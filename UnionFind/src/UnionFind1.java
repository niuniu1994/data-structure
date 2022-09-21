public class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for(int i =0; i < size; i ++){
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //找出元素i值对应的集合编号，O(1)
    private int find(int i){
        if(i < 0 || i > id.length){
            throw new IllegalArgumentException("i out of bound");
        }
        return id[i];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(p);
    }

    //O(n)
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId)
            return;

        for(int i = 0; i < id.length; i ++){
            if(id[i] == pId)
                id[i] = qId;
        }
    }
}
