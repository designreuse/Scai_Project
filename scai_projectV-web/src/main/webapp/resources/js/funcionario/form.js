$(document).ready(function(){
	$(".step2").hide();
	
	$(".nextStep").click(function(){
		$(".step1").hide();
		$(".step2").show(300);
		$(".tituloPage").empty().append("Novo Auxiliar - Dados Institucionais");
	});
	
	$(".backStep").click(function(){
		$(".tituloPage").empty().append("Novo Auxiliar - Dados Pessoais");
		$(".step2").hide();
		$(".step1").show(300);
	});
	
	$("#acesso_sistema").change(function(){
		if($("#acesso_sistema").val() == "SEM_ACESSO"){
			$(".form_login").hide(300);
		}else if($("#acesso_sistema").val() != "SEM_ACESSO"){
			$(".form_login").show(300);
		}
	});
	
});