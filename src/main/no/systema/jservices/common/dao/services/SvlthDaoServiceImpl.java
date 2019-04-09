package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
	public List<SvlthDto> findAll(String svlth_h, String svlth_irn, Integer svlth_id2) {
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
			if (svlth_h != null && svlth_h.equals(EventTypeEnum.INLAGG.getValue())) {
				dto.setSaldo(calculateSaldo(dao.getSvlth_int(), svlth_irn, svlth_id2));
			}
			dtoList.add(dto);
		});
		
		return dtoList;

	}	

	@Override
	public Integer calculateSaldo(Integer inlaggAntal, String svlth_irn, Integer svlth_id2) {
		List<SvlthDto> uttagList = findAll(EventTypeEnum.UTTAG.getValue(), svlth_irn, svlth_id2);

		Function<SvlthDto, Integer> totalMapper = uttag -> uttag.getSvlth_unt();
		Integer uttagAntal = uttagList.stream()
		        .map(totalMapper)
		        .reduce(0, Integer::sum);		
		
		return inlaggAntal - uttagAntal;
		
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
