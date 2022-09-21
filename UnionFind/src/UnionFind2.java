public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for(int i = 0; i < size; i ++){
            parent[i] = i;
        }
    }


    //找index到对应的racine根结点,O(h)
    private int find(int index){

        if(index < 0 || index > parent.length)
            throw new IllegalArgumentException("index out of bound");

        while (parent[index] != index)
            index = parent[index];
        return index;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查看p和q是否是同一个根结点
    //O(h)复杂度,h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //O(h)复杂度,h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}
