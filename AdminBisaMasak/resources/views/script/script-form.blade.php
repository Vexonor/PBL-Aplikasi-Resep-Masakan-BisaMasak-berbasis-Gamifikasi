<script>
    // Dropdown
    document.getElementById('dropdownButton').addEventListener('click', function(event) {
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

    document.addEventListener('click', function(event) {
        const dropdownMenu = document.getElementById('dropdownMenu');
        const dropdownButton = document.getElementById('dropdownButton');

        if (!dropdownMenu.contains(event.target) && !dropdownButton.contains(event.target)) {
            dropdownMenu.classList.add('hidden');
            dropdownMenu.classList.add('opacity-0');
            dropdownMenu.classList.add('translate-y-12');
        }
    });

    // Duplicate Input for Ingredient
    document.addEventListener('DOMContentLoaded', function() {
        const btnAdd = document.getElementById('btnAddIngredient');
        const btnRemove = document.getElementById('btnRemoveIngredient');
        const container = document.querySelector('.ingredients-container .flex-col'); // Container yang benar
        const ingredientGroups = container.querySelectorAll('.ingredient-group');

        // Ambil group pertama sebagai template
        const originalGroup = ingredientGroups[0].querySelector('.flex-wrap');

        // Fungsi untuk mengupdate ID bahan
        function updateIdBahan(inputElement) {
            const bahanValue = inputElement.value;
            const options = document.getElementById('ingredient').options;
            const idField = inputElement.closest('.flex-wrap').querySelector('input[name="id_bahan[]"]');

            idField.value = '';

            for (let option of options) {
                if (option.value === bahanValue) {
                    idField.value = option.getAttribute('data-id');
                    break;
                }
            }
        }

        // Fungsi cek duplikat bahan
        function isDuplicate(bahanValue, excludeGroup) {
            const inputs = container.querySelectorAll('.flex-wrap .input-bahan-field');
            for (let input of inputs) {
                if (input.closest('.flex-wrap') !== excludeGroup && input.value === bahanValue) {
                    return true;
                }
            }
            return false;
        }

        // Event Delegation untuk input bahan
        container.addEventListener('input', function(e) {
            if (e.target.classList.contains('input-bahan-field')) {
                updateIdBahan(e.target);

                if (isDuplicate(e.target.value, e.target.closest('.flex-wrap'))) {
                    e.target.setCustomValidity('Bahan sudah ada!');
                    e.target.reportValidity();
                } else {
                    e.target.setCustomValidity('');
                }
            }
        });

        // Tombol Tambah Input
        btnAdd.addEventListener('click', function() {
            const groups = container.querySelectorAll('.flex-wrap');
            const lastGroup = groups[groups.length - 1];
            const lastBahanInput = lastGroup.querySelector('.input-bahan-field');

            if (!lastBahanInput.value.trim()) {
                alert('Harap isi nama bahan!');
                lastBahanInput.focus();
                return;
            }

            if (isDuplicate(lastBahanInput.value, lastGroup)) {
                alert('Bahan ini sudah ada!');
                lastBahanInput.focus();
                return;
            }

            // Buat div wrapper baru untuk group
            const newGroupWrapper = document.createElement('div');
            newGroupWrapper.className = 'w-full flex flex-col gap-2 ingredient-group';

            // Clone original group
            const newGroup = originalGroup.cloneNode(true);
            const newId = 'input-bahan-' + Date.now();

            // Reset nilai input
            const newBahanInput = newGroup.querySelector('.input-bahan-field');
            newBahanInput.id = newId;
            newBahanInput.value = '';
            newGroup.querySelector('input[name="id_bahan[]"]').value = '';
            newGroup.querySelector('[name="jumlah_bahan[]"]').value = '';
            newGroup.querySelector('[name="satuan_bahan[]"]').selectedIndex = 0;

            // Tambahkan ke wrapper
            newGroupWrapper.appendChild(newGroup);

            // Tambahkan ke container utama (setelah semua group)
            container.appendChild(newGroupWrapper);

            btnRemove.classList.remove('hidden');
            newBahanInput.focus();
        });

        // Tombol Hapus Input
        btnRemove.addEventListener('click', function() {
            const groups = container.querySelectorAll('.ingredient-group');
            if (groups.length > 1) {
                groups[groups.length - 1].remove();
                btnRemove.classList.toggle('hidden', groups.length === 2);
            }
        });

        // Inisialisasi untuk input yang sudah ada
        container.querySelectorAll('.input-bahan-field').forEach(input => {
            updateIdBahan(input);
        });
    });

    // Duplicate Input for Nutrition
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

            const giziOptions = giziList.map(gizi => `<option value="${gizi}">${gizi}</option>`)
                .join('');

            const satuanOptions = satuanList.map(satuan =>
                    `<option value="${satuan}">${satuan}</option>`)
                .join('');

            // Mengisi HTML dengan opsi
            textInputWrapper.innerHTML = `
            <div class="flex-2">
            <label for="input-nutrition" class="block text-sm font-medium mb-2">Nutrisi</label>
                <div class="w-full px-2 border border-cinnabar rounded-lg">
                    <select name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="" disabled>Pilih Nutrisi</option>
                        ${giziOptions}
                    </select>
                </div>
            </div>
            <div class="flex-1">
            <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                <input type="text" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah">
            </div>
            <div class="flex-1">
            <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
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
        document.getElementById('ingredient-form').addEventListener('submit', function(e) {
            const allRealInputs = document.querySelectorAll('input[name="id_bahan[]"]');
            let isValid = true;

            allRealInputs.forEach(input => {
                const parent = input.closest('.flex-2') || input.closest(
                    '.ingredient-group');
                if (parent) parent.style.border = '';

                if (!input.value.trim()) {
                    isValid = false;
                    if (parent) parent.style.border = '1px solid red';
                }
            });

            if (!isValid) {
                e.preventDefault();
                alert('Silakan pilih bahan masak untuk semua input');
            }
        });
    });
</script>