<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Datos del Paciente</h2>
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
	<form:hidden path="pacienteForm.id"/>
	<fieldset>
		<legend>Personales</legend>
		
		<c:set var="auxError"><form:errors path="pacienteForm.nombre"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.nombre" class="control-label col-sm-3">Nombre:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.nombre" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.apellidoPaterno"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>" style="display:none">
			<form:label path="pacienteForm.apellidoPaterno" class="control-label col-sm-3">Ap.Paterno:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.apellidoPaterno" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.apellidoMaterno"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>" style="display:none">
			<form:label path="pacienteForm.apellidoMaterno" class="control-label col-sm-3">Ap.Materno:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.apellidoMaterno" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.fechaNacimientoString"/></c:set>
		<div class="form-group <c:if test='${not empty auxError || not empty fechaError}'>has-error</c:if>">
			<label class="control-label col-sm-3">Fecha Nacimiento</label>
			<div class="form-inline col-sm-9">
				<form:input path="pacienteForm.fechaNacimientoString" class="form-control" placeholder="DD-MM-AAAA" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.sexo"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.sexo" class="control-label col-sm-3">Sexo:</form:label>
			<div class="col-sm-6">
				<div class="radio-inline"><form:radiobutton path="pacienteForm.sexo" value="Masculino" label="Masculino" /></div>
				<div class="radio-inline"><form:radiobutton path="pacienteForm.sexo" value="Femenino" label="Femenino" /></div>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.estadoCivil"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.estadoCivil" class="control-label col-sm-3">Edo.Civil:</form:label>
			<div class="col-sm-6">
				<form:select path="pacienteForm.estadoCivil" class="form-control">
					<form:option value="Soltero" label="Soltero"/>
					<form:option value="Casado" label="Casado"/>
					<form:option value="Divorciado" label="Divorciado"/>
					<form:option value="Viudo" label="Viudo"/>
					<form:option value="ULibre" label="U.Libre"/>
					<form:option value="Pendiente" label="Pendiente"/>
				</form:select>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.ocupacion"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.ocupacion" class="control-label col-sm-3">Ocupación:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.ocupacion" class="form-control" />
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend>Direccion</legend>
		<c:set var="auxError"><form:errors path="pacienteForm.calleynum"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.calleynum" class="control-label col-sm-3">Calle y Número:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.calleynum" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.colonia"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.colonia" class="control-label col-sm-3">Colonia:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.colonia" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.cp"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.cp" class="control-label col-sm-3">C.P.:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.cp" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.pais"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.pais" class="control-label col-sm-3">País:</form:label>
			<div class="col-sm-6">
				<div class="radio-inline">
					<form:radiobutton path="pacienteForm.pais" value="México" label="México" 
					onclick="$('#otro_pais').css('display','none');$('#otro_estado').css('display','none');$('#estados').css('display','block')" />
				</div>
				<div class="radio-inline">
					<form:radiobutton path="pacienteForm.pais" value="otro" label="Otro"
					onclick="$('#otro_pais').css('display','block');$('#otro_estado').css('display','block');$('#estados').css('display','none');$('#estado').val('otro')" />
				</div>
				<div id="otro_pais" <c:if test='${pacienteForm.pais=="otro"}'>style="display:block"</c:if><c:if test='${pacienteForm.pais!="otro"}'>style="display:none"</c:if>>
					<form:input path="pacienteForm.otroPais" class="form-control" />
				</div>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.estado"/></c:set>
			<div class="form-group <c:if test='${not empty auxError}'>has-error</c:if>">
			<label class="control-label col-sm-3">Estado:</label>
			<div class="col-sm-6">
				<div id="estados" style="display:<c:if test='${pacienteForm.pais!="otro"}'>block</c:if><c:if test='${pacienteForm.pais=="otro"}'>none</c:if>">
				<form:select path="pacienteForm.estado" class="form-control">
					<form:option value="otro" label="Selecciona un estado.."/>
					<form:option value="Aguascalientes" label="Aguascalientes" />
					<form:option value="Baja California" label="Baja California" />
					<form:option value="Baja California Sur" label="Baja California Sur" />
					<form:option value="Campeche" label="Campeche" />
					<form:option value="Chiapas" label="Chiapas" />
					<form:option value="Chihuahua" label="Chihuahua" />
					<form:option value="Coahuila" label="Coahuila" />
					<form:option value="Colima" label="Colima" />
					<form:option value="Distrito Federal" label="Distrito Federal" />
					<form:option value="Durango" label="Durango" />
					<form:option value="Guanajuato" label="Guanajuato" />
					<form:option value="Guerrero" label="Guerrero" />
					<form:option value="Hidalgo" label="Hidalgo" />
					<form:option value="Jalisco" label="Jalisco" />
					<form:option value="Estado de México" label="Estado de México" />
					<form:option value="Michoacán" label="Michoacán" />
					<form:option value="Morelos" label="Morelos" />
					<form:option value="Nayarit" label="Nayarit" />
					<form:option value="Nuevo León" label="Nuevo León" />
					<form:option value="Oaxaca" label="Oaxaca" />
					<form:option value="Puebla" label="Puebla" />
					<form:option value="Querétaro" label="Querétaro" />
					<form:option value="Quintana Roo" label="Quintana Roo" />
					<form:option value="San Luis Potosí" label="San Luis Potosí" />
					<form:option value="Sinaloa" label="Sinaloa" />
					<form:option value="Sonora" label="Sonora" />
					<form:option value="Tabasco" label="Tabasco" />
					<form:option value="Tamaulipas" label="Tamaulipas" />
					<form:option value="Tlaxcala" label="Tlaxcala" />
					<form:option value="Veracruz" label="Veracruz" />
					<form:option value="Yucatán" label="Yucatán" />
					<form:option value="Zacatecas" label="Zacatecas" />
				</form:select>
				</div>
				<div id="otro_estado" <c:if test='${pacienteForm.pais=="otro"}'>style="display:block"</c:if><c:if test='${pacienteForm.pais!="otro"}'>style="display:none"</c:if>>
					<form:input path="pacienteForm.otroEstado" class="form-control" />
				</div>
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.ciudad"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.ciudad" class="control-label col-sm-3">Ciudad:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.ciudad" class="form-control" />
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend>Adicionales</legend>
		
		<c:set var="auxError"><form:errors path="pacienteForm.telefono"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.telefono" class="control-label col-sm-3">Teléfono:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.telefono" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.rfc"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>" style="display:none">
			<form:label path="pacienteForm.rfc" class="control-label col-sm-3">R.F.C.:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.rfc" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.recomendado"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.recomendado" class="control-label col-sm-3">Recomendado:</form:label>
			<div class="col-sm-6">
				<form:input path="pacienteForm.recomendado" class="form-control" />
			</div>
		</div>
		
		<c:set var="auxError"><form:errors path="pacienteForm.observaciones"/></c:set>
		<div class="form-group inline <c:if test='${not empty auxError}'>has-error</c:if>">
			<form:label path="pacienteForm.observaciones" class="control-label col-sm-3">Observaciones:</form:label>
			<div class="col-sm-6">
				<form:textarea path="pacienteForm.observaciones" class="form-control" rows="5"/>
			</div>
		</div>
	</fieldset>
		<div class="col-sm-12 text-center">
			<input type="submit" class="btn btn-default" value="Guardar" />
			<input type="reset" class="btn btn-default" value="Limpiar" />
		</div>
</form>