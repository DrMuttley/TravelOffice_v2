import junit.framework.TestCase;
import org.junit.Test;

public class TravelOfficceServiceTest {


    @Test
    public void addCustomer() {

    }

    @Test
    public void addTrip() {
    }

    @Test
    public void findTripByDescription() {
    }

    @Test
    public void findCustomerByName_customerFound(){

        boolean customerFound = false;

        TravelOfficceService travelOfficceService = new TravelOfficceService();
        Customer customer = new Customer();
        travelOfficceService.addCustomer(customer);

        try {
            travelOfficceService.findCustomerByName(customer.getName());
            customerFound = true;
        }catch(NoSuchCustomerException e){
        }
        TestCase.assertTrue(customerFound);
    }

    //DONE
    @Test
    public void findCustomerByName_catchNoSuchCustomerException() {

        TravelOfficceService travelOfficceService = new TravelOfficceService();

        boolean thrown = false;

        try {
            travelOfficceService.findCustomerByName(null);
        } catch (NoSuchCustomerException e) {
            thrown = true;
        }
        TestCase.assertTrue(thrown);
    }

    @Test
    public void getCustomersSet() {
    }

    @Test
    public void findCustomerByTripCatchNoSuchCustomerException() {
    }

    //DONE
    @Test
    public void removeTrip_catchNoSuchTripException() {

        TravelOfficceService travelOfficceService = new TravelOfficceService();

        boolean thrown = false;

        try {
            travelOfficceService.removeTrip("");
        } catch (NoSuchTripException e) {
            thrown = true;
        }
        TestCase.assertTrue(thrown);

    }

    //DONE
    @Test
    public void removeTrip_removedSuccessfully() {

        boolean tripWasRemoved = false;

        TravelOfficceService travelOfficceService = new TravelOfficceService();

        LocalDate startTrip = new LocalDate(2019,12,12);
        LocalDate stopTrip = new LocalDate(2019,12,20);

        AbroadTrip abroadTrip = new AbroadTrip(startTrip, stopTrip, "FRANCE", 500);

        travelOfficceService.addTrip("firstTrip", abroadTrip);

        try {
            travelOfficceService.removeTrip("firstTrip");
            tripWasRemoved = true;
        }catch (NoSuchTripException e){
        }
        TestCase.assertTrue(tripWasRemoved);
    }

    @Test
    public void showAllTrips() {

    }

    @Test
    public void showAllCustomers() {
    }
}