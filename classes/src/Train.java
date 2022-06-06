import java.math.BigDecimal;
public class Train {
    private String station;
    private String number;
    private double time;
    private int seats;
    private int bench;
    private int coupes;
    private int vips;

    public Train() {
        this.station = "";
        this.number = "";
        this.time = 0.00;
        this.seats = 0;
        this.bench = 0;
        this.coupes = 0;
        this.vips = 0;
    }

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }
    public void setNumber(String number) {
         this.number = number;
    }
    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }

    public void setBench(int bench) {
        this.bench = bench;
    }
    public void setCoupes(int coupes) {
        this.coupes = coupes;
    }
    public void setVips(int vips) {
        this.vips = vips;
    }

    @Override
    public String toString() {
        return "Train to the station " + station + " has a number is " + number + ". Departure time at: " +  BigDecimal.valueOf(time).setScale(2,BigDecimal.ROUND_HALF_EVEN) +
                ". There are free seats in total: " + (seats + bench + coupes + vips) + " (bench - " + bench +
                ", coupes - " + coupes + ", vips - " + vips + ")";
    }
}
