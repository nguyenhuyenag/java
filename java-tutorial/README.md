# Regular Expression
	
	Biểu thức					Mô tả (khớp với 1 ký tự)
	
		.				-		Ký tự bất kỳ
		
		^a				-		Bắt đầu bởi ký tự a
	   
		a$				-		Kết thúc bởi ký tự a
	   
	   [abc]			-		Là a hoặc b hoặc c
	   
	   [^abc]			-		Trừ a hoặc b hoặc c. Dấu ^ (dấu mũ) nằm trong dấu
	   							ngoặc vuông là một dấu phủ định
	   
	   [a-d]			-		Khớp với chuỗi giữa a và d
	   
	   8.	X|Z				-	Tìm X hoặc Z
	   
	   9.	XZ				- 	Tìm X, theo sau là Z
	   
	   10.	$				- 	Kiểm tra kết thúc dòng
	   
	   11.	\d				-	Số bất kỳ, viết ngắn gọn của [0-9]
	   
	   12.	\D				-	Ký tự không phải là số, viết gọn của [^0-9]
	   
	   13.	\s				-	Ký tự khoảng trắng, viết gọn của [ \t\n\x0b\r\f]
	   
	   14.	\S				-	Ký tự không phải khoản trắng, viết gọn của [^\s]
	   
	   15.	\w				-	Ký tự chữ, viết gọn của [a-zA-Z_0-9]
	   
	   16.	\W				-	Ký tự không phải chữ, viết gọn của [^\w]
	   
	   17.	\S+				-	Một số ký tự không phải khoảng trắng (một hoặc nhiều)
	   
	   18.	\b				-	Ký tự thuộc a-z hoặc A-Z hoặc 0-9 hoặc _, viết gọn của [a-zA-Z0-9_].
	   
	   19. *	 			-	Xuất hiện 0 hoặc nhiều lần, viết ngắn gọn cho {0,}
	   
	   20.	+				-	Xuất hiện 1 hoặc nhiều lần, viết ngắn gọn cho {1,}
	   
	   21.	?				-	Xuất hiện 0 hoặc 1 lần, ? viết ngắn gọn cho {0,1}
	   
	   22.	{X}				-	Xuất hiện X lần, {}
	   
	   23.	{X,Y}			-	Xuất hiện trong khoảng X tới Y lần
	   
	   24.	 ?				-	Xuất hiện 0 hoặc nhiều lần, thêm ? phía sau nghĩa là tìm kiếm khớp nhỏ nhất
	   
	   25.	()				-	Xác định 1 group (biểu thức con) xem như nó là một yếu tố đơn lẻ trong pattern, ví
								dụ ((a(b))c) sẽ khớp với b, ab, abc
								
	5.	[abc][xy]	-		Khớp a hoặc b hoặc c, theo sau là x hay y
	   
	   26.	\.[{( +?^$|		-	Ký tự đặc biệt	=> \
	 

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
	
	
	
	
	
	
	
	
	
	
	
	