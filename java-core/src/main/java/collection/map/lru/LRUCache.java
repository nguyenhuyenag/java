package collection.map.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
    - LinkedHashMap: Lưu trữ các entry theo thứ tự chèn (insertion order) hoặc thứ tự truy cập (access order). Với accessOrder = true, mỗi lần get() hoặc put() một key, entry đó sẽ được di chuyển xuống cuối danh sách. Điều này cho phép ta dễ dàng xác định phần tử ít được sử dụng gần đây nhất (LRU) — chính là entry ở đầu danh sách.

    Ngoài ra, LinkedHashMap cung cấp method removeEldestEntry() để ta override, tự động xóa entry cũ nhất khi vượt quá capacity
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        // initialCapacity, loadFactor, accessOrder = true
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Trả về true khi size vượt quá capacity => xóa entry LRU (đầu danh sách)
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache); // {1=A, 2=B, 3=C}

        cache.get(1);              // truy cập key 1 => thành MRU
        cache.put(4, "D");         // vượt capacity => xóa LRU (key 2)

        System.out.println(cache); // {3=C, 1=A, 4=D}
    }

}
