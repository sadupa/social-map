package hms.dao.impl;

import hms.dao.VehicleDao;
import hms.model.Vehicle;
import hms.model.VehicleGroup;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository("vehicleDao")
public class VehicleDaoImpl extends UniversalDaoImpl implements VehicleDao {

    @Override
    public boolean save(Vehicle vehicle) {
        return super.save(vehicle);
    }

    @Override
    public boolean update(Vehicle vehicle) {
        return super.update(vehicle);
    }



    @Override
    public Vehicle getVehicleById(Long id) {
        Session session = getSession();
        Vehicle result = (Vehicle) session.createCriteria(Vehicle.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return result;
    }

    @Override
    public Vehicle getVehicleById(String vehicleId) {
        Session session = getSession();
        Vehicle result = (Vehicle) session.createCriteria(Vehicle.class)
                .add(Restrictions.eq("vehicleId", vehicleId))
                .uniqueResult();
        return result;
    }


    @Override
    public Vehicle getVehicleByGroupAndCode(Long groupId, String code, Vehicle.Status status) {
        Session session = getSession();
        Vehicle result = (Vehicle) session.createCriteria(Vehicle.class)
                .add(Restrictions.eq("vehicleGroup.id", groupId))
                .add(Restrictions.eq("authenticationCode", code))
                .add(Restrictions.eq("vehicleStatus", status))
                .uniqueResult();
        return result;
    }

    @Override
    public List<Vehicle> getAllVehiclesByGroup(Long groupId, Vehicle.Status status) {
        Session session = getSession();
        List<Vehicle> result = (List<Vehicle>) session.createCriteria(Vehicle.class)
                .add(Restrictions.eq("vehicleGroup.id", groupId))
                .add(Restrictions.eq("vehicleStatus", status))
                .list();
        return result;
    }

    @Override
    public List<Vehicle> getAllVehiclesByGroup(Long groupId, Vehicle.Status status, Date minLastUpdatedTime) {
        Session session = getSession();
        List<Vehicle> result = (List<Vehicle>) session.createCriteria(Vehicle.class)
                .add(Restrictions.eq("vehicleGroup.id", groupId))
                .add(Restrictions.eq("vehicleStatus", status))
                .add(Restrictions.gt("lastUpdatedTime", minLastUpdatedTime))
                .list();
        return result;

    }

    @Override
    public List<Vehicle> getAllVehicles() {
        Session session = getSession();
        List<Vehicle> result = (List<Vehicle>) session.createCriteria(Vehicle.class)
                .add(Restrictions.ne("vehicleStatus", Vehicle.Status.REMOVED))
                .list();
        return result;
    }

   // @Override
    public List<Vehicle> getAllVehiclegroups() {
        Session session = getSession();
        List<Vehicle> result = (List<Vehicle>) session.createCriteria(Vehicle.class)
                .list();
        return result;
    }




}
