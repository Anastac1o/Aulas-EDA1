public class BTreeTester {
    public static void main(String[] args){
        BTree<String> t = new BTree<String>("root");
        t.root.dir= new BNode<String>("Sim");
        t.root.esq= new BNode<String>("Não");
        t.root.dir.dir = new BNode<>("Claro que sim");
        t.root.dir.esq = new BNode<>("Obvio que sim");
        t.root.esq.dir = new BNode<>("Claro que nao");
        t.root.esq.esq = new BNode<>("Obvio que nao");

        t.printPostOrder(t.root);
        System.out.println("");
        t.printInOrder(t.root);
        System.out.println("");
        t.printPreOrder(t.root);

    }
}
