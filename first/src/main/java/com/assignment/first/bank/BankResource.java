package com.assignment.first.bank;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;







@RestController
public class BankResource {

	@Autowired
	private BankRepository BankRepository ;
	
	
	@GetMapping(path = "/bank")
	public Iterable<BankDetails> RetrieveAllBanks() {
		return BankRepository.findAll();
	}

	@GetMapping(path = "/bank/{id}")
	public BankDetails GetBankById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return Product.get();
	}
	
	/*. The first restful URL should display the bank Name as a String*/
	@GetMapping(path = "/bankNameById/{id}")
	public String GetBankNameById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return  Product.get().getBank_Name();
	}
	
	/*. The second restful URL should display the bank Address as a String*/
	@GetMapping(path = "/bankAddressById/{id}")
	public String GetBankAddressById(@PathVariable Integer id) {

		Optional<BankDetails> Product = BankRepository.findById(id);
		return Product.get().getBank_Address();
	}
	
	@PostMapping(path = "/bank")
	public ResponseEntity<Object> CreateBankDetails(@Valid @RequestBody BankDetails bankDetails) {

			BankDetails details = BankRepository.save(bankDetails);
			URI location =	ServletUriComponentsBuilder.
					fromCurrentRequest().
					path("/{id}").
					buildAndExpand(details.getId()).toUri();
			
					return ResponseEntity.created(location).build();

	}
	
//	@GetMapping("/bank-name-list")
//	public MappingJacksonValue GetBankByName() {
//
//		return RetriveFilterValue("bank_Name");
//		
//		
//	}
//
//	@GetMapping("/bank-address-list")
//	public MappingJacksonValue GetBankByAddress() {
//	
//		return RetriveFilterValue("bank_Address");
//	}
//	
//	
//	
//	
//	public MappingJacksonValue RetriveFilterValue(String key){
//		
//		MappingJacksonValue mapping = new MappingJacksonValue(BankRepository.findAll()) ;
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(key);
//		FilterProvider filters   = new SimpleFilterProvider().addFilter("FilterByNameorAddress", filter);
//		mapping.setFilters(filters);
//		return mapping ;
//	}
	
}
