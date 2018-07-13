<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher | Take Attendence</title>
</head>
<style>
	select{
		width: 140px;
		border-color: #4CAF50;
	}
	input{
	background-color: white;
    color: black;
	    border: 2px solid green;
	}
	input:hover {
	    background-color: #4CAF50;
	    color: white;
	}
	h4{
		color: green;
	}
</style>
<body>
	<div align="center">
	<form action="cms.controller.TakeAttendance" method="post">
	<div>
		<h4>DATE</h4>
		<select name="date" id="">
							<option value="one">1</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10</option>
							<option value="eleven">11</option>
							<option value="twelve">12</option>
							<option value="thirteen">13</option>
							<option value="fourteen">14</option>
							<option value="fifteen">15</option>
							<option value="sixteen">16</option>
							<option value="seventeen">17</option>
							<option value="eighteen">18</option>
							<option value="nineteen">19</option>
							<option value="twenty">20</option>
							<option value="twentyone">21</option>
							<option value="twentytwo">22</option>
							<option value="twentythree">23</option>
							<option value="twentyfour">24</option>
							<option value="twentyfive">25</option>
							<option value="twentysix">26</option>
							<option value="twentyseven">27</option>
							<option value="twentyeight">28</option>
							<option value="twentynine">29</option>
							<option value="thirty">30</option>
							<option value="thirtyone">31</option>
						</select><br><br>
		<h4>MONTH</h4>
		<select name="month">
							<option>january</option>
							<option>february</option>
							<option>march</option>
							<option>april</option>
							<option>may</option>
							<option>june</option>
							<option>july</option>
							<option>august</option>
							<option>september</option>
							<option>october</option>
							<option>november</option>
							<option>december</option>
		</select><br><br>
		</div>
		
		<h4>SEMESTER</h4>
		<select name="semester">
							<option>1st</option>
							<option>2nd</option>
							<option>3rd</option>
							<option>4th</option>
							<option>5th</option>
							<option>6th</option>
							<option>7th</option>
							<option>8th</option>
		</select><br><br>
		
		<h4>Branch</h4>
		<select name="branch">
							<option>IT</option>
							<option>CSE</option>
		</select>
		<br><br>
		<input type="submit" value="Submit">
	</form>
	</div>
</body>
</html>