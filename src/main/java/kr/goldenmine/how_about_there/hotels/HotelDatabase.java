package kr.goldenmine.how_about_there.hotels;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelDatabase")
public class HotelDatabase {
    List<Hotel> hotels;

    public HotelDatabase() {

    }
}
