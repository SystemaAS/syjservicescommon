package no.systema.jservices.common.dto;

import lombok.Data;

@Data
public class ManifestDto {
	private String manifestId;
	private String transportationCompanyId;
	private String timeOfRegistration;
	private String timeOfSubmission;
	
	private String placeOfEntryCode;
	private String estimatedTimeOfArrival;
	private String modeOfTransportCode;
	private String lastChanged;
	private String status;
	private String transportStatus;

	
	
}
