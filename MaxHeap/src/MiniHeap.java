public class MiniHeap<E extends Comparable<E>> {

    Array<E> data;
    public MiniHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MiniHeap(){
        data = new Array<>();
    }

    //Heapify功能，即输入一个数组讲这个数组转换成堆。
    public MiniHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0;i--){
            siftDown(i);
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的index
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index 0 doesn't has a parent");
        return (index - 1) / 2 ;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左儿子节点的index
    private int leftSon(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右儿子节点的index
    private  int rightSon(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftup(data.getSize() - 1);//为满足父亲必须比孩子节点大，必须进行比较
    }

    //上浮功能,将新加入的元素与其父亲元素进行比较，如果它比父亲大则替换他们两个的位置。
    private void siftup(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }
//找到堆中最大元素，即最上面的

    public E findMini(){
        if (data.isEmpty())
            throw new IllegalArgumentException("the heap is empty");
        return data.get(0);
    }
    //提取最小元素 并从堆中删除
    public E extractMax(){

        E e = findMini();

        data.swap(0,data.getSize() - 1);
        data.remove(data.getSize() - 1);
        siftDown(0);

        return e;
    }

    private void siftDown(int k) {

        while (leftSon(k) < data.getSize()) {
            int j = leftSon(k);
            //若右节点存在比较leftson rightson从而得到较大的一个
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) > 0) {
                j = rightSon(k);
            }

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);

            k = j;
        }
    }


    public E replace(E e){
        E ret = findMini();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}
