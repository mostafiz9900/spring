var myApp=angular.module("myApp",[]);
myApp.controller("myController",function($scope){
console.log("sfsfsfsf");

$scope.newUser={};
$scope.clickedUser={};

$scope.users=[
	{username:"mostafiz", fullName:"Md mostafiz", email:"mostafiz@gmail.com"},
	{username:"mostafiz", fullName:"Md mostafiz", email:"mostafiz@gmail.com"},
	{username:"mostafiz", fullName:"Md mostafiz", email:"mostafiz@gmail.com"}

];

$scope.saveUser = function(){
	
	$scope.users.push($scope.newUser);
	$scope.newUser={};
};

$scope.selectUser = function(user){
	console.log(user);
	$scope.clickedUser=user;
};
$scope.updateUser=function(){

};
$scope.deleteUser=function(){
	$scope.users.splice($scope.users.indexOf($scope.clickedUser), 1);
};
});