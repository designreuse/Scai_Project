<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="/scai_projectV-web/js/aluno/editar.js"
	type="text/javascript"></script>
<script src="/scai_projectV-web/js/aluno/form.js" type="text/javascript"></script>
<!-- DATA TABES SCRIPT -->
<script
	src="/scai_projectV-web/js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script
	src="/scai_projectV-web/js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="/scai_projectV-web/js/AdminLTE/app.js"
	type="text/javascript"></script>
<script src="/scai_projectV-web/js/blockUI.js"></script>
<script src="/scai_projectV-web/js/aluno/form.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Editar aluno</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">

						<form:form action="/scai_projectV-web/aluno-cadastrar/"
							method="POST" modelAttribute="aluno" class="form-horizontal"
							id="form-main" name="userForm">

							<div class="panel-group" id="accordion">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"> Aluno - Dados pessoais</a>
										</h4>

									</div>
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<div class="col-sm-6"></div>
												<button class="btn btn-default btn-xs" type="button"
													id="btn_editar_dados_pessoais">Editar</button>
											</div>
											<div class="form-group">
												<form:label class="col-sm-2" path="nome">Nome:</form:label>


												<div class="col-xs-9">
													<form:input type="text" class="form-control"
														ng-model="user.name" placeholder="Nome do aluno"
														id="inp_nome" path="nome" value="${aluno.nome}"
														disabled="true"></form:input>
												</div>
												<form:hidden path="id" value="${aluno.id}" />
											</div>
											<div class="form-group">
												<form:label class="col-sm-2" path="dataNascimento">Nascimento:</form:label>
												<div class="col-xs-4">
													<form:input type="text" class="form-control datepicker"
														placeholder="Data nascimento" path="dataNascimento"
														id="inp_datanascimento" disabled="true"></form:input>
												</div>

												<form:label class="col-sm-1" path="dataNascimento">Sexo:</form:label>
												<div class="col-xs-4">
													<form:select path="sexo" class="form-control" id="sel_sexo"
														disabled="true" value="${aluno.sexo}">
														<option value="masculino">Masculino</option>
														<option value="feminino">Feminino</option>
													</form:select>

												</div>
											</div>

											<div class="form-group">
												<form:label class="col-sm-2" path="rg">RG:</form:label>
												<div class="col-xs-4">
													<form:input type="text" class="form-control RG" id="inp_rg"
														disabled="true" placeholder="Registro geral" path="rg"
														value="${aluno.rg}"></form:input>
												</div>

												<form:label class="col-sm-1" path="cpf">CPF:</form:label>
												<div class="col-xs-4">
													<form:input type="text" class="form-control cpf"
														placeholder="Cadastro pessoal fisíca" path="cpf"
														id="inp_cpf" disabled="true" value="${aluno.cpf}"></form:input>
												</div>
											</div>

											<div class="form-group">
												<form:label path="cidade.estado" class="col-sm-2">Estado:</form:label>
												<div class="col-xs-9">
													<form:select path="cidade.estado" class="form-control"
														id="sel_estado" disabled="true"
														value="${aluno.cidade.estado}">
														<form:option value="SAO_PAULO">São Paulo</form:option>
														<form:option value="MINAS_GERAIS">Minas Gerais</form:option>
														<form:option value="MATO_GROSSO">Moto Grosso</form:option>
													</form:select>
												</div>
											</div>
											<div class="form-group">
												<form:label path="cidade.nome" class="col-sm-2">Cidade:</form:label>
												<div class="col-xs-9">
													<form:select path="cidade.nome" class="form-control"
														id="inp_cidade" disabled="true"
														value="${aluno.cidade.nome}">
														<form:option value="SAO_PAULO">Fernandópolis</form:option>
														<form:option value="MINAS_GERAIS">Jales</form:option>
														<form:option value="MATO_GROSSO">São José dos Campos</form:option>
													</form:select>
												</div>
											</div>

											<div class="form-group">
												<form:label path="cidade.cep" class="col-sm-2">CEP:</form:label>
												<div class="col-sm-9">
													<form:input path="cidade.cep" placeholder="Cep"
														id="inp_cep" disabled="true" value="${aluno.cidade.cep}"
														class="form-control cep" type="text" />
												</div>
											</div>

											<div class="form-group">
												<form:label class="col-sm-2" path="ddd">Telefone:</form:label>
												<div class="col-xs-1">
													<form:input type="text" class="form-control ddd"
														id="inp_ddd" disabled="true" placeholder="DDD" path="ddd"
														value="${aluno.ddd}"></form:input>
												</div>
												<div class="col-xs-8">
													<form:input type="text" class="form-control phone"
														disabled="true" placeholder="Número do telefone"
														id="inp_telefone" path="telefone"
														value="${aluno.telefone}"></form:input>
												</div>
											</div>
											<div class="form-group">
												<form:label path="email" class="col-sm-2">E-mail:</form:label>
												<div class="col-sm-9">
													<form:input path="email" class="form-control" type="text"
														id="inp_email" disabled="true" placeholder="E-mail"
														value="${aluno.email}" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo"> Aluno - Dados finançeiro </a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="form-group">
												<div class="col-sm-6"></div>
												<button class="btn btn-default btn-xs" type="button">
													Editar</button>
											</div>
											<div class="form-group">
												<form:label class="col-sm-2" path="pagamento.tipoPagamento">Pagamento:</form:label>
												<div class="col-xs-8">
													<form:select class="form-control" disabled="true"
														path="pagamento.tipoPagamento" id="tpPagamento"
														value="${aluno.pagamento.tipoPagamento}">
														<option value="A_VISTA">à Vista</option>
														<option value="CARTAO">Cartão - PagSeguro</option>
														<option value="PARCELAMENTO">Mensalidade</option>
														<option value="NAO_DEFINIDO">Outro</option>
													</form:select>
												</div>
												<div class="col-xs-1 money-icon">
													<img src="/scai_projectV-web/images/cash32.png"
														alt="à Vista">
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
												<form:label class="col-sm-2" path="pagamento.tipoPagamento">Qnt Parcela:</form:label>
												<div class="col-xs-9">
													<form:select class="form-control" disabled="true"
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
												<div class="col-xs-9">
													<form:input type="text" class="form-control"
														disabled="true"
														placeholder="Dia do vencimento da mensalidade"
														path="pagamento.diaVencimento"></form:input>
												</div>
											</div>

											<div class="form-group" id="obs">
												<form:label class="col-sm-2" path="pagamento.observacao">Observações:</form:label>
												<div class="col-xs-9">
													<form:textarea type="text" class="form-control"
														disabled="true"
														placeholder="Observações gerais sobre o pagamento"
														value="${aluno.pagamento.observacao}"
														path="pagamento.observacao"></form:textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseThree"> Aluno - Dados acadêmicos </a>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="form-group">
												<div class="col-sm-6"></div>
												<button class="btn btn-default btn-xs" type="button">
													Editar</button>
											</div>
											COnteudo
										</div>
									</div>
								</div>
								</br>
								<button class="btn btn-danger btn-xs col-md-12" type="button"
									id="btn_editar_dados_pessoais">Excluir</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section> </aside>