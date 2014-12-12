package hms.service;

import hms.model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sadupa on 12/12/14.
 */
public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(String vehicleId);
    boolean VerifyVehicle(String vehicleId, String verificationCode);
    boolean updateVehicleLocation(String vehicleId, BigDecimal longitude, BigDecimal latitude, Date time);
    boolean getVehiclesByGroup(Long groupId);
}