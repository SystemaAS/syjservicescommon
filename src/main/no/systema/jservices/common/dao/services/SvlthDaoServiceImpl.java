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

	Comparator<SvlthDao> comparator = Comparator.comparing(SvlthDao::getSvlth_id1 )
			.thenComparing(SvlthDao::getSvlth_im1); 
	
	
	@Override
	public boolean exist(EventTypeEnum typeEnum, String mrn, int arrivalDate) {
		boolean exist = false;
		params.put("svlth_h", typeEnum.getValue());
		params.put("svlth_irn", mrn);
		params.put("svlth_id2", arrivalDate);
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
	public List<SvlthDto> getAll(String svlth_h, String svlth_ign, String svlth_irn,  Integer svlth_id2, Integer svlth_id1, Integer svlth_im1, String svlth_rty) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SvlthDao> daoList;
		List<SvlthDto> dtoList = new ArrayList<SvlthDto>();
		
		if (svlth_h != null) {
			params.put("svlth_h", svlth_h);
		}
		if (svlth_ign != null) {
			params.put("svlth_ign", svlth_ign);
		}
		if (svlth_irn != null) {
			params.put("svlth_irn", svlth_irn);
		}
		if (svlth_id2 != null) {
			params.put("svlth_id2" + GREATER_AND_EQUALS_THEN, svlth_id2);
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
				dto.setSaldo(calculateSaldo(dto.getSvlth_irn()));
			}
			dtoList.add(dto);
		});
		
		return dtoList;

	}	

	@Override
	public Integer calculateSaldo(String svlth_irn, Integer svlth_id2) {
		return calculateSaldo(svlth_irn);
	}	
	
	@Override
	public boolean validUttagQuantity(Integer uttagAntal, String svlth_irn) {
		Integer currentUttagAntal = getRattelseUttagAntal(svlth_irn);
		if (currentUttagAntal == 0) {
			currentUttagAntal = getUttagAntal(svlth_irn);
		}
		
		Integer inlaggAntal = getRattelseInlaggAntal(svlth_irn);
		if (inlaggAntal == 0) {
			inlaggAntal = getInlaggAntal(svlth_irn);
		}
		
		Integer toDoTotalUttagAntal = currentUttagAntal + uttagAntal;
		
		return inlaggAntal - toDoTotalUttagAntal >= 0;
	}	
	
	private Integer calculateSaldo(String svlth_irn) {
		Integer inlaggAntal = getRattelseInlaggAntal(svlth_irn);
		if (inlaggAntal == 0) {
			inlaggAntal = getInlaggAntal(svlth_irn);
		}
		Integer uttagAntal = getUttagAntal(svlth_irn);
		Integer rattelseUttagAntal = getRattelseUttagAntal(svlth_irn);
		Integer justeratUttagAntal = uttagAntal - rattelseUttagAntal;
		
		return inlaggAntal - justeratUttagAntal;
		
	}
	
	private Integer getUttagAntal(String svlth_irn) {
		List<SvlthDao> uttagList = getAll(EventTypeEnum.UTTAG.getValue(), svlth_irn);
		Function<SvlthDao, Integer> totalMapper = uttag -> uttag.getSvlth_unt();
		Integer currentUttagAntal = uttagList.stream()
		        .map(totalMapper)
		        .reduce(0, Integer::sum);		

		return currentUttagAntal;
	}
	
	private Integer getInlaggAntal(String svlth_irn) {
		List<SvlthDao> uttagList = getAll(EventTypeEnum.INLAGG.getValue(),svlth_irn);

		return uttagList.get(0).getSvlth_int();
	}
	
	private Integer getRattelseInlaggAntal(String svlth_irn) {
		List<SvlthDao> inlaggList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_irn, EventTypeEnum.INLAGG.getValue());
		if (inlaggList.isEmpty()) {
			return 0;
		}
		
		SvlthDao maxRattelseUttagDto = inlaggList.stream()
                .max( comparator )
                .get();	

		return maxRattelseUttagDto.getSvlth_rnt();
	}
	
	private Integer getRattelseUttagAntal(String svlth_irn) {
		List<SvlthDao> uttagList = getAll(EventTypeEnum.RATTELSE.getValue(), svlth_irn, EventTypeEnum.UTTAG.getValue());
		if (uttagList.isEmpty()) {
			return 0;
		}
		
		SvlthDao maxRattelseUttagDto = uttagList.stream()
                .max( comparator )
                .get();	

		return maxRattelseUttagDto.getSvlth_rnt();
		
	}	
	
	private List<SvlthDao> getAll(@NonNull String svlth_h, @NonNull String svlth_irn) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svlth_h", svlth_h);
		params.put("svlth_irn", svlth_irn);

		return findAll(params);

	}	
	
	private List<SvlthDao> getAll(@NonNull String svlth_h,  @NonNull String svlth_irn, @NonNull String svlth_rty) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (svlth_h != null) {
			params.put("svlth_h", svlth_h);
		}
		if (svlth_irn != null) {
			params.put("svlth_irn", svlth_irn);
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
