package collection.iterable;

import java.util.stream.StreamSupport;

public class IterableSize {

	public long size1(Iterable<String> data) {
		return data.spliterator().getExactSizeIfKnown();
	}

	public long size(Iterable<String> data) {
		return StreamSupport.stream(data.spliterator(), false).count();
	}

}
