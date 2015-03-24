<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Usuario</h2>
<c:if test='${not empty errors}'>
<div class="has-error">
<ul>
<c:forEach var="e" items="${errors}">
<li>${e}</li>
</c:forEach>
</ul>
</div>
</c:if>
<form method="post" class="form-horizontal">	
	<form:hidden path="usuarioForm.id"/>
	<fieldset>
		<legend>Usuario</legend>
		
		<c:set var="auxError"><form:errors path="usuarioForm.firma"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="usuarioForm.clave" class="control-label col-sm-3">Nombre Completo:</form:label>
			<div class="col-sm-9">
				<form:input path="usuarioForm.firma" class="form-control"/>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="usuarioForm.usuario"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="usuarioForm.usuario" class="control-label col-sm-3">Usuario:</form:label>
			<div class="col-sm-9">
				<form:input path="usuarioForm.usuario" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="usuarioForm.clave"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="usuarioForm.clave" class="control-label col-sm-3">Clave:</form:label>
			<div class="col-sm-9">
				<form:input path="usuarioForm.clave" class="form-control"/>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="usuarioForm.diasSiguienteVisita"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="usuarioForm.diasSiguienteVisita" class="control-label col-sm-3">Días entre visitas:</form:label>
			<div class="col-sm-9">
				<form:input path="usuarioForm.diasSiguienteVisita" class="form-control"/>
			</div>
		</div>
		
	</fieldset>
	
	<div class="col-sm-12 text-center">
		<input type="submit" class="btn btn-default" value="Guardar" />
		<input type="reset" class="btn btn-default" value="Limpiar" />
	</div>
</form>