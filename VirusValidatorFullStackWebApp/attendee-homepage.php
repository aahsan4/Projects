<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Attendee Homepage</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/attendee.css" />
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <link rel="icon" href="./images/icon.png" />
</head>

<body>
    <div class="header_section">
        <div class="container-fluid">
            <div class="main">
                <div class="logo">
                    <a href="index.html"><img class="vv" src="./images/vvdarkpp.png" /></a>
                </div>
            </div>
        </div>
    </div>

    <h1 class="word">WELCOME ATTENDEE!</h1>
    <div class="intro">
        <h6 class="welcome">
            To ensure the health and safety of you and others, you are
            <span>REQUIRED</span> to take the quiz below to determine if you are eligible to attend the scheduled meeting or not:
        </h6>
        <hr />
        <div class="column">
            <div class="meeting">
                <!-- <i class="fas fa-calendar-days fa-6x"></i> -->

                <img class="calender" src="./images/calender.webp" />
                <ul class="item">
                    SCHEDULED MEETING:
                    <?php
                        session_start(); 
                        include "form.php";
                        $virus = $_SESSION['virus'];
                        $sql = "SELECT * FROM meeting_info WHERE virus = '$virus'";
                        $result = mysqli_query($con, $sql); 
                        if(mysqli_num_rows($result) === 1)
                        {
                            $row = mysqli_fetch_assoc($result);
                            echo "<div id='Date'>" . "DATE: " .  $row['date'] . "</div>";
                            echo "<div id='Time'>" . "TIME: " . $row['time'] . "</div>";
                        }
                        //exit();
                    ?>
                </ul>
            </div>
            <hr />
        </div>
        <h6 class="welcome">
            Please click on the button below to answer some questions to determine
            <br /> if you are eligible to attend the scheduled meeting or not.
        </h6>

        <form action="questionaire.php" method="post">
            <button class="quiz" type="submit" class="button">TAKE QUIZ</button>
        </form>
</body>

</html>