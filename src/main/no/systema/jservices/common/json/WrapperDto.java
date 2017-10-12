package no.systema.jservices.common.json;

import java.util.List;

/**
 * This class serves as wrapper of a DTO list. Where the list is very large. 
 * This json can not be serialized using @link {@link JsonReader} since no class-def is provided. This is to save broadband.
 * Introduced primary for large JSON-string provided for Reports
 * @author Fredrik Möller
 * @date Okt 10, 2017
 *
 */
public class WrapperDto<T> {

		private List<T> dtoList;

		public List<T> getDtoList() {
			return dtoList;
		}
		public void setDtoList(List<T> dtoList) {
			this.dtoList = dtoList;
		}

}
