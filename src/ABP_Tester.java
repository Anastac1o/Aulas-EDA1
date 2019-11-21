public class ABP_Tester {
    public static void main(String[] args) {
        ABP<Integer> t = new ABP<Integer>();
        t.insere(50);
        t.insere(30);
        t.insere(20);
        t.insere(40);
        t.insere(70);
        t.insere(60);
        t.insere(80);

        t.printEmOrdem();
        System.out.println("");
        t.printPreOrdem();
        System.out.println("");
        t.printPosOrdem();
        System.out.println("");
        t.remove(20);
        t.remove(50);

        IteradorEmOrdem it = new IteradorEmOrdem(t.root);
        while (it.hasNext()){
            System.out.println(it.next().element.toString());
        }

        while (it.hasNext()){
            System.out.println(it.next().element.toString());
        }
    }
}