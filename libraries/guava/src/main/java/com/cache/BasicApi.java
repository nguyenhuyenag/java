package com.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/*-
 * - put(k, v): Thêm dữ liệu vào cache
 * 
 * - get(key): Trả về giá trị tương ứng với khóa `key`. Hoặc nếu `key` không tồn
 * tại và không có lỗi trong quá trình tải dữ liệu thì: key(k) = put(k, load(k))
 * 
 * - getUnchecked(k): Tương tự get(k) nhưng sẽ bỏ qua lỗi
 * 
 * - getIfPresent(k): Trả về giá trị nếu key tồn tại, nếu không trả về null 
 * 
 * - getAll():
 * 
 * - invalidate(k): Xóa entry theo key
 * 
 * - maximumSize(n): Kích thước tối đa của cache. Khi dữ liệu thêm vào vượt quá n thì 
 * 					 sẽ dùng các cách sau đển quản lý
 * 
 * 		+ LRU (Least Recently Used): Mục cũ nhất (ít sử dụng nhất) sẽ bị loại bỏ trước.
 * 
 * 		+ LFU (Least Frequently Used): Mục ít sử dụng nhất sẽ bị loại bỏ trước.
 * 
 * 		+ FIFO (First In, First Out): Mục đầu tiên được thêm vào sẽ bị loại bỏ trước.
 * 
 * 		+ Weighted Size: Mục có trọng lượng lớn nhất (nếu bạn đã cấu hình weigher) sẽ bị loại bỏ trước
 */
public class BasicApi {

	private static LoadingCache<String, String> cache = CacheBuilder.newBuilder() //
			.maximumSize(3) //
			.build(new CacheLoader<String, String>() {
				@Override
				public String load(String key) {
					return key.toUpperCase();
				}
			});

	public static void main(String[] args) throws ExecutionException {
		String[] arr = { "first", "second", "third" };
		for (String key : arr) {
			cache.get(key);
		}
		System.out.println("Current cache: " + cache.asMap());
		System.out.println("Size: " + cache.size());
		cache.getUnchecked("forth");
		System.out.println("Current cache: " + cache.asMap());

		System.out.println("getIfPresent: " + cache.getIfPresent("first"));
		System.out.println("getIfPresent: " + cache.getIfPresent("forth"));
		
		cache.invalidate("second");
		System.out.println("Current cache: " + cache.asMap());
		
		cache.invalidateAll();
	}

}
