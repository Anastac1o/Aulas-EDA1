public class BTree<E> {
    BNode<E> root;

    public BTree(){ this.root = null; }
    public BTree(BNode<E> r){
        this.root = r;
    }
    public BTree(E x){ this.root = new BNode<E>(x);}

    public BTree(E r, BNode<E> esq, BNode<E> dir){
        this.root = new BNode<E>(r,esq,dir);
    }
    void printPostOrder(){
        printPostOrder(this.root);
    }
    void printPostOrder(BNode<E> node){
        if (node == null) return;

        printPostOrder(node.esq);
        printPostOrder(node.dir);
        System.out.println(node.data + " ");

    }
    void printPreOrder(){
        printPreOrder(this.root);
    }
    void printPreOrder(BNode<E> node){
        if(node == null) return;

        System.out.println(node.data + " ");
        printPreOrder(node.esq);
        printPreOrder(node.dir);
    }
    void printInOrder(){
        printInOrder(this.root);
    }
    void printInOrder(BNode<E> node){
        printInOrder(node.esq);
        System.out.println(node.data + " ");
        printInOrder(node.dir);
    }

}
