public class AbroadTrip extends Trip {

    private int insurance;

    public AbroadTrip() {
        super();
        this.insurance = 50;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public AbroadTrip(String tripDetails){
        super(tripDetails);
    }

    public AbroadTrip(LocalDate start, LocalDate end, String destination, int price) {
        super(start, end, destination, price);
    }

    @Override
    public int getPrice(){
        return super.getPrice() + this.insurance;
    }
}
