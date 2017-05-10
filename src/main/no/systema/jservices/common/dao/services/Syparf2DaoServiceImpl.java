package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.IDao;
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
		return this.find(qDao);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public SyparfDao find(SyparfDao id) {
		//blank the sykunr from parent class
		id.setKeys(id.getSyuser());
		//start process
		//IDao dao = (IDao )id;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("syuser", id.getSyuser());
		params.put("syrecn", id.getSyrecn());
		params.put("sykunr", "0");
		
		List<SyparfDao> list =findAll( params) ;
		if (list.size() ==1) {
			return list.get(0);
		}
		return null;		
		
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
