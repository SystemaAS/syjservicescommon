package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvltfDao;

public interface SvltfDaoService extends GenericDaoService<SvltfDao> {

	/**
	 * Increment svltf_num with 1 and but return current.
	 * 
	 * @param svlth_igl, actual godslokalkod.
	 * @return SvltfDao with existing svltf_num
	 */
	SvltfDao getExistingSvltf_numAndIncrement(String svlth_igl);
	
}
