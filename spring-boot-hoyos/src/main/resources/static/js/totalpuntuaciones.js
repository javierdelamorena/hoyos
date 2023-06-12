

$.ajax({
    type: 'GET',
    url: "votacionPropuestasAjax",
}).done(function (datos) {

    console.log('Estos son los datos' + datos);

    var html2 = '';
    html2 += '<table class="table table-striped table-bordered" style="text-align: center;">';
    html2 += '<tr>  ';
    html2 += '<th scope="col">Historial de Propuestas</th> ';
    html2 += '<th scope="col">Apoyos</th>';

    html2 += '</tr>';
    html2 += '<tbody id="the_table_body">';
    for (let i = 0; i < datos.length; i++) {

        console.log('Estos son los datos' + datos.estados);


        html2 += '</tr>';
        html2 += '<tr>';
        html2 += '<td >' + datos[i].propuesta + '</td>';
        html2 += '<td >' + datos[i].puntuacion + '</td>';
        html2 += '</tr>';



    }
    html2 += '</tbody>';
    html2 += '</table>';
    $('#propuestas').append(html2);

});


