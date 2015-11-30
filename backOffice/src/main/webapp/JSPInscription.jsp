<%-- 
    Document   : JSPInscription
    Created on : 28 nov. 2015, 00:45:38
    Author     : galoat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${InscriptionCours.theme.code}</h1>
        <form action="ServletInscription" method="POST">
            <div class="label">
                <label> FirstName </label>
                <input name="FName" type="text">
            </div>
            <br>
            
              <div class="label">
                <label> LastName </label>
                <input name="LName" type="text">
            </div>
            <br>
           <div class="label">
                <label> Addrese </label>
                <input name="Adresse" type="text">
            </div>
            <br>
             <div class="label">
                <label> Phone </label>
                <input name="Phone" type="text">
            </div>
            <br>
             <div class="label">
                <label> EMail </label>
                <input name="Email" type="text">
            </div>
            <br>
            <button type="submit"> Inscription </button>
        </form>
    </body>
</html>
