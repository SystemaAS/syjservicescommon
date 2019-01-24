package no.systema.jservices.common.dto;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;

import lombok.Data;
import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.util.DateTimeManager;

/**
 * This is the query Data Transfer Object between service and UI for Kostnadsforing - Arbete med bilag.
 * 
 * @author Fredrik Möller
 * @date Okt 1, 2018
 *
 */
@Data
public class KostaDto  {
	
	private static Logger logger = Logger.getLogger(KostaDto.class.getName());
	
	private String kabb;
	private String kabdt;
	private String kabl;
	private String kablm ;
	private String kabnr; 
	private String kabnr2;  
	private String kadte;
	private String kadtr;
	private String kafdt;
	private BigDecimal kaffdt;
	private String kafnr;
	private String kajour;
	private String kalkid;
	private String kalnr;
	private String kamva;
	private String kaoavd;
	private String kaomrf;
	private String kaopd;
	private Integer KAPÅR;
	private Integer kapcc;
	private Integer kapmn;
	private String karnr;
	private String kasg;
	private String kast;
	private String katavd;
	private String katdr;
	private String katme ;
	private String katunr;
	private String katxt;
	private String kauser;
	private String kaval;
	private String kavk;
	private String kavku;

	//non-dao
	private String kttyp;
	private String fskode; 
	private String fssok;
	private String opp_dato;
	private String reg_dato;
	private String levnavn;

	/**
	 * 
	 * Convenience method for transforming Dao to Dto.
	 * 
	 * @param dao
	 * @return KostaDto
	 */
	static public KostaDto get(KostaDao dao) {
		ModelMapper modelMapper = new ModelMapper();
		KostaDto dto = modelMapper.map(dao, KostaDto.class);	
		
		dto.setOpp_dato(DateTimeManager.getDateTime(dao.getKadte(), dao.getKatme()));
		dto.setReg_dato(DateTimeManager.getDateTime(dao.getKadtr().intValue(), dao.getKatdr().intValue()));
		
		return dto;
		
	}
}
