package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class FirmaltDao implements IDao {

	private String aifirm; // key
	private String aiorg;  //key
	private String aipwd;
	private String aipath;
	private String aiapi;
	private String aiuser;
	private String aiupwd;
	private String aihost;
	private String aiauur;
	private int aidato;
	private int aitid;

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


	public String getAihost() {
		return aihost;
	}

	public void setAihost(String aihost) {
		this.aihost = aihost;
	}

	public String getAiauur() {
		return aiauur;
	}

	public void setAiauur(String aiauur) {
		this.aiauur = aiauur;
	}
	
	public int getAidato() {
		return aidato;
	}

	public void setAidato(int aidato) {
		this.aidato = aidato;
	}

	public int getAitid() {
		return aitid;
	}

	public void setAitid(int aitid) {
		this.aitid = aitid;
	}	

	@Override
	public Map<String, Object> getKeys() {
		keys.put("aifirm", aifirm);
		keys.put("aiorg", aiorg);
		return keys;
	}

	/**
	 * Sanity check on Firmalt records
	 * 
	 * throws a RuntimeException if any value is null. aidato and aitid excluded.
	 * 
	 */
	public void hasSaneValues()  {
		if (aifirm == null || aiorg == null || aipwd == null || aipath == null || aiapi == null || aiuser == null || aiupwd == null || aihost == null || aiauur == null) {
			throw new RuntimeException("Some, or all columns are null in FIRMALT!, record="+ReflectionToStringBuilder.toString(this));
		}
		
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
