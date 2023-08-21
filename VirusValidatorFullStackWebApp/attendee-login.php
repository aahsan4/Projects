<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="./css/login.css" />
    <link rel="icon" href="./images/icon.png" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css">
  </head>

  <body>

    <div class="header_section">
      <div class="container-fluid">
          <div class="main">
              <div class="logo">
                  <a href="index.html"><img class="vv" src="./images/vvdarkpp.png"></a>
              </div>

          </div>
      </div>

    <div class="center">
      <button id="show-login">Login</button>
    </div>

    <div class="popup-login">
      <!-- <div class="close-btn">&times;</div> -->
      <form action="attendee_login2.php" method="post">
        <h2>Log in</h2>
        <?php if(isset($_GET['error'])) {  ?> 
          <p class="error"> <?php echo $_GET['error']; ?></p>
        <?php } ?> 
        <label for="username">Enter your Email:</label>
        <input type="text" name="username" placeholder="Enter email" />       
        <button type="submit">Log In</button>
 
      </form>
    </div>
  </body>
  <script src="./js/login.js"></script>
</html>
