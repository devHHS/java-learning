public class SmsNotification extends Notification {

    private int maxLength;

    public SmsNotification(String recipient, int maxLength) {
        // TODO: super(recipient)를 호출해라.
        super(recipient);
        this.maxLength = maxLength;
    }

    // TODO: send()를 override해라.
    //       내용: "SMS(최대 [maxLength]자)를 recipient에게 보냄" 형태로 출력.
    @Override
    public void send() {
        System.out.println("SMS(최대 " + maxLength + "자)를 " + recipient + "에게 보냄");
    }
}
