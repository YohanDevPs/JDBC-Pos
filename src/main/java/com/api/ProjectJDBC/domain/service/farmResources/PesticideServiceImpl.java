package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.dao.PesticideDao;
import com.api.ProjectJDBC.domain.entities.resources.Pesticide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesticideServiceImpl implements PesticideService{


    @Autowired
    private PesticideDao pesticideDao;

    @Override
    public void save(Pesticide pesticide) {
        pesticideDao.save(pesticide);
    }

    @Override
    public Pesticide getById(long id) {
        return pesticideDao.getById(id);
    }

    @Override
    public List<Pesticide> getAll() {
        return pesticideDao.getAll();
    }

    @Override
    public void remove(long id) {
        pesticideDao.remove(id);
    }

    @Override
    public void update(Pesticide pesticide) {
        pesticideDao.update(pesticide);
    }
}
