package multimedia;

import exceptions.DurataNonValidaException;
import exceptions.TitoloNonValidoException;
import exceptions.ValoreVolumeNonValidoException;

public class Audio extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int durata;

	public Audio(String titolo,  int durata, int volume)throws TitoloNonValidoException, ValoreVolumeNonValidoException,  DurataNonValidaException{
		super(titolo);
		if(durata < 0) throw new DurataNonValidaException("la durata deve essere positivo");
		if(volume < 0) throw new ValoreVolumeNonValidoException("il volume non può essere negativo");
		
		this.durata=durata;
		this.volume = volume;

	}
	
	

	public int getVolume() {
		return volume;
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
			System.out.println(titolo + " " + "!".repeat(volume));
		}
	}

	@Override
	public void esegui() {
		play();
	}

}

