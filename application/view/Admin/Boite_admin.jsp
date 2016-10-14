
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
        
           
      <tr ><td>Identifiant</td><td>Source</td><td>Destination</td><td>Objet</td><td>Contenu</td><td>Date</td><td>Etat</td><td>Exécution</td></tr>      
            
            <c:forEach var="message" items="${ messages }">  
            <tr>
            <td> <c:out value="${ message.id }" /></td>
            <td><c:out value="${ message.source }" /></td>
            <td><c:out value="${ message.destination }" /></td>
            <td><c:out value="${ message.objet }" /></td>
            <td><c:out value="${ message.contenu }" /></td>
            <td><c:out value="${ message.date}" /></td>
            <td><c:out value="${ message.etat }" /></td>
            
            <td> 
                <c:set var="titleURL">
            
                    <c:url value="Marquer_message">  
                         <c:param name="id" value="${ message.id }"/>  
                         <c:param name="matricule" value="${ sessionScope.matricule }"/>                      
                    </c:url>
                   
                </c:set>
              <a href="${titleURL}">marquer</a>
               <c:set var="titleURL">
            
                    <c:url value="Supprimer_message">  
                         <c:param name="id" value="${ message.id }"/> 
                         <c:param name="matricule" value="${ sessionScope.matricule }"/>  
                    </c:url>        
                </c:set>
              <a href="${titleURL}">supprimer</a>
            </td>
            </tr>
            </c:forEach>
             
            
         
        
 </table>
 <br>
 <c:set var="titleURL">
            
                    <c:url value="Nouveau_message">  
                         <c:param name="matricule" value="${ sessionScope.matricule }"/>  
                    </c:url>        
                </c:set>
<a href="${titleURL}">Nouveau message ?</a>
<c:set var="titleURL">
            
                    <c:url value="Messages_envoyes">  
                         <c:param name="matricule" value="${ sessionScope.matricule }"/>  
                    </c:url>        
                </c:set>
<a href="${titleURL}">Messages envoyées ?</a>

   
</body>

</html>