public class LinkedListTester {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("ola");
        list.add("oi");
        list.add("ola");
        list.add("diz");
        list.add(2, "ops");
        list.add(0,"beg");
        list.set(4, "adeus");

        SingleNode current = list.head;
        String s = "";
        while (current != null){
            current = current.next;
        }
    }
}
