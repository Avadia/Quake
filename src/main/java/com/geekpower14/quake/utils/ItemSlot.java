package com.geekpower14.quake.utils;

public enum ItemSlot {
    // http://redditpublic.com/images/b/b2/Items_slot_number.png
    Head("Head", 103),
    Armor("Armor", 102),
    Slot1("Slot1", 0),
    Slot2("Slot2", 1),
    Slot3("Slot3", 2),
    Slot4("Slot4", 3),
    Slot5("Slot5", 4),
    Slot6("Slot6", 5),
    Slot7("Slot7", 6),
    Slot8("Slot8", 7);

    private final String info;
    private final int slot;

    ItemSlot(String info, int slot) {
        this.info = info;
        this.slot = slot;
    }

    public String getInfo() {
        return info;
    }

    public int getSlot() {
        return slot;
    }
}