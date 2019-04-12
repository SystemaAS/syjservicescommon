package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
import no.systema.jservices.common.values.EventTypeEnum;

public class SvlthDaoServiceImpl extends GenericDaoServiceImpl<SvlthDao> implements SvlthDaoService{

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
	public List<SvlthDto> getAll(String svlth_h, String svlth_irn, Integer svlth_id2) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SvlthDao> daoList;
		List<SvlthDto> dtoList = new ArrayList<SvlthDto>();
		
		if (svlth_h != null) {
			params.put("svlth_h", svlth_h);
		}
		if (svlth_irn != null) {
			params.put("svlth_irn", svlth_irn);
		}
		if (svlth_id2 != null) {
			params.put("svlth_id2", svlth_id2);
		}
		
		daoList = findAll(params);
		
		daoList.forEach(dao -> {
			SvlthDto dto = SvlthDto.get(dao);
			
			if (dto.getSvlth_h().equals(EventTypeEnum.INLAGG.getValue())) {
				dto.setSaldo(calculateSaldo(dto.getSvlth_int(), dto.getSvlth_irn(), dto.getSvlth_id2()));
			}
			
			dtoList.add(dto);
		});
		
		return dtoList;

	}	

	@Override
	public Integer calculateSaldo(String svlth_irn, Integer svlth_id2) {
		Integer inlaggAntal = getInlaggAntal(svlth_irn, svlth_id2);
		Integer currentUttagAntal = getCurrentUttagAntal(svlth_irn, svlth_id2);
		return inlaggAntal - currentUttagAntal;
	}	
	
	@Override
	public boolean validUttagQuantity(Integer uttagAntal, String svlth_irn, Integer svlth_id2) {
		Integer currentUttagAntal = getCurrentUttagAntal(svlth_irn, svlth_id2);
		Integer inlaggAntal = getInlaggAntal(svlth_irn, svlth_id2);
		Integer toDoTotalUttagAntal = currentUttagAntal + uttagAntal;
		
		return inlaggAntal - toDoTotalUttagAntal >= 0;
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

	private Integer calculateSaldo(Integer inlaggAntal, String svlth_irn, Integer svlth_id2) {
		Integer currentUttagAntal = getCurrentUttagAntal(svlth_irn, svlth_id2);
		return inlaggAntal - currentUttagAntal;
	}		
	
	
	private Integer getCurrentUttagAntal(String svlth_irn, Integer svlth_id2) {
		List<SvlthDto> uttagList = getAll(EventTypeEnum.UTTAG.getValue(), svlth_irn, svlth_id2);
		Function<SvlthDto, Integer> totalMapper = uttag -> uttag.getSvlth_unt();
		Integer currentUttagAntal = uttagList.stream()
		        .map(totalMapper)
		        .reduce(0, Integer::sum);		

		return currentUttagAntal;
	}
	
	private Integer getInlaggAntal(String svlth_irn, Integer svlth_id2) {
		List<SvlthDto> uttagList = getAll(EventTypeEnum.INLAGG.getValue(), svlth_irn, svlth_id2);
		return uttagList.get(0).getSvlth_int();
	}
	

}
