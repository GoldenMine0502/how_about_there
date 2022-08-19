package kr.goldenmine.how_about_there.users;

public class User {
    private String id;
    private String password;

    private String nickname;

    private String gender;

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

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
