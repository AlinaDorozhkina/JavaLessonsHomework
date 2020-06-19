
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        changeArray(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        fillArray(new int[8]);
        multiplyArray(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        fillDiagonal(new int[6][6]);
        findMaxMinValue(createRandomArray(20, 100));
        System.out.println("Balance exists: " + checkBalance(createRandomArray(10, 20)));
        System.out.println("Balance exists: " + checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        moveArray(createRandomArray(6, 10), 3);
        moveArray(createRandomArray(10,20),-4);
    }
    // Task 1
    static void changeArray(int[] inputArray) {
        System.out.println("Task  1.");
        System.out.print("Input Array:\n");
        printArray(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                inputArray[i] = 1;
            } else {
                inputArray[i] = 0;
            }
        }
        System.out.print("Changed array:\n");
        printArray(inputArray);

    }

    static void printArray (int[] inputArray){
        for (int element: inputArray){
            System.out.print (element + " ");
        }
        System.out.println();
    }

    //Task2
    static void fillArray(int[] inputArray) {
        System.out.println("Task 2");
        System.out.print("Input Array:\n");
        printArray(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = i * 3;
        }
        System.out.print("Changed array:\n");
        printArray(inputArray);

    }

    //Task 3
    static void multiplyArray(int[] inputArray) {
        System.out.println("Task 3");
        System.out.print("Input Array:\n");
        printArray(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 6) {
                inputArray[i] *= 2;
            }
        }
        System.out.print("Changed array:\n");
        printArray(inputArray);
    }

    //Task 4
    static void fillDiagonal(int[][] squareArray) {
        System.out.println("Task 4. Fill diagonal by 1");
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                if (i == j || i + j == squareArray.length - 1) {
                    squareArray[i][j] = 1;
                }

                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] createRandomArray(int size, int value) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * value + 1);
        }
        return array;
    }

    // Task 5
    static void findMaxMinValue(int[] randomArray) {
        System.out.println("Task 5.");
        System.out.println("Input array:\n" + Arrays.toString(randomArray));
        int min = randomArray[0];
        int max = randomArray[0];
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < min) {
                min = randomArray[i];
            }
            if (randomArray[i] > max) {
                max = randomArray[i];
            }
        }
        System.out.println("Min value: " + min + ". Max value: " + max);
    }

    //Task 6
    static boolean checkBalance(int[] inputArray) {
        System.out.println("Task 6*.");
        System.out.print("Input Array:\n");
        printArray(inputArray);
        int rightSideSum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            rightSideSum += inputArray[i];
            int leftSideSum = 0;
            for (int j = i + 1; j < inputArray.length; j++) {
                leftSideSum += inputArray[j];
            }
            if (rightSideSum == leftSideSum) {
                return true;
            }
        }
        return false;
    }

    // Task 7
    static void moveArray(int[] inputArray, int n) {
        System.out.println("Task 7***");
        System.out.print("Input Array:\n");
        printArray(inputArray);
        System.out.println ("shift " + n);
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = inputArray[0];
                inputArray[0] = inputArray[inputArray.length - 1];
                for (int j = 1; j < inputArray.length - 1; j++) {
                    inputArray[inputArray.length - j] = inputArray[inputArray.length - j - 1];
                }
                inputArray[1] = temp;
            }
            System.out.print("Changed array:\n");
            printArray(inputArray);
        }
        if (n<0){
            for (int i=0;i>n;i--){
                int temp = inputArray[inputArray.length-1];
                inputArray[inputArray.length-1]=inputArray[0];
                for (int j=1;j<inputArray.length;j++){
                    inputArray[j-1]=inputArray[j];
                }
                inputArray[inputArray.length-2]=temp;
            }
            System.out.print("Changed array:\n");
            printArray(inputArray);
        }
    }
}