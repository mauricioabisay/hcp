<br/>
<br/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<a href="${pageContext.request.contextPath}/usuario/create"><button type="button" class="btn btn-default btn-sm">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Usuario
</button></a>


<table class="table table-hover" style="padding-left:25%; padding-right:25%">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Usuario</th>
			<th>Opc.</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty list}">
		<c:forEach var="i" items="${list.content}">  
		<tr>
			<td>${i.firma}</td>
			<td>${i.usuario}</td>
			<td>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/usuario/retrieve/${i.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
						</button>
					</a>
					<!--  
					<a href="${pageContext.request.contextPath}/usuario/update/${i.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</a>
					-->
					<a href="${pageContext.request.contextPath}/usuario/delete/${i.id}">
						<button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
					</a>
				</div>
			</td>
		</tr>
		</c:forEach>
		</c:if>
	</tbody>
</table>
<c:if test="${list.totalPages > 1}">
	<nav class="text-center">
	  <ul class="pagination">
	    <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
	    <c:forEach var="page" begin="${0}" end="${list.totalPages - 1}">
	    	<li><a href="${pageContext.request.contextPath}/usuario/list?page=${page}">${page+1}</a></li>
	    </c:forEach>
	    <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
	  </ul>
	</nav>
</c:if>