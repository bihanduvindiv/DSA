import java.util.Queue;
import java.util.ArrayDeque;

public class QueueStack_PopFriendly{
    Queue <Integer> q1 = new ArrayDeque<>();
    Queue <Integer> q2 = new ArrayDeque<>();
    //push
    void push (int value){
        q2.add(value);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        //swap the queues
        Queue<Integer> temp = q1;
        q1=q2;
        q2=temp;
        System.out.println(value+"pushed");
    }

    //pop
    int pop(){
        if (q1.isEmpty()){
            throw new  IllegalArgumentException(" stack is empty ");
        }
        return q1.remove();
    }

    int peek() {

        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return q1.peek();
    }

    // Check whether stack is empty
    boolean isEmpty() {
        return q1.isEmpty();
    }

    // Display stack
    void display() {
        System.out.println("Stack (top to bottom): " + q1);
    }
public static void main(String[] args) {
    QueueStack_PopFriendly stack = new QueueStack_PopFriendly();

    stack.push(10);
    stack.push(20);
    stack.push(30);

    stack.display();

    System.out.println("Top: " + stack.peek());

    System.out.println("Removed: " + stack.pop());

    stack.display();
    
    }
}