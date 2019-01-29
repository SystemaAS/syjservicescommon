package no.systema.jservices.common.dto;

import org.modelmapper.ModelMapper;

import lombok.Data;
import no.systema.jservices.common.dao.KostbDao;

/**
 * This is the query Data Transfer Object between service and UI for Kostnadsforing - Fordel kostnader.
 * 
 * @author Fredrik Möller
 * @date Jan 28, 2019
 *
 */
@Data
public class KostbDto  {

	private String kbavd;
	private String kbbilt;
	private String kbblf;
	private String kbblhb;
	private String kbbnr; 
	private String kbbuds;
	private String kbbval;
	private String kbfree;
	private String kbgeby;
	private String kbgod;
	private String kbkavd;  
	private String kbkdm;
	private String kbkdmv;
	private String kbkdpf;
	private String kbkkey;
	private String kbkn;
	private String KBNØKK;
	private String kbopd; 
	private String KBPÅR; 
	private String kbpcc;
	private String kbpmn;
	private String kbrefa;
	private String kbrefb;
	private String kbrefc;
	private String kbrekl;
	private String kbsg;
	private String kbsgg;
	private String kbvk;

	//non-dao
	private String ot;
	private String fra;
	private String sk;
	private String val;
	private String vkt1;
	private String vkt2;
	private String ant;
	private String budsjett;
	private String diff;
	private String gren;
	
	/**
	 * 
	 * Convenience method for transforming Dao to Dto.
	 * 
	 * @param dao
	 * @return KostbDto
	 */
	static public KostbDto get(KostbDao dao) {
		ModelMapper modelMapper = new ModelMapper();
		KostbDto dto = modelMapper.map(dao, KostbDto.class);	
		
		return dto;
		
	}	

}
