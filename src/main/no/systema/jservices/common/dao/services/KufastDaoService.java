package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KufastDao;
import no.systema.jservices.common.values.FasteKoder;

public interface KufastDaoService extends GenericDaoService<KufastDao> {
	
	/**
	 * Get unique Kufast
	 * 
	 * @param kftyp enum of types {@link FasteKoder}.
	 * @param kfkod
	 * @return a {@link KufastDao}, i found, else null
	 */
	public KufastDao find(FasteKoder  kftyp, String kfkod);	
	
	/**
	 * Get list Kufast typed with kftyp
	 * 
	 * @param kftyp enum of types {@link FasteKoder}.
	 * @return a list of {@link KufastDao}
	 */
	public List<KufastDao> getList(FasteKoder  kftyp);		
	
}
