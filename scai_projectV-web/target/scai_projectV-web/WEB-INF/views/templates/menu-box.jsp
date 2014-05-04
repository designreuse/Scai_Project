<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="main">
	<div class="wrap">
		<div class="column_left">
			<div class="menu_box">
				<h3>Menu</h3>
				<div class="menu_box_list">
					<ul>
						<li><a href="#" class="messages"><span>Messages</span><label
								class="digits">24</label>
								<div class="clear"></div></a></li>
						<li class="active"><a href="#" class="invites"><span>Invites</span><label
								class="digits active">3</label>
								<div class="clear"></div></a></li>
						<li><a href="#" class="events"><span>Events</span><label
								class="digits">5</label>
								<div class="clear"></div></a></li>
						<li><a href="#" class="account_settings"><span>Account
									Settings</span></a></li>
						<li><a href="#" class="statistics"><span>Statistics</span></a></li>
					</ul>
				</div>
			</div>
			<div class="chart">
				<h3>Os Audience Stats</h3>
				<div class="diagram">
					<canvas id="canvas" height="220" width="220"> </canvas>
					<h4>
						<span>June</span><br />2013
					</h4>
				</div>

				<!----		              
						<span><img src="images/chart.png" alt="" /></span>
						----->
				<div class="chart_list">
					<ul>
						<li><a href="#" class="red">ios
								<p class="percentage">
									21<em>%</em>
								</p>
						</a></li>
						<li><a href="#" class="purple">Mac
								<p class="percentage">
									48<em>%</em>
								</p>
						</a></li>
						<li><a href="#" class="yellow">Linux
								<p class="percentage">
									9<em>%</em>
								</p>
						</a></li>
						<li><a href="#" class="blue">Win
								<p class="percentage">
									32<em>%</em>
								</p>
						</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<script>
					var doughnutData = [ {
						value : 21,
						color : "#E64C65"
					}, {
						value : 48,
						color : "#11A8AB"
					}, {
						value : 32,
						color : "#4FC4F6"
					}, {
						value : 9,
						color : "#FCB150"
					},

					];
					var myDoughnut = new Chart(document
							.getElementById("canvas").getContext("2d"))
							.Doughnut(doughnutData);
				</script>
			</div>
			<div class="graph">
				<canvas id="line-chart"> </canvas>
				<script>
					var lineChartData = {
						labels : [ "Apr", "May", "Jun" ],
						datasets : [ {
							fillColor : "rgba(255, 255, 255, 0)",
							strokeColor : "#FFF",
							pointColor : "#11a8ab",
							pointStrokeColor : "#FFF",
							data : [ 32, 48, 35 ]
						} ]

					}

					var myLine = new Chart(document
							.getElementById("line-chart").getContext("2d"))
							.Line(lineChartData);
				</script>
				<!---
		             	<img src="images/graph.png" alt="" />
		             	------->
				<div class="graph_list">
					<div class="week-month-year">
						<p>
							<a href="#">Week</a>
						</p>
						<p>
							<a href="#" class="active">Month</a>
						</p>
						<p>
							<a href="#">year</a>
						</p>
						<div class="clear"></div>
					</div>
					<ul>
						<li><a href="#"><span class="day_name">Apr</span> 2013 <label
								class="digits"><span>+</span>21<em>%</em></label>
								<div class="clear"></div></a></li>
						<li class="active"><a href="#"><span class="day_name">May</span>
								2013 <label class="digits"><span>+</span>48<em>%</em></label>
								<div class="clear"></div></a></li>
						<li><a href="#"><span class="day_name">Jun</span> 2013 <label
								class="digits"><span>+</span>35<em>%</em> </label>
								<div class="clear"></div></a></li>
					</ul>
				</div>
			</div>
			
			<div class="video_palyer">
				 <div class="column_right_grid calender">
                      <div class="cal1"> </div>
			</div>
		</div>
	</div>
</div>
