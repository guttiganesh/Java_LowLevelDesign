package LLD.ParkingLot.Pricing;

public class HourlyPricingStrategy implements PricingStrategy{
    double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(long duration) {
        return ((double) duration / 3600000) * hourlyRate;
    }
}
