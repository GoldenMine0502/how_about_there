const SERVER_URL = "http://localhost:9999";
let register = () => {
    let userId = document.getElementById("user-id").value;
    let password = document.getElementById("user-password").value;
    let nickname = document.getElementById("user-nickname").value;
    let gender = document.getElementById("user-gender").value;

    if (password === passwordCheck) {
        axios.post(SERVER_URL + "/auth/register", {
            email: userId,
            password: password,
            nickname: nickname,
            gender: gender
        })
            .then((response) => {
                if (response.status === 201) {
                    saveToken(response.data["token"]);
                }
            })
            .catch((error) => {
                alert(error.response.data["message"]);
            });
    } else {
        alert("올바르지 않은 양식입니다.");
    }
};