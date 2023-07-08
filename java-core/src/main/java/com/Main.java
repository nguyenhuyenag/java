package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		final int[] array = {1, 2, 3, 4, 5};

        // Không thể thay đổi giá trị của các phần tử trong mảng
        array[0] = 10; // Lỗi biên dịch: Cannot assign a value to final variable 'array'
        
        for (int num : array) {
            System.out.println(num);
        }
	}

}
