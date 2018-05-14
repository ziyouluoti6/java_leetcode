/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

class QueueByStack {
	
	// push into 1
	Stack<Integer> stack1 = new Stack<>();
	// out from 2
	Stack<Integer> stack2 = new Stack<>();
	
	public QueuedEvents() {
		
	}
	
	// element is not generics
	// add in the end
	public void push(int n) {
		stack1.push(n);
	}
	
	// take out from head
	public int pop() {
		if (stack2.empty()){
			// push all elements from 1 to 2
			while(!stack1.empty()) {stack2.push(stack1.pop());}
		}
        
        return stack2.pop();
	}
	
	// get head
	public int peek() {
		if (stack2.empty()){
			// push all elements from 1 to 2
			while(!stack1.empty()) {stack2.push(stack1.pop());}
		}
        
        return stack2.peek();
	}
	
	public boolean empty() {
		return stack1.empty() && stack2.empty();
	}
	
}