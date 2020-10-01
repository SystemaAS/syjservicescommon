package no.systema.jservices.common.dto.expressfortolling;

import lombok.Data;

@Data
public class ManifestDriverDto {
	String firstName;
	String lastName;
	String countryCode;
	String dateOfBirth;
	String sendReleasedConfirmation;
	String sendReleasedConfirmationEmail;
	
}
