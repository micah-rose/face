
var numFace = 0;
var numEye = 0;
var numNose = 0;
var numMouth = 0;

function changeFace(){
    checkbox1 = document.getElementById("chkbx1");
    checkbox2 = document.getElementById("chkbx2");
    checkbox3 = document.getElementById("chkbx3");
      
        if(checkbox1.checked){
            if (numEye != 2){
	            numEye++;
            }else 
            {
	            numEye = 0;
            }
           document.getElementById("eyes-image").src = "img/eyes" + numEye + ".png";
        }
        if(checkbox2.checked){
            if (numNose != 2){
	            numNose++;
            }else 
            {
	            numNose = 0;
            }
            document.getElementById("nose-image").src = "img/nose" + numNose + ".png";      
        }
        if(checkbox3.checked){
            if (numMouth != 2){
	            numMouth++;
            }else 
            {
	            numMouth = 0;
            }
            document.getElementById("mouth-image").src = "img/mouth" + numMouth + ".png";    
        }

        if (!(checkbox1.checked) && !(checkbox2.checked) && !(checkbox3.checked)) 
        {
            if (numFace != 2) 
            {
                numFace++;
            } else 
            {
                numFace = 0;
            }
            document.getElementById("face-image").src = "img/face" + numFace + ".png";
        }
    }