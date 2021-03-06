public abstract class HashTable<T> {
    Elemento<T> table[];
    int ocupados = 0;

    public HashTable() {
    }

    public HashTable(int n) {
        table = new Elemento[n];
    }

    public int ocupados() {
        return ocupados;
    }

    public int capacity(){
        return table.length;
    }

    public float factorCarga() {
        return ocupados / (float) table.length;
    }

    protected abstract int procPos(T s);

    protected abstract int insertPos(T s);

    public void alocarTabela(int dim) {
        table = new Elemento[dim];
        ocupados = 0;
    }

    public void tornarVazia() {
        alocarTabela(table.length);
    }

    protected int hash(T s){
        int valHash = 0;

        for( int i = 0; i < ((String) s).length(); i++)
            valHash = 31 * valHash + ((String) s).charAt(i);

        valHash %= capacity();
        if( valHash < 0 )
            valHash += capacity();
        return valHash;
    }

    public T procurar (T t) {
        int possiblePlace = procPos(t);

        if (table[possiblePlace] != null) {

            if (table[possiblePlace].elem.equals(t)) {

                return table[possiblePlace].elem;
            }
        }
        return null;
    }

    public void remove(T t) {
        for (int i = 0; i < table.length; i++) {

            if (table[i] != null) {

                if (table[i].elem.equals(t)){

                    table[i].delete();
                }
                ocupados--;

            }
        }
    }

    public void insere(T t) {
        int insertPos = insertPos(t);
        if(table[insertPos] == null || table[insertPos].del) {
            table[insertPos] = new Elemento<T>(t);
            ocupados++;
        }
        if (factorCarga() > 0.5) {
            rehash();
        }
    }

    public void rehash() {
        Elemento<T> tempTable[] = table;
        alocarTabela(procPrimo(table.length * 2));
        for (int i = 0; i < tempTable.length; i++) {
            if (tempTable[i] != null) {
                if (tempTable[i].del == false) {
                    insere(tempTable[i].elem);
                }
            }
        }
    }

    public static int procPrimo(int n) {
        boolean found = false;
        while(!found) {
            if (isPrime(n))
                found = true;
            else
                n++;
        }
        return n;
    }

    public int procPrimoAnterior(int n) {
        boolean found = false;
        while(!found) {
            if (isPrime(n))
                found = true;
            else
                n--;
        }
        return n;
    }

    static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
    /*public boolean contains(Elemento<T> x){
        for (int i= 0; i < table.length; i++){
            if(table[i] != null) {
                if (!table[i].del){
                    if(table[i].elem.equals(x)){
                        return true;
                    }
                }
            }
        }
        return false;
    }*/

    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (table[i].del == false) {
                    System.out.println(table[i]);
                }
            }
        }
    }

    public void debugPrint() {
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                if (table[i].del == true) {
                    System.out.println("[" + table[i] + "] - deleted");
                } else {
                    System.out.println(i + " : " + "[" + table[i] + "]");
                }
            } else {
                System.out.println(i+ " : " + "[ ]");
            }
        }
    }
}