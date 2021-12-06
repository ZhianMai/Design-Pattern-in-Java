package johnston.design_pattern.behavior.mediator;


public class User {
  private String userName;
  private PublicChatRoom chatRoom;

  public User(String userName, PublicChatRoom chatRoom) {
    this.userName = userName;
    this.chatRoom = chatRoom;
    chatRoom.userOnlineNotify(this);
  }

  public void post(String message) {
    chatRoom.broadcast(userName, message);
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public PublicChatRoom getChatRoom() {
    return chatRoom;
  }

  public void setChatRoom(PublicChatRoom chatRoom) {
    this.chatRoom = chatRoom;
  }
}
