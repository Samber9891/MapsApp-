
      let map;
      
      
      
      function initMap() {
        let image = {url: 'images/lonestar2.jpg', 
        scaledSize: new google.maps.Size(50, 50)};

        map = new google.maps.Map(document.getElementById('map'), {
          center: coords,
          zoom: 10, 
          scrollwheel:false,
        });

            marker = new google.maps.Marker({
            position: coords,
            map: map,
            icon : image,
            draggable:true,
            title:"Drag me!",
            animation: google.maps.Animation.DROP, 
        });

        let contentString = '<h2>' + city + ', ' + state + '</h2>';

        let infowindow = new google.maps.InfoWindow({
          content: contentString
        });
       
        google.maps.event.addListener(marker, 'click', function() {
           infowindow.open(map,marker);
        });

       
      }
 