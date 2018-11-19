package no.systema.jservices.common.json;

import lombok.Data;

/**
 * This class is convenient when dynamic search from UI is required.
 * 
 * @author Fredrik Möller
 * @date Nov 14, 2018
 *
 */
@Data //I love lombok
public class Select2Dto {

	private int id;
	private String text;

}
