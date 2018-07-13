<%@page import="cms.model.TeacherDao"%>
<%@page import="cms.db.Teacher"%>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<style>
button {
    background-color: #4CAF50;
    color: green;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
}

button:hover {
    opacity: 0.8;
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
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> 
                </div>
                <form action="cms.controller.TeacherApplyLeave" method="post">
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                      <td>Name :</td>
                        <td><input type="text" name="name" readonly="readonly" value="<%=s1.getName() %>"></td>
                       </tr>
                      <tr>
                        <td>Email Id</td>
                        <td><input type="text" name="email" readonly="readonly" value="<%=s1.getEmail() %>"></td>
                      </tr>
                      <tr>
                        <td>From Date :</td>
                        <td><input type="text" name="fromDate" ></td>
                      </tr>
                      <tr>
                        <td>To Date :</td>
                        <td><input type="text" name="toDate" ></td>
                      </tr>
                      <tr>
                        <td>Reason :</td>
                        <td><input type="text" name="reason" ></td>
                      </tr>
                      <tr>
                      <td><input type="submit" value="Apply" ></td>
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