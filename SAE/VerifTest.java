import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerifTest {

    // --- Méthode utilitaire pour créer un plateau vide rapidement ---
    // Cela évite de copier-coller la boucle for dans chaque test
    private char[][] creerPlateauVide() {
        char[][] plateau = new char[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                plateau[i][j] = ' ';
            }
        }
        return plateau;
    }

    // --- TEST 1 : Victoire Horizontale Standard ---
    @Test
    public void testVictoireHorizontaleValide() {
        char[][] plateau = creerPlateauVide();

        // On place 5 pions X sur la ligne 10
        plateau[10][5] = 'X';
        plateau[10][6] = 'X';
        plateau[10][7] = 'X';
        plateau[10][8] = 'X';
        plateau[10][9] = 'X';

        // On s'attend à ce que la fonction réponde TRUE (Vrai)
        assertTrue(Verif.verifVictoire(plateau, 'X'), "5 pions horizontaux devraient gagner");
    }

    // --- TEST 2 : Victoire Verticale Standard ---
    @Test
    public void testVictoireVerticaleValide() {
        char[][] plateau = creerPlateauVide();

        // On place 5 pions O sur la colonne 2
        plateau[2][2] = 'O';
        plateau[3][2] = 'O';
        plateau[4][2] = 'O';
        plateau[5][2] = 'O';
        plateau[6][2] = 'O';

        assertTrue(Verif.verifVictoire(plateau, 'O'), "5 pions verticaux devraient gagner");
    }

    // --- TEST 3 : Victoire Diagonale (\) ---
    @Test
    public void testVictoireDiagonaleDescendante() {
        char[][] plateau = creerPlateauVide();

        plateau[0][0] = 'X';
        plateau[1][1] = 'X';
        plateau[2][2] = 'X';
        plateau[3][3] = 'X';
        plateau[4][4] = 'X';

        assertTrue(Verif.verifVictoire(plateau, 'X'), "5 pions en diagonale devraient gagner");
    }

    // --- TEST 4 : Règle des 6 pions (Overline) ---
    // C'est le test le plus important pour ton code !
    @Test
    public void testOverlineInvalide() {
        char[][] plateau = creerPlateauVide();

        // On place 6 pions alignés (interdit !)
        plateau[10][5] = 'X';
        plateau[10][6] = 'X';
        plateau[10][7] = 'X';
        plateau[10][8] = 'X';
        plateau[10][9] = 'X';
        plateau[10][10] = 'X'; // Le 6ème pion

        // On s'attend à ce que la fonction réponde FALSE (Faux)
        assertFalse(Verif.verifVictoire(plateau, 'X'), "6 pions alignés ne doivent PAS donner la victoire");
    }

    // --- TEST 5 : Pas assez de pions (4 pions) ---
    @Test
    public void testPasAssezDePions() {
        char[][] plateau = creerPlateauVide();

        plateau[5][5] = 'O';
        plateau[5][6] = 'O';
        plateau[5][7] = 'O';
        plateau[5][8] = 'O';
        // Pas de 5ème pion

        assertFalse(Verif.verifVictoire(plateau, 'O'), "4 pions ne doivent pas suffire");
    }

    // --- TEST 6 : Ligne coupée (XX O XX) ---
    @Test
    public void testLigneCoupee() {
        char[][] plateau = creerPlateauVide();

        plateau[5][5] = 'X';
        plateau[5][6] = 'X';
        plateau[5][7] = 'O'; // Un intrus au milieu
        plateau[5][8] = 'X';
        plateau[5][9] = 'X';

        assertFalse(Verif.verifVictoire(plateau, 'X'), "Une ligne coupée par l'adversaire ne doit pas gagner");
    }
}