package graphs;

import java.util.ArrayList;

public interface Graf {
    public ArrayList<Integer> przeszukiwanieWGlab(int poczatek);
    public ArrayList<Integer> przeszukiwanieWszerz(int poczatek);
    public String toString();
}
