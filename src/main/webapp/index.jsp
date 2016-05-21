<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-2.2.3.min.js"
            integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <!-- bootstrap form helper -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/css/bootstrap-formhelpers.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/js/bootstrap-formhelpers.min.js"></script>

    <script type="text/javascript" src="js/validator.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            // format phone numbers for listing form
            $(".form-user-phone").mask("+9 (999) 999-9999");
            $(".modal-user-phone").mask("+9 (999) 999-9999");

            $("#sendButton").click(function(){
                $.get("");
            });

            $(".sendSms").click(function(){
                // TODO: find out a better way to replace this complicated select element sentence.
                var phone = $(this).parent().parent().find("td:eq(1)").find("input").val();
                $("#myModal").modal();
                $("#modalPhone").val(phone);
            });

        })
    </script>
</head>
<body>
<!--TODO: add a list user action.-->
<div id="saveUserContainer" class="form-group" style="width:60%; margin-top: 20px; margin-left: 20px">
    <form action="saveUser" method="post" data-toggle="validator" role="form">
        <div class="form-group row">
            <label for="name" class="col-sm-2 form-control-label">Name: </label>
            <div class="col-sm-10">
                <input id="name" class="form-control" data-error="User Name is required"
                       type="text" name="user.name" placeholder="User Name" required/>
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="form-group row">
            <label for="phone" class="col-sm-2 form-control-label">Phone: </label>
            <div class="col-sm-10">
                <input id="phone" class="form-control bfh-phone"
                       data-country="US" type="text" name="user.phone" placeholder="Phone Number" />
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-5">
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
            <td> Delete </td>
            <td> Update </td>
            <td> Send SMS </td>
        </tr>

        <s:iterator value="users" status="userStatus" var="user">
            <tr>
                <form action="saveUser" method="POST">
                    <td>
                        <input type="hidden" name="user.id" value="<s:property value="#user.id"/>"/>
                        <input class="form-control" type="text" name="user.name" value="<s:property value="#user.name" />"/>
                    </td>
                    <td>
                        <input class="form-control form-user-phone"
                               data-country="US" type="text" name="user.phone" value="<s:property value="#user.phone"/>"/>
                    </td>
                    <td>
                        <a class="btn btn-warning" href="deleteUser?user.id=<s:property value="id"/>">Delete User</a>
                    </td>
                    <td>
                        <input class="btn btn-info" type="submit" value="Update User"/>
                    </td>
                    <td>
                        <!-- Trigger the modal with a button -->
                        <button type="button" class="btn btn-info sendSms">Send SMS</button>
                    </td>
                </form>
            </tr>
        </s:iterator>

    <!--TODO: looks ugly now. Make it looks better. -->
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Send SMS</h4>
                </div>
                <form role="form" action="sendSms" method="POST">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="modalPhone" class="col-sm-2 form-control-label">Send To: </label>
                            <div class="col-sm-10">
                                <input id="modalPhone" name="to" class="form-control bfh-phone modal-user-phone"
                                       data-country="US" type="text" placeholder="Phone Number"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="message" class="col-sm-2 form-control-label">Content: </label>
                            <div class="col-sm-10">
                                <textarea id="message" name="message" class="form-control modal-message"
                                          data-country="US" type="text" placeholder="Enter message"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input name="sendButton" type="submit" class="btn btn-info" value="Send"/>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</table>
</body>
</html>
