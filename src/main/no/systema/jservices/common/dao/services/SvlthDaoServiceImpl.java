package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.NonNull;
import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
import no.systema.jservices.common.values.EventTypeEnum;

public class SvlthDaoServiceImpl extends GenericDaoServiceImpl<SvlthDao> implements SvlthDaoService{

	private Comparator<SvlthDao> timestampComparator = Comparator.comparing(SvlthDao::getSvlth_id1 )
														 .thenComparing(SvlthDao::getSvlth_im1); 
	
	@Autowired
	SvltfDaoService svltfDaoService; 
	
	@Override
	public boolean exist(EventTypeEnum typeEnum, String godsnummer, String position) {
		boolean exist = false;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", typeEnum.getValue());
		params.put("svlth_ign", godsnummer);
		params.put("svlth_pos", position);
		int count  = countAll(params);
		
		if (count == 1) {
			exist = true;
		} else if (count == 0){
			exist = false;
			
		} else {
			String errMsg = "Found invalid count:"+count+" in SVLTH on param:"+params;
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
			
		}
		
		return exist;
	}		
	
	
	@Override
	public boolean existMrn(EventTypeEnum typeEnum, String mrn) {
		boolean exist = false;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", typeEnum.getValue());
		params.put("svlth_irn", mrn);
		int count  = countAll(params);
		
		if (count == 1) {
			exist = true;
		} else if (count == 0){
			exist = false;
			
		} else {
			String errMsg = "Found invalid count:"+count+" in SVLTH on param:"+params;
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
			
		}
		
		return exist;
			
	}
	
	@Override
	public List<SvlthDto> getAll(String svlth_h, String svlth_igl, String svlth_ign,String svlth_pos, String svlth_irn,  Integer svlth_id2F,Integer svlth_id2T, Integer svlth_id1, Integer svlth_im1, String svlth_rty) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SvlthDao> daoList;
		List<SvlthDto> dtoList = new ArrayList<SvlthDto>();
		
		if (svlth_h != null) {
			params.put("svlth_h", svlth_h);
		}
		if (svlth_igl != null) {
			params.put("svlth_igl", svlth_igl);
		}
		if (svlth_ign != null) {
			params.put("svlth_ign", svlth_ign);
		}
		if (svlth_pos != null) {
			params.put("svlth_pos", svlth_pos);
		}
		if (svlth_irn != null) {
			params.put("svlth_irn", svlth_irn);
		}
		if (svlth_id2F != null) {
			params.put("svlth_id2" + GREATER_AND_EQUALS_THEN, svlth_id2F);
		}
		if (svlth_id2T != null) {
			params.put("svlth_id2" + LESS_AND_EQUALS_THEN, svlth_id2T);
		}

		if (svlth_id1 != null) {
			params.put("svlth_id1" , svlth_id1);
			params.put("svlth_im1" , svlth_im1);

		}	
		if (svlth_rty != null) {
			params.put("svlth_rty", svlth_rty);
		}		
		
		daoList = findAll(params);
		
		daoList.forEach(dao -> {
			SvlthDto dto = SvlthDto.get(dao);
			if (dto.getSvlth_h().equals(EventTypeEnum.INLAGG.getValue())) {
				dto.setSaldo(calculateSaldo(dto.getSvlth_ign(),dto.getSvlth_pos()));
			}
			dtoList.add(dto);
		});
		
		return dtoList;

	}	

	@Override
	public boolean validUttagQuantity(Integer uttagAntal, String svlth_ign, String svlth_pos) {
		return uttagAntal <= calculateSaldo(svlth_ign, svlth_pos);
	}	
	
	private Integer calculateSaldo(String svlth_ign, String svlth_pos) {
		Integer inlaggAntal = getInlaggAntal(svlth_ign, svlth_pos);
//		logger.info("inlaggAntal="+inlaggAntal);
		
		Integer uttagAntal = getUttagAntal(svlth_ign, svlth_pos);
//		logger.info("uttagAntal="+uttagAntal);
		
		return inlaggAntal - uttagAntal;
		
	}	
	
	private Integer getInlaggAntal(String svlth_ign,String svlth_pos) {
		List<SvlthDao> inlaggList = getAll(EventTypeEnum.INLAGG.getValue(),svlth_ign, svlth_pos);
		if (inlaggList.isEmpty()) {
			return 0;
		}
		SvlthDao inlagg = inlaggList.get(0);
		
		List<SvlthDao> inlaggRattelseList = getInlaggRattelseAntal(inlagg.getSvlth_ign(),inlagg.getSvlth_pos());
		if (inlaggRattelseList.isEmpty()) {
			return inlagg.getSvlth_int();
		}
		
		SvlthDao latestInlaggDto = inlaggRattelseList.stream()
                .max( timestampComparator )
                .get();		
		
		return latestInlaggDto.getSvlth_rnt();
		
	}	

	private Integer getUttagAntal(String svlth_ign,String svlth_pos) {	
		List<SvlthDao> uttagList = getAll(EventTypeEnum.UTTAG.getValue(),svlth_ign, svlth_pos);
		Integer uttagAntal = 0;
		Integer sumUttagAntal = 0;
		
		for (SvlthDao uttagDao : uttagList) {
			SvlthDao uttagRattelseDao = getLatestUttagRattelse(uttagDao.getSvlth_ign(),uttagDao.getSvlth_pos(), uttagDao.getSvlth_ud1(), uttagDao.getSvlth_um1());
			if (uttagRattelseDao != null) {
				uttagAntal = uttagRattelseDao.getSvlth_rnt(); 
			} else {
				uttagAntal = uttagDao.getSvlth_unt(); 
			}

			sumUttagAntal += uttagAntal;
			
		}
		
		return sumUttagAntal;
	}
	
	private List<SvlthDao> getAll(@NonNull String svlth_h, @NonNull String svlth_ign,  @NonNull String svlth_pos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", svlth_h);
		params.put("svlth_ign", svlth_ign);
		params.put("svlth_pos", svlth_pos);

		return findAll(params);

	}	
	
	private List<SvlthDao> getInlaggRattelseAntal(@NonNull String svlth_ign, @NonNull String svlth_pos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", EventTypeEnum.RATTELSE.getValue());
		params.put("svlth_ign", svlth_ign);
		params.put("svlth_pos", svlth_pos);
		params.put("svlth_rty", EventTypeEnum.INLAGG.getValue());
		params.put("svlth_rnt" + GREATER_THEN, 0);			
		
		return findAll(params);

	}		
	
	private SvlthDao getLatestUttagRattelse(@NonNull String svlth_ign, @NonNull String svlth_pos, @NonNull Integer svlth_ud1, @NonNull Integer svlth_um1) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", EventTypeEnum.RATTELSE.getValue());
		params.put("svlth_ign", svlth_ign);
		params.put("svlth_pos", svlth_pos);
		params.put("svlth_ud1", svlth_ud1);
		params.put("svlth_um1", svlth_um1);
		params.put("svlth_rty", EventTypeEnum.UTTAG.getValue());

		List<SvlthDao> list = findAll(params);
		if (list.isEmpty()) {
			return null;
		}

		SvlthDao latestUttagRattelseDao = list.stream().max(timestampComparator).get();

		return latestUttagRattelseDao;

	}
	
	@Override
	public SvlthDao update(SvlthDao t) {
		throw new IllegalAccessError("Update is not allowed!");
	}
	
	@Override
	public void delete(Object id) {
		throw new IllegalAccessError("Delete is not allowed!");
	}
	
	
	@Override
	public void deleteAll(Map<String, Object> params) {
		throw new IllegalAccessError("Delete is not allowed!");
	}
	
	
	@Override
	public SvlthDao find(Object id) {
		throw new IllegalAccessError("SVLTH do not have keys, hence find does not work!");
	}
	
	@Override
	public boolean exist(Object id) {
		throw new IllegalAccessError("SVLTH do not have keys, hence exist does not work!");
	}

	
}
