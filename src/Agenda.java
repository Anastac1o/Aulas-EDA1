import java.awt.*;
import java.util.ArrayList;

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


    public void insert(String s, int i){
        t.insere(new Contato(s, i));
    }

    public void remove(String s){
        while (it.hasNext()){
            if (it.next().element.nome.equals(s)){
                t.remove(it.next().element);
            }
        }
    }

    public void listarAlfabeticamente(){
        it = new IteradorEmOrdem<>(t.root);
        ArrayList<String> list = new ArrayList<>();
        while (it.hasNext()){
            list.add(it.next().element.nome);
        }
        list.sort(String::compareToIgnoreCase);
        for (String s :list) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args){
        Agenda a = new Agenda();
        a.insert("Bob",9632123);
        a.insert("Joao",9632125);
        a.insert("Maria",696345345);
        a.insert("André", 923141123);

        a.listarAlfabeticamente();
        System.out.println("");
        a.t.printEmOrdem();
    }

    
}