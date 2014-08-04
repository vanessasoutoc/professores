$app = angular.module("app", ['ngRoute', 'app.service', 'app.cadService']);
var urlService = "http://localhost:8080/Professor/webresources/";
//var urlServiceEscola = "http://localhost:8080/Escola/webresources/";

$app.config(function($routeProvider) {

    $routeProvider

            .when('/', {
                controller: 'professorCtrl',
                templateUrl: 'home.html'
            })
            .when('/addProfessores', {
                controller: 'cadProfessorCtrl',
                templateUrl: 'addProfessores.html'
            })
            .when('/searchProfessores', {
                controller: 'searchProfessorCtrl',
                templateUrl: 'searchProfessores.html'
            })
            .otherwise({
                redirectTo: '/'
            });

});