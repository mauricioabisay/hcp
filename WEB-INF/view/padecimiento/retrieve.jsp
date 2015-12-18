<h2 class="page-header">Padecimiento
	${padecimientoForm.fechaString}</h2>
<div class="col-sm-6">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Síntomas</h3>
		</div>
		<div class="panel-body">
			<pre><span style="font-size: large; font-family: Helvetica Neue, Helvetica, Arial, sans-serif">${padecimientoForm.sintomas}</span></pre>
		</div>
	</div>
</div>
<span class="col-sm-1"></span>
<div class="col-sm-5">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Dosis</h3>
		</div>
		<div class="panel-body">
			<p>
				<b>Dosis 1:</b> ${padecimientoForm.dosis1}
			</p>
			<p>
				<b>Dosis 2:</b> ${padecimientoForm.dosis2}
			</p>
			<p>
				<b>Dosis 3:</b> ${padecimientoForm.dosis3}
			</p>
		</div>
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Medicamentos</h3>
		</div>
		<div class="panel-body">
			<pre><span style="font-size: large; font-family: Helvetica Neue, Helvetica, Arial, sans-serif">${padecimientoForm.medicamentos}</span></pre>
		</div>
	</div>
</div>