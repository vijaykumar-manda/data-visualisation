package com.data_dashboard.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.data_dashboard.Modal.EntityModal;
import com.data_dashboard.Repository.EntityRepository;

@Service
public class DataService {
    private final EntityRepository entityRepository;

    public DataService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }
   
    public List<EntityModal> getData(){
    	return entityRepository.findAll();
    	
    }

    public List<EntityModal> getIntensityData(int intensity) {
        System.out.println("Fetching data for intensity: " + intensity);
        List<EntityModal> data = entityRepository.findByIntensity(intensity);
        System.out.println("Fetched " + data.size() + " records.");
        return data;
    }

    public List<Object[]> getIntensityCount() {
        return entityRepository.countByIntensity();
    }

	public List<Object[]> getLikelihoodCount() {
		// TODO Auto-generated method stub
		return entityRepository.countByLikelihood();
	}
}
