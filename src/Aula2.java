import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

abstract class Shape {
    abstract double area();

    int compareTo(Shape s) {
        if (this.area() > s.area()) {
            return 1;
        } else {
            if (this.area() < s.area()) {
                return -1;
            }else {
                return 0;
            }
        }
    }
    public String toString(){
        return "I am a class " + getClass().getSimpleName() + " my area is: " + this.area();
    }
}
class Circle extends Shape{
    double raio;

    Circle(double r){
        this.raio = r;
    }
    double area() {
        return raio * Math.PI;
    }
}

class Square extends Shape{
    double lado;

    Square(double l){
        this.lado = l;
    }

    double area() {
        return lado * lado;
    }
}

class Teste{
    static double totalShape(Shape[] arr){
        double areaTotal = arr[0].area();
        for(int i = 1; i < arr.length; i++){
            areaTotal += arr[i].area();
        }
        return areaTotal;
    }

    static double totalShape2(Collection<? extends Shape> collection){
        double areaTotal = 0;
        for(Shape s: collection){
            areaTotal += s.area();
        }
        return areaTotal;
    }

    static Comparable maior(Comparable[] array){
        Comparable maior = array[0];
        for(int i=0; i < array.length; i++){
            if(array[i].compareTo(maior)>0){
                maior = array[i];
            }
        }
        return maior;
    }
    public static void main(String[] args){
        Shape[] arr1 = new Shape[3];
        Circle[] arr2 = new Circle[3];
        Square[] arr3 = new Square[3];

        arr1[0] = new Circle(5);
        arr1[1] = new Square(32);
        arr1[2] = new Square(3);

        arr2[0] = new Circle(1);
        arr2[1] = new Circle(3);
        arr2[2] = new Circle(54);

        arr3[0] = new Square(1);
        arr3[1] = new Square(2);
        arr3[2] = new Square(5);

        /*for (int i=0; i<arr1.length; i++){
            System.out.println(arr1[i].toString());
            System.out.println(arr2[i].toString());
            System.out.println(arr3[i].toString());
        }*/
        System.out.println(totalShape(arr1));
        System.out.println(totalShape(arr2));
        System.out.println(totalShape(arr3));

        Collection<Shape> col1 = Arrays.asList(arr1);
        Collection<Shape> col2 = Arrays.asList(arr2);
        Collection<Shape> col3 = Arrays.asList(arr3);

        System.out.println(totalShape2(col1));
        System.out.println(totalShape2(col2));
        System.out.println(totalShape2(col3));

        String[] array1 = new String[3];
        Shape[] array2 = new Shape[3];
        array1[0] = "Cao";
        array1[1] = "Porco";
        array1[2] = "Gato";

        array2[0] = new Circle(2);
        array2[1] = new Circle(3);
        array2[2] = new Square(4);

        //System.out.println(maior(array1));
        //System.out.println(maior(array2));
    }
}
