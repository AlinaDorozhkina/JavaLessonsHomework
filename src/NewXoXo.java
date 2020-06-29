import java.util.Random;
import java.util.Scanner;

public class NewXoXo {

    public static void main(String[] args) {
        int size =chooseField();
        letsPlay(size);
    }

    static int chooseField() {
        System.out.println("Let's play TIC TAC TOE!");
        System.out.println("Well,your sign is X, computer's sign is O.");
        System.out.println("The game has 2 options - the standard tic-tac-toe (field 3×3) and field 5×5, where you have to place 4 consecutive X to win.");
        System.out.println("Enter 3 for field 3×3 or 5 for field 5×5. Exit - 0");
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            size = scanner.nextInt();
            switch (size) {
                case 3:
                    size = 3;
                    break;
                case 5:
                    size = 5;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter 3 for field 3×3 or 5 for field 5×5. Exit - 0");
            }
        } while (size!=3&&size!=5&&size!=0);
        return size;
    }
    static void letsPlay(int size) {
        if (size == 0) {
            return;
        }
        char[][] gameField;
        char emptyPlace = '_';
        char compSign = '0';
        char userSign = 'X';
        gameField = createField(size,emptyPlace);
        printGameField(size,gameField);
        while (true) {
            userMove(size, gameField, emptyPlace, userSign);
            if (isSomebodyWin(userSign, size,gameField)) {
                System.out.println("You are a winner! Congratulations!");
                return;
            }
            if (isNobodyWin(size,gameField,emptyPlace)) {
                System.out.println("No winners");
                return;
            }
            compMove(size,gameField, emptyPlace, compSign, userSign);
            if (isSomebodyWin(compSign, size,gameField)) {
                System.out.println("Computer is a winner! You are looser!");
                return;
            }
            if (isNobodyWin(size,gameField,emptyPlace)) {
                System.out.println("No winners");
                return;
            }
        }
    }

    static char[][] createField(int size, char emptyPlace) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = emptyPlace;
            }
        }
        return field;
    }

    static void printGameField(int size, char [][]gameField) {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void userMove(int size,char[][]gameField, char emptyPlace, char userSign) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        do {
            System.out.println("Please enter coordinate of your move on the axis X");
            x = scanner.nextInt() - 1;
            System.out.println("Please enter coordinate of your move on the axis Y");
            y = scanner.nextInt() - 1;

        } while (!(isPlaceEmpty(y, x, size,gameField,emptyPlace)));

        gameField[y][x] = userSign;
        System.out.println("Updating....");
        printGameField(size, gameField);
    }

    static void compMove(int size, char[][]gameField, char emptyPlace,char compSign, char userSign) {
        if(findPlaceCompWin(size,gameField,emptyPlace, compSign)){
            return;
        } else if(findPlaceUserWin(size,gameField,emptyPlace,compSign,userSign)){
            return;
        } else {
            findRandomPlace(size,gameField, emptyPlace,compSign);
        }
    }

    static boolean findPlaceCompWin(int size, char [][]gameField,char emptyPlace, char compSign){
        for (int i=0; i<size;i++){
            for (int j=0;j<size;j++){
                if (isPlaceEmpty(i,j, size,gameField,emptyPlace)){
                    gameField[i][j]=compSign;
                    if (isSomebodyWin(compSign, size,gameField)) {
                        gameField[i][j]=compSign;
                        System.out.println(String.format("Computer comes to the  Х %d, Y %d", j + 1, i + 1));
                        System.out.println("Updating....");
                        printGameField(size,gameField);
                        return true;

                    } else {
                        gameField[i][j]=emptyPlace;
                    }

                }
            }
        }
        return false;
    }
    static boolean findPlaceUserWin(int size, char[][]gameField,char emptyPlace,char compSign, char userSign){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPlaceEmpty(i, j, size,gameField,emptyPlace)) {
                    gameField[i][j] = userSign;
                    if (isSomebodyWin(userSign, size,gameField)) {
                        gameField[i][j] = compSign;
                        System.out.println(String.format("Computer comes to the  Х %d, Y %d", j + 1, i + 1));
                        System.out.println("Updating....");
                        printGameField(size, gameField);
                        return true;

                    } else {
                        gameField[i][j] = emptyPlace;
                    }
                }
            }
        }
        return false;
    }
    static void findRandomPlace(int size,char[][]gameField,char emptyPlace,char compSign){
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!(isPlaceEmpty(x, y, size,gameField,emptyPlace)));
        gameField[x][y] = compSign;
        System.out.println(String.format("Computer comes to the  Х %d, Y %d", y + 1, x + 1));
        System.out.println("Updating....");
        printGameField(size,gameField);
    }

    static boolean isPlaceEmpty(int x, int y, int size, char[][]gameField,char emptyPlace) {
        if (x > size || x < 0 || y > size || y < 0) {
            return false;
        }
        if (gameField[x][y] == emptyPlace) {
            return true;
        }
        return false;

    }

    static boolean isSomebodyWin(char sign, int size,char[][]gameField) {
        if (size == 3) {
            for (int i = 0; i < size; i++) {
                if (gameField[i][0] == sign && gameField[i][1] == sign && gameField[i][2] == sign ||
                        gameField[0][i] == sign && gameField[1][i] == sign && gameField[2][i] == sign)
                    return true;
            }
            if (gameField[0][0] == sign && gameField[1][1] == sign && gameField[2][2] == sign ||
                    gameField[0][2] == sign && gameField[1][1] == sign && gameField[2][0] == sign)
                return true;
            return false;

        } else {
            for (int i = 0; i < size; i++) {
                if (gameField[0][i] == sign && gameField[1][i] == sign && gameField[2][i] == sign && gameField[3][i] == sign||
                        gameField[1][i] == sign && gameField[2][i] == sign && gameField[3][i] == sign && gameField[4][i] == sign||
                        gameField[i][0] == sign && gameField[i][1] == sign && gameField[i][2] == sign && gameField[i][3] == sign||
                        gameField[i][1] == sign && gameField[i][2] == sign && gameField[i][3] == sign && gameField[i][4] == sign)
                    return true;
            }
            for (int i=0; i<size;i++) {

            }


            if (gameField[1][3] == sign && gameField[2][2] == sign && gameField[3][1] == sign && gameField[4][0] == sign||
                    gameField[0][0] == sign && gameField[1][1] == sign && gameField[2][2] == sign && gameField[3][3] == sign||
                    gameField[1][1] == sign && gameField[2][2] == sign && gameField[3][3] == sign && gameField[4][4] == sign||
                    gameField[0][4] == sign && gameField[1][3] == sign && gameField[2][2] == sign && gameField[3][1] == sign||
                    gameField[0][1] == sign && gameField[1][2] == sign && gameField[2][3] == sign && gameField[3][4] == sign||
                    gameField[1][0] == sign && gameField[2][1] == sign && gameField[3][2] == sign && gameField[4][3] == sign||
                    gameField[3][0] == sign && gameField[2][1] == sign && gameField[1][2] == sign && gameField[1][3] == sign||
                    gameField[0][3] == sign && gameField[1][2] == sign && gameField[2][1] == sign && gameField[3][0] == sign)
                return true;
        }
        return false;
    }

    static boolean isNobodyWin(int size,char[][]gameField,char emptyPlace) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameField[i][j] == emptyPlace) {
                    return false;
                }
            }
        }
        return true;
    }

}
