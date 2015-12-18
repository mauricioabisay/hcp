<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class="page-header">Historia Clínica Legada</h2>
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
	<fieldset>
		<legend>Historia Clínica Legada</legend>
		<div class="form-group inline">
			<div class="col-sm-12">
				<textarea class="form-control" rows="25" readonly>${historiaClinica}</textarea>
			</div>
		</div>
	</fieldset>
	
	<div class="col-sm-12 text-center">
		<a href="${pageContext.request.contextPath}/historiaclinica/create"><button type="button" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nueva Historia Clínica
		</button></a>
	</div>
</form>