package multimedia;

import exceptions.DurataNonValidaException;
import exceptions.TitoloNonValidoException;
import exceptions.ValoreVolumeNonValidoException;

public class Audio extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int durata;

	public Audio(String titolo, int volume, int durata)throws ValoreVolumeNonValidoException, TitoloNonValidoException, DurataNonValidaException{
		super(titolo);
		
		if(volume < 0) throw new ValoreVolumeNonValidoException("il volume non può essere negativo");
		if(durata < 0) throw new DurataNonValidaException("deve essere positivo");
		this.durata=durata;
		this.volume = volume;

	}

	public void abbassaVolume() {
		if(volume > 0)
			volume--;
		else {
			System.out.println("Il volume è già al minimo");
		}
	}

	public void alzaVolume() {
		volume++;
	}



	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.println(titolo + " " + "!".repeat(volume));
		}
	}

	@Override
	public void esegui() {
		play();
	}

}
