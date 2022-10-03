function Radio1(){
  var score1 = document.getElementsByName("score1-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score1-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score1-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score1-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  const total=document.getElementById("totalsum1");
  const totalsum=v1+v2+v3+v4;
  total.innerHTML=totalsum;

  if (totalsum<15){
    const modal = document.querySelector('.modal1');
      const btnOpenPopup = document.querySelector('.btn-open-popup1');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup1');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success1");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  }    
}

function Radio2(){
  var score1 = document.getElementsByName("score2-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score2-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score2-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  const total=document.getElementById("totalsum2");
  const totalsum=v1+v2+v3
  total.innerHTML=totalsum;

  if (totalsum<15){
    const modal = document.querySelector('.modal2');
      const btnOpenPopup = document.querySelector('.btn-open-popup2');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup2');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success2");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  }    
}

function Radio3(){
  var score1 = document.getElementsByName("score3-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score3-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score3-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score3-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  var score5 = document.getElementsByName("score3-5");
  var sel5 = Array.from(score5).find(radio => radio.checked);
  const v5=Number(sel5.value);

  const total=document.getElementById("totalsum3");
  const totalsum=v1+v2+v3+v4+v5
  total.innerHTML=totalsum;

  if (totalsum<15){
    const modal = document.querySelector('.modal3');
      const btnOpenPopup = document.querySelector('.btn-open-popup3');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup3');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success3");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  }    
}

function Radio4(){
  var score1 = document.getElementsByName("score4-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score4-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score4-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score4-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  const total=document.getElementById("totalsum4");
  const totalsum=v1+v2+v3+v4
  total.innerHTML=totalsum;
  if (totalsum<15){
    const modal = document.querySelector('.modal4');
      const btnOpenPopup = document.querySelector('.btn-open-popup4');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup4');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success4");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  } 

}

function Radio5(){
  var score1 = document.getElementsByName("score5-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score5-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score5-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score5-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  const total=document.getElementById("totalsum5");
  const totalsum=v1+v2+v3+v4
  total.innerHTML=totalsum;
  if (totalsum<15){
    const modal = document.querySelector('.modal5');
      const btnOpenPopup = document.querySelector('.btn-open-popup5');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup5');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success5");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  } 
}

function Radio6(){
  var score1 = document.getElementsByName("score6-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score6-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score6-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score6-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  const total=document.getElementById("totalsum6");
  const totalsum=v1+v2+v3+v4
  total.innerHTML=totalsum;
  if (totalsum<15){
    const modal = document.querySelector('.modal6');
      const btnOpenPopup = document.querySelector('.btn-open-popup6');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup6');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success6");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  } 
}

function Radio7(){
  var score1 = document.getElementsByName("score7-1");
  var sel1 = Array.from(score1).find(radio => radio.checked);
  const v1=Number(sel1.value);

  var score2 = document.getElementsByName("score7-2");
  var sel2 = Array.from(score2).find(radio => radio.checked);
  const v2=Number(sel2.value);

  var score3 = document.getElementsByName("score7-3");
  var sel3 = Array.from(score3).find(radio => radio.checked);
  const v3=Number(sel3.value);

  var score4 = document.getElementsByName("score7-4");
  var sel4 = Array.from(score4).find(radio => radio.checked);
  const v4=Number(sel4.value);

  const total=document.getElementById("totalsum7");
  const totalsum=v1+v2+v3+v4
  total.innerHTML=totalsum;
  if (totalsum<15){
    const modal = document.querySelector('.modal7');
      const btnOpenPopup = document.querySelector('.btn-open-popup7');
      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
      });
  } else {
    const btnOpenPopup = document.querySelector('.btn-open-popup7');
    btnOpenPopup.addEventListener('click', () => {
      const success=document.getElementById("success7");
      const word="<div style='color:red; position:absolute; margin-left:25%; font-weight:700;'>합격입니다.</div>"
      success.innerHTML=word;
      })   
  } 
}

  document.getElementById("daytable1").style.display ='none';
  document.getElementById("daytable2").style.display ='none';
  document.getElementById("daytable3").style.display ='none';
  document.getElementById("daytable4").style.display ='none';
  document.getElementById("daytable5").style.display ='none';
  document.getElementById("daytable6").style.display ='none';
  document.getElementById("daytable7").style.display ='none';
  document.getElementById("daytable8").style.display ='none';
  document.getElementById("daytable9").style.display ='none';
  document.getElementById("daytable10").style.display ='none';
  document.getElementById("daytable11").style.display ='none';
  document.getElementById("daytable12").style.display ='none';
  document.getElementById("daytable13").style.display ='none';
  document.getElementById("daytable14").style.display ='none';
  document.getElementById("daytable15").style.display ='none';

function Evaluation(){
    const typeC=document.getElementById("typeC");
    const typeFC = typeC.options[typeC.selectedIndex].value;
    const levelC=document.getElementById("levelC");
    const levelFC = levelC.options[levelC.selectedIndex].value;
    const dayC=document.getElementById("dayC");
    const dayFC = dayC.options[dayC.selectedIndex].value;

    if (typeFC=="사고"){
      document.getElementById("daytable1").style.display ='none';
      document.getElementById("daytable2").style.display ='none';
      document.getElementById("daytable3").style.display ='none';
      document.getElementById("daytable4").style.display ='none';
      document.getElementById("daytable5").style.display ='none';
      document.getElementById("daytable6").style.display ='none';
      document.getElementById("daytable7").style.display ='none';
      document.getElementById("daytable8").style.display ='none';
      document.getElementById("daytable9").style.display ='none';
      document.getElementById("daytable10").style.display ='none';
      document.getElementById("daytable11").style.display ='none';
      document.getElementById("daytable12").style.display ='none';
      document.getElementById("daytable13").style.display ='none';
      document.getElementById("daytable14").style.display ='none';
      document.getElementById("daytable15").style.display ='none';
      if(levelFC=="level1"){
        if(dayFC=="1일차"){
          document.getElementById("daytable1").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable2").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable15").style.display ='block';
        }
      }else if(levelFC=="level2"){
        if(dayFC=="1일차"){
          document.getElementById("daytable3").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable4").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable15").style.display ='block';
        }
      } else if(levelFC=="level3"){
        if(dayFC=="1일차"){
          document.getElementById("daytable5").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable6").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable7").style.display ='block';
        }
      }
    }
    else if (typeFC=="재난"){
      document.getElementById("daytable1").style.display ='none';
      document.getElementById("daytable2").style.display ='none';
      document.getElementById("daytable3").style.display ='none';
      document.getElementById("daytable4").style.display ='none';
      document.getElementById("daytable5").style.display ='none';
      document.getElementById("daytable6").style.display ='none';
      document.getElementById("daytable7").style.display ='none';
      document.getElementById("daytable8").style.display ='none';
      document.getElementById("daytable9").style.display ='none';
      document.getElementById("daytable10").style.display ='none';
      document.getElementById("daytable11").style.display ='none';
      document.getElementById("daytable12").style.display ='none';
      document.getElementById("daytable13").style.display ='none';
      document.getElementById("daytable14").style.display ='none';
      document.getElementById("daytable15").style.display ='none';
      if(levelFC=="level1"){
        if(dayFC=="1일차"){
          document.getElementById("daytable8").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable9").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable15").style.display ='block';
        }
      }else if(levelFC=="level2"){
        if(dayFC=="1일차"){
          document.getElementById("daytable10").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable11").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable15").style.display ='block';
        }
      } else if(levelFC=="level3"){
        if(dayFC=="1일차"){
          document.getElementById("daytable12").style.display ='block';
        } else if (dayFC=="2일차"){
          document.getElementById("daytable13").style.display ='block';
        } else if (dayFC=="3일차"){
          document.getElementById("daytable14").style.display ='block';
        }
      }
    } 
}



