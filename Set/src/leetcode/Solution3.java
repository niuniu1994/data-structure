package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int[] intersect_1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] l1 = {4,9,5};
        int[] l2 = {9,4,9,8,4};

       int [] l3 = new Solution3().intersect_1(l1,l2);
       for(int i : l3){
           System.out.println(i);
       }
    }
}
