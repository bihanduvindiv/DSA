public class UnboundedArrayStack {
    int[]arr;
    int top;
    int capacity;


    UnboundedArrayStack(int capacity){
        this.capacity = capacity;
        arr = new int [capacity];
        top=-1;
    }
//resize the arry  //
    void resize (int Newcapacity){
        int [] Newarr =new int [Newcapacity];
        for (int i = 0; i <= top; i++) {
            Newarr[i] = arr[i];
        }
    arr = Newarr;
    capacity = Newcapacity;
    }
//push
    void push (int value){
        if (top == capacity-1){
            resize(capacity*2);
        }top ++;
        arr [top] = value;
    }
    // pop

    int pop() {
        if (top == -1) {
            throw new IllegalStateException("stack is empty");
        }
        int value = arr[top];//temp verible
        arr[top] = 0; //Clean the slot
        top--;// That mean move the  top pointer down
        if (capacity > 2 && top+1 <= capacity/4){
            resize(capacity/2);
        }
        return value;
    }
    //peek
    int peek(){
        if (top==-1){
            throw new IllegalStateException("Stack is empty");
        }
        return arr[top];
    }
    //is empty(check empty)
    boolean isEmpty (){
        return top == -1;
    }
    //get numbers of elements

    int size() {
        return top + 1;
    }
//display stack
    void display(){
        for (int i=top; i >=0; i--){
            System.out.println(arr[i]);
        }

        System.out.println("Capacity: " + capacity);
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack(2);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();
        System.out.println("Removed: " + stack.pop());

        stack.display();
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());

    }
}