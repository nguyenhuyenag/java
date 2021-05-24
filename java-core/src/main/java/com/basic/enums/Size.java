package com.basic.enums;

/**
 * - ordinal(SMALL): Trả về vị trí của một hằng số enum // returns 0
 *
 * - compareTo(): So sánh hằng enum dựa trên giá trị thứ tự
 * 
 * Size.SMALL.compareTo(Size.MEDIUM) // returns ordinal(SMALL) - ordinal(MEDIUM)
 *
 * - name(): Trả về tên xác định một hằng số enum ở dạng chuỗi. Giá trị trả về
 * từ phương thức name() là final
 * 
 * name(SMALL) // returns "SMALL"
 *
 * - valueOf(): Nhận một chuỗi và trả về một hằng số enum có tên chuỗi tương tự
 *
 * Size.valueOf("SMALL") // returns constant SMALL
 * 
 * - values(): Trả về một mảng của kiểu enum chứa tất cả các hằng số enum
 * 
 * Size[] enumArray = Size.value();
 * 
 */
public enum Size {
	SMALL, MEDIUM, LARGE, EXTRALARGE;
}
