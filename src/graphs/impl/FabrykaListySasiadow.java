package graphs.impl;

import java.util.ArrayList;

import application.FileUtils;
import graphs.FabrykaGrafow;
import graphs.GrafNieskierowany;
import graphs.GrafSkierowany;

public class FabrykaListySasiadow implements FabrykaGrafow {

	@Override
	public GrafNieskierowany createGrafNieskierowany(String filePath) {
		Krawedz[] krawedzie = FileUtils.wczytajPlik(filePath);
		int liczbaWierzcholkow = FileUtils.ustalLiczbeWierzcholkow(filePath);
		ArrayList<ArrayList<Integer>> wierzcholki = new ArrayList<>();
		for (int i = 0; i < liczbaWierzcholkow; i++) {
			wierzcholki.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < krawedzie.length; i++) {
			wierzcholki.get(krawedzie[i].getX()).add(krawedzie[i].getY());
			wierzcholki.get(krawedzie[i].getY()).add(krawedzie[i].getX());
		}
		return new GrafNieskierowanyLista(wierzcholki);
	}

	@Override
	public GrafSkierowany createGrafSkierowany(String filePath) {
		Krawedz[] krawedzie = FileUtils.wczytajPlik(filePath);
		int liczbaWierzcholkow = FileUtils.ustalLiczbeWierzcholkow(filePath);
		ArrayList<ArrayList<Integer>> wierzcholki = new ArrayList<>();
		for (int i = 0; i < liczbaWierzcholkow; i++) {
			ArrayList<Integer> temp = new ArrayList<>();

			for (int j = 0; j < krawedzie.length; j++) {
				if (i == krawedzie[j].getX()) {
					temp.add(krawedzie[j].getY());
				}
			}

			wierzcholki.add(temp);
		}
		return new GrafSkierowanyLista(wierzcholki);
	}

}
