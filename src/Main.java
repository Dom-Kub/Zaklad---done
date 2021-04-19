
/**
 * Created by IntelliJ IDEA.
 * User: Dominik-PC

 */
public class Main {

    public static void main(String[] args) {

      // príklad z prezentácie

        int[][] cenaHrany = {{0, 0, 30, 0, 0, 0},
                             {0, 0, 0, 30, 0, 0},
                             {0, 10, 0, 0, 60, 0},
                             {0, 0, 80, 0, 0, 20},
                             {30, 90, 0, 0, 0, 150},
                             {0, 0, 0, 0, 0, 0}};

        int zaciatocnyBod = 4;

        int[][] pos = new int[cenaHrany.length][3];
        for (int i = 0; i < pos.length; i++) {
            pos[i][0] = 0;
            pos[i][1] = Integer.MAX_VALUE;
            pos[i][2] = -1;
        }
        pos[zaciatocnyBod][1] = 0;

        // alogiritmus
        boolean p = true;
        while (p) {
            p = false;
            for (int i = 0; i < pos.length; i++) {
                for (int j = 0; j < cenaHrany.length; j++) {
                    if (cenaHrany[i][j] != 0 && pos[i][1] != Integer.MAX_VALUE) {
                        if (pos[j][1] > pos[i][1] + cenaHrany[i][j]) {
                            pos[j][0] = 1;

                            pos[j][1] = pos[i][1] + cenaHrany[i][j];

                            pos[j][2] = i;


                            p = true;
                        }else {
                            p = false;
                        }
                    }else {
                        p = false;
                    }
                }
            }
        }


        // Vypisanie najkratsich ciest
        int x;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i][1] != 0 && pos[i][1] != Integer.MAX_VALUE) {
                x = i;
                System.out.println("Pre uzol: " + i + " najkratšia cesta: ");
                System.out.print(i + " ");
                while (true) {

                    x = pos[x][2];
                    System.out.print(x + " ");


                    if (pos[x][2] == -1) {
                        break;
                    }
                }
                System.out.print(" hodnota: " + pos[i][1]);
                System.out.println("\n");
            }

            if (pos[i][1] == 0) {
                System.out.println("Pre uzol: " + i + " najkratšia cesta: ");
                System.out.println("Initial node\n");
            }


            if (pos[i][1] == Integer.MAX_VALUE) {
                System.out.println("Pre uzol: " + i + " najkratšia cesta: ");
                System.out.print("žiadna cesta\n");
                System.out.println();
            }



        }
    }
}