<%
response.setStatus(301); // Permanent redirect code.
response.setHeader("Location", "/childrensplace");
response.setHeader("Connection", "close");
%>
