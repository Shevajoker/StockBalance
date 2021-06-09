/**
 * 
 */
var ctx = document.getElementById('myChart').getContext('2d');
ctx.canvas.width = 200;

var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: labelsData,
        datasets: [{
            label: labelData,
            data: dataData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)' 
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
