public class Address {

    private String street;
    private String zip;
    private String city;


    public Address() {
        this.street = "OPOLSKA";
        this.zip = "40-708";
        this.city = "KATOWICE";
    }

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    @Override
    public String toString(){
        return street + " " + zip + " " + city;
    }
}
