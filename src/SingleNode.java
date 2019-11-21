public class SingleNode<E> {
    E data;
    SingleNode next;
    SingleNode prev;

    public SingleNode(E o) {
        this.data = o;
        next = null;
        prev = null;
    }

    public SingleNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public SingleNode(E o, SingleNode<E> n) {
        this.data = o;
        this.next = n;
        this.prev = null;
    }

    public SingleNode(E o, SingleNode<E> n, SingleNode<E> p){
        this.data = o;
        this.next = n;
        this.prev = p;
    }

    public E element() {
        return this.data;
    }
    public SingleNode<E> getNext(){
        return this.next;
    }

    public SingleNode<E> getPrev(){
        return this.prev;
    }

    public void setElement(E o){
        this.data = o;
    }

    public void setNext(SingleNode<E> n){
        this.next = n;
    }

    public void setPrev(SingleNode<E> p){
        this.prev = p;
    }
}
