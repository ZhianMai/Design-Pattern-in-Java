package johnston.design_pattern.behavior.observer;

public class User {
  private String username;
  private SubscriptionService service;

  public User (String username, SubscriptionService service) {
    this.username = username;
    this.service = service;
  }

  public void subscribe(Publisher publisher) {
    service.addSubscribe(this, publisher);
  }

  public void unsubscribe(Publisher publisher) {
    service.removeSubscribe(this, publisher);
  }

  public void getPush(String news) {
    System.out.println(news + "(user " + username + " received)");
  }
}
