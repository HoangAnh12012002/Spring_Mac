package ProjectDemo.demo.service;

import ProjectDemo.demo.entity.Profile;

import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    void update(Profile profile);
}
