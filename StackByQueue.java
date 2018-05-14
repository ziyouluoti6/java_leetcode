/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

class StackByQueue {
	
	// since queue is interface, using LinkedList here, can get/remove both head and tail
	LinkedList<Integer> list1 = new LinkedList<>();
	LinkedList<Integer> list2 = new LinkedList<>();
	
	public StackByQueue() {
		
	}
	
	public void push(int x) {
		// assume always have one empty queue
		if (list1.size() == 0) {
			list1.add(x);  
        } else {
			list2.add(x);	
		}
	}
	
	public int pop() {
		if (list1.size() == 0) {
			while(list2.size() > 1) {list1.add(list2.poll());}
			return list2.poll();
		} else {
			while(list1.size() > 1) {list2.add(list1.poll());}
			return list1.poll();
		}
	}
	
	public int top() {
		return list1.size() == 0 ? list2.peekLast() : list1.peekLast();
	}
	
	public boolean empty() {
		return list1.size() == 0 && list2.size() == 0;
	}
}
