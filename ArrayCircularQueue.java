public class ArrayCircularQueue{

    int [] arr;
    int front;
    int rear ;
    int capacity;
    int size;


    ArrayCircularQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        this.capacity = capacity;
        arr = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }
    //enqueue
    void enqueue(int value) {

        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        rear = (rear + 1) % capacity;

        arr[rear] = value;

        size++;
    }
    //dequeue
    int dequeue() {

        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int removed = arr[front];

        arr[front] = 0;

        front = (front + 1) % capacity;

        size--;

        return removed;
    }
    //peek
    int peek() {

        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return arr[front];
    }
    //is empty
    boolean isEmpty() {
        return size == 0;
    }
    // is full
    boolean isFull() {
        return size == capacity;
    }
//dispaly
    void display() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(arr[index] + " ");
        }

        System.out.println();
    }

static void main(String[] args){ ArrayCircularQueue queue =
        new ArrayCircularQueue(5);

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);

    queue.display();

    System.out.println("Removed: " + queue.dequeue());
    System.out.println("Removed: " + queue.dequeue());

    queue.display();

    queue.enqueue(60);
    queue.enqueue(70);

    queue.display();

    System.out.println("Front: " + queue.peek());
    }
}
