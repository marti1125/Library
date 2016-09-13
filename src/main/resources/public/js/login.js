$(document).ready(function(){
  
  $("#signin").click(function(){
    $(".alert-warning, .alert-danger").addClass("hide");
    var username = $("#username").val();
    var password = $("#password").val();
    $.post("/secure", {username:username, password:password}, function(response){
      var jsonResponse = JSON.parse(response);
      if(jsonResponse.type !== "ok"){
        $("#" + jsonResponse.type + "alert").removeClass("hide");
        $("#" + jsonResponse.type + "message").html(jsonResponse.message);
      } else {
        window.location.replace("/");
      }
    });
  });
  
  $(".timesclose").click(function(){
      $(this).parent().addClass("hide");
  });
  
});