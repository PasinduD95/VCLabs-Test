<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>customers</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   </head>
   <body>
      <h3>Add Customers</h3>

      <form:form method="post" action="/SpringMVCTutorial/employee.html" commandName="customer">
        <div class="table-responsive">
          <table class="table table-bordered" style="width: 300px">
            <tr>
              <td>Customer Id :</td>
              <td><form:input type="text" path="customerId" /></td>
            </tr>
            <tr>
              <td>Dept Id :</td>
              <td><form:input type="text" path="deptId" /></td>
            </tr>
            <tr>
              <td>Customer Name :</td>
              <td><form:input type="text" path="customerName" /></td>
            </tr>
            <tr>
              <td>Contact No :</td>
              <td><form:input type="text" path="contactNo" /></td>
            </tr>
            <tr>
              <td>Address :</td>
              <td><form:input type="text" path="address" /></td>
            </tr>
            <tr>
              <td></td>
              <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
            </tr>
          </table>
        </div>
      </form:form>
     <br>
     <h3>List of Customers</h3>
       <table class="table table-bordered" style="width: 300px">
         <tr>
           <th>Customer Id</th>
           <th>Dept Id</th>
           <th>Customer Name</th>
           <th>Contact No</th>
           <th>Address</th>
           <th>Edit/Delete</th>
         </tr>
         <c:forEach items="${customerList}" var="customer">
         <tr>
           <td width="60" align="center">${customer.customerId}</td>
           <td width="60" align="center">${customer.deptId}</td>
           <td width="60" align="center">${customer.customerName}</td>
           <td width="60" align="center">${customer.contactNo}</td>
           <td width="60" align="center">${customer.Address}</td>

           <td width="60" align="center"><a href="edit/${customer.customerId}">Edit</a></td>
         </tr>
      </c:forEach>
    </table>
  </body>
</html>