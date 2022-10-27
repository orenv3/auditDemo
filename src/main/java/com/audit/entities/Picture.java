package com.audit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@Table
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long picture_id;
	
	@NotBlank
	@Column(name = "picture_name")
    private String PictureName;

	public Picture(@NotBlank String picture_name) {
		super();
		this.PictureName = picture_name;
	}
	
	
}
