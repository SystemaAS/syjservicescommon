package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import lombok.NonNull;
import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
import no.systema.jservices.common.values.EventTypeEnum;

public class SvlthDaoServiceImpl extends GenericDaoServiceImpl<SvlthDao> implements SvlthDaoService{

	Comparator<SvlthDao> timestampComparator = Comparator.comparing(SvlthDao::getSvlth_id1 )
														 .thenComparing(SvlthDao::getSvlth_im1); 
	
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
		Integer inlaggAntal = getLatestRattelseInlaggAntal(svlth_ign,svlth_pos);
		if (inlaggAntal == 0) {
			inlaggAntal = getInlaggAntal(svlth_ign,svlth_pos);
		}
//		logger.info("inlaggAntal="+inlaggAntal);
		
		Integer latestRattelseUttagAntal = getLatestRattelseUttagAntal(svlth_ign,svlth_pos);
//		logger.info("latestRattelseUttagAntal="+latestRattelseUttagAntal);

		Integer uttagAntal = getUttagAntal(svlth_ign,svlth_pos);
//		logger.info("uttagAntal="+uttagAntal);
		
		Integer justeratUttagAntal = latestRattelseUttagAntal + uttagAntal;
//		logger.info("justeratUttagAntal="+justeratUttagAntal);

		
		return inlaggAntal - justeratUttagAntal;
		
	}
	
	private Integer getInlaggAntal(String svlth_ign,String svlth_pos) {
		List<SvlthDao> inlaggList = getAll(EventTypeEnum.INLAGG.getValue(),svlth_ign, svlth_pos);
		SvlthDao latestInlaggDto = inlaggList.stream()
                .max( timestampComparator )
                .get();			
		
		List<SvlthDao> rattelseInlaggList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_ign,svlth_pos, EventTypeEnum.INLAGG.getValue());
		if (rattelseInlaggList.isEmpty()) {
			return latestInlaggDto.getSvlth_int();
		}

		SvlthDao latestRattelseInlaggDto = rattelseInlaggList.stream()
                .max( timestampComparator )
                .get();		
		
		if (latestRattelseInlaggDto.getSvlth_id1() > latestInlaggDto.getSvlth_id1()) {
			return latestRattelseInlaggDto.getSvlth_rnt();
		} else {
			return latestInlaggDto.getSvlth_int();
		}
		
	}
	
	private Integer getUttagAntal(String svlth_ign,String svlth_pos) {
		Integer qId1;
		Integer qIm1;
		
		List<SvlthDao> rattelseUttagList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_ign,svlth_pos, EventTypeEnum.UTTAG.getValue());
		if (rattelseUttagList.isEmpty()) {
			qId1 = null;
			qIm1 = null;
		} else {
			SvlthDao lastestRattelseUttagDto = rattelseUttagList.stream()
	                .max( timestampComparator )
	                .get();		
			
			qId1 = lastestRattelseUttagDto.getSvlth_id1();
			qIm1 = lastestRattelseUttagDto.getSvlth_im1();
			
		}
		
		List<SvlthDao> uttagAfterlastestRattelseList = getAll(EventTypeEnum.UTTAG.getValue(), svlth_ign,svlth_pos, qId1,  qIm1);
		Function<SvlthDao, Integer> totalMapper = uttag -> uttag.getSvlth_unt();
		Integer uttagAntal = uttagAfterlastestRattelseList.stream()
		        .map(totalMapper)
		        .reduce(0, Integer::sum);	
		
		return uttagAntal;
		
	}	
	
	private Integer getLatestRattelseInlaggAntal(String svlth_ign, String svlth_pos) {
		List<SvlthDao> inlaggList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_ign,svlth_pos, EventTypeEnum.INLAGG.getValue());
		if (inlaggList.isEmpty()) {
			return 0;
		}
		
		SvlthDao maxRattelseUttagDto = inlaggList.stream()
                .max( timestampComparator )
                .get();	

		return maxRattelseUttagDto.getSvlth_rnt();
	}
	
	private Integer getLatestRattelseUttagAntal(String svlth_ign, String svlth_pos) {
		List<SvlthDao> uttagList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_ign,svlth_pos, EventTypeEnum.UTTAG.getValue());
		if (uttagList.isEmpty()) {
			return 0;
		}
		
		SvlthDao maxRattelseUttagDao = uttagList.stream()
                .max( timestampComparator )
                .get();	
		
		return maxRattelseUttagDao.getSvlth_rnt();
		
	}	
	
	private List<SvlthDao> getAll(@NonNull String svlth_h, @NonNull String svlth_ign,  @NonNull String svlth_pos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", svlth_h);
		params.put("svlth_ign", svlth_ign);
		params.put("svlth_pos", svlth_pos);

		return findAll(params);

	}	
	
	private List<SvlthDao> getAll(@NonNull String svlth_h, @NonNull String svlth_ign,@NonNull String svlth_pos, Integer svlth_id1, Integer svlth_im1) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", svlth_h);
		params.put("svlth_ign", svlth_ign);
		params.put("svlth_pos", svlth_pos);
		if (svlth_id1 != null) {
			params.put("svlth_id1" + GREATER_THEN, svlth_id1);
			params.put("svlth_im1" + GREATER_THEN, svlth_im1);			
		}

		return findAll(params);

	}	
	
	private List<SvlthDao> getAll(@NonNull String svlth_h,  @NonNull String svlth_ign, @NonNull String svlth_pos, @NonNull String svlth_rty) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (svlth_h != null) {
			params.put("svlth_h", svlth_h);
		}
		if (svlth_ign != null) {
			params.put("svlth_ign", svlth_ign);
		}
		if (svlth_pos != null) {
			params.put("svlth_pos", svlth_pos);
		}
		if (svlth_rty != null) {
			params.put("svlth_rty", svlth_rty);
		}		
		
		return findAll(params);

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
