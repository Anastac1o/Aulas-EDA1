

public class LinkedList<E> {
    SingleNode<E> head;
    int size;

    public LinkedList(){ //empty list
        this.head = null;
    }

    public LinkedList(SingleNode<E> h){
        this.head = h;
    }

    public Iterator<E> iterator(){
        return new LinkedListIterator<E>(this.head);
    }
    public int size(){
        int count = 0;
        SingleNode<E> current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty(){
        return (head == null);
    }
    public SingleNode<E> header(){
        return this.head;
    }

    public void add(int i, E x){
        int p = 0;
        SingleNode current = head;

        if(i <= 0){
            SingleNode newHead = new SingleNode(x);
            newHead.next = current;
            this.head = newHead;
            return;
        }

        while (p != i-1){
            current = current.next;
            p++;
        }
        SingleNode next = new SingleNode(x);
        next.next = current.next;
        current.next = next;
    }

    void add(E data){
        if (head == null) {
            head = new SingleNode<>(data);
            return;
        }

        SingleNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new SingleNode<>(data);

    }

    SingleNode<E> findPrevious(E x){
        return this.head;
    }

    void remove(E x){

    }

    public String toString(){
        SingleNode current = head;
        String s = "";
        while (current.next != null){
            current = current.next;
        }
        return s;
    }

    void set(int indx, E x){
        SingleNode current = head;
        int p = 0;
        while (p != indx){
            current=current.next;
            p++;
        }
        current.data = x;
    }

    public E get(int ind){
        SingleNode current = head;
        int p = 0;
        while (p != ind){
            current = current.next;
            p++;
        }
        return (E) current.data;
    }

    SingleNode<E> getNode(int i){
        SingleNode current = head;
        int p = 0;
        while (p != i){
            current = current.next;
            p++;
        }
        return current;

    }
}
