import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABP<E extends Comparable<? super E>> implements ABP_i<E> {
    NoABP<E> root;

    public static class NoABP<E> {
        E element;
        NoABP<E> esq;
        NoABP<E> dir;
        int height = 1;


        NoABP(E o) {
            this.element = o;
            this.esq = null;
            this.dir = null;
        }

        NoABP(E e, NoABP<E> esq, NoABP<E> dir) {
            this.element = e;
            this.esq = esq;
            this.dir = dir;
        }
    }

    public ABP(){
        this.root = null;
    }

    public ABP(E x){
        this.root = new NoABP<E>(x);
    }

    public ABP(NoABP<E> x){
        this.root = x;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E x) { return contains(x, root); }

    public boolean contains(E x, NoABP<E> n) {
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
               return findMin(root);
        }
    }

    public E findMin(NoABP<E> n) {
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
            return findMax(root);
        }
    }

    public E findMax(NoABP<E> n){
        if(n.dir == null){
            return n.element;
        }else{
            return findMax(n.dir);
            }
        }

    public void insere(E x) {
        root = insere(x , root);
    }

    public NoABP<E> insere(E x, NoABP<E> n){
        if(n == null){
            n = new NoABP<E>(x, null, null);
        }else{
            if((n.element).compareTo(x) > 0){
                n.esq = insere(x, n.esq);
            }else{
                if((n.element).compareTo(x) < 0){
                n.dir = insere(x, n.dir);
                }
            }
        }
        //System.out.println("inserted:" + n.element.toString());
        return n;
    }

    public void remove(E x) {
        root = remove(x, root);
    }

    public void printEmOrdem(NoABP n){
        if(n == null) {return;}

        printEmOrdem(n.esq);
        System.out.print(n.element.toString()+ " ");
        printEmOrdem(n.dir);
    }

    public void printEmOrdem() {
        printEmOrdem(root);
    }
    public void printPosOrdem(NoABP n){
        if (n == null) {return;}

        printPosOrdem(n.esq);
        printPosOrdem(n.dir);
        System.out.print(n.element.toString() + " ");
    }
    public void printPosOrdem() {
        printPosOrdem(root);
    }

    public void printPreOrdem(NoABP n){
        if(n == null) {return;}

        System.out.print(n.element.toString()+" ");
        printPreOrdem(n.esq);
        printPreOrdem(n.dir);
    }

    public void printPreOrdem() {
        printPreOrdem(root);
    }

    private NoABP<E> remove(E x, NoABP<E> n) {
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

    public NoABP<E> find(E x, NoABP<E> n){
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
        NoABP n = find(x, root);
        return (E) n.element;
    }

    private int height(NoABP n) {
        if (n == null) return 0;
        return n.height;
    }

    private NoABP<E> rotacaoDir(NoABP<E> n0) {
        System.out.println("Rotacao dir");

        NoABP<E> n1 = (NoABP<E>) n0.esq;
        n0.esq = n1.dir;
        n1.dir = n0;

        n0.height = Math.max(height(n0.esq), height(n0.dir)) + 1;
        n1.height = Math.max(height(n1.dir), height(n1.esq)) + 1;

        return n1;
    }

    private NoABP<E> rotacaoEsq(NoABP<E> n0) {
        System.out.println("Rotaçao esq");

        NoABP<E> n1 = (NoABP<E>) n0.esq;
        n0.dir = n1.esq;
        n1.esq = n0;

        n0.height = Math.max(height(n0.esq), height(n0.dir)) + 1;
        n1.height = Math.max(height(n1.dir), height(n1.esq)) + 1;

        return n1;
    }
    private NoABP<E> duplaEsqDir(NoABP<E> n0){
        System.out.println("Rotacao dupla esq dir");
        //draw("Rotacao dupla esq dir : " + n0);
        NoABP<E> n1 = (NoABP<E>) n0.esq;
        n0.esq = rotacaoEsq(n1);
        return rotacaoDir(n0);
    }
    private NoABP<E> duplaDirEsq(NoABP<E> n0) {
        System.out.println("Rotacao dupla dir esq");
        //draw("Rotacao dupla dir esq : + n0);
        NoABP<E> n1 = (NoABP<E>) n0.dir;
        n0.dir = rotacaoDir(n1);
        return rotacaoEsq(n0);
    }

    private int equlibrio(NoABP<E> n){
        if(n == null) return 0;
        return height(n.esq) - height(n.dir);
    }

    public NoABP<E> insereAVL(E x, NoABP<E> n){
        //Insercao normal abp
        if(n == null){
            n = new NoABP<E>(x, null, null);
        }else{
            if((n.element).compareTo(x) > 0){
                n.esq = insere(x, n.esq);
            }else{
                if((n.element).compareTo(x) < 0){
                    n.dir = insere(x, n.dir);
                }
            }
        }
        //incrementar altura
        n.height = 1 + Math.max(height(n.esq),height(n.dir));
        
        return n;


    }

    public static void main(String[] args){
        ABP t = new ABP();
        t.insere(1);
        t.insere(3);
        t.insere(2);
        t.insere(4);
        t.insere(6);
        if(!t.isEmpty()){
        System.out.println(t.find(3));
        System.out.println(t.contains(4));
        System.out.println(t.findMax());
        System.out.println(t.findMin());
        }
    }
}
