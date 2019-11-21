
public class IteradorEmOrdem<E> implements Iterator {
    ArrayStack<ABP.NoABP<E>> stack;

    IteradorEmOrdem(ABP.NoABP<E> node){
        stack = new ArrayStack<>();
        while (node != null){
            stack.push(node);
            node = node.esq;
        }
    }
    public boolean hasNext() {
        return !stack.empty();
    }

    public ABP.NoABP<E> next(){
        ABP.NoABP<E> atual = stack.pop();
        ABP.NoABP<E> dir = atual.dir;

        while (dir != null){
            stack.push(dir);
            dir = dir.esq;
        }
        return atual;
    }
    public void remove(){
        
    }
}
