public class AVL_1<E extends Comparable<? super E>> {
    NodeAVL root;

    static class NodeAVL<E> {
        int height;
        E element;
        NodeAVL<E> esq;
        NodeAVL<E> dir;

        NodeAVL(E x){
            element = x;
            esq = null;
            dir = null;
            height = 1;
        }

        NodeAVL(E x, NodeAVL<E> esq, NodeAVL<E> dir){
            element = x;
            this.esq = esq;
            this.dir = dir;
            height = 1;
        }
    }

    public AVL_1(){ root = null; }

    public AVL_1(E x) { root = new NodeAVL<E>(x); }

    public AVL_1(NodeAVL<E> n){ root = n; }

    public boolean isEmpty(){ return root == null; }

    public boolean contains(E x) { return contains(x, root); }

    public boolean contains(E x, NodeAVL<E> n) {
        if(n == null){
            return false;
        }
        else {
            if(n.element.compareTo(x) < 0){
                return contains(x, n.dir);
            }
            else{
                if (n.element.compareTo(x) > 0){
                    return contains(x, n.esq);
                }
                else return true;
            }
        }
    }

    public E findMin() {
        if (isEmpty()) {
            return null;
        } else{
            return (E) findMin(root);
        }
    }

    public E findMin(NodeAVL<E> n) {
        if (n.esq == null) {
            return n.element;
        } else{
            return findMin(n.esq);
        }
    }
    public E findMax() {
        if (isEmpty()) {
            return null;
        }else{
            return (E) findMax(root);
        }
    }

    public E findMax(NodeAVL<E> n){
        if(n.dir == null){
            return n.element;
        }else{
            return findMax(n.dir);
        }
    }

    public void insere(E x) {
        root = insere(x , root);
    }

    public NodeAVL<E> insere(E x, NodeAVL<E> n){
        if(n == null){
            n = new NodeAVL<>(x, null, null);
        }else{
            if((n.element).compareTo(x) > 0){
                n.esq = insere(x, n.esq);
            }else{
                if((n.element).compareTo(x) < 0){
                    n.dir = insere(x, n.dir);
                }
            }
        } //inserçao ABP

        n.height = 1 + Math.max(height(n.esq),height(n.dir));    //actualiza altura do node
        int i = equlibrio(n);                                                    //determina se há desequilibrio e qual o caso

        if(i > 1 && x.compareTo(n.esq.element) == -1){                           //left left & key < node.left.key
            return rotacaoDir(n);
        }
        if(i < -1 && x.compareTo(n.dir.element) == 1){                           //right right & key > node.right.key
            return rotacaoEsq(n);
        }
        if(i > 1 && x.compareTo(n.esq.element) == 1){                            //left right & key > node.left.key
            return duplaEsqDir(n);
        }
        if(i > 1 && x.compareTo(n.dir.element) == -1){                           //right left & key < node.right.key
            return duplaDirEsq(n);
        }

        //se nao for nenhum dos casos
        return n;
    }

    public void remove(E x) {
        root = remove(x, root);
    }

    public void printEmOrdem(NodeAVL n){
        if(n == null) {return;}

        printEmOrdem(n.esq);
        System.out.print(n.element.toString()+ " ");
        printEmOrdem(n.dir);
    }

    public void printEmOrdem() {
        printEmOrdem(root);
    }
    public void printPosOrdem(NodeAVL n){
        if (n == null) {return;}

        printPosOrdem(n.esq);
        printPosOrdem(n.dir);
        System.out.print(n.element.toString() + " ");
    }
    public void printPosOrdem() {
        printPosOrdem(root);
    }

    public void printPreOrdem(NodeAVL n){
        if(n == null) {return;}

        System.out.print(n.element.toString()+" ");
        printPreOrdem(n.esq);
        printPreOrdem(n.dir);
    }

    public void printPreOrdem() {
        printPreOrdem(root);
    }

    private NodeAVL<E> remove(E x, NodeAVL<E> n) {
        if (n == null) {
            return n;
        }
        if (n.element.compareTo(x) < 0) {
            n.dir = remove(x, n.dir);
        } else if (n.element.compareTo(x) > 0) {
            n.esq = remove(x, n.esq);
        } else if (n.esq != null && n.dir != null) { // 2 filhos
            E min = findMin(n.dir);
            n.element = min;
            n.dir = remove(min, n.dir);
        } else if (n.esq == null) {// 1 filho
            n = n.dir;
        } else n = n.esq;
        return n;
    }

    public NodeAVL<E> find(E x, NodeAVL<E> n){
        if (n == null) { return null; }
        if(n.element == x){
            return n;
        }
        if(n.element.compareTo(x) < 0){ // data < x --> right
            return find(x, n.dir);
        }else {
            if(n.element.compareTo(x) > 0){ // data > x --> left
                return find(x, n.esq);
            }
        }
        return null;
    }

    public E find(E x){
        NodeAVL n = find(x, root);
        return (E) n.element;
    }

    public int height(NodeAVL n){
        if(n == null) return 0;
        return n.height;
    }

    private NodeAVL<E> rotacaoDir(NodeAVL<E> n0) {
        System.out.println("Rotacao dir");

        NodeAVL<E> n1 = n0.esq;
        n0.esq = n1.dir;
        n1.dir = n0;

        n0.height = Math.max(height(n0.esq), height(n0.dir)) + 1;
        n1.height = Math.max(height(n1.dir), height(n1.esq)) + 1;

        return n1;
    }

    private NodeAVL<E> rotacaoEsq(NodeAVL<E> n0) {
        System.out.println("Rotaçao esq");

        NodeAVL<E> n1 = n0.esq;
        n0.dir = n1.esq;
        n1.esq = n0;

        n0.height = Math.max(height(n0.esq), height(n0.dir)) + 1;
        n1.height = Math.max(height(n1.dir), height(n1.esq)) + 1;

        return n1;
    }
    private NodeAVL<E> duplaEsqDir(NodeAVL<E> n0){
        System.out.println("Rotacao dupla esq dir");
        //draw("Rotacao dupla esq dir : " + n0);
        NodeAVL<E> n1 = n0.esq;
        n0.esq = rotacaoEsq(n1);
        return rotacaoDir(n0);
    }
    private NodeAVL<E> duplaDirEsq(NodeAVL<E> n0){
        System.out.println("Rotacao dupla dir esq");
        //draw("Rotacao dupla dir esq : + n0);
        NodeAVL<E> n1 = n0.dir;
        n0.dir = rotacaoDir(n1);
        return rotacaoEsq(n0);
    }

    private int equlibrio(NodeAVL<E> n){
        if(n == null) return 0;
        return height(n.esq) - height(n.dir);
    }

    public static void main(String[] args){
        AVL_1<Integer> a = new AVL_1<>();
        a.insere(1);
        a.insere(2);
        a.insere(3);
        a.insere(4);
        a.insere(5);
        a.insere(6);
        a.insere(7);

        a.printEmOrdem();
    }
}
