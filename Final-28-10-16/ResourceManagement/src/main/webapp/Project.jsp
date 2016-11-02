<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Details insert</title>
</head>
<body ng-app="myAppProject" ng-controller="myController">

	<div>
		<table>
		<form>
			<tr><td>Project Id</td><td><input type="text" ng-model="project.Proj_id"></td></tr> 
			<tr><td>Project Name</td><td><input type="text" ng-model="project.Proj_name"></td></tr>
			<tr><td>Project Status</td><td><input type="text" ng-model="project.Proj_status"></td></tr>
			<tr><td>Project Start Date</td><td><input type="date" ng-model="project.Proj_start_date"></td></tr>
			<tr><td>Project End Date</td><td><input type="date" ng-model="project.Proj_end_date"></td></tr>
			<tr><td><button ng-click="createProject()">Create Project</button></td></tr>
		</form>
	</div>
	<br/><br/>
	

<script>

'use strict'

var app = angular.module('myAppProject', []);

app.controller('myController',['$scope','EmployeeService',function($scope,EmployeeService) 
  {
	$scope.employee= {empid:null,department:'',desigination:'',ename:''};
	$scope.employees=[];
	
	$scope.createEmployee= function()
	    {
		  alert("IN Create Employee Function");
	    	EmployeeService.createEmployee($scope.employee).then(fetchAllEmployee,function(errorMsg)
	    	{
	    		console.error('Failed to create');
	    	});
	    }
}]);


angular.module('myApp').service('EmployeeService', ['$http', '$q', function($http, $q)
{

	var REST_SERVICE_URI = 'http://localhost:8080/ResourceManagement/employees/';


	this.createEmployee = function (employee)
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
					console.error("Error while creating user");
					deferred.reject(reason);
		
				});
		
		return deferred.promise;
	}
}]);
 
 </script>	



</body>
</html>