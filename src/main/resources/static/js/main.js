﻿$( document ).ready(function() {

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
        'static/assets/meeting/Clipboard023.jpg',
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
        }, 600);
        setTimeout(function() {
            aboutPhotoContainer.addClass('opacity-0');
        }, 9000);
    }, 10000);

    //zmieniajac czas w linii 45 oraz 46 możesz regulować tempo wyświelania zdjec

    const toposPeopleList = [
        '001 Katarzyna Dorota Lentas',
        '002 Anna Hols-Rudnicki',
        '003 Krzysztof Leon Grabski',
        '004 Urszula Gertruda Nicoleizig',
        '005 Eleonora Zofia Jerzyk',
        '006 Krystyna Helena Ellwardt',
        '007 Edeltraut Antonina Jasnoch',
        '008 Elfryda Krystyna Gołąbek',
        '009 Manfred Stahmer',
        '010 Barbara Kaczmarowska-Hamilton',
        '011 Jadwiga Orłowska',
        '012 Magdalena Alicja Niklas',
        '013 Marian Wosztal',
        '014 Bożena Stefania Zadroga',
        '015 Elzbieta Dobrowolska',
        '016 Celina Maria Dratkowska',
        '017 Krystyna Katarzyna Stolarska',
        '018 Tomasz Jan Wojtanowski',
        '019 Grażyna Waloch',
        '020 Zofia Irena Trębińska-Zieniuk',
        '021 Magdalena Maria Dziurkowska',
        '022 Mirosława Rybicka',
        '023 Elzbieta Maria Kaźmierczak',
        '024 Maria Teresa Berbeka',
        '025 Marcin Rajmund Wojtanowski',
        '026 Michał Marek Zdun',
        '027 Sławomir Józef Teofil Weber',
        '028 Joanna Elżbieta Zuber',
        '029 Dominika Maria Koprowska',
        '030 Alicja Ewa Kwaśniewska',
        '031 Krystyna Krajkowska',
        '032 Teresa	Maria Augustyn',
        '033 Małgorzata Irena Salwarowska',
        '034 Maria Jolanta Domińczak',
        '035 Andrzej Henryk Gościniecki',
        '036 Marta Iwona Dmochowska',
        '037 Sylwia	Lucyna Amielańczyk',
        '038 Zdzisława Filzek',
        '039 Krzysztof Stasierowski',
        '040 Wiesław Tadeusz Górka',
        '041 Czesław Stanisław Głogowski',
        '042 Grażyna Maria Chmielecki',
        '043 Henryk Jan Chmielecki',
        '044 Zbigniew Andrzej Garsztka',
        '045 Wiesław Stanisław Karpusiewicz',
        '046 Urszula Krystyna Bączkiewicz',
        '047 Roman Piotr Dera',
        '048 Joanna	Barbara Zalewska',
        '049 Ryszard Iwaszczyszyn',
        '050 Ryszard Lipiński',
        '051 Maria Krystyna Lipińska',
        '052 Leszek Zbigniew Klosowiak',
        '053 Artur Józef Albin',
        '054 Katarzyna Zofia Mamel',
        '055 Wojciech Jarosław Sałata',
        '056 Ewa Maria Hermann',
        '057 Irena Masłowska',
        '058 Maria Jolanta Czerniak',
        '059 Barbara Chabowska',
        '060 Jerzy Koniecki',
        '061 Jerzy Adam Sadłowski',
        '062 Alina Leokadia Sadłowska',
        '063 Teresa Maria Deyk',
        '064 Tadeusz Roman Deyk',
        '065 Marek Przybylski',
        '066 Mirosława Barbara Piklikiewicz',
        '067 Ewa Śmiglak',
        '068 Jolanta Barbara Harasim',
        '069 Elżbieta Aniela Pietkiewicz',
        '070 Renata Maria Zalewska',
        '071 Irena Halina Łazuta',
        '072 Jerzy Zalewski',
        '073 Barbara Anna Ledwoń',
        '074 Janusz Jerzy Ledwoń',
        '075 Robert Jacek Ledwoń',
        '076 Jan Krzysztof Malinowski',
        '077 Joanna Lityński',
        '078 Halina Regina Winiarska',
        '079 Bogdan Bolesław Winiarski',
        '080 Elżbieta Krystyna Collingwood',
        '081 Mieczysław Włodzimierz Olszewski',
        '082 Tadeusz Banaszek',
        '083 Jan Jerzy Iwaszczyszyn',
        '084 Jadwiga Łucja Makara',
        '085 Bożena Maria Kolowska',
        '086 Halina Irena Kozłowska',
        '087 Elżbieta Jakubiak',
        '088 Anna Roberta Wood',
        '089 Anna Maria Satora',
        '090 Maria Spisak',
        '091 Alina Janina Lewków',
        '092 Jolanta Książkiewicz',
        '093 Aneta Teresa Zagalak',
        '094 Maria Dominika Tomczak',
        '095 Andrzej Janusz Ignaczak',
        '096 Lucyna Suchołbiak',
        '097 Jolanta Maria Edwards',
        '098 Bogdan Mieczysław Turek',
        '099 Roman Adam Miękina',
        '100 Marzena Teresa Idczak',
        '101 Maria Bernadetta Gołuchowska',
        '102 Ewa Stella Maliszewska',
        '103 Zofia Marta Woźniak',
        '104 Irena Longina Walukiewicz',
        '105 Krzysztof Homik',
        '106 Teresa Małgorzata Orczykowska',
        '107 Jacek Jerzy Kaliszan',
        '108 Krystyna Anna Krzykowska',
        '109 Małgorzata Kulewitz',
        '110 Barbara Ewa Micelska',
        '111 Włodzimierz Kusiak',
        '112 Andrzej Senderacki',
        '113 Joanna Spisak',
        '114 Renata Opechowska',
        '115 Wacław Tadeusz Opechowski',
        '116 Kazimiera Danuta Hallmann',
        '117 Jan Antoni Leszczyk',
        '118 Dorota Maria Czajor',
        '119 Barbara Mirosława Sowa',
        '120 Janusz Zdzisław Sowa',
        '121 Joanna	Anita Gogielis',
        '122 Sylwestra Gabriela Łukaszewicz',
        '123 Bogusław Piotr Łukaszewicz',
        '124 Ewa Lilla Lisiecka',
        '125 Wojciech Stanisław Wróbel',
        '126 Józef Bogumił Kędzierski',
        '127 Krzysztof Jerzy Kwiatkowski',
        '128 Maria Bożena Moder',
        '129 Olena Barbara Rebow',
        '130 Ewa Dorota Baczyk-Remus',
        '131 Mariola Maria Kwiatkowska',
        '132 Ryszard Wiesław Pomirski-Kwieciński',
        '133 Maria Turecka',
        '134 Janina Felicja Kulczycka',
        '135 Zygmunt Lorenc',
        '136 Janusz Kazimierz Lippert',
        '137 Marek Stanisław Mardziński',
        '138 Jerzy Józef Gościniecki',
        '139 Ryszard Norbert Bork',
        '140 Waldemar Leszek Stępniewski',
        '142 Jolanta Popiołek',
        '143 Maria Jolanta Marzec',
        '144 Ewa Maria Kalińska',
        '145 Anna Maria Borońska',
        '146 Andrzej Zdzisław Boroński',
        '147 Mirosław Pawłowski',
        '148 Anna Monika Wojtunik',
        '149 Bożena Julianna Dąbrowska',
        '150 Alina Emilia Sarnik',
        '151 Michał Szymanowski',
        '152 Elżbieta Mariola Maj',
        '153 Mirosław Korpuliński',
        '154 Anita Maria Badowska',
        '155 Marzena Magdalena Pilch',
        '156 Adam Wojciech Pilch',
        '157 Maria Jolanta Stukan',
        '158 Zbigniew Piotr Karpusiewicz',
        '159 Izabela Anna Glonke',
        '160 Wojciech Andrzej Pioch',
        '161 Krzysztof Stnisław Maciąg',
        '162 Joanna Małgorzata Paszulka',
        '163 Anna Alina Krzyżak',
        '164 Barbara Kromski',
        '165 Lidia Barbara Składanek',
        '166 Marek Krupiński',
        '167 Anna Banaszuk',
        '168 Joanna Sperska',
        '169 Krzysztof Władysław Gier',
        '170 Mariola Stenzel',
        '171 Joanna Małgorzata Kramska',
        '172 Andrzej Wendyński',
        '173 Jolanta Stefania Gałek',
        '174 Barbara Lewicka',
        '175 Anna Zofia Jendrych',
        '176 Bożena Elżbieta Koć',
        '177 Jarosław Bata',
        '178 Ewa Joanna Ignaczak-Bata',
        '179 Elżbieta Talaśka',
        '180 Teresa Sampolska',
        '181 Krzysztof Dariusz Kessler',
        '182 Jadwiga Irena Kowalczyk',
        '183 Barbara Maria Klonowska',
        '184 Krystyna Dembicka',
        '185 Wojciech Władysław Walczyk',
        '186 Małgorzata Grzęda-Romstad',
        '187 Ewa Bronisława Chludzińska',
        '188 Mariola Szulc',
        '189 Paweł Semmerling',
        '190 Krzysztof Szuba',
        '191 Ewa Krystyna Bobrowska',
        '192 Eliza Serafina Laskowska',
        '193 Ewa Talaśka',
        '194 Kinga Janas',
        '195 Irena Janina Gliniecka',
        '196 Marek Tadeusz Bieszczanin',
        '197 Zbigniew Henryk Wyszomirski',
        '198 Barbara Krystyna Semmerling',
        '199 Jadwiga Teresa Zimna',
        '200 Iwona Tecław',
        '201 Ewa Morka',
        '202 Anna Dończyk',
        '203 Andrzej Semmerling',
        '204 Zbigniew Miszczak',
        '205 Józef Łodziana',
        '206 Wojciech Śliwecki',
        '207 Jolanta Teresa Rozborska',
        '208 Barbara Maria Janaczyk',
        '209 Jarosława Bowszys',
        '210 Anna Dorota Łukaszewska',
        '211 Mirosława Joanna Tange',
        '212 Stefania Anastazja Wiśniewska',
        '213 Anna Barbara Okońska',
        '214 Witold Mieczysław Maniecki',
        '215 Ryszard Stanisław Budzyński',
        '216 Aleksandra Maria Śliwa',
        '217 Violetta Karnowska',
        '218 Jacek Zdzisław Sokół',
        '219 Dariusz Marek Leśniak',
        '220 Arseniusz Krzysztof Graliński',
        '221 Wiesława Jadwiga Krawczyk	-Żurawska',
        '222 Jolanta Antonina Lewandowska',
        '223 Marek Jacek Seweryński',
        '224 Ewa Janina Ankiewicz',
        '225 Janina Krystyna Kruszyńska',
        '226 Marzena Bogumiła Zocholl',
        '227 Bożena Urszula Lipczyńska',
        '228 Jacek Marek Hoffman',
        '229 Jolanta Janina Mucha',
        '230 Stanisław Jan Doms',
        '231 Adam Aleksander Popiołek',
        '232 Julia Ehlert',
    ];

    const toposPeopleListSorted = toposPeopleList.sort();
    const toposListContainer = document.querySelector('.people-list');

    for(let i = 0; i < toposPeopleListSorted.length; i++){
        toposListContainer.innerHTML += '<p>' + toposPeopleList[i] + '</p>';
        console.log(i);
    }


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