import java.util.Random;

public class TrabalhoFinal {

    static class Boggle {
        Character[][] boggle = new Character[4][4];

        void genBoggle(){
            Random r = new Random();
            for (int i = 0; i < boggle.length; i++) {
                for (int j = 0; j < boggle.length; j++){
                    char c = (char) (r.nextInt(26) + 'a');
                    boggle[i][j] = c;
                }
            }
        }

        void printBoggle(){
            for (int i = 0; i < boggle.length; i++) {
                for (int j = 0; j < boggle[i].length; j++) {
                    System.out.print(boggle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    class Position{}

    public static void main(String[] args){
        Boggle boggle = new Boggle();
        boggle.genBoggle();
        boggle.printBoggle();
    }
}
