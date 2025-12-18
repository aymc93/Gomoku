public class Plateau {

    public static final String RESET = "\u001B[0m";
    public static final String ROUGE = "\u001B[31m";  // joueur 1 (combo)
    public static final String VERT  = "\u001B[32m";  // joueur 2 (combo)
    public static final String JAUNE = "\u001B[33m";

    public static void AfficheTableau(char[][] tS) {
        String ligneSeparation = "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+";

        System.out.println(ligneSeparation);

        for (int i = 0; i < tS.length; i++) {
            for (int j = 0; j < tS[i].length; j++) {

                char pion = tS[i][j];
                String affichage;

                // couleur
                if (pion == 'x') {
                    // si pion deja marqué donc en minuscule alors il va se remettre en grand avec les couleurs
                    affichage = ROUGE + "X" + RESET;
                }
                else if (pion == 'o') {
                    // pareil que x
                    affichage = VERT + "O" + RESET;
                }
                else if (pion == 'X') {
                    affichage = "X";
                }
                else if (pion == 'O') {
                    affichage = "O";
                }
                else {
                    affichage = " ";
                }
                System.out.print("| " + affichage + " ");
            }
            System.out.println("|");
            System.out.println(ligneSeparation);
        }
    }


    public static char[][] plateau =
            {
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
            };

}
