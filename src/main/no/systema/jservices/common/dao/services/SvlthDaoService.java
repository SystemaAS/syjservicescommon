package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.values.EventTypeEnum;

public interface SvlthDaoService extends GenericDaoService<SvlthDao> {
	
	/**
	 * Exist controll. Typically used when EventTypeEnum is INLAGG
	 * 
	 * @param event svlth_h
	 * @param mrn svlth_irn
	 * @param arrivalDate svlth_id2
	 * @return
	 */
	boolean exist(EventTypeEnum typeEnum, String mrn, int arrivalDate);
	
}
