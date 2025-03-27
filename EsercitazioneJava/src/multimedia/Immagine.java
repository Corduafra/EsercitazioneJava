package multimedia;

import exceptions.LuminositaNonValidaException;
import exceptions.TitoloNonValidoException;

public class Immagine extends ElementoMultimediale {

	private int luminosita;


	public Immagine(String titolo, int luminosita) throws TitoloNonValidoException, LuminositaNonValidaException {
		super(titolo);
		if(luminosita < 0) throw new LuminositaNonValidaException("valore non valido");
		
		this.luminosita = luminosita;
	}
	
	

	public int getLuminosita() {
		return luminosita;
	}



	public void aumentaLuminosita() throws LuminositaNonValidaException {
		if (luminosita <10) {
			luminosita++;
		}else {
			throw new LuminositaNonValidaException("Luminosita al minimo");
		}
	}

	public void diminuisciLuminosita() throws LuminositaNonValidaException {
		if (luminosita > 0) { 
			luminosita--;
		}else {
			throw new LuminositaNonValidaException("Luminosita al minimo");
		}
	}
	
	public void show() {
		System.out.println(titolo + " " + "*".repeat(luminosita));
	}

	@Override
	public void esegui() {
		show();

	}


}
