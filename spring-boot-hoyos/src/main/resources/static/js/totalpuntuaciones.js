

$.ajax({
    type: 'GET',
    url: "votacionPropuestasAjax",
}).done(function (datos) {

    console.log('Estos son los datos' + datos);

    var html2 = '';
    html2 += '<table class="table table-striped table-bordered" style="font-size: 23px;background-color: rgb(0 126 255 / 34%);text-align: center;border: solid;margin-top: 2%;">';
    html2 += '<tr>  ';
    html2 += '<th scope="col">Historial de Propuestas</th> ';
    html2 += '<th scope="col">Apoyos</th>';

    html2 += '</tr>';

    for (let i = 0; i < datos.length; i++) {

        console.log('Estos son los datos' + datos.estados);
        

        html2 += '</tr>';
        html2 += '<tr>';
        html2 += '<td >' + datos[i].propuesta + '</td>';
        html2 += '<td >' + datos[i].puntuacion + '</td>';
        html2 += '</tr>';



    }
    html2 += '</table>';
    $('#propuestas').append(html2);

});


