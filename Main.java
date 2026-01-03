import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot  = new ParkingLot();

        while (true) {

            System.out.println();
            System.out.println("===== PARKING LOT MENU =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Un-park Vehicle");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter Vehicle number ");
                    String num = sc.nextLine();

                    System.out.println("Vehicle Type:");
                    System.out.println("1. BIKE");
                    System.out.println("2. CAR");
                    System.out.println("3. TRUCK");

                    int typeChoice = sc.nextInt();
                    sc.nextLine();

                    VehicleType type;

                    switch (typeChoice){

                        case 1 :
                            type = VehicleType.BIKE;
                            break;
                        case 2 :
                            type = VehicleType.CAR;
                            break;
                        case 3 :
                            type = VehicleType.TRUCK;
                            break;

                        default:
                            System.out.println("INVALID vehicle type");
                            continue;

                    }
                    Vehicle vehicle = new Vehicle(num,type) ;

                        try {
                            Ticket ticket = parkingLot.parkVehicle(vehicle);
                            System.out.println("-----------------------------------------");
                            System.out.println("Vehicle parked");
                            System.out.println(ticket.getEntryTime());
                            System.out.println("Ticket ID :" + ticket.getTicketId());
                            System.out.println("Slot No : " + ticket.getSlot().getSlotNumber());
                            System.out.println(" VehicleType : " +ticket.getVehicle().getType());
                            System.out.println("-----------------------------------------");
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;

                case 2:
                    System.out.println("Enter Ticket ID");
                    String id = sc.nextLine();

                    try {

                        Ticket ticket = parkingLot.getTicket(id);
                        parkingLot.unPark(id);
                        int amount = 0;

                        FeeCalculation fee = new FeeCalculation();

                        switch (ticket.getVehicle().getType()){

                            case BIKE:
                               amount =  fee.BikeFee(ticket);
                                break;
                            case CAR:
                                amount =  fee.CarFee(ticket);
                                break;
                            case TRUCK:
                                amount = fee.TruckFee(ticket);
                                break;
                        }
                        System.out.println("-----------------------------------------");
                        System.out.println(ticket.getExitTime());
                        System.out.println("Vehicle Un-parked Successfully ");
                        System.out.println("Parking Fee : " + amount);
                        System.out.println("Thanks for Parking");
                        System.out.println("-----------------------------------------");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Thanks for Parking");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}