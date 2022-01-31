package com.adoptdontshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptdontshop.domain.model.Demand;

public interface DemandRepository extends JpaRepository<Demand,Long>{

}
