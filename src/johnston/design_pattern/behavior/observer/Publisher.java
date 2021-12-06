package johnston.design_pattern.behavior.observer;

public class Publisher {
  private String publisherName;
  private SubscriptionService service;

  public Publisher(String publisherName, SubscriptionService service) {
    this.publisherName = publisherName;
    this.service = service;
    service.registerPublisher(this);
  }

  public void post(String message) {
    service.post(this, message);
  }

  public String getPublisherName() {
    return publisherName;
  }
}
