<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Partidos de Futbol</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">             
        <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">
    
        <link href="partidos/css/bootstrap.min.css" rel="stylesheet">
        <link href="partidos/css/estilos.css" rel="stylesheet">
        
    </head>
    <main class="form-signin">
    <body>
       
        
       
        
        
    <div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <span class="fs-4">Partidos</span>
      </a>     
    </header>
  </div>
        
        <div class="mb-3">          
         <a href="UsuariosController?accion=lista"> Ir a Usuarios</a>    

<!-- ${cookie['JSESSIONID'].getValue()}         
${cookie['JWT'].getValue()}         -->
        </div>        
        
        <form action="UsuariosController?accion=insert_partidos" method="post" autocomplete="off">
            
            <div class="mb-3">
              <label for="nombre" class="form-label">Equipo Local</label>
              <select name="equipo_local" id="equipo_local" class="form-select" aria-label="Default select example">
                <option selected>Seleccione un Equipo</option>                        
                    <c:forEach var="lista_equipos" items="${lista_equipos}">
                        <option value="${lista_equipos.id}">${lista_equipos.nombre}</option>                    
                    </c:forEach>                
              </select>
            </div>
            
            <div class="mb-3">
              <label for="correo" class="form-label">Equipo Visitante</label>
              <select name="equipo_visitante" id="equipo_visitante" class="form-select" aria-label="Default select example">
                <option selected>Seleccione un Equipo</option>                        
                    <c:forEach var="lista_equipos" items="${lista_equipos}">
                        <option value="${lista_equipos.id}">${lista_equipos.nombre}</option>                    
                    </c:forEach>                
              </select>
            </div>
            
            <div class="mb-3">
              <label for="username" class="form-label">Goles Local</label>
              <input type="text" class="form-control" id="gol_local" name="gol_local">
            </div>           
            <div class="mb-3">
              <label for="username" class="form-label">Goles Visitantes</label>
              <input type="text" class="form-control" id="gol_visita" name="gol_visita">
            </div>           
                     
            <button type="submit" class="btn btn-primary">Enviar</button>
          </form>
        
        
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Local</th>
                <th scope="col">Goles Local</th>
                <th scope="col">Visitante</th>
                <th scope="col">Goles Visitante</th>
              </tr>
            </thead>
            <tbody>
                
                <c:forEach var="partidos_jugados" items="${partidos_jugados}">
                    
                    <tr>
                        <td><c:out value="${partidos_jugados.local}" /></td>
                        <td><c:out value="${partidos_jugados.goles_local}" /></td>
                        <td><c:out value="${partidos_jugados.visitante}" /></td>
                         <td><c:out value="${partidos_jugados.goles_visitantes}" /></td>
                        
                        <th> <a href="UsuariosController?accion=modificar&id=<c:out value="${partidos_jugados.id}" />">Modificar</a></th> 
                        
                        
                      </tr>                    
                    
                </c:forEach>
                
                
                
              
              
            </tbody>
          </table>
        
        
     </main>   
        
        
    </body>
</html>
