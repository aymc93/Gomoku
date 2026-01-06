public class Verif {

    private static boolean estMemeJoueur(char[][] tab, int l, int c, char joueur) {
        // verif si c'est dans tableau
        if (l < 0 || l >= tab.length || c < 0 || c >= tab.length) {
            return false;
        }
        return Character.toUpperCase(tab[l][c]) == Character.toUpperCase(joueur);
    }

    private static boolean traiterVictoire(char[][] tab, int lDepart, int cDepart, int dL, int dC) {
        // verif s'il y a au moins un pion (en majuscule) dans les 5
        boolean nouveauPionTrouve = false;
        for (int k = 0; k < 5; k++) {
            if (Character.isUpperCase(tab[lDepart + k * dL][cDepart + k * dC])) {
                nouveauPionTrouve = true;
            }
        }

        // si oui on transforme tout en minuscule et on valide la victoire
        if (nouveauPionTrouve) {
            for (int k = 0; k < 5; k++) {
                int l = lDepart + k * dL;
                int c = cDepart + k * dC;
                tab[l][c] = Character.toLowerCase(tab[l][c]);
            }
            return true;
        }
        return false;
    }

    public static boolean validerEtMarquer(char[][] tab, char joueur, int lastL, int lastC) {
        // Directions : {dLig, dCol} -> Horizontal, Vertical, Diag \, Diag /
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        for (int[] dir : directions) {
            int dL = dir[0];
            int dC = dir[1];

            // compte combien de pions on a "avant" le dernier coup
            int compteAvant = 0;
            int tempL = lastL - dL;
            int tempC = lastC - dC;
            while (estMemeJoueur(tab, tempL, tempC, joueur)) {
                compteAvant++;
                tempL -= dL;
                tempC -= dC;
            }

            // compte combien de pions on a "après" le dernier coup
            int compteApres = 0;
            tempL = lastL + dL;
            tempC = lastC + dC;
            while (estMemeJoueur(tab, tempL, tempC, joueur)) {
                compteApres++;
                tempL += dL;
                tempC += dC;
            }

            // total (avant + après + le pion qu'on vient de poser)
            int total = compteAvant + compteApres + 1;

            // verif EXACTEMENT 5
            if (total == 5) {
                // verif les bornes (qu'il n'y ait pas un 6ème pion avant ou après qui invaliderait)
                int lAvant = lastL - (compteAvant + 1) * dL;
                int cAvant = lastC - (compteAvant + 1) * dC;
                int lApres = lastL + (compteApres + 1) * dL;
                int cApres = lastC + (compteApres + 1) * dC;

                boolean pasDePionAvant = !estMemeJoueur(tab, lAvant, cAvant, joueur);
                boolean pasDePionApres = !estMemeJoueur(tab, lApres, cApres, joueur);

                if (pasDePionAvant && pasDePionApres) {
                    // on calcule le point de départ de la ligne pour la colorier
                    int startL = lastL - (compteAvant * dL);
                    int startC = lastC - (compteAvant * dC);

                    if (traiterVictoire(tab, startL, startC, dL, dC)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}