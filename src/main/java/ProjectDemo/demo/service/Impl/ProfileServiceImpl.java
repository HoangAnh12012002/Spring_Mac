package ProjectDemo.demo.service.Impl;

import ProjectDemo.demo.entity.Profile;
import ProjectDemo.demo.reponsitory.ProfileReponsitory;
import ProjectDemo.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileReponsitory profileReponsitory;

    @Override
    public void update(Profile profile) {
        profileReponsitory.save(profile);
    }
}
