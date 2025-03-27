package multimedia;

import exceptions.ValoreVolumeNonValidoException;

public interface Riproducibile {
	void abbassaVolume()throws ValoreVolumeNonValidoException;
	void alzaVolume()throws ValoreVolumeNonValidoException;
	void play();
}
