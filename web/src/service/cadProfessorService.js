
$app = angular.module("app.cadService", []);

$app.factory("cadProfessorFactory", ['$http', function($http) {
        return{
            saveEscola: function(escola) {
                return $http
                        ({method: 'POST',
                            url: urlService + 'professores/salvar', data: escola}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            }
        }
    }]);

