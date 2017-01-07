package no.systema.jservices.common.brreg.proxy.entities;

import java.util.List;

/**
 * This class is the placeholder for object(s) that should be delivered from service to UI.
 * 
 * @author Fredrik Möller
 * @date Jan 4, 2016
 *
 */
public class JsonEnhetContainer {

	private String user;
	private String errMsg;
	
	private List<Enhet> dtoList;
	
	public List<Enhet> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<Enhet> dtoList) {
		this.dtoList = dtoList;
		
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	
}
