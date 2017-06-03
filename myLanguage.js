<!doctype <!DOCTYPE html>
<html lang="en" ng-app="myLanguageApp">
<head>
<title>Angular JS Welcomoe!</title>


<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"> </script>

</head>
<body>

<div ng-controller = "languages">
Select your Favourite Language 
<button ng-click= "php()">php</button>
<button ng-click= "javascript()">Javascript</button>
<button ng-click= "cplus()">C++</button>
<button ng-click= "java()">Java</button>

<p>You have selected: {{myFavLanguage}}</p>

</div>


<script>
var application = angular.module('myLanguageApp', []);
application.controller("languages", function($scope) {
$scope.myFavLanguage = "none";


$scope.php = function(){
$scope.myFavLanguage = "Php";
};

$scope.javascript = function(){
$scope.myFavLanguage = "Javascript";
};

$scope.java = function(){
$scope.myFavLanguage = "Java";
};

$scope.cplus = function(){
$scope.myFavLanguage = "C++";
};

});


</script>




</body>
</html>
