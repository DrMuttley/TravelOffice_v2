public abstract class Trip {

    private LocalDate start;
    private LocalDate end;
    private String destination;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip(){
        this.start = new LocalDate();
        this.end = new LocalDate();
        this.destination = "FRANCE";
        this.price = 1000;
    }

    public Trip(String tripDetails){}

    public Trip(LocalDate start, LocalDate end, String destination, int price) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return "start: " + this.start.toString() + " " + "End: " + this.end.toString() + this.destination + " " + getPrice();
    }
}
