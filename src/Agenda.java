import java.util.ArrayList;

public class Agenda {
    ABP<Contato> t = new ABP<Contato>();
    IteradorEmOrdem<Contato> it = new IteradorEmOrdem<Contato>(t.root);

    private static class Contato implements Comparable<Contato> {
        String nome;
        Integer numContato;

        private Contato(String nome, int numContato) {
            this.nome = nome;
            this.numContato = numContato;
        }

        public int compareTo(Contato contato) {
            if (this.numContato > contato.numContato) {
                return 1;
            } else {
                if (this.numContato < contato.numContato) {
                    return -1;
                }
            }
            return 0;
        }

        public String toString() {
            return nome + ":" + this.numContato;
        }
    }


    private void insert(String s, int i) {
        t.insere(new Contato(s, i));
    }

    private void remove(String s) {
        IteradorEmOrdem<Contato> it = new IteradorEmOrdem<Contato>(t.root);
        while (it.hasNext()) {
            Contato c = it.next().element;
            if (c.nome.equals(s)) {
                t.remove(c);
            }
        }
    }

    private void listarAlfabeticamente() {
       /* it = new IteradorEmOrdem<Contato>(t.root);
        ArrayList<String> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next().element.nome);
        }

        list.sort(String::compareToIgnoreCase);

        for (String s : list) {
            System.out.print(s + " ");
        }*/
       t.printEmOrdem();
    }

    private String ligandoPraQuem(Integer i) {
        it = new IteradorEmOrdem<Contato>(t.root);
        while (it.hasNext()) {
            Contato c = it.next().element;
            if (c.numContato.equals(i)) {
                return c.nome;
            }
        }
        return "Número não guardado.";
    }

    private void contacto(String s){
        Contato c = new Contato(s,0);
        Contato res = t.find(c);
        if(res == null) {
            System.out.println("Contacto nao existente.");
        }else {
            System.out.println(res.toString());
        }
    }

    public static void main(String[] args) {
        Agenda a = new Agenda();
        a.insert("Bob", 9632123);
        a.insert("Joao", 9632125);
        a.insert("Maria", 696345345);
        a.insert("André", 923141123);

        a.listarAlfabeticamente();
        a.remove("Maria");
        System.out.println("");
        a.t.printEmOrdem();
        System.out.println("\n" + a.ligandoPraQuem(9632123));
        System.out.println(a.ligandoPraQuem(93454351));
        a.contacto("Joao");
    }


}