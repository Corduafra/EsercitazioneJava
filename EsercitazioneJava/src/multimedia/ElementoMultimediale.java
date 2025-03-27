package multimedia;

import exceptions.DurataNonValidaException;
import exceptions.TitoloNonValidoException;
import exceptions.ValoreVolumeNonValidoException;

public abstract class ElementoMultimediale {
	
	protected String titolo;
	
	
	

	public ElementoMultimediale(String titolo) throws  TitoloNonValidoException {
		
		if(titolo.isEmpty() || titolo == null ) throw new TitoloNonValidoException("inserisci un titolo valido");
		this.titolo = titolo;
		
	}


	public ElementoMultimediale() {
		
	}

	
	
	public abstract void esegui();


	


	
	
	
	

	
}
