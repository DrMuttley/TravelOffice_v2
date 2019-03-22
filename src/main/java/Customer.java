public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public String getName() {
        return name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }


    public Customer() {
        this.name = "JOHN DOE";
        this.address = new Address();
        this.trip = new AbroadTrip();
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Address address, Trip trip) {
        this.name = name;
        this.address = address;
        this.trip = trip;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString(){

        String customerData = name;

        if(address != null){
            customerData += " " + address.toString();
        }
        if(trip != null){
            customerData += " " + trip.toString();
        }
        return customerData;
    }
}
