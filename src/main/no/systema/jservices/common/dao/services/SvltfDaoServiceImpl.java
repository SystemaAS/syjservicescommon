package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvltfDao;

public class SvltfDaoServiceImpl extends GenericDaoServiceImpl<SvltfDao> implements SvltfDaoService{
	
	private static String SEPARATOR = "-";

	@Override
	public String getGenerateGodsnummer(String godsLokalkod) {
		SvltfDao withExistingSvltf_numDao =  getExistingSvltf_numAndIncrement(godsLokalkod);
		StringBuilder buffer = new StringBuilder();
		
		String paddedNumber = getWithThePadding(withExistingSvltf_numDao.getSvltf_num());
		buffer.append(withExistingSvltf_numDao.getSvltf_aar()).append(SEPARATOR).append(paddedNumber);
		
		return buffer.toString();
	}
	
	
	private String getWithThePadding(Integer svltf_num) {
		int totalLength = 4;
		String leftPadded = null;
		StringBuilder format = new StringBuilder("%0").append(totalLength).append("d");
		leftPadded = String.format(format.toString(), svltf_num);
		
		return leftPadded;
	}

	private SvltfDao getExistingSvltf_numAndIncrement(String svlth_igl) {
		Integer existingSvltf_num, scaffoldingSvltf_num;
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl(svlth_igl);
		SvltfDao dao = find(qDao);
		existingSvltf_num = dao.getSvltf_num();
		scaffoldingSvltf_num = existingSvltf_num;
		dao.setSvltf_num(++scaffoldingSvltf_num);

		update(dao);
		dao.setSvltf_num(existingSvltf_num);

		return dao;  //Note; NOT incremented num
		
	}
	
}
