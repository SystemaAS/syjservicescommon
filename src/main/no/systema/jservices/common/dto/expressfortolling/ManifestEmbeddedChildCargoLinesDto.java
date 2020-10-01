package no.systema.jservices.common.dto.expressfortolling;


import lombok.Data;

@Data
public class ManifestEmbeddedChildCargoLinesDto {
	Exports exports;
	ManifestCargoLinesImportDeclarationDto importDeclaration;

	
	@Data
	class Exports {
		ManifestEmbedded _embedded;
	}
}
