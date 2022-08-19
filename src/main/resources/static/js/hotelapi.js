const SERVER_URL = "http://minecraft.goldenmine.kr:9999";
// http://web.goldenmine.kr:9999

let getHotels = () => {
    let elementHotels = document.getElementById("list-box");

    // let formData = new FormData();
    // formData.append("curPage", "1");

    axios.get(SERVER_URL + "/hotel/list?curPage=1").then((response) => {
        let data = response.data

        let totalHTML = "";

        for (let i = 0; i < data.length; i++) {
            let current = "<div class=\"list\" id=\"current" + i + "\">" + data[i].hotelName + "</div>"

            totalHTML += current;
        }

        document.getElementById("hotellist").innerHTML = totalHTML

        // let hotelElements = document.getElementsByClassName("list")

        for (let i = 0; i < data.length; i++) {
            document.getElementById("current" + i).addEventListener("click", () => loadHotelAndRoute(data[i].hotelName));
        }
    }).catch((error) => {

    });
}

let loadHotelAndRoute = (hotelName) => {
    localStorage.setItem("hotelName", hotelName)

    // console.log(hotelName)
    location.href = "/room.html"
}

window.onload = () => {
    getHotels()
}