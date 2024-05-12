

$.ajax({
    type: 'GET',
    //url: "votacionPropuestasAjax",
    url:"https://hoyos.com.es/votacionPropuestasAjax",
}).done(function (datos) {

    

    var html2 = '';
    html2 += '<table class="table table-striped table-bordered" style="text-align: center;">';
    html2 += '<tr style="background-color: #deb887a8;">  ';
    html2 += '<th scope="col">Historial de Propuestas</th> ';
    html2 += '<th scope="col">Apoyos</th>';

    html2 += '</tr>';
    html2 += '<tbody id="the_table_body">';
    for (let i = 0; i < datos.length; i++) {

        


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


