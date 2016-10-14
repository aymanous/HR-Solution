
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8" />

<title>Test</title>

</head>

<body>
   
    <a href="Infos">Informations</a>
    <a href="Conges_Employe">Conges</a>
    <a href="Prime">Prime</a>
    <a href="Liste_formations">Formations</a>
    <a href="Offres_emplois">Offres d'emploi</a>
    <c:set var="titleURL">
                    <c:url value="Boite_message">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Boite de reception</a>
    
  <br>
  <br>
  <br> 
     
<table  border="1" style="width:100%" >
        
           
      <tr ><td>Identifiant</td><td>Service</td><td>Théme</td><td>Priorité</td><td>Durée moyenne</td><td>Budget</td><td>Date de début</td><td>Date de fin</td><td>Lieu</td><td>Etat</td></tr>     
            
            <c:forEach var="formation" items="${ formations }">  
            <tr>
            <td> <c:out value="${ formation.id }" /></td>
            <td><c:out value="${ formation.service }" /></td>
            <td><c:out value="${ formation.theme }" /></td>
            <td><c:out value="${ formation.priorite }" /></td>
            <td><c:out value="${ formation.dure_moy }" /></td>
            <td><c:out value="${ formation.budget }" /></td>
            <td><c:out value="${ formation.date_debut }" /></td>
            <td><c:out value="${ formation.date_fin }" /></td>
            <td><c:out value="${ formation.lieu }" /></td>
            <td><c:out value="${ formation.etat }" /></td>
          
                
            </c:forEach>
             
            
         
        
 </table>
 <br>
 <br>
    <form method="get" action="Liste_formations" >
       <input type="submit" value="Retour" />  
    </form>
   
        
</body>

</html>