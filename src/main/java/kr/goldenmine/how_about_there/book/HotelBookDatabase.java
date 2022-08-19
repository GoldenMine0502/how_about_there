package kr.goldenmine.how_about_there.book;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("hotelBookDatabase")
public class HotelBookDatabase {
    private HashMap<String, HotelInfo> hotelBooks = new HashMap<>();

    public HashMap<String, HotelInfo> getHotelBooks() {
        return hotelBooks;
    }

}
