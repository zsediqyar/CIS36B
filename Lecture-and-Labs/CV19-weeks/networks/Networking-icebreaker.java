class Networking-icebreaker {
  public static void main(String args[]){
    ServerSocket ss = new ServerSocket(6666);
    Socket s = ss.accept();
  }
}
