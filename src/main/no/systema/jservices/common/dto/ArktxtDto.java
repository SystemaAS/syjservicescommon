package no.systema.jservices.common.dto;

import no.systema.jservices.common.dao.ArktxtDao;

/**
 * This is the Data Transfer Object between service and UI for Arkiv dokumenter
 * 
 * @author Fredrik Möller
 * @date Apr 10, 2017
 *
 */
public class ArktxtDto extends ArktxtDao {

	private String arklagDesc;
	private String arkved1;
	private String arkved2;
	private String arkved3;
	private String arkved4;
	private String arkved5;
	private String arkved6;
	private String arkved7;
	private String arkved8;
	private String arkved9;
	private String arkved10;
	private String arkved11;
	private String arkved12;
	private String arkved13;
	private String arkved14;
	private String arkved15;
	private String arkved16;
	private String arkved17;
	private String arkved18;
	private String arkved19;
	private String arkved20;
	private String arkved21;
	private String arkved22;
	private String arkved23;
	private String arkved24;
	private String arkved25;
	private String arkved26;
	private String arkved27;
	private String arkved28;
	private String arkved29;
	private String arkved30;

	public String getArkved1() {
		if (arkved1 != null) { // from UI
			return arkved1;
		} else {
			if (arkved != null && arkved.length() > 1) { // from DB
				return this.arkved.substring(0, 2);
			}
		}
		return arkved1;
	}

	public void setArkved1(String arkved1) {
		this.arkved1 = arkved1;
	}

	public String getArkved2() {
		if (arkved2 != null) { // from UI
			return arkved2;
		} else {
			if (arkved != null && arkved.length() > 3) { // from DB
				return this.arkved.substring(2, 4);
			}
		}
		return arkved2;
	}

	public void setArkved2(String arkved2) {
		this.arkved2 = arkved2;
	}

	public String getArkved3() {
		if (arkved3 != null) { // from UI
			return arkved3;
		} else {
			if (arkved != null && arkved.length() > 5) { // from DB
				return this.arkved.substring(4, 6);
			}
		}
		return arkved3;
	}

	public void setArkved3(String arkved3) {
		this.arkved3 = arkved3;
	}

	public String getArkved4() {
		if (arkved4 != null) { // from UI
			return arkved4;
		} else {
			if (arkved != null && arkved.length() > 7) { // from DB
				return this.arkved.substring(6, 8);
			}
		}
		return arkved4;
	}

	public void setArkved4(String arkved4) {
		this.arkved4 = arkved4;
	}

	public String getArkved5() {
		if (arkved5 != null) { // from UI
			return arkved5;
		} else {
			if (arkved != null && arkved.length() > 9) { // from DB
				return this.arkved.substring(8, 10);
			}
		}
		return arkved5;
	}

	public void setArkved5(String arkved5) {
		this.arkved5 = arkved5;
	}

	public String getArkved6() {
		if (arkved6 != null) { // from UI
			return arkved6;
		} else {
			if (arkved != null && arkved.length() > 11) { // from DB
				return this.arkved.substring(10, 12);
			}
		}
		return arkved6;
	}

	public void setArkved6(String arkved6) {
		this.arkved6 = arkved6;
	}

	public String getArkved7() {
		if (arkved7 != null) { // from UI
			return arkved7;
		} else {
			if (arkved != null && arkved.length() > 13) { // from DB
				return this.arkved.substring(12, 14);
			}
		}
		return arkved7;
	}

	public void setArkved7(String arkved7) {
		this.arkved7 = arkved7;
	}

	public String getArkved8() {
		if (arkved8 != null) { // from UI
			return arkved8;
		} else {
			if (arkved != null && arkved.length() > 15) { // from DB
				return this.arkved.substring(14, 16);
			}
		}
		return arkved8;
	}

	public void setArkved8(String arkved8) {
		this.arkved8 = arkved8;
	}

	public String getArkved9() {
		if (arkved9 != null) { // from UI
			return arkved9;
		} else {
			if (arkved != null && arkved.length() > 17) { // from DB
				return this.arkved.substring(16, 18);
			}
		}
		return arkved9;
	}

	public void setArkved9(String arkved9) {
		this.arkved9 = arkved9;
	}

	public String getArkved10() {
		if (arkved10 != null) { // from UI
			return arkved10;
		} else {
			if (arkved != null && arkved.length() > 19) { // from DB
				return this.arkved.substring(18, 20);
			}
		}
		return arkved10;
	}

	public void setArkved10(String arkved10) {
		this.arkved10 = arkved10;
	}

	public String getArkved11() {
		if (arkved11 != null) { // from UI
			return arkved11;
		} else {
			if (arkved != null && arkved.length() > 21) { // from DB
				return this.arkved.substring(20, 22);
			}
		}
		return arkved11;
	}

	public void setArkved11(String arkved11) {
		this.arkved11 = arkved11;
	}

	public String getArkved12() {
		if (arkved12 != null) { // from UI
			return arkved12;
		} else {
			if (arkved != null && arkved.length() > 23) { // from DB
				return this.arkved.substring(22, 24);
			}
		}
		return arkved12;
	}

	public void setArkved12(String arkved12) {
		this.arkved12 = arkved12;
	}

	public String getArkved13() {
		if (arkved13 != null) { // from UI
			return arkved13;
		} else {
			if (arkved != null && arkved.length() > 25) { // from DB
				return this.arkved.substring(24, 26);
			}
		}
		return arkved13;
	}

	public void setArkved13(String arkved13) {
		this.arkved13 = arkved13;
	}

	public String getArkved14() {
		if (arkved14 != null) { // from UI
			return arkved14;
		} else {
			if (arkved != null && arkved.length() > 27) { // from DB
				return this.arkved.substring(26, 28);
			}
		}
		return arkved14;
	}

	public void setArkved14(String arkved14) {
		this.arkved14 = arkved14;
	}

	public String getArkved15() {
		if (arkved15 != null) { // from UI
			return arkved15;
		} else {
			if (arkved != null && arkved.length() > 29) { // from DB
				return this.arkved.substring(28, 30);
			}
		}
		return arkved15;
	}

	public void setArkved15(String arkved15) {
		this.arkved15 = arkved15;
	}

	public String getArkved16() {
		if (arkved16 != null) { // from UI
			return arkved16;
		} else {
			if (arkved != null && arkved.length() > 31) { // from DB
				return this.arkved.substring(30, 32);
			}
		}
		return arkved16;
	}

	public void setArkved16(String arkved16) {
		this.arkved16 = arkved16;
	}

	public String getArkved17() {
		if (arkved17 != null) { // from UI
			return arkved17;
		} else {
			if (arkved != null && arkved.length() > 33) { // from DB
				return this.arkved.substring(32, 34);
			}
		}
		return arkved17;
	}

	public void setArkved17(String arkved17) {
		this.arkved17 = arkved17;
	}

	public String getArkved18() {
		if (arkved18 != null) { // from UI
			return arkved18;
		} else {
			if (arkved != null && arkved.length() > 35) { // from DB
				return this.arkved.substring(34, 36);
			}
		}
		return arkved18;
	}

	public void setArkved18(String arkved18) {
		this.arkved18 = arkved18;
	}

	public String getArkved19() {
		if (arkved19 != null) { // from UI
			return arkved19;
		} else {
			if (arkved != null && arkved.length() > 37) { // from DB
				return this.arkved.substring(36, 38);
			}
		}
		return arkved19;
	}

	public void setArkved19(String arkved19) {
		this.arkved19 = arkved19;
	}

	public String getArkved20() {
		if (arkved20 != null) { // from UI
			return arkved20;
		} else {
			if (arkved != null && arkved.length() > 39) { // from DB
				return this.arkved.substring(38, 40);
			}
		}
		return arkved20;
	}

	public void setArkved20(String arkved20) {
		this.arkved20 = arkved20;
	}

	public String getArkved21() {
		if (arkved21 != null) { // from UI
			return arkved21;
		} else {
			if (arkved != null && arkved.length() > 41) { // from DB
				return this.arkved.substring(40, 42);
			}
		}
		return arkved21;
	}

	public void setArkved21(String arkved21) {
		this.arkved21 = arkved21;
	}

	public String getArkved22() {
		if (arkved22 != null) { // from UI
			return arkved22;
		} else {
			if (arkved != null && arkved.length() > 43) { // from DB
				return this.arkved.substring(42, 44);
			}
		}
		return arkved22;
	}

	public void setArkved22(String arkved22) {
		this.arkved22 = arkved22;
	}

	public String getArkved23() {
		if (arkved23 != null) { // from UI
			return arkved23;
		} else {
			if (arkved != null && arkved.length() > 45) { // from DB
				return this.arkved.substring(44, 46);
			}
		}
		return arkved23;
	}

	public void setArkved23(String arkved23) {
		this.arkved23 = arkved23;
	}

	public String getArkved24() {
		if (arkved24 != null) { // from UI
			return arkved24;
		} else {
			if (arkved != null && arkved.length() > 47) { // from DB
				return this.arkved.substring(46, 48);
			}
		}
		return arkved24;
	}

	public void setArkved24(String arkved24) {
		this.arkved24 = arkved24;
	}

	public String getArkved25() {
		if (arkved25 != null) { // from UI
			return arkved25;
		} else {
			if (arkved != null && arkved.length() > 49) { // from DB
				return this.arkved.substring(48, 50);
			}
		}
		return arkved25;
	}

	public void setArkved25(String arkved25) {
		this.arkved25 = arkved25;
	}

	public String getArkved26() {
		if (arkved26 != null) { // from UI
			return arkved26;
		} else {
			if (arkved != null && arkved.length() > 51) { // from DB
				return this.arkved.substring(50, 52);
			}
		}
		return arkved26;
	}

	public void setArkved26(String arkved26) {
		this.arkved26 = arkved26;
	}

	public String getArkved27() {
		if (arkved27 != null) { // from UI
			return arkved27;
		} else {
			if (arkved != null && arkved.length() > 53) { // from DB
				return this.arkved.substring(52, 54);
			}
		}
		return arkved27;
	}

	public void setArkved27(String arkved27) {
		this.arkved27 = arkved27;
	}

	public String getArkved28() {
		if (arkved28 != null) { // from UI
			return arkved28;
		} else {
			if (arkved != null && arkved.length() > 55) { // from DB
				return this.arkved.substring(54, 56);
			}
		}
		return arkved28;
	}

	public void setArkved28(String arkved28) {
		this.arkved28 = arkved28;
	}

	public String getArkved29() {
		if (arkved29 != null) { // from UI
			return arkved29;
		} else {
			if (arkved != null && arkved.length() > 57) { // from DB
				return this.arkved.substring(56, 58);
			}
		}
		return arkved29;
	}

	public void setArkved29(String arkved29) {
		this.arkved29 = arkved29;
	}

	public String getArkved30() {
		if (arkved30 != null) { // from UI
			return arkved30;
		} else {
			if (arkved != null && arkved.length() > 59) { // from DB
				return this.arkved.substring(58, 60);
			}
		}
		return arkved30;
	}

	public void setArkved30(String arkved30) {
		this.arkved30 = arkved30;
	}

	public String getArklagDesc() {
		return arklagDesc;
	}

	public void setArklagDesc(String arklagDesc) {
		this.arklagDesc = arklagDesc;
	}

}
