import java.util.Map;
import java.util.Set;

public class TravelOfficeService {

    private TravelOffice travelOffice = new TravelOffice();

    public void addCustomer(Customer customer){
        travelOffice.addCustomer(customer);
    }

    public void addTrip(String tripDescription, Trip trip){
        travelOffice.addTrip(tripDescription, trip);
    }

    public Trip findTripByDescription(String tripDescription){
        return travelOffice.findTripByDescription(tripDescription);
    }

    public Customer findCustomerByName(String userName) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(userName);
    }

    public Set<Customer> getCustomersSet(){
        return travelOffice.getCustomersSet();
    }

    public Map<String, Trip> getTripsMap(){
        return  travelOffice.getTripsMap();
    }

    public Customer findCustomerByTrip(Trip trip){
        return travelOffice.findCustomerByTrip(trip);
    }

    public void removeTrip(String tripDescription) throws NoSuchTripException {
        travelOffice.removeTrip(tripDescription);
    }

    public String showAllTrips(){
        return travelOffice.showAllTrips();
    }

    public String showAllCustomers(){
        return travelOffice.showAllCustomers();
    }

    public void assignTrip(String userName , String tripDescription) throws NoSuchCustomerException{
        travelOffice.assignTrip(userName, tripDescription);
    }
}
