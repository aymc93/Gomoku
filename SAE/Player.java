import java.util.Scanner;

public class Player {

    public static char[][] Demande(char[][] tableau, int player) {
        Scanner scanner = new Scanner(System.in);
        int ligne, colone;
        boolean coupValide = false;

        do {
            System.out.print("Joueur " + player + ", entrez une ligne (1-19) : ");
            ligne = scanner.nextInt();

            System.out.print("\nJoueur " + player + ", entrez une colonne (1-19) : ");
            colone = scanner.nextInt();

            int l = ligne - 1;
            int c = colone - 1;

            if (l >= 0 && l < 19 && c >= 0 && c < 19) {
                if (tableau[l][c] != 'X' && tableau[l][c] != 'O') {
                    coupValide = true;
                    if (player == 1) {
                        tableau[l][c] = 'X';
                    } else {
                        tableau[l][c] = 'O';
                    }
                } else {
                    System.out.println("Il y a déjà un pion ici ! Réessayez");
                }
            } else {
                System.out.println("Hors du plateau (doit être entre 1 et 19)");
            }
        } while (!coupValide);
        return tableau;
    }
}