package ProjectDemo.demo.reponsitory;

import ProjectDemo.demo.entity.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TopicReponsitory extends JpaRepository<Topic,Integer> {
    @Query("SELECT t FROM Topic t WHERE t.title LIKE %?1%")
    List<Topic> SearchTopic(String keyword);
    List<Topic> getAllById(Integer id);
    Topic findTopicById(Integer id);
    void deleteById(Integer id);
    Integer countTopicByUser_ID(Integer userId);


}
