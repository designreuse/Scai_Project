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
	
});