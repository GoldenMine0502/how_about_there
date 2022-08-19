const SERVER_URL = "http://localhost:8080";

let getRoomData = () => {
    let hotelName = localStorage.getItem("hotelName")

    document.getElementById("hotelname").innerHTML = hotelName;

    axios.get(SERVER_URL + "/hotel/state?hotelName=" + hotelName).then((response) => {
        console.log(response.data["bookInfoList"])

        let list = response.data["bookInfoList"]

        let totalHTML = ""

        for (const [key, value] of Object.entries(list)) {
            console.log(key, value);

            let tag = "<div class=\"list\">" +
                "<div class=\"text\">" +
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

        document.getElementsByClassName("room-box")[0].innerHTML = totalHTML;
    }).catch((error) => {

    });
}

window.onload = () => {
    getRoomData()
}