package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Blog {

	private String authorName;
	private List<String> comments = new ArrayList<>();

	public Blog(String authorName, String... comments) {
		this.authorName = authorName;
		for (String cm : comments) {
			this.comments.add(cm);
		}
	}

}

public class FlatMapping {

	public static void main(String[] args) {
		Blog blog1 = new Blog("1", "Nice", "Very Nice");
		Blog blog2 = new Blog("2", "Disappointing", "Ok", "Could be better");
		List<Blog> blogs = List.of(blog1, blog2);
		// System.out.println(blogs);
		Map<String, List<List<String>>> authorComments1 = blogs.stream().collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.mapping(Blog::getComments, Collectors.toList())));
		System.out.println(authorComments1);
		
		Map<String, List<String>> authorComments2 = blogs.stream()
			      .collect(Collectors.groupingBy(Blog::getAuthorName, 
			        Collectors.flatMapping(blog -> blog.getComments().stream(), 
			        Collectors.toList())));
		
		System.out.println(authorComments2);
	}

}
