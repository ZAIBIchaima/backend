package com.backends.stock.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.DetailsOperation;



@Repository
public interface DetailsOperationRepository extends JpaRepository<DetailsOperation, Long> {
Iterable<DetailsOperation> findAllById(long id);
	
	@Modifying
    @Transactional
    @Query("delete from DetailsOperation e where id = ?1")
    void deleteById(long id);
}
