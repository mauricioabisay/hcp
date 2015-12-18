<h2 class="page-header">Usuario de ${usuarioForm.firma}</h2>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Datos Usuario</h3>
	</div>
	<div class="panel-body">
		<div class="col-sm-12">
			<span class="col-sm-3">Nombre Completo:</span>
			<span class="col-sm-9">${usuarioForm.firma}</span>
		</div>
		
		<div class="col-sm-12">
			<span class="col-sm-3">Usuario:</span>
			<span class="col-sm-9">${usuarioForm.usuario}</span>
		</div>
		
		<div class="col-sm-12">
			<span class="col-sm-3">Días entre visitas:</span>
			<span class="col-sm-9">${usuarioForm.diasSiguienteVisita}</span>
		</div>
	</div>
</div>
		
<div class="col-sm-12 text-center">
	<a href="${pageContext.request.contextPath}/usuario/update/${usuarioForm.id}">
		<button class="btn btn-default">Editar</button>
	</a>
</div>