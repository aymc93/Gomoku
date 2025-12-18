import java.util.Scanner;

public class Lanceur {

    // optimisr pour la verification qu'il ne parcour pas tout le tableau
    //séparer la verif diag hori verti en plusieurs sous méthode




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
                    System.out.println("Fermeture du jeu. À bientôt !");
                    continuer = false;
                    break;
            }
        }
    }

    public static void jouerPartie() {

        int scoreJ1 = 0;
        int scoreJ2 = 0;
        int pointsPourGagner = 5;

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                Plateau.plateau[i][j] = ' ';
            }
        }

        int joueurActuel = 1;

        while (scoreJ1 < pointsPourGagner && scoreJ2 < pointsPourGagner) {

            Plateau.AfficheTableau(Plateau.plateau);
            System.out.println("Score -> J1: " + scoreJ1 + " | J2: " + scoreJ2);

            // joueur joue
            Plateau.plateau = Player.Demande(Plateau.plateau, joueurActuel);

            char symbole;
            if (joueurActuel == 1) {
                symbole = 'X';
            } else {
                symbole = 'O';
            }

            if (Verif.validerEtMarquer(Plateau.plateau, symbole)) {

                System.out.println("Le joueur "+ joueurActuel +" a marqué 1 point !");

                // score
                if (joueurActuel == 1) {
                    scoreJ1++;
                } else {
                    scoreJ2++;
                }

            }
            joueurActuel = (joueurActuel == 1) ? 2 : 1;
        }

        // fin du jeu
        Plateau.AfficheTableau(Plateau.plateau); // plateau final
        System.out.println("=================================");
        if (scoreJ1 > scoreJ2) {
            System.out.println("VICTOIRE DU JOUEUR 1 !");
        } else {
            System.out.println("VICTOIRE DU JOUEUR 2 !");
        }
        System.out.println("Score final : " + scoreJ1 + " - " + scoreJ2);


        System.out.println("\nAppuyez sur Entrée pour revenir au menu...");
        new Scanner(System.in).nextLine();
    }
}