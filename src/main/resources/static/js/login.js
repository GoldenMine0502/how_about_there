const SERVER_URL = "http://localhost:9999";
let login = () => {
    let userId = document.getElementById("user-id").value;
    let password = document.getElementById("user-password").value;

    axios
        .post(SERVER_URL + "/auth/login", {
            username: userId,
            password: password,
        })
        .then((response) => {
            saveToken(response.data["token"]);
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


