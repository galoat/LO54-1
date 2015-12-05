<%-- 
    Document   : brackOffice
    Created on : 18 nov. 2015, 22:25:08
    Author     : galoat
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BackOffice</title>
    </head>
    <body>
        <h1>Backoffice</h1>
        
        <table border="1">
            <tr>
                <th> Code UV </th>
                <th> Theme </th>
                <th> Debut </th>
                <th> Fin </th>
                <th> lieu </th>
                <th> inscription </th>
            </tr>
             <c:forEach items ="${listCours}" var="cours">
                 <tr> 
                     <th>${cours.theme.code}</th>
                     <th>${cours.theme.titre}</th>
                     <th> <fmt:formatDate type="date" value="${cours.debut}"/></th>
                      <th> <fmt:formatDate type="date" value="${cours.fin}"/></th>
                     <th>${cours.lieu.city}</th>  
                     <th>
                 <form action="ServletInscription">
                     <input type="hidden" name="InscriptionCours" value= ${cours.ID} </input>
                     <button type="submit"> inscription </button>
                 </form>
             </th>
                </tr>
            </c:forEach>
                <form action="ProjetServlet" method="POST">
                      <div class="label">
                              <label>Keyword :</label>
                              <input name="keyword" type="text" >
                         </div> 
                      <br>
                      <select name="location">
                          <option>Toute les Villes </option>
                          <c:forEach items="${listeVille}" var="ville">
                                    <option>${ville.city}
                          </c:forEach>
                       </select>
                      <br>
                      <input name="dateDebut" type="text" placeholder="JJ/MM/AA">
                     <button type="submit">Rechercher</button>		 
        </form>
    </body>
</html>
