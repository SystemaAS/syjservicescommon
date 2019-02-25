package no.systema.jservices.common.dao.services;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import no.systema.jservices.common.dao.CnffDao;

public class CnffDaoServiceImpl extends GenericDaoServiceImpl<CnffDao> implements CnffDaoService{

	/**
	 * Increment the counter for Tradevision foreign keys in related tables such as: FFR00F (f00rec)
	 * The value returned is the value to be used
	 * @return
	 */
	
	public int getCnrecnAndIncrement(){
		int counter = 0;
		int update = 0;
		
		try{
			List<CnffDao> list = findAll(null); //no need to specify since the table will always have one-and-only-one record
			for(CnffDao record: list){
				record.getCnrecn();
				update = updateCounterColumn("cnrecn", record.getCnrecn());
			}
			if(update>0){
				//get the newly updated counter
				List<CnffDao> newList = findAll(null); //no need to specify since the table will always have one-and-only-one record
				for(CnffDao record: newList){
					counter = record.getCnrecn();
				}
			}
		
		}catch(Exception e){
			counter = -1;
		}
		return counter;
		
	}
	
	
}
