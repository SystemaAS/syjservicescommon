package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SvltuDao;
import no.systema.jservices.common.values.EventTypeEnum;

public interface SvltuDaoService extends GenericDaoService<SvltuDao> {
	
	/**
	 * Find all utgående handlingar for INLAGG.
	 * 
	 * @param svltu_igl
	 * @param svltu_ign
	 * @param svltu_pos
	 * @return List of utgående handlingar
	 */
	List<SvltuDao> findAll(String svltu_igl, String svltu_ign, String svltu_pos);
	
}
