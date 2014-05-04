$(document).ready(function(){
	$(".alert").hide();
	
	//objeto json para envio
	var Turma = {
			  "nomeTurma" : null,
			  "previsaoInicio" : null,
			  "previsaoTermino" : null,
			  "valorCurso" : null,
			  "vagasDisponiveis" : null,
			  "horariosAulas":[],
			  "materia":{"id": null}
			  };
	
	//data inicio data termino
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp
			.getDate(), 0, 0, 0, 0);

	var checkin = $('#dpd1').datepicker({
		onRender : function(date) {
			return date.valueOf() < now.valueOf() ? 'disabled' : '';
		}
	}).on('changeDate', function(ev) {
		if (ev.date.valueOf() > checkout.date.valueOf()) {
			var newDate = new Date(ev.date)
			newDate.setDate(newDate.getDate() + 1);
			checkout.setValue(newDate);
		}
		checkin.hide();
		$('#dpd2')[0].focus();
	}).data('datepicker');
	var checkout = $('#dpd2').datepicker({
		onRender : function(date) {
			return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
		}
	}).on('changeDate', function(ev) {
		checkout.hide();
	}).data('datepicker');
	
	//adicionar horario
	$("#add").click(function() {
		
		$("#table_horarios").append(
				"<tr>" +
				"<td>"+$("#dia_semana option:selected").text() + "</td>" +
				"<td>"+ $("#hora_inicio").val() +"</td>" +
				"<td>"+ $("#hora_fim").val() +"</td>" +
				"<td><button type='button' class='btn btn-danger btn-flat pull-right remove_row'><div class='glyphicon glyphicon-trash'></div></button></td>" +
				"</tr>").html();
$("#myModal").modal('toggle');
criarJsonTurma($("#dia_semana option:selected").text(),$("#hora_inicio").val(), $("#hora_fim").val());
$("#hora_inicio").val("");
$("#hora_fim").val("");

});
	//remover row
	$(document).on('click', '.remove_row', function() {
		delete Turma.horariosAulas.splice(($(this).parents("tr").index() - 1),1);
		$(this).closest("tr").remove();
	});
	
	//add valores de horarios
	function criarJsonTurma(week, begin, end){
		Turma.horariosAulas.push({"diaSemana" : week, "horarioInicio": begin,"horarioTermino" : end});
	};
	
	//requisicao ajax
		$("#salvarBtn").click(function(){
			$(".alert").hide();
			//objeto json para envio
			Turma.nomeTurma = $("#nomeTurma").val();
			Turma.previsaoInicio = $("#dpd1").val();
			Turma.previsaoTermino = $("#dpd2").val();
			Turma.valorCurso = $("#valorCurso").val();
			Turma.vagasDisponiveis = $("#vagasDisponiveis").val();
			Turma.materia.id = $("#materiaId").val();
			getRowsEdit();
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(Turma),
				dataType: "json", 
				url: "/scai_projectV-web/cadastrar-turma",
	            processData:false,
				statusCode: {
				    404: function() {
				      emptyMessages();
				      $(".alert-warning").append("<strong>AVISO!</strong> Não foi possível cadastrar turma. <strong>Error 404</strong>: Página solicitada não encontrada.").show(400);
				      hideMessages();
				    },
					200: function(){
						emptyMessages();
					    $(".alert-success").append("<strong>FEITO!</strong> Turma cadastrada com <strong>sucesso!</strong>").show(400);
					    hideMessages();
					    clearFields();
					},
					500: function(){
						emptyMessages();
					    $(".alert-danger").append("<strong>ERRO!</strong> Página solicitada não encontrada! Error <strong>500</strong>: Entre em contato com o administrador!").show(400);
					    hideMessages();
					}
				}
		    });
		});
	
});

function emptyMessages(){
	$(".alert").empty();
	
}

function hideMessages(){
	$(".alert").delay(10000).hide(1300);
}

function clearFields(){
	$("#nomeTurma").val("");
	$("#dpd1").val("");
	$("#dpd2").val("");
	$("#valorCurso").val("");
	$("#vagasDisponiveis").val("");
	$('#materiaId :nth-child(0)').prop('selected', true); 
	$("#table_horarios tr").detach();
	
	$("#table_horarios").append(
			"<tr width='40%'>" +
			"<th width='40%'><span class='glyphicon glyphicon-calendar'></span> Dia da semana</th>" +
			"<th width='20%'><span class='glyphicon glyphicon-time'></span> Horário de inicío</th>" +
			"<th width='20%'><span class='glyphicon glyphicon-time'></span> Horário de término</th>" +
			"<th width='10%'><span class='glyphicon glyphicon-trash'></span> Remover</th>" +
			"</tr>").html();
}

function getRowsEdit(){
}
