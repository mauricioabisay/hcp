<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="<c:url value = '/resources/js/addDosis.js' />"></script>
<h2 class="page-header">Padecimiento</h2>
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
	<form:hidden path="padecimientoForm.id"/>
	<form:hidden path="padecimientoForm.paciente"/>
	<fieldset>
		<legend>Padecimiento</legend>
		<c:set var="auxError"><form:errors path="padecimientoForm.sintomas"/></c:set>
		<div class="col-sm-6 <c:if test='${not empty auxError}'>has-error</c:if>">
			<div class="form-group">
				<form:label path="padecimientoForm.sintomas" class="control-label">Síntomas:</form:label>
				<form:textarea path="padecimientoForm.sintomas" class="form-control" rows="25" onblur="addDosis()" />
			</div>
		</div>
		<span class="col-sm-1"></span>
		<div class="col-sm-5">
			<c:set var="auxError"><form:errors path="padecimientoForm.dosis1"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="padecimientoForm.dosis1" class="control-label">Dosis 1:</form:label>
				<form:input path="padecimientoForm.dosis1" class="form-control"/>
			</div>
			<c:set var="auxError"><form:errors path="padecimientoForm.dosis2"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="padecimientoForm.dosis2" class="control-label">Dosis 2:</form:label>
				<form:input path="padecimientoForm.dosis2" class="form-control"/>
			</div>
			<c:set var="auxError"><form:errors path="padecimientoForm.dosis3"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="padecimientoForm.dosis3" class="control-label">Dosis 3:</form:label>
				<form:input path="padecimientoForm.dosis3" class="form-control"/>
			</div>
			<c:set var="auxError"><form:errors path="padecimientoForm.medicamentos"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="padecimientoForm.medicamentos" class="control-label">Medicamentos:</form:label>
				<form:textarea path="padecimientoForm.medicamentos" class="form-control" rows="14" />
			</div>
		</div>
	</fieldset>
	
	<div class="col-sm-12 text-center">
		<input type="submit" class="btn btn-default" value="Guardar" />
		<input type="reset" class="btn btn-default" value="Limpiar" />
	</div>
</form>