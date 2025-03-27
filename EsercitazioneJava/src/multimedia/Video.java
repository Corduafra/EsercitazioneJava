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
	
	

	public int getVolume() {
		return volume;
	}
	public int getLuminosita() {
		return luminosita;
	}
	@Override
	public void abbassaVolume() throws ValoreVolumeNonValidoException {
		if(volume > 0)
			volume--;
		else {
			throw new ValoreVolumeNonValidoException("Il volume è già al minimo");
		}
	}
	@Override
	public void alzaVolume() throws ValoreVolumeNonValidoException {
		if (volume< 10)volume++;
		else {
			throw new ValoreVolumeNonValidoException("hai il volume al massimo");
		}
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
