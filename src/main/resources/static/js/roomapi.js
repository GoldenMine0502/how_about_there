const SERVER_URL = "http://minecraft.goldenmine.kr:9999";

let getRoomData = () => {
    let hotelName = localStorage.getItem("hotelName")

    console.log("hotelName: " + hotelName);

    document.getElementById("hotelname").innerHTML = hotelName;

    axios.get(SERVER_URL + "/hotel/state?hotelName=" + hotelName).then((response) => {
        console.log(response.data["bookInfoList"])

        let list = response.data["bookInfoList"]

        let totalHTML = ""

        for (const [key, value] of Object.entries(list)) {
            console.log(key, value);

            let tag =
                "<div class=\"list\">" +
                "<div class=\"text\" id='room" + key + "'>" +
                "<h2>" + key + "호</h2>" +
                "<ul>" +
                "<li>4인실</li>" +
                "<li>"+ value["people"] + "</li>" +
                "</ul>" +
                "</div>" +
                "<div class=\"image\">" +
                "<img src=\"./image/bed.jpg\">" +
                "</div>" +
                "</div>"

            totalHTML += tag;
        }

        document.getElementById("roomlist").innerHTML = totalHTML;

        for (const [key, value] of Object.entries(list)) {
            document.getElementById("room" + key).addEventListener("click", () => loadRoomAndRoute(key));
        }
    }).catch((error) => {

    });
}

let loadRoomAndRoute = (roomId) => {
    localStorage.setItem("roomId", roomId)

    location.href="/reservation.html"
}

window.onload = () => {
    getRoomData()
}