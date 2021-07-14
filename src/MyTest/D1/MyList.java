package MyTest.D1;

public class MyList<N> {
    private Node<N> first = null;
    private Node<N> last = null;
    private int size = 0;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public MyList() {
    }

    public MyList(N data) {
        Node<N> n = new Node<>();
        n.setData(data);
        n.setNext(null);
        this.first = n;
        this.last = n;
        this.size++;
    }

    public boolean addNodeF(N data) {
        if (data == null) {
            return false;
        }
        Node<N> n = new Node<>();
        n.setData(data);
        if (first != null && last != null) {
            n.setNext(first);
            this.first = n;
        } else {
            n.setNext(null);
            this.first = n;
            this.last = n;
        }
        this.size++;
        return true;
    }

    public boolean addNodeL(N data) {
        if (data == null) {
            return false;
        }
        Node<N> n = new Node<>();
        n.setData(data);
        if (first != null && last != null) {
            n.setNext(null);
            this.last.setNext(n);
            this.last = n;
        } else {
            n.setNext(null);
            this.first = n;
            this.last = n;
        }
        this.size++;
        return true;
    }

    public boolean rmNode(N data) {
        Node<N> ptr = first;
        Node<N> pptr = null;
        if (size == 0)
            return false;
        do {
            if (ptr.getData().equals(data)) {
                if (size == 1) {
                    first = null;
                    last = null;
                    size--;
                    return true;
                }
                if (ptr.equals(first)) {
                    first = first.getNext();
                } else if (ptr.equals(last)) {
                    pptr.setNext(null);
                    last = pptr;
                } else {
                    pptr.setNext(ptr.getNext());
                }
                ptr.setNext(null);
                size--;
                return true;
            }
            pptr = ptr;
            ptr = ptr.getNext();
        } while (ptr != null);
        return false;
    }

    public boolean updateNode(N old, N n) {
        if (old == null || n == null || size == 0) {
            return false;
        }
        Node<N> ptr = first;
        do {
            if (ptr.getData().equals(old)) {
                ptr.setData(n);
                return true;
            }
            ptr = ptr.getNext();
        } while (ptr != null);
        return false;
    }

    public N selectIndex(int i){
        if(i>size)
            return null;
        Node<N> ptr=first;
        for(int j=1;j<i;j++){
            ptr=ptr.getNext();
        }
        return ptr.getData();
    }

    public void display(){
        StringBuffer str=new StringBuffer();
        str.append("[ ");
        int i=1;
        Node<N> ptr=first;
        while (ptr!=null){
            str.append(i).append(":").append(ptr.getData().toString()).append("; ");
            i++;
            ptr=ptr.getNext();
        }
        str.append("]");
        System.out.println(str);
    }

    public N getFirst() {
        return first.getData();
    }

    public N getLast() {
        return last.getData();
    }

    public int getSize() {
        return size;
    }
}
