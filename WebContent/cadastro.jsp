<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<style>
div {
	padding-top: 5px
}
</style>
</head>
<body>
	<div>
		<input type="text" id="nuProc" placeholder="Processo..." value="WO2002008676">
		<button type="button" onclick="buscarProcesso()">Buscar</button>
	</div>

	<div id="dados" style="display: none">
		<form action="cadastrar" method="post">
		
			<input type="hidden" name="nuProcessp" id="nuProcesso">
			<div>
				<label>Nº de pub</label> <input type="text" id="nuPub" name="nuPub">
			</div>
			<div>
				<label>Nº do pedido internacional</label> <input type="text"
					id="nuPedido" name="nuPedido">
			</div>
			<div>
				<label>Data de publicação</label> <input type="text" id="dtPublic"
					name="dtPublic">
			</div>
			<div>
				<label>Requerentes</label> <input type="text" id="requerentes"
					name="requerentes">
			</div>
			<div>
				<label>Tí­tulo</label> <input type="text" id="titulo" name="titulo">
			</div>
			<div>
				<input type="submit" value="Gravar" />
			</div>
		</form>
	</div>

	<div id="semResultado" style="display: none">
		<p>Nenhum dado encontrado!</p>
	</div>
</body>
</html>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	function buscarProcesso() {
		//console.log($('#nuProcesso').val())
		$('#dados').show()
		$('#semResultado').show()
		$('#nuProcesso').val($('#nuProc').val())

		//console.log('https://patentscope.wipo.int/search/pt/detail.jsf?docId='
		//		+ $('#nuProcesso').val() + '&redirectedID=true')

		jQuery.support.cors = true;
		
		$.ajax({
			url : 'https://patentscope.wipo.int/search/pt/detail.jsf?docId='+ $('#nuProc').val() + '&redirectedID=true',
			method: "GET",
			crossDomain: true,
			dataType : "json",
			success: function(data) {
                console.log('data', data)
            }
		})
	}
</script>
