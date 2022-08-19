const SERVER_URL = "http://minecraft.goldenmine.kr:9999";
// http://web.goldenmine.kr:9999

let getHotels = () => {
    let elementHotels = document.getElementById("list-box");

    let page = localStorage.getItem("page")

    // let formData = new FormData();
    // formData.append("curPage", "1");

    axios.get(SERVER_URL + "/hotel/list?curPage=" + page).then((response) => {
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

let previousPage = () => {
    let page = parseInt(localStorage.getItem("page"))
    if(page > 1) {
        page = page - 1;
    }
    localStorage.setItem("page", String(page));

    getHotels()
}

let nextPage = () => {
    let page = parseInt(localStorage.getItem("page"))
    if(page < 100) {
        page = page + 1;
    }
    localStorage.setItem("page", String(page));

    getHotels()
}

window.onload = () => {
    localStorage.setItem("page", "1")
    getHotels()

    let previous = document.getElementById("previous")
    let next = document.getElementById("next")

    if(previous != null) {
        previous.addEventListener('click', previousPage)
    }

    if(next != null) {
        next.addEventListener('click', nextPage)
    }
}