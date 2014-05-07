<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="js/funcionario/form.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Novo Auxiliar - Dados Pessoais</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">

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

						<form:form action="funcionario-cradastrar-auxiliar" method="POST"
							modelAttribute="docente" class="form-horizontal" id="form-main">
							<div class="step1">
								<div class="form-group">
									<form:label class="col-sm-2" path="nome">Nome:</form:label>
									<div class="col-xs-9">
										<form:input type="text" class="form-control"
											placeholder="Nome do docente" path="nome"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="sobrenome">Sobrenome:</form:label>
									<div class="col-xs-9">
										<form:input type="text" class="form-control"
											placeholder="Sobrenome do docente" path="sobrenome"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="dataNascimento">Nascimento:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control datepicker"
											placeholder="Data nascimento" path="dataNascimento"></form:input>
									</div>

									<form:label class="col-sm-1" path="dataNascimento">Sexo:</form:label>
									<div class="col-xs-4">
										<form:select path="sexo" class="form-control">
											<option value="masculino">Masculino</option>
											<option value="feminino">Feminino</option>
										</form:select>

									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="rg">RG:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control RG"
											placeholder="Registro geral" path="rg"></form:input>
									</div>

									<form:label class="col-sm-1" path="cpf">CPF:</form:label>
									<div class="col-xs-4">
										<form:input type="text" class="form-control cpf"
											placeholder="Cadastro pessoal fisíca" path="cpf"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label path="cidade.estado" class="col-sm-2">Estado:</form:label>
									<div class="col-xs-9">
										<form:select path="cidade.estado" class="form-control"
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
										<form:select path="cidade.nome" class="form-control">
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
											class="form-control cep" type="text" />
									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="ddd">Telefone:</form:label>
									<div class="col-xs-1">
										<form:input type="text" class="form-control ddd"
											placeholder="DDD" path="ddd"></form:input>
									</div>
									<div class="col-xs-8">
										<form:input type="text" class="form-control phone"
											placeholder="Número do telefone" path="telefone"></form:input>
									</div>
								</div>
								<div class="form-group">
									<form:label path="email" class="col-sm-2">E-mail:</form:label>
									<div class="col-sm-9">
										<form:input path="email" class="form-control" type="text"
											placeholder="E-mail" />
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-primary nextStep">Seguinte</button>
								</div>


							</div>
							<div class="step2">
								<div class="form-group">
									<form:label path="dataAdmissao" class="col-sm-2">Data de admissão</form:label>
									<div class="col-sm-5">
										<form:input path="dataAdmissao" placeholder="Data de admissão"
											type="text" class="form-control datepicker" id="dataAdmissao" />
									</div>
									<form:label path="diaVencimentoSalario" class="col-sm-1">Venci.:</form:label>
									<div class="col-sm-3">
										<form:input path="diaVencimentoSalario"
											class="form-control day" type="text" min="1" max="31"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label path="salario" class="col-sm-2">Salário:</form:label>
									<div class="col-sm-9">
										<form:input path="salario" class="form-control money"
											type="text" placeholder="Valor do salário"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label path="acessoSistema" class="col-sm-2">Acesso:</form:label>
									<div class="col-xs-9">
										<form:select path="acessoSistema" class="form-control"
											id="acesso_sistema">
											<form:option value="ADMINISTRADOR">Total</form:option>
											<form:option value="FUNCIONARIO">Parcial</form:option>
											<form:option value="SEM_ACESSO">Sem acesso</form:option>
										</form:select>
									</div>
								</div>

								<div class="form_login">
									<div class="form-group">
										<form:label path="salario" class="col-sm-2">Login:</form:label>
										<div class="col-sm-9">
											<form:input path="login" class="form-control" type="text"
												placeholder="Login do usuário"></form:input>
										</div>
									</div>

									<div class="form-group">
										<form:label path="senha" class="col-sm-2">Senha:</form:label>
										<div class="col-sm-9">
											<form:input path="senha" class="form-control" type="password"
												placeholder="Senha de acesso"></form:input>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2">Confirmar:</label>
										<div class="col-sm-9">
											<input class="form-control" type="password"
												placeholder="Confirmar senha"></input>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button"
										class="btn btn-primary backStep pull-left">Voltar</button>
									<button type="submit" class="btn btn-primary">Cadastrar</button>
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

