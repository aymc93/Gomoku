public class Lanceur {
    public static void main(String[] args) {

        int scoreJ1 = 0;
        int scoreJ2 = 0;
        int pointsPourGagner = 5;

        while (scoreJ1 < pointsPourGagner && scoreJ2 < pointsPourGagner) {

            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    Plateau.plateau[i][j] = ' ';
                }
            }

            System.out.println("NOUVELLE MANCHE !");
            System.out.println("Score actuel -> J1: " + scoreJ1 + " | J2: " + scoreJ2);




            int joueurActuel = 1;
            boolean mancheGagnee = false;

            while (!mancheGagnee) {

                Plateau.AfficheTableau(Plateau.plateau);
                Plateau.plateau = Player.Demande(Plateau.plateau, joueurActuel);

                char symbole = (joueurActuel == 1) ? 'X' : 'O';

                if (Verif.verifVictoire(Plateau.plateau, symbole)) {
                    Plateau.AfficheTableau(Plateau.plateau);
                    System.out.println("Le joueur " + joueurActuel + " remporte la manche !");

                    if (joueurActuel == 1) {
                        scoreJ1++;
                    } else {
                        scoreJ2++;
                    }
                    mancheGagnee = true;
                } else {
                    joueurActuel = (joueurActuel == 1) ? 2 : 1;
                }
            }
        }


        System.out.println("=================================");
        if (scoreJ1 > scoreJ2) {
            System.out.println("VICTOIRE FINALE DU JOUEUR 1 !");
        } else {
            System.out.println("VICTOIRE FINALE DU JOUEUR 2 !");
        }
        System.out.println("Score final : " + scoreJ1 + " - " + scoreJ2);
    }
}