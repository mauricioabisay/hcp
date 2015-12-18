<h2 class="page-header">${pacienteForm.nombre}&nbsp;${pacienteForm.apellidoPaterno}&nbsp;${pacienteForm.apellidoMaterno}</h2>
<div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Datos Personales</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Nombre</span>
				<span class="col-sm-9 text-left">${pacienteForm.nombre}&nbsp;${pacienteForm.apellidoPaterno}&nbsp;${pacienteForm.apellidoMaterno}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Fecha Nacimiento</span>
				<span class="col-sm-9">${pacienteForm.fechaNacimientoString}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Edad</span>
				<span class="col-sm-9">${pacienteForm.edadString}</span>
			</div>
		<!-- Ocupacion -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Ocupación</span>
				<span class="col-sm-9">${pacienteForm.ocupacion}</span>
			</div>
		<!-- Sexo -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Sexo</span>
				<span class="col-sm-9">${pacienteForm.sexo}</span>
			</div>
		<!-- Estado Civil -->
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Edo.Civil</span>
				<span class="col-sm-9">${pacienteForm.estadoCivil}</span>
			</div>	
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Dirección</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Calle</span>
				<span class="col-sm-9">
					${pacienteForm.calleynum}&nbsp;
				</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Colonia</span>
				<span class="col-sm-9">${pacienteForm.colonia}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Ciudad</span>
				<span class="col-sm-9">${pacienteForm.ciudad}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Estado</span>
				<span class="col-sm-9">${pacienteForm.estado}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">País</span>
				<span class="col-sm-9">${pacienteForm.pais}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">C.P.</span>
				<span class="col-sm-9">${pacienteForm.cp}</span>
			</div>
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Información Adicional</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">R.F.C.</span>
				<span class="col-sm-9">${pacienteForm.rfc}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Teléfono</span>
				<span class="col-sm-9">${pacienteForm.telefono}</span>
			</div>
			<div class="col-sm-12">
				<span class="col-sm-3 text-right">Recomendado por</span>
				<span class="col-sm-9">${pacienteForm.recomendado}</span>
			</div>
		</div>
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Observaciones</h3>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<pre><span style="font-size: large; font-family: Helvetica Neue,Helvetica,Arial,sans-serif">${pacienteForm.observaciones}</span></pre>
			</div>
		</div>
	</div>
</div>

<div class="form-group col-md-12">
	<div align="center">
		<a href="${pageContext.request.contextPath}/paciente/update/${pacienteForm.id}">
			<input type="button" class="btn btn-default" value="Editar" />
		</a>
	</div>
</div>