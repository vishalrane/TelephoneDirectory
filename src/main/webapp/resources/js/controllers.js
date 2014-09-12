var controller = angular.module("controllers", []);
controller.controller(
		"navController",
		function($scope, $location) {
			$scope.navClass = function (page) {
		        var currentRoute = $location.path().substring(1) || 'search';
		        return page === currentRoute ? 'active' : '';
		    }; 
		});

controller.controller(
		"searchController",
		function($scope, $http, $routeParams) {
			$scope.questionNo = 1;			
			$http.get('data/questions.json').success(function (questions){
				var questionNo = Math.floor((Math.random() * 2) + 0);
			    $scope.question = questions[questionNo];
			  }); 
			$scope.selectAnswer = function (question, choice) {
		       console.log(question, choice)
		    }; 
		});




























/*

$scope.helloTo = {};
$scope.helloTo.title = "World, AngularJS";
$scope.helloTo.items = [ {
	text : "one"
}, {
	text : "two"
}, {
	text : "three"
} ];
$scope.helloTo.myObject = {
	var1 : "val1",
	var2 : "val3",
	var3 : "val3"
};
$scope.itemFilter = function(item) {
	if (item.text == "two")
		return false;
	return true;
}

$scope.sortField = "text";
$scope.reverse = true;
$scope.helloTo.doClick = function() {
	alert("clicked");
}

$scope.helloTo.doClick = function(item, event) {
	console.log(item)
	alert("clicked: " + item.text + " @ " + event.clientX + ": "
			+ event.clientY);
}
*/