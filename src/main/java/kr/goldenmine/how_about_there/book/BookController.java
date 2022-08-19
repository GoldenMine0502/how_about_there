package kr.goldenmine.how_about_there.book;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.goldenmine.how_about_there.hotels.Hotel;
import kr.goldenmine.how_about_there.hotels.HotelDatabase;
import kr.goldenmine.how_about_there.users.User;
import kr.goldenmine.how_about_there.users.UserDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class BookController {
    public static final int HOTEL_MAX = 4;

    private final HotelDatabase hotelDatabase;
    private final UserDatabase userDatabase;

    private final HotelBookDatabase hotelBookDatabase;

    private final Gson gson = new Gson();

    public BookController(HotelDatabase hotelDatabase, UserDatabase userDatabase, HotelBookDatabase hotelBookDatabase) {
        this.hotelDatabase = hotelDatabase;
        this.userDatabase = userDatabase;
        this.hotelBookDatabase = hotelBookDatabase;
    }

    @GetMapping("/state")
    public ResponseEntity<HotelInfo> getHotelState(String hotelName) {
        HotelInfo info = hotelBookDatabase.getHotelBooks().computeIfAbsent(hotelName, HotelInfo::new);

        return ResponseEntity.status(HttpStatus.OK).body(info);
    }

    @PostMapping("/book")
    public ResponseEntity<HotelInfo> book(String id, String password, String hotelName, int roomId) {
//        System.out.println(id);
//        System.out.println(password);
        Optional<User> user = userDatabase.login(id, password);

        if(user.isPresent()) {
            HotelInfo info = hotelBookDatabase.getHotelBooks().computeIfAbsent(hotelName, HotelInfo::new);

            HotelBookInfo bookInfo = info.getBookInfoList().computeIfAbsent(roomId, HotelBookInfo::new);

            if(bookInfo.getPeople().size() < HOTEL_MAX) {
                if(!bookInfo.getPeople().contains(id)) {
                    bookInfo.getPeople().add(id);

                    return ResponseEntity.status(HttpStatus.OK).body(info);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Hotel>> hotelList(@PathParam("curPage") String curPage) {
        List<Hotel> hotelList;
        if (curPage == null) {
            hotelList = hotelDatabase.getAllHotel();

            return ResponseEntity.status(200).body(hotelList);
        } else {
            hotelList = hotelDatabase.getHotelPaging(Integer.parseInt(curPage));
        }
        return ResponseEntity.status(200).body(hotelList);
    }
}
