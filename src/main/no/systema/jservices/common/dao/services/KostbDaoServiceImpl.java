package no.systema.jservices.common.dao.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import no.systema.jservices.common.dao.KostbDao;

public class KostbDaoServiceImpl extends GenericDaoServiceImpl<KostbDao> implements KostbDaoService{

	@Override
	public List<KostbDao> findByKbbnr(Integer kbbnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kbbnr", kbbnr);
		return findAllRRN(params);	
	}

	@Override
	public double getFordelt(Integer kbbnr) {
		List<KostbDao> daoList = findByKbbnr(kbbnr);
		
		Function<KostbDao, BigDecimal> totalMapper = kb -> kb.getKbblhb();
		BigDecimal result = daoList.stream()
		        .map(totalMapper)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return result.doubleValue();
	}

}
