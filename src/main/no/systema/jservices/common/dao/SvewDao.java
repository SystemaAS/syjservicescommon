package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class SvewDao implements IDao {

	private int svew_knnr; // kundnummer 1 8 8 8 0 s //key
	private String svew_knso; // søkbegrepp 9 43 35 a //key
	private int svew_kota;// kollital 44 48 5 5 0 s
	private int svew_kot2;// kollital 49 53 5 5 0 s
	private int svew_kot3;// kollital 54 58 5 5 0 s
	private int svew_kot4;// kollital 59 63 5 5 0 s
	private int svew_kot5;// kollital 64 68 5 5 0 s
	private String svew_kosl;// kollislag 69 72 4 a
	private String svew_kos2;// kollislag 73 76 4 a
	private String svew_kos3;// kollislag 77 80 4 a
	private String svew_kos4;// kollislag 81 84 4 a
	private String svew_kos5;// kollislag 85 88 4 a
	private String svew_vasl;// varubeskrivning 89 158 70 a
	private String svew_vas2;// varubeskrivning 159 228 70 a
	private String svew_vas3;// varubeskrivning 229 298 70 a
	private String svew_vas4;// varubeskrivning 299 368 70 a
	private String svew_vas5;// varubeskrivning 369 438 70 a
	private String svew_godm;// godsmærkning 439 480 42 a
	private String svew_god2;// godsmærkning 481 522 42 a
	private String svew_god3;// godsmærkning 523 564 42 a
	private String svew_god4;// godsmærkning 565 606 42 a
	private String svew_god5;// godsmærkning 607 648 42 a
	private int svew_vano;// varupost nr. 649 653 5 5 0 s 
	private String svew_vata;// varukod taric nr 654 661 8 a
	private String svew_vati;// varukod till 33:3 662 665 4 a
	private String svew_vat4;// varukod till 33:4 666 669 4 a
	private String svew_vat5;// varukod till 33:5 670 673 4 a
	private String svew_ulkd;// ursprungsland, kod 674 675 2 a
	private int svew_brut;// bruttovikt 676 689 14 14 3 s
	private String svew_eup1;// førfarande 37:1 690 693 4 a
	private String svew_eup2;// førfarande 37:2 694 696 3 a
	private int svew_neto;// nettovikt 697 710 14 14 3 s
	private String svew_kono;// kontigentnummer 711 713 3 a
	private int svew_ankv;// annan kvantitet 714 723 10 10 0 s
	private String svew_suko;// særsk.uppl.kod 724 728 5 a
	private String svew_suk6;// særsk.uppl.kod 729 733 5 a
	private String svew_sukb;// særsk.uppl.kod 734 738 5 a
	private String svew_sutx;// særsk.uppl.text 739 808 70 a
	private String svew_sut2;// særsk.uppl.text 809 878 70 a
	private String svew_sut3;// særsk.uppl.text 879 948 70 a
	private String svew_sut4;// særsk.uppl.text 949 1018 70 a
	private String svew_sut5;// særsk.uppl.text 1019 1088 70 a
	private String svew_sut6;// særsk.uppl.text 1089 1158 70 a
	private String svew_sut7;// særsk.uppl.text 1159 1228 70 a
	private String svew_sut8;// særsk.uppl.text 1229 1298 70 a
	private String svew_sut9;// særsk.uppl.text 1299 1368 70 a
	private String svew_suta;// særsk.uppl.text 1369 1438 70 a
	private String svew_sutb;// særsk.uppl.text 1439 1508 70 a
	private String svew_sutc;// særsk.uppl.text 1509 1578 70 a
	private String svew_sutd;// særsk.uppl.text 1579 1648 70 a
	private String svew_sute;// særsk.uppl.text 1649 1718 70 a
	private String svew_sutf;// særsk.uppl.text 1719 1788 70 a
	private int svew_suok;// særsk.uppl.ø.kost 1789 1799 11 11 0 s
	private int svew_sukr;// særsk.uppl.kassa.r 1800 1810 11 11 0 s
	private int svew_suar;// særsk.uppl.annan.r 1811 1821 11 11 0 s
	private String svew_atin;// åtgærdsindikator 1822 1824 3 a
	private int svew_stva;// stat.værde 1825 1835 11 11 0 s
	private int svew_stva2;// tullværde 1836 1846 11 11 0 s
	private int svew_fabl;// fakturabelopp 1847 1857 11 11 3 s
	private String svew_betk;// betalkod transp 1858 1858 1 a
	private String svew_komr;// komm refnr 1859 1928 70 a
	private String svew_fnkd;// fn kod fg 1929 1932 4 a
	private String svew_bit1;// bil.handl, typ 1933 1936 4 a
	private String svew_bit2;// bil.handl, typ 1937 1940 4 a
	private String svew_bit3;// bil.handl, typ 1941 1944 4 a
	private String svew_bit4;// bil.handl, typ 1945 1948 4 a
	private String svew_bit5;// bil.handl, typ 1949 1952 4 a
	private String svew_bit6;// bil.handl, typ 1953 1956 4 a
	private String svew_bit7;// bil.handl, typ 1957 1960 4 a
	private String svew_bit8;// bil.handl, typ 1961 1964 4 a
	private String svew_bit9;// bil.handl, typ 1965 1968 4 a
	private String svew_bii1;// bil.handl, id 1969 2003 35 a
	private String svew_bii2;// bil.handl, id 2004 2038 35 a
	private String svew_bii3;// bil.handl, id 2039 2073 35 a
	private String svew_bii4;// bil.handl, id 2074 2108 35 a
	private String svew_bii5;// bil.handl, id 2109 2143 35 a
	private String svew_bii6;// bil.handl, id 2144 2178 35 a
	private String svew_bii7;// bil.handl, id 2179 2213 35 a
	private String svew_bii8; // bil.handl, id 2214 2248 35 a
	private String svew_bii9;// bil.handl, id 2249 2283 35 a
	private String svew_co01;// containernummer 2284 2300 17 a
	private String svew_co02;// containernummer 2301 2317 17 a
	private String svew_co03;// containernummer 2318 2334 17 a
	private String svew_co04;// containernummer 2335 2351 17 a
	private String svew_co05;// containernummer 2352 2368 17 a
	private String svew_co06;// containernummer 2369 2385 17 a
	private String svew_co07;// containernummer 2386 2402 17 a
	private String svew_co08;// containernummer 2403 2419 17 a
	private String svew_co09;// containernummer 2420 2436 17 a
	private String svew_co10;// containernummer 2437 2453 17 a
	private String svew_co11;// containernummer 2454 2470 17 a
	private String svew_co12;// containernummer 2471 2487 17 a
	private String svew_co13;// containernummer 2488 2504 17 a
	private String svew_co14;// containernummer 2505 2521 17 a
	private String svew_co15;// containernummer 2522 2538 17 a
	private String svew_co16;// containernummer 2539 2555 17 a
	private String svew_co17;// containernummer 2556 2572 17 a
	private String svew_co18;// containernummer 2573 2589 17 a
	private String svew_co19;// containernummer 2590 2606 17 a
	private String svew_co20;// containernummer 2607 2623 17 a
	private String svew_tik1;// tid.handl. kat 2624 2624 1 a
	private String svew_tik2;// tid.handl. kat 2625 2625 1 a
	private String svew_tik3;// tid.handl. kat 2626 2626 1 a
	private String svew_tik4;// tid.handl. kat 2627 2627 1 a
	private String svew_tik5;// tid.handl. kat 2628 2628 1 a
	private String svew_tik6;// tid.handl. kat 2629 2629 1 a
	private String svew_tik7;// tid.handl. kat 2630 2630 1 a
	private String svew_tik8;// tid.handl. kat 2631 2631 1 a
	private String svew_tik9;// tid.handl. kat 2632 2632 1 a
	private String svew_tit1;// tid.handl. typ 2633 2635 3 a
	private String svew_tit2;// tid.handl. typ 2636 2638 3 a
	private String svew_tit3;// tid.handl. typ 2639 2641 3 a
	private String svew_tit4;// tid.handl. typ 2642 2644 3 a
	private String svew_tit5;// tid.handl. typ 2645 2647 3 a
	private String svew_tit6;// tid.handl. typ 2648 2650 3 a
	private String svew_tit7;// tid.handl. typ 2651 2653 3 a
	private String svew_tit8;// tid.handl. typ 2654 2656 3 a
	private String svew_tit9;// tid.handl. typ 2657 2659 3 a
	private String svew_tix1;// tid.handl. txt 2660 2694 35 a
	private String svew_tix2;// tid.handl. txt 2695 2729 35 a
	private String svew_tix3;// tid.handl. txt 2730 2764 35 a
	private String svew_tix4;// tid.handl. txt 2765 2799 35 a
	private String svew_tix5;// tid.handl. txt 2800 2834 35 a
	private String svew_tix6;// tid.handl. txt 2835 2869 35 a
	private String svew_tix7;// tid.handl. txt 2870 2904 35 a
	private String svew_tix8;// tid.handl. txt 2905 2939 35 a
	private String svew_tix9;// tid.handl. txt 2940 2974 35 a
	private String svew_lagi;// 49.lager id 2975 2988 14 a
	private String svew_lagt;// 49.lager typ 2989 2989 1 a
	private String svew_lagl;// 49.lager lk 2990 2991 2 a
	private String svew_call;// call me 2992 2993 2 a

	Map<String, Object> keys = new HashMap<String, Object>();

	public int getSvew_knnr() {
		return svew_knnr;
	}

	public void setSvew_knnr(int svew_knnr) {
		this.svew_knnr = svew_knnr;
	}

	public String getSvew_knso() {
		return svew_knso;
	}

	public void setSvew_knso(String svew_knso) {
		this.svew_knso = svew_knso;
	}

	public int getSvew_kota() {
		return svew_kota;
	}

	public void setSvew_kota(int svew_kota) {
		this.svew_kota = svew_kota;
	}

	public int getSvew_kot2() {
		return svew_kot2;
	}

	public void setSvew_kot2(int svew_kot2) {
		this.svew_kot2 = svew_kot2;
	}

	public int getSvew_kot3() {
		return svew_kot3;
	}

	public void setSvew_kot3(int svew_kot3) {
		this.svew_kot3 = svew_kot3;
	}

	public int getSvew_kot4() {
		return svew_kot4;
	}

	public void setSvew_kot4(int svew_kot4) {
		this.svew_kot4 = svew_kot4;
	}

	public int getSvew_kot5() {
		return svew_kot5;
	}

	public void setSvew_kot5(int svew_kot5) {
		this.svew_kot5 = svew_kot5;
	}

	public String getSvew_kosl() {
		return svew_kosl;
	}

	public void setSvew_kosl(String svew_kosl) {
		this.svew_kosl = svew_kosl;
	}

	public String getSvew_kos2() {
		return svew_kos2;
	}

	public void setSvew_kos2(String svew_kos2) {
		this.svew_kos2 = svew_kos2;
	}

	public String getSvew_kos3() {
		return svew_kos3;
	}

	public void setSvew_kos3(String svew_kos3) {
		this.svew_kos3 = svew_kos3;
	}

	public String getSvew_kos4() {
		return svew_kos4;
	}

	public void setSvew_kos4(String svew_kos4) {
		this.svew_kos4 = svew_kos4;
	}

	public String getSvew_kos5() {
		return svew_kos5;
	}

	public void setSvew_kos5(String svew_kos5) {
		this.svew_kos5 = svew_kos5;
	}

	public String getSvew_vasl() {
		return svew_vasl;
	}

	public void setSvew_vasl(String svew_vasl) {
		this.svew_vasl = svew_vasl;
	}

	public String getSvew_vas2() {
		return svew_vas2;
	}

	public void setSvew_vas2(String svew_vas2) {
		this.svew_vas2 = svew_vas2;
	}

	public String getSvew_vas3() {
		return svew_vas3;
	}

	public void setSvew_vas3(String svew_vas3) {
		this.svew_vas3 = svew_vas3;
	}

	public String getSvew_vas4() {
		return svew_vas4;
	}

	public void setSvew_vas4(String svew_vas4) {
		this.svew_vas4 = svew_vas4;
	}

	public String getSvew_vas5() {
		return svew_vas5;
	}

	public void setSvew_vas5(String svew_vas5) {
		this.svew_vas5 = svew_vas5;
	}

	public String getSvew_godm() {
		return svew_godm;
	}

	public void setSvew_godm(String svew_godm) {
		this.svew_godm = svew_godm;
	}

	public String getSvew_god2() {
		return svew_god2;
	}

	public void setSvew_god2(String svew_god2) {
		this.svew_god2 = svew_god2;
	}

	public String getSvew_god3() {
		return svew_god3;
	}

	public void setSvew_god3(String svew_god3) {
		this.svew_god3 = svew_god3;
	}

	public String getSvew_god4() {
		return svew_god4;
	}

	public void setSvew_god4(String svew_god4) {
		this.svew_god4 = svew_god4;
	}

	public String getSvew_god5() {
		return svew_god5;
	}

	public void setSvew_god5(String svew_god5) {
		this.svew_god5 = svew_god5;
	}

	public int getSvew_vano() {
		return svew_vano;
	}

	public void setSvew_vano(int svew_vano) {
		this.svew_vano = svew_vano;
	}

	public String getSvew_vata() {
		return svew_vata;
	}

	public void setSvew_vata(String svew_vata) {
		this.svew_vata = svew_vata;
	}

	public String getSvew_vati() {
		return svew_vati;
	}

	public void setSvew_vati(String svew_vati) {
		this.svew_vati = svew_vati;
	}

	public String getSvew_vat4() {
		return svew_vat4;
	}

	public void setSvew_vat4(String svew_vat4) {
		this.svew_vat4 = svew_vat4;
	}

	public String getSvew_vat5() {
		return svew_vat5;
	}

	public void setSvew_vat5(String svew_vat5) {
		this.svew_vat5 = svew_vat5;
	}

	public String getSvew_ulkd() {
		return svew_ulkd;
	}

	public void setSvew_ulkd(String svew_ulkd) {
		this.svew_ulkd = svew_ulkd;
	}

	public int getSvew_brut() {
		return svew_brut;
	}

	public void setSvew_brut(int svew_brut) {
		this.svew_brut = svew_brut;
	}

	public String getSvew_eup1() {
		return svew_eup1;
	}

	public void setSvew_eup1(String svew_eup1) {
		this.svew_eup1 = svew_eup1;
	}

	public String getSvew_eup2() {
		return svew_eup2;
	}

	public void setSvew_eup2(String svew_eup2) {
		this.svew_eup2 = svew_eup2;
	}

	public int getSvew_neto() {
		return svew_neto;
	}

	public void setSvew_neto(int svew_neto) {
		this.svew_neto = svew_neto;
	}

	public String getSvew_kono() {
		return svew_kono;
	}

	public void setSvew_kono(String svew_kono) {
		this.svew_kono = svew_kono;
	}

	public int getSvew_ankv() {
		return svew_ankv;
	}

	public void setSvew_ankv(int svew_ankv) {
		this.svew_ankv = svew_ankv;
	}

	public String getSvew_suko() {
		return svew_suko;
	}

	public void setSvew_suko(String svew_suko) {
		this.svew_suko = svew_suko;
	}

	public String getSvew_suk6() {
		return svew_suk6;
	}

	public void setSvew_suk6(String svew_suk6) {
		this.svew_suk6 = svew_suk6;
	}

	public String getSvew_sukb() {
		return svew_sukb;
	}

	public void setSvew_sukb(String svew_sukb) {
		this.svew_sukb = svew_sukb;
	}

	public String getSvew_sutx() {
		return svew_sutx;
	}

	public void setSvew_sutx(String svew_sutx) {
		this.svew_sutx = svew_sutx;
	}

	public String getSvew_sut2() {
		return svew_sut2;
	}

	public void setSvew_sut2(String svew_sut2) {
		this.svew_sut2 = svew_sut2;
	}

	public String getSvew_sut3() {
		return svew_sut3;
	}

	public void setSvew_sut3(String svew_sut3) {
		this.svew_sut3 = svew_sut3;
	}

	public String getSvew_sut4() {
		return svew_sut4;
	}

	public void setSvew_sut4(String svew_sut4) {
		this.svew_sut4 = svew_sut4;
	}

	public String getSvew_sut5() {
		return svew_sut5;
	}

	public void setSvew_sut5(String svew_sut5) {
		this.svew_sut5 = svew_sut5;
	}

	public String getSvew_sut6() {
		return svew_sut6;
	}

	public void setSvew_sut6(String svew_sut6) {
		this.svew_sut6 = svew_sut6;
	}

	public String getSvew_sut7() {
		return svew_sut7;
	}

	public void setSvew_sut7(String svew_sut7) {
		this.svew_sut7 = svew_sut7;
	}

	public String getSvew_sut8() {
		return svew_sut8;
	}

	public void setSvew_sut8(String svew_sut8) {
		this.svew_sut8 = svew_sut8;
	}

	public String getSvew_sut9() {
		return svew_sut9;
	}

	public void setSvew_sut9(String svew_sut9) {
		this.svew_sut9 = svew_sut9;
	}

	public String getSvew_suta() {
		return svew_suta;
	}

	public void setSvew_suta(String svew_suta) {
		this.svew_suta = svew_suta;
	}

	public String getSvew_sutb() {
		return svew_sutb;
	}

	public void setSvew_sutb(String svew_sutb) {
		this.svew_sutb = svew_sutb;
	}

	public String getSvew_sutc() {
		return svew_sutc;
	}

	public void setSvew_sutc(String svew_sutc) {
		this.svew_sutc = svew_sutc;
	}

	public String getSvew_sutd() {
		return svew_sutd;
	}

	public void setSvew_sutd(String svew_sutd) {
		this.svew_sutd = svew_sutd;
	}

	public String getSvew_sute() {
		return svew_sute;
	}

	public void setSvew_sute(String svew_sute) {
		this.svew_sute = svew_sute;
	}

	public String getSvew_sutf() {
		return svew_sutf;
	}

	public void setSvew_sutf(String svew_sutf) {
		this.svew_sutf = svew_sutf;
	}

	public int getSvew_suok() {
		return svew_suok;
	}

	public void setSvew_suok(int svew_suok) {
		this.svew_suok = svew_suok;
	}

	public int getSvew_sukr() {
		return svew_sukr;
	}

	public void setSvew_sukr(int svew_sukr) {
		this.svew_sukr = svew_sukr;
	}

	public int getSvew_suar() {
		return svew_suar;
	}

	public void setSvew_suar(int svew_suar) {
		this.svew_suar = svew_suar;
	}

	public String getSvew_atin() {
		return svew_atin;
	}

	public void setSvew_atin(String svew_atin) {
		this.svew_atin = svew_atin;
	}

	public int getSvew_stva() {
		return svew_stva;
	}

	public void setSvew_stva(int svew_stva) {
		this.svew_stva = svew_stva;
	}

	public int getSvew_stva2() {
		return svew_stva2;
	}

	public void setSvew_stva2(int svew_stva2) {
		this.svew_stva2 = svew_stva2;
	}

	public int getSvew_fabl() {
		return svew_fabl;
	}

	public void setSvew_fabl(int svew_fabl) {
		this.svew_fabl = svew_fabl;
	}

	public String getSvew_betk() {
		return svew_betk;
	}

	public void setSvew_betk(String svew_betk) {
		this.svew_betk = svew_betk;
	}

	public String getSvew_komr() {
		return svew_komr;
	}

	public void setSvew_komr(String svew_komr) {
		this.svew_komr = svew_komr;
	}

	public String getSvew_fnkd() {
		return svew_fnkd;
	}

	public void setSvew_fnkd(String svew_fnkd) {
		this.svew_fnkd = svew_fnkd;
	}

	public String getSvew_bit1() {
		return svew_bit1;
	}

	public void setSvew_bit1(String svew_bit1) {
		this.svew_bit1 = svew_bit1;
	}

	public String getSvew_bit2() {
		return svew_bit2;
	}

	public void setSvew_bit2(String svew_bit2) {
		this.svew_bit2 = svew_bit2;
	}

	public String getSvew_bit3() {
		return svew_bit3;
	}

	public void setSvew_bit3(String svew_bit3) {
		this.svew_bit3 = svew_bit3;
	}

	public String getSvew_bit4() {
		return svew_bit4;
	}

	public void setSvew_bit4(String svew_bit4) {
		this.svew_bit4 = svew_bit4;
	}

	public String getSvew_bit5() {
		return svew_bit5;
	}

	public void setSvew_bit5(String svew_bit5) {
		this.svew_bit5 = svew_bit5;
	}

	public String getSvew_bit6() {
		return svew_bit6;
	}

	public void setSvew_bit6(String svew_bit6) {
		this.svew_bit6 = svew_bit6;
	}

	public String getSvew_bit7() {
		return svew_bit7;
	}

	public void setSvew_bit7(String svew_bit7) {
		this.svew_bit7 = svew_bit7;
	}

	public String getSvew_bit8() {
		return svew_bit8;
	}

	public void setSvew_bit8(String svew_bit8) {
		this.svew_bit8 = svew_bit8;
	}

	public String getSvew_bit9() {
		return svew_bit9;
	}

	public void setSvew_bit9(String svew_bit9) {
		this.svew_bit9 = svew_bit9;
	}

	public String getSvew_bii1() {
		return svew_bii1;
	}

	public void setSvew_bii1(String svew_bii1) {
		this.svew_bii1 = svew_bii1;
	}

	public String getSvew_bii2() {
		return svew_bii2;
	}

	public void setSvew_bii2(String svew_bii2) {
		this.svew_bii2 = svew_bii2;
	}

	public String getSvew_bii3() {
		return svew_bii3;
	}

	public void setSvew_bii3(String svew_bii3) {
		this.svew_bii3 = svew_bii3;
	}

	public String getSvew_bii4() {
		return svew_bii4;
	}

	public void setSvew_bii4(String svew_bii4) {
		this.svew_bii4 = svew_bii4;
	}

	public String getSvew_bii5() {
		return svew_bii5;
	}

	public void setSvew_bii5(String svew_bii5) {
		this.svew_bii5 = svew_bii5;
	}

	public String getSvew_bii6() {
		return svew_bii6;
	}

	public void setSvew_bii6(String svew_bii6) {
		this.svew_bii6 = svew_bii6;
	}

	public String getSvew_bii7() {
		return svew_bii7;
	}

	public void setSvew_bii7(String svew_bii7) {
		this.svew_bii7 = svew_bii7;
	}

	public String getSvew_bii8() {
		return svew_bii8;
	}

	public void setSvew_bii8(String svew_bii8) {
		this.svew_bii8 = svew_bii8;
	}

	public String getSvew_bii9() {
		return svew_bii9;
	}

	public void setSvew_bii9(String svew_bii9) {
		this.svew_bii9 = svew_bii9;
	}

	public String getSvew_co01() {
		return svew_co01;
	}

	public void setSvew_co01(String svew_co01) {
		this.svew_co01 = svew_co01;
	}

	public String getSvew_co02() {
		return svew_co02;
	}

	public void setSvew_co02(String svew_co02) {
		this.svew_co02 = svew_co02;
	}

	public String getSvew_co03() {
		return svew_co03;
	}

	public void setSvew_co03(String svew_co03) {
		this.svew_co03 = svew_co03;
	}

	public String getSvew_co04() {
		return svew_co04;
	}

	public void setSvew_co04(String svew_co04) {
		this.svew_co04 = svew_co04;
	}

	public String getSvew_co05() {
		return svew_co05;
	}

	public void setSvew_co05(String svew_co05) {
		this.svew_co05 = svew_co05;
	}

	public String getSvew_co06() {
		return svew_co06;
	}

	public void setSvew_co06(String svew_co06) {
		this.svew_co06 = svew_co06;
	}

	public String getSvew_co07() {
		return svew_co07;
	}

	public void setSvew_co07(String svew_co07) {
		this.svew_co07 = svew_co07;
	}

	public String getSvew_co08() {
		return svew_co08;
	}

	public void setSvew_co08(String svew_co08) {
		this.svew_co08 = svew_co08;
	}

	public String getSvew_co09() {
		return svew_co09;
	}

	public void setSvew_co09(String svew_co09) {
		this.svew_co09 = svew_co09;
	}

	public String getSvew_co10() {
		return svew_co10;
	}

	public void setSvew_co10(String svew_co10) {
		this.svew_co10 = svew_co10;
	}

	public String getSvew_co11() {
		return svew_co11;
	}

	public void setSvew_co11(String svew_co11) {
		this.svew_co11 = svew_co11;
	}

	public String getSvew_co12() {
		return svew_co12;
	}

	public void setSvew_co12(String svew_co12) {
		this.svew_co12 = svew_co12;
	}

	public String getSvew_co13() {
		return svew_co13;
	}

	public void setSvew_co13(String svew_co13) {
		this.svew_co13 = svew_co13;
	}

	public String getSvew_co14() {
		return svew_co14;
	}

	public void setSvew_co14(String svew_co14) {
		this.svew_co14 = svew_co14;
	}

	public String getSvew_co15() {
		return svew_co15;
	}

	public void setSvew_co15(String svew_co15) {
		this.svew_co15 = svew_co15;
	}

	public String getSvew_co16() {
		return svew_co16;
	}

	public void setSvew_co16(String svew_co16) {
		this.svew_co16 = svew_co16;
	}

	public String getSvew_co17() {
		return svew_co17;
	}

	public void setSvew_co17(String svew_co17) {
		this.svew_co17 = svew_co17;
	}

	public String getSvew_co18() {
		return svew_co18;
	}

	public void setSvew_co18(String svew_co18) {
		this.svew_co18 = svew_co18;
	}

	public String getSvew_co19() {
		return svew_co19;
	}

	public void setSvew_co19(String svew_co19) {
		this.svew_co19 = svew_co19;
	}

	public String getSvew_co20() {
		return svew_co20;
	}

	public void setSvew_co20(String svew_co20) {
		this.svew_co20 = svew_co20;
	}

	public String getSvew_tik1() {
		return svew_tik1;
	}

	public void setSvew_tik1(String svew_tik1) {
		this.svew_tik1 = svew_tik1;
	}

	public String getSvew_tik2() {
		return svew_tik2;
	}

	public void setSvew_tik2(String svew_tik2) {
		this.svew_tik2 = svew_tik2;
	}

	public String getSvew_tik3() {
		return svew_tik3;
	}

	public void setSvew_tik3(String svew_tik3) {
		this.svew_tik3 = svew_tik3;
	}

	public String getSvew_tik4() {
		return svew_tik4;
	}

	public void setSvew_tik4(String svew_tik4) {
		this.svew_tik4 = svew_tik4;
	}

	public String getSvew_tik5() {
		return svew_tik5;
	}

	public void setSvew_tik5(String svew_tik5) {
		this.svew_tik5 = svew_tik5;
	}

	public String getSvew_tik6() {
		return svew_tik6;
	}

	public void setSvew_tik6(String svew_tik6) {
		this.svew_tik6 = svew_tik6;
	}

	public String getSvew_tik7() {
		return svew_tik7;
	}

	public void setSvew_tik7(String svew_tik7) {
		this.svew_tik7 = svew_tik7;
	}

	public String getSvew_tik8() {
		return svew_tik8;
	}

	public void setSvew_tik8(String svew_tik8) {
		this.svew_tik8 = svew_tik8;
	}

	public String getSvew_tik9() {
		return svew_tik9;
	}

	public void setSvew_tik9(String svew_tik9) {
		this.svew_tik9 = svew_tik9;
	}

	public String getSvew_tit1() {
		return svew_tit1;
	}

	public void setSvew_tit1(String svew_tit1) {
		this.svew_tit1 = svew_tit1;
	}

	public String getSvew_tit2() {
		return svew_tit2;
	}

	public void setSvew_tit2(String svew_tit2) {
		this.svew_tit2 = svew_tit2;
	}

	public String getSvew_tit3() {
		return svew_tit3;
	}

	public void setSvew_tit3(String svew_tit3) {
		this.svew_tit3 = svew_tit3;
	}

	public String getSvew_tit4() {
		return svew_tit4;
	}

	public void setSvew_tit4(String svew_tit4) {
		this.svew_tit4 = svew_tit4;
	}

	public String getSvew_tit5() {
		return svew_tit5;
	}

	public void setSvew_tit5(String svew_tit5) {
		this.svew_tit5 = svew_tit5;
	}

	public String getSvew_tit6() {
		return svew_tit6;
	}

	public void setSvew_tit6(String svew_tit6) {
		this.svew_tit6 = svew_tit6;
	}

	public String getSvew_tit7() {
		return svew_tit7;
	}

	public void setSvew_tit7(String svew_tit7) {
		this.svew_tit7 = svew_tit7;
	}

	public String getSvew_tit8() {
		return svew_tit8;
	}

	public void setSvew_tit8(String svew_tit8) {
		this.svew_tit8 = svew_tit8;
	}

	public String getSvew_tit9() {
		return svew_tit9;
	}

	public void setSvew_tit9(String svew_tit9) {
		this.svew_tit9 = svew_tit9;
	}

	public String getSvew_tix1() {
		return svew_tix1;
	}

	public void setSvew_tix1(String svew_tix1) {
		this.svew_tix1 = svew_tix1;
	}

	public String getSvew_tix2() {
		return svew_tix2;
	}

	public void setSvew_tix2(String svew_tix2) {
		this.svew_tix2 = svew_tix2;
	}

	public String getSvew_tix3() {
		return svew_tix3;
	}

	public void setSvew_tix3(String svew_tix3) {
		this.svew_tix3 = svew_tix3;
	}

	public String getSvew_tix4() {
		return svew_tix4;
	}

	public void setSvew_tix4(String svew_tix4) {
		this.svew_tix4 = svew_tix4;
	}

	public String getSvew_tix5() {
		return svew_tix5;
	}

	public void setSvew_tix5(String svew_tix5) {
		this.svew_tix5 = svew_tix5;
	}

	public String getSvew_tix6() {
		return svew_tix6;
	}

	public void setSvew_tix6(String svew_tix6) {
		this.svew_tix6 = svew_tix6;
	}

	public String getSvew_tix7() {
		return svew_tix7;
	}

	public void setSvew_tix7(String svew_tix7) {
		this.svew_tix7 = svew_tix7;
	}

	public String getSvew_tix8() {
		return svew_tix8;
	}

	public void setSvew_tix8(String svew_tix8) {
		this.svew_tix8 = svew_tix8;
	}

	public String getSvew_tix9() {
		return svew_tix9;
	}

	public void setSvew_tix9(String svew_tix9) {
		this.svew_tix9 = svew_tix9;
	}

	public String getSvew_lagi() {
		return svew_lagi;
	}

	public void setSvew_lagi(String svew_lagi) {
		this.svew_lagi = svew_lagi;
	}

	public String getSvew_lagt() {
		return svew_lagt;
	}

	public void setSvew_lagt(String svew_lagt) {
		this.svew_lagt = svew_lagt;
	}

	public String getSvew_lagl() {
		return svew_lagl;
	}

	public void setSvew_lagl(String svew_lagl) {
		this.svew_lagl = svew_lagl;
	}

	public String getSvew_call() {
		return svew_call;
	}

	public void setSvew_call(String svew_call) {
		this.svew_call = svew_call;
	}

	@Override
	public Map<String, Object> getKeys() {   
		keys.put("svew_knnr", svew_knnr);
		keys.put("svew_knso", svew_knso);
		return keys;
	}

}
