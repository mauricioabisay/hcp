<c:if test='${empty usuario}'>
<form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/login">
<fieldset>
	<legend>Inicio Sesión</legend>
	<div class="form-group <c:if test='${not empty userCampo.error}'>has-error</c:if>">
		<label class="control-label col-sm-4">Usuario</label>
		<div class="col-sm-4">
			<input type="text" name="user" class="form-control" />
		</div>
	</div>
	<div class="form-group <c:if test='${not empty passCampo.error}'>has-error</c:if>">
		<label class="control-label col-sm-4">Contraseña</label>
		<div class="col-sm-4">
			<input type="password" name="pass" class="form-control" />	
		</div>
	</div>
	<div class="col-sm-8 text-center">
		<input type="submit" class="btn btn-default" />
	</div>
</fieldset>
</form>
</c:if>
<c:if test='${not empty usuario}'>
<c:redirect url="welcome/" />
</c:if>