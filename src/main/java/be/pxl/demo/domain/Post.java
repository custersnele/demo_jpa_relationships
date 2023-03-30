package be.pxl.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@OneToMany(mappedBy = "post")
	private List<PostComment> commentList;

	public Post() {
		// JPA only
	}

	public Post(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<PostComment> getCommentList() {
		return commentList;
	}
}
