package cn.tsplaycool.help;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author Tans
 *
 */
public class MinStack {
	private int[] stack = new int[99999];
	private int topPoint = 0;// 指向栈顶上一个元素

	public void push(int x) {
		stack[topPoint++] = x;
	}

	public void pop() {
		topPoint--;
	}

	public int top() {
		return stack[topPoint - 1];
	}

	public int getMin() {
		int min = stack[0];
		for (int i = 1; i < topPoint; i++) {
			if (stack[i] < min) {
				min = stack[i];
			}
		}
		return min;
	}
}