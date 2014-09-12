var quizApp = angular.module('quiz-app', [
  'controllers'
]);

quizApp.config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/add', {
				templateUrl : 'add.html',
				controller : 'quizController'
			}).when('/search', {
				templateUrl : 'search.html',
				controller : 'searchController'
			}).otherwise({
				redirectTo : '/search'
			});
		} ]);

