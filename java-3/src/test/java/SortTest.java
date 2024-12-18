import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import Library.BubbleSort;

public class SortTest {

    @Test
    public void creationTest() {
        int[] massive = {2, 6, 2, 8, 4, 0, 2, 4, 6, 2, 7};
        BubbleSort sorter = new BubbleSort(massive);
        int[] result = sorter.massive;
        assertArrayEquals(massive, result, "Проверка создания массива");
    }

    @Test
    public void sortTest() {
        int[] massive = {2, 6, 2, 8, 4, 0, 2, 4, 6, 2, 7};
        BubbleSort sorter = new BubbleSort(massive);
        int[] result = sorter.sort();
        assertArrayEquals(new int[]{0, 2, 2, 2, 2, 4, 4, 6, 6, 7, 8}, result, "Проверка сортировки");
    }
}