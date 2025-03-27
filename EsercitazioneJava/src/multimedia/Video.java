package multimedia;

import exceptions.DurataNonValidaException;
import exceptions.LuminositaNonValidaException;
import exceptions.TitoloNonValidoException;
import exceptions.ValoreVolumeNonValidoException;

public class Video extends ElementoMultimediale implements Riproducibile {

	private int volume;
	private int luminosita;
	private int durata;


	public Video(String titolo, int volume, int luminosita,int durata) throws TitoloNonValidoException, ValoreVolumeNonValidoException, LuminositaNonValidaException, DurataNonValidaException {
		super(titolo);
		if(volume < 0) throw new ValoreVolumeNonValidoException("il volume non può essere negativo");
		if(luminosita < 0) throw new LuminositaNonValidaException("valore non valido");
		if(durata < 0) throw new DurataNonValidaException("deve essere positivo");
		this.durata=durata;
		this.volume = volume;
		this.luminosita = luminosita;
		
	}

	public void aumentaLuminosita() {
		if (luminosita < 10) luminosita++;
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) luminosita--;
	}

	public void abbassaVolume() {
		if (volume > 0) volume--;
	}

	public void alzaVolume() {
		if (volume< 10)volume++;
	}

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));
		}
	}

	@Override
	public void esegui() {
		play();
	}

}
