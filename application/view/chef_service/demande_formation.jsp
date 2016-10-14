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
                    <c:url value="equipe">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Equipe</a>
          <c:set var="titleURL">
                    <c:url value="Missions">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             </c:set>
     <a href="${titleURL}">Missions</a>
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
      <form method="post" action="demande_formation">

     <table  style="width:300px">
       <tr>
          <td><label for="service">Service </label> </td>
          <td><input type="text" name="service" id="service" value="${ requestScope.service }" /></td>
        </tr>          
         <tr>
           <td> <label for="theme">Théme </label></td>
        <td> <input type="text" name="theme" id="theme" /></td>
        </tr>
        <tr>
           <td> <label for="priorite">Priorité </label></td>
           <td> <input type="text" name="priorite" id="priorite" /></td>
        </tr>
        <tr>
           <td> <label for="dure_moy">Durée moyenne </label></td>
           <td> <input type="text" name="dure_moy" id="dure_moy" /></td>
        </tr>
       
     </table>
   
     <br>
    
 <p>Liste des employées désignés</p>
 
 


        
            
            <c:forEach var="utilisateur" items="${ utilisateurs }">  
            
             <input type="checkbox" name="designes" value="${ utilisateur.matricule }"> <c:out value="${ utilisateur.nom }" /> <c:out value="${ utilisateur.prenom }" />
            
            </c:forEach>      
 
     <br>
     <br>
     <p>
      
        <input type="hidden" name="matricule" id="matricule" value="${sessionScope.matricule }" /> 
        <input type="submit" value="Valider" /> 
        <input type="reset" value="annuler" />
     </p>
        
        
        
 </form>
 <br>

  
</body>

</html>