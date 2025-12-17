public class Verif {

    public static boolean verifVictoire(char[][] tableau, char joueur) {
        int taille = tableau.length;
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {

                if (tableau[i][j] == joueur) {

                    // horizontal
                    if (j + 4 < taille) {
                        if (tableau[i][j+1] == joueur &&
                                tableau[i][j+2] == joueur &&
                                tableau[i][j+3] == joueur &&
                                tableau[i][j+4] == joueur) {

                            boolean pasDePionAvant = (j == 0) || (tableau[i][j-1] != joueur);
                            boolean pasDePionApres = (j + 5 >= taille) || (tableau[i][j+5] != joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                return true;
                            }
                        }
                    }

                    // verticale
                    if (i + 4 < taille) {
                        if (tableau[i+1][j] == joueur &&
                                tableau[i+2][j] == joueur &&
                                tableau[i+3][j] == joueur &&
                                tableau[i+4][j] == joueur) {

                            boolean pasDePionAvant = (i == 0) || (tableau[i-1][j] != joueur);
                            boolean pasDePionApres = (i + 5 >= taille) || (tableau[i+5][j] != joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                return true;
                            }
                        }
                    }

                    // diag desc
                    if (i + 4 < taille && j + 4 < taille) {
                        if (tableau[i+1][j+1] == joueur &&
                                tableau[i+2][j+2] == joueur &&
                                tableau[i+3][j+3] == joueur &&
                                tableau[i+4][j+4] == joueur) {

                            boolean pasDePionAvant = (i == 0 || j == 0) || (tableau[i-1][j-1] != joueur);
                            boolean pasDePionApres = (i + 5 >= taille || j + 5 >= taille) || (tableau[i+5][j+5] != joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                return true;
                            }
                        }
                    }

                    // diag asc
                    if (i + 4 < taille && j - 4 >= 0) {
                        if (tableau[i+1][j-1] == joueur &&
                                tableau[i+2][j-2] == joueur &&
                                tableau[i+3][j-3] == joueur &&
                                tableau[i+4][j-4] == joueur) {

                            boolean pasDePionAvant = (i == 0 || j == taille - 1) || (tableau[i-1][j+1] != joueur);
                            boolean pasDePionApres = (i + 5 >= taille || j - 5 < 0) || (tableau[i+5][j-5] != joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}