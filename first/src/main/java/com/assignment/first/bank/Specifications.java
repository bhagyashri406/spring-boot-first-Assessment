package com.assignment.first.bank;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public class Specifications {

	 public static Specification<BankDetails> getBankBySpec(String namekey ,String name) {
	      return new Specification<BankDetails>() {
	          @Override
	          public javax.persistence.criteria.Predicate toPredicate(Root<BankDetails> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get(namekey), name);
	              return equalPredicate;
	          }
	      };
	  }

	
}
