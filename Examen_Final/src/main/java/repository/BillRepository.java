package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
		public List<Bill> findAll(); public void save(Bill bill);
	}

