package leetcode;

class Solution {
    /*public static ListNode removeElements(ListNode head, int val) {
        
    	while(head != null && head.val == val) {
    		ListNode delNode = head;
    		head = head.next;
    		delNode = null;
    	}
    	
    	if(head == null)
    		return null;
    	
    	ListNode pre = head;
    	while(pre.next != null) {
    		if(pre.next.val == val) {
    			ListNode delNode = pre.next;
    			pre.next = delNode.next;
    			delNode = null;
    		}else {
    			pre = pre.next;
    		}
    	}
    	return head;*/

    	/*public static ListNode removeElements(ListNode head, int val) {//递归思想完成
    		if(head == null)
    			return hull;
    		ListNode res = removeElements(head.next,val);
    		if(head.val == val)
    			return res;
    		else {
				head.next = res;
				return head;
			}*/
		public ListNode removeElements(ListNode head, int val, int depthe){//递归更简洁的写法
			String deptheString = DeptheString(depthe);

			System.out.println(deptheString);
			System.out.println("call : remove " + val + " in "+head);

			if(head == null){
                System.out.println(deptheString);
                System.out.println("return null");
                return null;
            }

            ListNode res = removeElements(head.next,val,depthe + 1);
            System.out.println(deptheString);
            System.out.println("after : remove " + val +" in "+ res);

            ListNode ret ;
            if(head.val == val)
                ret = res;
            else {
                head.next = res;
                ret = head;
            }
            System.out.println(deptheString);
            System.out.println(ret);

            return ret;
    }

    public String DeptheString(int depthe){
			StringBuilder res = new StringBuilder();
			for(int i = 0;i < depthe;i++){
				res.append("--");
			}
			return res.toString();
	}

    public static void main(String[] args) {
		 
		 int[] nums = {1,2,3,4,5,6};
		 ListNode cur = new ListNode(nums);

		 ListNode node = new Solution().removeElements(cur,2,0);
		 System.out.println(node);
		 
    }
}