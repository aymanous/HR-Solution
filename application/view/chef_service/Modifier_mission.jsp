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

 <form method="post" action="Modifier_mission">

     <table  style="width:300px">
       <tr>
          <td><label for="id">Identifiant </label> </td>
          <td><input type="text" name="id" id="id" value="${param.id}"/></td>
        </tr>  
        
        <tr>
           <td> <label for="service">Service </label></td>
           <td> <input type="text" name="service" id="service" value="${param.service}" /></td>
        </tr>
         <tr>
           <td> <label for="objet">Objet </label></td>
           <td> <input type="text" name="objet" id="objet" value="${param.objet}" /> </td>
        </tr>
        <tr>
           <td> <label for="description">Description</label></td>
           <td> <input type="text" name="description" id="description" value="${param.description}"/></td>
        </tr>
         <tr>
            <td><label for="date_debut">Date de début </label></td>
            <td><input type="text" name="date_debut" id="date_debut" value="${param.date_debut}" /></td>
        </tr>
        
        <tr>
           <td> <label for="dure">Durée </label></td>
           <td> <input type="text" name="dure" id="dure" value="${param.dure}" /></td>
        </tr>
        <tr>
            <td><label for="lieu">Lieu  </label></td>
            <td><input type="text" name="lieu" id="lieu" value="${param.lieu}" /></td>
        </tr>
        <tr>
            <td><label for="etat">Etat </label></td>
            <td><input type="text" name="etat" id="etat" value="${param.etat}" /></td>
        </tr>
      
     </table>
   
     <br>
     <p>
      <input type="hidden" name="matricule" value="${ sessionScope.matricule }" /> 
      <input type="submit" value="valider" />        
      <input type="reset" value="retour" />
     </p>
        
        
        
 </form>

       
</body>

</html>