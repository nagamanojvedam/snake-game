import java.util.Scanner;

public class SnakeGame {

    private int[] player;
    private int[] gameChart;

    public SnakeGame(int players) {

        player = new int[players];
        gameChart = new int[106];

    }

    public void startGame() {

        setLadders();
        setSnakes();

        boolean isCompleted = false;

        while (true) {

            for (int i = 0; i < player.length; i++) {

                int move = rollDice();
                int forward = player[i] + move;
                player[i] = forward + gameChart[forward];

                if (player[i] >= 100) {

                    System.out.println("Winner is Player " + (i + 1));
                    isCompleted = true;
                    break;

                }

                if (gameChart[forward] < 0)

                    System.out.println("Dice Rolled = " + move + ", " + "Snake ;( " + gameChart[forward] + " , "
                            + "player - " + (i + 1) + " position " + player[i] + ".");

                else if (gameChart[forward] > 0)

                    System.out.println("Dice Rolled = " + move + ", " + " Ladder :) " + gameChart[forward] + " , "
                            + "player - " + (i + 1) + " position " + player[i] + ".");

                else

                    System.out.println(
                            "Dice Rolled = " + move + ", " + "player - " + (i + 1) + " position " + player[i] + ".");

            }

            System.out.println("----------------------------------------");

            if (isCompleted)
                break;

        }

    }

    private void setSnakes() {

        // Snakes

        gameChart[17] = -10;
        gameChart[54] = -20;
        gameChart[62] = -43;
        gameChart[64] = -4;
        gameChart[87] = -51;
        gameChart[92] = -19;
        gameChart[95] = -20;
        gameChart[98] = -19;

    }

    private void setLadders() {

        // Ladders

        gameChart[1] = 38;
        gameChart[4] = 10;
        gameChart[9] = 22;
        gameChart[21] = 20;
        gameChart[28] = 64;
        gameChart[51] = 16;
        gameChart[72] = 18;
        gameChart[80] = 19;

    }

    private int rollDice() {

        return (int) (Math.random() * 6) + 1;

    }

    public static void main(String[] args) {

        int players = 0;
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Enter number of players (2 - 4) : ");
            players = scan.nextInt();

            if (players < 2 || players > 4) {

                System.out.print("Exceeded No of Players (2 - 4), Try Again !");
                continue;

            } else {

                SnakeGame game1 = new SnakeGame(players);
                game1.startGame();
                break;

            }

        }

    }

}
