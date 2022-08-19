package kr.goldenmine.how_about_there.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userDatabase")
public class UserDatabase {
    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        loadAll();
    }

    public Optional<User> register(String id, String password, String nickname, String gender) {
        Optional<User> alreadyExistedUser = getUserById(id);

        if(alreadyExistedUser.isPresent()) {
            return Optional.empty();
        }

        User user = new User(id, password, nickname, gender);
        users.add(user);

        return Optional.of(user);
    }

    public Optional<User> login(String id, String password) {
        return users.stream().filter(it -> it.getId().equals(id) && it.getPassword().equals(password)).findFirst();
    }

    public Optional<User> getUserById(String id) {
        // 비밀번호 제거 후 리턴
        return users.stream().filter(it -> it.getId().equals(id)).map(User::withoutPassword).findFirst();
    }

    public void saveAll() {

    }

    public void loadAll() {

    }
}
