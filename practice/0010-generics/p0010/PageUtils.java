package p0010;

public class PageUtils {

    // TODO: generic static method. PagedResult<T>를 받아서 items의 첫 번째 요소를 반환해라.
    //       비어있으면 null을 반환해라.
    //       method 자체가 타입 T를 알아야 하므로, return type(T) 앞에 <T>를 선언해야 한다.
    //       형태: public static <T> T firstOrNull(PagedResult<T> result) { ... }
    public static <T> T firstOrNull(PagedResult<T> result) {
        // TODO
        if (result.getItems().isEmpty()) {
            return null;
        }
        return result.getItems().get(0);
    }
}
