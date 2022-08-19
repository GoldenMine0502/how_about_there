const SERVER_URL = "http://minecraft.goldenmine.kr:9999";

let reservation = () => {
    let hotelName = document.getElementById("hotelName")
    let roomId = document.getElementById("roomId")

    let data = new FormData();
    data.append("id", localStorage.getItem("id"));
    data.append("password", localStorage.getItem("password"));
    data.append("hotelName", hotelName.value);
    data.append("roomId", roomId.value);

    axios.post(SERVER_URL + "/hotel/book", data).then((response) => {
        if(response.status === 200) {
            location.href = '/room.html'
        } else {
            alert("로그인을 안했거나.. 이미 똑같은 호실에 등록을 했습니다.")
        }
        console.log(response)
    }).catch((error) => {

    });
}

window.onload = () => {
    let hotelName = document.getElementById("hotelName")
    let roomId = document.getElementById("roomId")

    hotelName.value = localStorage.getItem("hotelName")
    roomId.value = localStorage.getItem("roomId")

    let button = document.getElementById("submit")
    if(button != null) {
        button.addEventListener("click", reservation)
    }
}