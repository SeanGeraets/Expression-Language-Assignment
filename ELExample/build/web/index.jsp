<%-- 
    Document   : index
    Created on : Feb 20, 2020, 6:29:47 PM
    Author     : Sean Geraets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="nameModel" class="edu.kirkwood.java.NameModel" 
             scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL Name and Number Form</title>
        <link href="css/standard.css" rel="stylesheet" type="text/css"/>
        <script>
            /**
             * NOTE: This is JavaScript.  It is not necessary but 
             * convenient.
             */
            function setCursorFocus(){
                document.getElementById("userName").focus();
                document.getElementById("userName").select();
            }
        </script>
    </head>
    <body onload="setCursorFocus()" >
        <header>
            <h1>Name and Number Form with Expression Language</h1>
        </header>
        <section>
            <h2>Hello, ${nameModel.userName}</h2>
            <p>Please enter your name and number.</p>
            <form action="NameHandler" method="GET" >
                <label for="userName" >User Name</label><br />
                <input type="text" name="userName" id="userName" 
                       value="${nameModel.userName}" />
                <span class="errorSpan">${nameModel.userNameError}</span><br />
                
                <label for="userNumber" >User Number</label><br />
                <input type="text" name="userNumber" 
                       value="${nameModel.userNumber}" />
                <span class="errorSpan">${nameModel.userNumberError}</span><br />
                
                <input type="submit" value="Submit" />
            </form>
                <p>Current Number: ${nameModel.userNumber}</p>
        </section>
        <section>
            <h2>Notes</h2>
            <p>
                When you look at the useBean tag, notice that the class is 
                fully qualified.  This removes the need for an import
                directive.
            </p>
        </section>
    </body>
</html>





