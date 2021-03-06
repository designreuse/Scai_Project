<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="/scai_projectV-web/js/blockUI.js"></script>
<script src="/scai_projectV-web/js/aluno/form.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Novo aluno - dados pessoais</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12" ng-app="validationApp" ng-controller="mainController">

						<c:if test="${msgType.equals('success')}">
							<div class="alert alert-success">
								<a href="#" class="alert-link">${msg}</a>
							</div>
						</c:if>
						<c:if test="${msg.equals('alert')}">
							<div class="alert alert-info">
								<a href="#" class="alert-link">${msg}</a>
							</div>
						</c:if>
						<c:if test="${msg.equals('warning')}">
							<div class="alert alert-warning">
								<a href="#" class="alert-link">${msg}</a>
							</div>
						</c:if>
						<c:if test="${msgType == ('danger')}">
							<div class="alert alert-danger">
								<a href="#" class="alert-link">${msg}</a>
							</div>
						</c:if>

						<form:form action="/scai_projectV-web/aluno-cadastrar/"
							method="POST" modelAttribute="aluno" class="form-horizontal"
							id="form-main" ng-submit="submitForm(userForm.$valid)" name="userForm">
							
							<div class="step1">
								<div class="form-group">
									<form:label class="col-sm-2" path="nome">Nome:</form:label>
									<div class="col-xs-9">
										<form:input type="text" class="form-control" ng-model="user.name"
											placeholder="Nome do aluno" path="nome" value="${aluno.nome}"></form:input>
									</div>
									<form:hidden path="id" value="${aluno.id}" />
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="dataNascimento">Nascimento:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control datepicker"
											placeholder="Data nascimento" path="dataNascimento"></form:input>
									</div>

									<form:label class="col-sm-1" path="dataNascimento">Sexo:</form:label>
									<div class="col-xs-4">
										<form:select path="sexo" class="form-control" value="${aluno.sexo}">
											<option value="masculino">Masculino</option>
											<option value="feminino">Feminino</option>
										</form:select>

									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="rg">RG:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control RG"
											placeholder="Registro geral" path="rg" value="${aluno.rg}"></form:input>
									</div>

									<form:label class="col-sm-1" path="cpf">CPF:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control cpf"
											placeholder="Cadastro pessoal fisíca" path="cpf" value="${aluno.cpf}"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label path="cidade.estado" class="col-sm-2">Estado:</form:label>
									<div class="col-xs-9">
										<form:select path="cidade.estado" class="form-control" value="${aluno.cidade.estado}"
											id="estado">
											<form:option value="SAO_PAULO">São Paulo</form:option>
											<form:option value="MINAS_GERAIS">Minas Gerais</form:option>
											<form:option value="MATO_GROSSO">Moto Grosso</form:option>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<form:label path="cidade.nome" class="col-sm-2">Estado:</form:label>
									<div class="col-xs-9">
										<form:select path="cidade.nome" class="form-control" value="${aluno.cidade.nome}">
											<form:option value="SAO_PAULO">Fernandópolis</form:option>
											<form:option value="MINAS_GERAIS">Jales</form:option>
											<form:option value="MATO_GROSSO">São José dos Campos</form:option>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<form:label path="cidade.cep" class="col-sm-2" >CEP:</form:label>
									<div class="col-sm-9">
										<form:input path="cidade.cep" placeholder="Cep" value="${aluno.cidade.cep}"
											class="form-control cep" type="text" />
									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="ddd">Telefone:</form:label>
									<div class="col-xs-1">
										<form:input type="text" class="form-control ddd"
											placeholder="DDD" path="ddd" value="${aluno.ddd}"></form:input>
									</div>
									<div class="col-xs-8">
										<form:input type="text" class="form-control phone"
											placeholder="Número do telefone" path="telefone" value="${aluno.telefone}"></form:input>
									</div>
								</div>
								<div class="form-group">
									<form:label path="email" class="col-sm-2">E-mail:</form:label>
									<div class="col-sm-9">
										<form:input path="email" class="form-control" type="text"
											placeholder="E-mail" value="${aluno.email}" />
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-primary nextStep">Seguinte</button>
								</div>


							</div>
							<div class="step2">
								<div class="form-group">
									<form:label class="col-sm-2" path="pagamento.tipoPagamento">Pagamento:</form:label>
									<div class="col-xs-8">
										<form:select class="form-control"
											path="pagamento.tipoPagamento" id="tpPagamento" value="${aluno.pagamento.tipoPagamento}">
											<option value="A_VISTA">à Vista</option>
											<option value="CARTAO">Cartão - PagSeguro</option>
											<option value="PARCELAMENTO">Mensalidade</option>
											<option value="NAO_DEFINIDO">Outro</option>
										</form:select>
									</div>
									<div class="col-xs-1 money-icon">
										<img src="/scai_projectV-web/images/cash32.png" alt="à Vista">
									</div>
									<div class="col-xs-1 card-icon">
										<img src="/scai_projectV-web/images/pagseguro.jpg"
											alt="Cartão - PagSeguro">
									</div>
									<div class="col-xs-1 boleto-icon">
										<img src="/scai_projectV-web/images/boleto.png"
											alt="Mensalidade">
									</div>
									<div class="col-xs-1 none-icon">
										<img src="/scai_projectV-web/images/none.png" alt="Outro">
									</div>
								</div>

								<div class="form-group" id="parcelas">
									<form:label class="col-sm-2"  path="pagamento.tipoPagamento">Qnt Parcela:</form:label>
									<div class="col-xs-9">
										<form:select class="form-control"
											path="pagamento.quantidadeParcela">
											<option value="1">1 Parcela</option>
											<option value="2">2 Parcelas</option>
											<option value="3">3 Parcelas</option>
											<option value="4">4 Parcelas</option>
											<option value="5">5 Parcelas</option>
											<option value="6">6 Parcelas</option>
											<option value="7">7 Parcelas</option>
											<option value="8">8 Parcelas</option>
											<option value="9">9 Parcelas</option>
											<option value="10">10 Parcelas</option>
											<option value="11">11 Parcelas</option>
											<option value="12">12 Parcelas</option>
										</form:select>
									</div>
								</div>

								<div class="form-group" id="diaVencimento">
									<form:label class="col-sm-2" path="pagamento.diaVencimento">Dia de vencimento:</form:label>
									<div class="col-xs-9" >
										<form:input type="text" class="form-control"
											placeholder="Dia do vencimento da mensalidade" 
											path="pagamento.diaVencimento"></form:input>
									</div>
								</div>
								
								<div class="form-group" id="obs">
									<form:label class="col-sm-2" path="pagamento.observacao" >Observações:</form:label>
									<div class="col-xs-9" > 
										<form:textarea type="text" class="form-control"
											placeholder="Observações gerais sobre o pagamento"  value="${aluno.pagamento.observacao}"
											path="pagamento.observacao"></form:textarea>
									</div>
								</div>

								<div class="modal-footer">
									<button type="button"
										class="btn btn-primary backStep pull-left">Voltar</button>
									<button type="submit" id="btnCadastrar" class="btn btn-primary">Cadastrar</button>
								</div>

							</div>

							<script type="text/javascript">
								$('.datepicker').datepicker();
							</script>

						</form:form>

					</div>

					<!-- /.col (RIGHT) -->
				</div>
				<!-- /.row -->
			</div>
			<!-- box-footer -->
		</div>
		<!-- /.box -->
	</div>
	<!-- /.col (MAIN) -->
</div>
<!-- MAILBOX END --> </section> <!-- /.content --> </aside>
<!-- /.right-side -->

<script>
	$(document).ready(function() {
		$('#btnCadastrar').click(function() {
			$.blockUI({
				message: '<h1><img src="/scai_projectV-web/images/loader.gif" /> Processando...</h1>'
			});
		});
	});
</script>
