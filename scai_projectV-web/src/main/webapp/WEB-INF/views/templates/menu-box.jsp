<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="wrapper row-offcanvas row-offcanvas-left">
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="left-side sidebar-offcanvas">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- Sidebar user panel -->
			<div class="user-panel">
				<div class="pull-left image">
					<img src="../img/avatar3.png" class="img-circle" alt="User Image" />
				</div>
				<div class="pull-left info">
					<p>Hello, Jane</p>

					<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
				</div>
			</div>
			<!-- search form -->
			<form action="#" method="get" class="sidebar-form">
				<div class="input-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search..." /> <span class="input-group-btn">
						<button type='submit' name='seach' id='search-btn'
							class="btn btn-flat">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</form>
			<!-- /.search form -->
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
				<li class="active"><a href="/scai_projectV-web/dashboard"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li>
				<li class="treeview"><a href="#"> <i
						class="fa fa-bar-chart-o"></i> <span>Aluno</span> <i
						class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="/scai_projectV-web/aluno-curso"><i
								class="fa fa-angle-double-right"></i> Novo</a></li>
						<li><a href="charts/flot.html"><i
								class="fa fa-angle-double-right"></i> Gerenciar</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
						<span>Colaborador</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="/scai_projectV-web/funcionario-novo-docente"><i
								class="fa fa-angle-double-right"></i> Novo docente</a></li>
						<li><a href="/scai_projectV-web/funcionario-novo-auxiliar"><i
								class="fa fa-angle-double-right"></i> Novo auxiliar</a></li>
						<li><a href="UI/buttons.html"><i
								class="fa fa-angle-double-right"></i> Gerenciar docente</a></li>
						<li><a href="/scai_projectV-web/funcionario-gerenciar-auxiliar"><i
								class="fa fa-angle-double-right"></i> Gerenciar auxiliar</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
						<span>Materia</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="/scai_projectV-web/materia-novo"><i
								class="fa fa-angle-double-right"></i> Nova matéria</a></li>
						<li><a href="/scai_projectV-web/materia-gerenciar"><i
								class="fa fa-angle-double-right"></i> Gerenciar matéria</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-table"></i>
						<span>Turma</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="/scai_projectV-web/turma-novo"><i
								class="fa fa-angle-double-right"></i> Nova turma</a></li>
						<li><a href="/scai_projectV-web/gerenciar-turma"><i
								class="fa fa-angle-double-right"></i> Gerenciar turma</a></li>
					</ul></li>
				<li><a href="calendar.html"> <i class="fa fa-calendar"></i>
						<span>Calendar</span> <small class="badge pull-right bg-red">3</small>
				</a></li>
				<li><a href="mailbox.html"> <i class="fa fa-envelope"></i>
						<span>Mailbox</span> <small class="badge pull-right bg-yellow">12</small>
				</a></li>
				<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
						<span>Examples</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="examples/invoice.html"><i
								class="fa fa-angle-double-right"></i> Invoice</a></li>
						<li><a href="examples/login.html"><i
								class="fa fa-angle-double-right"></i> Login</a></li>
						<li><a href="examples/register.html"><i
								class="fa fa-angle-double-right"></i> Register</a></li>
						<li><a href="examples/lockscreen.html"><i
								class="fa fa-angle-double-right"></i> Lockscreen</a></li>
						<li><a href="examples/404.html"><i
								class="fa fa-angle-double-right"></i> 404 Error</a></li>
						<li><a href="examples/500.html"><i
								class="fa fa-angle-double-right"></i> 500 Error</a></li>
						<li><a href="examples/blank.html"><i
								class="fa fa-angle-double-right"></i> Blank Page</a></li>
					</ul></li>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>