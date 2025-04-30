import './bootstrap';
import 'preline';

// Loader
window.addEventListener('load', () => {
    setTimeout(() => {
        document.body.classList.add('loaded');
    }, 1000);
});

document.getElementById('input-ingredient').addEventListener('click', function () {
    document.getElementById('ingredient-list').classList.toggle('hidden');
});