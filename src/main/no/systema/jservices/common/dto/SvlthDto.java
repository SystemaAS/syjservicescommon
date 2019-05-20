package no.systema.jservices.common.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import lombok.Data;
import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.util.DateTimeManager;

/**
 * This is the query Data Transfer Object between service and UI for Tillfällig lagring.
 * 
 * 
 * @author fredrikmoller
 * @date 2019-04-09
 */
@Data
public class SvlthDto  {

	private String svlth_h; 
	private BigDecimal svlth_ibr;
	private Integer svlth_id1;
	private Integer svlth_id2;
	private String svlth_iex; 
	private String svlth_igl;
	private String svlth_ign;
	private String svlth_pos;
	private String svlth_ih1;
	private String svlth_ih2;
	private String svlth_ih3;
	private String svlth_ih4;
	private String svlth_ih5;
	private Integer svlth_im1;
	private Integer svlth_int;
	private String svlth_irn;
	private String svlth_isl;
	private String svlth_itx;
	private String svlth_ivb;
	private String svlth_ivb2;
	private String svlth_ivb3;
	private String svlth_ivb4;
	private String svlth_ivb5;
	private String svlth_rnt;
	private String svlth_rtx;
	private String svlth_rty;
	private String svlth_ud1;
	private String svlth_uex;
	private Integer svlth_um1;
	private Integer svlth_unt;
	private String svlth_uti;
	private String svlth_utx;
	
	private Integer saldo;
	
	private String timestamp;
	
	
	public String getTimestamp(){
		return DateTimeManager.getDateTime(svlth_id1, svlth_im1);
	}

	public String getSvlth_rnt() {
		if ("0".equals(svlth_rnt)) {
			return null;	
		} else {
			return svlth_rnt;
		}
	}	
	
	/**
	 * 
	 * Convenience method for transforming Dao to Dto.
	 * 
	 * @param dao
	 * @return SvlthDto
	 */
	static public SvlthDto get(SvlthDao dao) {
		ModelMapper modelMapper = new ModelMapper();
		SvlthDto dto = modelMapper.map(dao, SvlthDto.class);	
		
		return dto;
		
	}		
	
	
	

}
