package de.gtwsp21.handmanserv.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Handwerker")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class Handwerker extends Benutzer {

	public Handwerker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Handwerker(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer,List<Gebiet> gebiete,List<Gewerk> gewerke) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
		this.gebiete = gebiete;
		this.gewerke = gewerke;
	}

	@ManyToMany
	@JoinTable(name = "Gebiet_Handwerker",
    joinColumns = @JoinColumn(name = "HandwerkerId"),
    inverseJoinColumns = @JoinColumn(name = "GebietId"))
	private List<Gebiet> gebiete;
	
	@ManyToMany
	@JoinTable(name = "Gewerk_Handwerker",
    joinColumns = @JoinColumn(name = "HandwerkerId"),
    inverseJoinColumns = @JoinColumn(name = "GewerkId"))
	private List<Gewerk> gewerke;
	
	private String telefonnummer;
	
	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	@Override
	public int getRolleNr() {
		return 4;
	}
	
	@Override
	public String getRolleName() {
		return "Handwerker";
	}

	public List<Gebiet> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Gebiet> gebiete) {
		this.gebiete = gebiete;
	}

	public List<Gewerk> getGewerke() {
		return gewerke;
	}

	public void setGewerke(List<Gewerk> gewerke) {
		this.gewerke = gewerke;
	}

	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_HANDWERKER};
	}


}
