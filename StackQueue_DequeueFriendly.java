import java.util.Stack;
import java.util.Queue;

public class StackQueue_DequeueFriendly{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //enqueue

    void  enqueue(int value){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
       } s1.push(value);System.out.println(value+" enqueued");

      while (!s2.isEmpty()) {
          s1.push(s2.pop());
        }

    }
    //dequeue
int dequeue(){
        if(s1.isEmpty()){
            throw new IllegalStateException("the queue is empty");

        } return s1.pop() ;
}

    //peek
int peek (){
        if (s1.isEmpty()){
            throw new IllegalStateException("queue is empty");
        }   return s1.peek();
    }
    //isEmpty()
    boolean isEmpty() {
        return s1.isEmpty(); }

public static void main(String[] args) {

    StackQueue_DequeueFriendly queue = new StackQueue_DequeueFriendly();

    queue.enqueue(9);
    queue.enqueue(2);
    queue.enqueue(4);
    queue.enqueue(6);

    System.out.println("Front element: " + queue.peek());
    System.out.println("Removed: " + queue.dequeue());
    System.out.println("New front: " + queue.peek());

    }
}