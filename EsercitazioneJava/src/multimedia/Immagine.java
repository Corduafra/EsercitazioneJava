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

	public void aumentaLuminosita() {
		luminosita++;
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) 
			luminosita--;
		else {
			System.out.println("Luminosita al minimo");
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
