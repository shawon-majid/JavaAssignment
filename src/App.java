import java.nio.channels.NonReadableChannelException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = 'O';
            }
        }

        String land = in.nextLine();

        for (int i = 0; i < land.length(); i++) {
            if (land.charAt(i) == ',') {
                int x = Character.getNumericValue(land.charAt(i - 1));
                int y = Character.getNumericValue(land.charAt(i + 1));
                grid[x][y] = 'X';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = in.next().charAt(0);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        int numberOfBottle = in.nextInt();

        ArrayList<Bottle> bottles = new ArrayList<Bottle>(numberOfBottle);

        for (int i = 0; i < numberOfBottle; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String bottleName = in.nextLine().trim();

            String message = in.nextLine();
            bottles.add(i, new Bottle(x, y, bottleName, message));
        }

        System.out.println("Problem 1:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        for (Bottle b : bottles) {
            System.out
                    .println("Bottle named \"" + b.getName() + "\" starting at (" + b.getX() + ", " + b.getY() + ")\n");
        }

        System.out.println("Problem 2:");

        boolean[] landed = new boolean[numberOfBottle];

        for (int i = 0; i < numberOfBottle; i++)
            landed[i] = false;

        for (Bottle b : bottles) {
            System.out.println(b.getName() + ": Starting at (" + b.getX() + ", " + b.getY() + ")");
        }

        int iteration = 0;

        while (bottles.size() > 0 || iteration < 100) {

            ArrayList<Integer> toRemove = new ArrayList<Integer>();

            for (int i = 0; i < bottles.size(); i++) {
                Bottle b = bottles.get(i);

                if (grid[b.getX()][b.getY()] == 'X') {
                    toRemove.add(i);
                    System.out.println(
                            iteration + ": " + b.getName() + " at (" + b.getX() + "," + b.getY() + "): LANDED!");
                    System.out.println("<<MESSAGE RECEIVED: " + b.getMessage() + ">>");
                } else {
                    char instruction = grid[b.getX()][b.getY()];
                    System.out.println(iteration + ": " + b.getName() + " at (" + b.getX() + "," + b.getY()
                            + "): In ocean, current taking it " + instruction + ".");
                    b.take(instruction);
                }
            }

            for (int i = 0; i < toRemove.size(); i++) {
                int index = toRemove.get(i);
                bottles.remove(index);
            }

            iteration++;
        }

        in.close();

    }
}
