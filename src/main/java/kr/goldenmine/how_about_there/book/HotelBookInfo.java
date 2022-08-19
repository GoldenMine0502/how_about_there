package kr.goldenmine.how_about_there.book;

import java.util.ArrayList;
import java.util.List;

public class HotelBookInfo {
    private int roomId;
    private List<String> people;

    public HotelBookInfo(int roomId) {
        this.roomId = roomId;
        this.people = new ArrayList<>();
    }

    public int getRoomId() {
        return roomId;
    }

    public List<String> getPeople() {
        return people;
    }
}
