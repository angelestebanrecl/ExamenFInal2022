package controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Bill;
import repository.BillRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bills")
public class BillController {

	
	@Autowired
	BillRepository billRepository;
	
	@GetMapping
	public List<Bill> getBillAll() {

		return billRepository.findAll(); 
	}
	
	@GetMapping("/{id}")
	public Bill getBillsbyId(@PathVariable Integer id) {
		
		Optional<Bill> bill = billRepository.findById(id);
		
		if (bill.isPresent()) {
			return bill.get();
		}
		
		return null;

	}
	
	@PostMapping
	public Bill postBills(@RequestBody Bill bill) {
		
		billRepository.save(bill);
		
		return bill;
		

	}
	
	@DeleteMapping("/{id}")
	public Bill deleteBillsbyId(@PathVariable Integer id) {
		
		Optional<Bill> producto = billRepository.findById(id);
		
		if (producto.isPresent()) {
			
			Bill billReturn = getBillsbyId(id);
			
			billRepository.deleteById(id);
			
			return billReturn;
		}
		
		return null;
}
