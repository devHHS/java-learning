import java.util.ArrayList;
import java.util.List;

public class NotificationDemo {
    public static void main(String[] args) {
        List<Notification> queue = new ArrayList<>();
        queue.add(new Notification("admin@invoice-app.com"));
        queue.add(new EmailNotification("user@example.com", "결제 완료 안내"));
        queue.add(new SmsNotification("+49-123-456", 70));

        // queue의 선언 타입은 전부 Notification이지만,
        // send()는 각 object의 "진짜" 타입에 맞는 버전이 호출된다 — 이게 polymorphism이다.
        for (Notification n : queue) {
            n.send();
        }
    }
}
