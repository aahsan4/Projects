<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>View Meetings</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/scheduler.css" />
    <link rel="stylesheet" href="css/view-meetings.css" />
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
    <h1 id="meeting-title">Meeting</h1>
    <div class="container hi">
        <div class="box">
            <div class="box-row">
                <div class="box-cell box1" style="text-align: center;">
                    <h class="view-meeting-header"> Schedule Meeting</h><br /><br />
            
                    <img id="cal" src="images/calendar-image.png">
                </div>
                <div class="vertical"></div>
                <div class="box-cell box2">
                    <div class="selected-box">
                        <h2 class="selected-meeting-title"> Selected Meeting</h>
                            <h3> Here are the details for the following meeting:</h3>
                            <div class="selected-meeting-boxes">
                                <?php
                                    include "form.php";
                                    session_start();
                                    $id = 1;
                                    $result = mysqli_query($con, "SELECT COUNT(*) FROM meeting_info");
                                    $count = mysqli_fetch_assoc($result);
                                    while($id <= $count)
                                    {
                                        $sql = "SELECT * FROM meeting_info WHERE id = $id";
                                        $result = mysqli_query($con, $sql); 
                                        if(mysqli_num_rows($result) === 1)
                                        {
                                ?>
                                <div class="selected-meeting-box">
                                    <?php
                                            $row = mysqli_fetch_assoc($result);
                                            echo "<div id='Date'>" . "Date: " .  $row['date'] . " at " . $row['time'] . "</div>";
                                            echo "<div id='Virus'>" . "Virus to be tested: " .  $row['virus'] . "</div>";
                                            $virus = $row['virus'];
                                            $sql = "SELECT * FROM test_results WHERE virus = '$virus'";
                                            $result = mysqli_query($con, $sql);
                                            echo "<div id='Attendee'>" . "Attendees: | ";
                                            while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) 
                                            {
                                                echo $row["email"] . "(" . $row["result"] . ")" . " | ";
                                            }
                                            echo "</div>";

                                            
                                            
                                        }
                                        $id++;
                                    ?>
                                        </div>
                                    <?php    
                                    }
                                                    
                                    ?> 
                                            
                                     
                                <a href="view-selected.html">
                                    <h3 class="view-edit">View/Edit (Click to see Results)</h3>
                                </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
