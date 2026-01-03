public class ParkingSlot {

    private int slotNumber;
    private SlotType slotType;
    private boolean isOccupied;

    public ParkingSlot(int slotNumber , SlotType slot){

        this.slotNumber = slotNumber;
        this.slotType = slot;
        this.isOccupied = false;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void occupy(){
        this.isOccupied = true;
    }

    public void vacate(){
        this.isOccupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean canFit(Vehicle vehicle) {
        return this.slotType.getSize()>= vehicle.getRequiredSlotType().getSize();
    }
}

