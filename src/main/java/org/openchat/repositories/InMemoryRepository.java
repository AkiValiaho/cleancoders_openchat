package org.openchat.repositories;

import org.openchat.entities.User;
import org.openchat.usecases.Repository;

import java.util.*;

public class InMemoryRepository implements Repository {
  private Map<String, User> users = new HashMap<>();

  public User getUser(String username) {
    return users.get(username);
  }

  public void addUser(User user) {
    User copy = new User();
    copy.username = user.username;
    copy.password = user.password;
    copy.about = user.about;
    users.put(user.username, copy);
  }

  public List<User> getAllUsers() {
    ArrayList<User> theUsers = new ArrayList<>(this.users.values());
    return Collections.unmodifiableList(theUsers);
  }
}