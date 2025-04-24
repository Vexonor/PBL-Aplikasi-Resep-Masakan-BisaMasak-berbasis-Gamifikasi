import './bootstrap';
import 'preline';

document.getElementById('dropdownButton').addEventListener('click', function (event) {
    const dropdownMenu = document.getElementById('dropdownMenu');

    dropdownMenu.classList.toggle('hidden');
    dropdownMenu.classList.toggle('opacity-0');
    dropdownMenu.classList.toggle('translate-y-12');

    if (!dropdownMenu.classList.contains('hidden')) {
        setTimeout(() => {
            dropdownMenu.classList.remove('opacity-0');
            dropdownMenu.classList.remove('translate-y-12');
        }, 300);
    } else {
        dropdownMenu.classList.add('opacity-0');
        dropdownMenu.classList.add('translate-y-12');
    }

    event.stopPropagation();
});

document.addEventListener('click', function (event) {
    const dropdownMenu = document.getElementById('dropdownMenu');
    const dropdownButton = document.getElementById('dropdownButton');

    if (!dropdownMenu.contains(event.target) && !dropdownButton.contains(event.target)) {
        dropdownMenu.classList.add('hidden');
        dropdownMenu.classList.add('opacity-0');
        dropdownMenu.classList.add('translate-y-12');
    }
});


