package no.systema.jservices.common.values;

import java.io.Serializable;

/**
 * Holding constant for select section from ...
 * 
 * 
 * <b>KOFAST:</b> <br>
 * AIRCOD AIRSPH ARKIVJ ARKIVU AVLETEKST BERKOD CPSORT DELSYS ESPEDPARM
 * FRBREVPRO FRBREVPROT FRTKOD FSDOKK FUNKSJON GEBTYP HEUR INLTOPOPT KOLTYP
 * LAGERLEIER LAGERMOT LAGERUTTAK MLAPKOD MST PP01DAT03 PRKOLL SEASYS SFEDIT
 * STATKODE STSORT ST01TYPE SVTULL1 SYPAR S8SATSTY TABTYP TRACKPREFI TRACKSUFFI
 * TRACKT UTLKOD WEBETRACK XMLVLTYPE
 * 
 * <b>KUFAST</b>: <br>
 * AIROTH AVTTIL BILAVGGR BILKLAUS CONTLOK DHLEDKD DHLPRDKD DUPKONTOR
 * ESPEDFARGE ESPEDKUGRP FELTKONTR FORPAKNING GETXTKOD GRITYPE GRKTYPE KREDIT
 * LAGDETALJT LAGERPLMAN LAGERPLUSG LS00000175 MEEMBAL MELAGER MVAKOD PODAVVIK
 * PRODTYPE SSORDREF SSSTATUS SSSYCGITDV STTYPE TEST TIDSBRUK TKTTSTED VATY
 * VE*SY* VE00000001 VE00000072 VE00000175 VE00000176 VE00007021 VG*SY*
 * VG00000001 VG00000072 VG00000175 VG00000176 VG00007021
 * 
 * @author Fredrik Möller
 * @date Nov 21, 2016
 *
 */
public enum FasteKoder implements Serializable {
	FUNKSJON,
	MLAPKOD,
	DELSYS,
	SYPAR,
	ARKIVU,
	PRODTYPE,
	FRBREVPRO,
	TRACKT,
	SADEFBKODE,
	SADEFETYPE,
	SADEFPR
}
