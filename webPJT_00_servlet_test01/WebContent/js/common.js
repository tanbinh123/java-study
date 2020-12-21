/*
 입력문자 공백, 길이 검사
*/
function inputCheck_empty_length(obj, msg,mByte) {
	if(obj.value ==""){
		alert(msg);
		obj.focus();
		return false;
	}	
//  var maxByte = 10; //최대 입력 바이트 수
  	var maxByte = mByte; //최대 입력 바이트 수
  	var str = obj.value;
  	var str_len = str.length;

	var rbyte = 0;
	var one_char = "";
	
	for (var i = 0; i < str_len; i++) {
	    one_char = str.charAt(i);
	
	    if (escape(one_char).length > 4) {
	        rbyte += 2; //한글2Byte
	    } else {
	        rbyte++; //영문 등 나머지 1Byte
	    }
	}
	//alert(rbyte); 
    if (rbyte > maxByte) {
        alert("한글 " + (maxByte / 2) + "자 / 영문 " + maxByte + "자를 초과 입력할 수 없습니다.");
        obj.focus();
		return false;
	} else {
		return true;
	}
}

/*
 입력문자 길이 검사
*/
function fnChkByte(obj, mByte) {
//  var maxByte = 10; //최대 입력 바이트 수
  	var maxByte = mByte; //최대 입력 바이트 수
  	var str = obj.value;
  	var str_len = str.length;

	var rbyte = 0;
	var one_char = "";
	
	for (var i = 0; i < str_len; i++) {
	    one_char = str.charAt(i);
	
	    if (escape(one_char).length > 4) {
	        rbyte += 2; //한글2Byte
	    } else {
	        rbyte++; //영문 등 나머지 1Byte
	    }
	}
	//alert(rbyte); 
    if (rbyte > maxByte) {
        alert("한글 " + (maxByte / 2) + "자 / 영문 " + maxByte + "자를 초과 입력할 수 없습니다.");
        obj.focus();
		return false;
	} else {
		return true;
	}
} 

/*
공백체크
*/
function checkEmpty(obj, alertString ){
   var errorMesg =  alertString ;
   if(trim(obj.value) == "" ) {
		alert(errorMesg);
		obj.focus();
		return false;
   } else {
		return true;   
   }	
}
/*
문자열 앞뒤에있는 공백없에기
*/
function trim( arg )
{
   var st = 0;
   var len = arg.length;

   //문자열앞에 공백문자가 들어 있는 Index 추출
   while( (st < len) && (arg.charCodeAt(st) == 32) )
   {
      st++;
   }
   //문자열뒤에 공백문자가 들어 있는 Index 추출
   while( (st < len) && (arg.charCodeAt(len-1) == 32) )
   {
      len--;
   }
   return ((st > 0) || (len < arg.length)) ? arg.substring(st, len) : arg;
}