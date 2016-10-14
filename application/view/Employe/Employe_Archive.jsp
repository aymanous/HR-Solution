
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8" />

<title>Test</title>

</head>

<body>

             <c:set var="titleURL">
                    <c:url value="Employe_Infos">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
            
       <a href="${titleURL}">Informations</a>
    <c:set var="titleURL">
                    <c:url value="Employe_Fiche">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Fiche de paie</a>
     <c:set var="titleURL">
                    <c:url value="Employe_Conge">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Conges</a>
     <c:set var="titleURL">
                    <c:url value="Employe_missions">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Missions</a>
         <c:set var="titleURL">
                    <c:url value="employe_formations">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Formations</a>
    <c:set var="titleURL">
                    <c:url value="Boite_message">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Boite de reception</a>
    <br>
    <br>
    <br>
    <br> 
   <table  border="1" style="width:100%" >
      <tr><td>matricule</td><td>Date de début</td><td>Nombre des jours</td><td>Type</td><td>Réponse</td></tr>
      <c:forEach var="archi" items="${ archive }"> 
      <tr>
            <td> <c:out value="${ sessionScope.matricule }" /></td>
            <td> <c:out value="${ archi.datedeb }" /></td>
            <td><c:out value="${ archi.jours_demande }" /></td>
            <td><c:out value="${ archi.type_conge }" /></td>
            <td><c:out value="${ archi.reponse }" /></td>

      </tr> 
       </c:forEach>

   </table>
    <br>
    <br>
    <form method="get" action="Employe_Conge" >
       <input type="hidden" name="matricule" value="${sessionScope.matricule }" />
       <input type="submit" value="Retour" />  
    </form>
  
</body>

</html>