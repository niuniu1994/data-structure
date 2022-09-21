
//路径压缩
public class UnionFind5 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i = 0; i < size; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }


    //找index到对应的racine根结点,O(h)
    private int find(int index){

        if(index < 0 || index > parent.length)
            throw new IllegalArgumentException("index out of bound");

        while (parent[index] != index){
            //在find的同时改变非根节点的节点的父节点，达到路径压缩的目的
            parent[index] = parent[parent[index]];

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
    //根据两个树，所拥有的rank（深度）大小判断合并方向
    //将深度小的并到深度大的
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[pRoot] += 1;
        }
    }
}
