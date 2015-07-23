var app = angular.module('socialStat', []);

app.service('scrollService', ['$anchorScroll', '$location',
    function($anchorScroll, $location) {
        this.goTo = function(id, timeout) {
            setTimeout(function(){$location.hash(id); $anchorScroll();}, timeout);
        }
    }]);

app.controller('UsersController', function ($scope, $http, $window, scrollService) {
    $scope.isUsersShow = false;

    $scope.refresh = function() {
       $window.location.reload();
    };

    $scope.getUsers  = function(request) {
        $scope.isUserShow = true;
    $http.get(request).success(function(response){
        $scope.users = response;
        scrollService.goTo('scroll', 1000);
    })};

    $scope.scrollTop = function() {
        scrollService.goTo('header', 0);
    }
});

