<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="wrap">	 
	      <div class="header">
	      	  <div class="header_top">
					  <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
							<ul class="nav">
								<li><a href="#"><i><img src="images/favourite.png" alt="" /></i>Home</a></li>
								<li class="active"><a href="#"><i><img src="images/user.png" alt="" /></i>Minha Conta</a></li>
								<li><a href="#"><i><img src="images/mail.png" alt="" /></i>Mensagens <span class="messages">1</span></a></li>
								<li><a href="#"><i><img src="images/settings.png" alt="" /></i>Configurações</a></li>
							<div class="clear"></div>
						    </ul>
							<script type="text/javascript" src="<c:url value="js/responsive-nav.js"/>"></script>
				        </div>	
					  <div class="profile_details">
				    		   <div id="loginContainer">
				                  <a id="loginButton" class=""><span>Eu</span></a>   
				                    <div id="loginBox">                
				                      <form id="loginForm">
				                        <fieldset id="body">
				                            <div class="user-info">
							        			<h4>Olá,<a href="#"> Paulo</a></h4>
							        			<ul>
							        				<li class="profile active"><a href="#">Perfil </a></li>
							        				<li class="logout"><a href="#"> Sair</a></li>
							        				<div class="clear"></div>		
							        			</ul>
							        		</div>			                            
				                        </fieldset>
				                    </form>
				                </div>
				            </div>
				             <div class="profile_img">	
				             	<a href="#"><img src="images/profile_img40x40.jpg" alt="" />	</a>
				             </div>		
				             <div class="clear"></div>		  	
					    </div>	
		 		      <div class="clear"></div>				 
				   </div>
			</div>	  					     
	</div>