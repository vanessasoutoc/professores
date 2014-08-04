$app = angular.module("app", ['ngRoute', 'ngResource']);
var urlService = "http://localhost:8080/Professor/webresources";
//var urlServiceEscola = "http://localhost:8080/Escola/webresources/";

$app.config(function($routeProvider) {

    $routeProvider

            .when('/', {
                controller: 'professorCtrl',
                templateUrl: 'home.html'
            })
            .when('/addProfessores', {
                controller: 'professorCtrl',
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

$app.service('selectManyFunction', function() {
    this.add = function(obj, listSelect, e) {
        this.returnValue = {
            isNotExist: true,
            list: [],
            indexRemove: ""
        };
        console.log(obj);
        console.log(listSelect);
        for (var i = 0; i < listSelect.length; i++) {
            if (obj === listSelect[i]) {
                this.returnValue.isNotExist = false;
                this.returnValue.indexRemove = i;
            }
        }
        if (this.returnValue.isNotExist) {
            listSelect.push(obj);
            this.returnValue.list = listSelect;
            $(e).addClass("active");
        } else {
            listSelect.splice(this.returnValue.indexRemove, 1);
            this.returnValue.list = listSelect;
            $(e).removeClass("active");
        }

        return this.returnValue;
    };
});


