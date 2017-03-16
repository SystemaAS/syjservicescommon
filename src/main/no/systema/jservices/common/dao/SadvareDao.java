package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class SadvareDao implements IDao {

	private String varenr; // key
	private String varebe;
	private String levenr; // key
	private String w2vf;
	private String w2lk;
	private String w2vnti;
	private String w2tn;
	private String w2pre;
	private String w2belt = "0";
	private String w2vktb = "0";
	private String w2vktn = "0";
	private String w2ntm = "0";
	private String w2pva;
	private String w2as = "0";
	private String w2mfr;
	private String w2akd1;
	private String w2asv1;
	private String w2asa1 = "0";
	private String w2agr1 = "0";
	private String w2abl1 = "0";
	private String w2bel = "0";
	private String w2akd2;
	private String w2asv2;
	private String w2asa2 = "0";
	private String w2agr2 = "0";
	private String w2abl2 = "0";
	private String w2pros = "0";
	private String w2akd3;
	private String w2asv3;
	private String w2asa3 = "0";
	private String w2agr3 = "0";
	private String w2abl3 = "0";
	private String w2val;
	private String w2akd4;
	private String w2asv4;
	private String w2asa4 = "0";
	private String w2agr4 = "0";
	private String w2abl4 = "0";
	private String w2beln = "0";
	private String w2akd5;
	private String w2asv5;
	private String w2asa5 = "0";
	private String w2agr5 = "0";
	private String w2abl5 = "0";
	private String w2akd6;
	private String w2asv6;
	private String w2asa6 = "0";
	private String w2agr6 = "0";
	private String w2abl6 = "0";
	private String w2akd7;
	private String w2asv7;
	private String w2asa7 = "0";
	private String w2agr7 = "0";
	private String w2abl7 = "0";
	private String w2akd8;
	private String w2asv8;
	private String w2asa8 = "0";
	private String w2agr8 = "0";
	private String w2abl8 = "0";
	private String w2ft01;
	private String w2nt01 = "0";
	private String w2eh01;
	private String w2vt01;
	private String w2ft02;
	private String w2nt02 = "0";
	private String w2eh02;
	private String w2vt02;
	private String w2ft03;
	private String w2nt03 = "0";
	private String w2eh03;
	private String w2vt03;
	private String w2ft04;
	private String w2nt04 = "0";
	private String w2eh04;
	private String w2vt04;
	private String w2ft05;
	private String w2nt05 = "0";
	private String w2eh05;
	private String w2vt05;
	private String w2ft06;
	private String w2nt06 = "0";
	private String w2eh06;
	private String w2ft07;
	private String w2nt07 = "0";
	private String w2eh07;
	private String w2top1;
	private String w2cre1;
	private String w2top2;
	private String w2cre2;
	private String w2top3;
	private String w2cre3;
	private String w2top4;
	private String w2cre4;
	private String w2top5;
	private String w2cre5;
	private String w2top6;
	private String w2cre6;
	private String w2top7;
	private String w2cre7;
	private String w2top8;
	private String w2cre8;
	private String w2top9;
	private String w2cre9;
	private String w2top10;
	private String w2cre10;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getVarenr() {
		return varenr;
	}

	public void setVarenr(String varenr) {
		this.varenr = varenr;
	}

	public String getVarebe() {
		return varebe;
	}

	public void setVarebe(String varebe) {
		this.varebe = varebe;
	}

	public String getLevenr() {
		return levenr;
	}

	public void setLevenr(String levenr) {
		this.levenr = levenr;
	}

	public String getW2vf() {
		return w2vf;
	}

	public void setW2vf(String w2vf) {
		this.w2vf = w2vf;
	}

	public String getW2lk() {
		return w2lk;
	}

	public void setW2lk(String w2lk) {
		this.w2lk = w2lk;
	}

	public String getW2vnti() {
		return w2vnti;
	}

	public void setW2vnti(String w2vnti) {
		this.w2vnti = w2vnti;
	}

	public String getW2tn() {
		return w2tn;
	}

	public void setW2tn(String w2tn) {
		this.w2tn = w2tn;
	}

	public String getW2pre() {
		return w2pre;
	}

	public void setW2pre(String w2pre) {
		this.w2pre = w2pre;
	}

	public String getW2belt() {
		return w2belt;
	}

	public void setW2belt(String w2belt) {
		this.w2belt = w2belt;
	}

	public String getW2vktb() {
		return w2vktb;
	}

	public void setW2vktb(String w2vktb) {
		this.w2vktb = w2vktb;
	}

	public String getW2vktn() {
		return w2vktn;
	}

	public void setW2vktn(String w2vktn) {
		this.w2vktn = w2vktn;
	}

	public String getW2ntm() {
		return w2ntm;
	}

	public void setW2ntm(String w2ntm) {
		this.w2ntm = w2ntm;
	}

	public String getW2pva() {
		return w2pva;
	}

	public void setW2pva(String w2pva) {
		this.w2pva = w2pva;
	}

	public String getW2as() {
		return w2as;
	}

	public void setW2as(String w2as) {
		this.w2as = w2as;
	}

	public String getW2mfr() {
		return w2mfr;
	}

	public void setW2mfr(String w2mfr) {
		this.w2mfr = w2mfr;
	}

	public String getW2akd1() {
		return w2akd1;
	}

	public void setW2akd1(String w2akd1) {
		this.w2akd1 = w2akd1;
	}

	public String getW2asv1() {
		return w2asv1;
	}

	public void setW2asv1(String w2asv1) {
		this.w2asv1 = w2asv1;
	}

	public String getW2asa1() {
		return w2asa1;
	}

	public void setW2asa1(String w2asa1) {
		this.w2asa1 = w2asa1;
	}

	public String getW2agr1() {
		return w2agr1;
	}

	public void setW2agr1(String w2agr1) {
		this.w2agr1 = w2agr1;
	}

	public String getW2abl1() {
		return w2abl1;
	}

	public void setW2abl1(String w2abl1) {
		this.w2abl1 = w2abl1;
	}

	public String getW2bel() {
		return w2bel;
	}

	public void setW2bel(String w2bel) {
		this.w2bel = w2bel;
	}

	public String getW2akd2() {
		return w2akd2;
	}

	public void setW2akd2(String w2akd2) {
		this.w2akd2 = w2akd2;
	}

	public String getW2asv2() {
		return w2asv2;
	}

	public void setW2asv2(String w2asv2) {
		this.w2asv2 = w2asv2;
	}

	public String getW2asa2() {
		return w2asa2;
	}

	public void setW2asa2(String w2asa2) {
		this.w2asa2 = w2asa2;
	}

	public String getW2agr2() {
		return w2agr2;
	}

	public void setW2agr2(String w2agr2) {
		this.w2agr2 = w2agr2;
	}

	public String getW2abl2() {
		return w2abl2;
	}

	public void setW2abl2(String w2abl2) {
		this.w2abl2 = w2abl2;
	}

	public String getW2pros() {
		return w2pros;
	}

	public void setW2pros(String w2pros) {
		this.w2pros = w2pros;
	}

	public String getW2akd3() {
		return w2akd3;
	}

	public void setW2akd3(String w2akd3) {
		this.w2akd3 = w2akd3;
	}

	public String getW2asv3() {
		return w2asv3;
	}

	public void setW2asv3(String w2asv3) {
		this.w2asv3 = w2asv3;
	}

	public String getW2asa3() {
		return w2asa3;
	}

	public void setW2asa3(String w2asa3) {
		this.w2asa3 = w2asa3;
	}

	public String getW2agr3() {
		return w2agr3;
	}

	public void setW2agr3(String w2agr3) {
		this.w2agr3 = w2agr3;
	}

	public String getW2abl3() {
		return w2abl3;
	}

	public void setW2abl3(String w2abl3) {
		this.w2abl3 = w2abl3;
	}

	public String getW2val() {
		return w2val;
	}

	public void setW2val(String w2val) {
		this.w2val = w2val;
	}

	public String getW2akd4() {
		return w2akd4;
	}

	public void setW2akd4(String w2akd4) {
		this.w2akd4 = w2akd4;
	}

	public String getW2asv4() {
		return w2asv4;
	}

	public void setW2asv4(String w2asv4) {
		this.w2asv4 = w2asv4;
	}

	public String getW2asa4() {
		return w2asa4;
	}

	public void setW2asa4(String w2asa4) {
		this.w2asa4 = w2asa4;
	}

	public String getW2agr4() {
		return w2agr4;
	}

	public void setW2agr4(String w2agr4) {
		this.w2agr4 = w2agr4;
	}

	public String getW2abl4() {
		return w2abl4;
	}

	public void setW2abl4(String w2abl4) {
		this.w2abl4 = w2abl4;
	}

	public String getW2beln() {
		return w2beln;
	}

	public void setW2beln(String w2beln) {
		this.w2beln = w2beln;
	}

	public String getW2akd5() {
		return w2akd5;
	}

	public void setW2akd5(String w2akd5) {
		this.w2akd5 = w2akd5;
	}

	public String getW2asv5() {
		return w2asv5;
	}

	public void setW2asv5(String w2asv5) {
		this.w2asv5 = w2asv5;
	}

	public String getW2asa5() {
		return w2asa5;
	}

	public void setW2asa5(String w2asa5) {
		this.w2asa5 = w2asa5;
	}

	public String getW2agr5() {
		return w2agr5;
	}

	public void setW2agr5(String w2agr5) {
		this.w2agr5 = w2agr5;
	}

	public String getW2abl5() {
		return w2abl5;
	}

	public void setW2abl5(String w2abl5) {
		this.w2abl5 = w2abl5;
	}

	public String getW2akd6() {
		return w2akd6;
	}

	public void setW2akd6(String w2akd6) {
		this.w2akd6 = w2akd6;
	}

	public String getW2asv6() {
		return w2asv6;
	}

	public void setW2asv6(String w2asv6) {
		this.w2asv6 = w2asv6;
	}

	public String getW2asa6() {
		return w2asa6;
	}

	public void setW2asa6(String w2asa6) {
		this.w2asa6 = w2asa6;
	}

	public String getW2agr6() {
		return w2agr6;
	}

	public void setW2agr6(String w2agr6) {
		this.w2agr6 = w2agr6;
	}

	public String getW2abl6() {
		return w2abl6;
	}

	public void setW2abl6(String w2abl6) {
		this.w2abl6 = w2abl6;
	}

	public String getW2akd7() {
		return w2akd7;
	}

	public void setW2akd7(String w2akd7) {
		this.w2akd7 = w2akd7;
	}

	public String getW2asv7() {
		return w2asv7;
	}

	public void setW2asv7(String w2asv7) {
		this.w2asv7 = w2asv7;
	}

	public String getW2asa7() {
		return w2asa7;
	}

	public void setW2asa7(String w2asa7) {
		this.w2asa7 = w2asa7;
	}

	public String getW2agr7() {
		return w2agr7;
	}

	public void setW2agr7(String w2agr7) {
		this.w2agr7 = w2agr7;
	}

	public String getW2abl7() {
		return w2abl7;
	}

	public void setW2abl7(String w2abl7) {
		this.w2abl7 = w2abl7;
	}

	public String getW2akd8() {
		return w2akd8;
	}

	public void setW2akd8(String w2akd8) {
		this.w2akd8 = w2akd8;
	}

	public String getW2asv8() {
		return w2asv8;
	}

	public void setW2asv8(String w2asv8) {
		this.w2asv8 = w2asv8;
	}

	public String getW2asa8() {
		return w2asa8;
	}

	public void setW2asa8(String w2asa8) {
		this.w2asa8 = w2asa8;
	}

	public String getW2agr8() {
		return w2agr8;
	}

	public void setW2agr8(String w2agr8) {
		this.w2agr8 = w2agr8;
	}

	public String getW2abl8() {
		return w2abl8;
	}

	public void setW2abl8(String w2abl8) {
		this.w2abl8 = w2abl8;
	}

	public String getW2ft01() {
		return w2ft01;
	}

	public void setW2ft01(String w2ft01) {
		this.w2ft01 = w2ft01;
	}

	public String getW2nt01() {
		return w2nt01;
	}

	public void setW2nt01(String w2nt01) {
		this.w2nt01 = w2nt01;
	}

	public String getW2eh01() {
		return w2eh01;
	}

	public void setW2eh01(String w2eh01) {
		this.w2eh01 = w2eh01;
	}

	public String getW2vt01() {
		return w2vt01;
	}

	public void setW2vt01(String w2vt01) {
		this.w2vt01 = w2vt01;
	}

	public String getW2ft02() {
		return w2ft02;
	}

	public void setW2ft02(String w2ft02) {
		this.w2ft02 = w2ft02;
	}

	public String getW2nt02() {
		return w2nt02;
	}

	public void setW2nt02(String w2nt02) {
		this.w2nt02 = w2nt02;
	}

	public String getW2eh02() {
		return w2eh02;
	}

	public void setW2eh02(String w2eh02) {
		this.w2eh02 = w2eh02;
	}

	public String getW2vt02() {
		return w2vt02;
	}

	public void setW2vt02(String w2vt02) {
		this.w2vt02 = w2vt02;
	}

	public String getW2ft03() {
		return w2ft03;
	}

	public void setW2ft03(String w2ft03) {
		this.w2ft03 = w2ft03;
	}

	public String getW2nt03() {
		return w2nt03;
	}

	public void setW2nt03(String w2nt03) {
		this.w2nt03 = w2nt03;
	}

	public String getW2eh03() {
		return w2eh03;
	}

	public void setW2eh03(String w2eh03) {
		this.w2eh03 = w2eh03;
	}

	public String getW2vt03() {
		return w2vt03;
	}

	public void setW2vt03(String w2vt03) {
		this.w2vt03 = w2vt03;
	}

	public String getW2ft04() {
		return w2ft04;
	}

	public void setW2ft04(String w2ft04) {
		this.w2ft04 = w2ft04;
	}

	public String getW2nt04() {
		return w2nt04;
	}

	public void setW2nt04(String w2nt04) {
		this.w2nt04 = w2nt04;
	}

	public String getW2eh04() {
		return w2eh04;
	}

	public void setW2eh04(String w2eh04) {
		this.w2eh04 = w2eh04;
	}

	public String getW2vt04() {
		return w2vt04;
	}

	public void setW2vt04(String w2vt04) {
		this.w2vt04 = w2vt04;
	}

	public String getW2ft05() {
		return w2ft05;
	}

	public void setW2ft05(String w2ft05) {
		this.w2ft05 = w2ft05;
	}

	public String getW2nt05() {
		return w2nt05;
	}

	public void setW2nt05(String w2nt05) {
		this.w2nt05 = w2nt05;
	}

	public String getW2eh05() {
		return w2eh05;
	}

	public void setW2eh05(String w2eh05) {
		this.w2eh05 = w2eh05;
	}

	public String getW2vt05() {
		return w2vt05;
	}

	public void setW2vt05(String w2vt05) {
		this.w2vt05 = w2vt05;
	}

	public String getW2ft06() {
		return w2ft06;
	}

	public void setW2ft06(String w2ft06) {
		this.w2ft06 = w2ft06;
	}

	public String getW2nt06() {
		return w2nt06;
	}

	public void setW2nt06(String w2nt06) {
		this.w2nt06 = w2nt06;
	}

	public String getW2eh06() {
		return w2eh06;
	}

	public void setW2eh06(String w2eh06) {
		this.w2eh06 = w2eh06;
	}

	public String getW2ft07() {
		return w2ft07;
	}

	public void setW2ft07(String w2ft07) {
		this.w2ft07 = w2ft07;
	}

	public String getW2nt07() {
		return w2nt07;
	}

	public void setW2nt07(String w2nt07) {
		this.w2nt07 = w2nt07;
	}

	public String getW2eh07() {
		return w2eh07;
	}

	public void setW2eh07(String w2eh07) {
		this.w2eh07 = w2eh07;
	}

	public String getW2top1() {
		return w2top1;
	}

	public void setW2top1(String w2top1) {
		this.w2top1 = w2top1;
	}

	public String getW2cre1() {
		return w2cre1;
	}

	public void setW2cre1(String w2cre1) {
		this.w2cre1 = w2cre1;
	}

	public String getW2top2() {
		return w2top2;
	}

	public void setW2top2(String w2top2) {
		this.w2top2 = w2top2;
	}

	public String getW2cre2() {
		return w2cre2;
	}

	public void setW2cre2(String w2cre2) {
		this.w2cre2 = w2cre2;
	}

	public String getW2top3() {
		return w2top3;
	}

	public void setW2top3(String w2top3) {
		this.w2top3 = w2top3;
	}

	public String getW2cre3() {
		return w2cre3;
	}

	public void setW2cre3(String w2cre3) {
		this.w2cre3 = w2cre3;
	}

	public String getW2top4() {
		return w2top4;
	}

	public void setW2top4(String w2top4) {
		this.w2top4 = w2top4;
	}

	public String getW2cre4() {
		return w2cre4;
	}

	public void setW2cre4(String w2cre4) {
		this.w2cre4 = w2cre4;
	}

	public String getW2top5() {
		return w2top5;
	}

	public void setW2top5(String w2top5) {
		this.w2top5 = w2top5;
	}

	public String getW2cre5() {
		return w2cre5;
	}

	public void setW2cre5(String w2cre5) {
		this.w2cre5 = w2cre5;
	}

	public String getW2top6() {
		return w2top6;
	}

	public void setW2top6(String w2top6) {
		this.w2top6 = w2top6;
	}

	public String getW2cre6() {
		return w2cre6;
	}

	public void setW2cre6(String w2cre6) {
		this.w2cre6 = w2cre6;
	}

	public String getW2top7() {
		return w2top7;
	}

	public void setW2top7(String w2top7) {
		this.w2top7 = w2top7;
	}

	public String getW2cre7() {
		return w2cre7;
	}

	public void setW2cre7(String w2cre7) {
		this.w2cre7 = w2cre7;
	}

	public String getW2top8() {
		return w2top8;
	}

	public void setW2top8(String w2top8) {
		this.w2top8 = w2top8;
	}

	public String getW2cre8() {
		return w2cre8;
	}

	public void setW2cre8(String w2cre8) {
		this.w2cre8 = w2cre8;
	}

	public String getW2top9() {
		return w2top9;
	}

	public void setW2top9(String w2top9) {
		this.w2top9 = w2top9;
	}

	public String getW2cre9() {
		return w2cre9;
	}

	public void setW2cre9(String w2cre9) {
		this.w2cre9 = w2cre9;
	}

	public String getW2top10() {
		return w2top10;
	}

	public void setW2top10(String w2top10) {
		this.w2top10 = w2top10;
	}

	public String getW2cre10() {
		return w2cre10;
	}

	public void setW2cre10(String w2cre10) {
		this.w2cre10 = w2cre10;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("levenr", levenr);
		keys.put("varenr", varenr);
		return keys;
	}

}
