package no.systema.jservices.common.dto.expressfortolling;

import lombok.Data;

@Data
public class ManifestCargoLinesImportDeclarationDto {
	String grossMass;
	Integer numberOfPackages;
	String consignee;
	
}
