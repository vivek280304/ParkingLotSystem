import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

     private final List<ParkingSlot> lot ;
    private final Map<String,Ticket> activeTickets ;

    public ParkingLot(){
        this.lot = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        createLot();
    }

    private void createLot(){

        int slot = 1;

//      Bike slot  10
        for (int i = 0; i < 10; i++) {
            lot.add(new ParkingSlot(slot++,SlotType.SMALL));
        }

//      Car slot  5
        for (int i = 0; i < 5; i++) {
            lot.add(new ParkingSlot(slot++,SlotType.MEDIUM));
        }

//      Truck slot 2
        for (int i = 0; i < 2; i++) {
            lot.add(new ParkingSlot(slot++,SlotType.LARGE));
        }
    }


    public Ticket parkVehicle(Vehicle vehicle){

      for (ParkingSlot slot : lot ){

          if(slot.isAvailable() && slot.canFit(vehicle)){

              slot.occupy();
              Ticket ticket = new Ticket(vehicle,slot);
              activeTickets.put(ticket.getTicketId(),ticket);

              return ticket;
          }
        }
        throw new RuntimeException("Parking full for "+ vehicle.getType());
    }

    public void unPark(String ticketId){

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            throw new RuntimeException("Invalid TIcket id");
        }

        ParkingSlot slot = ticket.getSlot();
        slot.vacate();

        ticket.closeTicket();
        activeTickets.remove(ticketId);

    }

    public   Ticket getTicket(String id){
        return activeTickets.get(id);
    }
}
