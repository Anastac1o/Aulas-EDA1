public class QueueArray<E> implements Queue<E> {

    E[] queue;

    int N;
    int ini = 0;
    int fim = 0;



    public QueueArray(int size){ queue = (E[]) new Object[size+1]; N = size; }

    public void enqueue(E o) {
        if(this.size() != N - 1) {
            queue[fim] = o;
            fim = inc(fim);
        }else
            System.out.println("Full Queue!");


    }

    public int inc(int i){
        return (i+1) % N;
    }

    public E front() {
        return queue[ini];
    }

    public E dequeue(){
        if(!this.empty()) {
            E x = queue[ini];
            queue[ini] = null;
            ini = inc(ini);
            return x;
        }else {
            System.out.println("Empty Queue!");
            return null;
        }
    }

    public int size() {
        return (N-ini+fim) % N;
    }

    public boolean empty() {
        return ini == fim;
    }
}


class Tester{
    public static void main(String[] args){
        QueueArray<Integer> queue = new QueueArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
    System.out.println(queue.front());

    }
}
