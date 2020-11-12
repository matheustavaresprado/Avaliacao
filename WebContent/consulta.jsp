<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar processos</title>
<style>
div {
	padding-top: 5px
}
</style>
</head>
<body>

	<div>
		<label>Nº do processo</label> <input type="text" id="nuProcesso">
	</div>
	<div>
		<label>Requerente</label> <input type="text" id="requerente">
	</div>
	<div>
		<button type="button" onclick="buscarProcesso()">Buscar</button>
	</div>

	<div id="processos" style="display: none">
		<table>
			<head>
			<th>Nº Processo</th>
			<th>Nº pub</th>
			<th>Nº do pedido internacional</th>
			<th>Data de publicação</th>
			<th>Requerentes</th>
			<th>Tí­tulo</th>
			</head>
			<tbody id="dados"></tbody>
		</table>
	</div>

	<div id="semResultado" style="display: none">
		<p>Nenhum registro encontrado!</p>
	</div>

</body>
</html>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	function buscarProcesso() {
		$.ajax({
			url : '/Avaliacao/cadastrar?nuProcesso=' + $('#nuProcesso').val()
					+ '&requerente=' + $('#requerente').val(),
			method : "GET",
			success : function(data) {
				console.log('data', data)

				if (data && data.length > 0) {

					var tx = "";
					$('#dados').html('')

					for (var i = 0; i < data.length; i++) {
						tx += "<tr>"

						tx += "<td>" + data[i].nuProcesso + "</td>"
						tx += "<td>" + data[i].nuPub + "</td>"
						tx += "<td>" + data[i].nuPedido + "</td>"
						tx += "<td>" + data[i].dtPublic + "</td>"
						tx += "<td>" + data[i].requerentes + "</td>"
						tx += "<td>" + data[i].titulo + "</td>"

						tx += "</tr>"
					}

					$('#dados').html(tx)
					
					$('#processos').show()
					$('#semResultado').hide()
				} else {
					$('#processos').hide()
					$('#semResultado').show()
				}

			}
		})
	}
</script>


















