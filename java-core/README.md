# Regular Expression

	Biểu thức					Mô tả
	
		.				-		Khớp với 1 kí tự bất kỳ, ngoại trừ ký tự xuống dòng `\n`
		
		^				-		Khớp với phần bắt đầu của dòng
	   
		$				-		Kết thúc dòng phải thỏa mãn mẫu phía trước $
	   
	   [...]			-		Khớp với 1 kí tự bất kỳ có trong dấu ngoặc vuông
	   
	   							Nếu [] chứa . thì nó biểu diễn ký tự `.`
	   
	   [^...]			-		Khớp với 1 ký tự bất kỳ không có trong dấu ngoặc vuông
								
								Dấu ^ (dấu mũ) nằm trong dấu ngoặc vuông là một dấu phủ định
	   
	   [a-d]			-		Khớp với 1 kí tự nằm giữa a và d, dùng dấu `-` làm dấu ngăn cách
	   
		|				-		Phép toán or
	   
	   \d				-		Kí tự số, viết ngắn gọn của [0-9]
	   
	   \D				-		Ký tự không phải là số, viết gọn của [^\d] hoặc [^0-9]
	   
	   \s				-		Ký tự khoảng trắng, bao gồm cả tab
	   
	   \S				-		Ký tự không phải khoảng trắng, viết gọn của [^\s]
	   
	   \w				-		Ký tự từ (chữ cái, số, dấu gạch dưới _ ), viết gọn của [a-zA-Z_0-9]
	   
	   \W				-		Ký tự không phải chữ, viết gọn của [^\w] hoặc [^a-zA-Z_0-9]
	   
		\b				- 		Khớp với toàn bộ ký tự đứng trước nó
		
		\B				-		[^\b]
	   
		*				-		Xuất hiện 0 hoặc nhiều lần, viết gọn của {0,}
	   
	   +				-		Xuất hiện 1 hoặc nhiều lần, viết gọn của {1,}
	   
	   ?				-		Xuất hiện 0 hoặc 1 lần (có hay không cũng được), viết gọn của {0,1}
	   
	   ?=				- 		Phần đầu của biểu thức phải được tiếp nối bởi biểu thức (lookahead)
	   	
	   	?!				-		Lấy kết quả mà đi sau nó không có chuỗi lookahead
	   
		{n}				-		Xuất hiện đúng n lần, với n là số
		
		{n,}			-		Xuất hiện ít nhất n lần
	   
	   {m,n}			-		Xuất hiện từ m đến n lần
	   
	   \uxxxx			-		Khớp với 1 ký tự unicode
	   
	   \pL				- 		Khớp với một ký tự unicode bất kỳ ngoại trừ dấu cách
	   
	   ()				-		Biểu diễn 1 nhóm
	 
		\				-		Biểu diễn ký tự đặc biệt: [ ] ( ) { } . * + ? ^ $ \ |

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
	
# > mvn javadoc:javadoc

# static
	- Method
		+ Phương thức static thuộc lớp chứ không thuộc đối tượng của lớp
		+ Phương thức static chỉ có thể gọi một phương thức static
		+ Phương thức static không thể sử dụng từ khóa this, super
		+ Không thể override (ghi đè) phương thức static
	- Class
		+ Chỉ khai báo được static class khi nó nằm trong 1 class khác (nested class)
		
# final
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
	là runtime exception và checked exception, runtime exception là lỗi trong lúc mình thực thi ct, còn checked exception là lỗi trong quá trình biên dịch	
	
# Abstract Class

	- Có thể có các phương thức abstract hoặc non-abstract

	- Có thể khai báo 0, 1 hoặc nhiều abstract method

	- Không thể khởi tạo trực tiếp một lớp trừu tượng

	- Lớp con bắt buộc phải cài đặt (implement) tất cả các phương thức trừu tượng của lớp cha
	
	- Access modifier mặc định của abstract methods là protected

# Interface 

	- Luôn luôn có modifier là public interface, cho dù bạn có khai báo rõ hay không
	
	- Các field đều là public static final, cho dù bạn có khai báo rõ hay không
	
	- Một interface không thể kế thừa từ lớp, nó được triển khai bởi một lớp.

	- Một interface có thể kế thừa từ nhiều interface khác.
	
	- Method đều có modifier là public abstract, cho dù bạn có khai báo hay không
	
	- Interface không có hàm khởi tạo (constructor)
	
	- Class mô tả thuộc tính và hành vi của đối tượng. Interface chứa các hành vi mà một class triển khai
