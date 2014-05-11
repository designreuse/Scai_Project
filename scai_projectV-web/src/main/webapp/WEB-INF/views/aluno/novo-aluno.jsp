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

						<form:form action="/scai_projectV-web/aluno-cadastrar/"
							method="POST" modelAttribute="aluno" class="form-horizontal"
							id="form-main">
							<div class="step1">
								<div class="form-group">
									<form:label class="col-sm-2" path="nome">Nome:</form:label>
									<div class="col-xs-9">
										<form:input type="text" class="form-control"
											placeholder="Nome do aluno" path="nome"></form:input>
									</div>
								</div>

								<div class="form-group">
									<form:label class="col-sm-2" path="sobrenome">Sobrenome:</form:label>
									<div class="col-xs-9">
										<form:input type="text" class="form-control"
											placeholder="Sobrenome do aluno" path="sobrenome"></form:input>
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
									<button type="submit" class="btn btn-primary nextStep">Seguinte</button>
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

