public class Agenda  {
    ABP<Contato> t = new ABP();
    IteradorEmOrdem<Contato> it = new IteradorEmOrdem<>(t.root);

    private static class Contato implements Comparable<Contato> {
        String nome;
        int numContato;

        private Contato(String nome, int numContato){
            this.nome = nome;
            this.numContato = numContato;
        }

        public int compareTo(Contato contato) {
            if(this.numContato > contato.numContato){
                return 1;
            }else{
                if (this.numContato < contato.numContato){
                    return -1;
                }
            }
            return 0;
        }

        public String toString(){
            return nome;
        }
    }


    public void insert(Contato c){
        t.insere(c);
    }

    public void remove(String s){
        while (it.hasNext()){
            if (it.next().element.nome.equals(s)){
                t.remove(it.next().element);
            }
        }
    }

    
}