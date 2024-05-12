package ProjectDemo.demo.reponsitory;

import ProjectDemo.demo.entity.Profile;

import ProjectDemo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProfileReponsitory extends JpaRepository<Profile,Integer> {
    Profile findProfileByUser(User user);
    Profile findProfileById(int id);
}
