import java.util.Random;
import java.util.Scanner;

public class XoXo {
    static char[][] gameField;
    static int size;
    static final char EMPTY_PLACE = '_';
    static char userSign = 'X';
    static char compSign = '0';
    static String name;

    public static void main(String[] args) {
        chooseField();
        letsPlay();
    }

    static void chooseField(){
        System.out.println("Let's play TIC TAC TOE! What's your name?");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println(String.format("Well, %s, your sign is %s, computer's sign is %s.", name, userSign, compSign));
        System.out.println("The game has 2 options - the standard tic-tac-toe field 3×3 and field 5×5, where you have to place 4 consecutive X to win." );
        System.out.println("Enter 3 for field 3×3 or 5 for field 5×5");
        size = scanner.nextInt();
        switch (size){
            case 3: size =3;
                break;
            case 5: size =5;
                break;
        }

    }
    static void letsPlay() {

        gameField = createField(size);
        printGameField();
        while (true) {
            userMove();
            if (isSomebodyWin(userSign)) {
                System.out.println(String.format("%s is a winner! Congratulations!", name));
                return;
            }
            if (isNobodyWin()) {
                System.out.println("No winners");
                return;
            }
            compMove();
            if (isSomebodyWin(compSign)) {
                System.out.println("Computer is a winner! You are looser!");
                return;
            }
            if (isNobodyWin()) {
                System.out.println("No winners");
                return;
            }
        }
    }

    static char[][] createField(int size) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = EMPTY_PLACE;
            }
        }
        return field;
    }

    static void printGameField() {
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

    static void userMove() {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        do {
            System.out.println("Please enter coordinate of your move on the axis X");
            x = scanner.nextInt() - 1;
            System.out.println("Please enter coordinate of your move on the axis Y");
            y = scanner.nextInt() - 1;

        } while (!(isPlaceEmpty(y, x)));

        gameField[y][x] = userSign;
        System.out.println("Updating....");
        printGameField();
    }

    static void compMove() {
        if(findPlaceCompWin()){
            return;
        } else if(findPlaceUserWin()){
            return;
        } else {
            findRandomPlace();
        }
    }

    static boolean findPlaceCompWin(){
        for (int i=0; i<size;i++){
            for (int j=0;j<size;j++){
                if (isPlaceEmpty(i,j)){
                    gameField[i][j]=compSign;
                    if (isSomebodyWin(compSign)) {
                        gameField[i][j]=compSign;
                        System.out.println(String.format("Computer comes to the  Х %d, Y %d", j + 1, i + 1));
                        System.out.println("Updating....");
                        printGameField();
                        return true;

                    } else {
                        gameField[i][j]=EMPTY_PLACE;
                    }

                }
            }
        }
        return false;
    }
    static boolean findPlaceUserWin(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPlaceEmpty(i, j)) {
                    gameField[i][j] = userSign;
                    if (isSomebodyWin(userSign)) {
                        gameField[i][j] = compSign;
                        System.out.println(String.format("Computer comes to the  Х %d, Y %d", j + 1, i + 1));
                        System.out.println("Updating....");
                        printGameField();
                        return true;

                    } else {
                        gameField[i][j] = EMPTY_PLACE;
                    }
                }
            }
        }
        return false;
    }
    static void findRandomPlace(){
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!(isPlaceEmpty(x, y)));
        gameField[x][y] = compSign;
        System.out.println(String.format("Computer comes to the  Х %d, Y %d", y + 1, x + 1));
        System.out.println("Updating....");
        printGameField();
    }

    static boolean isPlaceEmpty(int x, int y) {
        if (x > size || x < 0 || y > size || y < 0) {
            return false;
        }
        if (gameField[x][y] == EMPTY_PLACE) {
            return true;
        }
        return false;

    }

    static boolean isSomebodyWin(char sign) {
        if (size == 3) {
            for (int i = 0; i < size; i++) {
                if (gameField[i][0] == sign && gameField[i][1] == sign && gameField[i][2] == sign ||
                        gameField[0][i] == sign && gameField[1][i] == sign && gameField[2][i] == sign ||
                        gameField[0][0] == sign && gameField[1][1] == sign && gameField[2][2] == sign ||
                        gameField[0][2] == sign && gameField[1][1] == sign && gameField[2][0] == sign) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (gameField[0][i] == sign && gameField[1][i] == sign && gameField[2][i] == sign && gameField[3][i] == sign ||
                        gameField[1][i] == sign && gameField[2][i] == sign && gameField[3][i] == sign && gameField[4][i] == sign ||
                        gameField[i][0] == sign && gameField[i][1] == sign && gameField[i][2] == sign && gameField[i][3] == sign ||
                        gameField[i][1] == sign && gameField[i][2] == sign && gameField[i][3] == sign && gameField[i][4] == sign ||
                        gameField[1][3] == sign && gameField[2][2] == sign && gameField[3][1] == sign && gameField[4][0] == sign ||
                        gameField[0][0] == sign && gameField[1][1] == sign && gameField[2][2] == sign && gameField[3][3] == sign ||
                        gameField[1][1] == sign && gameField[2][2] == sign && gameField[3][3] == sign && gameField[4][4] == sign ||
                        gameField[0][4] == sign && gameField[1][3] == sign && gameField[2][2] == sign && gameField[3][1] == sign) {
                    return true;

                }
            }
        }
        return false;
    }

    static boolean isNobodyWin() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameField[i][j] == EMPTY_PLACE) {
                    return false;
                }
            }
        }
        return true;
    }




}