import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        System.out.println ("В какую игру хотите сыграть ? 1 - Угадай число, 2 - Угадай слово");
        Scanner scanner = new Scanner (System.in);
        int game = scanner.nextInt();

        switch (game) {
            case 1:playGuessNumber();
            break;
            case 2: playGuessWord();
            break;
            default:
                System.out.println("Не хотите играть ? Ну ладно...");
                break;
        }
    }
    static void playGuessNumber() {

        System.out.println("Добро пожаловать в игру Угадай число!");
        int userAnswer;
        do {
            int computerNumber = generateNumber();
            compareNumbers(computerNumber);
            System.out.println("Сыграем еще раз? Выберете 1 - Да; Выберете 0 - нет ");
            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.nextInt();
        } while (userAnswer == 1);
        System.out.println("Игра закончена. До свидания.");
    }

    static int generateNumber(){
        Random random =new Random();
        int number = random.nextInt(10);
        return number;
    }
    static void compareNumbers(int computerNumber) {
        int count =0;
        do {
            int userNumber = getUserNumber("Введите число от 0 до 9", 0,9);
            if (computerNumber > userNumber) {
                System.out.println("Вы ввели число меньшее");
                count++;
            } else if (computerNumber < userNumber) {
                System.out.println("Вы ввели число большее");
                count++;
            } else {
                System.out.println("Поздравляем! Вы угадали");
                return;
            }

        } while (count!=3);
        System.out.println ("Вы проиграли! Загаданное число было " + computerNumber);
    }

    static int getUserNumber(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        do {
            System.out.println (message);
            userNumber = scanner.nextInt();

        } while (userNumber<min || userNumber>max);
        return userNumber;
    }

    static void playGuessWord(){
        String[] words = {"apple", "orange", "lemon",
                "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        printArray(words);
        String randomWord = chooseWordFromArray(words);
        compareWords(randomWord);

    }
    static void printArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + ", ");
        }
        System.out.println();
    }

    static String chooseWordFromArray(String[] words) {
        Random random = new Random();
        int wordIndex = random.nextInt(words.length - 1);
        String randomWord = words[wordIndex];
        return randomWord;
    }

    static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        return userAnswer;
    }

    static void compareWords(String randomWord) {
        System.out.println("Угадайте слово");
        String userWord;
        do {
            userWord = getUserAnswer();
            if (userWord.equals(randomWord)) {
                System.out.println("Поздравяем! Угадали. Конец игры");
                break;
            } else {
                findCoincidence(randomWord, userWord);

            }

        } while (!(userWord.equals(randomWord)));
    }
    static void findCoincidence(String randomWord, String userWord) {
        String result = " ";
        if (randomWord.length() < userWord.length()) {
            for (int i = 0; i < randomWord.length() - 1; i++) {
                char a = randomWord.charAt(i);
                char b = userWord.charAt(i);
                if (a == b) {
                    result += a;
                } else {
                    result += "#";
                }
            }
        } else {
            for (int i = 0; i < userWord.length() - 1; i++) {
                char a = randomWord.charAt(i);
                char b = userWord.charAt(i);
                if (a == b) {
                    result += a;
                } else {
                    result += "#";
                }
            }
        }
        if (result.length()<15){
            for (int i=result.length();i<=15;i++){
                result+="#";
            }
        }
        System.out.println("Совпадения букв "+result);
    }

}
