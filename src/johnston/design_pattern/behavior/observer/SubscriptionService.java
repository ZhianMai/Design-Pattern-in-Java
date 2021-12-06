package johnston.design_pattern.behavior.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubscriptionService {
  private Map<Publisher, Set<User>> subscriberList = new HashMap<>();

  public void post(Publisher publisher, String message) {
    Set<User> userSet = subscriberList.get(publisher);

    if (userSet == null) {
      return;
    }

    String publisherName = publisher.getPublisherName();
    String pushMessage = publisherName + ": " + message;

    for (User user : userSet) {
      user.getPush(pushMessage);
    }
  }

  public void addSubscribe(User user, Publisher publisher) {
    Set userList = subscriberList.get(publisher);

    if (userList != null) {
      userList.add(user);
    }
  }

  public void removeSubscribe(User user, Publisher publisher) {
    Set userList = subscriberList.get(publisher);

    if (userList != null) {
      userList.remove(user);
    }
  }

  public void registerPublisher(Publisher publisher) {
    if (!subscriberList.containsKey(publisher)) {
      subscriberList.put(publisher, new HashSet<>());
    }
  }
}
