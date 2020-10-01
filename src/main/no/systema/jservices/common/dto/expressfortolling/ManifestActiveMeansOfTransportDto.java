package no.systema.jservices.common.dto.expressfortolling;

import lombok.Data;

@Data
public class ManifestActiveMeansOfTransportDto {
	String typeOfMeansOfTransport;
	String identificationCode;
	String countryCode;
	ManifestDriverDto driver;
	
}
