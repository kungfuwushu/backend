package fr.kungfunantes.backend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
@ApiModel(description="A Profile is allowed to connect to the application")
public class Profile {
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(notes="Firstname should have at least 2 characters, at most 20.")
	@Size(min=2, message="Firstname should have at least 2 characters")
	@Size(max=20, message="Firstname should have at most 20 characters")
	private String firstname;
	
	@ApiModelProperty(notes="Lastname should have at least 2 characters, at most 20.")
	@Size(min=2, message="Lastname should have at least 2 characters")
	@Size(max=20, message="Lastname should have at most 20 characters")
	private String lastname;
	
	public Profile() {
		super();
	}

	public Profile(Long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
}
