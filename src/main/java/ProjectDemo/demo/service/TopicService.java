package ProjectDemo.demo.service;


import ProjectDemo.demo.dto.CommentDto;
import ProjectDemo.demo.dto.TopicDto;
import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    void save(TopicDto topicDto, User user);
    Topic findTopicById(Integer id);
    void delete(Integer id);
    void update(Topic topic);

    List<Topic> SearchTopic(String keyword);
}
