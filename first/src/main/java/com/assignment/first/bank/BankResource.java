package com.assignment.first.bank;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class BankResource {

	@Autowired
	private BankRepository BankRepository;

	@Autowired
	private BankBranchDetailRepository BankBranchDetailRepository;

	@Autowired
	private ServiceRepository ServiceRepository;

	@GetMapping(path = "/bank")
	public Iterable<BankDetails> RetrieveAllBanks() {

		return BankRepository.findAll();
	}

	@GetMapping(path = "/bank/{id}")
	public BankDetails GetBankById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return Product.get();
	}

	/* . The first restful URL should display the bank Name as a String */
	@GetMapping(path = "/bankNameById/{id}")
	public String GetBankNameById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return Product.get().getBank_Name();
	}

	/* . The second restful URL should display the bank Address as a String */
	@GetMapping(path = "/bankAddressById/{id}")
	public String GetBankAddressById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return Product.get().getBank_Address();
	}

	@PostMapping(path = "/bank")
	public ResponseEntity<Object> CreateBankDetails(@Valid @RequestBody BankDetails bankDetails) {

		BankDetails details = BankRepository.save(bankDetails);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(details.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PostMapping(path = "/branch")
	public ResponseEntity<Object> CreateBranchDetails(@Valid @RequestBody BankBranchDetails bankBranchDetails) {

		BankBranchDetails details = BankBranchDetailRepository.save(bankBranchDetails);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(details.getBranch_id()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/branch/{id}")
	public BankBranchDetails GetBranchById(@PathVariable Integer branch_id) {

		Optional<BankBranchDetails> Product = BankBranchDetailRepository.findById(branch_id);
		return Product.get();
	}

	@GetMapping(path = "/branch")
	public Iterable<BankBranchDetails> RetrieveAllBranch() {
		return BankBranchDetailRepository.findAll();
	}

	@PostMapping(path = "/services")
	public ResponseEntity<Object> CreateServices(@Valid @RequestBody Services services) {

		Services details = ServiceRepository.save(services);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(details.getService_id()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/services")
	public Iterable<Services> RetrieveAllServices() {

		return ServiceRepository.findAll();
	}

	@GetMapping("/branchListByBankIdAndLocation/{bankId}-{location}")
	public ModelAndView GetBranchListByBankIdAndLocation(@PathVariable Integer bankId, @PathVariable String location) {

		List<BankBranchDetails> allEntries = BankBranchDetailRepository.findAll(
				Specifications.getBranchListByBankIdAndLocation("bank_id", bankId, "branch_location", location));
		ModelAndView modelAndView = new ModelAndView();
		Optional<BankDetails> bank = BankRepository.findById(bankId);

		modelAndView.addObject("entries", allEntries);
		modelAndView.addObject("title", bank.get().getBank_Name());
		System.out.println("title" + bank.get().getBank_Name());
		modelAndView.setViewName("branch.html");
		return modelAndView;
	}

	@GetMapping(path = "/allServicesByBank/{id}")
	public ModelAndView GetAllServicesByBank(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<BankDetails> bank = BankRepository.findById(id);
		List<Integer> serviceId = bank.get().getService_id();

		Iterable<Services> iterable = ServiceRepository.findAllById(serviceId);
		modelAndView.addObject("entries", iterable);
		modelAndView.addObject("title", bank.get().getBank_Name());
		modelAndView.setViewName("services.html");
		return modelAndView;

	}

}
