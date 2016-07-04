package application;

import javax.swing.JFileChooser;

import graphs.FabrykaGrafow;
import graphs.GrafNieskierowany;
import graphs.GrafSkierowany;
import graphs.impl.FabrykaListySasiadow;
import graphs.impl.FabrykaMacierzySasiadow;

public class Application {

    public static void main(String[] args) {
    	String sciezka = "";
    	JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        	sciezka = fc.getSelectedFile().getAbsolutePath();
        }
        FabrykaGrafow fabryka = new FabrykaListySasiadow();
        
        GrafNieskierowany gns = fabryka.createGrafNieskierowany(sciezka);
        System.out.println(gns.toString());
        GrafSkierowany gs = fabryka.createGrafSkierowany(sciezka);
        System.out.println(gs.toString());
        
        fabryka = new FabrykaMacierzySasiadow();
        gns = fabryka.createGrafNieskierowany(sciezka);
        System.out.println(gns.toString()); 
        gs = fabryka.createGrafSkierowany(sciezka);
        System.out.println(gs.toString()); 
        
        
    }
    
}
