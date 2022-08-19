package kr.goldenmine.how_about_there.hotels;

import com.google.gson.annotations.SerializedName;

public class Hotel {
    @SerializedName("BIZPLC_NM")
    private String hotelName;
    @SerializedName("REFINE_ROADNM_ADDR")
    private String addr;
    @SerializedName("WSTROOM_CNT")
    private String roomCnt;
    private String restRoomCnt;

    public Hotel(String hotelName, String addr, String roomCnt) {
        this.hotelName = hotelName;
        this.addr = addr;
        this.roomCnt = roomCnt;
        this.restRoomCnt = roomCnt;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getAddr() {
        return addr;
    }

    public String getRoomCnt() {
        return roomCnt;
    }

    public String getRestRoomCnt() {
        return restRoomCnt;
    }
}
