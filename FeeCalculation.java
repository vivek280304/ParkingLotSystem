import java.time.Duration;
public class FeeCalculation {



    public long Hour(Ticket ticket ) {

        return Duration.between(ticket.getEntryTime() , ticket.getExitTime()).toHours()+1;

    }

    public int BikeFee (Ticket ticket) {

        if (ticket.getVehicle().getType() != VehicleType.BIKE) {

            return 0;
        }

            long hour = Hour(ticket);

            if (hour <= 1) {
                return 20;
            }
            return (int) (20 + (hour - 1) * 10);

    }

    public int CarFee (Ticket ticket) {

        if (ticket.getVehicle().getType() != VehicleType.CAR) {

            return 0;
        }

        long hour = Hour(ticket);

        if (hour <= 1) {
            return 50;
        }
        return (int) (50 + (hour - 1) * 30);

    }

    public int TruckFee (Ticket ticket) {

        if (ticket.getVehicle().getType() != VehicleType.TRUCK) {

            return 0;
        }

        long hour = Hour(ticket);

        if (hour <= 1) {
            return 20;
        }
        return (int) (100 + (hour - 1) * 50);

    }
}