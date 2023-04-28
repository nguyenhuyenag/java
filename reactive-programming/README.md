# Reactive Programming

	- Là mô hình lập trình mà ở đó bất kỳ sự thay đổi nào trên đối tượng có các đối tượng khác tham chiếu tới thì các đối tượng tham chiếu tới đó đều nhận biết sự thay đổi của đối tượng đó
	
	- Các khái niệm
	
		+ Publisher	 -> là đối tượng sẽ có sự thay đổi giá trị (Observable)
		+ Subscriber -> là những đối tượng sẽ nhận sự thay đổi từ các đối tượng Publisher
			- onNext : Được gọi khi emit data, nó có thể được gọi một hoặc nhiều lần.
			- onCompleted: Được gọi khi stream đã emit data hoàn tất, đánh dấu trạng thái kết thúc của luồng
			- onError: Được gọi khi có bất kỳ lỗi nào xảy ra. Khi nó được gọi thì onComplete sẽ không được gọi nữa.
		+ Subscribe  -> là phần kết nối giữa Publisher và Subscriber