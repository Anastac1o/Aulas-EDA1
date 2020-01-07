import java.lang.Math;

public class LinHashTable<T> extends HashTable<T>{
    private static final int tamanhoPorDefeito = 200;

    public LinHashTable(){
        this(tamanhoPorDefeito);
    }

    public LinHashTable(int tamanho) {
        alocarTabela(tamanho);
        tornarVazia();
    }

    //metodo que implementa o acesso linear
    protected int procPos(T s){
        int colisoes = 1;
        int posActual = hash(s);
        while(table[posActual] != null)
        {
            if(table[posActual].elem.equals(s)){
                return posActual;
            }
            posActual += colisoes; // f(i) = i
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
            posActual += colisoes;
            colisoes += 1;
            if(posActual >= table.length){
                posActual = posActual % table.length;
            }
        }
        return posActual;
    }
}
