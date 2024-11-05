public class ZomatoFacade {
    private DeliveryBoy deliveryBoy;
    private DeliveryTeam deliveryTeam;
    private Restaurant restaurant;

    public void placeOrder() {
        restaurant.prepareFood();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpFood();
        deliveryBoy.deliverFood();
    }; 
}
