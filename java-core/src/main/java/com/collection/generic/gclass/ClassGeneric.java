package com.collection.generic.gclass;

class KeyValuePair<K, V> {
	private K key;
	private V value;

	public KeyValuePair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

public class ClassGeneric {

	public static void main(String[] args) {
		KeyValuePair<String, Integer> g = new KeyValuePair<>("Java", 8);
		System.out.println("Name = " + g.getKey() + ", Id = " + g.getValue());
	}

}
