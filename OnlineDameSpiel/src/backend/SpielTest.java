package backend;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author A2
 *
 */

public class SpielTest implements iBediener, iDatenzugriff{

	public static void main(String[] args) {
		SpielBrett sb = new SpielBrett();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Spiel laden [L] oder neues Spiel spielen [n].\n" + "Der aktuelle Spielstand kann jederzeit Ã¼ber die Eingabe [s] gespeichert werden");
		String eingabe = scanner.nextLine();
		if ("l".equals(eingabe) == true) {
			System.out.println("Dateinamen eingeben.");
			String filename = scanner.nextLine();
			System.out.println("Speichertyp [csv] oder [ser] eingeben.");
			String typ = scanner.nextLine();
			if(typ.equals("csv")){
			try {
				SpielBean s = new SpielBean();
				s.laden(filename, typ);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			else if(typ.equals("ser")){
				try {
					SpielBean s = new SpielBean();
					s.laden(filename, typ);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if ("n".equals(eingabe) == true) {

			System.out.println("Name Spieler 1:");
			String name1 = scanner.nextLine();
			System.out.println("KI? - y/n");
			while (!scanner.hasNext("[yn]")) {
				System.out.println("KI? - y/n");
				scanner.next();
			}
			String ki1 = scanner.next();
			boolean ki1erstellen = false;

			if (ki1.equals("y")) {
				ki1erstellen = true;
			}
			
			
//
//			Spieler player1 = new Spieler(name1, FarbEnum.weiss, ki1erstellen);
//
//			add(player1);
			System.out.println(name1 + " hinzugefuegt!");
			System.out.println("Name Spieler 2:");
			String name2 = scanner.next();
			System.out.println("KI? - y/n");
			while (!scanner.hasNext("[yn]")) {
				System.out.println("KI? - y/n");
				scanner.next();
			}
			String ki2 = scanner.next();
			boolean ki2erstellen = false;
			if (ki2.equals("y")) {
				ki2erstellen = true;
			}
//
//			Spieler player2 = new Spieler(name2, FarbEnum.schwarz, ki2erstellen);
//
//			add(player2);
//			System.out.println(player2 + " hinzugefuegt!");
//
//			System.out.println("Moege das Spiel beginnen!");

//			System.out.println(spielbrett);
//			System.out.println(player1.getName() + " - " + "'" + player1.getFarbe() + "'" + " faengt an!");
			scanner.reset();
			//playerRotation(player1, player2);
			sb.printBrett();
			System.out.println();
			iBediener unserSpiel = new SpielBean(name1, ki1erstellen, name2, ki2erstellen);
			
		}

		iBediener spiel = new SpielBean(eingabe, false, eingabe, false);

	}

	@Override
	public Spielfeld[] eingabeSpielfeldSpieler(Spieler player1) {

		
		return null;
	}

	@Override
	public void askSchlagen(Spieler player, Spielfeld spielfeld) {
		// TODO Auto-generated method stub
		
	}

	
	public void speichern(Object obj, String name, String typ)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object laden(String name, String typ) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speichern(Object obj, String name) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
