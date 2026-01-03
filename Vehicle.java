public  class Vehicle{

    private String Number;
    private VehicleType Type;


    public Vehicle(String Number , VehicleType Type){
        this.Number = Number;
        this.Type =  Type;

    }

   public  String getNumber(){
        return Number;
    }


   public VehicleType getType(){
        return Type;
    }

    public SlotType getRequiredSlotType() {
        return Type.getRequiredSlotType();
    }
}

