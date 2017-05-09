package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Syparf2Dao;

public class Syparf2DaoServiceImpl extends GenericDaoServiceImpl<Syparf2Dao> implements Syparf2DaoService{

	@Override
	public List<Syparf2Dao> findAll(String syuser) {
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
	public Syparf2Dao find(String syuser, String syrecn) {
		Syparf2Dao qDao = new Syparf2Dao();
		qDao.setSyuser(syuser);
		qDao.setSyrecn(syrecn);
		return find(qDao);
	}
	
	@Override
	public Syparf2Dao create(Syparf2Dao dao) {
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
