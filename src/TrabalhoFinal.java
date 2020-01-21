import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TrabalhoFinal {

    private static Position[][] genBoggle(String s) throws InvalidStringException
    {
       int length = s.length(); // comprimento da string
       int count = 0;          // posiçao
       int size;               // dimensao da matriz
       if(length % (Math.sqrt(length)) == 0){    // esta funcao so permite
           size = (int) (length / (Math.sqrt(length)));
       }else throw new InvalidStringException("Numero de letras invalido.");
       Position[][] boggle = new Position[size][size];
       for(int i = 0; i < size; i++){
           for(int j = 0; j < size; j++){
               count++;
               boggle[i][j] = new Position(i,j,s.charAt(count - 1));
           }
       }
       return boggle;
    }

    static String readBoggle() throws IOException
    {
        LinHashTable<String> table = new LinHashTable();
        URL url = TrabalhoFinal.class.getResource("boggle1.txt");
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);

        String content;
        content = sc.next();

        return content;
    }


    private static void printBoggle(Position[][] boggle)
    {
       for (int i = 0; i < boggle.length; i++) {
           for (int j = 0; j < boggle[i].length; j++) {
               System.out.print(boggle[i][j].ch + " ");
           }
           System.out.println();
       }
    }

    static LinHashTable<String> readWords() throws FileNotFoundException
    {

        LinHashTable<String> table = new LinHashTable();
        URL url = TrabalhoFinal.class.getResource("allWords.txt");
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            table.insere(sc.nextLine());
        }
        return table;
    }

    static LinHashTable<String> storePrefix(LinHashTable<String> words)
    {
        String tmp = "";
        LinHashTable<String> table = new LinHashTable<>();
        for(int i = 0; i < words.table.length; i++){
            Elemento<String> atual = words.table[i];

            if(atual != null){
                if(!atual.del){
                    if(atual.elem.length() > 3){ tmp = atual.elem.substring(0,3); }
                    if(table.procPos(tmp) == -1){
                        table.insere(tmp);
                    }
                }
            }
        }
        return table;
    }

    static Boolean isWord(String s, LinHashTable<String> words){ return words.procPos(s) != -1; }

    static void findWordsRec(Position[][] boggle, Position position, String word, LinHashTable<String> words, LinkedList<LinkedList<Position>> result)
    {
        position.checked = true;
        word += position.ch;

        if(isWord(word, words)){
            result.

        }
    } 





    public static void main(String[] args) throws InvalidStringException, FileNotFoundException {
       Position[][] boggle = genBoggle("seldomometinkyas".toUpperCase());
       printBoggle(boggle);
        LinHashTable<String> map = readWords();
        LinHashTable<String> map1 = storePrefix(map);
        //map.print();
        //map.debug();
        //map1.print();
        //System.out.println(isWord("camelt", map));
        //System.out.println(isWord("fox", map));

    }
}

