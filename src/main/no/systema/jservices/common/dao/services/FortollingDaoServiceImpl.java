package no.systema.jservices.common.dao.services;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	@Override
	public List<FortollingDto> getStats(FortollingDto qDto) {  
		return getImportStatsNew(qDto);
	
	}

	private List<FortollingDto> getImportStatsNew(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		StringBuilder queryString = new StringBuilder();
		queryString.append( "SELECT  siavd avdeling,  sitdn deklarasjonsnr, sidt registreringsdato, sisg signatur,  siknk mottaker, sikns avsender, wvpreg reg_vareposter,  wvpoff off_vareposter, ");
		queryString.append("  		wie type,  wmerk edim,  sidtg deklarasjonsdato, wsvexr03 inputtype, wextref extern_referanse, wantdag antall_dager, silka avsender_land, ");
		queryString.append("  		wai, waii, waiii, waiv, wav, wavi, wavii, waviii, waix, wax, waxi, ");
		queryString.append("  		waxii, waxiii, waxiv, waxv, waxvi, waxvii, waxviii, waxvix, waxx, waxxi ");
		queryString.append(" FROM SADHAN   ");	
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    AND  (siavd IN ( :avdelingList ) )");
		}		
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    AND  (sisg IN ( :signaturList )) ");
		}
		
		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	

/*	
	         SONET        5  0       5       157        Begge    ANT.AVS.I              
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.I                              
	        SONET        5  0       5       162        Begge    ANT.AVS.II             
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.II                             
	       SONET        5  0       5       167        Begge    ANT.AVS.III            
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.III                            
	        SONET        5  0       5       172        Begge    ANT.AVS.IV             
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.IV                             
	         SONET        5  0       5       177        Begge    ANT.AVS.V              
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.V                              
	        SONET        5  0       5       182        Begge    ANT.AVS.VI             
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.VI                             
	       SONET        5  0       5       187        Begge    ANT.AVS.VII            
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.VII                            
	      SONET        5  0       5       192        Begge    ANT.AVS.VIII           
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.VIII                           
	          SONET        5  0       5       197        Begge    ANT.AVS.IX       
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.IX                       
	         SONET        5  0       5       202        Begge    ANT.AVS.X        
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.X                        
	        SONET        5  0       5       207        Begge    ANT.AVS.XI       
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XI                       
	       SONET        5  0       5       212        Begge    ANT.AVS.XII      
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XII                      
	      SONET        5  0       5       217        Begge    ANT.AVS.XIII     
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XIII                     
	       SONET        5  0       5       222        Begge    ANT.AVS.XIV      
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XIV                      
	        SONET        5  0       5       227        Begge    ANT.AVS.XV       
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XV                       
	       SONET        5  0       5       232        Begge    ANT.AVS.XVI      
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XVI                      
	      SONET        5  0       5       237        Begge    ANT.AVS.XVII     
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XVII                     
	     SONET        5  0       5       242        Begge    ANT.AVS.XVIII    
	      SONET        5  0       5       247        Begge    ANT.AVS.XVIX            
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XVIX                            
	        SONET        5  0       5       252        Begge    ANT.AVS.XX              
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XX                              
	       SONET        5  0       5       257        Begge    ANT.AVS.XXI             
	   Felttekst . . . . . . . . . . . . . . . . :  ANT.AVS.XXI                             
*/	                                                                                        	 
	 
	   
	   
	   
	   
	
	
	
	
	
}