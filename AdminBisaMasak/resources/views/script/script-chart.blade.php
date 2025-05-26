<script>
    document.addEventListener('DOMContentLoaded', function() {
        fetch('{{ url("/api/stats/konten-resep") }}')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                renderChart(data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                document.getElementById('chart').closest('.chart-container').innerHTML =
                    '<div class="text-red-500 p-4">Gagal memuat data statistik</div>';
            });

        function renderChart(apiData) {
            const ctx = document.getElementById('chart').getContext('2d');

            if (window.resepChart instanceof Chart) {
                window.resepChart.destroy();
            }

            const labels = apiData.map(item => item.month);

            const statusColors = {
                'Draf': '#FBBF24',
                'Terunggah': '#7BF1A8',
                'Terblokir': '#EF4444'
            };

            const datasets = Object.keys(apiData[0])
                .filter(key => key !== 'month')
                .map(status => ({
                    label: status,
                    data: apiData.map(item => item[status]),
                    borderColor: statusColors[status] || '#999',
                    backgroundColor: (statusColors[status] || '#999') + '33',
                    borderWidth: 2,
                    tension: 0.3,
                    fill: false,
                    pointBackgroundColor: statusColors[status] || '#999',
                    pointRadius: 5,
                    pointHoverRadius: 7,
                    pointHitRadius: 10
                }));

            window.resepChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels,
                    datasets
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    plugins: {
                        legend: {
                            position: 'top',
                            labels: {
                                usePointStyle: true,
                                padding: 20
                            }
                        },
                        tooltip: {
                            mode: 'index',
                            intersect: false,
                            callbacks: {
                                label: function(context) {
                                    return `${context.dataset.label}: ${context.parsed.y} resep`;
                                }
                            }
                        }
                    },
                    scales: {
                        y: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Jumlah Resep',
                                padding: {
                                    top: 10,
                                    bottom: 10
                                }
                            },
                            ticks: {
                                precision: 0,
                                stepSize: 1
                            },
                            grid: {
                                drawBorder: false
                            }
                        },
                        x: {
                            title: {
                                display: true,
                                text: 'Bulan',
                                padding: {
                                    top: 10,
                                    bottom: 10
                                }
                            },
                            grid: {
                                display: false
                            }
                        }
                    },
                    interaction: {
                        mode: 'nearest',
                        axis: 'x',
                        intersect: false
                    }
                }
            });

            window.addEventListener('resize', () => {
                window.resepChart.resize();
            });
        }
    });
</script>