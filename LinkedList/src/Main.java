
public class Main {


    public int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        } else {
            return arr[l] + sum(arr, l + 1);
        }
    }

    public static void main(String[] args) {

		/*Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		n1.next = n2;
		n2.next = n3;
		
		n1 = Node.reverseLinkedNode(n1);	
		System.out.println(n1);
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0; i < 8; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		
		linkedList.add(2, 19);
		System.out.println(linkedList);
		
		System.out.println(linkedList.removeNode(2));
		System.out.print(linkedList);

		LinkedLlist2<Integer> ls = new LinkedLlist2<>();

		for (int i = 0; i < 10; i ++){
			ls.addFirst(i);
		}

		for (int i = 0; i < 10; i ++){
			System.out.println(ls.get(i));
		}

		System.out.println(ls.getSize());

		ls.reverse();

		for (int i = 0; i < 10; i ++){
			System.out.println(ls.get(i));
		}

		 */
        Main s = new Main();
        int[] arr = {1, 2, 3, 4, 5, 5};
        System.out.println(s.sum(arr, 0));


    }


}
