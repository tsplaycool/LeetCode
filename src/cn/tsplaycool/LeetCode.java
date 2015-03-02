package cn.tsplaycool;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode {

	public static void main(String[] args) {
		LeetCode leetCode = new LeetCode();
		int[] array = new int[] { 1, 2 };
		System.out.println("hello world!");
		leetCode.rotate(array, 1);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i] + " ");

		System.out.println(leetCode.isValid("[]{}"));
	}

	/**
	 * Given a column title as appear in an Excel sheet, return its corresponding column number.
	 * For example:
	 * A -> 1
	 * B -> 2
	 * C -> 3
	 * ...
	 * Z -> 26
	 * AA -> 27
	 * AB -> 28 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {

	}

	/**
	 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	 * For example:
	 * 1 -> A
	 * 2 -> B
	 * 3 -> C
	 * ...
	 * 26 -> Z
	 * 27 -> AA
	 * 28 -> AB 
	 * ...
	 * 54 -> AZ
	 * 55 -> BA
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {// 这个题目相当于把十进制转成26进制
		String result = "";
		while (n > 0) {
			int x = n % 26;
			if (x == 0)
				x = 26;
			result = (char) (x + 'A' - 1) + result;
			n = (n - 1) / 26;
		}
		return result;
	}

	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {// 利用栈来做
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			Character character = new Character(a);
			if (!stack.isEmpty()
					&& isSame(stack.peek().charValue(), character.charValue())) {
				stack.pop();
			} else {
				stack.push(new Character(a));
			}
		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isSame(char a, char b) {
		if (a == '[' && b == ']') {
			return true;
		} else if (a == '{' && b == '}') {
			return true;
		} else if (a == '(' && b == ')') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Rotate an array of n elements to the right by k steps.
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		if (nums.length == 1) {
			return;
		}
		int n = k % (nums.length - 1);
		if (n == 0) {
			return;
		}
		revert(nums, 0, n);
		revert(nums, n + 1, nums.length - 1);
		revert(nums, 0, nums.length - 1);
	}

	private void revert(int[] nums, int start, int end) {
		if (start == end)
			return;
		for (int i = 0; i <= (end - start) / 2; i++) {
			int temp = nums[start + i];
			nums[start + i] = nums[end - i];
			nums[end - i] = temp;
		}
	}

	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		boolean isNeedAddRoom = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				isNeedAddRoom = false;
				break;
			}
		}
		int digitsLength = digits.length;
		int[] result;
		if (isNeedAddRoom) {
			result = new int[digitsLength + 1];
			result[0] = 1;
		} else {
			result = digits;
			for (int i = digitsLength - 1; i >= 0; i--) {
				if (result[i] == 9) {
					result[i] = 0;
				} else {
					result[i]++;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,
	 * Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2]
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
		int header = 0;
		int tail = 0;
		for (int i = 0; i < A.length; i++) { // 设置两个指针
			if (A[header] != A[tail]) {
				header++;
				A[header] = A[tail];
			}
			tail++;
		}

		if (A.length > 0)
			A = Arrays.copyOf(A, ++header);
		return A.length;
	}

}
