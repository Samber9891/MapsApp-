let map;


function initMap() {
    let image = {url: '/styles/bus.png', 
    scaledSize: new google.maps.Size(50, 50)};

    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: parseFloat(busLocations[0].LATITUDE), lng: parseFloat(busLocations[0].LONGITUDE) },
        zoom: 15,
        scrollwheel: false
    });
	
    for (i=0; i<busLocations.length; i++){
        let marker = new google.maps.Marker({
            position: { lat: parseFloat(busLocations[i].LATITUDE), lng: parseFloat(busLocations[i].LONGITUDE) },
            map: map,
            icon : image, 
        });
    }
    for (i=0; i<busLocations.length; i++){
        let marker = new google.maps.Marker({
            position: { lat: parseFloat(personLocation[i].LATITUDE), lng: parseFloat(personLocation[i].LONGITUDE) },
            map: map, 
        });
    }

    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(VEHICLE);
     });
}