public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for(int i = 0; i < size; i ++){
            parent[i] = i;
            sz[i] = 1;
        }
    }


    //找index到对应的racine根结点,O(h)
    private int find(int index){

        if(index < 0 || index > parent.length)
            throw new IllegalArgumentException("index out of bound");

        while (parent[index] != index){
            index = parent[index];
        }
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
    //根据两个树，所拥有的元素多少来判断合并方向
    //将元素少的树并到元素多的树上
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }
    }
}
