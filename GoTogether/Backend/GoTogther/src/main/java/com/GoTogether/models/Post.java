package com.GoTogether.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Departure location cannot be blank")
    @Size(max = 100, message = "Departure location must not exceed 100 characters")
	private String depart;
	private String destination;
	
	private String date;
	
	private Date time;
	
	private String description;
	
	private int seats;
	private String luggage;
	
	private int price;
	private String car;
	
	
	
	
}
