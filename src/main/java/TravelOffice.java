import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class TravelOffice {

    private Set<Customer> customersSet = new HashSet<>();
    private Map<String, Trip> tripsMap = new HashMap<>();

    public Set<Customer> getCustomersSet() {
        return customersSet;
    }

    public Map<String, Trip> getTripsMap() {
        return tripsMap;
    }

    public void addCustomer(Customer customer){
        customersSet.add(customer);
    }

    public String showAllCustomers(){

        StringBuilder allCustomers = new StringBuilder();

        if(!getCustomersSet().isEmpty()) {
            getCustomersSet().forEach(customer -> allCustomers.append(customer.toString() + "\n"));
        }else{
            allCustomers.append("There is no customers in the DB.");
        }
        return allCustomers.toString();
    }

    public String showAllTrips(){

        StringBuilder allTrips = new StringBuilder();

        if(!getTripsMap().isEmpty()) {
            getTripsMap().entrySet().forEach(trip -> allTrips.append(trip.getValue() + "\n"));
        }else{
            allTrips.append("There is no trip in the DB.");
        }
        return allTrips.toString();
    }

    public void addTrip(String description, Trip trip){
        tripsMap.put(description, trip);
    }

    public void removeTrip(String description) throws NoSuchTripException{

        if(tripsMap.containsKey(description)){
            tripsMap.remove(description);
        }else{
            throw new NoSuchTripException("The trip wasn't found");
        }
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException{

        for(Customer c : customersSet){
            if(c.getName().equals(name)){
                return c;
            }
        }
        throw new NoSuchCustomerException("The customer not found exception.");
    }

    public Customer findCustomerByTrip(Trip trip){

        for(Customer c : customersSet){
            if(c.getTrip().equals(trip)){
                return c;
            }
        }
        return null;
    }

    public Trip findTripByDescription(String tripDescription){

        for (Map.Entry<String,Trip> entry : getTripsMap().entrySet()) {

            if(entry.getKey().equals(tripDescription)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void assignTrip(String userName, String tripDescription) throws NoSuchCustomerException{
        findCustomerByName(userName).assignTrip(findTripByDescription(tripDescription));
    }

    public void removeCustomer(Customer customer) throws NoSuchCustomerException{

        if(!customersSet.remove(customer)){
            throw new NoSuchCustomerException("The customer not found exception.");
        }
    }

}
