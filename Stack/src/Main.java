import java.lang.reflect.Array;
import java.util.Random;

public class Main {
	//测试使用testQueue进行opcount次的enqueue和dequeue所用的时间
	private static double testQueue(Stack<Integer> q , int opCount) {
		long startTime = System.nanoTime();
		
		Random random = new Random();
		for(int i = 0; i < opCount;i++) {
			q.push(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			q.pop();
		}
		long endTime = System.nanoTime();
		return(endTime - startTime) / 1000000000.0;
	}
	
	
	public static void main(String[] args) {
		
		int opCount =10000000;
		arrayStack<Integer> arrayStack = new arrayStack<Integer>();
		LinkedlistStack<Integer> linkedlistStack= new LinkedlistStack<Integer>();
		
		System.out.println(testQueue(arrayStack, opCount));
		System.out.println(testQueue(linkedlistStack, opCount));
		
	}
}
