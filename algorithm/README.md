# Quay lui

	- Thường dùng trong các bài toán liệt kê dạng X[1...n]
	
	1) Xét tất cả các giá trị X[1] có thể nhận, thử X[1] nhận các giá trị đó. Với mỗi giá trị của X[1] ta sẽ
	
	2) Xét tất cả các giá trị X[2] có thể nhận, thử X[2] nhận các giá trị đó. Với mỗi giá trị của X[2] ta sẽ

	3) Xét tất cả các giá trị X[3] có thể nhận, ...
	
	...
	
	n) Xét tất cả các giá trị X[n] có thể nhận, thử X[n] nhận các giá trị đó. Thông báo cấu hình tìm được.
	
	void backtrack(int i) { 				// Xác định x_i
		for (j = 1; j < nj; j++) { 		// Xét tất cả các khả năng của x_i
			if (chấp nhận khả năng j) { 	// Nếu chấp nhận khả năng j
				Ghi nhận việc đã chọn j 	// Có thể không có (*)
				Xác định x[i] theo j;
				if (i == n) {
					// Đã xác định đủ n thành phần và ghi nhận 1 cấu hình
				} else {
					backtrack(i + 1); 		// Xác định x_i + 1 bằng các gọi đệ quy
				}
				Ghi nhận việc bỏ chọn j 	// Lệnh này có thể không có nếu lệnh (*) không có
			}
		}
	}
