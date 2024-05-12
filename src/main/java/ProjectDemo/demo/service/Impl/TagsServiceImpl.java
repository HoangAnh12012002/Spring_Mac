package ProjectDemo.demo.service.Impl;


import ProjectDemo.demo.entity.Tags;
import ProjectDemo.demo.reponsitory.TagsReponsitory;
import ProjectDemo.demo.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagsReponsitory tagsReponsitory;
    @Override
    public List<Tags> getListTag() {
        return tagsReponsitory.findAll();
    }
}
