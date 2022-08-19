package kr.goldenmine.how_about_there.hotels;

import com.google.gson.JsonObject;
import kr.goldenmine.how_about_there.hotels.HotelDatabase;
import kr.goldenmine.how_about_there.users.User;
import kr.goldenmine.how_about_there.users.UserDatabase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelDatabase hotelDatabase;
    private final UserDatabase userDatabase;

    public HotelController(HotelDatabase hotelDatabase, UserDatabase userDatabase) {
        this.hotelDatabase = hotelDatabase;
        this.userDatabase = userDatabase;
    }

    @PostMapping("/login")
    public String login(String id, String password) throws IOException {
        Optional<User> user = userDatabase.login(id, password);

        JsonObject object = new JsonObject();

        return object.toString();
    }
}
