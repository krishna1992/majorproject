<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="myController">

	<div>
		<form>
			Enter username : <input type="text" ng-model="employee.username"><br/><br/> 
			Enter Password : <input type="text" ng-model="employee.password"><br/><br/>
			<button ng-click="loginEmployee()">Login</button>
			{{msg}}
		</form>
	</div>
	<br/><br/>
	
	<div ng-bind="msg"></div>
	
 	<table border="1">
		<thead>
			<tr>
				<th>Roll NO</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Marks</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="u in students">
				<td><span ng-bind="u.rollno"></span></td>
				<td><span ng-bind="u.firstname"></span></td>
				<td><span ng-bind="u.lastname"></span></td>
				<td><span ng-bind="u.city"></span></td>
				<td><span ng-bind="u.marks"></span></td>
			</tr>
		</tbody>
	</table>
{{students}}
</body>

<script>

'use strict'

var app = angular.module('myApp', []);

app.controller('myController',['$scope','UserService',function($scope,UserService) 
  {
	$scope.employee= {username:'',password:''};
	$scope.students=[];
	
	
	function fetchId()
	{
	    	alert("In Fetch Students Id 1"); 
	        UserService.fetchId()
	            .then(	            	
	            function(d) {
	                alert('Redirecting Manager');
	               window.location.href = "http://localhost:8080/ResourceManagement/AdminHome.jsp";	
	              $scope.students = d;
	         
	      
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	            }
	        );	   
	}
	
	//loginEmployee1();
	
	function loginEmployee1()
	{
	    	alert("In login employee Function 1"); 
	        UserService.loginEmployee1()
	            .then(	            	
	            function(d) {
	              $scope.msg = d;
	              
	            },
	            function(errResponse){
	                console.error('Error while logining Users');
	            }
	        );	   
	}
	
	
	$scope.loginEmployee= function()
	    {
		  alert("IN login Employee Function 2");
	    	UserService.loginEmployee($scope.employee).then(fetchId,function(errorMsg)
	    	{
	    		console.error('Failed to login');
	    	});
	    }
}]);


angular.module('myApp').service('UserService', ['$http', '$q', function($http, $q)
{

	var REST_SERVICE_URI = 'http://localhost:8080/ResourceManagement/login/';

	var REST_SERVICE_URI1 = 'http://localhost:8080/ResourceManagement/loginSuccess/';
	
/*	this.fetchAllEmployee= function () 
	{
		alert(REST_SERVICE_URI);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(
				function (response) 
				{
					deferred.resolve(response.data);
				},
				function(errResponse)
				{
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
*/
	this.loginEmployee = function (employee)
	{
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI,employee)
		.then(
				function(response) 
				{
					deferred.resolve(response.data);
					
				},
				function(reason) 
				{
					console.error("Error while login ");
					deferred.reject(reason);
		
				});
		
		return deferred.promise;
	}
	
	this.fetchId = function ()
	{
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI1)
		.then(
				function(response) 
				{
					deferred.resolve(response.data);
					
				},
				function(reason) 
				{
					console.error("Error while login ");
					deferred.reject(reason);
		
				});
		
		return deferred.promise;
	}
	
	
	
}]);
 
 </script>
</html>