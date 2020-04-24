package com.assignment.first.employee;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeResource {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("user-data.html");
		return modelAndView;
	}

	@GetMapping(path = "/displayAll")
	public Iterable<Employee> RetrieveAllEmployee() {

		return employeeRepository.findAll();
	}

	@GetMapping(path = "/display/{id}")
	public Employee GetEmployeeById(@PathVariable Integer id) {

		Optional<Employee> Product = employeeRepository.findById(id);
		return Product.get();
	}

	@PostMapping(path = "/employee")
	public String PostEmpluyee(@Valid @RequestBody Employee employee) {

		Employee details = employeeRepository.save(employee);
		return "Emplyee Saved";

	}

	@PutMapping(path = "/employee")
	public String UpdateEmployee(@Valid @RequestBody Employee employee) {

		Optional<Employee> details = employeeRepository.findById(employee.getId());

		if (details != null) {

			employeeRepository.save(employee);
			return "Employee Details Updated";
		} else {
			return "Employee is not exists of id :" + employee.getId();
		}
	}

	@DeleteMapping(path = "/delete/{id}")
	public String DeleteEmployeeById(@PathVariable Integer id) {

		employeeRepository.deleteById(id);
		return "Employee Details Deleted";
	}
}
