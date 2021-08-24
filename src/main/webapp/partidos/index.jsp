

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
            <span class="fs-4">Inicio</span>
          </a>     
        </header>
      </div>        
        
        <form action="MyServlet" method="post" autocomplete="off">
            
              <div class="form-floating">
                <input type="text" class="form-control" id="text_usuario" name="text_usuario" >
                <label for="floatingInput">Usuario</label>
              </div>
              <div class="form-floating">
                <input type="password" class="form-control" id="text_contrasena" name="text_contrasena" >
                <label for="floatingPassword">Password</label>
              </div>              
              <button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar</button>
            
        </form>
     </main>   
        
        
    </body>
</html>
