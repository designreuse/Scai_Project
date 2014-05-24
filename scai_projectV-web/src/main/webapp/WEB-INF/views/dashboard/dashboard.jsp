<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script src="http://code.highcharts.com/highcharts.js"></script>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side"> <!-- Content Header (Page header) -->
<section class="content-header no-margin">
<h1 class="text-center tituloPage">Painel de informações</h1>
</section> <!-- Main content --> <section class="content"> <!-- MAILBOX BEGIN -->
<div class="mailbox row" ng-app="validationApp"
	ng-controller="mainController">
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



						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Resumo do mês de maio</h3>
							</div>

							<!-- Small boxes (Stat box) -->
							<div class="row">

								<div class="box-body chart-responsive">
									<div class="col-lg-3 col-xs-6">
										<!-- small box -->
										<div class="small-box bg-aqua">
											<div class="inner">
												<h3>${alunosMatriculados}</h3>
												<c:if test="${alunosMatriculados < 2}">
													<p>Novo Usuário</p>
												</c:if>
												<c:if test="${alunosMatriculados > 1}">
													<p>Novos Usuários</p>
												</c:if>
											</div>
											<div class="icon">
												<i class="ion ion-person-add"></i>
											</div>
											<a href="#" class="small-box-footer"> Visualizar <i
												class="fa fa-arrow-circle-right"></i>
											</a>
										</div>
									</div>
									<!-- ./col -->
									<div class="col-lg-3 col-xs-6">
										<!-- small box -->
										<div class="small-box bg-green">
											<div class="inner">
												<h3>
													R$ 4.000,<sup style="font-size: 20px">00</sup>
												</h3>
												<p>Valor acumulado</p>
											</div>
											<div class="icon">
												<i class="ion ion-stats-bars"></i>
											</div>
											<a href="#" class="small-box-footer"> Visualizar <i
												class="fa fa-arrow-circle-right"></i>
											</a>
										</div>
									</div>
									<!-- ./col -->
									<div class="col-lg-3 col-xs-6">
										<!-- small box -->
										<div class="small-box bg-yellow">
											<div class="inner">
												<h3>44</h3>
												<p>Pagamentos pendentes</p>
											</div>
											<div class="icon">
												<i class="ion ion-person-add"></i>
											</div>
											<a href="#" class="small-box-footer"> Visualizar <i
												class="fa fa-arrow-circle-right"></i>
											</a>
										</div>
									</div>
									<!-- ./col -->
									<div class="col-lg-3 col-xs-6">
										<!-- small box -->
										<div class="small-box bg-red">
											<div class="inner">
												<h3>65</h3>
												<p>Pagamentos atrasados</p>
											</div>
											<div class="icon">
												<i class="ion ion-pie-graph"></i>
											</div>
											<a href="#" class="small-box-footer"> Visualizar <i
												class="fa fa-arrow-circle-right"></i>
											</a>
										</div>
									</div>
									<!-- ./col -->
								</div>
								<!-- /.box-body -->
							</div>

						</div>
						<!-- /.row -->

						<!-- top row -->
						<div class="row">
							<div class="col-xs-12 connectedSortable"></div>
							<!-- /.col -->
						</div>
						<!-- /.row -->



						<div class="row">
							<div class="col-md-12">
								<!-- AREA CHART -->
								<div class="box box-primary">
									<div class="box-header">
										<h3 class="box-title">Area Chart</h3>
									</div>
									<div class="box-body chart-responsive">
										<div id="container" style="width: 100%; height: 400px;"></div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
							</div>
							<div class="col-md-6">
								<!-- AREA CHART -->
								<div class="box box-primary">
									<div class="box-header">
										<h3 class="box-title">Area Chart</h3>
									</div>
									<div class="box-body chart-responsive">
										<div id="pier" style="width: 100%; height: 400px;"></div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<!-- AREA CHART -->
								<div class="box box-primary">
									<div class="box-header">
										<h3 class="box-title">Area Chart</h3>
									</div>
									<div class="box-body chart-responsive">
										<div id="container" style="width: 100%; height: 400px;"></div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section> </aside>


<script>
	$(function() {
		$('#container')
				.highcharts(
						{
							title : {
								text : 'Monthly Average Temperature',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: WorldClimate.com',
								x : -20
							},
							xAxis : {
								categories : [ 'Jan', 'Fev', 'Mar', 'Abr',
										'Mai', 'Jun', 'Jul', 'Ago', 'Set',
										'Out', 'Nov', 'Dez' ]
							},
							yAxis : {
								title : {
									text : 'Quantidade'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [ {
								name : 'Matriculas',
								data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
										26.5, 23.3, 18.3, 13.9, 9.6 ]
							} ]
						});
	});

	//PIE CHARTS
	$(function() {
		$('#pier')
				.highcharts(
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false
							},
							title : {
								text : 'Browser market shares at a specific website, 2014'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										format : '<b>{point.name}</b>: {point.percentage:.1f} %',
										style : {
											color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
													|| 'black'
										}
									}
								}
							},
							series : [ {
								type : 'pie',
								name : 'Browser share',
								data : [ [ 'Firefox', 45.0 ], [ 'IE', 26.8 ], {
									name : 'Chrome',
									y : 12.8,
									sliced : true,
									selected : true
								}, [ 'Safari', 8.5 ], [ 'Opera', 6.2 ],
										[ 'Others', 0.7 ] ]
							} ]
						});
	});
</script>