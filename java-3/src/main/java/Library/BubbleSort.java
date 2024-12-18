package Library;

public class BubbleSort {
    public int[] massive;
    
    public BubbleSort(int[] mass) {
        massive = mass;
    }

    public int[] sort() {
        int bubble;
        for(int i = 0;i < massive.length;i++) {
            for(int j = 0;j < massive.length - 1;j++) {
                if(massive[j] > massive[j+1]) {
                    bubble = massive[j+1];
                    massive[j+1] = massive[j];
                    massive[j] = bubble;
                }
            }
        }
        return massive;
    }
}