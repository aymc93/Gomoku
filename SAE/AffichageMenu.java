import java.util.Scanner;

public class AffichageMenu {

    public static final String ROUGE = "\u001B[31m";
    public static final String VERT  = "\u001B[32m";
    public static final String JAUNE = "\u001B[33m";
    public static final String CYAN  = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void afficherTitre() {
        System.out.println(CYAN);
        System.out.println("   ______  _____  __  __  _____  _   __ __  __");
        System.out.println("  / ____/ / __  /|  \\/  |/  _  \\| | / // / / /");
        System.out.println(" / / __  / / / / | .  . || / / || |/ // / / / ");
        System.out.println("/ /_/ / / /_/ /  | |\\/| || \\_/ ||   / / /_/ /  ");
        System.out.println("\\____/  \\____/   |_|  |_|\\_____/|_|\\_\\\\____/   ");
        System.out.println(RESET);
    }

    public static int afficherMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix < 1 || choix > 3) {
            System.out.println("\n\n");

            afficherTitre();

            System.out.println(JAUNE + "╔══════════════════════════════════════╗" + RESET);
            System.out.println(JAUNE + "║" + RESET + "           MENU PRINCIPAL             " + JAUNE + "║" + RESET);
            System.out.println(JAUNE + "╠══════════════════════════════════════╣" + RESET);
            System.out.println(JAUNE + "║" + RESET + " 1. " + VERT + "JOUER UNE PARTIE" + RESET + "                  " + JAUNE + "║" + RESET);
            System.out.println(JAUNE + "║" + RESET + " 2. " + CYAN + "RÈGLES DU JEU" + RESET + "                     " + JAUNE + "║" + RESET);
            System.out.println(JAUNE + "║" + RESET + " 3. " + ROUGE + "QUITTER" + RESET + "                           " + JAUNE + "║" + RESET);
            System.out.println(JAUNE + "╚══════════════════════════════════════╝" + RESET);
            System.out.print("   Votre choix : ");

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
            } else {
                scanner.next(); // On vide le buffer si l'utilisateur tape des lettres
            }
        }
        return choix;
    }

    public static void afficherRegles() {
        System.out.println(CYAN + "\n        === RÈGLES DU GOMOKU ===" + RESET);
        System.out.println("1. Le but est d'aligner " + VERT + "5 pions" + RESET + " de sa couleur.");
        System.out.println("2. L'alignement peut être horizontal, vertical ou diagonal.");
        System.out.println("3. " + ROUGE + "ATTENTION" + RESET + " : Il faut aligner EXACTEMENT 5 pions.");
        System.out.println("   (6 pions ou plus ne comptent pas pour la victoire).");
        System.out.println("4. Vous pouvez réutiliser un pion d'une ligne déjà validée");
        System.out.println("   pour créer une nouvelle ligne dans une autre direction.");
        System.out.println("\nAppuyez sur une touche pour revenir au menu...");
        new Scanner(System.in).nextLine();
    }
}