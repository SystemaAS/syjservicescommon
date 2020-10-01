package no.systema.jservices.common.dto.expressfortolling;

import java.util.List;

import lombok.Data;

@Data
public class ManifestEmbedded {
	List<ManifestCargoLinesExportsDto> exports;
}
