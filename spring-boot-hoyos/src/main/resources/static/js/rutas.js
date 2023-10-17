$(document).ready(function () {


    $.ajax({
        type: 'GET',
        url: "todasRutas"


    }).done(function (data) {
        console.log('todas las rutas: ', data);

        var html = "";
        
        for (var i = 0; i < data.length; i++) {
            html += ' <div class="col-12" style="text-align: center;">';
            html += '<a href=""  id="botonesRutas"  onclick="mostraRuta( ' + data[i].id + ')" data-bs-toggle="modal" data-bs-target="#idModal' + data[i].id + '">' + data[i].nombre + ' </a>';
            
           
            

            html += '<div  class="modal fade modal-lg" id="idModal' + data[i].id + '" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">';
            html += '<div class="modal-dialog">';
            html += '<div class="modal-content" id="content' + data[i].id + '">';
            html += '<div class="modal-header"><button type="button" class="btn-close" data-bs-dismiss="modal"aria-label="Close"></button></div>';
            // html += '<div class="modal-body">';
            html += '</div>';
            html += '</div>';
            html += '</div>';
            
            html += '</div>';
            html += '<hr>';
        }
        
        $('#divMedio').append(html);

    });

});
function mostraRuta(idRuta) {
    console.log('Entramos en mostrar ruta el idRuta: ', idRuta);
    $.ajax({
        type: 'GET',
        url: "unaRuta",
        data: {

            'idRuta': idRuta,

        },


    }).done(function (data) {
        $('#content' + data.id + '').empty();
        console.log('todas las rutas: ', data);
        //if (data.id > 0) {
        var html = "";

        // html += '<div  class="modal fade modal-lg" id="idModal'+ data.id+'" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">';
        // html += '<div class="modal-dialog">';
        // html += '<div class="modal-content">';
        html += '<div class="modal-header"><button type="button" class="btn-close" data-bs-dismiss="modal"aria-label="Close"></button></div>';
        html += '<div class="modal-body">';
        html += '<p style="font-size: 20px;font-weight: bold;text-align:center;"><b>' + data.nombre + '</b></p></br>';
        if (data.texto1 != null) {
            html += '<p style="font-size: 18px;text-align: left" >' + data.texto1 + '</p></br>';
        }
        if (data.foto1 != null) {
            html += '<div><img src="imagenesRutas/hoyos/' + data.foto1 + '" alt=""style="width: 100%;"></div></br>';
        }
        if (data.texto2 != null) {
            html += '<p style="font-size: 18px;text-align: left" >' + data.texto2 + '</p></br>';
        }
        if (data.foto2 != null) {
            html += '<div><img src="imagenesRutas/hoyos/' + data.foto2 + '" alt=""style="width: 100%;"></div></br>';
        }
        if (data.texto3 != null) {
            html += '<p style="font-size: 18px;text-align: left" >' + data.texto3 + '</p></br>';
        }
        if (data.foto3 != null) {
            html += '<div><img src="imagenesRutas/hoyos/' + data.foto3 + '" alt=""style="width: 100%;"></div></br>';
        }
        if (data.texto4 != null) {
            html += '<p style="font-size: 18px;text-align: left" >' + data.texto4 + '</p></br>';
        }
        if (data.foto4 != null) {
            html += '<div><img src="imagenesRutas/hoyos/' + data.foto4 + '" alt=""style="width: 100%;"></div></br>';
        }
        if (data.texto5 != null) {
            html += '<p style="font-size: 18px;text-align: left" >' + data.texto5 + '</p></br>';
        }
        if (data.foto5 != null) {
            html += '<div><img src="imagenesRutas/hoyos/' + data.foto5 + '" alt=""style="width: 100%;"></div></br>';
        }
        html += '</div>';
        html += '<div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button></div>';

        $('#content' + data.id + '').append(html);

    }
    )
};