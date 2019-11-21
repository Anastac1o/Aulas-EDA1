import java.util.StringTokenizer;

public class ArvExp{


    private static boolean operator(String s){
        return (s.length()==1)&& s.equals("+")|| s.equals("-") || s.equals("*")|| s.equals("/");
    }
    private static boolean isNum(String s){
        try{
            float f=Float.valueOf(s).floatValue();
            return true;
        }
        catch (Exception e){/*System.out.println(e.getMessage());*/}
        return false;
    }

    public static float avalia(BTree<String> t){
        // deve retornar um float correspondente a avaliacao da arvore
        return avaliar(t.root);
    }

    public static float avaliar(BNode<String> n){
        // deve retornar um float correspondente a avaliação da arvore cuja
        //raiz e n
        if (isNum(n.data))
            return Float.valueOf(n.data);
        else
            return operacao( n.data ,avaliar(n.esq) ,avaliar(n.dir));

    }

    public static float operacao(String op, float a, float b){
        // deve retornar o  resultado da operacao a op b

        if (op.equals("+"))
            return a+b;
        else if (op.equals("-"))
            return a-b;
        else if (op.equals("*"))
            return b*a;
        else  return a/b;


    }


    public static void main(String[] args){
        //String postfix="2 8 - 9 / 7 * 67 7 5 * + 8 7 * / -";
        String postfix="30 4 2- 5* 7 3+/+";
        ArrayStack<BTree<String>> s=new ArrayStack<BTree<String>>();
        String token;
        StringTokenizer st=new StringTokenizer(postfix," *+-/",true);
        while (st.hasMoreTokens()){
            token =st.nextToken();
            System.out.println("lido:"+token);
            // implementar o algoritmo
        }
        BTree<String> t= s.top();

        System.out.println("Em ordem");
        //System.out.println(t.printInOrder());
        System.out.println("Pos ordem");
        //System.out.println(t.printPostOrder());
        System.out.println("Pre ordem");
        //System.out.println(t.printPreOrder());

        System.out.println(avalia(t));
    }

}
