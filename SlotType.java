public enum SlotType {

    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int size;

    SlotType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
