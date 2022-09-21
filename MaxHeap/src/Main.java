import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime  = System.nanoTime();

        MaxHeap<Integer> maxHeap;

        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for(int i = 0; i < testData.length; i ++){
                maxHeap.add(testData[i]);
            }
        }

        int[] arr = new int[testData.length];

        for(int i = 0; i < testData.length; i++){
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 0; i < testData.length- 1; i++){
            if(arr[i + 1] > arr[i])
                throw new IllegalArgumentException("error");
        }

        System.out.println("testMaxHeap completed");
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        /*
        int n = 10000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println(testHeap(testData,false));
        System.out.println(testHeap(testData,true));

         */
         int nums[] = {1,2,2,3,3,3,3,3,3,6,6,8,9,9,9,9,10,10,10,10,10,10};
            Solution s = new Solution();
            LinkedList<Integer> l = new LinkedList<>();
            l = (LinkedList<Integer>) s.topKFrequent(nums,3);

            for(int i : l) {
                System.out.println(i);
            }
    }
}
