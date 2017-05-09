package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SyparfDao;

public class Syparf2DaoServiceImpl extends GenericDaoServiceImpl<SyparfDao> implements Syparf2DaoService{

	@Override
	public List<SyparfDao> findAll(String syuser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("syuser", syuser);
		return findAll(params);
	}
	
	@Override
	public void deleteAll(String syuser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("syuser", syuser);
		deleteAll(params);
	}	
	
	@Override
	public SyparfDao find(String syuser, String syrecn) {
		SyparfDao qDao = new SyparfDao();
		qDao.setSyuser(syuser);
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
