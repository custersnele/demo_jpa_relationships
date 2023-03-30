package be.pxl.demo.domain.football;

import jakarta.persistence.*;

@Entity
public class FootballPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	private String name;
	private String email;
	@Transient
	private int shirtNumber;

	public FootballPlayer() {
	}

	public FootballPlayer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	@Override
	public String toString() {
		return "FootballPlayer{" +
				"uuid=" + uuid +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", shirtNumber=" + shirtNumber +
				'}';
	}
}
