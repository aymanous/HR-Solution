
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
  
 <form method="post" action="New_Fiche">
  
 <table  border="1" style="width:100%" >
        
            
              
            <tr><th>Salaire de base</th><th  width="100"> <input type="text" name="salaire_base"  size="30" /></th></tr>
            <tr><td>Prime de rendement</td><td> <input type="text" name="prime_rendement" size="30" /></td></tr>
            <tr><td>Prime de Presence</td><td> <input type="text" name="prime_presence"  size="30"/></td></tr>
            <tr><td>Frais professionnels</td><td> <input type="text" name="frais_professionnels"  size="30"/></td></tr>
            <tr><td>Total primes</td><td> <input type="text"  size="30" /></td></tr>
            <tr><th>Salaire brute</th><th> <input type="text"   size="30"/></th></tr>
            <tr><td>Securité sociale</td><td> <input type="text" name="securite_sociale" size="30"/></td></tr>
            <tr><td>Retraite complémentaire</td><td> <input type="text" name="retraite_complementaire"  size="30"/></td></tr>
            <tr><td>Autres impôts</td><td> <input type="text" name="autres_impots"  size="30"/></td></tr>
            <tr><td>Total impôts</td><td> <input type="text"  size="30"/></td></tr>
            <tr><th>Net à payer</th><th> <input type="text"  size="30"/></th></tr>
            
        
        
 </table>
     <br>
     <br> 
        <input type="text" name="matricule" />      
        <input type="submit" value="Valider" />
  </form>
</body>

</html>