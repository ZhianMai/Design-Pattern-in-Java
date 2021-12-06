package johnston.design_pattern.behavior.observer;

public class Main {
  public static void main(String[] args) {
    SubscriptionService service =  new SubscriptionService();
    Publisher cctv = new Publisher("CCTV", service);
    Publisher cnn = new Publisher("CNN", service);
    Publisher bbc = new Publisher("BBC", service);

    User john = new User("John", service);
    john.subscribe(cctv);
    john.subscribe(cnn);
    john.subscribe(bbc);

    User doe = new User("Doe", service);
    doe.subscribe(cctv);
    doe.subscribe(cnn);
    doe.subscribe(bbc);

    User jane = new User("Jane", service);
    jane.subscribe(cctv);
    jane.subscribe(cnn);
    jane.subscribe(bbc);

    cctv.post("GDP grew slower last year");
    cnn.post("Trump plans for next presidential election");
    bbc.post("Christmas tree from Norway is not very good this year!");

    john.unsubscribe(cctv);
    jane.unsubscribe(cnn);
    doe.unsubscribe(bbc);

    System.out.println();
    cctv.post("Real estate price goes up");
    cnn.post("Stock price goes up, hitting the historical record");
    bbc.post("Daniel won't film any more 007 movies.");
  }
}
