public class PageRequest {

    private int pageNumber;
    private int pageSize;

    public PageRequest() {}

    public PageRequest(int pageNumber, int pageSize) {
        if (pageNumber < 0 || pageSize < 1 || pageSize > 100 ) {
            throw new IllegalArgumentException();
        }
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public PageRequest nextPage() {
        return new PageRequest(this.pageNumber + 1, pageSize);
    }

    public static void main(String[] args) {
        PageRequest pageRequest1 = new PageRequest(2, 3);
        //PageRequest pageRequest2 = new PageRequest(0, 0);
        //PageRequest pageRequest3 = new PageRequest(-5, 2);
        //PageRequest pageRequest4 = new PageRequest(2, 101);
        System.out.print(pageRequest1.pageNumber);
        System.out.print(pageRequest1.nextPage().pageNumber);
    }

}
