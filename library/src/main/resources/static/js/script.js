function myFunction() {
	  var suc;
	  var a=document.getElementById("i1").value;
	  var b=document.getElementById("i2").value;
	  var c=document.getElementById("i3").value;
	  var d=document.getElementById("i4").value;
	  var e=document.getElementById("i5").value;
	  var f=document.getElementById("i6").value;
	  
	  console.log(a+" "+b+" "+c+" "+d+" "+e+" "+f);
	  
	  if (a == null || a == "", b == null || b == "", c == null || c == "", d == null || d == "", e == null || e == "", f == null || f == "") {
	    alert("Please fill the required field")
	  } else{
		  var result = confirm( "Do you want to do this?" );
		  if(result){
		  document.getElementById("f1").submit();	
		  }else{
			  
		  }
	  }
	}