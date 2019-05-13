package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
import no.systema.jservices.common.values.EventTypeEnum;

public interface SvlthDaoService extends GenericDaoService<SvlthDao> {
	
	/**
	 * Exist controll on godsnummer. Typically used when EventTypeEnum is INLAGG
	 * 
	 * @param event svlth_h
	 * @param mrn svlth_igl
	 * @return
	 */
	boolean exist(EventTypeEnum typeEnum, String godsnummer);
	
	/**
	 * Exist controll on mrn. Typically used when EventTypeEnum is INLAGG
	 * 
	 * @param event svlth_h
	 * @param mrn svlth_irn
	 * @return
	 */
	boolean existMrn(EventTypeEnum typeEnum, String mrn);
	
	
	 /**
	 * Find all {@linkplain SvltDto} on provided search-criteria. <br>
	 * param can be null.
	 * 
	 * If svlth_h is {@linkplain EventTypeEnum}.INLAGG saldo is calculated.
	 * 
	 * @param svlth_h, type
	 * @param svlth_igl, godslokalkod
	 * @param svlth_ign godsnummer
	 * @param svlth_irn mrn
	 * @param svlth_id2F from ankomstdate
	 * @param svlth_id2T to ankomstdate
	 * @param svlth_id1 arkiveringsdate
	 * @param svlth_im1 arkiveringstime
	 * @param svlth_rty rattningstyp, I el. U
	 * @return a List of {@linkplain SvlthDto}
	 */
	List<SvlthDto> getAll(String svlth_h, String svlth_igl, String svlth_ign, String svlth_irn , Integer svlth_id2F,Integer svlth_id2T, Integer svlth_id1,  Integer svlth_im1, String svlth_rty );
	
	/**
	 * Is uttag quantity valid.
	 * 
	 * 
	 * @param svlth_unt
	 * @param svlth_ign
	 */
	boolean validUttagQuantity(Integer uttagAntal, String svlth_ign);
	
	
}
