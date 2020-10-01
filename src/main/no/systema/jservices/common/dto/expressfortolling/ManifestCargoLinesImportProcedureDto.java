package no.systema.jservices.common.dto.expressfortolling;

import lombok.Data;

@Data
public class ManifestCargoLinesImportProcedureDto {
	String mrn;
	String recipientName;
	String senderName;
	String declarantNumber;
	String declarationDate;
	String sequenceNumber;
	
	
}
