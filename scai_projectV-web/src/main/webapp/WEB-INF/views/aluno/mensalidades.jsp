<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<h1 class="text-center tituloPage">Mensalidades</h1>
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


						<div class="panel panel-info">
							<div class="panel-heading">Dados pessoais</div>
							<div class="panel-body">

								<div class="row">
									<div class="col-xs-6 col-sm-4">
										<strong>aluno</strong> ${aluno.nome}
									</div>
									<div class="col-xs-6 col-sm-4">
										<strong>telefone</strong> ${aluno.telefone}
									</div>
									<!-- Optional: clear the XS cols if their content doesn't match in height -->
									<div class="clearfix visible-xs"></div>
									<div class="col-xs-6 col-sm-4">
										<strong>e-mail</strong> ${aluno.email}
									</div>
								</div>

								</br>
								<div class="row">
									<div class="col-xs-6 col-sm-4">
										<strong>cpf</strong> ${aluno.cpf}
									</div>
									<div class="col-xs-6 col-sm-4">
										<strong>rg</strong> ${aluno.rg}
									</div>
									<!-- Optional: clear the XS cols if their content doesn't match in height -->
									<div class="clearfix visible-xs"></div>
									<div class="col-xs-6 col-sm-4">
										<strong>cidade</strong> ${aluno.cidade.nome}
									</div>
								</div>
							</div>
						</div>
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<div class="panel panel-info">
							<div class="panel-heading">Mensalidades</div>
							<div class="panel-body">
								<table class="table table-bordered">
									<tr>
										<th style="width: 10px"></th>
										<th>Data de vencimento</th>
										<th>Observações</th>
										<th>Valor</th>
										<th style="width: 40px">Status</th>
										<th style="width: 40px">Ação</th>
									</tr>
									<c:forEach items="${mensalidades}" var="mensalidade"
										varStatus="status">
										<c:set var="money" value="${mensalidade.valorPago}" />
										<tr>
											<td>${status.count}</td>
											<td><fmt:formatDate type="time" pattern="dd/MM/yyyy"
													value="${mensalidade.dataVencimento}" /></td>
											<c:if test="${mensalidade.obersacao == null}">
												<td>Sem observações para este registro</td>
											</c:if>
											<td>R$ <fmt:formatNumber type="number" pattern="###.##"
													value="${money}" /></td>
											<c:if test="${mensalidade.statusPagamento == 'PAGO'}">
												<td><span class="badge bg-green"> Pago </span></td>
												<td><a
													href="/scai_projectV-web/aluno-receber-mensalidade/${mensalidade.id}/${aluno.id}"
													class="btn btn-info btn-xs" disabled="true">Receber</a></td>
											</c:if>
											<c:if test="${mensalidade.statusPagamento == 'EM_ABERTO'}">
												<td><span class="badge bg-yellow"> Aberto </span></td>
												<td><a
													href="/scai_projectV-web/aluno-receber-mensalidade/${mensalidade.id}/${aluno.id}"
													class="btn btn-info btn-xs">Receber</a></td>
											</c:if>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section> </aside>
