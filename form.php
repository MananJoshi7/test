<?php include("connection.php"); ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="#" method="POST">
        <label>Firstname</label>
        <input type="text" class="input" name="fname">
        <br>
        <label>Lastname</label>
        <input type="text" class="input" name="lname">
        <br>
        <label>Password</label>
        <input type="password" class="input" name="password">
        <br>
        <label>Confirm Password</label>
        <input type="password" class="input" name="conpassword">
        <br>
        <label>Gender</label>
        <select name="gender">
            <option value="Not Selected">Select</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>
        <br>
        <label>Email</label>
        <input type="text" class="input" name="email">
        <br>
        <label>Phone Number</label>
        <input type="text" class="input" name="phone">
        <br>
        <label>Address</label>
        <textarea name="address"></textarea>
        <br>
        <input type="submit" value="register" name="register">
    </form>
</body>
</html>
<?php
    if($_POST['register'])
    {
        $fname = $_POST['fname'];
        $lname = $_POST['lname'];
        $password = $_POST['password'];
        $conpassword = $_POST['conpassword'];
        $gender = $_POST['gender'];
        $email = $_POST['email'];
        $phone = $_POST['phone'];
        $address = $_POST['address'];
            $query = "INSERT INTO FORM VALUES('$fname','$lname','$password','$conpassword','$gender','$email','$phone','$address')";
            $data = mysqli_query($conn,$query);
    }
?>
