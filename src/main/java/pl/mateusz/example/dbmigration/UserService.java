package pl.mateusz.example.dbmigration;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void add(UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getBirthDate(),
                userDto.getEmail(), userDto.getIsNewsletterSubscriber());
        if (userRepository.existsUserByFirstNameAndLastNameAndBirthDate(userDto.getFirstName(), userDto.getLastName(),
                userDto.getBirthDate())) {
            throw new DuplicateUserException("Nie można dodać ponownie tego samego użytkownika");
        }
        if (userDto.getBirthDate().isAfter(LocalDate.now().minusYears(15))) {
            throw new MinimumAgeException("Nie można dodać użytkownika w wieku niższym niż 15 lat");
        }

        userRepository.save(user);

    }

    public List<UserDto> displayAll() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthDate(), user.getEmail(),
                user.getIsNewsletterSubscriber());
    }
}
