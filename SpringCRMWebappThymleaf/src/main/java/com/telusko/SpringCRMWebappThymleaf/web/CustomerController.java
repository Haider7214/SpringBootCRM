package com.telusko.SpringCRMWebappThymleaf.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.SpringCRMWebappThymleaf.model.Customer;
import com.telusko.SpringCRMWebappThymleaf.service.ICustomerService;

@Controller
public class CustomerController
{
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/cxinfo")
	public String getAllCxData(Model model)
	{
		List<Customer> cxList = service.getCustomerInfo();
		model.addAttribute("customers", cxList);
		cxList.forEach(c->System.out.println(c));
		return "customerlist";
	}
	@GetMapping("/showForm")
	public String getForm(Model model)
	{
		model.addAttribute("customer", new Customer());
		return "showform";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCx(@ModelAttribute("customer")Customer customer,Model model)
	{
		service.registerCustomer(customer);
		return "redirect:/cxinfo";
	}
	
	@GetMapping("/updateForm")
	public String updateCx(@RequestParam("customerId")Integer id,Model model)
	{
		Customer cx = service.fetchCxById(id);
		model.addAttribute("customer", cx);
		return "showform";
	}
	
	@GetMapping("/deleteData")
	public String deleteCx(@RequestParam("customerId")Integer id)
	{
		service.deleteCxRecord(id);
		
		return "redirect:/cxinfo";
	}
}
