package no.systema.jservices.common.values;

import java.io.Serializable;

import no.systema.jservices.common.dao.ViscrossrDao;

/**
 *  Holding constants for codetypes for {@linkplain ViscrossrDao}. <br>
 *  
 *  Converting from SYSPED code into Visma.net code
 *  
 *  Enum can be maximum 5 char.
 * 
 * @author fredrikmoller
 * @date 2018-08-08
 *
 */
public enum ViscrossrKoder implements Serializable{

	/**
	 * Moms salg Norsk
	 */
	MS_NO,

	/**
	 * Moms , salg IKKE Norsk
	 */	
	MS,

	/**
	 * Moms , kjop Norsk
	 */
	MK_NO,

	/**
	 * Moms , kjop IKKE Norsk
	 */	
	MK;
	
}
