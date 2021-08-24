<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <span class="fs-4">Usuario</span>
      </a>     
    </header>
  </div>
        
        
        <form action="UsuariosController?accion=insert" method="post" autocomplete="off">
            
            <div class="mb-3">
              <label for="nombre" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre">
            </div>
            
            <div class="mb-3">
              <label for="correo" class="form-label">Email</label>
              <input type="email" class="form-control" id="correo" name="correo" aria-describedby="emailHelp">
            </div>
            
            <div class="mb-3">
              <label for="username" class="form-label">User Name</label>
              <input type="text" class="form-control" id="username" name="username">
            </div>
            
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password">
            </div>            
            <button type="submit" class="btn btn-primary">Crear Usuario</button>
          </form>
     </main>   
        
        
    </body>
</html>
