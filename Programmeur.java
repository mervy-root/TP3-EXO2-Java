import java.util.List;

public class Programmeur {
    private int Id;
    private String Nom;
    private String Prenom;
    private int Bureau;
    List<Consos_Cafe> consommationCafesSemaine;

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


}

