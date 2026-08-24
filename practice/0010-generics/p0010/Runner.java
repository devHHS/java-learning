package p0010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO: 아래 순서대로 main 메서드를 처음부터 작성해라. (완성본 없음 — 직접 작성)
//
// 1. Item을 3~4개 만들어 List<Item>에 담는다.
// 2. 그 List와 totalCount(예: 실제 개수와 다른 값, "전체는 더 많다"는 상황을 가정)로
//    PagedResult<Item>을 만든다.
// 3. PageUtils.firstOrNull(...)을 호출해 결과를 출력한다.
// 4. 빈 List(size 0)로 PagedResult<Item>을 하나 더 만들어 firstOrNull을 호출하고,
//    null이 출력되는지 확인한다.
public class Runner {
    public static void main(String[] args) {
        Item item1 = new Item(1, "Item 1");
        Item item2 = new Item(2, "Item 2");
        Item item3 = new Item(3, "Item 3");
        Item item4 = new Item(4, "Item 4");

        List<Item> items = Arrays.asList(item1, item2, item3, item4);

        PagedResult<Item> pagedResult = new PagedResult<>(items, 10);

        Item firstItem = PageUtils.firstOrNull(pagedResult);
        System.out.printf("First item: %s\n", firstItem);

        //List<Item> emptyItems = Collections.emptyList();
        List<Item> emptyItems = new ArrayList<>();
        PagedResult<Item> pagedResult2 = new PagedResult<>(emptyItems, 10);
        Item firstItem2 = PageUtils.firstOrNull(pagedResult2);
        System.out.printf("First item: %s\n", firstItem2);
    }
}
