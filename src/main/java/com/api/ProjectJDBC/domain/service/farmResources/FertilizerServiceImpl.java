package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.dao.FertilizerDao;
import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerServiceImpl implements FertilizerService{

    @Autowired
    private FertilizerDao fertilizerDao;

    @Override
    public void save(Fertilizer fertilizer) {
        fertilizerDao.save(fertilizer);
    }

    @Override
    public Fertilizer getById(long id) {
        return fertilizerDao.getById(id);
    }

    @Override
    public List<Fertilizer> getAll() {
        return fertilizerDao.getAll();
    }

    @Override
    public void remove(long id) {
        fertilizerDao.remove(id);
    }

    @Override
    public void update(Fertilizer fertilizer) {
        fertilizerDao.update(fertilizer);
    }
}
