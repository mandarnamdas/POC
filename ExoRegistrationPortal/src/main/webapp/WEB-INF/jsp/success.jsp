<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>You Have Successfully Registered!!!!!!!</h1>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/registration.css">

</head>

 <div class="container">
    
    <table class="table table-hover">
      <thead>
        <tr>
          <th>Registered User</th>
        </tr>
      </thead>
      <tbody>
        <tr>

        <th style="text-align:left">Name</th>

        <th style="text-align:left">Email</th>

    </tr>

    <c:forEach items = "${customerList}" var ="contact">  

        <tr>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.username}</td>
            

        </tr>

    </c:forEach>
        
      </tbody>
    </table>  
    
</div>