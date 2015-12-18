<h2 class="page-header">Exploración Física ${exploracionFisicaForm.fechaString}</h2>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Exploración Física</h3>
	</div>
	<div class="panel-body">
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Peso</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.peso}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Estatura</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.estatura}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Peso Ideal</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.pesoIdeal}</span>
		</div>
		<div class="col-sm-12">&nbsp;</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Temperatura</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.temperatura}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Glucosa</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.glucosa}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Presión Arterial</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.presionSistolica} / ${exploracionFisicaForm.presionDiastolica}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Frec.Cardiaca</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.frecuenciaCardiaca}</span>
		</div>
		<div class="col-sm-12">
			<span class="col-sm-3 text-right">Frec.Respiratoria</span>
			<span class="col-sm-9 text-left">${exploracionFisicaForm.frecuenciaRespiratoria}</span>
		</div>
	</div>
</div>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Observaciones</h3>
	</div>
	<div class="panel-body">
		<pre><span style="font-size: large; font-family: Helvetica Neue,Helvetica,Arial,sans-serif">${exploracionFisicaForm.observaciones}</span></pre>
	</div>
</div>
