<?php
session_start();
include "form.php";

if(isset($_POST['username']) && isset($_POST['password']))
{
    function validate($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
}

$username = validate($_POST['username']);
$password = validate($_POST['password']);

if(empty($username))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Input your email");';
    echo 'window.location.replace("admin-login.php");';
    echo "</script>";
    exit();
}
else if(empty($password))
{
    echo "<script language='javascript'>";
    echo 'alert("Error: Input your password");';
    echo 'window.location.replace("admin-login.php");';
    echo "</script>";
    exit();
}

$sql = "SELECT * FROM admin_login WHERE email='$username' AND pass='$password'";

$result = mysqli_query($con, $sql);

if(mysqli_num_rows($result) === 1)
{
    $row = mysqli_fetch_assoc($result);
    if($row['email'] === $username && $row['pass'] === $password)
    {
        echo "Logged in!";
        $_SESSION['email'] = $row['email'];
        $_SESSION['pass'] = $row['pass'];
        $_SESSION['id'] = $row['id'];
        header("Location: admin-homepage.html");
        exit();
    }
    else
    {
        echo "<script language='javascript'>";
        echo 'alert("Error");';
        echo 'window.location.replace("admin-login.php");';
        echo "</script>";
        exit();
    }
}
else
{
    echo "<script language='javascript'>";
    echo 'alert("Invalid e-mail or password");';
    echo 'window.location.replace("admin-login.php");';
    echo "</script>";
    exit();

}
?>