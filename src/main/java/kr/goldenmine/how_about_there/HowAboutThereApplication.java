package kr.goldenmine.how_about_there;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@WebAppConfiguration
public class HowAboutThereApplication {
    // https://howtodoinjava.com/gson/gson-serialazedname/
    /*
    List<User> users = new ArrayList<>();
List<Hodel> Hodels = new ArrayList<>();

gson.fromJson(getReso~~, new TypeToken

User findUser(String id) {
	return users.stream().filter { it.id.equals(id) }.first()

Class Hotel {
	@SerializedName(“SIGUN_NM”);
	String location;
     */

    public static void main(String[] args) {
        SpringApplication.run(HowAboutThereApplication.class, args);
    }

}
