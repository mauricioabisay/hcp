<h2 class="page-header no-printable">Prescripción ${prescripcionForm.fechaString}</h2>
<div class="panel panel-primary">
	<div class="panel-heading no-printable">
		<h3 class="panel-title">Prescripción</h3>
	</div>
	<div class="panel-body">
	
		<div class="col-sm-6 print-column-50 print-left">
			<div class="print-block">
				<span class="col-sm-4 text-right">Nombre Paciente:</span>
				<span class="col-sm-8">${paciente.nombre}&nbsp;${paciente.apellidoPaterno}&nbsp;${paciente.apellidoMaterno}</span>
			</div>
			<div class="print-block">
				<span class="col-sm-4 text-right">Dosis Nº1:</span>
				<span class="col-sm-8">${prescripcionForm.dosis1}&nbsp;</span>
			</div>
			<div class="print-block" <c:if test='${empty prescripcionForm.dosis2}'>style="display:none"</c:if>>
				<span class="col-sm-4 text-right">Dosis Nº2:</span>
				<span class="col-sm-8">${prescripcionForm.dosis2}&nbsp;</span>
			</div>
			<div class="print-block" <c:if test='${empty prescripcionForm.dosis3}'>style="display:none"</c:if>>
				<span class="col-sm-4 text-right">Dosis Nº3:</span>
				<span class="col-sm-8">${prescripcionForm.dosis3}&nbsp;</span>
			</div>
			
			<div class="print-block print-column-100 print-right">
				<pre><span style="font-size: large; font-family: Helvetica Neue,Helvetica,Arial,sans-serif">${prescripcionForm.indicacionesAdicionales}</span></pre>
			</div>
			
			<c:if test='${prescripcionForm.plantilla==3}'>
				<p class="col-sm-12 print-block print-column-100 print-p-smaller">
					<span style="font-weight:bold;text-decoration:underline;">ALIMENTOS PERMITIDOS</span>
					Carne de buey, aves, jamón, sesos, riñones, lengua y pescados. Huevos crudos o tibios y quesos, además de una serie de
					verduras que deben de ser preparadas sin adhesión de harina como espinacas, pepinos, apios, berros, lechugas, nopales y 
					quelites. Fruta fresca, debemos consumir un máximo de 2 o 3 piezas al día, preferentemente durante el día y no en la cena.
					Pan de harina de centeno (pan negro).
				</p>
				<p class="col-sm-12 print-block print-column-100 print-p-smaller">
					<span style="font-weight:bold;text-decoration:underline;">BEBIDAS PERMITIDAS</span>
					Agua potable, agua mineral, caldo de carne y té (sin azúcar), leche descremada y productos que hayan cambiado en sus ingredientes 
					el azúcar por endulcorante.
				</p>
				<p class="col-sm-12 print-block print-column-100 print-p-smaller">
					<span style="font-weight:bold;text-decoration:underline;">ALIMENTOS PROHIBIDOS</span>
					Azúcar, pan, tortillas, pasteles y todos los alimentos preparados con harina, papas, arroz, marcarrones, frijoles, 
					lentejas y judias, golosinas, comidas dulces, miel, jaleas, mermeladas.
				</p>
				<p class="col-sm-12 print-block print-column-100 print-p-smaller">
					<span style="font-weight:bold;text-decoration:underline;">BEBIDAS PROHIBIDAS</span>
					Toda clase de vinos dulces y licores así como limonadas azucaradas, cervezas y atoles.
				</p>
			</c:if>
			
		</div>
		
		<div class="col-sm-6 print-column-50 print-right">
			<div class="print-block">
				<span class="col-sm-4 text-right print-inline print-column-50 print-left">Estatura:</span>
				<span class="col-sm-8 print-inline print-column-50 print-left">${prescripcionForm.estatura}&nbsp;</span>
			</div>
			<div class="print-block">
				<span class="col-sm-4 text-right print-inline print-column-50 print-left">Peso:</span>
				<span class="col-sm-8 print-inline print-column-50 print-right">${prescripcionForm.peso}&nbsp;</span>
			</div>
			<c:if test='${prescripcionForm.plantilla==3}'>
			<div class="print-block" <c:if test='${prescripcionForm.plantilla!=3}'>style="display:none"</c:if>>	
				<span class="col-sm-4 text-right print-inline print-column-50 print-left">Glucosa:</span>
				<span class="col-sm-8 print-inline print-column-50 print-right">${prescripcionForm.glucosa}&nbsp;</span>
			</div>
			</c:if>
			<div class="print-block">
				<span class="col-sm-4 text-right print-inline print-column-50 print-left">Presión Arterial:</span>
				<span class="col-sm-8 print-inline print-column-50 print-left">${prescripcionForm.presionSistolica}/${prescripcionForm.presionDiastolica}&nbsp;</span>
			</div>
			<div class="print-block">
				<span class="col-sm-4 text-right print-inline print-column-50 print-left">Siguiente Cita:</span>
				<span class="col-sm-8 print-inline print-column-50 print-left">${prescripcionForm.siguienteCita}</span>
			</div>
			<div class="print-block print-column-100 print-left">
				<pre><span style="font-size: large; font-family: Helvetica Neue,Helvetica,Arial,sans-serif">${prescripcionForm.indicaciones}</span></pre>
			</div>
		</div>
		
		
		<div class="col-sm-12 print-column-100 print-block print-small text-center print-footer" style="font-size: xx-small;display:none;">
			<span style="display:block;padding:0;margin:0">______________________________________</span>
			<span style="display:block;padding:0;margin:0">${usuario.firma}</span>
		</div>
	</div>
</div>
<div class="col-sm-12 text-center no-printable">
	<button class="btn btn-default" onclick="window.print();">Imprimir</button>	
	<a href="${pageContext.request.contextPath}/prescripcion/update/${prescripcionForm.id}"><button class="btn btn-default">Editar</button></a>
</div>