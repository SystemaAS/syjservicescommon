package no.systema.jservices.common.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import lombok.Data;
import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dao.SvltuDao;
import no.systema.jservices.common.util.DateTimeManager;
import no.systema.jservices.common.util.StringUtils;

/**
 * This is the query Data Transfer Object between service and UI for Tillfällig lagring. <br>
 * Hence the minor changes in some get methods.
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
	private String svlth_int;
	private String svlth_irn;
	private String svlth_isl;
	private String svlth_itx;
	private String svlth_ivb;
	private String svlth_ivb2;
	private String svlth_ivb3;
	private String svlth_ivb4;
	private String svlth_ivb5;
	private String svlth_rnt;
	private String svlth_rntU;
	private BigDecimal svlth_rbr;
	private String svlth_rvb;
	private String svlth_rvb2;
	private String svlth_rvb3;
	private String svlth_rvb4;
	private String svlth_rvb5;
	private String svlth_rsl;
	private String svlth_rtx;
	private String svlth_rtxU;
	private String svlth_rty;
	private String svlth_rd2;
	private String svlth_rex;	
	private String svlth_rexU;	
	private String svlth_rh1;	
	private String svlth_rh2;	
	private String svlth_rh3;
	private String svlth_rh4;	
	private String svlth_rh5;
	private String svlth_rud1;
	private String svlth_rum1;	
	private String svlth_ruti;
	private String svlth_rrn;
	private Integer svlth_ud1;
	private String svlth_uex;
	private String svlth_uex2;
	private String svlth_uex3;
	private String svlth_uex4;
	private String svlth_uex5;
	private String svlth_uex6;
	private String svlth_uex7;
	private String svlth_uex8;
	private String svlth_uex9;
	private String svlth_uex10;
	private String svlth_uex11;
	
	private String svlth_uex_concat;

	private Integer svlth_um1;
	private Integer svlth_unt;
	private String svlth_uti;
	private String svlth_utx;
	private String svlth_ius;
	
	private Integer saldo;
	
	private String timestamp;
	
	
	public String getTimestamp(){
		if (svlth_id1 != null) {
			return DateTimeManager.getDateTimeSV(svlth_id1, svlth_im1);
		} else {
			return "";
		}
	}
	
	public String getSvlth_rnt() {
		if ("0".equals(svlth_rnt)) {
			return null;	
		} else {
			return svlth_rnt;
		}
	}	

	public void setSvlth_rbr(String svlth_rbr) {
		if (StringUtils.hasValue(svlth_rbr)) {
			this.svlth_rbr = new BigDecimal(svlth_rbr.replace(",", "."));
		}
	}	
	
	public BigDecimal getSvlth_rbr() {
		if (svlth_rbr != null && "0.000".equals(svlth_rbr.toString())) {
			return null;	
		} else {
			return svlth_rbr;
		}
	}		

	public BigDecimal getSvlth_ibr() {
		if (svlth_ibr != null && "0.000".equals(svlth_ibr.toString())) {
			return null;	
		} else {
			return svlth_ibr;
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
	
	/**
	 * 
	 * Convenience method for transforming Dto to Dao.
	 * 
	 * @param dao
	 * @return SvlthDao
	 */
	static public SvlthDao get(SvlthDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		SvlthDao dao = modelMapper.map(dto, SvlthDao.class);	
		
		return dao;
		
	}		

	/**
	 * 
	 * Convenience method for transforming values in SvlthDto to SvltuDao.
	 * 
	 * @param dto
	 * @return SvltuDao
	 */
	static public List<SvltuDao> transform(SvlthDto dto) {
		List<SvltuDao> list = new ArrayList<SvltuDao>();
		
		if (StringUtils.hasValue(dto.getSvlth_uex2())) {
			list.add(add(dto,dto.getSvlth_uex2() ));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex3())) {
			list.add(add(dto,dto.getSvlth_uex3()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex4())) {
			list.add(add(dto,dto.getSvlth_uex4()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex5())) {
			list.add(add(dto,dto.getSvlth_uex5()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex6())) {
			list.add(add(dto,dto.getSvlth_uex6()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex7())) {
			list.add(add(dto,dto.getSvlth_uex7()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex8())) {
			list.add(add(dto,dto.getSvlth_uex8()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex9())) {
			list.add(add(dto,dto.getSvlth_uex9()));
		}
		if (StringUtils.hasValue(dto.getSvlth_uex10())) {
			list.add(add(dto,dto.getSvlth_uex10()));
		}		
		if (StringUtils.hasValue(dto.getSvlth_uex11())) {
			list.add(add(dto,dto.getSvlth_uex11()));
		}			
		
		return list;
		
	}		
	
	private static SvltuDao add( SvlthDto dto, String uha) {
		SvltuDao dao = new SvltuDao();
		dao.setSvltu_igl(dto.getSvlth_igl());
		dao.setSvltu_ign(dto.getSvlth_ign());
		dao.setSvltu_pos(dto.getSvlth_pos());
		dao.setSvltu_uha(uha);

		
		return dao;
		
	}

}
