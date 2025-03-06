import java.util.*;

public class GestionProgrammeur {
    private List<Programmeur> listeProgrammeurs;
    
    Scanner scanner = new Scanner(System.in);
    
    public GestionProgrammeur() {
        this.listeProgrammeurs = new ArrayList<>();
    }

    public GestionProgrammeur(List<Programmeur> listeProgrammeurs) {
        this.listeProgrammeurs = listeProgrammeurs;
    }

    public GestionProgrammeur(GestionProgrammeur gestionProgrammeur) {
        this.listeProgrammeurs = new ArrayList<>(gestionProgrammeur.getListeProgrammeurs());
    }

    public List<Programmeur> getListeProgrammeurs() {
        return listeProgrammeurs;
    }

    public void setListeProgrammeurs(List<Programmeur> listeProgrammeurs) {
        this.listeProgrammeurs = listeProgrammeurs;
    }

    public void ajouterProgrammeur() {
        System.out.println("Ajouter un nouveau Programmeur");

        int id = -1;
        while (true) {
            try {
                System.out.print("Entrez son Id : ");
                id = scanner.nextInt();
                scanner.nextLine(); // Nettoyer le buffer
                break; // Sort de la boucle si l'entrée est correcte
            } catch (InputMismatchException e) {
                System.out.println("Erreur ! Veuillez entrer un nombre entier valide.");
                scanner.nextLine(); // Nettoyer l'entrée incorrecte
            }
        }

        System.out.print("Entrez son Nom : ");
        String nom = scanner.nextLine().trim();
        while (nom.isEmpty()) {
            System.out.print("Le nom ne peut pas être vide. Veuillez entrer un nom : ");
            nom = scanner.nextLine().trim();
        }

        System.out.print("Entrez son Prenom : ");
        String prenom = scanner.nextLine().trim();
        while (prenom.isEmpty()) {
            System.out.print("Le prénom ne peut pas être vide. Veuillez entrer un prénom : ");
            prenom = scanner.nextLine().trim();
        }

        int bureau = -1;
        while (true) {
            try {
                System.out.print("Entrez son Bureau : ");
                bureau = scanner.nextInt();
                scanner.nextLine(); // Nettoyer le buffer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erreur ! Veuillez entrer un numéro de bureau valide.");
                scanner.nextLine(); // Nettoyer l'entrée incorrecte
            }
        }

        // Vérifier si l'ID est déjà utilisé
        for (Programmeur prog : listeProgrammeurs) {
            if (prog.getId() == id) {
                System.out.println("Erreur ! Un programmeur avec cet ID existe déjà.");
                return; // Annule l'ajout
            }
        }

        Programmeur p = new Programmeur(id, nom, prenom, bureau);
        this.listeProgrammeurs.add(p);
        System.out.println(p.toString());
        System.out.println("Programmeur ajouté avec succès !");
    }

/*
    public void ajouterProgrammeur(){
        System.out.println("Ajouter un nouveau Programmeur");

        System.out.println("Entrez son Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez son Nom : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez son Prenom : ");
        String prenom = scanner.nextLine();

        System.out.println("Entrez son Bureau : ");
        int bureau = scanner.nextInt();

        Programmeur p = new Programmeur(id,nom,prenom,bureau);
        this.listeProgrammeurs.add(p);
    }
*/

    //2-Afficher un programmeur
    public void afficherUnProgrammeur(){
        if (this.listeProgrammeurs.isEmpty()) {
            System.out.println("La liste est vide");
            return;
        }

        System.out.println("Entrez l'Id du programmeur : ");
        int id = scanner.nextInt(); //id du programmeur à supprimer

        if (id > 0){
            int position = rechercherIndiceProgrammeur(this.listeProgrammeurs, id); //rechercher l'indice du programmeur dans la liste
            if (position != -1){
                System.out.println(this.listeProgrammeurs.get(position).toString());
            }
            else
                System.out.println("Programmeur non trouvé");
        }
        else
            System.out.println("Entree incorrecte");
    }

    //3-Afficher la liste des programmeurs
    public void afficherPlusieursProgrammeurs(){
        if (this.listeProgrammeurs.isEmpty()) {
            System.out.println("La liste est vide");
            return;
        }

        System.out.println("Liste des programmeurs : ");
        for (Programmeur programmeur : this.listeProgrammeurs) {
            System.out.println(programmeur);
        }
    }

    //4-Supprimer un programmeur
    public void supprimerUnProgrammeur() {
        if (!this.listeProgrammeurs.isEmpty()){
            System.out.println("La liste est vide");
            return;
        }

        System.out.println("Entrez l'Id du programmeur à supprimer : ");
        int id = scanner.nextInt(); //id du programmeur à supprimer

        if (id <= 0) {
            System.out.println("Entree incorrecte");
            return;            
        }

        int position = rechercherIndiceProgrammeur(this.listeProgrammeurs, id);
        this.listeProgrammeurs.remove(position);
        System.out.println("Suppression effectue avec succes");
 
        /*
        for (int j = position; j < tabPro.size() - 1; j++) {
            tabPro.get(j).setId(tabPro.get(j+1).getId());
            tabPro.get(j).setNom(tabPro.get(j+1).getNom());
            tabPro.get(j).setPrenom(tabPro.get(j+1).getPrenom());
            tabPro.get(j).setBureau(tabPro.get(j+1).getBureau());
        }
        if (!tabPro.isEmpty()) {
            tabPro.remove(tabPro.size() - 1);
        }

        System.out.println("Suppression effectue avec succes");
        */
    }



    //5 Changer le bureau d’un programmeur
    public void changerBureauProgrammeur(){
        System.out.println("Entrez l'Id du programmeur : ");
        int id = scanner.nextInt(); //id du programmeur à supprimer
        
        if (id <= 0) {
            System.out.println("Entree de l'Id du programmeur incorrect");
            return;    
        }

        int indice = rechercherIndiceProgrammeur(this.listeProgrammeurs, id);
        if (indice == -1) {
            System.out.println("Programmeur non trouvé");
            return;
        }

        System.out.println("Entrez le nouveau bureau : ");
        int nouveauBureau = scanner.nextInt(); 

        if (nouveauBureau <= 0) {
            System.out.println("Entree du nouveau bureau incorrect");
            return;    
        }

        this.listeProgrammeurs.get(indice).setBureau(nouveauBureau);
        System.out.println("Changement de bureau effectue avec succes");
        System.out.println(this.listeProgrammeurs.get(indice));

    }

    //6-consommeursCafesSemaine
    public List<Programmeur> consommeursCafesSemaine()
    {
        if (this.listeProgrammeurs.isEmpty()){
            System.out.println("La liste est vide");
            return null;
        }

        System.out.println("Entrez le numero de la semaine : ");
        final int noSemaine = scanner.nextInt();

        if (noSemaine <= 0){
            System.out.println("Entree du numero de la semaine incorrect");
            return null;
        }

        List<Programmeur> consommeursSemaine = new ArrayList<>();
        
        for (Programmeur programmeur : this.listeProgrammeurs) {
            if (programmeur.consommationCafesSemaine != null){
                for (Consos_Cafe consos_cafe : programmeur.consommationCafesSemaine) {
                    if (consos_cafe.getNo_Semaine() == noSemaine){
                        consommeursSemaine.add(programmeur);
                    }
                }
            }
        }

        Comparator<Programmeur> comparator = (p1, p2) ->
                Integer.compare(p2.getConsommationCafesSemaine().size(), p1.getConsommationCafesSemaine().size());
        consommeursSemaine.sort(comparator);
        System.out.println("Tri décroissant: " + consommeursSemaine);

        //Afficher pour une semaine donnée la liste des programmeurs triée dans
        //l’ordre décroissant selon le nombre de tasses consommées ;
        return consommeursSemaine;
    }

    //7-Afficher le nombre total de tasses de café consommé en une semaine donnée.
    public int nombreTotalTassesCafeSemaine()
    {
        if (this.listeProgrammeurs == null){
            System.out.println("Liste vide");
            return 0;
        }

        int noSemaine;
        System.out.println("Entrez le numero de la semaine : ");
        noSemaine = scanner.nextInt();

        if (noSemaine <= 0){
            System.out.println("Entree du numero de la semaine incorrect");
            return 0;
        }

        int total = 0;
        for (Programmeur programmeur : this.listeProgrammeurs) {
            if (programmeur.consommationCafesSemaine != null){
                for (Consos_Cafe consos_cafe : programmeur.consommationCafesSemaine) {
                    if (consos_cafe.getNo_Semaine() == noSemaine){
                        total += consos_cafe.getNb_Tasses();
                    }
                }
            }
        }
        return total;
    }


    public int rechercherIndiceProgrammeur(List<Programmeur> p, int id){
        for (Programmeur programmeur : p) {
            if (programmeur != null && programmeur.getId() == id) {
                return programmeur.getId();
            }
        }
        return -1;
    }

}

/*
 * // 1. Tri croissant (par la taille de la consommation de cafés)
        Collections.sort(consommeursSemaine, new Comparator<Programmeur>() {
            @Override
            public int compare(Programmeur o1, Programmeur o2) {
                return o1.getConsommationCafesSemaine().size() - o2.getConsommationCafesSemaine().size();
            }
        });
        System.out.println("Tri croissant: " + consommeursSemaine);

        // 2. Tri décroissant (par la taille de la consommation de cafés)
        Comparator<Programmeur> comparator = (p1, p2) -> Integer.compare(p2.getConsommationCafesSemaine().size(), p1.getConsommationCafesSemaine().size());
        consommeursSemaine.sort(comparator);
        System.out.println("Tri décroissant: " + consommeursSemaine);

        // 3. Inverser l'ordre pour revenir à un tri croissant
        consommeursSemaine.sort(comparator.reversed());
        System.out.println("Tri inversé (croissant à nouveau): " + consommeursSemaine);
    }
 */