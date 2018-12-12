package by.bsuir.blog.models;

import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(generator = "posts_id_seq")
    @SequenceGenerator(
            name = "posts_id_seq",
            sequenceName = "posts_id_seq",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    public String title;

    @NotBlank
    public String subtitle;

    @NotBlank
    @Column(length = 10000)
    public String text;

    @NotBlank
    public String author;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

     public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public String getDate() {
        Format formatter = new SimpleDateFormat("MMMM d, yyyy");
        return formatter.format(createdAt);
    }
}
