package com.kodilla.stream.portfolio;

<<<<<<< HEAD
import java.util.Objects;

=======
>>>>>>> origin/macbook
public final class User {
    private final String username;
    private final String realName;

<<<<<<< HEAD
    public User(String username, String realName) {
=======
    public User(final String username, final String realName) {
>>>>>>> origin/macbook
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
<<<<<<< HEAD
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

}
=======
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }
}
>>>>>>> origin/macbook
