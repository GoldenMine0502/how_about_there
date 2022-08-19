package kr.goldenmine.how_about_there.book;

import java.util.List;

public class HotelBookInfo {
    private int roomId;
    private List<String> people;

    public HotelBookInfo(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public List<String> getPeople() {
        return people;
    }
}
