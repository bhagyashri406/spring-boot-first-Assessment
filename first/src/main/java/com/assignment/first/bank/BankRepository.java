package com.assignment.first.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface BankRepository extends CrudRepository<BankDetails , Integer> ,JpaSpecificationExecutor<BankDetails> {

	/*
	 * List<BankDetails> findAll(Specification<BankDetails> productByNameSpec);
	 * 
	 * @Query(value = "SELECT BANK_NAME, FROM BANK__DETAILS", nativeQuery = true)
	 * List<BankDetails> findAllBanksName();
	 * 
	 * @Query(value = "SELECT BANK_ADDRESS, FROM Bank_Details", nativeQuery = true)
	 * List<BankDetails> findAllBanksAddress();
	 */
}
