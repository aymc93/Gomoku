import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VerifTest {

    // plateau vide a chaque test
    private char[][] vide() {
        char[][] t = new char[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                t[i][j] = ' ';
            }
        }
        return t;
    }

    @Test
    void testVictoiresClassiques() {
        // hori
        char[][] p1 = vide();
        // 5 pions
        p1[10][5] = 'X'; p1[10][6] = 'X'; p1[10][7] = 'X'; p1[10][8] = 'X'; p1[10][9] = 'X';
        assertTrue(Verif.validerEtMarquer(p1, 'X', 10, 9), "cas horizontal simple");

        // verti
        char[][] p2 = vide();
        p2[2][2] = 'O'; p2[3][2] = 'O'; p2[4][2] = 'O'; p2[5][2] = 'O'; p2[6][2] = 'O';
        // test le dernier pion posé en (6, 2)
        assertTrue(Verif.validerEtMarquer(p2, 'O', 6, 2), "cas vertical simple");

        // diag desc (\)
        char[][] p3 = vide();
        p3[0][0] = 'X'; p3[1][1] = 'X'; p3[2][2] = 'X'; p3[3][3] = 'X'; p3[4][4] = 'X';
        // test le dernier pion posé en (4, 4)
        assertTrue(Verif.validerEtMarquer(p3, 'X', 4, 4), "cas diagonale descendante");

        // diag asc (/)
        char[][] p4 = vide();
        p4[5][5] = 'O'; p4[4][6] = 'O'; p4[3][7] = 'O'; p4[2][8] = 'O'; p4[1][9] = 'O';
        // test le dernier pion posé en (1, 9)
        assertTrue(Verif.validerEtMarquer(p4, 'O', 1, 9), "cas diagonale montante");
    }

    @Test
    void testReglesStrictesEtEchecs() {
        // pas assez de pions (4)
        char[][] p1 = vide();
        p1[0][0] = 'X'; p1[0][1] = 'X'; p1[0][2] = 'X'; p1[0][3] = 'X';
        // On teste sur le dernier pion (0, 3) -> Doit échouer
        assertFalse(Verif.validerEtMarquer(p1, 'X', 0, 3), "cas 4 pions (insuffisant)");

        // trop de pions (6 ou plus)
        char[][] p2 = vide();
        p2[10][5] = 'X'; p2[10][6] = 'X'; p2[10][7] = 'X'; p2[10][8] = 'X'; p2[10][9] = 'X'; p2[10][10] = 'X';
        // On teste sur le 6ème pion (10, 10) -> Doit échouer car > 5
        assertFalse(Verif.validerEtMarquer(p2, 'X', 10, 10), "cas 6 pions (trop de pions)");

        // ligne coupée par l'adversaire (XXOXX)
        char[][] p3 = vide();
        p3[5][5] = 'X'; p3[5][6] = 'X';
        p3[5][7] = 'O'; // Intrus
        p3[5][8] = 'X'; p3[5][9] = 'X';
        // On teste sur le dernier X (5, 9) -> Doit échouer
        assertFalse(Verif.validerEtMarquer(p3, 'X', 5, 9), "cas ligne coupée par adversaire");

        // ligne coupée par un vide (XX XX)
        char[][] p4 = vide();
        p4[5][5] = 'O'; p4[5][6] = 'O';
        p4[5][7] = ' '; // Vide
        p4[5][8] = 'O'; p4[5][9] = 'O';
        assertFalse(Verif.validerEtMarquer(p4, 'O', 5, 9), "cas ligne coupée par vide");
    }

    @Test
    void testModificationDuPlateau() {
        // verif que le code change bien les majuscules en minuscules après une victoire

        char[][] p = vide();
        p[0][0] = 'X'; p[0][1] = 'X'; p[0][2] = 'X'; p[0][3] = 'X'; p[0][4] = 'X';

        // valide la victoire sur le dernier pion (0, 4)
        boolean victoire = Verif.validerEtMarquer(p, 'X', 0, 4);

        assertTrue(victoire, "La victoire doit être validée");

        // verif que les pions sont devenus minuscule
        assertEquals('x', p[0][0], "Le pion 1 doit devenir minuscule");
        assertEquals('x', p[0][1], "Le pion 2 doit devenir minuscule");
        assertEquals('x', p[0][2], "Le pion 3 doit devenir minuscule");
        assertEquals('x', p[0][3], "Le pion 4 doit devenir minuscule");
        assertEquals('x', p[0][4], "Le pion 5 doit devenir minuscule");
    }

    @Test
    void testRevalidationLigneDejaGagnee() {
        // si une ligne est déjà gagnée (déjà en minuscule) elle ne doit pas recompter un point

        char[][] p = vide();
        // simule une ligne déjà gagnée (minuscules)
        p[0][0] = 'x'; p[0][1] = 'x'; p[0][2] = 'x'; p[0][3] = 'x'; p[0][4] = 'x';

        assertFalse(Verif.validerEtMarquer(p, 'X', 0, 4), "Une ligne déjà validée (minuscule) ne doit pas donner de nouvelle victoire");
    }
}