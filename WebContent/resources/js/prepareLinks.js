$(document).ready(function() {
   $(".nav li.disabled a").click(function() {
     return false;
   });
   $(".button-remove").bind("click", function() {
	   if(confirm("¿Esta seguro de que desea borrar el registro?")) {
		   return true;
	   } else {
		   return false;
	   }
   });
});