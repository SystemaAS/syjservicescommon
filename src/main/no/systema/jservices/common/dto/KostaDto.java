package no.systema.jservices.common.dto;

import lombok.Data;
import no.systema.jservices.common.dao.KostaDao;

/**
 * This is the query Data Transfer Object between service and UI for Kostnadsforing - Arbete med bilag.
 * 
 * @author Fredrik Möller
 * @date Okt 1, 2018
 *
 */
@Data
public class KostaDto extends KostaDao {
	
	private String kttyp;
	private String kbrekl; //Kun reklamsjon
	private String fskode; 
	private String fssok;
	private String opp_dato;
	private String reg_dato;
	private String levnavn;

	/**
	 * Convenience method for transforming Dao to Dto.
	 * 
	 * @param dao
	 * @return KostaDto
	 */
	static public KostaDto get(KostaDao dao) {
		KostaDto dto = new KostaDto();
		
		dto.setKabb(dao.getKabb());
		dto.setKabdt(dao.getKabdt());
		dto.setKabl(dao.getKabl());
		dto.setKabnr(dao.getKabnr());
		dto.setKabnr2(dao.getKabnr2());
		dto.setKadte(dao.getKadte());
		dto.setKadtr(dao.getKadtr());
		dto.setKafdt(dao.getKafdt());
		dto.setKaffdt(dao.getKaffdt());
		dto.setKafnr(dao.getKafnr());
		dto.setKalkid(dao.getKalkid());
		dto.setKalnr(dao.getKalnr());
		dto.setKapmn(dao.getKapmn());
		dto.setKAPÅR(dao.getKAPÅR());
		dto.setKasg(dao.getKasg());
		dto.setKast(dao.getKast());
		dto.setKatdr(dao.getKatdr());
		dto.setKatme(dao.getKatme());
		dto.setKatxt(dao.getKatxt());
		dto.setKauser(dao.getKauser());
		
		return dto;
		
		
	}
}
