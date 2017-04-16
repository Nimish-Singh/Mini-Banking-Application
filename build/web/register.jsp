<jsp:useBean id="obj" class="dbConnections.RegistrationCredentials"></jsp:useBean>
<jsp:setProperty name="obj" property="*"></jsp:setProperty>
<%
  int registerStatus=obj.register();
  if(registerStatus==-5)
  {
%>
<script>
    alert("You already have an E-banking account.");
    window.location.assign("register.html");
</script>;
<%
  }
  else
  {
      if(registerStatus==-10)
      {
%>
<script>
    alert("The form details didn't match our database information.");
    window.location.assign("register.html");
</script>
<% 
       }
      else
          if(registerStatus==0)
          {
%>
<script>
            alert("Sorry, we are having some technical issues at present.");
            window.location.assign("index.html");
</script>
<%
          }
      else
              if(registerStatus==1)
              {
%>
<script>
    alert("You have been successfully registered.");
    window.location.assign("index.html");
</script>
<%
              }
  }
%>