package no.systema.jservices.common.dto.expressfortolling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class ManifestCargoLinesDto {
	Integer cargoLineId;
	String typeOfImportProcedure;
	String descriptionOfGoods;
	String grossMass;
	Integer numberOfPackages;
	String placeOfLoading;
	String placeOfUnloading;
	ManifestCargoLinesImportProcedureDto importProcedure;
	
	ManifestChildCargoLinesEmbeddedDto _embedded;
	
}
