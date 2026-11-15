import java.util.Queue;
import java.util.Stack ;
public class StackQueue_EnqueueFriendly {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //enqueue
    void enqueue(int value){
        s1.push(value);
        System.out.println(value + " added");

    }
    int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        // Transfer only when s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    //peek
    int peek (){
        if (s1.isEmpty()&& s2.isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }    return s2.peek();
    }
    // Check whether queue is empty
    boolean isEmpty() {

        return s1.isEmpty() && s2.isEmpty();
    }

    // Display the queue
    void display() {

        System.out.print("Queue: ");

        // Print s2 from top to bottom
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

        // Print s1 from bottom to top
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }

   static void main(String[] args) {
        StackQueue_EnqueueFriendly queue = new StackQueue_EnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());

        queue.display();

        queue.enqueue(40);

        queue.display();

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());
    
    }
}