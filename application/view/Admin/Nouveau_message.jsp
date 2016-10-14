
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
  <br>
 
  <form method="post" action="Nouveau_message">

     <table  style="width:300px">
       <tr>
          <td><label for="position">Source </label> </td>
          <td><input type="text" name="source" id="position" value="${ param.matricule }" /></td>
        </tr>
        
        <tr>
           <td> <label for="competences">Destination </label></td>
           <td> <input type="text" name="destination" id="competences" /></td>
        </tr>
         <tr>
           <td> <label for="experience">Objet </label></td>
           <td> <input type="text" name="objet" id="experience" /></td>
        </tr>
        <tr>
           <td> <label for="description">Contenu </label></td>
           <td> <input type="text" name="contenu" id="description" /></td>
        </tr>
        
     
     </table>
   
     <br>
     <p>
      <input type="submit" value="envoyer" />        
      <input type="reset" value="annuler" />
     </p>
        
        
        
 </form>
  
    
</body>

</html>