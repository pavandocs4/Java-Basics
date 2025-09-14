package com.example.java.advance.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;


public class GroupingByComplexEx {
	public static void main(String[] args) {
		List<BlogPost> blogList= getBlogList();
		
		//Simple Grouping by a Single Column
		System.out.println("***************Simple Grouping by a Single Column***************");
		blogList.stream().collect(Collectors.groupingBy(BlogPost::getTitle))
		.forEach((a, b) -> System.out.println("title:"+a+" blogs:"+b));
		
		//groupingBy with a Complex Map Key Type
		System.out.println("***************groupingBy with a Complex Map Key Type***************");
		Map<Object, List<BlogPost>> postsPerTypeAndAuthor = blogList.stream()
				  .collect(Collectors.groupingBy(post -> new ImmutablePair<>(post.getType(), post.getAuthor())));
		System.out.println(postsPerTypeAndAuthor);
		
		// multilevel grouping -> here we can use group by at different levels
		System.out.println("***************groupingBy with a Complex Map Key Type with multilevel***************");
		Map<BlogPostType, Map<String, List<BlogPost>>> postsPerTypeAndAuthorNew = blogList.stream()
				  .collect(Collectors.groupingBy(BlogPost::getType,
						  Collectors.groupingBy(BlogPost::getAuthor)));
		System.out.println(postsPerTypeAndAuthorNew);
		
		/*
		 * Java 16 has introduced the concept of a record as a new form of generating
		 * immutable Java classes.  The record feature provides us with a simpler, clearer, and safer way to do
		 * groupingBy for multiple fields. Ex if we need to group by all author, type, and name
		 */
		
		System.out.println("***************groupingBy with a Complex Map Key Type with record***************");
		
	}

	static List<BlogPost> getBlogList() {
		return Arrays.asList(new BlogPost("env", "pavan", BlogPostType.NEWS, 10),
				new BlogPost("pilitics", "rahul", BlogPostType.NEWS, 100),
				new BlogPost("tourism", "ajay", BlogPostType.NEWS, 110),
				new BlogPost("education", "ajay", BlogPostType.GUIDE, 11),
				new BlogPost("tourism", "prayan", BlogPostType.GUIDE, 20),
				new BlogPost("pilitics", "kavya", BlogPostType.REVIEW, 100),
				new BlogPost("education", "Savita", BlogPostType.NEWS, 110),
				new BlogPost("tourism", "Ritesh", BlogPostType.GUIDE, 11),
				new BlogPost("tourism", "Deven", BlogPostType.GUIDE, 20),
				new BlogPost("pilitics", "hina", BlogPostType.NEWS, 21),
				new BlogPost("education", "pritam", BlogPostType.NEWS, 25),
				new BlogPost("tourism", "ajay", BlogPostType.GUIDE, 65),
				new BlogPost("tourism", "lavanya", BlogPostType.GUIDE, 80),
				new BlogPost("pilitics", "kiran", BlogPostType.REVIEW, 54),
				new BlogPost("tourism", "Satish", BlogPostType.GUIDE, 77),
				new BlogPost("tourism", "Satish", BlogPostType.GUIDE, 87),
				new BlogPost("tourism", "Rambo", BlogPostType.GUIDE, 98));
	}

}

class BlogPost {

	public BlogPost(String title, String author, BlogPostType type, int likes) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.likes = likes;
	}

	private String title;
	private String author;
	private BlogPostType type;
	private int likes;

	public record AuthPostTypesLikes(String author, BlogPostType type, int likes) {

		};
		public void AuthPostTypesLikes(BlogPostType type2, String author2, int likes2) {
			// TODO Auto-generated constructor stub
		}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BlogPostType getType() {
		return type;
	}

	public void setType(BlogPostType type) {
		this.type = type;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "BlogPost [title=" + title + ", author=" + author + ", type=" + type + ", likes=" + likes + "]";
	};

	// constructor, getters/setters
}

enum BlogPostType {
	NEWS, REVIEW, GUIDE
}

class Tuple {
	public Tuple(BlogPostType type, String author) {
		// TODO Auto-generated constructor stub
		this.type= type;
		this.author=author;
	}
	BlogPostType type;
	String author;
	
	@Override
	public String toString() {
		return "Tuple [type=" + type + ", author=" + author + "]";
	}
	
}
