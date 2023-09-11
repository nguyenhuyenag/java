package com.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/*-
 * - put(k, v): Thêm dữ liệu vào cache
 * 
 * - get(key): Trả về giá trị tương ứng với khóa `key`. Hoặc nếu `key` không tồn
 * 			   tại và không có lỗi trong quá trình tải dữ liệu thì: key(k) = put(k, load(k))
 * 
 * - getUnchecked(k): Tương tự get(k) nhưng sẽ bỏ qua lỗi
 * 
 * - getIfPresent(k): Trả về giá trị nếu key tồn tại, nếu không trả về `null` 
 * 
 * - getAll():
 * 
 * - invalidate(k): Xóa entry theo key
 * 
 * - invalidateAll(k): Xóa toàn bộ cache
 * 
 * - maximumSize(n): Kích thước tối đa của cache. Khi dữ liệu thêm vào vượt quá n thì 
 * 					 sẽ dùng các cách sau đển quản lý
 * 
 * 		+ LRU (Least Recently Used): Mục cũ nhất (ít sử dụng nhất) sẽ bị loại bỏ trước
 * 
 * 		+ LFU (Least Frequently Used): Mục ít sử dụng nhất sẽ bị loại bỏ trước
 * 
 * 		+ FIFO (First In, First Out): Mục đầu tiên được thêm vào sẽ bị loại bỏ trước
 * 
 * 		+ Weighted Size: Mục có trọng lượng lớn nhất (nếu bạn đã cấu hình weigher) sẽ bị loại bỏ trước
 * 
 * - Cache là đồng bộ (synchronized), các hoạt động truy cập cache (read/write) được bảo vệ bằng khóa (lock) 
 *   để đảm bảo tính nhất quán trong môi trường đa luồng
 */
public class BasicApi {

	/**
	 * Hàm load cơ bản
	 */
	public static CacheLoader<String, String> basicLoader() {
		return new CacheLoader<String, String>() {
			@Override
			public String load(String key) {
				return key.toUpperCase();
			}
		};
	}

	/**
	 * Hàm load sử dụng lambda
	 */
	public static CacheLoader<String, String> basic2Loader() {
		return CacheLoader.from((String k) -> k.toString());
	}

	private static LoadingCache<String, String> cache = CacheBuilder.newBuilder() //
			.maximumSize(3) //
			// .build(basicLoader());
			.build(basic2Loader());

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
		System.out.println("Current cache: " + cache.asMap());
	}

}
