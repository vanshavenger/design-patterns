
import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private final static Map<String, Vehicle> mapVehicles = new HashMap<>();

    static {
        mapVehicles.put("TwoWheeler", new TwoWheelerVehicle("100cc", "Black", "Hero", "No"));
        mapVehicles.put("FourWheeler", new FourWheelerVehicle("2000cc", "White", "Toyota", true, true));
    }

    public  Vehicle getVehicle(String vehicleType) throws CloneNotSupportedException {
        return mapVehicles.get(vehicleType).clone();
    }

}
