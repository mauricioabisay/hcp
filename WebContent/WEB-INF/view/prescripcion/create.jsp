<script>
$(document).ready(function() {
	   $("#siguienteCita").datepicker({ dateFormat: 'dd/mm/yy' });
});
</script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Prescripción</h2>
<c:if test='${not empty errors}'>
<div class="has-error">
<ul>
<c:forEach var="e" items="${errors}">
<li>${e}</li>
</c:forEach>
</ul>
</div>
</c:if>

<form id="myForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/prescripcion/<c:if test='${prescripcionForm.id==0}'>create</c:if><c:if test='${prescripcionForm.id>0}'>update/${prescripcionForm.id}</c:if>"> 	
	<ul class="nav nav-pills nav-justified">
		<li <c:if test='${prescripcionForm.plantilla==1}'>class="active"</c:if>><a href="#" onclick="$('#myForm').attr('action','${pageContext.request.contextPath}/prescripcion/create/1');$('#myForm').submit()">Plantilla 1</a></li>
		<li <c:if test='${prescripcionForm.plantilla==2}'>class="active"</c:if>><a href="#" onclick="$('#myForm').attr('action','${pageContext.request.contextPath}/prescripcion/create/2');$('#myForm').submit()">Plantilla 2</a></li>
		<li <c:if test='${prescripcionForm.plantilla==3}'>class="active"</c:if>><a href="#" onclick="$('#myForm').attr('action','${pageContext.request.contextPath}/prescripcion/create/3');$('#myForm').submit()">Plantilla 3</a></li>
		<li <c:if test='${prescripcionForm.plantilla==4}'>class="active"</c:if>><a href="#" onclick="$('#myForm').attr('action','${pageContext.request.contextPath}/prescripcion/create/4');$('#myForm').submit()">Plantilla 4</a></li>
	</ul>
	<form:hidden path="prescripcionForm.id"/>
	<form:hidden path="prescripcionForm.paciente"/>
	<form:hidden path="prescripcionForm.plantilla"/>
	<form:hidden path="prescripcionForm.medicamentos"/>
	<fieldset>
		<legend>Prescripcion</legend>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label col-sm-4">Nombre Paciente:</label>
				<div class="col-sm-8">
					<input type="text" value="${paciente.nombre}&nbsp;${paciente.apellidoPaterno}&nbsp;${paciente.apellidoMaterno}" disabled="disabled" class="form-control"/>
				</div>
			</div>
			<c:set var="auxDay"><form:errors path="prescripcionForm.siguienteCita"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.siguienteCita" class="control-label col-sm-4">Sig.Cita:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.siguienteCita" class="form-control" />
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.dosis1"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.dosis1" class="control-label col-sm-4">Dosis Nº1:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.dosis1" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.dosis2"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>" <c:if test='${prescripcionForm.plantilla==1}'>style="display:none"</c:if>>
				<form:label path="prescripcionForm.dosis2" class="control-label col-sm-4">Dosis Nº2:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.dosis2" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.dosis3"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>" <c:if test='${prescripcionForm.plantilla<4}'>style="display:none"</c:if>>
				<form:label path="prescripcionForm.dosis3" class="control-label col-sm-4">Dosis Nº3:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.dosis3" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.indicacionesAdicionales"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.indicacionesAdicionales" class="control-label col-sm-4">Adicionales:</form:label>
				<div class="col-sm-8">
					<form:textarea path="prescripcionForm.indicacionesAdicionales" class="form-control" rows="10" />
				</div>
			</div>
		</div>
		
		<div class="col-sm-5">
			<c:set var="auxError"><form:errors path="prescripcionForm.estatura"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.estatura" class="control-label col-sm-4">Estatura:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.estatura" class="form-control"/>
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.peso"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.peso" class="control-label col-sm-4">Peso:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.peso" class="form-control" />
				</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.glucosa"/></c:set>
			<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>" <c:if test='${prescripcionForm.plantilla!=3}'>style="display:none"</c:if>>
				<form:label path="prescripcionForm.glucosa" class="control-label col-sm-4">Glucosa:</form:label>
				<div class="col-sm-8">
					<form:input path="prescripcionForm.glucosa" class="form-control" />
				</div>
			</div>
			<c:set var="auxSistolica"><form:errors path="prescripcionForm.presionSistolica"/></c:set>
			<c:set var="auxDiastolica"><form:errors path="prescripcionForm.presionDiastolica"/></c:set>
			<div class="form-group <c:if test='${not empty auxSistolica && not empty auxDiastolica}'>has-error</c:if>">
				<label class="control-label col-sm-4">Presión Arterial</label>
					<div class="input-group col-sm-8">
						<div <c:if test='${not empty auxSistolica}'>class="has-error"</c:if>>
							<form:input path="prescripcionForm.presionSistolica" class="form-control"/>
						</div>
						<div class="input-group-addon">/</div>
						<div <c:if test='${not empty auxDiastolica}'>class="has-error"</c:if>>
							<form:input path="prescripcionForm.presionDiastolica" class="form-control"/>
						</div>
					</div>
			</div>
			<c:set var="auxError"><form:errors path="prescripcionForm.indicaciones"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
				<form:label path="prescripcionForm.indicaciones" class="control-label col-sm-4">Indicaciones:</form:label>
				<div class="col-sm-8">
					<form:textarea path="prescripcionForm.indicaciones" class="form-control" rows="10" />
				</div>
			</div>
		</div>
	</fieldset>
	
	<div class="col-sm-12 text-center">
		<input type="submit" class="btn btn-default" value="Guardar" />
		<input type="reset" class="btn btn-default" value="Limpiar" />
	</div>
</form>