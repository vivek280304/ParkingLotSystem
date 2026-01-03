public enum VehicleType {

    BIKE(SlotType.SMALL),
    CAR(SlotType.MEDIUM),
    TRUCK(SlotType.LARGE);

    private SlotType requiredSlotType;

    VehicleType(SlotType slotType){
        this.requiredSlotType = slotType;
    }

    public SlotType getRequiredSlotType(){
        return requiredSlotType;
    }


}
