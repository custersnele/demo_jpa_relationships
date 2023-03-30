package be.pxl.demo.domain;

import be.pxl.demo.domain.usercredentials.Credentials;
import be.pxl.demo.domain.usercredentials.User;
import be.pxl.demo.domain.usercredentials.UserType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@DataJpaTest
class UserTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOneToOneBidirectionalRelation() {

        User user = new User();
        user.setFirstName("Mickey");
        user.setLastName("Mouse");
        user.setCreationTime(LocalDateTime.now());
        user.setDateofBirth(LocalDate.of(1996, 12, 13));
        user.setUserType(UserType.ADMIN);
        user.setCredentials(new Credentials("mickeym", "password123!"));

        //User object having all the information (User and Credentials)
        entityManager.persist(user);
        long userId = user.getId();
        long credentialsId = user.getCredentials().getCredentialId();
        entityManager.flush();

        Credentials credential = entityManager.find(Credentials.class, credentialsId);

        System.err.println("================= From Credentials ===================");
        System.err.println("User Name: " + credential.getUserName());
        System.err.println("Password: " + credential.getPassword());
        //In Bi-direction we can navigate to other side entity(User)
        System.err.println("First Name : " + credential.getUser().getFirstName());
        System.err.println("Last Name : " + credential.getUser().getLastName());

        User credentialUser = credential.getUser();
        credentialUser.setCredentials(new Credentials("mickey_update", "minie123!"));

        entityManager.merge(credentialUser);
        entityManager.flush();

        User retrievedUser = entityManager.find(User.class, userId);

        System.err.println("================= From User ===================");
        System.err.println("First Name : " + user.getFirstName());
        System.err.println("Last Name : " + user.getLastName());
        //In Bi-direction we can navigate to other side entity(Credentials)
        System.err.println("User Name: " + user.getCredentials().getUserName());
        System.err.println("Password: " + user.getCredentials().getPassword());
    }

}
