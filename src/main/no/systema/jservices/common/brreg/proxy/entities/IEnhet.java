package no.systema.jservices.common.brreg.proxy.entities;

public interface IEnhet {

	public void setKonkurs(Boolean b);
	public Boolean getKonkurs();

	public void setRegistrertIMvaregisteret(Boolean b);
	public Boolean getRegistrertIMvaregisteret();
	
	public void setUnderAvvikling(Boolean b);
	public Boolean getUnderAvvikling();
	
	public void setUnderTvangsavviklingEllerTvangsopplosning(Boolean b);
	public Boolean getUnderTvangsavviklingEllerTvangsopplosning();
	
	public String getOverordnetEnhet();
}
