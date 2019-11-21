public class BNode<E> {
    E data;
    BNode<E> esq, dir;
    public BNode(){
        this.data = null;
        this.esq = null;
        this.dir = null;
    }
    public BNode(E info){
        this.data = info;
        this.esq = null;
        this.dir = null;
    }

    public BNode(E info, BNode<E> esq, BNode<E> dir){
        this.data = info;
        this.esq = esq;
        this.dir = dir;
    }

    public String toString(){
        return data.toString();
    }
}
