package no.systema.jservices.common.dto.expressfortolling;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class ManifestChildCargoLinesEmbeddedDto {
	
	Exports exports;
	ManifestCargoLinesImportDeclarationDto importDeclaration;
	
	
	@Data
	class Exports {
		ManifestCargoLinesEmbeddedExports _embedded;
		
		@Data
		class ManifestCargoLinesEmbeddedExports {
			List<ManifestCargoLinesExportsDto> exports;
		}
	}
	
	
	
}
