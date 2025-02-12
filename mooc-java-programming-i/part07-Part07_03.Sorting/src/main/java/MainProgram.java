
import java.util.ArrayList;
import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        sort(array);
    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int num : array) {
            if (smallest > num) {
                smallest = num;
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        int smallest = array[0];
        int index = 0;
        for (int i = 1; i < array.length; ++i) {
            int num = array[i];
            if (smallest > num) {
                smallest = num;
                index = i;
            }
        }
        return index;
    }

    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int smallest = array[startIndex];
        int index = startIndex;
        for (int i = startIndex + 1; i < array.length; ++i) {
            int num = array[i];
            if (smallest > num) {
                smallest = num;
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));
        
        for (int i = 0; i < array.length; ++i) {
            int index = indexOfSmallestFrom(array, i);
            if (index != i) {
                swap(array, i, index);
            }
        }
        
        System.out.println(Arrays.toString(array));
    }
}
