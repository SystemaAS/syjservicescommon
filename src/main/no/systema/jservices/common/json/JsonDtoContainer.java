package no.systema.jservices.common.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * This class is the placeholder for object(s) that should be delivered from service to UI.
 * 
 * @author Fredrik Möller
 * @date Jan 4, 2016
 *
 */
public class JsonDtoContainer<T> {

	private String user;
	private String errMsg;
	
    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
	private List<T> dtoList;
	
	public List<T> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<T> dtoList) {
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
