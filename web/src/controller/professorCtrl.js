$app.controller("professorCtrl", function($scope, $http, selectManyFunction) {
    //$scope.teste = "teste";
    $scope.escola = [];
    $scope.professorSalvar = {
        "especialidade": "",
        "nome": "",
        "escolas": $scope.escola
    }
    $http({method: 'GET', url: 'http://localhost:8080/Escolas/webresources/escolas'}).
            success(function(data, status, headers, config) {
                console.log(data);
                $scope.listaEscola = data;
            }).
            error(function(data, status, headers, config) {
                console.log("Erro");
            });

    $scope.selectEscolas = function(escola, e) {

        var isexit = false;
        var element = angular.element(e.target);
        var returnvalue = selectManyFunction.add(escola, $scope.escola, element);
        $scope.escola = returnvalue.list;
        //console.log(returnvalue);
    };

    $scope.salvar = function() {
        console.log($scope.professorSalvar);
        $http({method: 'POST',
            url: 'http://localhost:8080/Professor/webresources/professores/salva',
            data: $scope.professorSalvar
        }).
                success(function(data, status, headers, config) {
                    console.log(data);
                    $scope.listaEscola = data;
                    alert("Salvo com sucesso!");
                }).
                error(function(data, status, headers, config) {
                    console.log("Erro");
                });
    }


});


