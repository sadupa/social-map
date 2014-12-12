package hms.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Sadupa Wijeratne
 *         Date     : 12/11/14
 *         Time     : 4:44 PM
 */

@Entity
@Table(name = "vehicle_group")
public class VehicleGroup implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "details")
    String details;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "start")
    Location start;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "end")
    Location end;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleGroup", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public Location getStart() {
        return start;
    }
    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }
    public void setEnd(Location end) {
        this.end = end;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
