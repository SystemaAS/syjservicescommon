package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SyparfDao;

public class SyparfDaoServiceImpl extends GenericDaoServiceImpl<SyparfDao> implements SyparfDaoService{

	@Override
	public List<SyparfDao> findAll(String sykunr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sykunr", sykunr);
		return findAll(params);
	}
	
	@Override
	public void deleteAll(String sykunr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sykunr", sykunr);
		deleteAll(params);
	}	
	
	@Override
	public SyparfDao find(String sykunr, String syrecn) {
		SyparfDao qDao = new SyparfDao();
		qDao.setSykunr(sykunr);
		qDao.setSyrecn(syrecn);
		return find(qDao);
	}
	
	@Override
	public SyparfDao create(SyparfDao dao) {
		int geno = tellgeDaoService.getGenoAndIncrement("SYPAR");
		dao.setSyrecn(String.valueOf(geno)); 
		return super.create(dao);
	}
	
	@Override
	public void delete(Object id) {
		super.delete(id);
		tellgeDaoService.substractGeno("SYPAR");
	}
	
	private TellgeDaoService tellgeDaoService = null;                                                            
	public void setTellgeDaoService( TellgeDaoService tellgeDaoService) {this.tellgeDaoService = tellgeDaoService;}          
	public TellgeDaoService getTellgeDaoService() {return this.tellgeDaoService;}



}
