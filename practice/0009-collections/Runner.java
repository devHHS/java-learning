// 이번엔 완성본을 주지 않는다. 아래 순서대로 main()부터 직접 작성해라.
//
// 1. List<Product> products = new ArrayList<>(); 로 List를 만든다.
//    (import java.util.ArrayList; import java.util.List; 를 파일 위에 추가해야 함)
// 2. Product를 5개 정도 만들어 products에 add()한다.
//    category는 일부러 겹치게 만들어라 (예: "전자제품"을 두 개 이상).
// 3. Catalog.uniqueCategories(products)를 호출하고 결과를 출력해라.
//    -> category가 중복 없이 나오는지 확인.
// 4. Catalog.indexById(products)를 호출하고, 그 Map에서 특정 id 하나를 get()해서 출력해라.
//    -> id로 바로 Product를 찾을 수 있는지 확인.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", "Electronics", 1200000);
        Product product2 = new Product(2, "Mouse", "Electronics", 30000);
        Product product3 = new Product(3, "Desk", "Furniture", 150000);
        Product product4 = new Product(4, "Chair", "Furniture", 90000);
        Product product5 = new Product(5, "Coffee", "Food", 5000);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        System.out.println(Catalog.uniqueCategories(products));

        Map<Integer, Product> productMap = Catalog.indexById(products);
        System.out.println(productMap.get(2));

    }
}
