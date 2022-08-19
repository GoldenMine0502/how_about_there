package kr.goldenmine.how_about_there.hotels;

import com.google.gson.JsonObject;
import kr.goldenmine.how_about_there.hotels.HotelDatabase;
import kr.goldenmine.how_about_there.users.User;
import kr.goldenmine.how_about_there.users.UserDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/register")
    public ResponseEntity<Object> register(String id, String password, String nickname, String gender) {
        Optional<User> user = userDatabase.register(id, password, nickname, gender);

        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(String id, String password) {
        Optional<User> user = userDatabase.login(id, password);

        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().withoutPassword());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/userinfo")
    public ResponseEntity<User> userInfo(String id) {
        Optional<User> user = userDatabase.getUserById(id);

        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().withoutPassword());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
