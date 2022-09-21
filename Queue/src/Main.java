import java.util.Random;

public class Main {
	//测试使用testQueue进行opcount次的enqueue和dequeue所用的时间
	private static double testQueue(Queue<Integer> q , int opCount) {
		long startTime = System.nanoTime();
		
		Random random = new Random();
		for(int i = 0; i < opCount;i++) {
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			q.dequeue();
		}
		long endTime = System.nanoTime();
		return(endTime - startTime) / 1000000000.0;
	}
	
	
	public static void main(String[] args) {
		
		int opCount =100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
		LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
		
		System.out.println(testQueue(arrayQueue, opCount));
		System.out.println(testQueue(loopQueue, opCount));
		
	}
}
