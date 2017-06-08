package no.systema.jservices.common.values;

import java.io.Serializable;

import no.systema.jservices.common.dao.Svtx03fDao;

/**
 * Holding constants for codetypes in {@linkplain Svtx03fDao}. Use to where clause svtx03_02.
 * 
 * @author Fredrik Möller
 * @date June 7, 2017
 *
 */
public enum Svtx03fKodTyper implements Serializable {
	GCY,
	FFK,
	KLI
}
