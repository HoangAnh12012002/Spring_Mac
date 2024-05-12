package ProjectDemo.demo.entity.relationship;

import ProjectDemo.demo.entity.Tags;
import ProjectDemo.demo.entity.Topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "topic_and_tags")
public class TopicAndTags implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tags tags;
}
