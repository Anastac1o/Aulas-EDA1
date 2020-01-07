import java.lang.Math;

public class QuadHashTable<T> extends HashTable<T> {

    public QuadHashTable() {
        super();
    }

    public QuadHashTable(int n) {
        super(n);
    }

    protected int procPos(T s){
        int colisoes = 1;
        int posActual = hash(s);
        while(table[posActual] != null)
        {
            if(table[posActual].elem.equals(s)){
                return posActual;
            }
            posActual += colisoes * colisoes; // f(i) = i^2
            colisoes += 1;
            if(posActual >= table.length) {
                posActual = posActual % table.length;
            }
        }

        return -1;
    }

    protected int insertPos(T s){
        int colisoes = 1;
        int posActual = hash(s);
        while(table[posActual] != null){
            posActual += colisoes * colisoes;
            colisoes += 1;
            if(posActual >= table.length){
                posActual = posActual % table.length;
            }
        }
        return posActual;
    }
}