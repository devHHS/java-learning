package p0011;

public class Runner {
    public static void main(String[] args) {
        Product product = new Product(1L, "Keyboard", 49.99);
        ApiResponse<Product> response = ApiResponse.success(product);
        System.out.println(response.isSuccess());
        System.out.println(response.getData().getName());

        ApiResponse<Product> errorResponse = ApiResponse.error("Product not found");
        System.out.println(errorResponse.isSuccess());
        System.out.println(errorResponse.getErrorMessage());
        System.out.println(errorResponse.getData() == null);
    }
}
