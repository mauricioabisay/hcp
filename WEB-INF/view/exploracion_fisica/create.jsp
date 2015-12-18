<script>
function calcularPesoIdeal() {
	var url = '<c:out value="${pageContext.request.contextPath}/peso/"/>' + $('#estatura').val() + '/<c:out value="${paciente.sexo}" />';
	$.ajax(url).done(
		function(data){
			$('#pesoIdeal').val(data);
		}
	)	
}
</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Exploración Física</h2>
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
	<form:hidden path="exploracionFisicaForm.id"/>
	<form:hidden path="exploracionFisicaForm.paciente"/>
	
	<div class="col-sm-6">
		<fieldset><legend>Peso y Estatura</legend>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.peso"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.peso" class="control-label col-sm-2">Peso</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.peso" class="form-control" />
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.estatura"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.estatura" class="control-label col-sm-2">Estatura</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.estatura" class="form-control" onchange="calcularPesoIdeal()" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="exploracionFisicaForm.pesoIdeal" class="control-label col-sm-2">Peso Ideal</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.pesoIdeal" class="form-control" disabled="disabled" />
				</div>
			</div>
		</fieldset>
	</div>
	<div class="col-sm-6">
		<fieldset><legend>Signos Vitales</legend>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.temperatura"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.temperatura" class="control-label col-sm-2">Temperatura</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.temperatura" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.glucosa"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.glucosa" class="control-label col-sm-2">Glucosa</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.glucosa" class="form-control"/>
				</div>
			</div>
			<c:set var="auxSistolica"><form:errors path="exploracionFisicaForm.presionSistolica"/></c:set>
			<c:set var="auxDiastolica"><form:errors path="exploracionFisicaForm.presionDiastolica"/></c:set>
			<div class="form-group <c:if test='${not empty auxSistolica && not empty auxDiastolica}'>has-error</c:if>">
				<label class="control-label col-sm-2">Presión Arterial</label>
				<div class="col-sm-4">
					<div class="input-group">
						<div <c:if test='${not empty auxSistolica}'>class="has-error"</c:if>>
							<form:input path="exploracionFisicaForm.presionSistolica" class="form-control"/>
						</div>
						<div class="input-group-addon">/</div>
						<div <c:if test='${not empty auxDiastolica}'>class="has-error"</c:if>>
							<form:input path="exploracionFisicaForm.presionDiastolica" class="form-control"/>
						</div>
					</div>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.frecuenciaCardiaca"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.frecuenciaCardiaca" class="control-label col-sm-2">Frec. Cardiaca</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.frecuenciaCardiaca" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="exploracionFisicaForm.frecuenciaRespiratoria"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="exploracionFisicaForm.frecuenciaRespiratoria" class="control-label col-sm-2">Frec. Respiratoria</form:label>
				<div class="col-sm-4">
					<form:input path="exploracionFisicaForm.frecuenciaRespiratoria" class="form-control"/>
				</div>
			</div>
		</fieldset>
	</div>
	
	
	<div class="col-sm-12">
		<fieldset><legend>Observaciones</legend>
		<c:set var="auxError"><form:errors path="exploracionFisicaForm.observaciones"/></c:set>
		<div <c:if test='${not empty auxError}'>class="has-error"</c:if>>
			<form:textarea path="exploracionFisicaForm.observaciones" class="form-control" rows="3"/>
		</div>
		</fieldset>
	</div>
	
	<div class="form-group col-md-12">
		<div align="center">
			<input type="submit" class="btn btn-default" value="Enviar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
	</div>
</form>