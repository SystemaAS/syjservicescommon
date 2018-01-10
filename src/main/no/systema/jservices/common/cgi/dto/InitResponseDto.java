package no.systema.jservices.common.cgi.dto;

/**
 * Respone message from rpg-service responsoble for preparing data into "datawarehouse-table"
 * 
 * @Example {"user" : "CB", "dtfra" : "20100101", "dttil" : "20171231", "errMsg" : "" } --> respose ok
 * @Example {"user" : "CB", "dtfra" : "20100101", "dttil" : "20171231", "errMsg" : "Invalid user" } --> respose not ok
 * @author fredrikmoller
 *
 */
public class InitResponseDto {

	private String user;
	private String dtfra;
	private String dttil;
	private String errMsg;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDtfra() {
		return dtfra;
	}
	public void setDtfra(String dtfra) {
		this.dtfra = dtfra;
	}
	public String getDttil() {
		return dttil;
	}
	public void setDttil(String dttil) {
		this.dttil = dttil;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	


}
