package johnston.design_pattern.behavior.mediator;

import java.util.HashSet;
import java.util.Set;

public class PublicChatRoom {

  private Set<User> onlineUser = new HashSet<>();

  public void broadcast(String userName, String message) {
    System.out.println(userName + ": " + message);
  }

  public void userOnlineNotify(User user) {
    onlineUser.add(user);
    System.out.println(user.getUserName() + " is online.");
  }
}
