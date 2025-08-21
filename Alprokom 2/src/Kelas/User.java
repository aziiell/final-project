package Kelas;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;  
    private String password;    

    public User(String username, String password) {
        validateUsername(username);
        validatePassword(password);
        
        this.username = username.trim();
        this.password = password;
    }

    private void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username tidak boleh kosong");
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("Password minimal 4 karakter");
        }
    }

    public static User authenticate(String username, String password) {
        for (User user : getRegisteredUsers()) {
            if (user.username.equals(username)) {
                if (user.password.equals(password)) {
                    return user;
                }
                throw new IllegalArgumentException("Password salah");
            }
        }
        User newUser = new User(username, password);
        getRegisteredUsers().add(newUser);
        return newUser;
    }

    private static List<User> getRegisteredUsers() {
        List<User> registeredUsers = new ArrayList<>();
        registeredUsers.add(new User("jeonghan", "pass111"));
        registeredUsers.add(new User("kyungsoo", "pass222"));
        return registeredUsers;
    }
    
    public String getUsername() { return username; }
    
    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }   
}