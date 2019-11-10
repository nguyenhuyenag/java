package com.collection.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*-
 * E- Element (phần tử – được sử dụng phổ biến trong Collection Framework)
 * K – Key (khóa)
 * V – Value (giá trị)
 * N – Number (kiểu số: Integer, Double, Float, …)
 * T – Type (Kiểu dữ liệu bất kỳ thuộc Wrapper class: String, Integer, Long, Float,...)
 * S, U, V … – được sử dụng để đại diện cho các kiểu dữ liệu (Type) thứ 2, 3, 4,...
 */
public class MethodGeneric {

	static <T> long count(Collection<T> collection, T key) {
		return collection.stream().filter(t -> t == key).count();
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 1, 2, 5, 6, 78, 1);
		System.out.println(count(list, 1)); // 4
	}

}
