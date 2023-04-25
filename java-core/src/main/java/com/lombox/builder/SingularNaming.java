package com.lombox.builder;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
class Sea {

	@Singular("oneFish") // Bỏ oneFish và chạy để show lỗi
	private List<String> fish;

}

/**
 * Can't singularize this name; please specify the singular explicitly
 * (i.e. @Singular("sheep")): xuất hiện khi tên của một thuộc tính không thể
 * được đưa về dạng số ít bằng cách bỏ đi một số ký tự cuối cùng (ví dụ, trong
 * trường hợp tên thuộc tính đã có dạng số ít)
 */
public class SingularNaming {

	public static void main(String[] args) {

	}

}
