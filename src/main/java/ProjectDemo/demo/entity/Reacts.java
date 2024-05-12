package ProjectDemo.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reacts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String Name;

    @ManyToOne
    @JoinColumn(name= "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name ="topic_id",nullable = true)
    private  Topic topic;

    @ManyToOne
    @JoinColumn(name="comment_id",nullable = true)
    private  Comment comment;

    public Reacts(String name, User user, Topic topic, Comment comment) {
        Name = name;
        this.user = user;
        this.topic = topic;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
