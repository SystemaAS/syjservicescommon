package no.systema.jservices.common.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper; 

/**
 * This Json writer is the evolutionary version of the the original based on
 * reflection.
 * 
 * @author Fredrik Möller
 * @date Jan 4, 2016
 * 
 */
public class JsonResponseWriter2<T> {
	private ObjectMapper mapper = new ObjectMapper();
	private JsonDtoContainer<T> container = new JsonDtoContainer<T>();
	private boolean hasContainer = true;


	/**
	 * Convert delivered object list into Json container.
	 * 
	 * @param user
	 * @param objectList
	 * @return Json string
	 */
	public String setJsonResult_Common_GetList(String user, List<T> dtoList) {
		String result = null;
		container.setUser(user);
		container.setDtoList(dtoList);
		result = writeValue();
		return result;
	}

	/**
	 * Convert delivered Object into Json
	 * 
	 * @param user
	 * @param value
	 * @return Json string
	 */
	public String setJsonResult_Common_GetComposite(String user, T value) {
		String result = null;
		container.setUser(user);
		addValue(value);
		result = writeValue();
		return result;
	}

	public String setJsonResult_Common_GetComposite_No_Container(T value) {
		String result = null;
		result = writeValue(value);
		return result;
	}	
	
	/**
	 * Concat status, errmsg and db error into container
	 * 
	 * @param user
	 * @param errMsg
	 * @param status
	 * @param dbErrorStackTrace
	 * @return Json string
	 */
	public String setJsonSimpleErrorResult(String user, String errMsg, String status, StringBuffer dbErrorStackTrace) {
		String result = null;
		container.setUser(user);
		if (dbErrorStackTrace != null && dbErrorStackTrace.length() > 0) {
			container.setErrMsg(errMsg + dbErrorStackTrace);
		} else {
			container.setErrMsg(errMsg);
		}
		result = writeValue();
		return result;

	}
	
	/**
	 * Small json
	 * 
	 * 
	 * @param user
	 * @param status
	 * @return Json String
	 */
	public String setJsonSimpleValidResult(String user, String status) {
		String result = null;
		container.setUser(user);
		result = writeValue();
		return result;
	}
	
	
	public boolean isHasContainer() {
		return hasContainer;
	}

	public void setHasContainer(boolean hasContainer) {
		this.hasContainer = hasContainer;
	}

	
	private void addValue(T value) {
		List<T> dtoList = new ArrayList<T>();
		dtoList.add(value);
		container.setDtoList(dtoList);
	}

	private String writeValue() {
		String result = null;
		try {
			result = mapper.writeValueAsString(container);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String writeValue(T value) {
		String result = null;
		try {
			result = mapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
}
