package leetcode;
import java.util.ArrayList;
import java.util.TreeMap;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
               map.put(num,1);
            }else {
                map.replace(num,map.get(num) + 1);
            }
        }

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) != 0){
                list.add(num);
                map.replace(num,map.get(num) - 1);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] l1 = {2,2,2};
        int[] l2 = {2,3,2};

        int [] l3 = new Solution().intersect(l1,l2);
        for(int i : l3){
            System.out.println(i);
        }
    }
}
