$app.controller("searchProfessorCtrl", function($scope, $http) {

    $http({method: 'GET', url: 'http://localhost:8080/Professor/webresources/professores'}).
            success(function(data, status, headers, config) {
                console.log(data);
                $scope.listaProfessores = data;
            }).
            error(function(data, status, headers, config) {
                console.log("Erro");
            });
});