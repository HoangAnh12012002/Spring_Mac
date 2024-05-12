package ProjectDemo.demo.service;


import ProjectDemo.demo.dto.CommentDto;
import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public interface CommentService {
    void save(CommentDto commentDto, User user, Topic topic);
    int countComment(Topic topic);
    Comment findCommentbyId(Integer id);
    void delete(Integer topicId);

}
