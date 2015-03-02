package cn.tsplaycool;

import java.util.Arrays;

public class LeetCode {

	public static void main(String[] args) {
		System.out.println("hello world!");
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
		for (int i = 0; i < A.length; i++) { //设置两个指针
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
