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
	 * If svlth_h is {@linkplain EventTypeEnum}.INLAGG saldo is calculated.
	 * 
	 * @param svlth_h, type
	 * @param svlth_ign godsnummer
	 * @param svlth_irn mrn
	 * @param svlth_id2 arrival
	 * @return a List of {@linkplain SvlthDto}
	 */
	List<SvlthDto> getAll(String svlth_h, String svlth_ign, String svlth_irn , Integer svlth_id2);
	
	
	/**
	 * Calculate remaining saldo of INLAGG minus UTAGG
	 * 
	 * @param svlth_irn
	 * @param svlth_id2
	 * @return current saldo
	 */
	Integer calculateSaldo(String svlth_irn, Integer svlth_id2 );

	/**
	 * Is uttag quantity valid.
	 * 
	 * 
	 * @param svlth_unt
	 * @param svlth_irn
	 * @param svlth_id2
	 */
	boolean validUttagQuantity(Integer uttagAntal, String svlth_irn, Integer svlth_id2);
	
	
}
