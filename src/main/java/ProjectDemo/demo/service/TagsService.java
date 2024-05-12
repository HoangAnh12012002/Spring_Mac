package ProjectDemo.demo.service;


import ProjectDemo.demo.dto.CommentDto;
import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Tags;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagsService {
    List<Tags> getListTag();
}
