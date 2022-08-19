const SERVER_URL = "http://minecraft.goldenmine.kr:9999";
let hotel = () => {
    let userId = document.getElementById("user-id").value;
    let password = document.getElementById("user-password").value;
    let hotelname = document.getElementById("hotelName").value;
    let roomId = document.getElementById("roomId").value;

    if (password === passwordCheck) {
        axios.post(SERVER_URL + "/auth/register", {
            email: userId,
            password: password,
            hotelname: hotelname,
            roomId: roomId
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
        alert("예약에 실패하였습니다.");
    }
};