import java.security.Key;
import java.util.*;

class Solution {
    /*
    private class Freq {
        int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        //因为我们本函数需要的是一个最小堆，即freq越小优先级越大,需要改写compareTo的比较逻辑，因为我们自己所创建的priorityQueue是以最大堆为基础
        //而使用java自带的priotityQueue是基于最小堆，此时freq的比较用正常逻辑即可
        //现在我们是基于最小堆

        @Override
        public int compareTo(Freq another) {
            if (this.freq > another.freq){
                return 1;
            }else if (this.freq < another.freq){
                return -1;
            }else return 0;
        }

         */



    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)) {
                treeMap.replace(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }


        //当使用系统自带的priorityQueue时允许导入Comparator的子类从而定义优先队列中的比较规则。
        //我们使用匿名内部类来创建Comparator,因为只使用一次
        /*
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){
            @Override
            public int compare(Freq a, Freq b){
                return a.freq - b.freq;
            }
        });
        for (int key : treeMap.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, treeMap.get(key)));
            } else if (treeMap.get(key) > pq.element().freq) {
                pq.poll();
                pq.add(new Freq(key, treeMap.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

     while (!pq.isEmpty())
         list.add(pq.poll().e);

        return list;
    }
         */
        PriorityQueue<Integer> pq= new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return treeMap.get(a) - treeMap.get(b);
            }
        });


        for (int key : treeMap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (treeMap.get(key) > treeMap.get(pq.element())) {
                pq.poll();
                pq.add(key);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

        while (!pq.isEmpty())
            list.add(pq.poll());

        return list;
    }
}
