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
<script src="js/plugins/datatables/jquery.dataTables.js"
	type="text/javascript"></script>
<script src="js/plugins/datatables/dataTables.bootstrap.js"
	type="text/javascript"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Gerenciar pessoas</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row">
	<div class="col-xs-12">
		<div class="box box-solid">
			<div class="box-body">
				<div class="row">
					<div class="col-md-12">

						<table id="pessoas-table"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th width="20%">Nome</th>
									<th width="13%">CPF</th>
									<th width="20%">Telefone</th>
									<th width="10%">Email</th>
									<th width="13%">Cidade</th>
									<th width="12%">Opção</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pessoas}" var="pessoa">
									<tr>
										<td>${pessoa.nome}</td>
										<td>${pessoa.cpf}</td>
										<td>${pessoa.ddd}${pessoa.telefone}</td>
										<td>${pessoa.email}</td>
										<td>${pessoa.cidade.nome}</td>
										<td><div class="btn-group">
												<button type="button"
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown">
													Aluno <span class="caret"></span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a
														href="/scai_projectV-web/aluno-editar/${pessoa.id}">Detalhar</a></li>
													<c:if
														test="${pessoa.pagamento.tipoPagamento == 'PARCELAMENTO'}">
														<li><a
															href="/scai_projectV-web/aluno-mensalidades/${pessoa.id}">Mensalidades</a></li>
													</c:if>
													<li><a href="#">VIsualizar</a></li>
													<li class="divider"></li>
													<li><a href="#">Desativar</a></li>
												</ul>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section> </aside>

<script>
	$("#pessoas-table").dataTable();
</script>
