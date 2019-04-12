package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * For Tillfälligt lager.
 * 
 * Note: No keys. 
 * 
 * Conversion of svlth_ibr is done explicit in setSvlth_ibr. E.g 23,4 -> 23.4
 * 
 * 
 * @author fredrikmoller
 * @date 2019-04-01
 */
@Data
public class SvlthDao implements IDao {

	private String svlth_h; 
	@Setter(AccessLevel.NONE) private BigDecimal svlth_ibr;
	private Integer svlth_id1;
	private Integer svlth_id2;
	private String svlth_iex; 
	private String svlth_igl;
	private String svlth_ign;
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
	private Integer svlth_rnt;
	private String svlth_rtx;
	private String svlth_rty;
	private Integer svlth_ud1;
	private String svlth_uex;
	private Integer svlth_um1;
	private Integer svlth_unt;
	private String svlth_uti;
	private String svlth_utx;
	
	private Map<String, Object> keys = null;

	public void setSvlth_ibr(String svlth_ibr) {
		this.svlth_ibr = new BigDecimal(svlth_ibr.replace(",", "."));
	}
	
	@Override
	@JsonIgnore
	public Map<String, Object> getKeys() {
		return keys;
	}


}
