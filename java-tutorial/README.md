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
	