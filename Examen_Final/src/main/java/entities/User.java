package entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data

public class User {

	@Id
	@SequenceGenerator(name="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	
	private Integer id;
	private String username;
	private String pass;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="bill")
	private List<User> users;
	
	
}
