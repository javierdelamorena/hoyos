//$(document).ready(function () {
    var coment;
    var idComent;
    var comentarios;
    // function editarComent(comentario, idComentario) {
    //     coment = comentario;
    //     idComent = idComentario
    //     console.log("se ha pulsado editarComentario");
    //     //$('#comentario').empty();
    //     //$('#editarComentario').hide();
    //     $('#comentario').append(coment);

    //     var html = '';
    //     // html += '<div class="col-lg-9 col-sm-9" id="textoComentario">';
    //     // html += '<textarea type="text" id="comentarioEditar" name="comentario" class="form-control" maxlength="250" required style="font-weight: 600;" placeholder="Escribe tu opinión...."></textarea>'
    //     // html += '</div>';
    //     html += '<div class="col-lg-3 col-sm-3">';
    //     html += '<button class="btn " style="color: #eeeeee;background-color: #463232a3;"onclick="editar()" id="editarComentario">';
    //     html += '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">';
    //     html += '<path d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z"/>';
    //     html += '</svg>';
    //     html += 'editar Comentario</button>';
    //     html += '</div>';

    //     $('#cajaAbajoComentarios').html(html);


    // };







    $("#salvarComentario").on("click", function () {
        console.log("se ha pulsado salvarComentario");

if($('#comentario').val()!=""){
        $.ajax({
            type: 'GET',
            url: "salvarcomentario",
            //url: "https://cuevas-de-ayllon.com/salvarcomentario",
            data: { 'comentario': $('#comentario').val(), 'idUsuario': $('#comentarioIdUsuario').val() },
            // beforeSend: function(){
            //     $('#textoComentario').empty();
            // }
        }).done(function (objetos) {
            document.getElementById("comentario").value = "";
            $("#salvarComentario").hide();
            console.log("Hecho Correcto!");
            console.log("Hecho Correcto!");
            console.log("Hecho Correcto!");
            console.log("Hecho Correcto!");
            console.log("foto: " + objetos.usuario.foto);
            console.log("nombre usuario: " + objetos.usuario.nombre);
            console.log("comentario: " + objetos.comentarios[0].comentario);
            console.log("propuesta: " + objetos.propuestas.titulo);

            var html2 = '';
            html2 += '<tr>';
            html2 += '<td><img class="img-thumbnail  float-left" style="width: 50px ;float: left; border-radius: 90px;" src=uploads/' + objetos.usuario.foto + "></td>";
            html2 += '</tr>';

            html2 += '<tr>';
            html2 += '<td style=" border-style: solid;font-weight: bold;">' + objetos.usuario.nombre.toUpperCase() + '</td>';
            html2 += '</tr>';
            html2 += '<tr>';
            console.log("Hecho Correcto estamos dentro del for!" + objetos.comentarios[0].comentario);
            console.log("Hecho Correcto estamos dentro del for!" + objetos.propuestas.idPropuesta);
            html2 += '<td><p   id="textoComentarios">' + objetos.usuario.nombre.toUpperCase() + ' Ha dicho:  ' + objetos.comentarios[0].comentario + '</p></td>';
            html2 += '</tr>';
            for (var i = 0; i < objetos.comentarios.length; i++) {
            if (objetos.comentarios[i].editable != null) {
                console.log("Hecho Correcto estamos dentro del if de editable: " + objetos.comentarios[i].editable);
                html2 += '<tr>';
                html2 += "<td>";
                html2 += '<div style="display: flex;">';
                html2 += "<button id='botonEditar' type='button' class='btn btn-dark'  onclick='editarComent(\"" + objetos.comentarios[i].comentario.toString() + "\" ," + objetos.comentarios[i].id + ")' style='color: #eeeeee;background-color: #463232a3; margin-bottom: 30px;margin-right: 1%;'float: left;'>editar</button>";
                html2 += " <form action='borrarComentarioAjax' method='post'>";
                html2 += '<input type="hidden" name="idComentario" value="' + objetos.comentarios[i].id + '">';
                console.log("Hecho Correcto estamos dentro del if de editable el id es: " + objetos.comentarios[i].id);
                html2 += '<input type="hidden" name="idPropuesta" value="' + objetos.propuestas.idPropuesta + '">';
                console.log("Hecho Correcto estamos dentro del if de editable el idpropuesta es: " + objetos.propuestas.idPropuesta);
                html2 += '<input type="submit" class="btn" value="Borrar"style="color: #eeeeee;background-color: #463232a3; margin-bottom: 30px;">';
                html2 += '</form>';
                html2 += '</div>';
                html2 += '</td>';
                html2 += '</tr>';

            }
        }

            $('#todosLosComentarios').append(html2);

        }).fail(function () {
            console.log("Fallo!");
        })
            .always(function () {
                console.log("Completo!");
            });;
        }
    });

//});
