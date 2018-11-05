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

	
}
