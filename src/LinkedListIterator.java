
public class LinkedListIterator<E> implements Iterator<E> {
    int index = 0;
    SingleNode<E> atual, head;

    public LinkedListIterator(SingleNode<E> listHead){
        head = listHead;
    }

    public boolean hasNext() {
        return atual != null;
    }

    public E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        E data = atual.data;
        atual = atual.next;
        return data;
    }
    public void remove(){

    }
}
