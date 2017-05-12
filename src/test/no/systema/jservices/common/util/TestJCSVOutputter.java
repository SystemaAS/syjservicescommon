package no.systema.jservices.common.util;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import no.systema.jservices.common.dao.FaktDao;

public class TestJCSVOutputter {
	
	CSVOutputter<FaktDao> cvsFilePrinter = null;
	FaktDao dao1 = new FaktDao();
	FaktDao dao2 = new FaktDao();
	List<FaktDao> faktDaoList = new ArrayList<FaktDao>();
	
	@Before
	public void setUp() throws Exception {
		cvsFilePrinter = new CSVOutputter<FaktDao>();
		
		dao1.setFaavd(1);
		dao1.setFaopd(100);
		dao1.setFali(1);

		dao2.setFaavd(1);
		dao2.setFaopd(200);
		dao2.setFali(1);	
		
		faktDaoList.add(dao1);
		faktDaoList.add(dao2);		
		
		
	}

	@Test
	public void testWriteToCVSFile() {
		String fileName = "HelloCVS.cvs";
		cvsFilePrinter.writeToCVSFile(fileName, faktDaoList);
	}
	
	@Test
	public void testWriteToCVS() {
		String csvOutput = null;
		csvOutput =cvsFilePrinter.writeAsString(faktDaoList);
		assertNotNull("message",csvOutput);
	}	
	

}
