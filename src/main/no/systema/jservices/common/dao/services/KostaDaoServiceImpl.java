package no.systema.jservices.common.dao.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dto.KostaDto;

public class KostaDaoServiceImpl extends GenericDaoServiceImpl<KostaDao> implements KostaDaoService{

	@Override
	public List<KostaDao> findAll(Integer bilagsnr, Integer innregnr, String faktnr, Integer levnr, String attkode,
			String komment, Integer fradato, Integer fraperaar, Integer frapermnd, String status) {

		Map<String, Object> params = new HashMap<String, Object>();
		if (innregnr != null) {
			params.put("kabnr", innregnr);
		}
		if (bilagsnr != null) {
			params.put("kabnr2", bilagsnr);
		}
		if (faktnr != null) {
			params.put("kafnr", faktnr);
		}
		if (levnr != null) {
			params.put("kalnr", levnr);
		}
		if (attkode != null) {
			params.put("kasg", attkode);
		}
		if (komment != null) {
			params.put("katxt", komment);
		}
		if (fradato != null) {
			params.put("kabdt" + GREATER_AND_EQUALS_THEN, fradato);
		}
		//TODO grupper år och mån i sökning
		if (fraperaar != null) {
			params.put("KAPÅR" + GREATER_AND_EQUALS_THEN, fraperaar);
		}
		if (frapermnd != null) {
			params.put("kapmn" + GREATER_AND_EQUALS_THEN, frapermnd);
		}
		if (status != null) {
			params.put("kast", status);
		}
		
		
		return findAll(params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KostaDao> findAllComplex(KostaDao qDto, String reklamasjon, String fskode, String fssok) {
			logger.info("KostaDto="+ReflectionToStringBuilder.toString(qDto));
			boolean hasWhere = false;
			StringBuilder queryString = new StringBuilder(" select distinct ka.* from kosta ka");
			if (reklamasjon != null) {
				queryString.append(" left join kostb kb on ka.kabnr = kb.kbbnr ");
			}
			if (fskode != null || fssok != null) {
				queryString.append(" left join friskk fs on ka.kabnr = fs.fsbnr ");
			}
			if (qDto.getKabnr() != null) {
				queryString.append(" where ");
				hasWhere = true;
//				queryString.append(" ka.kabnr = ").append(qDto.getKabnr());
				queryString.append(" LOWER(ka.kabnr) LIKE ").append("LOWER(\'"+WILD_CARD+qDto.getKabnr()+WILD_CARD+"\')");
				
			}
			if (qDto.getKabnr2() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
//				queryString.append(" ka.kabnr2 = ").append(qDto.getKabnr2());
				queryString.append(" LOWER(ka.kabnr2) LIKE ").append("LOWER(\'"+WILD_CARD+qDto.getKabnr2()+WILD_CARD+"\')");
			}
			if (qDto.getKalnr() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
//				queryString.append(" ka.kalnr = ").append(qDto.getKalnr());
				queryString.append(" LOWER(ka.kalnr) LIKE ").append("LOWER(\'"+WILD_CARD+qDto.getKalnr()+WILD_CARD+"\')");
			}
			if (qDto.getKabdt() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" ka.kabdt >= ").append(qDto.getKabdt());
			}			
			if (qDto.getKafnr() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
//				queryString.append(" ka.kafnr = ").append("\'"+qDto.getKafnr()+"\'");
				queryString.append(" LOWER(ka.kafnr) LIKE ").append("LOWER(\'"+WILD_CARD+qDto.getKafnr()+WILD_CARD+"\')");

			}			
			if (qDto.getKasg() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" ka.kasg = ").append("\'"+qDto.getKasg()+"\'");
			}			
			if (qDto.getKast() != null && !qDto.getKast().equals("*")) {  //* representing all, from JSP.
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" ka.kast = ").append("\'"+qDto.getKast()+"\'");
	
			} else if (qDto.getKast() == null ) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" NULLIF(ka.kast, '') IS NULL ");
			}
			if (qDto.getKatxt() != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
//				queryString.append(" ka.katxt = ").append("\'"+qDto.getKatxt()+"\'");
				queryString.append(" LOWER(ka.katxt) LIKE ").append("LOWER(\'"+WILD_CARD+qDto.getKatxt()+WILD_CARD+"\')");
			}			
			if (reklamasjon!= null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" kb.kbrekl = ").append("\'"+reklamasjon+"\'");
			}			
			if (fskode != null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
				queryString.append(" fs.fskode = ").append("\'"+fskode+"\'");
			}			
			if (fssok!= null) {
				if (hasWhere) {
					queryString.append(" and ");
				} else {
					queryString.append(" where ");
					hasWhere = true;
				}
//				queryString.append(" fs.fssok = ").append("\'"+qDto.getFssok()+"\'");
				queryString.append(" LOWER(fs.fssok) LIKE ").append("LOWER(\'"+WILD_CARD+fssok+WILD_CARD+"\')");

			}			

			logger.info("About to run queryString.toString()="+queryString.toString());

			return findAll(queryString.toString(), new GenericObjectMapper(new KostaDao()));
	
	
	}

	@Override
	public KostaDao create(KostaDao kostaDao, String kttyp) {
		int ktnr = kosttDaoService.getExistingKtnrAndIncrement(kttyp);
		kostaDao.setKabnr(ktnr);
	
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
		
		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(dateFormatter);
		String nowTime = now.format(timeFormatter);

		kostaDao.setKadtr(Integer.valueOf(nowDate));
		kostaDao.setKatdr(Integer.valueOf(nowTime));

		return super.create(kostaDao);
	}	

	@Override
	public KostaDao create(KostaDao dao) {
		throw new UnsupportedOperationException("::generic create is invalid. Use create(KostaDao dao, String kttyp).");
	}	
	

	private KosttDaoService kosttDaoService = null;                                                            
	public void setKosttDaoService( KosttDaoService kosttDaoService) {this.kosttDaoService = kosttDaoService;}          
	public KosttDaoService getKosttDaoService() {return this.kosttDaoService;}	
	
	
}
