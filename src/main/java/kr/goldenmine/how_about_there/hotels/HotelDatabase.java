package kr.goldenmine.how_about_there.hotels;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("hotelDatabase")
public class HotelDatabase {

    List<Hotel> hotels;

    public HotelDatabase() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Hotel>>() {
        }.getType();

        hotels = gson.fromJson(new InputStreamReader(HotelDatabase.class.getResourceAsStream("/data/hotels.json")),
            type);
    }

    public List<Hotel> getAllHotel() {
        return hotels;
    }

    public Hotel getHotel(int index) {
        return hotels.get(index);
    }

    public double countAllHotel() {
        return hotels.size();
    }

    public List<Hotel> getHotelPaging(int curPage) {
        int start = (curPage - 1) * 9;
        int finish = (curPage) * 9;
        return hotels.subList(start, finish);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
}
