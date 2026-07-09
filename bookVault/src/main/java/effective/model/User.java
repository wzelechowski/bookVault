package effective.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.random.RandomGenerator;

public final class User {

    private final String firstName;
    private final String surname;
    private final String email;
    private final int libraryCardId;
    private final LocalDateTime registeredAt;

    private User(String firstName, String surname, String email, int libraryCardId) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.libraryCardId = libraryCardId;
        this.registeredAt = LocalDateTime.now();
    }

    public static User create(String firstName, String surname, String email, int libraryCardId) {
        return new User(firstName, surname, email, libraryCardId);
    }

    public static User createWithRandomId(String firstName, String surname, String email) {
        return new User(firstName, surname, email, RandomGenerator.getDefault().nextInt());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getLibraryCardId() {
        return libraryCardId;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof User user)) {
            return false;
        }
        return libraryCardId == user.libraryCardId && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, libraryCardId);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", libraryCardId=" + libraryCardId +
                ", registeredAt=" + registeredAt +
                '}';
    }
}
