public class AVL<E extends Comparable<? super E>> extends ABP<E> {

    static class NoAVL<E> extends ABP.NoABP<E> {
        int height;
        E element;

        NoAVL(E x) {
            super(x);
            height = 1;
        }

        NoAVL(E e, NoAVL<E> esq, NoAVL<E> dir) {
            super(e, esq, dir);
            height = 1;
        }
    }

    NoAVL<E> root;

    public AVL() {
        this.root = null;
    }

    public AVL(NoAVL<E> n) {
        this.root = n;
    }

    private int height(NoAVL n) {
        if (n == null) return 0;
        return n.height;
    }

    private NoAVL<E> rotacaoDir(NoAVL<E> n0) {
        System.out.println("Rotacao dir");

        NoAVL<E> n1 = (NoAVL<E>) n0.esq;
        n0.esq = n1.dir;
        n1.dir = n0;

        n0.height = Math.max(height((NoAVL) n0.esq), height((NoAVL) n0.dir)) + 1;
        n1.height = Math.max(height((NoAVL) n1.dir), height((NoAVL) n1.esq)) + 1;

        return n1;
    }

    private NoAVL<E> rotacaoEsq(NoAVL<E> n0) {
        System.out.println("Rotaçao esq");

        NoAVL<E> n1 = (NoAVL<E>) n0.esq;
        n0.dir = n1.esq;
        n1.esq = n0;

        n0.height = Math.max(height((NoAVL) n0.esq), height((NoAVL) n0.dir)) + 1;
        n1.height = Math.max(height((NoAVL) n1.dir), height((NoAVL) n1.esq)) + 1;

        return n1;
    }
    private NoAVL<E> duplaEsqDir(NoAVL<E> n0){
        System.out.println("Rotacao dupla esq dir");
        //draw("Rotacao dupla esq dir : " + n0);
        NoAVL<E> n1 = (NoAVL<E>) n0.esq;
        n0.esq = rotacaoEsq(n1);
        return rotacaoDir(n0);
    }
    private NoAVL<E> duplaDirEsq(NoAVL<E> n0){
        System.out.println("Rotacao dupla dir esq");
        //draw("Rotacao dupla dir esq : + n0);
        NoAVL<E> n1 = (NoAVL<E>) n0.dir;
        n0.dir = rotacaoDir(n1);
        return rotacaoEsq(n0);
    }

    private int equlibrio(NoAVL<E> n){
        if(n == null) return 0;
        return height((NoAVL) n.esq) - height((NoAVL) n.dir);
    }

    public NoAVL<E> insere(E x, NoAVL<E> n){
        NoAVL<E> node = (NoAVL<E>) super.insere(x,n);                                                              //inserçao normal na BST
        node.height = 1 + Math.max(height((NoAVL) n.esq),height((NoAVL) n.dir));    //actualiza altura do node
        Integer i = equlibrio(node);                                                    //determina se há desequilibrio e qual o caso

        if(i > 1 && x.compareTo(node.esq.element) == -1){                           //left left & key < node.left.key
            return rotacaoDir(node);
        }
        if(i < -1 && x.compareTo(node.dir.element) == 1){                           //right right & key > node.right.key
            return rotacaoEsq(node);
        }
        if(i > 1 && x.compareTo(node.esq.element) == 1){                            //left right & key > node.left.key
            return duplaEsqDir(node);
        }
        if(i > 1 && x.compareTo(node.dir.element) == -1){                           //right left & key < node.right.key
            return duplaDirEsq(node);
        }

        //se nao for nenhum dos casos
        return node;
    }

    public void insere(E x){
        root = insere(x, root);
    }

    public void printEmOrdem(){
        super.printEmOrdem();
    }

    public static void main(String[] args){
        AVL<Integer> t = new AVL<>();
        t.insere(27);
        t.insere(18);
        t.insere(10);
        t.insere(5);
        t.printEmOrdem();
    }
}

