<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<%@page import="cms.model.TeacherDao"%>
<%@page import="cms.db.Teacher"%>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}


.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   <%
   Teacher s = new Teacher();
   s.setEmail((String)session.getAttribute("email"));
   Teacher s1 = TeacherDao.getDetails(s);
   
   %>
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"><%=s1.getName() %></h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                
               
                
                </div>
                <form action="cms.controller.UpdateTeacher" method="post">
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Specialization :</td>
                        <td><input type="text" name="specialization" value="<%=s1.getSpecialization() %>"></td>
                     
                      </tr>
                      <tr>
                      <td>Qualification :</td>
                        <td><input type="text" name="qualification" value="<%=s1.getQualification() %>"></td>
                       </tr>
                       <tr>
                        <td>Department</td>
                        <td><input type="text" name="department" value="<%=s1.getDepartment() %>"></td>
                      </tr>
                      <tr>
                        <td>Email Id</td>
                        <td><input type="text" name="email" readonly="readonly" value="<%=s1.getEmail() %>"></td>
                      </tr>
                      <tr>
                        <td>Marital Status :</td>
                        <td><input type="text" name="maritalStatus" value="<%=s1.getMaritalStatus()%>"></td>
                      </tr>
                      <tr>
                        <td>Gender :</td>
                        <td><input type="text" name="gender" value="<%=s1.getGender() %>"></td>
                      </tr>
                      <tr>
                        <td>Permanent Address :</td>
                        <td><input type="text" name="permanentAddress" value="<%=s1.getPermanentAddress() %>"></td>
                      </tr>
                      <tr>
                        <td>Present Address :</td>
                        <td><input type="text" name="presentAddress" value="<%=s1.getPresentAddress() %>"></td>
                      </tr>
                      <tr>
                        <td>City :</td>
                        <td><input type="text" name="city" value="<%=s1.getCity() %>"></td>
                      </tr>
                      <tr>
                        <td>District :</td>
                        <td><input type="text" name="district" value="<%=s1.getDistrict() %>"></td>
                      </tr>
                      <tr>
                        <td>State :</td>
                        <td><input type="text" name="state" value="<%=s1.getState() %>"></td>
                      </tr>
                      <tr>
                        <td>Pincode :</td>
                        <td><input type="text" name="pincode" value="<%=s1.getPincode()%>"></td>
                      </tr>
                      <tr>
                        <td>Phone Number :</td>
                        <td><input type="text" name="mobile_no" value="<%=s1.getMobile_No() %>"></td> 
                      </tr>
                      <tr>
                      <td><input type="submit" value="update"></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>