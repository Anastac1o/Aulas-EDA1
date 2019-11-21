import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABP<E extends Comparable<? super E>> implements ABP_i<E> {
    NoABP<E> root;

    static class NoABP<E> {
        E element;
        NoABP<E> esq;
        NoABP<E> dir;

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

    public boolean contains(E x) {
        return false;
    }


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

    private NoABP<E> insere(E x, NoABP<E> n){
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
}
