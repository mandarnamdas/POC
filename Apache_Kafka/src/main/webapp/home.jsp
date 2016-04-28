<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> My first JSP   </title>
	</head>	
	<body>		
		<form action="MessageProducer" method="post">			
			 Number of Producers : <br/> <input type="text" name="threadCount"size="20px"><br/>
             Message count each Producer will send : <br/><input type="text" name="messageCount"size="20px"><br/>
			<input type="submit" value="submit">						
            <div>
                ${successMessage}
            </div>		
		</form>
        
        <form action="MessageConsumer" method="post">
            <input type="hidden" name="option" value="start"/>
            <select name ="database">
                <option value="MYSQL" ${database == 'MYSQL' ? 'selected' : ''}>MySql</option>
                <option value="SQL" ${database == 'SQL' ? 'selected' : ''}>SQL</option>
                <option value="MONGODB" ${database == 'MONGODB' ? 'selected' : ''}>MongoDB</option>
            </select>           
            <input type="submit" value="Start Consumer">                        
        </form>
        
        <form action="MessageConsumer" method="post">
            <input type="hidden" name="option" value="stop"/>
            <input type="hidden" name="database" value="${database}"/>           
            <input type="submit" value="Stop Consumer">                        
        </form>
        
        <form action="MessageReader" method="post">
            <input type="submit" value="Get Customer Details">
            <br/>                        
            <div>
            Total number of Customers : ${fn:length(customerDetails)}
            </div><br/>
            <table border="1">
            <thead>
                <tr><td>Customer ID</td><td>Status</td><td>Start Time</td><td>End Time</td><td>Time Difference</td></tr>
            </thead>            
            <c:forEach items="${customerDetails}" var="customer">
                <tr>
                    <td>
                        <c:out value="${customer.customerId}"/>
                    </td>
                    <td>
                        <c:out value="${customer.status}"/><br/>
                    </td>
                    <td>
                        <c:out value="${customer.startTime}"/><br/>
                    </td>
                    <td>
                        <c:out value="${customer.endTime}"/><br/>
                    </td>
                    <td>
                        <c:out value="${customer.timeDifference}"/><br/>
                    </td>
                </tr>
            </c:forEach>
            </table>     
            
        </form>
        
	</body>	
</html>