package test;

import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

import exceptions.DurataNonValidaException;
import exceptions.LuminositaNonValidaException;
import exceptions.TitoloNonValidoException;
import exceptions.ValoreVolumeNonValidoException;
import multimedia.Audio;
import multimedia.ElementoMultimediale;
import multimedia.Immagine;
import multimedia.Video;

public class Main {


	public static void main(String[] args) throws ValoreVolumeNonValidoException, TitoloNonValidoException, LuminositaNonValidaException, DurataNonValidaException {
		Scanner scanner = new Scanner(System.in);

		ElementoMultimediale[] elementi = new ElementoMultimediale[5];

		// scritto dentro al for cosi da aver chiarezzza per ogni nuovo inserimento
		//System.out.println("Inserire  i tipi di elementi multimediale");
		//System.out.println("digitare: \n1 per video \n2 per audio \n3 per immagine");
		
		ElementoMultimediale elementoMultimediale = new Audio("ciao", 0, 0);
		// Esegui il cast a Audio per accedere ai metodi specifici
		//((Audio) elementoMultimediale).abbassaVolume();
		//genera errore il volume è al minimo 
		
		((Audio) elementoMultimediale).alzaVolume();
		System.out.println(((Audio) elementoMultimediale).getVolume());
		


		for (int i = 0; i < elementi.length; i++) {
			
			
			/*
			 * try catch per ruiscire a catturare gli errori nella fase di inizializzazione nel new
			 * l'errore non viene riportato subito mentre scriviamo in linea di comando ma durante l'inizializzaizone
			 * 
			 * inserito i-- dopo i catch così da continuare l'inserimento dei 5 elementi attesi e il default in caso di inserimento di case sbagliato
			 * 
			 */
			
			try {
				//			System.out.print("Inserisci il titolo: ");
				//            String titolo = scanner.next();
				System.out.println("Inserisci tipo di elemento \n1 = video \n2 = audio \n3 = immagine ");   
				int scelta = scanner.nextInt();
				scanner.nextLine(); // Consuma il newline altrimenti da errore di valore


				switch (scelta) {
				case 1: //video
					System.out.print("Inserisci il titolo: ");
					String titolo = scanner.nextLine();
					System.out.println("Inserisci durata: ");
					int durataVideo = scanner.nextInt();
					System.out.println("Inserisci volume: ");
					int volumeVideo = scanner.nextInt();
					System.out.println("Inserisci luminosità: ");
					int luminositaVideo = scanner.nextInt();
					elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
					break;

				case 2: //audio
					System.out.print("Inserisci il titolo: ");
					String titolo1 = scanner.nextLine();
					System.out.println("Inserisci durata: ");
					int durataAudio = scanner.nextInt();
					System.out.print("Inserisci volume: ");
					int volumeAudio = scanner.nextInt();
					elementi[i] = new Audio(titolo1, durataAudio, volumeAudio);
					break;
				case 3: //immagine
					System.out.print("Inserisci il titolo: ");
					String titolo2 = scanner.nextLine();
					System.out.print("Inserisci luminosità: ");
					int luminosita = scanner.nextInt();
					elementi[i] = new Immagine(titolo2, luminosita);
					break;
				default:
					System.out.println("Scelta non valida!");
					i--;
					continue;
				}
			}catch (ValoreVolumeNonValidoException | TitoloNonValidoException | LuminositaNonValidaException | DurataNonValidaException e){
				System.out.println(e.getMessage());
				i--;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				i--;
			}

		}
		
		
		/**
		 * utilizzato un break per uscire dal ciclio infito del while
		 * si poteva anche scegliere di fare un do-while
		 */
		
		while(true) {
			System.out.println("inserire il numero dell'elemento multimediale che si vuole eseguire");
			int scelta = scanner.nextInt();
			if(scelta == 0) {
				break;
			}
			if (scelta < 1 || scelta > 5) {
				System.out.println("Scelta non valida. Riprova.");
			} 
			else {
				elementi[scelta - 1].esegui();
			}

		}


	}

}
