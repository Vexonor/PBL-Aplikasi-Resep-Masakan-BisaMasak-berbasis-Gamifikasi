import './bootstrap';
import 'preline';

// Dropdown
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

// Duplicate Input For Ingredient
document.addEventListener("DOMContentLoaded", function () {
    const textInputContainer = document.getElementById('textInputContainerIngredient');
    const btnAddText = document.getElementById('btnAddIngredient');
    const btnRemove = document.getElementById('btnRemoveIngredient');

    // Fungsi untuk toggle visibilitas tombol hapus
    function toggleRemoveButton() {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            btnRemove.style.display = 'inline-flex';
        } else {
            btnRemove.style.display = 'none';
        }
    }

    // Sembunyikan tombol hapus saat halaman dimuat
    toggleRemoveButton();

    btnAddText.addEventListener('click', function () {
        const textInputWrapper = document.createElement('div');
        textInputWrapper.classList.add('flex', 'flex-wrap', 'gap-2');

        textInputWrapper.innerHTML = `
    <div class="flex-2">
        <input type="text"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none"
            placeholder="Masukkan nama bahan" name="nama_bahan[]">
    </div>
    <div class="flex-1">
        <input type="text"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none"
            placeholder="Masukkan jumlah" name="jumlah[]">
    </div>
    <div class="flex-1">
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select
                class="py-3 px-4 block w-full text-sm focus:outline-none"
                name="satuan[]">
                <option selected="">Pilih Satuan</option>
                <option>gram</option>
                <option>ml</option>
                <option>buah</option>
            </select>
        </div>
    </div>
        `;

        textInputContainer.appendChild(textInputWrapper);
        toggleRemoveButton();
    });

    btnRemove.addEventListener('click', function () {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            wrappers[wrappers.length - 1].remove();
        }
        toggleRemoveButton();
    });
});

// Duplicate Input For Nutrition
document.addEventListener("DOMContentLoaded", function () {
    const textInputContainer = document.getElementById('textInputContainerNutrition');
    const btnAddText = document.getElementById('btnAddNutrition');
    const btnRemove = document.getElementById('btnRemoveNutrition');

    // Fungsi untuk toggle visibilitas tombol hapus
    function toggleRemoveButton() {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            btnRemove.style.display = 'inline-flex';
        } else {
            btnRemove.style.display = 'none';
        }
    }

    // Sembunyikan tombol hapus saat halaman dimuat
    toggleRemoveButton();

    btnAddText.addEventListener('click', function () {
        const textInputWrapper = document.createElement('div');
        textInputWrapper.classList.add('flex', 'flex-wrap', 'gap-2');

        textInputWrapper.innerHTML = `
    <div class="flex-2">
        <input type="text"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none"
            placeholder="Masukkan nama bahan" name="nama_bahan[]">
    </div>
    <div class="flex-1">
        <input type="text"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none"
            placeholder="Masukkan jumlah" name="jumlah[]">
    </div>
    <div class="flex-1">
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select
                class="py-3 px-4 block w-full text-sm focus:outline-none"
                name="satuan[]">
                <option selected="">Pilih Satuan</option>
                <option>gram</option>
                <option>ml</option>
                <option>buah</option>
            </select>
        </div>
    </div>
        `;

        textInputContainer.appendChild(textInputWrapper);
        toggleRemoveButton();
    });

    btnRemove.addEventListener('click', function () {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            wrappers[wrappers.length - 1].remove();
        }
        toggleRemoveButton();
    });
});

// Duplicate Input Step
document.addEventListener("DOMContentLoaded", function () {
    const textInputContainer = document.getElementById('textInputContainerStep');
    const btnAddText = document.getElementById('btnAddStep');
    const btnRemove = document.getElementById('btnRemoveStep');

    function toggleRemoveButton() {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            btnRemove.style.display = 'inline-flex';
        } else {
            btnRemove.style.display = 'none';
        }
    }

    function getNextStepNumber() {
        const wrappers = textInputContainer.querySelectorAll('.step-input');
        return wrappers.length + 1;
    }

    toggleRemoveButton();

    btnAddText.addEventListener('click', function () {
        const nextNumber = getNextStepNumber();

        const textInputWrapper = document.createElement('div');
        textInputWrapper.classList.add('flex', 'flex-wrap', 'gap-2', 'step-input');

        textInputWrapper.innerHTML = `
                <div class="flex-1">
                    <input type="text" id="input-number"
                        class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                        placeholder="Masukkan kandungan nutrisi" value="${nextNumber}." readonly>
                </div>
                <div class="flex-4">
                    <textarea id="textarea-description"
                        class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                        rows="1" placeholder="Ketikkan deskripsi disini..."></textarea>
                </div>
                <div class="flex-4">
                    <input type="file" name="file-input" id="input-image-step"
                        class="block w-full border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-blue-500 focus:ring-blue-500 disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
                </div>
        `;

        textInputContainer.appendChild(textInputWrapper);
        toggleRemoveButton();
    });

    btnRemove.addEventListener('click', function () {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            wrappers[wrappers.length - 1].remove();
        }
        toggleRemoveButton();
    });
});