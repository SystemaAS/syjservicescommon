package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SviwDao implements IDao {

	private int sviw_knnr; // kundnummer 1 8 8 8 0 s //key
	private String sviw_knso; // søkbegrepp 9 43 35 a //key
	private int sviw_kota;// kollital 44 48 5 5 0 s
	private int sviw_kot2;// kollital 49 53 5 5 0 s
	private int sviw_kot3;// kollital 54 58 5 5 0 s
	private int sviw_kot4;// kollital 59 63 5 5 0 s
	private int sviw_kot5;// kollital 64 68 5 5 0 s
	private String sviw_kosl;// kollislag 69 72 4 a
	private String sviw_kos2;// kollislag 73 76 4 a
	private String sviw_kos3;// kollislag 77 80 4 a
	private String sviw_kos4;// kollislag 81 84 4 a
	private String sviw_kos5;// kollislag 85 88 4 a
	private String sviw_vasl;// varubeskrivning 89 158 70 a
	private String sviw_vas2;// varubeskrivning 159 228 70 a
	private String sviw_vas3;// varubeskrivning 229 298 70 a
	private String sviw_vas4;// varubeskrivning 299 368 70 a
	private String sviw_godm;// godsmærkning 439 480 42 a
	private String sviw_god2;// godsmærkning 481 522 42 a
	private String sviw_god3;// godsmærkning 523 564 42 a
	private String sviw_god4;// godsmærkning 565 606 42 a
	private String sviw_god5;// godsmærkning 607 648 42 a
	private int sviw_vano;// varupost nr. 649 653 5 5 0 s
	private String sviw_vata;// varukod taric nr 654 661 8 a
	private String sviw_vati;// varukod till 33:3 662 665 4 a
	private String sviw_vat4;// varukod till 33:4 666 669 4 a
	private String sviw_vat5;// varukod till 33:5 670 673 4 a
	private String sviw_ulkd;// ursprungsland, kod 674 675 2 a
	private BigDecimal sviw_brut;// bruttovikt 676 689 14 14 3 s
	private String sviw_eup1;// førfarande 37:1 690 693 4 a
	private String sviw_eup2;// førfarande 37:2 694 696 3 a
	private BigDecimal sviw_neto;// nettovikt 697 710 14 14 3 s
	private String sviw_kono;// kontigentnummer 711 713 3 a
	private int sviw_ankv;// annan kvantitet 714 723 10 10 0 s
	private String sviw_suko;// særsk.uppl.kod 724 728 5 a
	private String sviw_suk6;// særsk.uppl.kod 729 733 5 a
	private String sviw_sukb;// særsk.uppl.kod 734 738 5 a
	private String sviw_sutx;// særsk.uppl.text 739 808 70 a
	private String sviw_sut2;// særsk.uppl.text 809 878 70 a
	private String sviw_sut3;// særsk.uppl.text 879 948 70 a
	private String sviw_sut4;// særsk.uppl.text 949 1018 70 a
	private String sviw_sut5;// særsk.uppl.text 1019 1088 70 a
	private String sviw_sut6;// særsk.uppl.text 1089 1158 70 a
	private String sviw_sut7;// særsk.uppl.text 1159 1228 70 a
	private String sviw_sut8;// særsk.uppl.text 1229 1298 70 a
	private String sviw_sut9;// særsk.uppl.text 1299 1368 70 a
	private String sviw_suta;// særsk.uppl.text 1369 1438 70 a
	private String sviw_sutb;// særsk.uppl.text 1439 1508 70 a
	private String sviw_sutc;// særsk.uppl.text 1509 1578 70 a
	private String sviw_sutd;// særsk.uppl.text 1579 1648 70 a
	private String sviw_sute;// særsk.uppl.text 1649 1718 70 a
	private String sviw_sutf;// særsk.uppl.text 1719 1788 70 a
	private int sviw_suok;// særsk.uppl.ø.kost 1789 1799 11 11 0 s
	private int sviw_sukr;// særsk.uppl.kassa.r 1800 1810 11 11 0 s
	private int sviw_suar;// særsk.uppl.annan.r 1811 1821 11 11 0 s
	private String sviw_atin;// åtgærdsindikator 1822 1824 3 a
	private int sviw_stva;// stat.værde 1825 1835 11 11 0 s
	private int sviw_stva2;// tullværde 1836 1846 11 11 0 s
	private BigDecimal sviw_fabl;// fakturabelopp 1847 1857 11 11 3 s
	private String sviw_bit1;// bil.handl, typ 1933 1936 4 a
	private String sviw_bit2;// bil.handl, typ 1937 1940 4 a
	private String sviw_bit3;// bil.handl, typ 1941 1944 4 a
	private String sviw_bit4;// bil.handl, typ 1945 1948 4 a
	private String sviw_bit5;// bil.handl, typ 1949 1952 4 a
	private String sviw_bit6;// bil.handl, typ 1953 1956 4 a
	private String sviw_bit7;// bil.handl, typ 1957 1960 4 a
	private String sviw_bit8;// bil.handl, typ 1961 1964 4 a
	private String sviw_bit9;// bil.handl, typ 1965 1968 4 a
	private String sviw_bii1;// bil.handl, id 1969 2003 35 a
	private String sviw_bii2;// bil.handl, id 2004 2038 35 a
	private String sviw_bii3;// bil.handl, id 2039 2073 35 a
	private String sviw_bii4;// bil.handl, id 2074 2108 35 a
	private String sviw_bii5;// bil.handl, id 2109 2143 35 a
	private String sviw_bii6;// bil.handl, id 2144 2178 35 a
	private String sviw_bii7;// bil.handl, id 2179 2213 35 a
	private String sviw_bii8; // bil.handl, id 2214 2248 35 a
	private String sviw_bii9;// bil.handl, id 2249 2283 35 a
	private String sviw_co01;// containernummer 2284 2300 17 a
	private String sviw_co02;// containernummer 2301 2317 17 a
	private String sviw_co03;// containernummer 2318 2334 17 a
	private String sviw_co04;// containernummer 2335 2351 17 a
	private String sviw_co05;// containernummer 2352 2368 17 a
	private String sviw_co06;// containernummer 2369 2385 17 a
	private String sviw_co07;// containernummer 2386 2402 17 a
	private String sviw_co08;// containernummer 2403 2419 17 a
	private String sviw_co09;// containernummer 2420 2436 17 a
	private String sviw_co10;// containernummer 2437 2453 17 a
	private String sviw_co11;// containernummer 2454 2470 17 a
	private String sviw_co12;// containernummer 2471 2487 17 a
	private String sviw_co13;// containernummer 2488 2504 17 a
	private String sviw_co14;// containernummer 2505 2521 17 a
	private String sviw_co15;// containernummer 2522 2538 17 a
	private String sviw_co16;// containernummer 2539 2555 17 a
	private String sviw_co17;// containernummer 2556 2572 17 a
	private String sviw_co18;// containernummer 2573 2589 17 a
	private String sviw_co19;// containernummer 2590 2606 17 a
	private String sviw_co20;// containernummer 2607 2623 17 a
	private String sviw_tik1;// tid.handl. kat 2624 2624 1 a
	private String sviw_tik2;// tid.handl. kat 2625 2625 1 a
	private String sviw_tik3;// tid.handl. kat 2626 2626 1 a
	private String sviw_tik4;// tid.handl. kat 2627 2627 1 a
	private String sviw_tik5;// tid.handl. kat 2628 2628 1 a
	private String sviw_tik6;// tid.handl. kat 2629 2629 1 a
	private String sviw_tik7;// tid.handl. kat 2630 2630 1 a
	private String sviw_tik8;// tid.handl. kat 2631 2631 1 a
	private String sviw_tik9;// tid.handl. kat 2632 2632 1 a
	private String sviw_tit1;// tid.handl. typ 2633 2635 3 a
	private String sviw_tit2;// tid.handl. typ 2636 2638 3 a
	private String sviw_tit3;// tid.handl. typ 2639 2641 3 a
	private String sviw_tit4;// tid.handl. typ 2642 2644 3 a
	private String sviw_tit5;// tid.handl. typ 2645 2647 3 a
	private String sviw_tit6;// tid.handl. typ 2648 2650 3 a
	private String sviw_tit7;// tid.handl. typ 2651 2653 3 a
	private String sviw_tit8;// tid.handl. typ 2654 2656 3 a
	private String sviw_tit9;// tid.handl. typ 2657 2659 3 a
	private String sviw_tix1;// tid.handl. txt 2660 2694 35 a
	private String sviw_tix2;// tid.handl. txt 2695 2729 35 a
	private String sviw_tix3;// tid.handl. txt 2730 2764 35 a
	private String sviw_tix4;// tid.handl. txt 2765 2799 35 a
	private String sviw_tix5;// tid.handl. txt 2800 2834 35 a
	private String sviw_tix6;// tid.handl. txt 2835 2869 35 a
	private String sviw_tix7;// tid.handl. txt 2870 2904 35 a
	private String sviw_tix8;// tid.handl. txt 2905 2939 35 a
	private String sviw_tix9;// tid.handl. txt 2940 2974 35 a
	private String sviw_lagi;// 49.lager id 2975 2988 14 a
	private String sviw_lagt;// 49.lager typ 2989 2989 1 a
	private String sviw_lagl;// 49.lager lk 2990 2991 2 a
	private String sviw_call;// call me 2992 2993 2 a

	Map<String, Object> keys = new HashMap<String, Object>();

	public int getSviw_knnr() {
		return sviw_knnr;
	}

	public void setSviw_knnr(int sviw_knnr) {
		this.sviw_knnr = sviw_knnr;
	}

	public String getSviw_knso() {
		return sviw_knso;
	}

	public void setSviw_knso(String sviw_knso) {
		this.sviw_knso = sviw_knso;
	}

	public int getSviw_kota() {
		return sviw_kota;
	}

	public void setSviw_kota(int sviw_kota) {
		this.sviw_kota = sviw_kota;
	}

	public int getSviw_kot2() {
		return sviw_kot2;
	}

	public void setSviw_kot2(int sviw_kot2) {
		this.sviw_kot2 = sviw_kot2;
	}

	public int getSviw_kot3() {
		return sviw_kot3;
	}

	public void setSviw_kot3(int sviw_kot3) {
		this.sviw_kot3 = sviw_kot3;
	}

	public int getSviw_kot4() {
		return sviw_kot4;
	}

	public void setSviw_kot4(int sviw_kot4) {
		this.sviw_kot4 = sviw_kot4;
	}

	public int getSviw_kot5() {
		return sviw_kot5;
	}

	public void setSviw_kot5(int sviw_kot5) {
		this.sviw_kot5 = sviw_kot5;
	}

	public String getSviw_kosl() {
		return sviw_kosl;
	}

	public void setSviw_kosl(String sviw_kosl) {
		this.sviw_kosl = sviw_kosl;
	}

	public String getSviw_kos2() {
		return sviw_kos2;
	}

	public void setSviw_kos2(String sviw_kos2) {
		this.sviw_kos2 = sviw_kos2;
	}

	public String getSviw_kos3() {
		return sviw_kos3;
	}

	public void setSviw_kos3(String sviw_kos3) {
		this.sviw_kos3 = sviw_kos3;
	}

	public String getSviw_kos4() {
		return sviw_kos4;
	}

	public void setSviw_kos4(String sviw_kos4) {
		this.sviw_kos4 = sviw_kos4;
	}

	public String getSviw_kos5() {
		return sviw_kos5;
	}

	public void setSviw_kos5(String sviw_kos5) {
		this.sviw_kos5 = sviw_kos5;
	}

	public String getSviw_vasl() {
		return sviw_vasl;
	}

	public void setSviw_vasl(String sviw_vasl) {
		this.sviw_vasl = sviw_vasl;
	}

	public String getSviw_vas2() {
		return sviw_vas2;
	}

	public void setSviw_vas2(String sviw_vas2) {
		this.sviw_vas2 = sviw_vas2;
	}

	public String getSviw_vas3() {
		return sviw_vas3;
	}

	public void setSviw_vas3(String sviw_vas3) {
		this.sviw_vas3 = sviw_vas3;
	}

	public String getSviw_vas4() {
		return sviw_vas4;
	}

	public void setSviw_vas4(String sviw_vas4) {
		this.sviw_vas4 = sviw_vas4;
	}

	public String getSviw_godm() {
		return sviw_godm;
	}

	public void setSviw_godm(String sviw_godm) {
		this.sviw_godm = sviw_godm;
	}

	public String getSviw_god2() {
		return sviw_god2;
	}

	public void setSviw_god2(String sviw_god2) {
		this.sviw_god2 = sviw_god2;
	}

	public String getSviw_god3() {
		return sviw_god3;
	}

	public void setSviw_god3(String sviw_god3) {
		this.sviw_god3 = sviw_god3;
	}

	public String getSviw_god4() {
		return sviw_god4;
	}

	public void setSviw_god4(String sviw_god4) {
		this.sviw_god4 = sviw_god4;
	}

	public String getSviw_god5() {
		return sviw_god5;
	}

	public void setSviw_god5(String sviw_god5) {
		this.sviw_god5 = sviw_god5;
	}

	public int getSviw_vano() {
		return sviw_vano;
	}

	public void setSviw_vano(int sviw_vano) {
		this.sviw_vano = sviw_vano;
	}

	public String getSviw_vata() {
		return sviw_vata;
	}

	public void setSviw_vata(String sviw_vata) {
		this.sviw_vata = sviw_vata;
	}

	public String getSviw_vati() {
		return sviw_vati;
	}

	public void setSviw_vati(String sviw_vati) {
		this.sviw_vati = sviw_vati;
	}

	public String getSviw_vat4() {
		return sviw_vat4;
	}

	public void setSviw_vat4(String sviw_vat4) {
		this.sviw_vat4 = sviw_vat4;
	}

	public String getSviw_vat5() {
		return sviw_vat5;
	}

	public void setSviw_vat5(String sviw_vat5) {
		this.sviw_vat5 = sviw_vat5;
	}

	public String getSviw_ulkd() {
		return sviw_ulkd;
	}

	public void setSviw_ulkd(String sviw_ulkd) {
		this.sviw_ulkd = sviw_ulkd;
	}

	public BigDecimal getSviw_brut() {
		return sviw_brut;
	}

	public void setSviw_brut(BigDecimal sviw_brut) {
		this.sviw_brut = sviw_brut;
	}

	public String getSviw_eup1() {
		return sviw_eup1;
	}

	public void setSviw_eup1(String sviw_eup1) {
		this.sviw_eup1 = sviw_eup1;
	}

	public String getSviw_eup2() {
		return sviw_eup2;
	}

	public void setSviw_eup2(String sviw_eup2) {
		this.sviw_eup2 = sviw_eup2;
	}

	public BigDecimal getSviw_neto() {
		return sviw_neto;
	}

	public void setSviw_neto(BigDecimal sviw_neto) {
		this.sviw_neto = sviw_neto;
	}

	public String getSviw_kono() {
		return sviw_kono;
	}

	public void setSviw_kono(String sviw_kono) {
		this.sviw_kono = sviw_kono;
	}

	public int getSviw_ankv() {
		return sviw_ankv;
	}

	public void setSviw_ankv(int sviw_ankv) {
		this.sviw_ankv = sviw_ankv;
	}

	public String getSviw_suko() {
		return sviw_suko;
	}

	public void setSviw_suko(String sviw_suko) {
		this.sviw_suko = sviw_suko;
	}

	public String getSviw_suk6() {
		return sviw_suk6;
	}

	public void setSviw_suk6(String sviw_suk6) {
		this.sviw_suk6 = sviw_suk6;
	}

	public String getSviw_sukb() {
		return sviw_sukb;
	}

	public void setSviw_sukb(String sviw_sukb) {
		this.sviw_sukb = sviw_sukb;
	}

	public String getSviw_sutx() {
		return sviw_sutx;
	}

	public void setSviw_sutx(String sviw_sutx) {
		this.sviw_sutx = sviw_sutx;
	}

	public String getSviw_sut2() {
		return sviw_sut2;
	}

	public void setSviw_sut2(String sviw_sut2) {
		this.sviw_sut2 = sviw_sut2;
	}

	public String getSviw_sut3() {
		return sviw_sut3;
	}

	public void setSviw_sut3(String sviw_sut3) {
		this.sviw_sut3 = sviw_sut3;
	}

	public String getSviw_sut4() {
		return sviw_sut4;
	}

	public void setSviw_sut4(String sviw_sut4) {
		this.sviw_sut4 = sviw_sut4;
	}

	public String getSviw_sut5() {
		return sviw_sut5;
	}

	public void setSviw_sut5(String sviw_sut5) {
		this.sviw_sut5 = sviw_sut5;
	}

	public String getSviw_sut6() {
		return sviw_sut6;
	}

	public void setSviw_sut6(String sviw_sut6) {
		this.sviw_sut6 = sviw_sut6;
	}

	public String getSviw_sut7() {
		return sviw_sut7;
	}

	public void setSviw_sut7(String sviw_sut7) {
		this.sviw_sut7 = sviw_sut7;
	}

	public String getSviw_sut8() {
		return sviw_sut8;
	}

	public void setSviw_sut8(String sviw_sut8) {
		this.sviw_sut8 = sviw_sut8;
	}

	public String getSviw_sut9() {
		return sviw_sut9;
	}

	public void setSviw_sut9(String sviw_sut9) {
		this.sviw_sut9 = sviw_sut9;
	}

	public String getSviw_suta() {
		return sviw_suta;
	}

	public void setSviw_suta(String sviw_suta) {
		this.sviw_suta = sviw_suta;
	}

	public String getSviw_sutb() {
		return sviw_sutb;
	}

	public void setSviw_sutb(String sviw_sutb) {
		this.sviw_sutb = sviw_sutb;
	}

	public String getSviw_sutc() {
		return sviw_sutc;
	}

	public void setSviw_sutc(String sviw_sutc) {
		this.sviw_sutc = sviw_sutc;
	}

	public String getSviw_sutd() {
		return sviw_sutd;
	}

	public void setSviw_sutd(String sviw_sutd) {
		this.sviw_sutd = sviw_sutd;
	}

	public String getSviw_sute() {
		return sviw_sute;
	}

	public void setSviw_sute(String sviw_sute) {
		this.sviw_sute = sviw_sute;
	}

	public String getSviw_sutf() {
		return sviw_sutf;
	}

	public void setSviw_sutf(String sviw_sutf) {
		this.sviw_sutf = sviw_sutf;
	}

	public int getSviw_suok() {
		return sviw_suok;
	}

	public void setSviw_suok(int sviw_suok) {
		this.sviw_suok = sviw_suok;
	}

	public int getSviw_sukr() {
		return sviw_sukr;
	}

	public void setSviw_sukr(int sviw_sukr) {
		this.sviw_sukr = sviw_sukr;
	}

	public int getSviw_suar() {
		return sviw_suar;
	}

	public void setSviw_suar(int sviw_suar) {
		this.sviw_suar = sviw_suar;
	}

	public String getSviw_atin() {
		return sviw_atin;
	}

	public void setSviw_atin(String sviw_atin) {
		this.sviw_atin = sviw_atin;
	}

	public int getSviw_stva() {
		return sviw_stva;
	}

	public void setSviw_stva(int sviw_stva) {
		this.sviw_stva = sviw_stva;
	}

	public int getSviw_stva2() {
		return sviw_stva2;
	}

	public void setSviw_stva2(int sviw_stva2) {
		this.sviw_stva2 = sviw_stva2;
	}

	public BigDecimal getSviw_fabl() {
		return sviw_fabl;
	}

	public void setSviw_fabl(BigDecimal sviw_fabl) {
		this.sviw_fabl = sviw_fabl;
	}

	public String getSviw_bit1() {
		return sviw_bit1;
	}

	public void setSviw_bit1(String sviw_bit1) {
		this.sviw_bit1 = sviw_bit1;
	}

	public String getSviw_bit2() {
		return sviw_bit2;
	}

	public void setSviw_bit2(String sviw_bit2) {
		this.sviw_bit2 = sviw_bit2;
	}

	public String getSviw_bit3() {
		return sviw_bit3;
	}

	public void setSviw_bit3(String sviw_bit3) {
		this.sviw_bit3 = sviw_bit3;
	}

	public String getSviw_bit4() {
		return sviw_bit4;
	}

	public void setSviw_bit4(String sviw_bit4) {
		this.sviw_bit4 = sviw_bit4;
	}

	public String getSviw_bit5() {
		return sviw_bit5;
	}

	public void setSviw_bit5(String sviw_bit5) {
		this.sviw_bit5 = sviw_bit5;
	}

	public String getSviw_bit6() {
		return sviw_bit6;
	}

	public void setSviw_bit6(String sviw_bit6) {
		this.sviw_bit6 = sviw_bit6;
	}

	public String getSviw_bit7() {
		return sviw_bit7;
	}

	public void setSviw_bit7(String sviw_bit7) {
		this.sviw_bit7 = sviw_bit7;
	}

	public String getSviw_bit8() {
		return sviw_bit8;
	}

	public void setSviw_bit8(String sviw_bit8) {
		this.sviw_bit8 = sviw_bit8;
	}

	public String getSviw_bit9() {
		return sviw_bit9;
	}

	public void setSviw_bit9(String sviw_bit9) {
		this.sviw_bit9 = sviw_bit9;
	}

	public String getSviw_bii1() {
		return sviw_bii1;
	}

	public void setSviw_bii1(String sviw_bii1) {
		this.sviw_bii1 = sviw_bii1;
	}

	public String getSviw_bii2() {
		return sviw_bii2;
	}

	public void setSviw_bii2(String sviw_bii2) {
		this.sviw_bii2 = sviw_bii2;
	}

	public String getSviw_bii3() {
		return sviw_bii3;
	}

	public void setSviw_bii3(String sviw_bii3) {
		this.sviw_bii3 = sviw_bii3;
	}

	public String getSviw_bii4() {
		return sviw_bii4;
	}

	public void setSviw_bii4(String sviw_bii4) {
		this.sviw_bii4 = sviw_bii4;
	}

	public String getSviw_bii5() {
		return sviw_bii5;
	}

	public void setSviw_bii5(String sviw_bii5) {
		this.sviw_bii5 = sviw_bii5;
	}

	public String getSviw_bii6() {
		return sviw_bii6;
	}

	public void setSviw_bii6(String sviw_bii6) {
		this.sviw_bii6 = sviw_bii6;
	}

	public String getSviw_bii7() {
		return sviw_bii7;
	}

	public void setSviw_bii7(String sviw_bii7) {
		this.sviw_bii7 = sviw_bii7;
	}

	public String getSviw_bii8() {
		return sviw_bii8;
	}

	public void setSviw_bii8(String sviw_bii8) {
		this.sviw_bii8 = sviw_bii8;
	}

	public String getSviw_bii9() {
		return sviw_bii9;
	}

	public void setSviw_bii9(String sviw_bii9) {
		this.sviw_bii9 = sviw_bii9;
	}

	public String getSviw_co01() {
		return sviw_co01;
	}

	public void setSviw_co01(String sviw_co01) {
		this.sviw_co01 = sviw_co01;
	}

	public String getSviw_co02() {
		return sviw_co02;
	}

	public void setSviw_co02(String sviw_co02) {
		this.sviw_co02 = sviw_co02;
	}

	public String getSviw_co03() {
		return sviw_co03;
	}

	public void setSviw_co03(String sviw_co03) {
		this.sviw_co03 = sviw_co03;
	}

	public String getSviw_co04() {
		return sviw_co04;
	}

	public void setSviw_co04(String sviw_co04) {
		this.sviw_co04 = sviw_co04;
	}

	public String getSviw_co05() {
		return sviw_co05;
	}

	public void setSviw_co05(String sviw_co05) {
		this.sviw_co05 = sviw_co05;
	}

	public String getSviw_co06() {
		return sviw_co06;
	}

	public void setSviw_co06(String sviw_co06) {
		this.sviw_co06 = sviw_co06;
	}

	public String getSviw_co07() {
		return sviw_co07;
	}

	public void setSviw_co07(String sviw_co07) {
		this.sviw_co07 = sviw_co07;
	}

	public String getSviw_co08() {
		return sviw_co08;
	}

	public void setSviw_co08(String sviw_co08) {
		this.sviw_co08 = sviw_co08;
	}

	public String getSviw_co09() {
		return sviw_co09;
	}

	public void setSviw_co09(String sviw_co09) {
		this.sviw_co09 = sviw_co09;
	}

	public String getSviw_co10() {
		return sviw_co10;
	}

	public void setSviw_co10(String sviw_co10) {
		this.sviw_co10 = sviw_co10;
	}

	public String getSviw_co11() {
		return sviw_co11;
	}

	public void setSviw_co11(String sviw_co11) {
		this.sviw_co11 = sviw_co11;
	}

	public String getSviw_co12() {
		return sviw_co12;
	}

	public void setSviw_co12(String sviw_co12) {
		this.sviw_co12 = sviw_co12;
	}

	public String getSviw_co13() {
		return sviw_co13;
	}

	public void setSviw_co13(String sviw_co13) {
		this.sviw_co13 = sviw_co13;
	}

	public String getSviw_co14() {
		return sviw_co14;
	}

	public void setSviw_co14(String sviw_co14) {
		this.sviw_co14 = sviw_co14;
	}

	public String getSviw_co15() {
		return sviw_co15;
	}

	public void setSviw_co15(String sviw_co15) {
		this.sviw_co15 = sviw_co15;
	}

	public String getSviw_co16() {
		return sviw_co16;
	}

	public void setSviw_co16(String sviw_co16) {
		this.sviw_co16 = sviw_co16;
	}

	public String getSviw_co17() {
		return sviw_co17;
	}

	public void setSviw_co17(String sviw_co17) {
		this.sviw_co17 = sviw_co17;
	}

	public String getSviw_co18() {
		return sviw_co18;
	}

	public void setSviw_co18(String sviw_co18) {
		this.sviw_co18 = sviw_co18;
	}

	public String getSviw_co19() {
		return sviw_co19;
	}

	public void setSviw_co19(String sviw_co19) {
		this.sviw_co19 = sviw_co19;
	}

	public String getSviw_co20() {
		return sviw_co20;
	}

	public void setSviw_co20(String sviw_co20) {
		this.sviw_co20 = sviw_co20;
	}

	public String getSviw_tik1() {
		return sviw_tik1;
	}

	public void setSviw_tik1(String sviw_tik1) {
		this.sviw_tik1 = sviw_tik1;
	}

	public String getSviw_tik2() {
		return sviw_tik2;
	}

	public void setSviw_tik2(String sviw_tik2) {
		this.sviw_tik2 = sviw_tik2;
	}

	public String getSviw_tik3() {
		return sviw_tik3;
	}

	public void setSviw_tik3(String sviw_tik3) {
		this.sviw_tik3 = sviw_tik3;
	}

	public String getSviw_tik4() {
		return sviw_tik4;
	}

	public void setSviw_tik4(String sviw_tik4) {
		this.sviw_tik4 = sviw_tik4;
	}

	public String getSviw_tik5() {
		return sviw_tik5;
	}

	public void setSviw_tik5(String sviw_tik5) {
		this.sviw_tik5 = sviw_tik5;
	}

	public String getSviw_tik6() {
		return sviw_tik6;
	}

	public void setSviw_tik6(String sviw_tik6) {
		this.sviw_tik6 = sviw_tik6;
	}

	public String getSviw_tik7() {
		return sviw_tik7;
	}

	public void setSviw_tik7(String sviw_tik7) {
		this.sviw_tik7 = sviw_tik7;
	}

	public String getSviw_tik8() {
		return sviw_tik8;
	}

	public void setSviw_tik8(String sviw_tik8) {
		this.sviw_tik8 = sviw_tik8;
	}

	public String getSviw_tik9() {
		return sviw_tik9;
	}

	public void setSviw_tik9(String sviw_tik9) {
		this.sviw_tik9 = sviw_tik9;
	}

	public String getSviw_tit1() {
		return sviw_tit1;
	}

	public void setSviw_tit1(String sviw_tit1) {
		this.sviw_tit1 = sviw_tit1;
	}

	public String getSviw_tit2() {
		return sviw_tit2;
	}

	public void setSviw_tit2(String sviw_tit2) {
		this.sviw_tit2 = sviw_tit2;
	}

	public String getSviw_tit3() {
		return sviw_tit3;
	}

	public void setSviw_tit3(String sviw_tit3) {
		this.sviw_tit3 = sviw_tit3;
	}

	public String getSviw_tit4() {
		return sviw_tit4;
	}

	public void setSviw_tit4(String sviw_tit4) {
		this.sviw_tit4 = sviw_tit4;
	}

	public String getSviw_tit5() {
		return sviw_tit5;
	}

	public void setSviw_tit5(String sviw_tit5) {
		this.sviw_tit5 = sviw_tit5;
	}

	public String getSviw_tit6() {
		return sviw_tit6;
	}

	public void setSviw_tit6(String sviw_tit6) {
		this.sviw_tit6 = sviw_tit6;
	}

	public String getSviw_tit7() {
		return sviw_tit7;
	}

	public void setSviw_tit7(String sviw_tit7) {
		this.sviw_tit7 = sviw_tit7;
	}

	public String getSviw_tit8() {
		return sviw_tit8;
	}

	public void setSviw_tit8(String sviw_tit8) {
		this.sviw_tit8 = sviw_tit8;
	}

	public String getSviw_tit9() {
		return sviw_tit9;
	}

	public void setSviw_tit9(String sviw_tit9) {
		this.sviw_tit9 = sviw_tit9;
	}

	public String getSviw_tix1() {
		return sviw_tix1;
	}

	public void setSviw_tix1(String sviw_tix1) {
		this.sviw_tix1 = sviw_tix1;
	}

	public String getSviw_tix2() {
		return sviw_tix2;
	}

	public void setSviw_tix2(String sviw_tix2) {
		this.sviw_tix2 = sviw_tix2;
	}

	public String getSviw_tix3() {
		return sviw_tix3;
	}

	public void setSviw_tix3(String sviw_tix3) {
		this.sviw_tix3 = sviw_tix3;
	}

	public String getSviw_tix4() {
		return sviw_tix4;
	}

	public void setSviw_tix4(String sviw_tix4) {
		this.sviw_tix4 = sviw_tix4;
	}

	public String getSviw_tix5() {
		return sviw_tix5;
	}

	public void setSviw_tix5(String sviw_tix5) {
		this.sviw_tix5 = sviw_tix5;
	}

	public String getSviw_tix6() {
		return sviw_tix6;
	}

	public void setSviw_tix6(String sviw_tix6) {
		this.sviw_tix6 = sviw_tix6;
	}

	public String getSviw_tix7() {
		return sviw_tix7;
	}

	public void setSviw_tix7(String sviw_tix7) {
		this.sviw_tix7 = sviw_tix7;
	}

	public String getSviw_tix8() {
		return sviw_tix8;
	}

	public void setSviw_tix8(String sviw_tix8) {
		this.sviw_tix8 = sviw_tix8;
	}

	public String getSviw_tix9() {
		return sviw_tix9;
	}

	public void setSviw_tix9(String sviw_tix9) {
		this.sviw_tix9 = sviw_tix9;
	}

	public String getSviw_lagi() {
		return sviw_lagi;
	}

	public void setSviw_lagi(String sviw_lagi) {
		this.sviw_lagi = sviw_lagi;
	}

	public String getSviw_lagt() {
		return sviw_lagt;
	}

	public void setSviw_lagt(String sviw_lagt) {
		this.sviw_lagt = sviw_lagt;
	}

	public String getSviw_lagl() {
		return sviw_lagl;
	}

	public void setSviw_lagl(String sviw_lagl) {
		this.sviw_lagl = sviw_lagl;
	}

	public String getSviw_call() {
		return sviw_call;
	}

	public void setSviw_call(String sviw_call) {
		this.sviw_call = sviw_call;
	}

	@Override
	public Map<String, Object> getKeys() { 
		keys.put("sviw_knnr", sviw_knnr);
		keys.put("sviw_knso", sviw_knso);
		return keys;
	}

}
