package no.systema.jservices.common.json;

import java.util.List;

import lombok.Data;

/**
 * This class is convenient when dynamic search from UI is required.
 * 
 * @author Fredrik Möller
 * @date Nov 14, 2018
 *
 */
@Data //I love lombok
public class PagingDto {

	private List<Select2Dto> items;
	private int countFiltered;

}
