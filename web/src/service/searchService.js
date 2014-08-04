
$app = angular.module("app.service", []);

$app.factory("searchFactory", ['$http', function($http) {
        return{
            getSchools: function() {
                return $http({method: 'GET', url: urlService + '/escolas'}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            },
            getProfessores: function() {
                return $http({method: 'GET', url: 'http://localhost:8080/Professor/webresources/professores'}).
                        then(function(result) {
                            console.log(result);
                            return result.data;
                        },
                                function(data) {
                                    console.log("error");
                                    console.log(data);
                                });

            }
        };
    }]);

