package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvltfDao;

public interface SvltfDaoService extends GenericDaoService<SvltfDao> {

	/**
	 * 
	 * Increment svltf_num with 1 and but use current.
	 * 
	 * year and leftpadding num with 0000. <br>
	 * <b>Note: godlokalkod is not added handled here.</b>
	 * 
	 * @param godsLokalkod
	 * @return  godnummer, e.g. 19-0001
	 */
	String getGenerateGodsnummer(String godsLokalkod);
	
}
