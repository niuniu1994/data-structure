public class SegementTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegementTree(E[] arr, Merger<E> merge) {
        this.merger = merge;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegementTree(0,0,data.length - 1);
    }

    //在treeIndex处创建表示区间[0。。。n]的线段树
    private void buildSegementTree(int indexTree, int l, int end){

        if (l == end){
            tree[indexTree] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(indexTree);
        int rightTreeIndex = rigtheChild(indexTree);

        int mid = l + (end - l)/2;
        buildSegementTree(leftTreeIndex,l,mid);
        buildSegementTree(rightTreeIndex,mid + 1,end);

        tree[indexTree] = merger.Merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public E query(int i, int j){
        if(i < 0 || j > data.length - 1 || i > j)
            throw new IllegalArgumentException("range of serche is not right");
        return query(0,0,data.length - 1, i, j);
    }

    private E query(int treeIndex,int l,int r,int queryLeft,int queryRight){
        if(l == queryLeft && r == queryRight){
            return tree[treeIndex];
        }

        int mid = l + (r - l)/2;
        int leftTree = leftChild(treeIndex);
        int rightTree = rigtheChild(treeIndex);

        if (queryLeft >= mid + 1){
            return query(rightTree,mid + 1, r, queryLeft, queryRight);
        }else if(queryRight <= mid){
            return query(leftTree, l, mid, queryLeft, queryRight);
        }else {
            E leftResult = query(leftTree, l, mid,queryLeft,mid);
            E rightResult = query(rightTree, mid + 1, r,mid + 1, queryRight);
            return merger.Merge(leftResult,rightResult);
        }
    }

    public E get(int index) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("index is faux");
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rigtheChild(int index){
        return index * 2 + 2;
    }

    public void set(int index, E e){
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int indexTree,int left, int right, int index, E e){

        if (left == right){
            tree[indexTree] = e;
            return;
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(indexTree);
        int rightTreeIndex = rigtheChild(indexTree);

        if (index >= mid + 1){
            set(rightTreeIndex,mid + 1, right, index, e);
        }else if(index <= mid){
            set(leftTreeIndex, left, mid, index, e);
        }

        tree[indexTree] = merger.Merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SegementTree : [");
        for(int i =0; i < tree.length; i ++){
            res.append(tree[i]);
            if(i != tree.length - 1){
                res.append(",");
            }
            }
        res.append("]");
        return res.toString();
    }
}
