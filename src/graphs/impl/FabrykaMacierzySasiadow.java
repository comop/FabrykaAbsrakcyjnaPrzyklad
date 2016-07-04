package graphs.impl;

import java.util.Arrays;

import application.FileUtils;
import graphs.FabrykaGrafow;
import graphs.GrafNieskierowany;
import graphs.GrafSkierowany;

public class FabrykaMacierzySasiadow implements FabrykaGrafow {

	@Override
	public GrafNieskierowany createGrafNieskierowany(String filePath) {
		Krawedz[] krawedzie = FileUtils.wczytajPlik(filePath);
		int liczbaWierzcholkow = FileUtils.ustalLiczbeWierzcholkow(filePath);
		int macierz[][] = new int[liczbaWierzcholkow][liczbaWierzcholkow];
		for (int i = 0; i < liczbaWierzcholkow; i++) {
			Arrays.fill(macierz[i], 0);
		}

		for (int i = 0; i < krawedzie.length; i++) {
			macierz[krawedzie[i].getX()][krawedzie[i].getY()] = 1;
			macierz[krawedzie[i].getY()][krawedzie[i].getX()] = 1;
		}
		return new GrafNieskierowanyMacierz(macierz);
	}

	@Override
	public GrafSkierowany createGrafSkierowany(String filePath) {
		Krawedz[] krawedzie = FileUtils.wczytajPlik(filePath);
		int liczbaWierzcholkow = FileUtils.ustalLiczbeWierzcholkow(filePath);
		int macierz[][] = new int[liczbaWierzcholkow][liczbaWierzcholkow];
		for (int i = 0; i < liczbaWierzcholkow; i++) {
			Arrays.fill(macierz[i], 0);
		}

		for (int i = 0; i < krawedzie.length; i++) {
			macierz[krawedzie[i].getX()][krawedzie[i].getY()] = 1;
		}
		return new GrafSkierowanyMacierz(macierz);
	}

}
