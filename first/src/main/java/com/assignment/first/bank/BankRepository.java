package com.assignment.first.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<BankDetails, Integer>, JpaSpecificationExecutor<BankDetails> {

}
