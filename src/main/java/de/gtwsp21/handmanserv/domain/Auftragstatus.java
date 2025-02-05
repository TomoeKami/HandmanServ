package de.gtwsp21.handmanserv.domain;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public enum Auftragstatus {
	
	Neu(1,"Neu"),InArbeit(2,"in Arbeit"),Abnahme(3,"abnahme"),Storniert(4,"storniert"),Fertig(5,"Fertiggestellt");
	private int nummer;
	
	private String text;
	
	Auftragstatus(int nummer, String text) {
		this.nummer = nummer;
		this.text=text;
	}
	
	
	public Auftragstatus findByNummer(int nummer) {
		return Stream.of(Auftragstatus.values()).filter(status -> status.nummer == nummer).findFirst()
		.orElseThrow(()-> new NoSuchElementException(String.format("F�r die Nummer: %s gibt es keinen Auftragsstatus!",nummer)));
	}
	
	public Auftragstatus findByText(String text) {
		return Stream.of(Auftragstatus.values()).filter(status -> status.text.equals(text)).findFirst()
		.orElseThrow(()-> new NoSuchElementException(String.format("F�r den Text: %s gibt es keinen Auftragsstatus!",text)));
	}
	
	
}
