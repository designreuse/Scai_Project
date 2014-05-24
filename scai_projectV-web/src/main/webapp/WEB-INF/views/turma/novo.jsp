<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="js/turma/form.js" type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Nova turma</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">

<div class="alert alert-success">
  <a href="#" class="alert-link">Sucesso</a>
</div>
<div class="alert alert-info">
  <a href="#" class="alert-link">Aviso</a>
</div>
<div class="alert alert-warning">
  <a href="#" class="alert-link">Alerta</a>
</div>
<div class="alert alert-danger">
  <a href="#" class="alert-link">Prerigo</a>
</div>

						<form:form action="funcionario-cradastrar-auxiliar" method="POST"
							modelAttribute="turma" class="form-horizontal" id="form-main">

							<div class="form-group">
								<form:label class="col-sm-2" path="nomeTurma">Nome:</form:label>
								<div class="col-xs-9">
									<form:select class="form-control" path="nomeTurma" id="materiaId"
										items="${materias}" itemLabel="nome" itemValue="id"></form:select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2" path="nomeTurma">Nome da turma:</label>
								<div class="col-xs-9">
									<form:input type="text" class="form-control" id="nomeTurma"
										placeholder="Nome da turma" path="nomeTurma"></form:input>
								</div>
							</div>

							<div class="form-group">
								<form:label class="col-sm-2" path="previsaoInicio">Inicío:</form:label>
								<div class="col-xs-4">
									<form:input type="text" class="form-control"
										placeholder="Previsão de inicío das aulas" id="dpd1"
										path="previsaoInicio" data-date-format="yyyy-mm-dd"></form:input>
								</div>
								<form:label class="col-sm-1" path="previsaoTermino">Término:</form:label>
								<div class="col-xs-4">
									<form:input type="text" class="form-control" id="dpd2"
										placeholder="Previsão de término das aulas"
										path="previsaoTermino" data-date-format="yyyy-mm-dd"></form:input>
								</div>
							</div>

							<div class="form-group">
								<form:label class="col-sm-2" path="valorCurso">Valor do curso:</form:label>
								<div class="col-xs-4">
									<form:input type="text" class="form-control money"
										placeholder="Valor total do curso" path="valorCurso" id="valorCurso"></form:input>
								</div>
								<form:label class="col-sm-1" path="vagasDisponiveis">Vagas:</form:label>
								<div class="col-xs-4">
									<form:input type="text" class="form-control numbers"
										placeholder="Vagas disponíveis" id="vagasDisponiveis"
										path="vagasDisponiveis"></form:input>
								</div>
							</div>

							<div class="form-group">
								<form:label class="col-sm-2" path="valorCurso">Dia(s) de aula:</form:label>
								<div class="col-xs-9">
									<!-- /.box-header -->
									<div class="box-body no-padding">
										<table class="table table-condensed" id="table_horarios">
											<tr>
												<th width="40%"><span
													class="glyphicon glyphicon-calendar"></span> Dia da semana</th>
												<th width="20%"><span class="glyphicon glyphicon-time"></span>
													Horário de inicío</th>
												<th width="20%"><span class="glyphicon glyphicon-time"></span>
													Horário de término</th>
												<th width="10%"><span class="glyphicon glyphicon-trash"></span>
													Remover</th>
											</tr>
										</table>
										<hr>
										<!-- /.box-body -->
										<button class="btn btn-success btn-flat glyphicon glyphicon-plus" type="button"
											data-toggle='modal' data-target='#myModal'> Adicionar</button>
									</div>
								</div>
							</div>
							
							<!-- /.box -->
							<!-- /.col -->

							<!-- START MODAL -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title"><span class="glyphicon glyphicon-calendar"></span> Definir data de aula</h4>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<div class="form-group">
													<label class="col-sm-3">Dia da semana:</label>
													<div class="col-xs-8">
														<select class="form-control" id="dia_semana">
															<option value="SEGUNDA_FEIRA">Segunda-feira</option>
															<option value="TERÇA_FEIRA">Terça-feira</option>
															<option value="QUARTA_FEIRA">Quarta-feira</option>
															<option value="QUINTA_FEIRA">Quinta-feira</option>
															<option value="SEXTA_FEIRA">Sexta-feira</option>
															<option value="SABADO">Sabádo</option>
															<option value="DOMINGO">Domingo</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-3">Horário de inicío:</label>
													<div class="col-xs-8" >
														<input class="form-control hour" type="text" id="hora_inicio"/> 
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-sm-3">Horário de término:</label>
													<div class="col-xs-8">
														<input class="form-control hour" type="text" id="hora_fim"/> 
													</div>
												</div>

											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default glyphicon"
												data-dismiss="modal">Sair</button>
											<button type="button" class="btn btn-primary" id="add"> Adicionarr</button> 
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
							<!-- END MODAL -->

							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id=salvarBtn><span class="glyphicon glyphicon-ok"></span> Cadastrar</button>
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

