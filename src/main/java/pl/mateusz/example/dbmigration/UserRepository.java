package pl.mateusz.example.dbmigration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);
}
