<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Management System</title>

</head>
<body ng-app="myApp" ng-controller="myController">

	<div>
		
		Select By Projects <select ng-model="projName" ng-change="fetchAllResources(projName)" data-ng-options="ProjectTable.proj_name for ProjectTable in projects"></select>
		
		Select By Roles   <select ng-model="selectedName" ng-options=" RoleTable.role for RoleTable in roles"></select>
	
	<br/><br/>
	
	<table border="1">
		<thead>
			<tr>				
				<th>Employee Id</th>
                <th>Department</th>
                <th>Designation</th>
                <th>Name</th>
                <th>Billing</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Role</th>
                <th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="u in resources">
				<td><span ng-bind="u[0]"></span></td>
				<td><span ng-bind="u[1]"></span></td>
				<td><span ng-bind="u[2]"></span></td>
				<td><span ng-bind="u[3]"></span></td>
				<td><span ng-bind="u[4]"></span></td>
				<td><span ng-bind="u[5]"></span></td>
				<td><span ng-bind="u[6]"></span></td>
				<td><span ng-bind="u[7]"></span></td>
				<td><a href="release.jsp">Release</td>
			</tr>
		</tbody>
	</table>


	</div>

</body>

<script>

'use strict'

var app = angular.module('myApp', []);

app.controller('myController',['$scope','EmployeeService',function($scope,EmployeeService) 
  {
	$scope.projects=[];
	$scope.roles=[];
	$scope.resources=[];

	fetchAllProjects();
	
	fetchAllRoles();
	
	function fetchAllProjects()
	{
	    	alert("In Fetch Employee Function"); 
	        EmployeeService.fetchAllProjects()
	            .then(	            	
	            function(d) {
	              $scope.projects = d;
	            },
	            function(errResponse)
	            {
	                alert('Error while fetching Users');
	            }
	        );	   
	}
	
	
	$scope.fetchAllResources = function() 
	{
	    	EmployeeService.fetchAllResources()
	            .then(	            	
	            function(d) {
	              $scope.resources = d;
	            },
	            function(errResponse)
	            {
	                alert('Error while fetching Users');
	            }
	        );	   
	}
	
	function fetchAllRoles()
	{
	    	alert("In Fetch Employee Function"); 
	        EmployeeService.fetchAllRoles()
	            .then(	            	
	            function(d) {
	              $scope.roles = d;
	            },
	            function(errResponse)
	            {
	                alert('Error while fetching Users');
	            }
	        );	   
	}
	
	$scope.releaseResource = function() 
	{
	    	alert("In Fetch Employee Function"); 
	        EmployeeService.releaseResource()
	            .then(	            	
	            function(d) {
	              $scope.projects = d;
	            },
	            function(errResponse)
	            {
	                alert('Error while fetching Users');
	            }
	        );	   
	}
		
}]);


angular.module('myApp').service('EmployeeService', ['$http', '$q', function($http, $q)
{

	var REST_SERVICE_URI1 = 'http://localhost:8080/ResourceManagement/projects/';
	
	var REST_SERVICE_URI2 = 'http://localhost:8080/ResourceManagement/roles/';
	
	var REST_SERVICE_URI3 = 'http://localhost:8080/ResourceManagement/resources/';

	this.fetchAllProjects= function () 
	{
		alert(REST_SERVICE_URI1);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI1)
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

	this.fetchAllRoles= function () 
	{
		alert(REST_SERVICE_URI2);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI2)
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
	
	this.fetchAllResources= function ()
	{
		alert(REST_SERVICE_URI3);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI3)
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
	
	
	this.releaseResource = function () 
	{
		alert(REST_SERVICE_URI1);
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI3)
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

}]);
 
 </script>
</html>