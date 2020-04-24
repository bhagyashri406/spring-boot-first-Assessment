package com.assignment.first.bank;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class Specifications {

	public static Specification<BankBranchDetails> getBranchListByLocation(String locationkey, String location) {
		return new Specification<BankBranchDetails>() {
			@Override
			public javax.persistence.criteria.Predicate toPredicate(Root<BankBranchDetails> root,
					CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get(locationkey),
						location);
				return equalPredicate;
			}
		};
	}

	public static Specification<BankBranchDetails> getBranchListByBankId(String BankIdkey, int bankId) {
		return new Specification<BankBranchDetails>() {
			@Override
			public javax.persistence.criteria.Predicate toPredicate(Root<BankBranchDetails> root,
					CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				javax.persistence.criteria.Predicate equalPredicate = criteriaBuilder.equal(root.get(BankIdkey),
						bankId);
				return equalPredicate;
			}
		};
	}

	public static Specification<BankBranchDetails> getBranchListByBankIdAndLocation(String BankIdkey, int bankId,
			String locationkey, String location) {

		return Specification.where(getBranchListByBankId(BankIdkey, bankId))
				.and(getBranchListByLocation(locationkey, location));
	}

}
