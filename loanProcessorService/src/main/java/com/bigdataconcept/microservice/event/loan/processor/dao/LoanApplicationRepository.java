package com.bigdataconcept.microservice.event.loan.processor.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigdataconcept.microservice.event.loan.processor.model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication, String>{

}
