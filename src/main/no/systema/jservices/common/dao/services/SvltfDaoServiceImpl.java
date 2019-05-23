package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvltfDao;

public class SvltfDaoServiceImpl extends GenericDaoServiceImpl<SvltfDao> implements SvltfDaoService{
	
	@Override
	public SvltfDao getExistingSvltf_numAndIncrement(String svlth_igl) {
		int existingGodsnummer, scaffoldingGodsnummer;
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl(svlth_igl);
		SvltfDao dao = find(qDao);
		existingGodsnummer = dao.getSvltf_num();
		scaffoldingGodsnummer = existingGodsnummer;
		dao.setSvltf_num(++scaffoldingGodsnummer);

		update(dao);
		
		dao.setSvltf_num(existingGodsnummer);
		return dao;  //Note; NOT incremented num
		
	}
	
}
