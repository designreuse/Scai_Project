
$(document).ready(function(){
	$(".alert").hide();
	//capturar dados da tabela para remover linha selecionada
	$("#turma_table tbody").delegate("tr", "click", function () {
		oTable = $('#turma_table').dataTable();
	    iPos = oTable.fnGetPosition(this);
	});
	
	//request ajax
	$("#removerRegistro").click(function(){
		alert("teste: " + $("#bookId").val());
		$.ajax({
			type: "POST",
			url: "removerTurma/" + String($("#bookId").val()),
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			statusCode:{
				404: function(){
					$(".alert-warning").empty().append("<strong>AVISO!</strong> Não foi possível cadastrar turma. <strong>Error 404</strong>: Página solicitada não encontrada.").show().delay(10000).hide(1300);
				},
				200: function(){
					$(".alert-success").empty().append("<strong>FEITO!</strong> Turma removida com <strong>sucesso!</strong>").show().delay(10000).hide(1300);
					//remover linha selecionada
					 if (iPos !== null) {
					        oTable.fnDeleteRow(iPos);//delete row
					    }
				},
				500: function(){
					$(".alert-danger").empty().append("Erro 404").show().delay(10000).hide(1300);
				}
			}
		});
		$("#deleteRow").modal('toggle');
	});
});


$(document).ready(function() {
	/* Init DataTables */
	var oTable = $('#turma_table').dataTable();
	
	/* Apply the jEditable handlers to the table */
	$('td', oTable.fnGetNodes()).editable( '../examples_support/editable_ajax.php', {
		"callback": function( sValue, y ) {
			var aPos = oTable.fnGetPosition( this );
			oTable.fnUpdate( sValue, aPos[0], aPos[1] );
		},
		"submitdata": function ( value, settings ) {
			return {
				"row_id": this.parentNode.getAttribute('id'),
				"column": oTable.fnGetPosition( this )[2]
			};
		},
		"height": "14px"
	} );
} );

