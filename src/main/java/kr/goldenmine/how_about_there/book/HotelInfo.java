package kr.goldenmine.how_about_there.book;

import kr.goldenmine.how_about_there.book.HotelBookInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelInfo {
    private String hotelName;

    private HashMap<Integer, HotelBookInfo> bookInfoList; // Map<roomId, info>

    public HotelInfo(String hotelName) {
        this.hotelName = hotelName;
        this.bookInfoList = new HashMap<>();

        bookInfoList.put(101, new HotelBookInfo(101));
        bookInfoList.put(102, new HotelBookInfo(102));
        bookInfoList.put(103, new HotelBookInfo(103));
        bookInfoList.put(104, new HotelBookInfo(104));
        bookInfoList.put(105, new HotelBookInfo(105));
        bookInfoList.put(201, new HotelBookInfo(201));
        bookInfoList.put(202, new HotelBookInfo(202));
        bookInfoList.put(203, new HotelBookInfo(203));
        bookInfoList.put(204, new HotelBookInfo(204));
        bookInfoList.put(205, new HotelBookInfo(205));
    }

    public HashMap<Integer, HotelBookInfo> getBookInfoList() {
        return bookInfoList;
    }
}
