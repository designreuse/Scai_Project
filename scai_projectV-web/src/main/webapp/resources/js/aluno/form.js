$(document).ready(function(){
	
	$(".step2").hide();
	
	$(".nextStep").click(function(){
		$(".step1").hide();
		$(".step2").show(300);
		$(".tituloPage").empty().append("Novo aluno - dados pagamento");
	});
	
	$(".backStep").click(function(){
		$(".tituloPage").empty().append("Novo aluno - dados pessoais");
		$(".step2").hide();
		$(".step1").show(300);
	});
	
	//alterar icone do pagamento
	$(".card-icon").hide();
	$(".boleto-icon").hide();
	$(".none-icon").hide();
	$("#parcelas").hide(300);
	$("#diaVencimento").hide(300);
	var iconeAtual = ".money-icon";
	
	$("#tpPagamento").change(function(){
		if($(this).val() == "CARTAO"){
			$(iconeAtual).hide(300);
			$(".card-icon").show(300);
			iconeAtual = ".card-icon"; 
			//hide inputs
			$("#parcelas").hide(300);
			$("#diaVencimento").hide(300);
		}else if($(this).val() == "A_VISTA"){
			$(iconeAtual).hide(300);
			$(".money-icon").show(300);
			iconeAtual = ".money-icon"; 
			//hide inputs
			$("#parcelas").hide(300);
			$("#diaVencimento").hide(300);
		}else if($(this).val() == "PARCELAMENTO"){
			$(iconeAtual).hide(300);
			$(".boleto-icon").show(300);
			iconeAtual = ".boleto-icon"; 
			//hide inputs
			$("#parcelas").show(300);
			$("#diaVencimento").show(300);
		}else if($(this).val() == "NAO_DEFINIDO"){
			$(iconeAtual).hide(300);
			$(".none-icon").show(300);
			iconeAtual = ".none-icon"; 
			$("#parcelas").show(300);
			$("#diaVencimento").show(300);
		}
	});
	
});