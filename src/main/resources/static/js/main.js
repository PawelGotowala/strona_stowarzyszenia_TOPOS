$( document ).ready(function() {

    const meetingPhotos = [
        'static/assets/meeting/Clipboard002.jpg',
        'static/assets/meeting/Clipboard003.jpg',
        'static/assets/meeting/Clipboard001.jpg',
        'static/assets/meeting/Clipboard004.jpg',
        'static/assets/meeting/Clipboard005.jpg',
        'static/assets/meeting/Clipboard006.jpg',
        'static/assets/meeting/Clipboard007.jpg',
        'static/assets/meeting/Clipboard008.jpg',
        'static/assets/meeting/Clipboard009.jpg',
        'static/assets/meeting/Clipboard010.jpg',
        'static/assets/meeting/Clipboard011.jpg',
        'static/assets/meeting/Clipboard012.jpg',
        'static/assets/meeting/Clipboard013.jpg',
        'static/assets/meeting/Clipboard014.jpg',
        'static/assets/meeting/Clipboard015.jpg',
        'static/assets/meeting/Clipboard016.jpg',
        'static/assets/meeting/Clipboard017.jpg',
        'static/assets/meeting/Clipboard018.jpg',
        'static/assets/meeting/Clipboard019.jpg',
        'static/assets/meeting/Clipboard020.jpg',
        'static/assets/meeting/Clipboard021.jpg',
        'static/assets/meeting/Clipboard022.jpg',
        'static/assets/meeting/Clipboard023.jpg'
    ];

	
    const aboutPhotoContainer = $('.about-photo');

    let photoIndex = 0;

    const photoInterval = setInterval(function() {
        if(photoIndex > meetingPhotos.length - 1) {
            photoIndex = 0;
        }
        aboutPhotoContainer.css('background-image', 'url(' + meetingPhotos[photoIndex] + ')');
        photoIndex++;
        setTimeout(function() {
            aboutPhotoContainer.removeClass('opacity-0');
        }, 1000);
        setTimeout(function() {
            aboutPhotoContainer.addClass('opacity-0');
        }, 9000);
    }, 10000);

    //zmieniajac czas w linii 45 oraz 46 możesz regulować tempo wyświelania zdjec


    // nawigacja menu przy małych ekranach
    const hamburger = document.querySelector('.hamburger');
    const nav = document.querySelector('nav');
    let clickCount = 0;
    hamburger.addEventListener('click', function() {
        if(clickCount === 0) {
            nav.classList.add('mobile-menu');
            hamburger.innerHTML = '<i class="fas fa-times"></i>';
            clickCount++;
        } else {
            nav.classList.remove('mobile-menu');
            hamburger.innerHTML = '<i class="fas fa-bars"></i>';
            clickCount--;
        }
    }); 

    nav.addEventListener('click', function(e) {
        if(e.target.hasAttribute('href')) {
            nav.classList.remove('mobile-menu');
            hamburger.innerHTML = '<i class="fas fa-bars"></i>';
            clickCount--;
        }
    });
});