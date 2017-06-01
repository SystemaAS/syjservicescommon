package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Svtx03fDao implements IDao {

	private String svtx03_01; // key - exportImportType
	private String svtx03_02; // key - codeTypeId
	private String svtx03_03; // key - id
	private String svtx03_04; // description-1  
	private String svtx03_05; // dateEnd
	private String svtx03_06; // dateStart

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getSvtx03_01() {
		return svtx03_01;
	}

	public void setSvtx03_01(String svtx03_01) {
		this.svtx03_01 = svtx03_01;
	}

	public String getSvtx03_02() {
		return svtx03_02;
	}

	public void setSvtx03_02(String svtx03_02) {
		this.svtx03_02 = svtx03_02;
	}

	public String getSvtx03_03() {
		return svtx03_03;
	}

	public void setSvtx03_03(String svtx03_03) {
		this.svtx03_03 = svtx03_03;
	}

	public String getSvtx03_04() {
		return svtx03_04;
	}

	public void setSvtx03_04(String svtx03_04) {
		this.svtx03_04 = svtx03_04;
	}

	public String getSvtx03_05() {
		return svtx03_05;
	}

	public void setSvtx03_05(String svtx03_05) {
		this.svtx03_05 = svtx03_05;
	}

	public String getSvtx03_06() {
		return svtx03_06;
	}

	public void setSvtx03_06(String svtx03_06) {
		this.svtx03_06 = svtx03_06;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("svtx03_01", svtx03_01);
		keys.put("svtx03_02", svtx03_02);
		keys.put("svtx03_03", svtx03_03);
		return keys;
	}

}
