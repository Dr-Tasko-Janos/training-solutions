package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public void setSailing(LocalDate sailing) {
        this.sailing = sailing;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() == boat.getMaxPassenger()) {
            throw new IllegalStateException("There is no empty space on the ship");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getRate();
    }

    public Passenger findPassengerByName(String name) {
        Passenger toFind = null;
        for (Passenger item : passengers) {
            if (item.getName().equals(name)) {
                toFind = item;
            }
        }
        return toFind;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> namesInOrder = new ArrayList<>();

        for (Passenger item : passengers) {
            namesInOrder.add(item.getName());
        }
        Collections.sort(namesInOrder);

        return namesInOrder;
    }

    public double sumAllBookingsCharged() {

        double allCharge = 0.0;

        for(Passenger item : passengers) {
            allCharge += item.getCruiseClass().getRate() * basicPrice;
        }

        return allCharge;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
       int puffer = 0;
       Map<CruiseClass, Integer> counter = new HashMap<>();
        for(CruiseClass i : CruiseClass.values()) {
            for(Passenger item : passengers) {
                if(item.getCruiseClass().equals(i)) {
                    puffer += 1;
                }
            }
            counter.put(i, puffer);
            puffer = 0;
        }
        return counter;
    }
}

