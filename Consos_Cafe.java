import java.util.ArrayList;
import java.util.List;

public class Consos_Cafe {
    private int No_Semaine;
    private int Nb_Tasses;

    public Consos_Cafe(int no_semaine, int id_programmeur, int nb_tasses) {
        No_Semaine = no_semaine;
        Nb_Tasses = nb_tasses;
    } 

    public Consos_Cafe() {
        No_Semaine = -1;
        Nb_Tasses = -1;
    }

    public int getNo_Semaine() {
        return No_Semaine;
    }

    public void setNo_Semaine(int no_Semaine) {
        No_Semaine = no_Semaine;
    }

    public int getNb_Tasses() {
        return Nb_Tasses;
    }

    public void setNb_Tasses(int nb_Tasses) {
        Nb_Tasses = nb_Tasses;
    }

    @Override
    public String toString() {
        return "Consos_Cafe{" +
                "No_Semaine=" + No_Semaine +
                ", Nb_Tasses=" + Nb_Tasses +
                '}';
    }
    public String toStringInline() {
        return No_Semaine + "\t" + Nb_Tasses;
    }

    /*public String toString() {
        return "Consos_Cafe{" + "No_Semaine=" + No_Semaine + ", Nb_Tasses=" + Nb_Tasses + '}';
    }*/

    




}
