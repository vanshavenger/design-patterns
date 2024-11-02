
public class Main {
    public static void main(String[] args) {
        GroceryItemAdapter groceryProduct = new GroceryItemAdapter(new GroceryProduct());
        System.out.println(groceryProduct.getItemName());
        System.out.println(groceryProduct.getPrice());
        System.out.println(groceryProduct.getRestaurantName());

        FoddItem foddItem = new FoddItem();
        System.out.println(foddItem.getItemName());
        System.out.println(foddItem.getPrice());
        System.out.println(foddItem.getRestaurantName());
    }
}