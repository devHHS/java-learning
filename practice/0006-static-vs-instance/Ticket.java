public class Ticket {

    private static int nextId = 1;

    private int id;
    private String subject;

    public Ticket(String subject) {
        // TODO: id = nextId 로 대입하고, nextId를 1 증가시켜라.
        // TODO: this.subject = subject;
        this.id = nextId;
        nextId++;
        this.subject = subject;
    }

    // TODO: static method getCreatedCount() 추가.
    //       nextId - 1을 반환하면 "지금까지 만들어진 총 Ticket 개수"가 된다.
    public static int getCreatedCount() {
        return nextId - 1;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public static void main(String[] args) {
        Ticket t1 = new Ticket("로그인 안 됨");
        Ticket t2 = new Ticket("결제 오류");
        Ticket t3 = new Ticket("비밀번호 재설정");

        System.out.println(t1.getId() + ": " + t1.getSubject());
        System.out.println(t2.getId() + ": " + t2.getSubject());
        System.out.println(t3.getId() + ": " + t3.getSubject());
        System.out.println("총 개수: " + Ticket.getCreatedCount());
    }
}
