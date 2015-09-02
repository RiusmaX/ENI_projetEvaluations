<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/adapters/standalone-framework.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>

</head>
<body>
	<h2>Résultats</h2>
	<h4>Test #01 - JEE Avancé</h4>
	<div id="graphique" class="col-md-5">
		<p><u>Graphique</u></p>
		<div id="graphPie" style="width:100%; height:400px;"></div>
		<div id="graphColumn" style="width:100%; height:400px;"></div>
		
		<table id="datatable" class="hidden">
			<thead>
				<tr>
					<th></th>
					<th>JEE</th>
					<th>JEE Avancé</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>Initiation</th>
					<td>13</td>
					<td>10</td>
				</tr>
				<tr>
					<th>Base de données</th>
					<td>13</td>
					<td>9</td>
				</tr>
				
			</tbody>
		</table>
	</div>
	<div id="detail" class="col-md-7">
		<p><u>Détails des résultats</u></p>
		<div class="col-md-4">
			Résultat global : <strong>Acquis </strong></br></br>
			Note globale : <strong>42/50 </strong></br>
			<strong>84% </strong>de bonnes réponses </br>
		</div>
		<div class="col-md-3">
			Temps passé : 2h07 </br>
			Temps maximal : 3h00 </br>
			Nombre d'incident : 0 </br>
			Type de test : ECF </br>
		</div>
	</div>
	<div id="retourAccueil" class="col-md-12">
		<a href="Accueil.jsp" class="btn btn-primary" name="retourAccueil" id="btn-retour-resultat">Retour à l'accueil</a>
	</div>
	
	<script>
	$(function () { 
	    $('#graphPie').highcharts({
	        chart: {
	        	plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            type: 'pie'
	        },
	        title: {
	            text: 'Nombre de bonne réponse'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        },
	        series: [{
	            name: "Module JEE",
	            colorByPoint: true,
	            data: [{
	                name: "JEE",
	                y: 56.33
	            }, {
	                name: "JEE Avancé",
	                y: 24.03,
	                sliced: true,
	                selected: true
	            }]
	        }]
	    });
	});

	$(function () {
	    $('#graphColumn').highcharts({
	        data: {
	            table: 'datatable'
	        },
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'Détails du test'
	        },
	        yAxis: {
	            allowDecimals: false,
	            title: {
	                text: 'Points obtenus'
	            }
	        },
	        tooltip: {
	            formatter: function () {
	                return '<b>' + this.series.name + '</b><br/>' +
	                    this.point.y + ' ' + this.point.name.toLowerCase();
	            }
	        }
	    });
	});
	</script>
</body>
</html>