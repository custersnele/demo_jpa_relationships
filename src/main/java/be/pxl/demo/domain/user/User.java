package be.pxl.demo.domain.user;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "demouser")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="creation_time")
	private LocalDateTime creationTime;
	@Column(name="dob")
	private LocalDate dateofBirth;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sub_id")
	private Subscription subscription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public void setSubscription(PlanType planType) {
		this.subscription = new Subscription(planType);
	}

	public Subscription getSubscription() {
		return subscription;
	}
}
