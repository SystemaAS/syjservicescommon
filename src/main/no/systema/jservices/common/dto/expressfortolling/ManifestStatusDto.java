package no.systema.jservices.common.dto.expressfortolling;

import java.util.List;

import lombok.Data;

@Data
public class ManifestStatusDto {
	private String manifestId;
	private String status;
	private String timeOfDeparture;
	private String timeOfRelease;
	private String lastChanged;
	
	
}
