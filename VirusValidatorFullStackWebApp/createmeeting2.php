<?php
session_start();
include "form.php";

if(isset($_POST['email']) && isset($_POST['virus-type']) && isset($_POST['date']) && isset($_POST['time']))
{
    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
}

$email = validate($_POST['email']);
$virusType = validate($_POST['virus-type']);
$date = validate($_POST['date']);
$time = validate($_POST['time']);

if(empty($email))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Empty field: email");';
    echo 'window.location.replace("createmeeting.php");';
    echo "</script>";
    exit();
}
else if(empty($virusType))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Empty field: virus-type");';
    echo 'window.location.replace("createmeeting.php");';
    echo "</script>";
    exit();
}
else if(empty($date))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Empty field: date");';
    echo 'window.location.replace("createmeeting.php");';
    echo "</script>";
    exit();
}
else if(empty($time))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Empty field: time");';
    echo 'window.location.replace("createmeeting.php");';
    echo "</script>";
    exit();
}

$result = mysqli_query($con, "SELECT * FROM meeting_info WHERE date = '$date' && time = '$time' && virus = '$virusType'");
$row = mysqli_fetch_assoc($result);
if(empty($row))
{
    $sql = "INSERT INTO attendee_login (email, virus) VALUES ('$email', '$virusType')";

    $result = mysqli_query($con, $sql); 

    $sql = "INSERT INTO meeting_info (date, time, virus) VALUES ('$date', '$time', '$virusType')";

    $result = mysqli_query($con, $sql); 
}
else
{
    $sql = "INSERT INTO attendee_login (email, virus) VALUES ('$email', '$virusType')";

    $result = mysqli_query($con, $sql); 
} 

mysqli_close($con);
echo "<script language='javascript'>";
echo 'window.location.replace("createmeeting.php");';
echo "</script>";
exit();

?>