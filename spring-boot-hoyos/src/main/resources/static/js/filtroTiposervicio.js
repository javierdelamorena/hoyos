


// var pagina = 0;
// let observador;

// let producto;
// $('#myInput').change(function () {
//     observador = new IntersectionObserver((entradas) => {
//         entradas.forEach(entradas => {
//             if (entradas.isIntersecting) {
//                 pagina++;
//                 cargar();
//             }

//         })
//         console.log(entradas);

//     }, {

//         rootMargin: '0px 0px 0px 0px',
//         threshole: 1.0
//     });
//     if (producto) {
//         observador.unobserve(producto);
//     }


//     const alturas = document.querySelectorAll('#altura');
//     producto = alturas[alturas.length - 1];
//     console.log(producto);

//     observador.observe(producto);
// })
// function cargar() {
//     $.ajax({
//         type: 'GET',
//         url: "tipoServicio",
//         //url: "https://cuevas-de-ayllon.com/salvarcomentario",
//         data: {'page':pagina, 'tipoServicio': $('#myInput').val() },

//     }).done(function (objetos) {
//         var x = $("#ofertas").empty();
//         console.log(objetos);
//         var html = '';
//         html += '<div class="row g-3" style="margin-top: 3%;">';
//         html += '<div class="col-auto">';
//         html += '<label for="precioMinimo" class="form-label">Precio Minimo</label>';
//         html += '<input type="number" value="0" class="form-control" id="precioMinimo" placeholder="precio min">';
//         html += '</div>'
//         html += '<div class="col-auto">';
//         html += '<label for="precioMaximo" class="form-label">Precio Maximo</label>';
//         html += '<input type="number" value="0" class="form-control" id="precioMaximo" placeholder="precio max">';
//         html += '</div>'
//         html += '<div class="col-auto">';

//         html += '<button class="btn btn-primary mb-3" id="filtrarPrecio" onclick="myFunction()" style="margin-top: 23%;">Filtrar por Precio</button>';
//         html += '</div>';
//         html += '</div>';

//         for (var i = 0; i < objetos.length; i++) {


//             if (objetos[i].tipo_servicio == 'Venta') {

//                 html += '<div id="altura">';
//                 html += '<div class="row" style="margin-top: 7%;">';
//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += '</div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se vende: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';




//             }
//             if (objetos[i].tipo_servicio == 'Compra') {
//                 html += '<div id="altura">';

//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += '</div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se compra: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';




//             }
//             if (objetos[i].tipo_servicio == 'Servicios') {
//                 html += '<div id="altura">';

//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += ' </div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se ofrece: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';
//                 html += '</div>';

//             }
//             if (objetos[i].tipo_servicio == 'Alquiler') {

//                 html += '<div id="altura">';
//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += ' </div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se alquila: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';


//             }


//         }

//         $('#ofertas').append(html);

//     }


//     ).fail(function () {
//         console.log("Fallo!");
//     })
//         .always(function () {
//             console.log("Completo!");
//         });;




// };

// function myFunction() {

//     console.log('pulsamos boton tipo', $('#myInput').val(), ' precio max ', $('#precioMinimo').val(), ' precio min', $('#precioMaximo').val());
//     $.ajax({
//         type: 'GET',
//         url: "mercadilloPaginasPreciosTipoServicio",
//         //url: "https://cuevas-de-ayllon.com/salvarcomentario",
//         data: {
//             'page': pagina, 'tipoServicio': $('#myInput').val(),
//             'precioMin': $('#precioMinimo').val(),
//             'precioMax': $('#precioMaximo').val()
//         },

//     }).done(function (objetos) {
//         var x = $("#ofertas").empty();
//         console.log(objetos);
//         var html = '';


//         for (var i = 0; i < objetos.length; i++) {


//             if (objetos[i].tipo_servicio == 'Venta') {
//                 html += '<div id="altura">';
//                 // html += '<div class="row g-3" style="margin-top: 3%;">';
//                 // html += '<div class="col-auto">';                   
//                 // html += '<input type="number" value="0" class="form-control" id="precioMinimo" placeholder="precio min">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html += '<input type="number" value="0" class="form-control" id="precioMaximo" placeholder="precio max">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html+= '<button class="btn btn-primary mb-3" >Filtrar por Precio</button>';
//                 // html+= '</div>';
//                 // html+= '</div>';
//                 html += '<div class="row" style="margin-top: 7%;">';
//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += '</div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se vende: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';




//             }
//             if (objetos[i].tipo_servicio == 'Compra') {
//                 // html += '<div class="row g-3" style="margin-top: 3%;">';
//                 // html += '<div class="col-auto">';                   
//                 // html += '<input type="number" value="0" class="form-control" id="precioMinimo" placeholder="precio min">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html += '<input type="number" value="0" class="form-control" id="precioMaximo" placeholder="precio max">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html+= '<button class="btn btn-primary mb-3" >Filtrar por Precio</button>';
//                 // html+= '</div>';
//                 // html+= '</div>';
//                 html += '<div id="altura">';
//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += '</div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se compra: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';




//             }
//             if (objetos[i].tipo_servicio == 'Servicios') {
//                 // html += '<div class="row g-3" style="margin-top: 3%;">';
//                 // html += '<div class="col-auto">';                   
//                 // html += '<input type="number" value="0" class="form-control" id="precioMinimo" placeholder="precio min">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html += '<input type="number" value="0" class="form-control" id="precioMaximo" placeholder="precio max">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html+= '<button class="btn btn-primary mb-3" >Filtrar por Precio</button>';
//                 // html+= '</div>';
//                 // html+= '</div>';
//                 html += '<div id="altura">';
//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += ' </div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se ofrece: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';

//             }
//             if (objetos[i].tipo_servicio == 'Alquiler') {
//                 // html += '<div class="row g-3" style="margin-top: 3%;">';
//                 // html += '<div class="col-auto">';                   
//                 // html += '<input type="number" value="0" class="form-control" id="precioMinimo" placeholder="precio min">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html += '<input type="number" value="0" class="form-control" id="precioMaximo" placeholder="precio max">';
//                 // html += '</div>'
//                 // html += '<div class="col-auto">';                    
//                 // html+= '<button class="btn btn-primary mb-3" id="filtrarPrecio" onclick="myFunction()">Filtrar por Precio</button>';
//                 // html+= '</div>';
//                 // html+= '</div>';
//                 html += '<div id="altura">';
//                 html += '<div class="row" style="margin-top: 7%;">';

//                 html += '<div class="col-lg-5" style="margin-top: 3%; float:left">';
//                 html += '<div id="carouselExampleControls' + objetos[i].id + '" class="carousel slide" data-bs-ride="carousel">';
//                 html += '<div class="carousel-inner">';
//                 if (objetos[i].foto1) {
//                     html += '<div class="carousel-item active">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto1 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto2) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto2 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 if (objetos[i].foto3) {
//                     html += '<div class="carousel-item">';

//                     html += "<img src='/spring-boot-hoyos/uploadsMercadillo/" + objetos[i].foto3 + "' class='d-block w-100'  alt='...'>";

//                     html += '</div>';
//                 }
//                 html += '</div>';
//                 html += '<button class="carousel-control-prev" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="prev">';
//                 html += '<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Previous</span>';
//                 html += '</button>';
//                 html += '<button class="carousel-control-next" data-bs-target="#carouselExampleControls' + objetos[i].id + '" role="button" data-bs-slide="next">';
//                 html += '<span class="carousel-control-next-icon" aria-hidden="true"></span>';
//                 html += '<span class="sr-only">Next</span>';
//                 html += '</button>';
//                 html += '</div>';

//                 html += '</div>';
//                 html += '<div class="col-lg-4" style="margin-top: 1%;" id="textoMercadillo">';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;">';
//                 html += '<p >Fecha del anuncio: ' + objetos[i].fecha + '</p>';
//                 html += ' </div>';

//                 html += '<div  "class="col-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">';
//                 html += '<p >Se alquila: ' + objetos[i].nombre_servicio + '</p>';
//                 html += '</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Precio: ' + objetos[i].precio + ' Euros</div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Nombre: ' + objetos[i].nombre + ' </div>';
//                 html += '<div class="col-lg-1" style="width: 100%;font-weight: 600;" id="textoMercadillo">Telefono: ' + objetos[i].telefono + ' </div>';
//                 html += '<div class="col-lg-1" style="display: contents;align-items: center;word-break: break-all; align-items: center; margin: 0 0 1em 1em;">';
//                 html += '<div  style="padding: 3%;">' + objetos[i].texto + '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '</div>';
//                 html += '<hr style="margin-top: 3%;width: 72%;">';


//             }
//         }

//         $('#ofertas').append(html);
//     }

//     ).fail(function () {
//         console.log("Fallo!");
//     })
//         .always(function () {
//             console.log("Completo!");
//         });
// };