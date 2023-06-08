

$.ajax({
    type: 'GET',
    url: "estadosPropuestasAjax",
}).done(function (datos) {

    console.log('Estos son los datos' + datos);

    var html2 = '';
    html2 += '<table class="table table-striped table-bordered" style="font-size: 23px;background-color: rgb(0 126 255 / 34%);text-align: center;border: solid;margin-top: 2%;">';
    html2 += '<tr>  ';
    html2 += '<th scope="col">Propuesta</th> ';
    // html2 += '<th scope="col">Porque se ha desestimada</th> ';


    html2 += '</tr>';

    for (let i = 0; i < datos.length; i++) {
        console.log('Estos son los datos' + datos[i].propuesta);



        html2 += '</tr>';
        html2 += '<tr>';
        if (datos[i].votacion === 'votacion') {
            html2 += '<td style="background-color: rgb(37, 242, 40);">' + datos[i].titulo + '</td>';

        }
        if (datos[i].encurso === 'encurso') {
            html2 += '<td style="background-color: rgb(222, 19, 241);">' + datos[i].titulo + '</td>';

        }
        if (datos[i].realizada === 'realizada') {
            html2 += '<td style="background-color: rgb(241, 226, 15);">' + datos[i].titulo + '</td>';

        }
        // if (datos[i].desestimada === 'desestimada') {
           
        //     html2 += '<td style="background-color: rgb(230, 78, 78);">' + datos[i].titulo + '</td>';
        //     html2 += '<td style="background-color: rgb(230, 78, 78);">' + datos[i].textoDesestimada + '</td>';

        // }
        if (datos[i].pleno === 'pleno') {
            html2 += '<td style="background-color: rgb(16, 218, 241);">' + datos[i].titulo + '</td>';

        }

        html2 += '</tr>';
       
        if (datos[i].desestimada === 'desestimada') {
            html2 += '<th scope="col"></th> ';
            html2 += '<th scope="col">Porque se ha desestimada</th>';
            html2 += '<tr>';
           

            html2 += '<td style="background-color: rgb(230, 78, 78);">' + datos[i].titulo + '</td>';
            html2 += '<td style="background-color: rgb(230, 78, 78);">' + datos[i].textoDesestimada + '</td>';
            html2 += '</tr>';
        }



    }
    html2 += '</table>';
    $('#propuestas').prepend(html2);


});


/**
 * 
 */