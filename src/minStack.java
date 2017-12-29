import java.util.Stack;

public class minStack {
    Stack<Integer> s;
    Stack<Integer> min_stack;
    int min;

    public minStack() {
        this.min = Integer.MAX_VALUE;
        s = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        if(x<=min){
            min = x;
            s.push(x);
            min_stack.push(x);
        }else{
            s.push(x);
        }
    }

    public void pop() {
        System.out.println();
        System.out.println(s.peek());
        System.out.println(min_stack.peek());
        if(s.peek()  == min_stack.peek()){
            s.pop();
            min_stack.pop();
        }else{
            s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
