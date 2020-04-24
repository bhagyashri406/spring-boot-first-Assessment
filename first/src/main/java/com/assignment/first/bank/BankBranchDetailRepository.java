package com.assignment.first.bank;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchDetailRepository
		extends CrudRepository<BankBranchDetails, Integer>, JpaSpecificationExecutor<BankBranchDetails> {

}
