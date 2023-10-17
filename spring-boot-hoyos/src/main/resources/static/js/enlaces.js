
$(document).ready(function () {


    $.ajax({
        type: 'GET',
        url: "todosEnlace"


    }).done(function (data) {
        console.log('Estos son los enlaces que recibimos', data);

        for (var i = 0; i < data.length; i++) {
            if (data[i].tipo == 'Comercio') {
                var html = '';
                html += "<button href='' style='font-weight: 600;' onclick=mostraEnlace(" + data[i].id + "); class='list-group-item list-group-item-action'>" + data[i].nombre.toUpperCase() + "</button>";
                html += "<div id=" + data[i].id + " style='display:none; padding-top: 4%;'>";
                html += '</div>';
                $('#Comercios').append(html);
            }
            if (data[i].tipo == 'Asociacion') {
                var html = '';
                html += "<button href='' style='font-weight: 600;' onclick=mostraEnlace(" + data[i].id + "); class='list-group-item list-group-item-action'>" + data[i].nombre + "</button>";
                html += "<div id=" + data[i].id + " style='display:none; padding-top: 4%;'>";
                html += '</div>';

                $('#Asociaciones').append(html);
            }
            if (data[i].tipo == 'Vecino') {
                var html = '';
                html += "<button href='' style='font-weight: 600;' onclick=mostraEnlace(" + data[i].id + "); class='list-group-item list-group-item-action'>" + data[i].nombre + "</button>";
                html += "<div id=" + data[i].id + " style='display:none; padding-top: 4%;'>";
                html += '</div>';
                $('#Vecinos').append(html);
            }
            if (data[i].tipo == 'CasaRural') {
                var html = '';
                html += "<button href='' style='font-weight: 600;' onclick=mostraEnlace(" + data[i].id + "); class='list-group-item list-group-item-action'>" + data[i].nombre + "</button>";
                html += "<div id=" + data[i].id + " style='display:none; padding-top: 4%;'>";
                html += '</div>';
                $('#CasaRural').append(html);
            }
        }
    }).fail(function () {
        console.log("Fallo!");
    })
        .always(function () {
            console.log("Completo!");
        });;
});

function mostraEnlace(obj) {

    console.log('Entramos en mostrar enlace', obj);
    var idEnlace = obj;
    $.ajax({
        type: 'GET',
        url: "unEnlace",
        //url: "https://cuevas-de-ayllon.com/salvarcomentario",
        data: {

            'idEnlace': idEnlace,

        },

    }).done(function (objetos) {

        console.log('Recibimos este objeto', objetos);
        $(obj).empty();
        var html = '';
        html += '<div  style="font-weight: 500;margin:4%">';
        html += '<div class="row" >';
        html += '<div >';
        if (objetos.nombre != null) {

            html += "<p>  " + objetos.nombre;

        }
        if (objetos.apellidos != null) {

            html +=" "+ objetos.apellidos + "</p>";

        }
        html += '</div>';
        html += '</div>';
        

        if (objetos.telefono != null) {
            html += '<div class="row" >';
            html += '<div >';
            html += "<p>Telefono: " + objetos.telefono + "</p>";
            html += '</div>';
            html += '</div>';
        }


        
        

        if (objetos.direccion != null) {
            html += '<div class="row" >';
            html += '<div >';
            html += "<p>Dirección: " + objetos.direccion + "</p>";
            html += '</div>';
            html += '</div>';
            

        }
        if (objetos.mail != null) {
            html += '<div class="row" >';
            html += '<div >';
            html += "<p> " + objetos.mail + "</p>";
            html += '</div>';
            html += '</div>';
            

        }
        if (objetos.texto1 != null) {
            html += '<div class="row">';
            html += '<div >';
            html += "<p>" + objetos.texto1 + "</p>";
            html += '</div>';
            html += '</div>';
            

        }
        if (objetos.texto2!= null) {
            html += '<div class="row" >';
            html += '<div >';
            html += "<p>" + objetos.texto2 + "</p>";
            html += '</div>';
            html += '</div>';
            

        }
        if (objetos.texto3!= null) {
            html += '<div class="row" >';
            html += '<div >';
            html += "<p>" + objetos.texto3 + "</p>";
            html += '</div>';
            html += '</div>';
            

        }


       
       

        

        

        html += '<div class="row" >';

        if (objetos.foto1 != null&&objetos.foto2 == null) {
            html += '<div class="col-auto">';

            html += "<img src='/spring-boot-hoyos/uploadsEnlaces/" + objetos.foto1 + "' class=' w-100 responsive'  alt='...'>";

            html += '</div>';
        } if (objetos.foto1 != null&&objetos.foto2 != null) {
            html += '<div class="col-6">';

            html += "<img src='/spring-boot-hoyos/uploadsEnlaces/" + objetos.foto1 + "' class=' w-100 responsive'  alt='...'>";

            html += '</div>';
       
            html += '<div class="col-6">';

            html += "<img src='/spring-boot-hoyos/uploadsEnlaces/" + objetos.foto2 + "' class='d-block w-100'  alt='...'>";

            html += '</div>';
        }

        html += '</div>';
        if (objetos.enlaceweb != null) {
            html += '<divclass="row">';
            html += '<div >';
            html += "<a class='link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover' href='" + objetos.enlaceweb + "'>Enlace web</a>";
            html += '</div>';
            html += '</div>';
        }
        html += '</div>';
        $(obj).append(html);




    }
        // }

        // }

    ).fail(function () {
        console.log("Fallo!");
    })
        .always(function () {
            console.log("Completo!");
        });;
    var obj = document.getElementById(obj);




    if (obj.style.display == "block") obj.style.display = "none";
    else obj.style.display = "block";



};











