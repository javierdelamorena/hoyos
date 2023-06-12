

$.ajax({
    type: 'GET',
    url: "estadosPropuestasAjax",
}).done(function (datos) {

    console.log('Estos son los datos' + datos);

    var html2 = '';
    //html2 += '<table class="table table-bordered" style="font-size: 23px;background-color: white;text-align: center;border: solid;margin-top: 2%;">';
    // html2 += '<div >  ';
    
    // html2 += '<section id="mySection">';
    for (let i = 0; i < datos.length; i++) {
        console.log('Estos son los datos' + datos[i].propuesta);
        //html2 += '</tr>';
        //html2 += '<tr>';
        if (datos[i].votacion === 'votacion') {
            html2 += '<div class="row " style="margin: 1%">  ';
            html2 += '<div  style="font-size: 23px;background-color: rgb(37, 242, 40);text-align: center;padding: 1%;"><h5 class="card-title" id="h5-buscador">' + datos[i].titulo + '</h5></div>';
            html2 += '</div >  ';
        }
        if (datos[i].encurso === 'encurso') {
            html2 += '<div class="row " style="margin: 1%">  ';
            html2 += '<div  style="font-size: 23px;background-color: rgb(222, 19, 241);text-align: center;padding: 1%;"><h5 class="card-title" id="h5-buscador">' + datos[i].titulo + '</h5></div>';
            html2 += '</div >  ';
        }
        if (datos[i].realizada === 'realizada') {
            html2 += '<div class="row " style="margin: 1%">  ';
            html2 += '<div style="font-size: 23px;padding: 1%;background-color: rgb(241, 226, 15);text-align: center;"><h5 class="card-title" id="h5-buscador">' + datos[i].titulo + '</h5></div>';
            html2 += '</div >  ';
        }


        if (datos[i].pleno === 'pleno') {
            html2 += '<div class="row " style="margin: 1%">  ';
            html2 += '<div  style="font-size: 23px;padding: 1%;background-color: rgb(16, 218, 241);text-align: center;"><h5 class="card-title" id="h5-buscador">' + datos[i].titulo + '</h5></div>';
            html2 += '</div >  ';
        }



        if (datos[i].desestimada === 'desestimada') {
            // html2 += '<div>';
            html2 += '<div class="row" style="margin-left: 1%;margin-right: 1%;">';
            html2 += '<div  style="font-size: 23px;background-color: rgb(207 16 16 / 45%);text-align: center;padding: 1%;border-bottom: outset;"><h5 class="card-title" id="h5-buscador">' + datos[i].titulo + '</h5></div>';
            // html2 += '</div>';

            // html2 += '<div class="row" style="margin-left: 1%;margin-right: 1%;" >';
            html2 += '<div class="col" style="font-size: 18px;background-color: rgb(207 16 16 / 45%);text-align: center;padding: 1%;padding-top: 4%;">Razón de la desestimación:</div>';
            
            html2 += '<div class="col" style="background-color: rgb(207 16 16 / 45%);padding: 1%;"><h5 class="card-title" id="h5-buscador"><textarea  readonly style="padding:1%"  rows="4" cols="40">' + datos[i].textoDesestimada + '</textarea></h5></div>';
           
            html2 += '</div>';
        }



    }
    // html2 += '</section>';
    // html2 += '</div>';
    $('#propuestas').append(html2);


});


/**
 * 
 */