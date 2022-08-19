const SERVER_URL = "http://minecraft.goldenmine.kr:9999";
let login = () => {
    let userId = document.getElementById("user-id").value;
    let password = document.getElementById("user-password").value;

    let formData = new FormData();
    formData.append("id", userId);
    formData.append("password", password);

    axios
        .post(SERVER_URL + "/auth/login", formData)
        .then((response) => {
            // saveToken(response.data["token"]);
            if (response.status === 200) {
                localStorage.setItem("id", userId)
                localStorage.setItem("password", password)

                location.href = "/hotel.html"
            } else {
                alert("로그인 실패");
            }
        })
        .catch((error) => {
            alert(error.response.data["message"]);
        });
};

window.onload = () => {
    let loginBtn = document.getElementById("submit");

    if (loginBtn != null)
        loginBtn.addEventListener("click", login);
}


