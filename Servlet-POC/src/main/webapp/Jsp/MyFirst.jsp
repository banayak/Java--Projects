<html>
<head>
<%-- Below is JSP Declaration --%>

<%!
 int counter =0;
%>

</head>
<body>
<h2>JSP Example</h2>
<%-- This is the JSP comment will not visible to html output--%>
<%-- Below is scriptlet example--%>

<%

String str = request.getRequestURI();
String str1 = request.getRequestURL().toString();
  out.println("Request URI ::"+ str + "</br>");

  out.println("Request URL ::"+ str1 + "</br>");
 out.println("How many times hit this page ::"+ counter++ + "</br>");
%>

<%-- This is the JSP expression--%>
Request URI :: <%= str %>
</br>
Request URL :: <%= str %>
</br>
How many times hit this page :: <%= counter %>
</br>

</body>
</html>
