import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Programmeur {
    private int Id;
    private String Nom;
    private String Prenom;
    private int Bureau;
    
    List<Consos_Cafe> consommationCafesSemaine;

    public Programmeur() {
        Id = -1;
        Nom = "";
        Prenom = "";
        Bureau = -1;
        consommationCafesSemaine = null;
    }

    public Programmeur(int id, String nom, String prenom, int bureau) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Bureau = bureau;
        consommationCafesSemaine = null;
    }

    public List<Consos_Cafe> getConsommationCafesSemaine() {
        return consommationCafesSemaine;
    }

    public void setConsommationCafesSemaine(List<Consos_Cafe> consommationCafesSemaine) {
        this.consommationCafesSemaine = consommationCafesSemaine;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getBureau() {
        return Bureau;
    }

    public void setBureau(int bureau) {
        Bureau = bureau;
    }

    public void setPersonne(int ID, String nom, String prenom, int bureau){
        this.Id = ID;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Bureau = bureau;
    }

    @Override
    public String toString() {
        return "Programmeur{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Bureau=" + Bureau +
                ", consommationCafesSemaine=" + consommationCafesSemaine +
                '}';
    }

    public String toStringInline() {
        return String.format("%-3d | %-18s | %-18s | %-6d", Id, Nom, Prenom, Bureau);
    }

    public String toStringConsosCafesSemaineInline(int semaine) {
        int nbre_tasses = 0;
        for (int i = 0; i < consommationCafesSemaine.size(); i++){
            if (this.consommationCafesSemaine.get(i).getNo_Semaine() == semaine){
                nbre_tasses = this.consommationCafesSemaine.get(i).getNb_Tasses();
                break;
            }
        }
        return String.format("%-3d | %-18s | %-18s | %-14d | %-14d | %-14d", Id, Nom, Prenom, Bureau, semaine, nbre_tasses);
    }

    public String toStringInlineConsommationCafeSemaine(int noSemaine) {
        if (this.consommationCafesSemaine == null || noSemaine < 1) {
            return Id + " " + Nom + " " + Prenom + " " + Bureau + " " + "null";
        }

        List<Consos_Cafe> listConsos_cafe = new ArrayList<>(this.consommationCafesSemaine);
        String str = "\n";
        System.out.println("\t\t");
        for (Consos_Cafe consos_cafe : listConsos_cafe) {
            if (consos_cafe.getNb_Tasses() < 1 || consos_cafe.equals("null")) {
                 str += consos_cafe.toStringInline() + " \n ";
            }
        }
        return str;
    }

    public String toStringInlineConsommationCafeSemaine() {
        if (this.consommationCafesSemaine == null) {
            return Id + " " + Nom + " " + Prenom + " " + Bureau + " " + "null";
        }
        List<Consos_Cafe> listConsos_cafe = new ArrayList<>(this.consommationCafesSemaine);
        String str = "\n";
        for (Consos_Cafe consos_cafe : listConsos_cafe) {
            if (consos_cafe.getNo_Semaine() < 1 || consos_cafe.getNb_Tasses() < 1 || consos_cafe.equals("null")) {
                return Id + " " + Nom + " " + Prenom + " " + Bureau + " " + "null";
            }
            str += consos_cafe.toStringInline() + " \n ";
        }

        return Id + " " + Nom + " " + Prenom + " " + Bureau + " " + str;
    }


/*public String toString() {
        return "Programmeur{" + "Id=" + Id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Bureau=" + Bureau + '}';
    }*/



    //1-Afficher un programmeur


    //2-Afficher un programmeur
    public static void afficherUnProgrammeur(Programmeur p){
        System.out.println(p.toString());
    }

    //3-Afficher la liste des programmeurs

    //4-Supprimer un programmeur

    //5 Changer le bureau d’un programmeur

    //6-consommeursCafesSemaine

    //7-Afficher le nombre total de tasses de café consommé en une semaine donnée.

    public static String toString(List<Programmeur> listeProgrammeurs, int semaine){
        System.out.println("ID\t|\tNOM\t\t\t\t|\tPRENOM\t\t\t\t|\tBUREAU\t|\tSEMAINE\t|\tNBRE_TASSES");
        System.out.println("----------------------------------------------------------");
        String str = "";
        for (Programmeur programmeur : listeProgrammeurs) {
            System.out.println(programmeur.toStringConsosCafesSemaineInline(semaine));
            //str += programmeur.toStringInline() + "\n";
        }
        return str;
    }


}

