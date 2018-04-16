package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FirmaltDao;

public interface FirmaltDaoService extends GenericDaoService<FirmaltDao> {
	
	/**
	 * Get tuples in FirmaltDao.
	 * Supports more than one organization number per installation, e.g. FIRM
	 * 
	 * @return List<FirmaltDao>
	 */
	public List<FirmaltDao> get();
	
	/**
	 * Update aidato and aitid
	 * 
	 */
	public void updateAiDatoAndAiTid(FirmaltDao dao);
	
	/**
	 * Get Firmalt on orgnr.
	 * 
	 * @param orgnr
	 * @return FirmaltDao
	 */
	public FirmaltDao getFirmaltDao(String orgnr);
	

}
