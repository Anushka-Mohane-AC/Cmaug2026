import java.util.Scanner;
public class program_arrays {

        static Scanner sc = new Scanner(System.in);

        // Helper: input an array
        static int[] inputArray() {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            return arr;
        }

        // Helper: print an array
        static void printArray(int[] arr) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Q2: Sort array
        static void sortArray(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.print("Sorted Array: ");
            printArray(arr);
        }

        // Q3: Sum of array
        static void sumArray(int[] arr) {
            int sum = 0;
            for (int val : arr) sum += val;
            System.out.println("Sum of elements: " + sum);
        }

        // Q4: Average of array
        static void averageArray(int[] arr) {
            int sum = 0;
            for (int val : arr) sum += val;
            double avg = (double) sum / arr.length;
            System.out.println("Average of elements: " + avg);
        }

        // Q5: Copy array by iterating
        static void copyArray(int[] arr) {
            int[] copy = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                copy[i] = arr[i];
            }
            System.out.print("Copied Array: ");
            printArray(copy);
        }

        // Q6: Max and Min values
        static void findMinMax(int[] arr) {
            int min = arr[0], max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];
            }
            System.out.println("Maximum: " + max + " | Minimum: " + min);
        }

        // Q7: Reverse array
        static void reverseArray(int[] arr) {
            int start = 0, end = arr.length - 1;
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            System.out.print("Reversed Array: ");
            printArray(arr);
        }

        // Q8 & Q9: Duplicate values
        static void findDuplicates(int[] arr) {
            System.out.print("Duplicate values: ");
            boolean found = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.print(arr[i] + " ");
                        found = true;
                        break;
                    }
                }
            }
            if (!found) System.out.print("None");
            System.out.println();
        }

        // Q10: Common elements between two arrays
        static void findCommonElements() {
            System.out.println("Input Array 1");
            int[] arr1 = inputArray();
            System.out.println("Input Array 2");
            int[] arr2 = inputArray();

            System.out.print("Common elements: ");
            boolean found = false;
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr1[i] == arr2[j]) {
                        System.out.print(arr1[i] + " ");
                        found = true;
                        break;
                    }
                }
            }
            if (!found) System.out.print("None");
            System.out.println();
        }

        public static void main(String[] args) {
            int choice;
            do {
                System.out.println("\nMENU");
                System.out.println("2. Sort an Array");
                System.out.println("3. Sum of Array");
                System.out.println("4. Average of Array");
                System.out.println("5. Copy Array");
                System.out.println("6. Find Min and Max");
                System.out.println("7. Reverse Array");
                System.out.println("8. Find Duplicates");
                System.out.println("10. Find Common Elements Between Two Arrays");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                if (choice >= 2 && choice <= 8) {
                    int[] arr = inputArray();
                    switch (choice) {
                        case 2: sortArray(arr); break;
                        case 3: sumArray(arr); break;
                        case 4: averageArray(arr); break;
                        case 5: copyArray(arr); break;
                        case 6: findMinMax(arr); break;
                        case 7: reverseArray(arr); break;
                        case 8: findDuplicates(arr); break;
                    }
                } else if (choice == 10) {
                    findCommonElements();
                } else if (choice != 0) {
                    System.out.println("Invalid option! Try again.");
                }
            } while (choice != 0);

            System.out.println("Program terminated.");
            sc.close();
        }
    }

