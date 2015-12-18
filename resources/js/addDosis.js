function addDosis() {
	var sintomas = $('#sintomas').val();
	var aux = sintomas.split("DOSIS");
	if(aux.length > 0) {
		aux2 = aux[1].split("MEDICAMENTOS");
		var dosis = aux2[0];
		var medicamentos = aux2[1];
		var dosisAux = dosis.split("*");
		for(i = 1; i < dosisAux.length; i++) {
			$('#dosis' + i).val(dosisAux[i]);
		}
		$('#medicamentos').val(medicamentos.trim());
	}
}