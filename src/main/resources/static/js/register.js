const SERVER_URL = "http://minecraft.goldenmine.kr:9999";
let register = () => {
    let userId = document.getElementById("user-id").value;
    let password = document.getElementById("user-password").value;
    let nickname = document.getElementById("user-nickname").value;
    let gender = document.getElementById("user-gender").value;

    let formData = new FormData();
    formData.append("id", userId);
    formData.append("password", password);
    formData.append("nickname", nickname);
    formData.append("gender", gender);

    axios.post(SERVER_URL + "/auth/register", formData)
        .then((response) => {
            if (response.status === 201) {
                // saveToken(response.data["token"]);
                localStorage.setItem("id", userId)
                localStorage.setItem("password", password)

                location.href='/hotel.html'
            } else {
                alert("이미 같은 아이디가 존재합니다.");
            }
        })
        .catch((error) => {
            // alert(error.response.data["message"]);
        });
};

window.onload = () => {
    let registerButton = document.getElementById("register-btn")

    if(registerButton != null) {
        registerButton.addEventListener('click', register)
    }
}