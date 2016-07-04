package graphs.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import graphs.GrafSkierowany;

public class GrafSkierowanyMacierz implements GrafSkierowany {

    int macierzSasiedztwa[][];
    int kolor[];
    boolean czyOdwiedzony[];

    protected GrafSkierowanyMacierz(int macierzSasiedztwa[][]) {
        this.macierzSasiedztwa = macierzSasiedztwa;
        kolor = new int[macierzSasiedztwa.length];// bialy, szary, czarny -
        // odpowiednio 1, 2, 3
        for (int i = 0; i < macierzSasiedztwa.length; i++) {
            kolor[i] = 1;
        }
        czyOdwiedzony = new boolean[macierzSasiedztwa.length];
        for (int i = 0; i < macierzSasiedztwa.length; i++) {
            czyOdwiedzony[i] = false;
        }
    }

    @Override
    public ArrayList<Integer> przeszukiwanieWGlab(int poczatek) {
        ArrayList<Integer> wynik = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();
        czyOdwiedzony[poczatek] = true;
        temp.push(poczatek);
        wynik.add(poczatek);

        while (!temp.isEmpty()) {
            int v = wezNieodwiedzoneWierzcholki(temp.peek());
            if (v == -1) {
                temp.pop();
            } else {
                czyOdwiedzony[v] = true;
                wynik.add(v);
                temp.push(v);
            }
        }
        return wynik;
    }

    public int wezNieodwiedzoneWierzcholki(int v) {
        for (int j = 0; j < macierzSasiedztwa[v].length; j++) {
            int elem = macierzSasiedztwa[v][j];
            if (elem == 1 && czyOdwiedzony[j] == false) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Integer> przeszukiwanieWszerz(int poczatek) {
        LinkedList<Integer> temp = new LinkedList<>();
        ArrayList<Integer> wynik = new ArrayList<>();
        kolor[poczatek] = 2;
        temp.add(poczatek);
        while (!temp.isEmpty()) {
            int u = temp.remove();
            for (int i = 0; i < macierzSasiedztwa[u].length; i++) {
                int elem = macierzSasiedztwa[u][i];
                if (elem == 1 && kolor[i] == 1) {
                    kolor[i] = 2;
                    temp.add(i);
                }
            }
            wynik.add(u);
            kolor[u] = 3;
        }
        return wynik;
    }

    @Override
    public String toString() {
        int poczatek = 0;
        String wynik = "\nGRAF SKIEROWANY MACIERZ\n";
        wynik += "Postac grafu:\n";
        for (int[] macierzSasiedztwa1 : macierzSasiedztwa) {
            for (int j = 0; j < macierzSasiedztwa.length; j++) {
                wynik += macierzSasiedztwa1[j] + " ";
            }
            wynik += "\n";
        }
        ArrayList<Integer> al = przeszukiwanieWszerz(poczatek);
        wynik += "Przeszukiwanie wszerz:\n";
        for (int i = 0; i < al.size(); i++) {
            wynik += al.get(i) + ", ";
        }
        wynik += "\nPrzeszukiwanie w glab:\n";
        ArrayList<Integer> al2 = przeszukiwanieWGlab(poczatek);
        for (int j = 0; j < al2.size(); j++) {
            wynik += al2.get(j) + ", ";
        }
        return wynik;
    }
}
