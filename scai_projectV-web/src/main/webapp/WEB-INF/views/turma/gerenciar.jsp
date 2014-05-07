<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!-- DATA TABES SCRIPT -->
<script src="js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="js/AdminLTE/app.js" type="text/javascript"></script>
<script src="js/turma/table.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Gerenciar Turma</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">

						<div class="alert alert-success">
							<a href="#" class="alert-link"></a>
						</div>
						<div class="alert alert-info">
							<a href="#" class="alert-link"></a>
						</div>
						<div class="alert alert-warning">
							<a href="#" class="alert-link"></a>
						</div>
						<div class="alert alert-danger">
							<a href="#" class="alert-link"></a>
						</div>



						<div class="row">
							<div class="col-xs-12">
								<div class="box">
									<div class="box-header">
										<h3 class="box-title">Registros de turmas</h3>
									</div>

									<!-- /.box-header -->
									<div class="box-body table-responsive">
										<table id="turma_table"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Matéria</th>
													<th>Turma</th>
													<th>Início</th>
													<th>Término</th>
													<th>Vaga(s)</th>
													<th>Valor R$</th>
													<th width="10%">Opções</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${turmas}" var="turma">
													<tr>
														<td>${turma.materia.nome}</td>
														<td>${turma.nomeTurma}</td>
														<td>${turma.previsaoInicio}</td>
														<td>${turma.previsaoTermino}</td>
														<td>${turma.valorCurso}</td>
														<td><button class="btn btn-primary btn-flat">Matricular</button></td>
														<td><div class="progress progress-striped active">
																<div class="progress-bar progress-bar-warning" role="progressbar"
																	aria-valuenow="45" aria-valuemin="0"
																	aria-valuemax="100" style="width: 45%">
																	<span class="sr-only"></span>06/15
																</div>
															</div></td>
														<td><div class="btn-group">
																<button type="button"
																	class="btn btn-primary dropdown-toggle"
																	data-toggle="dropdown">
																	<span class="glyphicon glyphicon-cog"></span> Opções <span
																		class="caret"></span>
																</button>
																<ul class="dropdown-menu" role="menu">
																	<li><a href="<c:url value="/editar-turma/${turma.id}"/>"><span
																	
																	
																			class="glyphicon glyphicon-edit"></span> Editar</a></li>
																	<li><a href="#" id="remover"><span
																			class="glyphicon glyphicon-log-out"></span> Desativar</a></li>
																	<li class="divider"></li>
																	<li><a href="#" data-toggle="modal"
																		data-target="#deleteRow" data-id="${turma.id}"
																		class="open-AddBookDialog" id="remove_row"><span
																			class="glyphicon glyphicon-trash"></span> Remover</a></li>
																</ul>
															</div></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
							</div>
						</div>


					</div>


				</div>

				<!-- /.col (RIGHT) -->
			</div>
			<!-- /.row -->
		</div>
		<!-- box-footer -->
	</div>
	<!-- /.box -->
</div>
<p class="bg-success">...</p>
<!-- MODAL DELETE ROW -->
<div class="modal fade" id="deleteRow" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title text-danger">Remover turma</h4>
			</div>
			<div class="modal-body">
				<p><h4>Você tem certeza que deseja excluir <strong>permanentemente</strong> esta turma ?</h4></p>
				<hide type="text" name="bookId" id="bookId" value="" />
			</div>

				

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Voltar</button>
				<button type="button" id="removerRegistro" class="btn btn-danger">
					<span class="glyphicon glyphicon-trash"></span> Remover
				</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal --> <!-- END MODAL --><!-- /.col (MAIN) --> </section></aside>

<!-- page script -->
<script type="text/javascript">
	$(function() {
		$("#turma_table").dataTable();
	});

	$(document).on("click", ".open-AddBookDialog", function() {
		var myBookId = $(this).data('id');
		$(".modal-body #bookId").val(myBookId);
	});
</script>
