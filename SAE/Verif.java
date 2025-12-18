public class Verif {

    private static boolean estMemeJoueur(char caseDuTableau, char joueur) {
        return Character.toUpperCase(caseDuTableau) == Character.toUpperCase(joueur);
    }

    // verif si la ligne contient au moins un nouveau
    private static boolean contientNouveauPion(char p1, char p2, char p3, char p4, char p5) {
        return Character.isUpperCase(p1) || Character.isUpperCase(p2) ||
                Character.isUpperCase(p3) || Character.isUpperCase(p4) || Character.isUpperCase(p5);
    }

    public static boolean validerEtMarquer(char[][] tableau, char joueur) {
        int taille = tableau.length;

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {

                // verif si la case de départ est au joueur (X ou x)
                if (estMemeJoueur(tableau[i][j], joueur)) {

                    // hori
                    if (j + 4 < taille) {
                        if (estMemeJoueur(tableau[i][j+1], joueur) &&
                                estMemeJoueur(tableau[i][j+2], joueur) &&
                                estMemeJoueur(tableau[i][j+3], joueur) &&
                                estMemeJoueur(tableau[i][j+4], joueur)) {

                            // verif exactement 5
                            boolean pasDePionAvant = (j == 0) || !estMemeJoueur(tableau[i][j-1], joueur);
                            boolean pasDePionApres = (j + 5 >= taille) || !estMemeJoueur(tableau[i][j+5], joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                // nouvelle victoire ?
                                if (contientNouveauPion(tableau[i][j], tableau[i][j+1], tableau[i][j+2], tableau[i][j+3], tableau[i][j+4])) {
                                    // si oui on transforme tout en minuscule et on renvoie true
                                    tableau[i][j] = Character.toLowerCase(tableau[i][j]);
                                    tableau[i][j+1] = Character.toLowerCase(tableau[i][j+1]);
                                    tableau[i][j+2] = Character.toLowerCase(tableau[i][j+2]);
                                    tableau[i][j+3] = Character.toLowerCase(tableau[i][j+3]);
                                    tableau[i][j+4] = Character.toLowerCase(tableau[i][j+4]);
                                    return true;
                                }
                            }
                        }
                    }

                    // verti
                    if (i + 4 < taille) {
                        if (estMemeJoueur(tableau[i+1][j], joueur) &&
                                estMemeJoueur(tableau[i+2][j], joueur) &&
                                estMemeJoueur(tableau[i+3][j], joueur) &&
                                estMemeJoueur(tableau[i+4][j], joueur)) {

                            boolean pasDePionAvant = (i == 0) || !estMemeJoueur(tableau[i-1][j], joueur);
                            boolean pasDePionApres = (i + 5 >= taille) || !estMemeJoueur(tableau[i+5][j], joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                if (contientNouveauPion(tableau[i][j], tableau[i+1][j], tableau[i+2][j], tableau[i+3][j], tableau[i+4][j])) {
                                    tableau[i][j] = Character.toLowerCase(tableau[i][j]);
                                    tableau[i+1][j] = Character.toLowerCase(tableau[i+1][j]);
                                    tableau[i+2][j] = Character.toLowerCase(tableau[i+2][j]);
                                    tableau[i+3][j] = Character.toLowerCase(tableau[i+3][j]);
                                    tableau[i+4][j] = Character.toLowerCase(tableau[i+4][j]);
                                    return true;
                                }
                            }
                        }
                    }

                    // diag desc (\)
                    if (i + 4 < taille && j + 4 < taille) {
                        if (estMemeJoueur(tableau[i+1][j+1], joueur) &&
                                estMemeJoueur(tableau[i+2][j+2], joueur) &&
                                estMemeJoueur(tableau[i+3][j+3], joueur) &&
                                estMemeJoueur(tableau[i+4][j+4], joueur)) {

                            boolean pasDePionAvant = (i == 0 || j == 0) || !estMemeJoueur(tableau[i-1][j-1], joueur);
                            boolean pasDePionApres = (i + 5 >= taille || j + 5 >= taille) || !estMemeJoueur(tableau[i+5][j+5], joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                if (contientNouveauPion(tableau[i][j], tableau[i+1][j+1], tableau[i+2][j+2], tableau[i+3][j+3], tableau[i+4][j+4])) {
                                    tableau[i][j] = Character.toLowerCase(tableau[i][j]);
                                    tableau[i+1][j+1] = Character.toLowerCase(tableau[i+1][j+1]);
                                    tableau[i+2][j+2] = Character.toLowerCase(tableau[i+2][j+2]);
                                    tableau[i+3][j+3] = Character.toLowerCase(tableau[i+3][j+3]);
                                    tableau[i+4][j+4] = Character.toLowerCase(tableau[i+4][j+4]);
                                    return true;
                                }
                            }
                        }
                    }

                    // diag asc (/)
                    if (i + 4 < taille && j - 4 >= 0) {
                        if (estMemeJoueur(tableau[i+1][j-1], joueur) &&
                                estMemeJoueur(tableau[i+2][j-2], joueur) &&
                                estMemeJoueur(tableau[i+3][j-3], joueur) &&
                                estMemeJoueur(tableau[i+4][j-4], joueur)) {

                            boolean pasDePionAvant = (i == 0 || j == taille - 1) || !estMemeJoueur(tableau[i-1][j+1], joueur);
                            boolean pasDePionApres = (i + 5 >= taille || j - 5 < 0) || !estMemeJoueur(tableau[i+5][j-5], joueur);

                            if (pasDePionAvant && pasDePionApres) {
                                if (contientNouveauPion(tableau[i][j], tableau[i+1][j-1], tableau[i+2][j-2], tableau[i+3][j-3], tableau[i+4][j-4])) {
                                    tableau[i][j] = Character.toLowerCase(tableau[i][j]);
                                    tableau[i+1][j-1] = Character.toLowerCase(tableau[i+1][j-1]);
                                    tableau[i+2][j-2] = Character.toLowerCase(tableau[i+2][j-2]);
                                    tableau[i+3][j-3] = Character.toLowerCase(tableau[i+3][j-3]);
                                    tableau[i+4][j-4] = Character.toLowerCase(tableau[i+4][j-4]);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}