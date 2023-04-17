<%
response.setStatus(301); // Permanent redirect code.
response.setHeader("Location", "/childrensplace");
response.setHeader("Connection", "close");
response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
%>
