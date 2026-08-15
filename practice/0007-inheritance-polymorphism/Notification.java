public class Notification {

    protected String recipient;

    public Notification(String recipient) {

        this.recipient = recipient;
    }

    public void send() {

        System.out.println("일반 알림을 " + recipient + "에게 보냄");
    }
}
