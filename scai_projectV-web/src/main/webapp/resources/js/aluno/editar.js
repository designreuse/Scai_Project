$(document).ready(function(){
	$("#btn_editar_dados_pessoais").click(function(){
		$("#inp_nome").prop('disabled', false);
		$("#inp_datanascimento").prop('disabled', false);
		$("#inp_rg").prop('disabled', false);
		$("#inp_cpf").prop('disabled', false);
		$("#sel_sexo").prop('disabled', false);
		$("#sel_estado").prop('disabled', false);
		$("#inp_cidade").prop('disabled', false);
		$("#inp_ddd").prop('disabled', false);
		$("#inp_cep").prop('disabled', false);
		$("#inp_telefone").prop('disabled', false);
		$("#inp_email").prop('disabled', false);
	});
});