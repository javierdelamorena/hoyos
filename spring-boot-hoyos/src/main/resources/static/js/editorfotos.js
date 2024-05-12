

var fileInput = document.querySelector(".file-input"),
filterOptions = document.querySelectorAll(".filter button"),
filterName = document.querySelector(".filter-info .name"),
filterValue = document.querySelector(".filter-info .value"),
filterSlider = document.querySelector(".slider input"),
rotateOptions = document.querySelectorAll(".rotate button"),
previewImg = document.querySelector(".preview-img img"),
resetFilterBtn = document.querySelector(".reset-filter"),
chooseImgBtn = document.querySelector(".choose-img"),
saveImgBtn = document.querySelector(".save-img");

let brightness = "100", saturation = "100", inversion = "0", grayscale = "0";
let rotate = 0, flipHorizontal = 1, flipVertical = 1;

// Cargar Imágenes
console.log(fileInput);
const loadImage = () => {
    
     previewImg.src =document.querySelector('.file-input').src;
   
     previewImg.addEventListener("load", () => {
        resetFilterBtn.click();
        
      });
}

// Aplicar Filtros

const applyFilter = () => {
    previewImg.style.transform = `rotate(${rotate}deg) scale(${flipHorizontal}, ${flipVertical})`;
    previewImg.style.filter = `brightness(${brightness}%) saturate(${saturation}%) invert(${inversion}%) grayscale(${grayscale}%)`;
}

filterOptions.forEach(options => {
    options.addEventListener("click", () => {
        document.querySelector(".active").classList.remove("active");
        options.classList.add("active");
        filterName.innerText = options.innerText;

        if(options.id === "brightness") {
            filterSlider.max = "200";
            filterSlider.value = brightness;
            filterValue.innerText = `${brightness}%`;
        } else if(options.id === "saturation" ) {
            filterSlider.max = "200";
            filterSlider.value = saturation;
            filterValue.innerText = `${saturation}%`
        } else if(options.id === "inversion" ) {
            filterSlider.max = "100";
            filterSlider.value = inversion;
            filterValue.innerText = `${inversion}%`;
        } else {
            filterSlider.max = "100";
            filterSlider.value = grayscale;
            filterValue.innerText = `${grayscale}%`;
        }
    });
});

// Actualizar Filtros

const updateFilter = () => {
    filterValue.innerText = `${filterSlider.value}%`;
    const selectedFilter = document.querySelector(".filter .active");

    if(selectedFilter.id === "brightness" ) {
        brightness = filterSlider.value;
    } else if(selectedFilter.id === "saturation" ) {
        saturation = filterSlider.value;
    } else if(selectedFilter.id === "inversion" ) {
        inversion = filterSlider.value;
    } else {
        grayscale = filterSlider.value;
    }
    applyFilter();
}

rotateOptions.forEach(options => {
    options.addEventListener("click", () => {
        if(options.id === "left" ) {
            rotate -= 90;
        } else if(options.id === "right" ) {
            rotate += 90;
        } else if(options.id === "horizontal" ) {
            flipHorizontal = flipHorizontal === 1 ? -1 : 1;
        } else {
            flipVertical = flipVertical === 1 ? -1 : 1;
        }
        applyFilter();
    });
});

// Resetear Filtros

const resetFilter = () => {
    brightness = "100"; saturation = "100"; inversion = "0"; grayscale = "0";
    rotate = 0; flipHorizontal = 1; flipVertical = 1;
    filterOptions[0].click();
    applyFilter();
}

// Guardar imágenes

const saveImage = (mails,ids) => {
    const canvas = document.createElement("canvas");
    const ctx = canvas.getContext("2d");
    canvas.width = previewImg.naturalWidth;
    canvas.height = previewImg.naturalHeight;
    
    ctx.filter = `brightness(${brightness}%) saturate(${saturation}%) invert(${inversion}%) grayscale(${grayscale}%)`;
    ctx.translate(canvas.width / 2, canvas.height / 2);
    if(rotate !== 0) {
        ctx.rotate(rotate * Math.PI / 180);
    }
    ctx.scale(flipHorizontal, flipVertical);
    ctx.drawImage(previewImg, -canvas.width / 2, -canvas.height / 2, canvas.width, canvas.height);
    
    var link = document.createElement("a");
    // link.download = nombreImagen;
    // console.log(link.download);
    link = canvas.toDataURL("img", 0.5);
     
    // link.click();
    // console.log(link.click());

    
	 var mail = mails;
     console.log('este es el mail',mail);
	 var id = ids;
     console.log('este es el idFotos',id);

    var blob = dataURItoBlob(link);
    var fd = new FormData(document.forms[0]);
   
    
     fd.append("mails", mail);
    
     fd.append("idFotos", id);
    
    fd.append("file", blob);

    for(let [name, value] of fd) {
        console.log(`${name} = ${value}`); // key1 = value1, luego key2 = value2
      }
    


    // Upload image

    var XHR = new XMLHttpRequest();
    // We define what will happen if the data are successfully sent
     XHR.addEventListener('load', function (event) {
        $('#respuestaAedicion').empty();
        $('#respuestaAedicion').append(XHR.response);
       console.log('Yeah! Data sent and response loaded.',XHR.response);
     });
    // We define what will happen in case of error
    // XHR.addEventListener('error', function (event) {
    //     console.log('Oups! Something goes wrong.');
    // });
    // We setup our request
    XHR.open('POST', 'https://hoyos.com.es/editarFoto');
    //XHR.open('POST', 'editarFoto');
 
    XHR.send(fd);
   
}

filterSlider.addEventListener("input", updateFilter);
resetFilterBtn.addEventListener("click", resetFilter);
// saveImgBtn.addEventListener("click", saveImage);
fileInput.addEventListener("click", loadImage);
//chooseImgBtn.addEventListener("click", () => fileInput.click());

function dataURItoBlob (dataURI) {
    // convert base64/URLEncoded data component to raw binary data held in a string
    var byteString;
    if (dataURI.split(',')[0].indexOf('base64') >= 0)
        byteString = atob(dataURI.split(',')[1]);
    else
        byteString = unescape(dataURI.split(',')[1]);

    // separate out the mime component
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

    // write the bytes of the string to a typed array
    var ia = new Uint8Array(byteString.length);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ia], {type: mimeString});
}