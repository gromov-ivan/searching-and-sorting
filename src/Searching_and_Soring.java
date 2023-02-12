import java.util.Random;
import java.util.Scanner;

public class Searching_and_Soring {
    private final int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        String menuChoice;
        boolean quit = false;

        while (!quit) {
            System.out.print("""
                    Menu of Searching and Sorting Testing.

                    1)  Linear searching
                    2)  Binary searching
                    3)  O(n^2) type of sorting
                    4)  O(n*log(n)) type of sorting

                    q/Q) Quit

                    Your choice:\s""");
            menuChoice = scanner.next();

            switch (menuChoice) {
                case "1" -> linearSearching();
                case "2" -> binarySearching();
                case "3" -> System.out.println(bubbleSort());
                case "4" -> System.out.println(quickSort());
                case "q", "Q" -> quit = true;
            }
        }
    }

    /**
     * Linear Searching
     */

    public void linearSearching() {
        int choice;
        int index = 0;

        System.out.print("\nIn the list are values 0, ..., 9; which value would you like to search with linear search? ");
        choice = scanner.nextInt();

        for (int i : array) {
            if (choice == i) {
                System.out.println("\nFound\n");
                break;
            }
            else {
                index++;
                if (index == array.length) {
                    System.out.println("\nNot found\n");
                }
            }
        }
    }

    /**
     * Binary Searching
     */

    private void binarySearching(){
        int choice;
        int first = 0;
        int last = array.length - 1;
        int midpoint = (last + first) / 2;

        System.out.print("\nIn the list are values 0, ..., 9; which value would you like to search with binary search? ");
        choice = scanner.nextInt();

        while(first <= last) {
            if (choice == array[midpoint]) {
                System.out.println("\nFound\n");
                break;
            }
            else {
                if (choice > array[midpoint]) {
                    first = midpoint + 1;
                } else {
                    last = midpoint - 1;
                }
                midpoint = (first + last) / 2;
            }
        }

        if (first > last) {
            System.out.println("\nNot found\n");
        }
    }

    /**
     * O(n^2) Type of Sorting - Bubble Sorting
     */

    private int[] randomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i<array.length; i++){
            array[i] = random.nextInt(-100, 100);
        }
        return array;
    }

    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private String bubbleSort(){
        String message = "";
        int[] bubbleArr;
        int position, scan;
        bubbleArr = randomArray(10);

        message += "\nData set before bubble sorting:\n";

        for(int a: bubbleArr)
            message += a+" ";
        for (position =  bubbleArr.length - 1; position >= 0; position--){
            for (scan = 0; scan <= position - 1; scan++){
                if (bubbleArr[scan] > bubbleArr[scan+1]) {
                    swap(bubbleArr, scan, scan+1);
                }
            }
        }
        message+= "\n\nData set after bubble sorting:\n";
        for(int a: bubbleArr){
            message += a + " ";
        }
        message += "\n";
        return message;
    }

    /**
     * O(n*log(n)) Type of Sorting - Bubble Sorting
     */

    private String quickSort(){

        StringBuilder message = new StringBuilder();

        int[] quickArray;
        quickArray = randomArray(10);
        message.append("\nData set before quicksort:\n");

        for(int a : quickArray)
            message.append(a).append(" ");

        quickSort(quickArray, 0, quickArray.length-1);
        message.append("\n\nData set after quicksort:\n");

        for(int a : quickArray)
            message.append(a).append(" ");
        message.append("\n");

        return message.toString();
    }

    private void quickSort(int[] array, int min, int max) {
        if (min < max)
        {
            int indexOfPartition = partition(array, min, max);
            quickSort(array, min, indexOfPartition - 1);
            quickSort(array, indexOfPartition + 1, max);
        }
    }

    private int partition(int[] array, int min, int max){
        int partitionElement;
        int left, right;
        int middle = (min + max) / 2;

        partitionElement = array[middle];
        swap(array, middle, min);

        left = min;
        right = max;

        while (left < right) {

            while (left < right && array[left] <= partitionElement) {
                left++;
            }
            while (array[right] > partitionElement) {
                right--;
            }
            if (left < right)
                swap(array, left, right);
        }
        swap(array, min, right);

        return right;
    }

}
