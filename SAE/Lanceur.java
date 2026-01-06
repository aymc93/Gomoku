import java.util.Scanner;

public class Lanceur {

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            int choix = AffichageMenu.afficherMenuPrincipal();
            switch (choix) {
                case 1:
                    jouerPartie();
                    break;
                case 2:
                    AffichageMenu.afficherRegles();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    continuer = false;
                    break;
            }
        }
    }

    public static void jouerPartie() {
        int scoreJ1 = 0;
        int scoreJ2 = 0;
        int pointsPourGagner = 5;

        // reset du plateau
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                Plateau.plateau[i][j] = ' ';
            }
        }

        int joueurActuel = 1;

        while (scoreJ1 < pointsPourGagner && scoreJ2 < pointsPourGagner) {
            Plateau.AfficheTableau(Plateau.plateau);
            System.out.println("Score -> J1: " + scoreJ1 + " | J2: " + scoreJ2);

            // récupère les coordonnées jouées
            int[] coords = Player.Demande(Plateau.plateau, joueurActuel);
            int lig = coords[0];
            int col = coords[1];

            // met à jour le plateau
            char symbole = (joueurActuel == 1) ? 'X' : 'O';
            Plateau.plateau[lig][col] = symbole;

            // appelle la vérification
            if (Verif.validerEtMarquer(Plateau.plateau, symbole, lig, col)) {
                System.out.println("Le joueur " + joueurActuel + " marque 1 point !");

                if (joueurActuel == 1) scoreJ1++;
                else scoreJ2++;
            }

            // changement de joueur
            joueurActuel = (joueurActuel == 1) ? 2 : 1;
        }

        // fin de partie
        Plateau.AfficheTableau(Plateau.plateau);
        System.out.println("VICTOIRE FINALE : " + (scoreJ1 > scoreJ2 ? "JOUEUR 1" : "JOUEUR 2"));
        System.out.println("Appuyez sur Entrée...");
        new Scanner(System.in).nextLine();
    }
}