package ProjectDemo.demo.service.Impl;


import ProjectDemo.demo.dto.CommentDto;
import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.CommentReponsitory;
import ProjectDemo.demo.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional //thêm cái này để tránh lỗi
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentReponsitory commentReponsitory;

    @Override
    public void save(CommentDto commentDto, User user, Topic topic) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        Comment comment=new Comment(
                commentDto.getBody(),
                creationDate,
                user,
                topic
        );
        commentReponsitory.save(comment);
    }

    @Override
    public int countComment(Topic topic) {
        return commentReponsitory.countCommentByTopic_Id(topic.getId());
    }

    @Override
    public void delete(Integer topicId) {
        commentReponsitory.removeAllByTopic_Id(topicId);
    }

    @Override
    public Comment findCommentbyId(Integer id) {
        return commentReponsitory.getCommentById(id);
    }
}
