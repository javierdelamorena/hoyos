var coment;
var idComent;
var comentarios;
function editarComent(comentario, idComentario) {
    coment = comentario;
    idComent = idComentario
    console.log("se ha pulsado editarComentario");
    $('#comentario').html("");

    $('#editarComentario').hide();


    var html = '';
    //html += '<div class="col-lg-3 col-sm-3" id="editComentario">';
    html += '<button class="btn " style="color: #eeeeee;background-color: #463232a3;"onclick="editar()" id="editarComentario">';
    html += '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">';
    html += '<path d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z"/>';
    html += '</svg>';
    html += 'Editar </button>';
    //html += '</div>';
    if($('#editarComentario').hide()){
        $('#editComentario').append(html);
        $('#salvarComentario').attr('disabled', 'disabled');
    }else{
        $('#editarComentario').hide();
        $('#editComentario').hide();
        
    }
    

    //$('#salvarComentario').css("display", "none");
    $('#comentario').val(comentario);

};


function editar() {
    $.ajax({
        type: 'POST',
        //url: "editarComentario",
        url: "https://hoyos.com.es/editarComentario",
        data: { 'comentario': $('#comentario').val(), 'idComentario': idComent },

    }).done(function (objetos) {
        $('#salvarComentario').removeAttr('disabled');
        $("#salvarComentario").hide();

        console.log(objetos.comentarios);

        $('#tablaComentarios  > tbody').empty();
        document.getElementById("comentario").value = "";
        $('#editComentario').empty();
        $('#editarComentario').hide();
        $('#botonEditar').hide();
        // document.getElementById("todosLosComentarios").value = "";

        var html2 = '';
        for (var i = 0; i < objetos.comentarios.length; i++) {

            html2 += '<tr>';
            html2 += '<td><img class="img-thumbnail  float-left" style="width: 50px ;float: left; border-radius: 90px;" src=/uploads/' + objetos.usuarios[i].foto + "></td>";
            html2 += '</tr>';

            html2 += '<tr>';
            //html2 += '<td style=" border-style: solid;font-weight: bold;">' + objetos.usuarios[i].nombre.toUpperCase() + '</td>';
            html2 += '</tr>';
            html2 += '<tr>';
            html2 += '<td><p   id="textoComentarios">' + objetos.usuarios[i].nombre.toUpperCase() + '  Ha dicho:  ' + objetos.comentarios[i].comentario + '</p></td>';
            html2 += '</tr>';
            if (objetos.comentarios[i].editable != null) {
                console.log("Hecho Correcto estamos dentro del if de editable: " + objetos.comentarios[i].editable);
                html2 += '<tr>';
                html2 += "<td>";
                html2 += '<div style="display: flex;">'
                html2 += " <button id='botonEditar' type='button' class='btn btn-dark'  onclick='editarComent(\"" + objetos.comentarios[i].comentario.toString() + "\" ," + objetos.comentarios[i].id + ")' style='color: #eeeeee;background-color: #463232a3; margin-bottom: 30px;margin-right: 1%;'float: left;font-size: smaller;'>editar</button>";
                html2 += " <form action='borrarComentarioAjax' method='post'>";
                //html2 += " <form action='https://cuevas-de-ayllon.com/borrarComentario' method='post'>";
                html2 += "<input type='hidden' name='idComentario' value=\"" + parseInt(objetos.comentarios[i].id) + "\" >";
                console.log("Hecho Correcto estamos dentro del if de editable el id es: " + objetos.comentarios[i].id);
                html2 += "<input type='hidden' name='idPropuesta'  value=\"" + parseInt(objetos.propuestas.idPropuesta) + "\" >";
                console.log("Hecho Correcto estamos dentro del if de editable el idpropuesta es: " + objetos.propuestas.idPropuesta);
                html2 += "<input type='submit' class='btn' value='Borrar' style='color: #eeeeee;background-color: #463232a3; margin-bottom: 30px;font-size: smaller;'>";
                html2 += "</form>";
                html2 += "</td>"
                html2 += '</div >'
                html2 += '</tr>';
            }


        }


        $('#todosLosComentarios').append(html2);
        $('#editarComentario').hide();



    }).fail(function () {
        console.log("Fallo!");
    })
        .always(function () {
            console.log("Completo!");
        });;
};

