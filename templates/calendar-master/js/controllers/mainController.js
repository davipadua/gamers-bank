angular.module('App').controller('mainController', ['$scope', function($scope,uiCalendarConfig) {





    $scope.uiConfig = {
        calendar:{
            dayNames : ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
            dayNamesShort : ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"],
            monthNames : "Janeiro_Fevereiro_Março_Abril_Maio_Junho_Julho_Agosto_Setembro_Outubro_Novembro_Dezembro".split("_"),
            monthNamesShort : "jan_fev_mar_abr_mai_jun_jul_ago_set_out_nov_dez".split("_"),
            height: 450,
            editable: true,
            header:{
                left: 'month basicWeek basicDay',
                center: 'title',
                right: 'today prev,next'
            }
        }
    };





    $scope.eventSources = [{
        googleCalendarApiKey: 'AIzaSyDQla3vMpeSZmdLQTCRiw5KaTYC7Z5aG8k',
        url: "http://www.google.com/calendar/feeds/agendaempreendedora2015%40gmail.com/public/basic",
        currentTimezone: 'America/Sao_Paulo' // an option!
    }];
}]);