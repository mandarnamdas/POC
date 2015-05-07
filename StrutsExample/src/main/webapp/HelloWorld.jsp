<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>
<h1><bean:write name="helloWorldForm" property="message" />
<form action="helloWorld?method=method1" name="helloWorldForm">
<bean:write name="" property=""/> 
</form>
<form action="helloWorld?method=method2"></form>
</h1>
</body>
</html>