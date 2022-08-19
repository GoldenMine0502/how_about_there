package kr.goldenmine.how_about_there.hotels;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@Service("hotelDatabase")
public class HotelDatabase {
    List<Hotel> hotels;

    public HotelDatabase() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Hotel>>() {}.getType();

        hotels = gson.fromJson(new InputStreamReader(HotelDatabase.class.getResourceAsStream("/data/hotels.json")), type);
    }
}
