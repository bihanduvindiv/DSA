import java.util.Queue;
import java.util.ArrayDeque;

public class QueueStack_PushFriendly {
    //we need to create 2 queues to make a stack
    Queue<Integer> q1=new ArrayDeque<>(); // queue 1
    Queue<Integer> q2=new ArrayDeque<>(); // second queue

    // push
    void push(int value){
    q1.add(value);
        System.out.println(value+"pushed");

    }
    // pop Move all elements except the last to q2 to access the "top"
    int  pop(){
        if (q1.isEmpty()){
            throw new IllegalStateException("The stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int removed = q1.remove(); // this is the top of the stack

        //swap the queues
        Queue<Integer> temp = q1 ;
        q1=q2;
        q2=temp ;
        return removed;
    }

    // PEEK - Same as pop, but puts the top element back into q2
    int peek() {

        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();

        // Put the top element back
        q2.add(top);

        // Swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }
   public static void main(String[] args) {
       QueueStack_PushFriendly qs = new QueueStack_PushFriendly();
       qs.push(10);
       qs.push(20);
       qs.push(30);
       qs.push(40);

       System.out.println("Top: " + qs.peek());
       System.out.println("Top: " + qs.pop());
       System.out.println("Top: " + qs.pop());
       System.out.println("Top: " + qs.peek());
    }
}