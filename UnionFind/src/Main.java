import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();

        double startTime = System.nanoTime();

        for (int i = 0; i < m; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.unionElements(a,b);
        }

        for (int i = 0; i < m; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            uf.isConnected(a,b);
        }

        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000;
    }

    public static void main(String[] args) {
        //System.out.println(testUF(new UnionFind1(1000000),100000));
        //System.out.println(testUF(new UnionFind2(1000000),100000));
        //System.out.println(testUF(new UnionFind3(100000),1000000));
        System.out.println(testUF(new UnionFind4(10000),100000));
        System.out.println(testUF(new UnionFind5(10000),100000));
        System.out.println(testUF(new UnionFind6(10000),100000));

    }
}
