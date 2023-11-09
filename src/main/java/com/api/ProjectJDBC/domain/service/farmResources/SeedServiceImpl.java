package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.dao.SeedDao;
import com.api.ProjectJDBC.domain.entities.resources.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServiceImpl implements SeedService{

    @Autowired
    private SeedDao seedDao;

    @Override
    public void save(Seed seed) {
        seedDao.save(seed);
    }

    @Override
    public Seed getById(long id) {
        return seedDao.getById(id);
    }

    @Override
    public List<Seed> getAll() {
        return seedDao.getAll();
    }

    @Override
    public void remove(long id) {
        seedDao.remove(id);
    }

    @Override
    public void update(Seed seed) {
        seedDao.update(seed);
    }
}
