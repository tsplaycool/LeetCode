package cn.tsplaycool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import cn.tsplaycool.help.ListNode;
import cn.tsplaycool.help.MinStack;
import cn.tsplaycool.help.TreeNode;

public class LeetCode {

	public static void main(String[] args) {
		LeetCode leetCode = new LeetCode();
		int[] array = new int[] { 1, 2 };
		System.out.println("hello world!");
		leetCode.rotate(array, 1);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i] + " ");

		System.out.println(leetCode.isValid("[]{}"));

		TreeNode[] nodes = new TreeNode[7];
		nodes[0] = new TreeNode(1);
		nodes[1] = new TreeNode(-2);
		nodes[2] = new TreeNode(-3);
		nodes[3] = new TreeNode(1);
		nodes[4] = new TreeNode(3);

		nodes[5] = new TreeNode(-2);

		nodes[6] = new TreeNode(-1);
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];

		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		nodes[2].left = nodes[5];

		nodes[3].left = nodes[6];

		System.out.println(leetCode.hasPathSum(nodes[0], 5));

		int[] num = { 6, 5, 5 };
		System.out.println(leetCode.majorityElement(num));
		System.out.println(leetCode.lengthOfLastWord("a "));
		System.out.println(leetCode.compareVersion("1.0", "1"));
		System.out.println(leetCode.convert("PAYPALISHIRING", 3));
		MinStack minStack = new MinStack();
		minStack.push(-3);
		System.out.println(minStack.getMin());
		System.out.println(leetCode.reverse(-123));
		System.out.println(leetCode.atoi("   +0 123"));
		System.out.println(leetCode.isPalindrome(-2147447412));
		TreeNode[] a = new TreeNode[4];
		a[0] = new TreeNode(0);
		a[1] = new TreeNode(0);
		a[2] = new TreeNode(0);
		a[3] = new TreeNode(0);
		a[0].left = a[1];
		a[0].right = a[2];
		a[1].right = a[3];
		System.out.println(leetCode.maxDepth(nodes[0]));
		for (int i = 0; i < 31; i++) {
			System.out.println(leetCode.getRow(i));
		}
		System.out.println(leetCode.generate(5));
		System.out.println(leetCode.hammingWeight(2147483647));
	}

	/**
	 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
	 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        do{
            if((n & 1) == 1) count++;
            n >>>= 1;
            i++;
        }while(i <= 32);
        return count;
        
    }

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * For example, given numRows = 5,
	 * Return
	[
	[1],
	[1,1],
	[1,2,1],
	[1,3,3,1],
	[1,4,6,4,1]
	]
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<Integer> tempRows = new ArrayList<Integer>();
		List<Integer> preRows = new ArrayList<Integer>();
		List<Integer> pascalRows = null;
		List<List<Integer>> pascalRowsList = new ArrayList<List<Integer>>();
		for (int row = 0; row < numRows; row++) {
			if (row == 0) {
				pascalRows = new ArrayList<Integer>();
				pascalRows.add(1);
				pascalRowsList.add(pascalRows);
				continue;
			}
			if (row == 1) {
				pascalRows = new ArrayList<Integer>();
				pascalRows.add(1);
				pascalRows.add(1);
				tempRows.clear();
				tempRows.addAll(pascalRows);
				pascalRowsList.add(pascalRows);
				continue;
			}

			pascalRows = new ArrayList<Integer>();
			pascalRows.clear();
			pascalRows.addAll(tempRows);
			preRows.clear();
			preRows.addAll(tempRows);
			for (int i = 1; i < row; i++) {
				pascalRows.set(i, preRows.get(i - 1) + preRows.get(i));
			}
			pascalRows.add(1);
			tempRows.clear();
			tempRows.addAll(pascalRows);
			pascalRowsList.add(pascalRows);
		}
		return pascalRowsList;
	}

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.(杨辉三角)
	 * For example, given k = 3,
	 * Return [1,3,3,1].
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {// 若使用递归,OJ编译器会报TLE运行超时错误
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> pre = new ArrayList<Integer>();

		if (rowIndex < 0) {
			return result;
		}
		for (int row = 0; row <= rowIndex; row++) {
			if (row == 0) {
				result.add(1);
				continue;
			}
			if (row == 1) {
				result.add(1);
				continue;
			}
			pre.clear();
			pre.addAll(result);
			for (int i = 1; i < row; i++) {
				result.set(i, pre.get(i - 1) + pre.get(i));
			}
			result.add(1);

		}
		return result;

	}

	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if (leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}
	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.(回文)
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x != Math.abs(x)) {
			return false;
		}
		int a = x;
		if (a > 0 && a < 10) {
			return true;
		}
		int revertA = 0;
		while (a / 10 != 0) {
			revertA = ((revertA * 10) + (a % 10));
			a = a / 10;
		}
		revertA = ((revertA * 10) + (a % 10));
		if (revertA == Math.abs(x)) { // 翻转x之后，如果与x相等，则为回文
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Implement atoi to convert a string to an integer.
	 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
	 * @param str
	 * @return
	 */
	public int atoi(String str) {
		str = str.trim();
		int isNegative = 1;
		boolean isAlreadyJudgeNegative = false;
		boolean isAlreadyCalc = false;
		StringBuilder resultSb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == '-' && !isAlreadyJudgeNegative) {
				isAlreadyJudgeNegative = true;
				isAlreadyCalc = true;
				isNegative = -1;
				continue;
			}
			if (temp == '+' && !isAlreadyJudgeNegative) {
				isAlreadyJudgeNegative = true;
				isAlreadyCalc = true;
				continue;
			}
			if (temp > '9' || temp < '0') {
				break;
			}

			if (temp <= '9' && temp >= '0') {
				if (!isAlreadyCalc) {
					isAlreadyCalc = true;
				}
				isAlreadyJudgeNegative = true;
				resultSb.append(temp);
			}
		}
		int result = 0;
		try {
			if (resultSb.length() != 0) {
				result = isNegative * Integer.parseInt(resultSb.toString());
			}
		} catch (NumberFormatException e) {
			if (isNegative == -1) {
				result = Integer.MIN_VALUE;
			} else {
				result = Integer.MAX_VALUE;
			}
		}
		return result;
	}

	/**
	 * Reverse digits of an integer.

	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		boolean isNegative;
		if (x == Math.abs(x)) {
			isNegative = false;
		} else {
			isNegative = true;
		}
		x = Math.abs(x);
		int j = 1;
		int temp = x;
		while (temp / 10 != 0) {
			j++;
			temp = temp / 10;
		}
		byte[] n = new byte[j];
		int i = 0;
		do {
			n[i] = (byte) (x % 10);
			i++;
			x = x / 10;
		} while (x != 0);
		int result;
		StringBuilder builder = new StringBuilder();
		for (int k = 0; k < n.length; k++) {
			builder.append(n[k]);
		}
		try {
			result = Integer.parseInt(builder.toString());
			if (isNegative) {
				result = -result;
			}
		} catch (NumberFormatException e) {
			result = 0;
		}
		return result;
	}

	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	 	P   A   H   N
		A P L S I I G
		Y   I   R
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a number of rows:

	 * string convert(string text, int nRows);
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		if (nRows <= 1)
			return s;
		int period = (nRows << 1) - 2;
		char[] array = s.toCharArray();

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			int j = i;
			int index = 0, temp = 0;

			while (j < array.length) {

				result = result.append(array[j]);

				if (i != 0 && i != nRows - 1) {

					temp = (j % period);
					index = ((temp < nRows) ? (nRows - 1 - temp) << 1
							: (period - temp) << 1);
					j += index;
				} else {
					j += period;
				}
			}
		}

		return result.toString();
	}

	/**
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 * For example, the following two linked lists:
	 * 
	 *	A:          a1 → a2
	               			↘
	                 			c1 → c2 → c3
	               			↗            
	 *	B:    	b1 → b2 → b3
	 *
	 * begin to intersect at node c1.
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode h1 = headA;
		ListNode h2 = headB;
		int count1 = 1, count2 = 1;
		while (h1.next != null) {
			count1++;
			h1 = h1.next;
		}
		while (h2.next != null) {
			count2++;
			h2 = h2.next;
		}
		if (h1 != h2)
			return null;
		else {
			int count = Math.abs(count1 - count2);
			if (count2 > count1) {
				h1 = headB;
				h2 = headA;
			} else {
				h1 = headA;
				h2 = headB;
			}
			while ((count--) > 0) {
				h1 = h1.next;
			}
			while (h1 != null && h2 != null && h1 != h2) {
				h1 = h1.next;
				h2 = h2.next;
			}
			return h1;
		}
	}

	/**
	 * Compare two version numbers version1 and version2.
	 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

	 * You may assume that the version strings are non-empty and contain only digits and the . character.
	 * The . character does not represent a decimal point and is used to separate number sequences.
	 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

	 * Here is an example of version numbers ordering:

	 * 0.1 < 1.1 < 1.2 < 13.37
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		String[] version_1, version_2;
		if (!version1.contains(".")) {
			version_1 = new String[1];
			version_1[0] = version1;
		} else {
			version_1 = version1.split("\\.");// . 在正则表达式中指任何字符,所以加上转义字符
		}
		if (!version2.contains(".")) {
			version_2 = new String[1];
			version_2[0] = version2;
		} else {
			version_2 = version2.split("\\.");
		}
		for (int i = 0; i < version_1.length || i < version_2.length; i++) {
			int v1 = 0, v2 = 0;
			if (i >= version_1.length) {
				v2 = Integer.parseInt(version_2[i]);
				if (v2 != 0) {
					return -1;
				}
			} else if (i >= version_2.length) {
				v1 = Integer.parseInt(version_1[i]);
				if (v1 != 0) {
					return 1;
				}
			} else {
				v1 = Integer.parseInt(version_1[i]);
				v2 = Integer.parseInt(version_2[i]);
			}
			if (v1 > v2) {
				return 1;
			} else if (v1 == v2) {
				continue;
			} else {
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	 * If the last word does not exist, return 0.
	 * Note: A word is defined as a character sequence consists of non-space characters only.
	 * For example, 
	 * Given s = "Hello World",
	 * return 5.
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int blankLocation = s.trim().lastIndexOf(" ");
		String part = s.trim().substring(blankLocation + 1);
		return part.length();
	}

	/**
	 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			int numValue = num[i];
			Integer numInteger = new Integer(numValue);
			if (map.containsKey(numValue)) {
				map.put(numInteger, map.get(numInteger).intValue() + 1);
			} else {
				map.put(numInteger, 1);
			}
			if (map.get(numInteger).intValue() > num.length / 2) {
				return numValue;
			}
		}
		return -1;
	}

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	 * For example:
	 * Given the below binary tree and sum = 22,
	          5
	         / \
	        4   8
	       /   / \
	      11  13  4
	     /  \      \
	    7    2      1
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) { // 利用递归
		if (root == null) {
			return false;
		}
		int path = root.val;
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		if (leftNode == null && rightNode == null && path == sum) {
			return true;
		}
		if (leftNode != null) {
			if (hasPathSum(leftNode, sum - path)) {
				return true;
			}
		}
		if (rightNode != null) {
			if (hasPathSum(rightNode, sum - path)) {
				return true;
			}
		}
		return false;
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
	public int titleToNumber(String s) {// 这个题目相当于把十进制转成26进制
		char[] a = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += Math.pow(26, i) * (a[a.length - 1 - i] - 'A' + 1);
		}
		return sum;

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
