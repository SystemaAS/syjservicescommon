package no.systema.jservices.common.dto.expressfortolling;

import java.util.List;

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
	
	private ManifestTransportationCompanyDto transportationCompany;
	private ManifestActiveMeansOfTransportDto activeMeansOfTransport;
	private ManifestModeOfTransportDto modeOfTransport;
	private ManifestPlaceOfEntryDto placeOfEntry;
	
	private List<ManifestCargoLinesDto> cargoLines;
}
