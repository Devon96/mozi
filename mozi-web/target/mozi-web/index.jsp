<html>
<body>
<%!
    private static int counter = 0;
%>

<%
    if(request.getParameter("submit") != null){
        counter++;
    }
%>

<h1>Counter value: <%= counter %></h1>

<form method="post" action="index.jsp">
    <button type="submit" name="submit">Increment</button>
</form>

</body>
</html>
