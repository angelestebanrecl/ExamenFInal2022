package entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;


@Entity
@Data
public class Bill {
	
	@Id
	@SequenceGenerator(name="bill_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bill_id_seq")

	private Integer id;
	private Date date_bill;
	private Integer user_id;
	private Integer value;
	private Integer type;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name="user_id_seq")
	private User user;
}
