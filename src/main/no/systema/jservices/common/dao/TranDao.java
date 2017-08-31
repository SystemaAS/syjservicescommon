package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TranDao implements IDao {

	private String vmfirm;
	private int vmtran; // key
	private int vmtrku; // key
	private int vmtrle; // key
	private int vmincr;
	private String vmnavn;
	private String vm0004;
	private String vm0010;
	private String vm0035;
	private String vmpref;
	private int vmrecn;
	private int vmrecm;
	private String vmlayo;
	private int vmlmom;
	private int vmm3om;
	private BigDecimal vmrab = new BigDecimal(0);
	private String vmalfa;
	private String vmtkat;
	private String vmstop;
	private int vmstda;
	private String vmtext;
	private int vmsnla;
	private int vmsnle;
	private String vmintp;
	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getVmfirm() {
		return vmfirm;
	}

	public void setVmfirm(String vmfirm) {
		this.vmfirm = vmfirm;
	}

	public int getVmtran() {
		return vmtran;
	}

	public void setVmtran(int vmtran) {
		this.vmtran = vmtran;
	}

	public int getVmtrku() {
		return vmtrku;
	}

	public void setVmtrku(int vmtrku) {
		this.vmtrku = vmtrku;
	}

	public int getVmtrle() {
		return vmtrle;
	}

	public void setVmtrle(int vmtrle) {
		this.vmtrle = vmtrle;
	}

	public int getVmincr() {
		return vmincr;
	}

	public void setVmincr(int vmincr) {
		this.vmincr = vmincr;
	}

	public String getVmnavn() {
		return vmnavn;
	}

	public void setVmnavn(String vmnavn) {
		this.vmnavn = vmnavn;
	}

	public String getVm0004() {
		return vm0004;
	}

	public void setVm0004(String vm0004) {
		this.vm0004 = vm0004;
	}

	public String getVm0010() {
		return vm0010;
	}

	public void setVm0010(String vm0010) {
		this.vm0010 = vm0010;
	}

	public String getVm0035() {
		return vm0035;
	}

	public void setVm0035(String vm0035) {
		this.vm0035 = vm0035;
	}

	public String getVmpref() {
		return vmpref;
	}

	public void setVmpref(String vmpref) {
		this.vmpref = vmpref;
	}

	public int getVmrecn() {
		return vmrecn;
	}

	public void setVmrecn(int vmrecn) {
		this.vmrecn = vmrecn;
	}

	public int getVmrecm() {
		return vmrecm;
	}

	public void setVmrecm(int vmrecm) {
		this.vmrecm = vmrecm;
	}

	public String getVmlayo() {
		return vmlayo;
	}

	public void setVmlayo(String vmlayo) {
		this.vmlayo = vmlayo;
	}

	public int getVmlmom() {
		return vmlmom;
	}

	public void setVmlmom(int vmlmom) {
		this.vmlmom = vmlmom;
	}

	public int getVmm3om() {
		return vmm3om;
	}

	public void setVmm3om(int vmm3om) {
		this.vmm3om = vmm3om;
	}

	public BigDecimal getVmrab() {
		return vmrab;
	}

	public void setVmrab(BigDecimal vmrab) {
		this.vmrab = vmrab;
	}

	public String getVmalfa() {
		return vmalfa;
	}

	public void setVmalfa(String vmalfa) {
		this.vmalfa = vmalfa;
	}

	public String getVmtkat() {
		return vmtkat;
	}

	public void setVmtkat(String vmtkat) {
		this.vmtkat = vmtkat;
	}

	public String getVmstop() {
		return vmstop;
	}

	public void setVmstop(String vmstop) {
		this.vmstop = vmstop;
	}

	public int getVmstda() {
		return vmstda;
	}

	public void setVmstda(int vmstda) {
		this.vmstda = vmstda;
	}

	public String getVmtext() {
		return vmtext;
	}

	public void setVmtext(String vmtext) {
		this.vmtext = vmtext;
	}

	public int getVmsnla() {
		return vmsnla;
	}

	public void setVmsnla(int vmsnla) {
		this.vmsnla = vmsnla;
	}

	public int getVmsnle() {
		return vmsnle;
	}

	public void setVmsnle(int vmsnle) {
		this.vmsnle = vmsnle;
	}

	public String getVmintp() {
		return vmintp;
	}

	public void setVmintp(String vmintp) {
		this.vmintp = vmintp;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("vmtran", vmtran);
		keys.put("vmtrku", vmtrku);
		keys.put("vmtrle", vmtrle);
		return keys;
	}

}
