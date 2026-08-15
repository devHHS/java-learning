public class EmailNotification extends Notification {

    private String subject;

    public EmailNotification(String recipient, String subject) {
        // TODO: super(recipient)를 호출해서 부모의 constructor에게 recipient 처리를 넘겨라.
        super(recipient);
        this.subject = subject;
    }

    // TODO: send()를 override해라.
    //       Notification의 send()와 signature(이름 + 매개변수)가 완전히 같아야 한다.
    //       내용: "이메일 [subject]를 recipient에게 보냄" 형태로 출력.
    //       recipient는 부모에서 물려받은 protected field를 그대로 쓸 수 있다.
    @Override
    public void send() {
        System.out.println("이메일 " + subject + "를 " + recipient + "에게 보냄");
    }
}
