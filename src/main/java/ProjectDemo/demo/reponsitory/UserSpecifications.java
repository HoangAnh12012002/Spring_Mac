//package ProjectDemo.demo.reponsitory;
//
//import ProjectDemo.demo.entity.User;
//import org.springframework.data.jpa.domain.Specification;
//
//public class UserSpecifications {
//    public static Specification<User> activeUsers() {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("views"),150);
//    }
//
//    public static Specification<User> emailEndsWithExample() {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%4@example.com");
//    }
//}
