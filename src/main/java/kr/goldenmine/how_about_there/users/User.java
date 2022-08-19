package kr.goldenmine.how_about_there.users;

public class User {
    String id;
    String password;

    String nickname;

    String gender;

    public User(String id, String password, String nickname, String gender) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
    }

    public User withoutPassword() {
        User user = new User(id, null, nickname, gender);

        return user;
    }
}
