import java.util.*;
import java.util.Scanner;

public class Main extends TicTacToe {

    public static void main(String[] args) {

        boolean playAgain = true;
        Scanner in = new Scanner(System.in);

        while(playAgain) {
            TicTacToe game = new TicTacToe();

            board = new String[9];
            turn = "X";
            String winner = null;

            for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a + 1);
            }

            System.out.println("Добро пожаловать на игру Крестики-нолики!");
            printBoard();

            System.out.println("Игрок (X), введите номер клетки для вашего хода:");

            while (winner == null) {
                int numInput;

                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Неверный формат, попробуйте ввести еще раз:");
                        continue;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Неверный формат, попробуйте ввести еще раз:");
                    continue;
                }

                if (board[numInput - 1].equals(String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    if (turn.equals("X")) {
                        turn = "O";
                    }
                    else {
                        turn = "X";
                    }

                    printBoard();
                    winner = checkWinner();
                }
                else {
                    System.out.println("Эта клетка занята, введите еще раз:");
                }
            }

            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Ничья!");
            }

            else {
                System.out.println("Поздравляем! Игрок  " + "(" + winner + ")" + ", победил!");
            }

            System.out.println("Сыграть еще раз? (да/нет)");
            String response = in.next();
            playAgain = response.equalsIgnoreCase("да");
        }
        System.out.println("Спасибо за игру!");
    }
}
