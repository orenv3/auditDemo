angular.module("crudApp").controller("GeneralController", GeneralController);

function GeneralController($scope, PullRequest, $http, $window){

$scope.pullRequestObj=null;
$scope.pullRequestList=[];
$scope.pullRequestId=0;
$scope.basicUrl = "C:\\pullRequest_screenshots\\";
$scope.url="";



$scope.getPullRequestList = function (){
$http.get("http://localhost:8080/api/pullRequest/getPullRequestList").then(function (response){
	$scope.pullRequestList=response.data;
})
 
}

$scope.getPullRequestDetailes = function (){
	$http.get("http://localhost:8080/api/pullRequest/getPullRequest/"+$scope.pullRequestId).then(function (response){	
		$scope.pullRequestObj=response.data.pullRequest;	
	})
	 
	}

	$scope.getPicture = function(){
		$scope.url= "file:///"+$scope.basicUrl + $scope.pullRequestObj.picture.pictureName + ".png";
		//$window.open($scope.url,'_blank');	
	}



}