import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static GestionProgrammeur gestionProgrammeur = new GestionProgrammeur();

    public static void main(String[] args) throws FileNotFoundException{
        application();
    }

    public static int menu()
    {
        int choix;
        final Scanner clavier = new Scanner(System.in);
        do {
            System.out.println("Bienvenue dans l'application de gestion des programmeurs !");
            System.out.println("\n===== MENU PRINCIPAL =====");

            System.out.println("0. Lire une liste de programmeurs");
            System.out.println("1. Ajouter un programmeur");
            System.out.println("2. Afficher un programmeur");
            System.out.println("3. Afficher la listes programmeurs");
            System.out.println("4. Supprimer un programmeur");
            System.out.println("5. Changer le bureau d’un programmeur");
            System.out.println("6. consommeurs Cafes Semaine");
            System.out.println("7. le nombre total de tasses de café consommé par semaine");
            System.out.println("8. Quitter");
            System.out.print("Votre choix : ");

            while (!clavier.hasNextInt()) { // Vérifie si l'entrée est un entier
                System.out.println("Veuillez entrer un nombre valide !");
                clavier.next(); // Ignore l'entrée incorrecte
            }
            choix = clavier.nextInt();

            // Si l'entrée n'est pas dans le bon intervalle, on demande à l'utilisateur de recommencer
            if (choix < 0 || choix > 8) {
                System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 8.");
            }
            
        } while (choix<0 || choix > 8);

        return choix;
    }
    
    public static void application() throws FileNotFoundException {

        final Scanner clavier = new Scanner(System.in);
        //System.out.println("Bienvenue dans l'application de gestion des programmeurs !");
        int choix;
        choix = menu();
        switch (choix) {
            case 0:
                gestionProgrammeur = GestionProgrammeur.lireProgrammeurFile("programmeurs.txt");
                break;
            case 1:
                System.out.println("1. Ajouter un programmeur");
                gestionProgrammeur.ajouterProgrammeur();                
                break;
            case 2:
                System.out.println("2. Afficher un programmeur");
                gestionProgrammeur.afficherUnProgrammeur();
                //System.out.println(gestionProgrammeur);
                break;
            case 3:
                System.out.println("3. Afficher la listes programmeurs");
                gestionProgrammeur.afficherPlusieursProgrammeurs();
                break;
            case 4:
                System.out.println("4. Supprimer un programmeur");
                gestionProgrammeur.supprimerUnProgrammeur();
                break;
            case 5:
                System.out.println("5. Changer le bureau d’un programmeur");
                gestionProgrammeur.changerBureauProgrammeur();
                break;
            case 6:
                System.out.println("6. consommeurs Cafes Semaine");
                GestionProgrammeur consProgrammeur = new GestionProgrammeur(gestionProgrammeur);
                consProgrammeur.consommeursCafesSemaine();
                //System.out.println(consProgrammeur);
                break;
            case 7:
                System.out.println("7. le nombre total de tasses de café consommé par semaine");
                System.out.println("le nombre total de tasses de café consommé par semaine: " +
                        gestionProgrammeur.nombreTotalTassesCafeSemaine());
                //gestionProgrammeur.nombreTotalTassesCafeSemaine();
                break;
            case 8:
                System.out.println("8. Quitter");
                System.out.println("Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("Erreur ! Choix invalide.");
                break;
        }

        char choix2;
        do {
            System.out.println("Voulez-vous continuer ? (O/N)");

            if (clavier.hasNext()) {
                choix2 = Character.toUpperCase(clavier.next().charAt(0));// Convertir en majuscule
            } else {
                choix2 = ' '; // Valeur par défaut pour éviter une boucle infinie
                clavier.next(); // Ignorer l’entrée invalide
            }

            if (choix2 != 'O' && choix2 != 'N') {
                System.out.println("Erreur ! Veuillez entrer 'O' pour Oui ou 'N' pour Non.");
            }

        } while (choix2 != 'O' && choix2 != 'N');

        if (choix2 == 'N'){
            System.out.println("Au revoir !");
            System.exit(0);
        }
        else{
            application();
        }

    }
}