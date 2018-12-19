package no.systema.jservices.common.elma.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EHF_ORDER_RESPONSE", "EHF_CATALOGUE_RESPONSE", "EHF_INVOICE_CREDITNOTE_2_0", "BIS36_MLR", "PAYMENT_02_RESPONSE", "PEPPOLBIS_03A_2_0", "PEPPOLBIS_28A_2_0", "PEPPOLBIS_30A_2_0",
		"BIS04_V2", "identifier", "EHF_CREDITNOTE_2_0", "EHF_ORDER", "PEPPOLBIS_3_0_BILLING_01_CII", "PEPPOLBIS_28A_2_0_RESPONSE", "BIS01", "PEPPOLBIS_3_0_BILLING_01_UBL", "Icd", "BIS03",
		"PAYMENT_01_RESPONSE", "EHF_30A_1_0", "EHF_XYA_1_0_REMINDER", "BIS06", "ISO20022_Pain_001", "PAYMENT_02", "PAYMENT_01", "name", "regdate", "EHF_INVOICE_2_0", "EHF_CATALOGUE", "BIS05_V2",
		"PEPPOLBIS_01A_2_0" })
public class Entry {

	@JsonProperty("EHF_ORDER_RESPONSE")
	private String eHFORDERRESPONSE;
	@JsonProperty("EHF_CATALOGUE_RESPONSE")
	private String eHFCATALOGUERESPONSE;
	@JsonProperty("EHF_INVOICE_CREDITNOTE_2_0")
	private String eHFINVOICECREDITNOTE20;
	@JsonProperty("BIS36_MLR")
	private String bIS36MLR;
	@JsonProperty("PAYMENT_02_RESPONSE")
	private String pAYMENT02RESPONSE;
	@JsonProperty("PEPPOLBIS_03A_2_0")
	private String pEPPOLBIS03A20;
	@JsonProperty("PEPPOLBIS_28A_2_0")
	private String pEPPOLBIS28A20;
	@JsonProperty("PEPPOLBIS_30A_2_0")
	private String pEPPOLBIS30A20;
	@JsonProperty("BIS04_V2")
	private String bIS04V2;
	@JsonProperty("identifier")
	private String identifier;
	@JsonProperty("EHF_CREDITNOTE_2_0")
	private String eHFCREDITNOTE20;
	@JsonProperty("EHF_ORDER")
	private String eHFORDER;
	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_CII")
	private String pEPPOLBIS30BILLING01CII;
	@JsonProperty("PEPPOLBIS_28A_2_0_RESPONSE")
	private String pEPPOLBIS28A20RESPONSE;
	@JsonProperty("BIS01")
	private String bIS01;
	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_UBL")
	private String pEPPOLBIS30BILLING01UBL;
	@JsonProperty("Icd")
	private String icd;
	@JsonProperty("BIS03")
	private String bIS03;
	@JsonProperty("PAYMENT_01_RESPONSE")
	private String pAYMENT01RESPONSE;
	@JsonProperty("EHF_30A_1_0")
	private String eHF30A10;
	@JsonProperty("EHF_XYA_1_0_REMINDER")
	private String eHFXYA10REMINDER;
	@JsonProperty("BIS06")
	private String bIS06;
	@JsonProperty("ISO20022_Pain_001")
	private String iSO20022Pain001;
	@JsonProperty("PAYMENT_02")
	private String pAYMENT02;
	@JsonProperty("PAYMENT_01")
	private String pAYMENT01;
	@JsonProperty("name")
	private String name;
	@JsonProperty("regdate")
	private String regdate;
	@JsonProperty("EHF_INVOICE_2_0")
	private String eHFINVOICE20;
	@JsonProperty("EHF_CATALOGUE")
	private String eHFCATALOGUE;
	@JsonProperty("BIS05_V2")
	private String bIS05V2;
	@JsonProperty("PEPPOLBIS_01A_2_0")
	private String pEPPOLBIS01A20;

	@JsonProperty("EHF_ORDER_RESPONSE")
	public String getEHFORDERRESPONSE() {
		return eHFORDERRESPONSE;
	}

	@JsonProperty("EHF_ORDER_RESPONSE")
	public void setEHFORDERRESPONSE(String eHFORDERRESPONSE) {
		this.eHFORDERRESPONSE = eHFORDERRESPONSE;
	}

	@JsonProperty("EHF_CATALOGUE_RESPONSE")
	public String getEHFCATALOGUERESPONSE() {
		return eHFCATALOGUERESPONSE;
	}

	@JsonProperty("EHF_CATALOGUE_RESPONSE")
	public void setEHFCATALOGUERESPONSE(String eHFCATALOGUERESPONSE) {
		this.eHFCATALOGUERESPONSE = eHFCATALOGUERESPONSE;
	}

	@JsonProperty("EHF_INVOICE_CREDITNOTE_2_0")
	public String getEHFINVOICECREDITNOTE20() {
		return eHFINVOICECREDITNOTE20;
	}

	@JsonProperty("EHF_INVOICE_CREDITNOTE_2_0")
	public void setEHFINVOICECREDITNOTE20(String eHFINVOICECREDITNOTE20) {
		this.eHFINVOICECREDITNOTE20 = eHFINVOICECREDITNOTE20;
	}

	@JsonProperty("BIS36_MLR")
	public String getBIS36MLR() {
		return bIS36MLR;
	}

	@JsonProperty("BIS36_MLR")
	public void setBIS36MLR(String bIS36MLR) {
		this.bIS36MLR = bIS36MLR;
	}

	@JsonProperty("PAYMENT_02_RESPONSE")
	public String getPAYMENT02RESPONSE() {
		return pAYMENT02RESPONSE;
	}

	@JsonProperty("PAYMENT_02_RESPONSE")
	public void setPAYMENT02RESPONSE(String pAYMENT02RESPONSE) {
		this.pAYMENT02RESPONSE = pAYMENT02RESPONSE;
	}

	@JsonProperty("PEPPOLBIS_03A_2_0")
	public String getPEPPOLBIS03A20() {
		return pEPPOLBIS03A20;
	}

	@JsonProperty("PEPPOLBIS_03A_2_0")
	public void setPEPPOLBIS03A20(String pEPPOLBIS03A20) {
		this.pEPPOLBIS03A20 = pEPPOLBIS03A20;
	}

	@JsonProperty("PEPPOLBIS_28A_2_0")
	public String getPEPPOLBIS28A20() {
		return pEPPOLBIS28A20;
	}

	@JsonProperty("PEPPOLBIS_28A_2_0")
	public void setPEPPOLBIS28A20(String pEPPOLBIS28A20) {
		this.pEPPOLBIS28A20 = pEPPOLBIS28A20;
	}

	@JsonProperty("PEPPOLBIS_30A_2_0")
	public String getPEPPOLBIS30A20() {
		return pEPPOLBIS30A20;
	}

	@JsonProperty("PEPPOLBIS_30A_2_0")
	public void setPEPPOLBIS30A20(String pEPPOLBIS30A20) {
		this.pEPPOLBIS30A20 = pEPPOLBIS30A20;
	}

	@JsonProperty("BIS04_V2")
	public String getBIS04V2() {
		return bIS04V2;
	}

	@JsonProperty("BIS04_V2")
	public void setBIS04V2(String bIS04V2) {
		this.bIS04V2 = bIS04V2;
	}

	@JsonProperty("identifier")
	public String getIdentifier() {
		return identifier;
	}

	@JsonProperty("identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@JsonProperty("EHF_CREDITNOTE_2_0")
	public String getEHFCREDITNOTE20() {
		return eHFCREDITNOTE20;
	}

	@JsonProperty("EHF_CREDITNOTE_2_0")
	public void setEHFCREDITNOTE20(String eHFCREDITNOTE20) {
		this.eHFCREDITNOTE20 = eHFCREDITNOTE20;
	}

	@JsonProperty("EHF_ORDER")
	public String getEHFORDER() {
		return eHFORDER;
	}

	@JsonProperty("EHF_ORDER")
	public void setEHFORDER(String eHFORDER) {
		this.eHFORDER = eHFORDER;
	}

	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_CII")
	public String getPEPPOLBIS30BILLING01CII() {
		return pEPPOLBIS30BILLING01CII;
	}

	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_CII")
	public void setPEPPOLBIS30BILLING01CII(String pEPPOLBIS30BILLING01CII) {
		this.pEPPOLBIS30BILLING01CII = pEPPOLBIS30BILLING01CII;
	}

	@JsonProperty("PEPPOLBIS_28A_2_0_RESPONSE")
	public String getPEPPOLBIS28A20RESPONSE() {
		return pEPPOLBIS28A20RESPONSE;
	}

	@JsonProperty("PEPPOLBIS_28A_2_0_RESPONSE")
	public void setPEPPOLBIS28A20RESPONSE(String pEPPOLBIS28A20RESPONSE) {
		this.pEPPOLBIS28A20RESPONSE = pEPPOLBIS28A20RESPONSE;
	}

	@JsonProperty("BIS01")
	public String getBIS01() {
		return bIS01;
	}

	@JsonProperty("BIS01")
	public void setBIS01(String bIS01) {
		this.bIS01 = bIS01;
	}

	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_UBL")
	public String getPEPPOLBIS30BILLING01UBL() {
		return pEPPOLBIS30BILLING01UBL;
	}

	@JsonProperty("PEPPOLBIS_3_0_BILLING_01_UBL")
	public void setPEPPOLBIS30BILLING01UBL(String pEPPOLBIS30BILLING01UBL) {
		this.pEPPOLBIS30BILLING01UBL = pEPPOLBIS30BILLING01UBL;
	}

	@JsonProperty("Icd")
	public String getIcd() {
		return icd;
	}

	@JsonProperty("Icd")
	public void setIcd(String icd) {
		this.icd = icd;
	}

	@JsonProperty("BIS03")
	public String getBIS03() {
		return bIS03;
	}

	@JsonProperty("BIS03")
	public void setBIS03(String bIS03) {
		this.bIS03 = bIS03;
	}

	@JsonProperty("PAYMENT_01_RESPONSE")
	public String getPAYMENT01RESPONSE() {
		return pAYMENT01RESPONSE;
	}

	@JsonProperty("PAYMENT_01_RESPONSE")
	public void setPAYMENT01RESPONSE(String pAYMENT01RESPONSE) {
		this.pAYMENT01RESPONSE = pAYMENT01RESPONSE;
	}

	@JsonProperty("EHF_30A_1_0")
	public String getEHF30A10() {
		return eHF30A10;
	}

	@JsonProperty("EHF_30A_1_0")
	public void setEHF30A10(String eHF30A10) {
		this.eHF30A10 = eHF30A10;
	}

	@JsonProperty("EHF_XYA_1_0_REMINDER")
	public String getEHFXYA10REMINDER() {
		return eHFXYA10REMINDER;
	}

	@JsonProperty("EHF_XYA_1_0_REMINDER")
	public void setEHFXYA10REMINDER(String eHFXYA10REMINDER) {
		this.eHFXYA10REMINDER = eHFXYA10REMINDER;
	}

	@JsonProperty("BIS06")
	public String getBIS06() {
		return bIS06;
	}

	@JsonProperty("BIS06")
	public void setBIS06(String bIS06) {
		this.bIS06 = bIS06;
	}

	@JsonProperty("ISO20022_Pain_001")
	public String getISO20022Pain001() {
		return iSO20022Pain001;
	}

	@JsonProperty("ISO20022_Pain_001")
	public void setISO20022Pain001(String iSO20022Pain001) {
		this.iSO20022Pain001 = iSO20022Pain001;
	}

	@JsonProperty("PAYMENT_02")
	public String getPAYMENT02() {
		return pAYMENT02;
	}

	@JsonProperty("PAYMENT_02")
	public void setPAYMENT02(String pAYMENT02) {
		this.pAYMENT02 = pAYMENT02;
	}

	@JsonProperty("PAYMENT_01")
	public String getPAYMENT01() {
		return pAYMENT01;
	}

	@JsonProperty("PAYMENT_01")
	public void setPAYMENT01(String pAYMENT01) {
		this.pAYMENT01 = pAYMENT01;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("regdate")
	public String getRegdate() {
		return regdate;
	}

	@JsonProperty("regdate")
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@JsonProperty("EHF_INVOICE_2_0")
	public String getEHFINVOICE20() {
		return eHFINVOICE20;
	}

	@JsonProperty("EHF_INVOICE_2_0")
	public void setEHFINVOICE20(String eHFINVOICE20) {
		this.eHFINVOICE20 = eHFINVOICE20;
	}

	@JsonProperty("EHF_CATALOGUE")
	public String getEHFCATALOGUE() {
		return eHFCATALOGUE;
	}

	@JsonProperty("EHF_CATALOGUE")
	public void setEHFCATALOGUE(String eHFCATALOGUE) {
		this.eHFCATALOGUE = eHFCATALOGUE;
	}

	@JsonProperty("BIS05_V2")
	public String getBIS05V2() {
		return bIS05V2;
	}

	@JsonProperty("BIS05_V2")
	public void setBIS05V2(String bIS05V2) {
		this.bIS05V2 = bIS05V2;
	}

	@JsonProperty("PEPPOLBIS_01A_2_0")
	public String getPEPPOLBIS01A20() {
		return pEPPOLBIS01A20;
	}

	@JsonProperty("PEPPOLBIS_01A_2_0")
	public void setPEPPOLBIS01A20(String pEPPOLBIS01A20) {
		this.pEPPOLBIS01A20 = pEPPOLBIS01A20;
	}

}
