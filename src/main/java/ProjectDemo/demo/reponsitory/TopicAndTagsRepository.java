package ProjectDemo.demo.reponsitory;

import ProjectDemo.demo.entity.relationship.TopicAndTags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TopicAndTagsRepository extends JpaRepository<TopicAndTags,Integer> {
}
