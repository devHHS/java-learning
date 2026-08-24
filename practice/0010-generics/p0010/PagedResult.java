package p0010;

import java.util.List;

public class PagedResult<T> {

    private List<T> items;
    private int totalCount;

    // TODO: constructor — items와 totalCount를 받아서 필드에 저장해라.
    public PagedResult(List<T> items, int totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    // TODO: getItems(), getTotalCount() getter 두 개 작성해라.
    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
