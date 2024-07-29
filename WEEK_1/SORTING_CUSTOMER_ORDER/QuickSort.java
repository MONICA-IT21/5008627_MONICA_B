package SORTING_CUSTOMER_ORDER;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {99, 78, 85, 95, 134, 595};
        int n = array.length;

        QuickSort.quickSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(array);
    }
    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int itr = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                itr++;
                int temp = array[itr];
                array[itr] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[itr + 1];
        array[itr + 1] = array[high];
        array[high] = temp;

        return (itr + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    static void printArray(int array[]) {
        int n = array.length;
        for (int itr = 0; itr < n; ++itr) {
            System.out.print(array[itr] + " ");
        }
        System.out.println();
    }
}
