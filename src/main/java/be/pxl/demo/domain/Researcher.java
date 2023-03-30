package be.pxl.demo.domain;

import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
public class Researcher {

	private static final Logger LOGGER = LogManager.getLogger(Researcher.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40, nullable = false)
	private String firstname;
	@Column(length = 40, nullable = false)
	private String lastname;
	@OneToOne(cascade = CascadeType.ALL)
	private ContactInformation contactInformation;
	@ManyToOne
	private Project project;

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	// TODO: write unit tests for this method
	public void setProject(Project project) {
		if (this.project != null) {
			if (this.project.equals(project)) {
				LOGGER.info("Researcher [" + id + "] already assigned to [" + project.getName() + "]");
				return;
			}
			this.project.removeResearcher(this);
		}
		this.project = project;
		project.addResearcher(this);
	}

	@Override
	public String toString() {
		return String.format("%s %s (%d)", firstname, lastname, id);
	}
}
