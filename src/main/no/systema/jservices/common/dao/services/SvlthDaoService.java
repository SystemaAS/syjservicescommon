package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
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
	
	
	 /**
	 * Find all {@linkplain SvltDto} on provided search-criteria. <br>
	 * param can be null.
	 * 
	 * @param svlth_h
	 * @param svlth_irn
	 * @param svlth_id2
	 * @return a List of {@linkplain SvlthDto}
	 */
	List<SvlthDto> findAll(String svlth_h, String svlth_irn, Integer svlth_id2);
	
	
	/**
	 * Calculate remaining saldo of INLAGG minus UTAGG
	 * 
	 * @param inlaggAntal
	 * @param svlth_irn
	 * @param svlth_id2
	 * @return current saldo
	 */
	Integer calculateSaldo(Integer inlaggAntal, String svlth_irn, Integer svlth_id2 );
	
	
}
