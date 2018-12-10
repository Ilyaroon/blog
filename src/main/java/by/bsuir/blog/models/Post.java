package by.bsuir.blog.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(generator = "post_generator")
    @SequenceGenerator(
            name = "post_generator",
            sequenceName = "post_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    public String title;

    @NotBlank
    public String text;

    @NotBlank
    public String author;

    public Post() {
    }

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
