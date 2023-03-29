public class Bottle {
    private int x, y;
    private String name;
    private String message;

    Bottle(int x, int y, String name, String message) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.message = message;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void take(char instruction) {
        if (instruction == 'N') {
            x--;
        } else if (instruction == 'S') {
            x++;
        } else if (instruction == 'E') {
            y++;
        } else if (instruction == 'W') {
            y--;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Bottle Name: " + name + "\nBottlePos: " + x + " " + y + "\n" + "message: " + message + "\n";
    }

}
