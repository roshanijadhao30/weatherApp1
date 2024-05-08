<%@page import="java.io.IOException"%>
<%@page import="org.apache.catalina.webresources.Cache"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "javax.servlet.ServletContext" %>  
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.io.PrintWriter" %>
<%@ page import = "java.time.LocalDateTime" %> 
<%@ page import = "java.time.format.DateTimeFormatter" %>
<%@ page import = "java.text.SimpleDateFormat" %> 
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "javax.servlet.ServletContext" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<style type="text/css">
  body{
    background-color: gray;
  }
  .my-card{
           padding: 10px;
           background: white;
           margin-top: 100px;
           margin-left: 400px;
           width: 600px;
              
           
  }
   img{
      border-radius: 50%;
      width: 150px;
      height: 150px;
      margin-left: 20px;
      margin-top: 0px;
  }
  h5{
  size: 5px;
   display: flex;
      align-items: center; 
  }   
  .container {
 display: grid;
 align-items: center; 
 grid-template-columns: 1fr 1fr 1fr;
 column-gap: 5px;
}
.text {
  font-size: 50px;
}
.temple{
        size: 10px;
        display: flex;
        text-align: right; 
        margin-left: 200px;
}
.test1{
           margin-left: 20px;
}
</style>

<body> 
     <div class="my-card">
     
     <%!
        Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("hh:mm aa");
		String time1  = s.format(d);
    %>
     
     <h5><% out.print(time1); %></h5>
     
     <h5 class="temple">Current Weather </h5><hr>
     <%
     ServletContext context=getServletContext();  
     double n=(double)context.getAttribute("temp1");
     int n1=(int)context.getAttribute("temp2");
     int n2=(int)context.getAttribute("temp3");
     int n3=(int)context.getAttribute("temp4");
     int h4 = (int)context.getAttribute("h");
     int h5 = (int)context.getAttribute("m");
     int h6 = (int)context.getAttribute("s");
     %>
     <div>
   
 
      <div class="container">
      <div class="image">
        <img src="wether3.jpg">
      </div>
      <div>
        <h1 class="text"><%out.print(n);%>°C</h1> 
      </div>
    </div><hr>
     <h5 class="test1">Sunrise : <%out.println("  "+n1+":"+n2+":"+n3);%></h5><br>
     <h5 class="test1">Sunset : <%out.println("  "+h4+":"+h5+":"+h6);%></h5>
  </div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>