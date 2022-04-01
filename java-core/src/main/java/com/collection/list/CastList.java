package com.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

/**
 * Một số hàm trả về `List` không có kiểu dữ liệu (ví dụ javax.xml.crypto.dsig.keyinfo.KeyInfo.getContent())
 */
public class CastList {
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		KeyInfo keyInfo = null;
		List<XMLStructure> entries = castList(XMLStructure.class, keyInfo.getContent());
		System.out.println(entries.size());
		// hoặc
		// Collections.checkedList(keyInfo.getContent(), XMLStructure.class);
	}
	
}
