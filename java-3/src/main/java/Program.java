import Library.BubbleSort;
import java.util.Arrays;

public class Program {

    public static void main(String Args[]) {
        int[] massive = new int[] {6, 9, 0, 1, 6, 2, 8, 4, 6};

        System.out.println("Исходный массив - " + Arrays.toString(massive));
        BubbleSort sorter = new BubbleSort(massive);
        System.out.print("Сортированный массив - " + Arrays.toString(sorter.Sort())); //changed method name
    }
}