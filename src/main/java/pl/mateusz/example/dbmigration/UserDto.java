package pl.mateusz.example.dbmigration;

import jakarta.persistence.Convert;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;

    private boolean isNewsletterSubscriber;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, LocalDate birthDate, String email, boolean isNewsletterSubscriber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.isNewsletterSubscriber = isNewsletterSubscriber;
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNewsletterSubscriber() {
        return isNewsletterSubscriber;
    }

    public void setNewsletterSubscriber(boolean newsletterSubscriber) {
        isNewsletterSubscriber = newsletterSubscriber;
    }
}
