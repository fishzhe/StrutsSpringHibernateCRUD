<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://code.jquery.com/jquery-2.2.3.min.js"
            integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div id="saveUserContainer" class="form-group" style="width:60%; margin-top: 20px; margin-left: 20px">
    <form action="saveUser" method="post">
        <div class="form-group row">
            <label for="name" class="col-sm-2 form-control-label">Name: </label>
            <div class="col-sm-10">
                <input id="name" class="form-control" type="text" name="user.name" placeholder="User Name"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="phone" class="col-sm-2 form-control-label">Phone: </label>
            <div class="col-sm-10">
                <input id="phone" class="form-control" type="text" name="user.phone" placeholder="Phone Number" />
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-info" type="submit" value="Create User"/>
            </div>
        </div>
    </form>
</div>
<table id="listUserContainer" class="table table-striped table-hover table-condensed table-responsive"
       style="margin-top: 10px; margin-left: 20px; margin-right: 20px; width: 60%">
        <tr>
            <td> Name </td>
            <td> Phone </td>
            <td> Delete</td>
            <td> Update</td>
        </tr>

        <s:iterator value="users" status="userStatus" var="user">
            <tr>
                <form action="saveUser" method="POST">
                    <td>
                        <input type="hidden" name="user.id" value="<s:property value="#user.id"/>"/>
                        <input class="form-control" type="text" name="user.name" value="<s:property value="#user.name" />"/>
                    </td>
                    <td>
                        <input class="form-control" type="text" name="user.phone" value="<s:property value="#user.phone"/>"/>
                    </td>
                    <td>
                        <a class="btn btn-warning" href="deleteUser?user.id=<s:property value="id"/>">Delete User</a>
                    </td>
                    <td>
                        <input class="btn btn-info" type="submit" value="Update User"/>
                    </td>
                </form>
            </tr>
        </s:iterator>
</table>
</body>
</html>
