package application;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

import graphs.impl.Krawedz;

public class FileUtils {
	
	public static Krawedz[] wczytajPlik(String path) {
		File file = new File(path);
		Krawedz[] krawedzie = null;
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			String drugaLinia = scanner.nextLine();
			int liczbaKrawedzi = Integer.parseInt(drugaLinia);
			krawedzie = new Krawedz[liczbaKrawedzi];

			for (int i = 0; i < liczbaKrawedzi; i++) {
				krawedzie[i] = wczytajKrawedz(scanner.nextLine());
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Blad");
		}
		return krawedzie;
	}

	public static int ustalLiczbeWierzcholkow(String path) {
		File file = new File(path);
		int liczbaWierzcholkow = 0;
		try {
			Scanner scanner = new Scanner(file);
			String pierwszaLinia = scanner.nextLine();
			liczbaWierzcholkow = Integer.parseInt(pierwszaLinia);

			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Blad");
		}
		return liczbaWierzcholkow;
	}

	private static Krawedz wczytajKrawedz(String linia) throws NumberFormatException {
		String[] czesci = linia.split(" ");
		int x = Integer.parseInt(czesci[0]);
		int y = Integer.parseInt(czesci[1]);
		return new Krawedz(x, y);
	}
}
