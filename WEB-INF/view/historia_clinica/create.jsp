<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Historia Clínica</h2>
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
	<form:hidden path="historiaClinicaForm.id"/>
	<form:hidden path="historiaClinicaForm.paciente"/>
	<fieldset>
		<legend>Historia Clínica</legend>
		
		<c:set var="auxError"><form:errors path="historiaClinicaForm.historia"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<div class="col-sm-12">
				<form:textarea path="historiaClinicaForm.historia" class="form-control" rows="20" />
			</div>
		</div>
	</fieldset>
	
	<div class="col-sm-12 text-center">
		<input type="submit" class="btn btn-default" value="Guardar" />
		<input type="reset" class="btn btn-default" value="Limpiar" />
	</div>
</form>