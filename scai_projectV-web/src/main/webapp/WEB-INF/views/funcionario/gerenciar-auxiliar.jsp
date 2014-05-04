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
<h1 class="text-center">Gerenciar Auxiliar(es)</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">




						<div class="box">
							<div class="box-header"></div>
							<!-- /.box-header -->
							<div class="box-body table-responsive">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th class="col-md-6">Matéria</th>
											<th class="col-md-4">Status</th>
											<th>Opção</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${funcionarios}" var="funcionario">
											<tr>
												<td>${funcionario.nome }</td>
												<td>${funcionario.sobrenome }</td>
												<td>
													<div class="btn-group">
														<div class="btn-group">
															<button type="button"
																class="btn btn-default dropdown-toggle"
																data-toggle="dropdown">
																Opções <span class="caret"></span>
															</button>
															<ul class="dropdown-menu">
																<li><a href="#" class="glyphicon glyphicon-pencil">
																		Editar</a></li>
																<li><a href="#myModal"
																	class="glyphicon glyphicon-ban-circle" data-toggle="modal" data-target="#myModal"> Desativar</a></li>
																<li role="presentation" class="divider"></li>
																<li><a href="#"
																	class="glyphicon glyphicon-trash"> Remover</a></li>
															</ul>
														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Rendering engine</th>
											<th>Browser</th>
											<th>Platform(s)</th>
										</tr>
									</tfoot>
								</table>

								<!-- MODAL DE OPçÔES -->

								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title">Desativar matéria</h4>
											</div>
											<div class="modal-body">
												<p>One fine body&hellip;</p>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Fechar</button>
												<button type="button" class="btn btn-primary">Feito</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->

								<!-- FIM MODAL -->


							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
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
<!-- /.col (MAIN) -->
</div>
<!-- MAILBOX END --> </section> <!-- /.content --> </aside>
<!-- /.right-side -->

<!-- DATA TABES SCRIPT -->
<script src="js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="js/AdminLTE/app.js" type="text/javascript"></script>

<!-- page script -->
<script type="text/javascript">
	$(function() {
		$("#example1").dataTable();
		$('#example2').dataTable({
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : false,
			"bSort" : true,
			"bInfo" : true,
			"bAutoWidth" : false
		});
	});
</script>
