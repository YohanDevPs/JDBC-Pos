package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.dao.ResourceDao;
import com.api.ProjectJDBC.domain.entities.resources.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public void save(Resource resource) {
        resourceDao.save(resource);
    }

    @Override
    public Resource getById(long id) {
        return resourceDao.getById(id);
    }

    @Override
    public List<Resource> getAll() {
        return resourceDao.getAll();
    }

    @Override
    public void remove(long id) {
        resourceDao.remove(id);
    }

    @Override
    public void update(Resource resource) {
        resourceDao.update(resource);
    }
}
