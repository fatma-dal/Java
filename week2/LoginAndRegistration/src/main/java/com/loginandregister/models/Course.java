package com.loginandregister.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="course")
public class Course {

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getWeekday() {
		return weekday;
	}

	public Course(Long id, @NotEmpty String name, @NotEmpty String discription,
			@NotNull @Min(0) @Max(200) Integer price, @NotEmpty String weekday, Date createdAt, Date updatedAt,
			User user) {
	
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.price = price;
		this.weekday = weekday;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Course() {}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty
	private String name;
	

	
	@NotEmpty
	private String discription;
	
	
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@NotNull
	@Min(0)
	@Max(200)
	private Integer price;
	
	@NotEmpty 
	private String weekday;
	
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    // methods on create & on update 
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	        this.updatedAt = new Date();
	    }
	    public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
}
