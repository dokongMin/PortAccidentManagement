




document.getElementById("daytable2").style.display ='none'; 

function Radio(){
  var score1 = document.getElementsByName("score1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);
  var score2 = document.getElementsByName("score2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);
  var score3 = document.getElementsByName("score3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);
  const total=document.getElementById("totalsum");
  const totalsum=v1+v2+v3
  total.innerHTML=totalsum;
  if (totalsum<15){
    const modal = document.querySelector('.modal');
      const btnOpenPopup = document.querySelector('.btn-open-popup');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success");
      const word="<div style='color:red;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  }    
}

function Evaluation(){
    const typeC=document.getElementById("typeC");
    const typeFC = typeC.options[typeC.selectedIndex].value;
    console.log(typeFC);
    const levelC=document.getElementById("levelC");
    const levelFC = levelC.options[levelC.selectedIndex].value;
    console.log(levelFC);
    const dayC=document.getElementById("dayC");
    const dayFC = dayC.options[dayC.selectedIndex].value;
    console.log(dayFC);
    if (typeFC=="사고" && levelFC=="level1" && dayFC=="1일차" ){
      
      
    } 
    if (typeFC=="사고" && levelFC=="level1" && dayFC=="2일차" ){
      document.getElementById("daytable2").style.display ='block';
    } 
    if (typeFC=="사고" && levelFC=="level2" && dayFC=="1일차" ){

    }
    if (typeFC=="사고" && levelFC=="level2" && dayFC=="2일차" ){

    }
    if (typeFC=="사고" && levelFC=="level3" && dayFC=="1일차" ){

    }
    if (typeFC=="사고" && levelFC=="level3" && dayFC=="2일차" ){

    }
    if (typeFC=="사고" && levelFC=="level3" && dayFC=="3일차" ){

    } 

    if (typeFC=="재난" && levelFC=="level1" && dayFC=="1일차" ){

    } 
    if (typeFC=="재난" && levelFC=="level1" && dayFC=="2일차" ){

    } 
    if (typeFC=="재난" && levelFC=="level2" && dayFC=="1일차" ){

    }
    if (typeFC=="재난" && levelFC=="level2" && dayFC=="2일차" ){

    }
    if (typeFC=="재난" && levelFC=="level3" && dayFC=="1일차" ){

    }
    if (typeFC=="재난" && levelFC=="level3" && dayFC=="2일차" ){

    }
    if (typeFC=="재난" && levelFC=="level3" && dayFC=="3일차" ){

    }    
  
}



