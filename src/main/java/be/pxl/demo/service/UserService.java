package be.pxl.demo.service;

import be.pxl.demo.api.dto.CreateUserRequest;
import be.pxl.demo.domain.user.PlanType;
import be.pxl.demo.domain.user.User;
import be.pxl.demo.exception.ResourceNotFoundException;
import be.pxl.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(CreateUserRequest createUserRequest) {
		User user = new User();
		user.setCreationTime(LocalDateTime.now());
		user.setFirstName(createUserRequest.firstname());
		user.setLastName(createUserRequest.lastname());
		user.setDateofBirth(createUserRequest.dob());
		user.setSubscription(PlanType.BASIC);
		userRepository.save(user);
	}

	public void updateSubscription(Long userId, PlanType planType) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		user.setSubscription(planType);
		userRepository.save(user);
	}
}
