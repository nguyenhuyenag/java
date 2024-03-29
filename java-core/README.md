# Java version

	JDK		Maven	Major 
	 7	 	 1.7	 51
	 8  	 1.8	 52
	 9	  	 9		 53
	 10  	 10		 54
	 11  	 11		 55
	 12  	 12		 56
	 13  	 13		 57
	 14  	 14		 58
	 15  	 15		 59
	 16  	 16		 60
	 17  	 17		 61
	 18		 18		 62

    
    Từ Java 9 trở đi, Oracle đã thay đổi cách phân phối và ký hiệu phiên bản Java. Thay vì sử dụng ký hiệu "1.x" như trước đây, các phiên bản sau Java 8 sẽ được đánh số theo kiểu "x". Ví dụ: Java 9 được ký hiệu là 9
    
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
	
	- Không thể overload các hàm trong một lớp

# Static

	- Method
	
		+ Phương thức static thuộc lớp chứ không thuộc đối tượng của lớp
		
		+ Phương thức static chỉ có thể gọi một phương thức static
		
		+ Phương thức static không thể sử dụng từ khóa this, super
		
		+ Không thể override (ghi đè) phương thức static
		
	- Class
		
		+ Chỉ khai báo được static class khi nó nằm trong 1 class khác (nested class)
	
	- Với Java < 7 có thể thực thi chương trình mà không cần phương thức main()

# Super

	- Gọi constructor của class cha.
	- Truy cập đến các biến instance của class cha khi class cha và class con có các biến instance giống tên nhau. 
	- Truy cập method của class cha khi class con đã ghi đè phương thức của class cha.

# This (đối tượng hiện tại của class)

	- Không thể dùng this hay super() trong phương thức static do phương thức static không gắn với đối tượng, nên không có this.
    - This là từ khóa do đó không thể gán `this = giá_trị_nào_đó`
		
# Final

	- Một constructor không thể khai báo với từ khoá final
	- Tất cả các biến được khai báo bên trong interface được mặc định là final
	- Biến final khi khai báo không gán giá trị thì phải được gán trong constructor hoặc static block
	
			final int MAX_VALUE;
		    public Demo() {
		        MAX_VALUE = 99;
		    }

	- Method

		+ Phương thức final có thể KẾ THỪA nhưng không thể ghi đè (override)

	- Class

		+ Không thể kế thừa class final

# Map

    + TreeMap

	    - TreeMap KHÔNG cho phép bất kỳ key nào là null và nhưng có thể có nhiều giá trị null
	    - TreeMap tự động sắp xếp các phần tăng dần theo key 
	
    + LinkedHashMap

	    - LinkedHashMap có thể có 1 key là null và nhiều giá trị null
	    - LinkedHashMap duy trì các phần tử theo thứ tự chèn
    
    + HashMap & Hashtable

        - Hashtable không cho phép chứa key-value null, còn HashMap thì có 
        - Hashtable là thread-safe, còn HashMap thì không (phải dùng ConcurrentHashMap)
	
# Exception

	- Có 2 loại là: Checked Exception và Runtime Exception (Unchecked Exception)
	
	- Checked exception là lỗi trong quá trình biên dịch

		+ FileNotFoundException,...
	
	- Runtime exception là lỗi trong lúc mình thực thi chương trình. Đa phần xảy ra lỗi do dữ liệu không hợp lệ trong quá trình tương tác với chương trình

		+ ArrayIndexOutOfBoundsException, lỗi chia cho 0,...

	- Oracle: Nếu một exception xảy ra mà người dùng có thể khắc phục được thì sử dụng checked exception, còn nếu không thể thì sử dụng unchecked exception
	
# Throw vs Throws

		Throw										Throws
	- Ném một exception cụ thể					- Khai báo các exception của một method
	- Checked exception không được ném ra 		- Ném ra checked exception ngay cả khi chỉ sử dụng throws
	  nếu chỉ sử dụng throw
	- Không thể throw nhiều exception			- Có thể throw nhiều exception (dùng dấu phẩy)
	- Throw được dùng bên trong method 		- Throws được dùng chung với phần khai báo của method
	- Sau throw là một new instance			- Sau throws là một hoặc nhiều class
	
	=> Tóm lại, "throw" được sử dụng để tạo và ném ngoại lệ, trong khi "throws" được sử dụng để khai báo rằng một phương thức có thể ném ra một hoặc nhiều loại ngoại lệ và truyền trách nhiệm xử lý ngoại lệ cho phương thức gọi.
	
		throws FileNotFoundException;
		throw new IllegalArgumentException("IllegalArgumentException Exception");

# For loop vs Iterator

	- Iterator có khả năng thêm/xoá những phần từ tập hợp trong quá trình duyệt.
	
	- Sử dụng for-each bạn không thể làm được điều này, sẽ phát sinh lỗi ConcurrentModificationException.
	
	- Sử dụng for-index có thể thêm/xóa được, nhưng có thể sẽ gặp lỗi khác là IndexOutOfBoundsException.
	
# Overloading (nạp chồng) & Overriding (ghi đè)

	- Nạp chồng phương thức là ví dụ về đa hình lúc biên dịch.
	
	- Ghi đè phương thức là ví dụ về đa hình lúc runtime.

# Comparator.compare(T1, T2) và Comparable.compareTo(T)

	- compare() is from the Comparator interface, so it is used to compare two different instances of another class with each other.

	- compareTo() is from the Comparable interface, so it is used to compare THIS instance to another one.

# Method parameter

	- Một method có thể nhận tối đa 255 tham số, tuy nhiên mặc định chứa một tham số this nên chính xác sẽ còn 254.

# Kiểu tham chiếu và tham chiếu (pass by value & pass by reference)

    - Tham trị
        + Kiểu thường dùng cho các kiểu nguyên thủy: int, long, byte, char,...
        + Khi truyền biến vào method thì sẽ method sẽ chỉ nhận giá trị không nhận địa chỉ biến
          (copy giá trị vào ô nhớ khác), do đó mọi thay đổi bên trong sẽ không ảnh hưởng đến biến ở bên ngoài.
    
    - Tham chiếu
        + Trong Java các biến của kiểu class (đối tượng) đều là tham chiếu
        + Khi truyền biến vào method tức là truyền địa chỉ ô nhớ vào method, do đó mọi thay đổi bên trong đều sẽ
          ảnh hướng đến biến ở bên ngoài

				public void newName(User u1) {
					u1.setName("Java_2024");
				}
			
				User u = new User("Java");
				newName(u);
				u.getName() -> "Java_2024"
        
        - Kiểu mảng int[], char[] cũng là tham chiếu (ví dụ int[] arr = new int[5] thì biến arr sẽ là 
          một tham chiếu (hoặc con trỏ) đến mảng đó trong bộ nhớ, không phải là một bản sao của mảng) 
	
# Stack & Heap

	- Các biến nguyên thủy được lưu trực tiếp trong stack
	
	- Các biến của Object sau khi khởi tạo sẽ được lưu trong heap
	
	- Stack
	
		+ Dùng để cấp phát vùng nhớ tĩnh: Các tham số của method, biến local, biến tham chiếu đến các object
		+ Hoạt động theo cơ chế LIFO
		+ Tự giải phóng vùng nhớ method thực hiện xong
		+ Các biến local bên trong Stack chỉ tồn tại khi method còn đang chạy. 
		+ Nếu stack memory đầy Java sẽ quăng ra StackOverFlowError.
		+ Truy cập Stack memory sẽ nhanh hơn so với Heap.
		+ Dùng để thực thi luồng (mỗi thread trong java đều có riêng một Stack memory của nó)
		
	- Heap
	
		Heap memory được chia thành các phần nhỏ hơn:

		- Young Generation: Là nơi tất cả các object được khởi tạo cho đến khi không còn được một tham chiếu đến nó thì sẽ được trình dọn rác thu gom.
		- Old (Tenured) Generation: Là nơi lưu trữ các object có vòng đời dài. Khi một object được khởi tạo và được đặt ở Young Generation chúng sẽ được đặt một ngưỡng cho thời gian sống, nếu vượt qua ngưỡng này thì chúng sẽ được đưa vào Old Generation.
		- Permanent Generation: Đây là nơi lưu trữ các metadata cho runtime class và application method.
		
		+ Dùng để cấp phát vùng nhớ động cho các object được khởi tạo tại thời điểm runtime
		+ Nó được truy cập thông qua các cơ chế quản lý phức tạp bao gồm các phần Young, Old, Permanent Generation.
		+ Nếu Heap space đầy thì java sẽ quăng lỗi OutOfMemoryError.
		+ Truy cập dữ liệu trong vùng nhớ Heap sẽ lâu hơn so với Stack.
		+ Heap không tự giải phóng vùng nhớ mà phải nhờ sự can thiệp của trình dọn rác java.
		+ Heap là một vùng nhớ chung cho toàn bộ Thread và chúng ta cần bảo vệ dữ liệu bằng cách đồng bộ hoá. 
	