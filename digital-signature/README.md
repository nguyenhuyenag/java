# Primitive Data Types

	TYPE		SIZE		MIN			MAX
	byte		1 byte		-2^7		2^7 - 1
	short		2 bytes		-2^(15)		2^(15) - 1		
	int			4 bytes		-2^(31)		2^(31) - 1
	long		8 bytes		-2^(63)		2^(63) - 1
	float 		4 bytes	
	double 		8 bytes
	char		2 byte		0			2^16 (unsigned)

# Generics (Java >= 5)
	
	- Không thể gọi Generics bằng kiểu dữ liệu Primitive
	
	- Không thể tạo instances của kiểu dữ liệu Generics
	
	- Không thể sử dụng static cho Generics
	
	- Không thể ép kiểu hoặc sử dụng instanceof
	
	- Không thể tạo mảng với parameterized types
	
	- Không thể tạo, catch, throw đối tượng của parameterized types
	
	- Không thể overload các hàm trong một lớp giống như

# Static

	- Method
	
		+ Phương thức static thuộc lớp chứ không thuộc đối tượng của lớp
		
		+ Phương thức static chỉ có thể gọi một phương thức static
		
		+ Phương thức static không thể sử dụng từ khóa this, super
		
		+ Không thể override (ghi đè) phương thức static
		
	- Class
		
		+ Chỉ khai báo được static class khi nó nằm trong 1 class khác (nested class)
	
	- Với Java < 7 có thể thực thi chương trình mà không cần phương thức main()

# This (đối tượng hiện tại của class)

	- Không thể dùng this hay super trong phương thức static do phương thức static không gắn
	
	  với đối tượng, nên không có this.
		
# Final

	- Method

		+ Phương thức final có thể KẾ THỪA nhưng không thể ghi đè (override)

	- Class

		+ Không thể kế thừa class final

# TreeMap

	- TreeMap lưu trữ dữ liệu dưới dạng cặp key và value
	
	- TreeMap chỉ chứa các key duy nhất
	
	- TreeMap KHÔNG cho phép bất kỳ key nào là null và nhưng có thể có nhiều giá trị null
	
	- TreeMap tự động sắp xếp các phần tăng dần theo key 
	
# LinkedHashMap

	- LinkedHashMap lưu trữ dữ liệu dưới dạng cặp key và value
	
	- LinkedHashMap chỉ chứa các key duy nhất
	
	- LinkedHashMap có thể có 1 key là null và nhiều giá trị null
	
	- LinkedHashMap duy trì các phần tử theo thứ tự chèn
	
# Exception

	- Có 2 loại là: Runtime exception và Checked exception
	
	- Runtime exception là lỗi trong lúc mình thực thi chương trình, còn Checked exception là lỗi trong quá trình biên dịch.	
	
# Throw vs Throws

	Throw											Throws
	
	- Ném ra một ngoại lệ							- Khai báo một ngoại lệ
	
	- Checked exception không được ném ra 		- Ném ra checked exception ngay cả khi chỉ sử dụng throws
	  nếu chỉ sử dụng throw
	  
	- Sau throw là một new instance				- Sau throws là một hoặc nhiều class
	
	- Không thể throw nhiều exception			- Có thể throw nhiều exception (dùng dấu phẩy)

# For loop vs Iterator

	- Iterator có khả năng thêm/xoá những phần từ tập hợp trong quá trình duyệt.
	
	- Sử dụng for-each bạn không thể làm được điều này, sẽ phát sinh lỗi ConcurrentModificationException.
	
	- Sử dụng for-index có thể thêm/xóa được, nhưng có thể sẽ gặp lỗi khác là IndexOutOfBoundsException.
	
# Overloading (nạp chồng) & Overriding (ghi đè)

	- Nạp chồng phương thức là ví dụ về đa hình lúc biên dịch.
	
	- Ghi đè phương thức là ví dụ về đa hình lúc runtime.

# compare(T obj1, T obj2) và compareTo(T object)

	- compare() is from the Comparator interface, so it is used to compare two different instances of another class with each other.

	- compareTo() is from the Comparable interface, so it is used to compare THIS instance to another one.

# mvn javadoc:javadoc

