package be.pxl.demo.api;

import be.pxl.demo.api.dto.CreateUserRequest;
import be.pxl.demo.domain.user.PlanType;
import be.pxl.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<Void> createUser(CreateUserRequest createUserRequest) {
		userService.createUser(createUserRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/{userId}/subscribe/{planType}")
	public ResponseEntity<Void> createSubscription(@PathVariable Long userId, @PathVariable PlanType planType) {
		userService.updateSubscription(userId, planType);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

}
