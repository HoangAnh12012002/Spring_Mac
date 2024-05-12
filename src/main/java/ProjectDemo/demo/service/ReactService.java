package ProjectDemo.demo.service;

import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface ReactService {
    void saveReactTopic(String namereact, Topic topic, User user);
    void saveReactComment(String namereact, Comment comment, User user);
    int countReact(Topic topic);
    int countReactComment(Comment comment);
    void delete(Integer topicId);

}
