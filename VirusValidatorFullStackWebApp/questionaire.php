<html lang="en">
  <!-- copy-->
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Virus Questionaire</title>
    <link rel="stylesheet" href="css/createmeeting.css" />
    <!-- bootstrap css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <script src="js/createmeeting.js" defer></script>

    <script
      type="module"
      src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
    ></script>
    <link rel="icon" href="./images/icon.png" />
  </head>

  <body>
    <div class="contianer">
      <div class="calendar">
        <h class="meeting-title">  
          <?php
            session_start(); 
            include "form.php";
            $virus = $_SESSION['virus'];
            $sql = "SELECT * FROM meeting_info WHERE virus = '$virus'";
            $result = mysqli_query($con, $sql); 
            if(mysqli_num_rows($result) === 1)
            {
              $row = mysqli_fetch_assoc($result);
              echo "<div id='virus'>" . $row['virus'] . " Symptom Survey" ."</div>";
            }
          
          ?>    
          
        </h><br /><br />
        <h class="selection-heading">
          All attendees are required to complete the following screening survey
          prior to entry.
        </h>
        <br /><br />
        <p class="selection-heading">
          In the past 24 hours, have you experienced:
        </p>
        <form method="post" action="process_survey.php">

          <p>Shortness of breath or difficulty breathing:</p>
          <input type="radio" id="yes" name="q1" value="yes">
          <label for="yes">Yes</label><br>
          <input type="radio" id="no" name="q1" value="no">
          <label for="no">No</label><br>
      
          <p>Fever or chills:</p>
          <input type="radio" id="yes2" name="q2" value="yes">
          <label for="yes2">Yes</label><br>
          <input type="radio" id="no2" name="q2" value="no">
          <label for="no2">No</label><br>

          <p>New or worsening cough:</p>
          <input type="radio" id="yes3" name="q3" value="yes">
          <label for="yes3">Yes</label><br>
          <input type="radio" id="no3" name="q3" value="no">
          <label for="no3">No</label><br>

          <p>Muscle or body aches:</p>
          <input type="radio" id="yes4" name="q4" value="yes">
          <label for="yes4">Yes</label><br>
          <input type="radio" id="no4" name="q4" value="no">
          <label for="no4">No</label><br>

          <p>Headaches:</p>
          <input type="radio" id="yes5" name="q5" value="yes">
          <label for="yes5">Yes</label><br>
          <input type="radio" id="no5" name="q5" value="no">
          <label for="no5">No</label><br>

          <p>New loss of taste of smell:</p>
          <input type="radio" id="yes6" name="q6" value="yes">
          <label for="yes6">Yes</label><br>
          <input type="radio" id="no6" name="q6" value="no">
          <label for="no6">No</label><br>

          <p>Sore throat:</p>
          <input type="radio" id="yes7" name="q7" value="yes">
          <label for="yes7">Yes</label><br>
          <input type="radio" id="no7" name="q7" value="no">
          <label for="no7">No</label><br>

          <p>Nausea or vomiting:</p>
          <input type="radio" id="yes8" name="q8" value="yes">
          <label for="yes8">Yes</label><br>
          <input type="radio" id="no8" name="q8" value="no">
          <label for="no8">No</label><br>

          <p>Congestion or runny nose:</p>
          <input type="radio" id="yes9" name="q9" value="yes">
          <label for="yes9">Yes</label><br>
          <input type="radio" id="no9" name="q9" value="no">
          <label for="no9">No</label><br>

          <p>Dizziness, confusion, difficulty waking up:</p>
          <input type="radio" id="yes10" name="q10" value="yes">
          <label for="yes10">Yes</label><br>
          <input type="radio" id="no10" name="q10" value="no">
          <label for="no10">No</label><br>
      
          <input type="submit" value="View Results"class="btn btn-default btn-lg submit"> 
          

        </form>
        <br /><br />
        
      </div>
    </div>
    <div class="footer_section layout_padding"></div>
  </body>
</html>
