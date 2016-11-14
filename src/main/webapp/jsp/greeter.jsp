<html>
    <head>
    <style>
         input[type=submit]
    </style>
    </head>
    <body>
        <a href="/"><input type="submit" value="To dashboard"></a>

          <form action="/greeter">
                 <input type="text" name="name" placeholder="username"/>
                 <input type="submit" class="button" value="greet"></form>

         <h2>
          <p>Welcome ${name}</p>
        </h2>

    </body>
</html>