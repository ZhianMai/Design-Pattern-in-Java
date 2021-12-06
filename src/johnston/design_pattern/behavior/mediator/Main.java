package johnston.design_pattern.behavior.mediator;

public class Main {
  public static void main(String[] args) {
    PublicChatRoom chatRoom = new PublicChatRoom();
    User john = new User("John", chatRoom);
    john.post("Anyone here?");

    User doe = new User("Doe", chatRoom);
    john.post("Join my team!");
    doe.post("Sure");

    User jane = new User("Jane", chatRoom);
    doe.post("Join out team!");
    jane.post("I prefer another team...");
  }
}
