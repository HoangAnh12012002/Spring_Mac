package ProjectDemo.demo.reponsitory;

import ProjectDemo.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserReponsitory extends JpaRepository<User,Integer> {

    @Query("SELECT a FROM User a WHERE a.Views = :views")
    List<User> searchAllUser2(@Param("views") int views);

    User getUserByEmail(String email);

    Optional<User> findByEmail(String email);
   // User findByEmail(String email);

   /* Optional<User> findByEmail(String email);*/
//    Boolean checkUserbyEmail(String email);

/*    @Query(
            value = "select * from user u where u.views=150 AND u.topic_counts=9",
            nativeQuery = true)
    List<User> getAllUser1();*/
//nếu fix cứng thì có thể dùng query dạng như trên, nhớ thêm nativeQuery=true
    @Query(
            value = "select * from User",
            nativeQuery = true)
    List<User> getAllUser();

    User findById(int ID);
    @Query("SELECT p FROM User p WHERE " +
            "p.UserDisplayName LIKE CONCAT('%',:query, '%')" +
            "Or p.email LIKE CONCAT('%', :query, '%')")
    List<User> searchUserByName(String query);

    // @Query("SELECT u FROM User u WHERE u.Role = :query")
    @Query("SELECT u FROM User u WHERE u.Role = :query")
    List<User> filterByRole( String query);
    @Transactional
    @Modifying
    @Query("update User u set u.Password = ?2 where u.email = ?1")
    void updatePassword(String email, String password);


}
