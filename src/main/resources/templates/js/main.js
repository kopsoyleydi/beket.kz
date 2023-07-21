function doFilter(){
    var deperature = document.getElementById("departure");
    var arrival = document.getElementById("arrival");
    var deperatureDate = document.getElementById("departure_date");
}
loadRoads();

function loadRoads(){
    const httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", "http://localhost:8888/roads/getRoadByFilter?departure="+deperature.value+"&arrival="+arrival.value+"&departureDate="+deperatureDate.value+"", true);
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200) {
            let roadsList = JSON.parse(httpRequest.responseText);
            let content = "";
            for (let i = 0; i < roadsList.length; i++) {
                content += "<tr>";
                content += "<th>"+roadsList[i].departure.name+"</th>";
                content += "<th>"+roadsList[i].arrival.name+"</th>";
                content += "<th>"+roadsList[i].departure.stationId.stationName+"</th>";
                content += "<th>"+roadsList[i].departure_date+"</th>";
                content += "</tr>"
            }
            document.getElementById("list").innerHTML = content;
        }
    }
    httpRequest.send();
}