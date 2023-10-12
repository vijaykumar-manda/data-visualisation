package com.data_dashboard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.data_dashboard.Modal.EntityModal;

@Repository
public interface EntityRepository extends JpaRepository<EntityModal, Long> {
	List<EntityModal> findAll();

	List<EntityModal> findByIntensity(int intensity);

	@Query("SELECT d.intensity, COUNT(d) FROM EntityModal d GROUP BY d.intensity ORDER BY d.intensity ASC")
    List<Object[]> countByIntensity();
    @Query("SELECT d.likelihood, COUNT(d) FROM EntityModal d GROUP BY d.likelihood ORDER BY d.likelihood")
	List<Object[]> countByLikelihood();

}
