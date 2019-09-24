package learn.collection.generic.gclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class KeyValuePair<K, V> {
	private K key;
	private V value;
}

public class ClassGeneric {

	public static void main(String[] args) {
		KeyValuePair<String, Integer> g = new KeyValuePair<>("Java", 8);
		System.out.println("Name = " + g.getKey() + ", Id = " + g.getValue());
	}

}
