package DSA_1.SORTING_CUSTOMER_ORDER;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = { 292, 450, 90, 191, -99 };
        
        bubbleSort(data);
        
        System.out.println("Sorted in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
    
    static void bubbleSort(int array[]) {
        int size = array.length;
        for (int itr = 0; itr < size - 1; itr++) {
            for (int j = 0; j < size - itr - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
