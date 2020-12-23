package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant newRestaurant = new Restaurant("VasEdény", 10);

        System.out.println(newRestaurant.getName());
        System.out.println(newRestaurant.getCapacity());
        System.out.println(newRestaurant.getMenu());
    }
}
