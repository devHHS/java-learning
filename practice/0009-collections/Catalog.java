import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    // TODO: products의 category를 전부 모으되, 중복은 제거해서 반환해라.
    //       Set 하나를 만들고, products를 순회하며 add()만 하면 된다 (중복은 Set이 알아서 걸러줌).
    public static Set<String> uniqueCategories(List<Product> products) {
        //for statemen
    /*  Set<String> categories = new HashSet<>();
        for (Product product : products) {
            categories.add(product.getCategory());
        }
        return categories
        */

        // Stream
        return products
                .stream()
                .map( product -> product.getCategory())
                .collect(Collectors.toSet());

    }

    // TODO: id로 Product를 바로 찾을 수 있도록 Map<Integer, Product>를 만들어 반환해라.
    //       Map 하나를 만들고, products를 순회하며 put(product.getId(), product)만 하면 된다.
    public static Map<Integer, Product> indexById(List<Product> products) {
        //for Statement
/*        Map<Integer, Product> map = new HashMap<>();
        for (Product product : products) {
            map.put(product.getId(), product);
        }
        return map;*/

        // Stream
        return products.stream().collect(Collectors.toMap(Product::getId, product -> product));
    }
}
