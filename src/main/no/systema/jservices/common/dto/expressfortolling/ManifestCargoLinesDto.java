package no.systema.jservices.common.dto.expressfortolling;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	ManifestEmbeddedChildCargoLinesDto _embedded;
	
}
