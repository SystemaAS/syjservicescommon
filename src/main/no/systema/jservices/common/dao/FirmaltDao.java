package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class FirmaltDao implements IDao {

	private String aifirm; // key
	private String aiorg;
	private String aipwd;
	private String aipath;
	private String aiapi;
	private String aiuser;
	private String aiupwd;

	private Map<String, Object> keys = new HashMap<String, Object>();


	public String getAifirm() {
		return aifirm;
	}

	public void setAifirm(String aifirm) {
		this.aifirm = aifirm;
	}

	public String getAiorg() {
		return aiorg;
	}

	public void setAiorg(String aiorg) {
		this.aiorg = aiorg;
	}

	public String getAipwd() {
		return aipwd;
	}

	public void setAipwd(String aipwd) {
		this.aipwd = aipwd;
	}

	public String getAipath() {
		return aipath;
	}

	public void setAipath(String aipath) {
		this.aipath = aipath;
	}

	public String getAiapi() {
		return aiapi;
	}

	public void setAiapi(String aiapi) {
		this.aiapi = aiapi;
	}

	public String getAiuser() {
		return aiuser;
	}

	public void setAiuser(String aiuser) {
		this.aiuser = aiuser;
	}

	public String getAiupwd() {
		return aiupwd;
	}

	public void setAiupwd(String aiupwd) {
		this.aiupwd = aiupwd;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("aifirm", aifirm);
		return keys;
	}

}
