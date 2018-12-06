package no.systema.jservices.common.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

import no.systema.jservices.common.dao.IDao;

/**
 * * This is the Data Transfer Object between service and UI delivering data
 * into searchlist, due to big HeadfDao appr. 200 attributes.
 * 
 * @author Fredrik Möller
 * @date Aug 7, 2017
 *
 */
@Data
public class HeadfDto implements IDao {
	private int heavd;
	private int heopd;
	private int hedtop;
	private int hedtr;
	private String henas;
	private String henak;
	private int hent;
	private int hevkt;
	private BigDecimal hem3;
	private String helks;
	private String hepns;
	private String helkk;
	private String hepnk;
	private String hesg;
	private String heot;
	private String heur;
	private int hepro;
	private String hegn;
	private String hest;
	private String hepk3;
	private String hepk4;
	private String hepos1;
	private int hepos2;
	/* days to view in list */
	@ExludeMapping
	private int dftdg;

	
	@Override
	public Map<String, Object> getKeys() {
		// Only to be used in IDao context.
		return null;
	}

}
