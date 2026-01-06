import java.util.Scanner;

public class Player {

    // renvoie tableau de 2 entiers ligne puis colone
    public static int[] Demande(char[][] tableau, int player) {
        Scanner scanner = new Scanner(System.in);
        int l, c;

        while (true) {
            System.out.println("Joueur " + player + ", a vous de jouer !");

            // saisie ligne
            System.out.print("Entrez une ligne (1-19) : ");
            if (scanner.hasNextInt()) {
                l = scanner.nextInt() - 1;
            } else {
                scanner.next(); // vider
                System.out.println("Erreur : Entrez un chiffre.");
                continue;
            }

            // saisie colonn
            System.out.print("\nEntrez une colonne (1-19) : ");
            if (scanner.hasNextInt()) {
                c = scanner.nextInt() - 1;
            } else {
                scanner.next();
                System.out.println("Erreur : Entrez un chiffre.");
                continue;
            }

            // verif
            if (l >= 0 && l < 19 && c >= 0 && c < 19) {
                if (tableau[l][c] != 'X' && tableau[l][c] != 'O') {
                    return new int[]{l, c};
                } else {
                    System.out.println("Il y a déjà un pion ici !");
                }
            } else {
                System.out.println("Hors du plateau (1-19)");
            }
        }
    }
}