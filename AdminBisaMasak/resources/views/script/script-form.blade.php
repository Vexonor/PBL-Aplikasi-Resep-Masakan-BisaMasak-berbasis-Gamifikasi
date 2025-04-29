<script>
// Duplicate Input for Ingredient
document.addEventListener("DOMContentLoaded", function() {
    const container = document.getElementById('textInputContainerIngredient');
    const btnAdd = document.getElementById('btnAddIngredient');
    const btnRemove = document.getElementById('btnRemoveIngredient');
    let counter = 1;

    function toggleRemoveButton() {
        const groups = document.querySelectorAll('.ingredient-group');
        btnRemove.style.display = groups.length > 1 ? 'inline-flex' : 'none';
    }

    function updateLabelVisibility() {
        const groups = document.querySelectorAll('.ingredient-group');
        if (groups.length > 1) {
            document.querySelector('label[for="input-ingredient"]').style.display = 'none';
        } else {
            document.querySelector('label[for="input-ingredient"]').style.display = 'block';
        }
    }

    btnAdd.addEventListener('click', function() {
        counter++;
        const newGroup = container.cloneNode(true);
        newGroup.id = 'ingredient-group-' + counter;

        const labels = newGroup.querySelectorAll('label');
        labels.forEach(label => label.remove());

        const inputs = newGroup.querySelectorAll('input, select');
        inputs.forEach(input => {
            const originalId = input.id.replace(/-[0-9]+$/,
                '');
            const newId = originalId + '-' + counter;
            input.id = newId;
            input.value = '';

            if (input.previousElementSibling && input.previousElementSibling.tagName ===
                'LABEL') {
                input.previousElementSibling.setAttribute('for', newId);
            }

            if (input.tagName === 'SELECT') {
                const options = input.options;
                for (let i = 0; i < options.length; i++) {
                    if (options[i].hasAttribute('selected') && options[i].hasAttribute(
                            'disabled')) {
                        input.selectedIndex = i;
                        break;
                    }
                }
            }
        });

        const comboBoxes = newGroup.querySelectorAll('[data-hs-combo-box]');
        comboBoxes.forEach(box => {
            box.removeAttribute('data-hs-combo-box-initialized');
            const input = box.querySelector('[data-hs-combo-box-input]');
            if (input) {
                input.value = '';
                input.setAttribute('aria-expanded', 'false');
            }

            setTimeout(() => {
                if (typeof HSComboBox !== 'undefined') {
                    new HSComboBox(box).init();
                }
            }, 0);
        });

        container.parentNode.insertBefore(newGroup, container.nextSibling);
        toggleRemoveButton();
        updateLabelVisibility();
    });

    btnRemove.addEventListener('click', function() {
        const groups = document.querySelectorAll('.ingredient-group');
        if (groups.length > 1) {
            groups[groups.length - 1].remove();
            toggleRemoveButton();
            updateLabelVisibility();
        }
    });

    toggleRemoveButton();
    updateLabelVisibility();

    document.addEventListener('click', function(e) {
        const item = e.target.closest('[data-hs-combo-box-output-item]');
        if (item) {
            const comboBox = item.closest('[data-hs-combo-box]');
            const displayInput = comboBox.querySelector('[data-hs-combo-box-input]');
            const realInput = comboBox.parentElement.querySelector('input[type="hidden"]');

            const valueId = item.getAttribute('data-hs-combo-box-item-stored-data');
            const displayText = item.querySelector('[data-hs-combo-box-search-text]').textContent;

            displayInput.value = displayText;
            realInput.value = valueId;
        }
    });
});

// DUplicate Input for Nutrition
document.addEventListener("DOMContentLoaded", function() {
    const textInputContainer = document.getElementById('textInputContainerNutrition');
    const btnAddText = document.getElementById('btnAddNutrition');
    const btnRemove = document.getElementById('btnRemoveNutrition');

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

    btnAddText.addEventListener('click', function() {
        const textInputWrapper = document.createElement('div');
        textInputWrapper.classList.add('flex', 'flex-wrap', 'gap-2');

        // Array gizi dan satuan
        const giziList = [
            'Energi', 'Karbohidrat', 'Protein', 'Lemak', 'Serat', 'Gula',
            'Natrium', 'Kalsium', 'Zat Besi', 'Vitamin A', 'Vitamin B1',
            'Vitamin B2', 'Vitamin B3', 'Vitamin B6', 'Vitamin B12', 'Vitamin C',
            'Vitamin D', 'Vitamin E', 'Vitamin K', 'Kolesterol'
        ];

        const satuanList = [
            'mg', 'g', 'µg', 'kcal', 'IU', 'ml', 'L', '%'
        ];

        const giziOptions = giziList.map(gizi => `<option value="${gizi}">${gizi}</option>`).join('');

        const satuanOptions = satuanList.map(satuan => `<option value="${satuan}">${satuan}</option>`)
            .join('');

        // Mengisi HTML dengan opsi
        textInputWrapper.innerHTML = `
            <div class="flex-2">
                <div class="w-full px-2 border border-cinnabar rounded-lg">
                    <select name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="" disabled>Pilih Nutrisi</option>
                        ${giziOptions}
                    </select>
                </div>
            </div>
            <div class="flex-1">
                <input type="text" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah">
            </div>
            <div class="flex-1">
                <div class="w-full px-2 border border-cinnabar rounded-lg">
                    <select name="satuan[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="" disabled>Pilih Satuan</option>
                        ${satuanOptions}
                    </select>
                </div>
            </div>
        `;

        textInputContainer.appendChild(textInputWrapper);
        toggleRemoveButton();
    });

    btnRemove.addEventListener('click', function() {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            wrappers[wrappers.length - 1].remove();
        }
        toggleRemoveButton();
    });
});

// Duplicate Input for Step
document.addEventListener("DOMContentLoaded", function() {
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

    btnAddText.addEventListener('click', function() {
        const nextNumber = getNextStepNumber();

        const textInputWrapper = document.createElement('div');
        textInputWrapper.classList.add('flex', 'flex-wrap', 'gap-2', 'step-input');

        textInputWrapper.innerHTML = `
               <div class="flex-1">
                <input type="text" id="input-number"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan kandungan nutrisi" value="${nextNumber}" name="nomor_langkah[]" readonly>
            </div>
            <div class="flex-4">
                <textarea id="textarea-description" name="deskripsi_langkah[]"
                    class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    rows="1" placeholder="Ketikkan deskripsi disini..." required></textarea>
            </div>
            <div class="flex-4">
                <input type="file" name="gambar_langkah[]" id="input-image-step"
                    class="block w-full ps-4 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
            </div>
        `;

        textInputContainer.appendChild(textInputWrapper);
        toggleRemoveButton();
    });

    btnRemove.addEventListener('click', function() {
        const wrappers = textInputContainer.querySelectorAll('.flex.flex-wrap.gap-2');
        if (wrappers.length > 1) {
            wrappers[wrappers.length - 1].remove();
        }
        toggleRemoveButton();
    });
});

// Handle Send Data from nama_bahan to id_bahan
document.addEventListener('DOMContentLoaded', function() {
    const comboBox = document.querySelector('[data-hs-combo-box]');
    const displayInput = document.getElementById('display-input-ingredient');
    const realInput = document.getElementById('real-input-ingredient');

    comboBox.addEventListener('click', function(e) {
        const item = e.target.closest('[data-hs-combo-box-output-item]');
        if (item) {
            const valueId = item.getAttribute('data-hs-combo-box-item-stored-data');
            const displayText = item.querySelector('[data-hs-combo-box-search-text]')
                .textContent;

            displayInput.value = displayText;
            realInput.value = valueId;
        }
    });

    document.getElementById('ingredient-form').addEventListener('submit', function(e) {
        const allRealInputs = document.querySelectorAll('input[name="id_bahan[]"]');
        let isValid = true;

        allRealInputs.forEach(input => {
            if (!input.value) {
                isValid = false;
                // Highlight input yang kosong
                input.closest('.ingredient-group').style.border = '1px solid red';
            }
        });

        if (!isValid) {
            e.preventDefault();
            alert('Silakan pilih bahan masak untuk semua input');
        }
    });
});
</script>