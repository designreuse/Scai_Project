<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="js/aluno/form.js" type="text/javascript"></script>
<!-- DATA TABES SCRIPT -->
<script src="js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="js/AdminLTE/app.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Novo Aluno - Dados Pessoais</h1>
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

						<table id="turma-table" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th width="8%">Matéria</th>
									<th width="25%">Turma</th>
									<th width="25%">Horário</th>
									<th width="10%">Inicío</th>
									<th width="13%">Vagas</th>
									<th width="9%">Valor</th>
									<th width="10%">Opção</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${turmas}" var="turma">
									<tr>
										<td>${turma.materia.nome}</td>
										<td>${turma.nomeTurma}</td>
										<td><c:forEach items="${turma.horariosAulas}"
												var="horario">
												<div class="btn-group">
													<button type="button"
														class="btn btn-default dropdown-toggle"
														data-toggle="dropdown">
														${horario.diaSemana} <span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a href="#"><span
																class="glyphicon glyphicon-time"></span> Inicío:
																${horario.horarioInicio}</a></li>
														<li><a href="#"><span
																class="glyphicon glyphicon-time"></span> Término:
																${horario.horarioTermino}</a></li>
													</ul>
												</div>
											</c:forEach></td>
										<td>${turma.previsaoInicio}</td>
										<td>
											<div class="progress progress-striped active">
												<div class="progress-bar" role="progressbar"
													aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"
													style="width: ${(turma.alunosMatriculados * 100) / turma.vagasDisponiveis}%"
													value="tte">
													<span class="sr-only"></span><strong>${turma.alunosMatriculados}/${turma.vagasDisponiveis}</strong>
												</div>
											</div>
										</td>
										<td>R$ ${turma.valorCurso }</td>
										<td><a
											href="/scai_projectV-web/aluno-novo/${turma.id}"
											class="btn btn-success btn-flat">Matricular</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary backStep pull-left">Voltar</button>
						</div>

						<script type="text/javascript">
							$('.datepicker').datepicker();
						</script>
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
	$("#turma-table").dataTable();
</script>