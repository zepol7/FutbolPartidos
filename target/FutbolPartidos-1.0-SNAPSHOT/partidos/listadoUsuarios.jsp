
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <span class="fs-4">Listado de Usuarios</span>
      </a>     
    </header>
  </div>
        
        
        <form>
            
            <div class="mb-3">
              <label for="nombre_usuario" class="form-label">Nombre</label>
              <br />
              
              <a href="UsuariosController?accion=nuevo"> Ir a Usuarios</a>
              
              <a href="UsuariosController?accion=lista_partidos"> Ir a Partidos</a>
            
            </div>
            
            
            <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Correo</th>
                <th scope="col">Usuario</th>
              </tr>
            </thead>
            <tbody>
                
                <c:forEach var="usuarios" items="${lista}">
                    
                    <tr>
                        <th scope="row"> <c:out value="${usuarios.id}" /> </th>
                        <td><c:out value="${usuarios.nombre}" /></td>
                        <td><c:out value="${usuarios.correo}" /></td>
                        <td><c:out value="${usuarios.username}" /></td>
                        
                        <th> <a href="UsuariosController?accion=modificar&id=<c:out value="${usuarios.id}" />">Modificar</a></th>
                        
                        
                      </tr>
                    
                    
                </c:forEach>
                
                
                
              
              
            </tbody>
          </table>
            
            
          </form>
     </main>   
        
        
    </body>
</html>
