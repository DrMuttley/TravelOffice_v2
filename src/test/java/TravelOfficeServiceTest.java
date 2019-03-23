import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class TravelOfficeServiceTest {

    @InjectMocks
    AbroadTrip abroadTrip;

    @InjectMocks
    Customer customer = new Customer();

    @InjectMocks
    TravelOfficeService travelOfficeService;

    //for testing System.out.println();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Methods set up fields before tests.
     */
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));

        travelOfficeService.addTrip("abroadTrip", abroadTrip);
        travelOfficeService.addCustomer(customer);
    }

    /**
     * Methods checks if customerSet contains new customer after add.
     */
    @Test
    public void addCustomer() {
        Customer someCustomer = new Customer("JOHN KOWALSKI");
        travelOfficeService.addCustomer(someCustomer);

        TestCase.assertEquals(true, travelOfficeService.getCustomersSet().contains(someCustomer));
    }

    /**
     * Methods checks if tripsMap contains new trip after add.
     */
    @Test
    public void addTrip() {
        travelOfficeService.addTrip("newTrip", abroadTrip);
        TestCase.assertEquals(true, travelOfficeService.getTripsMap().containsKey("newTrip"));
    }

    /**
     * Method check method findTripByDescription() for existing trip.
     */
    @Test
    public void findTripByDescription_ExistingTrip() {
        TestCase.assertEquals(abroadTrip, travelOfficeService.findTripByDescription("abroadTrip"));
    }

    /**
     * Method check method findTripByDescription() for NO existing trip.
     */
    @Test
    public void findTripByDescription_NoExistingTrip() {
        TestCase.assertEquals(null, travelOfficeService.findTripByDescription("noExistingTrip"));
    }

    /**
     * Method check method findCustomerByName() for existing customer.
     */
    @Test
    public void findCustomerByName_ExistingCustomer() {

        try {
            TestCase.assertEquals(customer, travelOfficeService.findCustomerByName(customer.getName()));
        } catch (NoSuchCustomerException e) {
            TestCase.fail();
        }
    }

    /**
     * Methods check method findCustomerByName() for NO existing customer.
     */
    @Test
    public void findCustomerByName_noExistingCustomer() {

        boolean testPass = false;

        try {
            travelOfficeService.findCustomerByName("noExistingName");
        } catch (NoSuchCustomerException e) {
            testPass = true;
        }
        TestCase.assertTrue(testPass);
    }

    /**
     * Methods tests method getCustomersSet() for NO empty set.
     */
    @Test
    public void getCustomersSetForNoEmptySet() {
        TestCase.assertEquals(1, travelOfficeService.getCustomersSet().size());
    }

    /**
     * Methods tests method getCustomersSet() for empty set.
     */
    @Test
    public void getCustomersSetForEmptySet() {
        travelOfficeService.getCustomersSet().clear();
        TestCase.assertTrue(travelOfficeService.getCustomersSet().isEmpty());
    }

    /**
     * Methods tests assign for existing customer and trip.
     */
    @Test
    public void assignTripForExistingCustomerAndTrip() {

        try {
            travelOfficeService.assignTrip(customer.getName(), "abroadTrip");
            TestCase.assertTrue(true);
        }catch (NoSuchCustomerException e){
            TestCase.fail();
        }
    }

    /**
     * Methods tests assign for existing customer and NO existing trip.
     */
    @Test
    public void assignTripForNoExistingTrip() {

        try {
            travelOfficeService.assignTrip(customer.getName(), "noExistingTrip");
            TestCase.assertEquals(null, customer.getTrip());
        }catch (NoSuchCustomerException e){

        }
    }

    /**
     * Methods tests assign for NO existing customer and existing trip.
     */
    @Test
    public void assignTripForNoExistingCustomer() {

        try {
            travelOfficeService.assignTrip("noExistingCustomer", "abroadTrip");
            TestCase.fail();
        }catch (NoSuchCustomerException e){
            TestCase.assertTrue(true);
        }
    }

    /**
     * Methods test removing trip from tripsMap for existing trip.
     */
    @Test
    public void removeTripExisting() {

        boolean tripRemoved = false;

        try {
            travelOfficeService.removeTrip("abroadTrip");
            tripRemoved = true;
        } catch (NoSuchTripException e) {

        }
        TestCase.assertTrue(tripRemoved);
    }

    /**
     * Methods test removing trip from tripsMap for NO existing trip.
     */
    @Test
    public void removeTripNoExisting() {

        boolean thrownException = false;
        travelOfficeService.getTripsMap().clear();

        try {
            travelOfficeService.removeTrip("abroadTrip");
        } catch (NoSuchTripException e) {
            thrownException = true;
        }
        TestCase.assertTrue(thrownException);
    }

    /**
     * Methods test showing trips for one trip in tripsMap.
     */
    @Test
    public void showAllTripsForOneTripInTripsMap() {
        System.out.print(travelOfficeService.showAllTrips());
        TestCase.assertEquals(travelOfficeService.showAllTrips(), outContent.toString());
    }

    /**
     * Methods test showing trips for empty tripsMap.
     */
    @Test
    public void showAllTripsForEmptyTripsMap() {
        travelOfficeService.getTripsMap().clear();
        System.out.print(travelOfficeService.showAllTrips());
        TestCase.assertEquals("There is no trip in the DB.", outContent.toString());
    }

    /**
     * Methods test showing customers for one customer in customerSet.
     */
    @Test
    public void showAllCustomersForOneCustomerInCustomerSet() {
        System.out.print(travelOfficeService.showAllCustomers());
        TestCase.assertEquals(travelOfficeService.showAllCustomers(), outContent.toString());
    }

    /**
     * Methods test showing customers for empty customerSet.
     */
    @Test
    public void showAllCustomersForEmptyCustomerSet() {
        travelOfficeService.getCustomersSet().clear();
        System.out.print(travelOfficeService.showAllCustomers());
        TestCase.assertEquals("There is no customers in the DB.", outContent.toString());
    }

    /**
     * Method clean up fields after tests.
     */
    @After
    public void cleanUp() {
        travelOfficeService.getCustomersSet().clear();
        travelOfficeService.getTripsMap().clear();
    }
}