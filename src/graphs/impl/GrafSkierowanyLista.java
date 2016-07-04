package graphs.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import graphs.GrafSkierowany;

public class GrafSkierowanyLista implements GrafSkierowany {

    ArrayList<ArrayList<Integer>> listySasiedztwa;
    int kolor[];

    boolean czyOdwiedzony[];

    protected GrafSkierowanyLista(ArrayList<ArrayList<Integer>> listySasiedztwa) {
        this.listySasiedztwa = listySasiedztwa;
        kolor = new int[listySasiedztwa.size()];// bialy, szary, czarny -
        // odpowiednio 1, 2, 3
        czyOdwiedzony = new boolean[listySasiedztwa.size()];
        for (int i = 0; i < listySasiedztwa.size(); i++) {
            kolor[i] = 1;
        }

        for (int i = 0; i < listySasiedztwa.size(); i++) {
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
        for (int j = 0; j < listySasiedztwa.get(v).size(); j++) {
            int elem = listySasiedztwa.get(v).get(j);
            if (czyOdwiedzony[elem] == false) {
                return elem;
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
            for (int i = 0; i < listySasiedztwa.get(u).size(); i++) {
                int elem = listySasiedztwa.get(u).get(i);
                if (kolor[elem] == 1) {
                    kolor[elem] = 2;
                    temp.add(elem);
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
        String wynik = "\nGRAF SKIEROWANY LISTA\n";
        wynik += "Postac grafu:\n";
        for (int i = 0; i < listySasiedztwa.size(); i++) {
            wynik += i;
            for (int j = 0; j < listySasiedztwa.get(i).size(); j++) {
                wynik += " -> " + listySasiedztwa.get(i).get(j);
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
