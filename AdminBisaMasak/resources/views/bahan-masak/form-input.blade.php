<form action="" class="flex flex-col gap-4 p-5" method="post" enctype="multipart/form-data">
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Bahan Masak</label>
        <input type="text" id="input-name"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama bahan masak">
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Bahan Masak</label>
        <textarea id="textarea-label"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..."></textarea>
    </div>
    <!-- Input Nutrition -->
    <div class="flex flex-col gap-2" id="textInputContainerNutrition">
        <label for="input-ingredient" class="block text-sm font-medium mb-2 w-full">Kandungan Gizi</label>
        <div class="flex flex-wrap gap-2">
            <div class="flex-2">
                <label for="input-ingredient" class="block text-sm font-medium mb-2">Nutrisi</label>
                <input type="text" id="input-ingredient"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan kandungan nutrisi">
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                <input type="text" id="input-amount"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah">
            </div>
            <div class="flex-1">
                <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                <div class="w-full px-4 border border-cinnabar rounded-lg">
                    <select id="hs-select-label"
                        class="py-3 px-4 block w-full text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="">Pilih Satuan</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <div class="flex gap-2 w-1/2">
        <button type="button" id="btnAddNutrition"
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path
                    d="M224,128a8,8,0,0,1-8,8H136v80a8,8,0,0,1-16,0V136H40a8,8,0,0,1,0-16h80V40a8,8,0,0,1,16,0v80h80A8,8,0,0,1,224,128Z">
                </path>
            </svg>
            Tambah Input
        </button>
        <button type="button" id="btnRemoveNutrition"
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            style="display: none;">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path d="M224,128a8,8,0,0,1-8,8H40a8,8,0,0,1,0-16H216A8,8,0,0,1,224,128Z"></path>
            </svg>
            Hapus Input
        </button>
    </div>
    <!-- Upload Image -->
    <div class="w-full">
        <label for="input-image" class="block text-sm font-medium mb-2">Gambar Bahan Masak</label>
        <input type="file" name="file-input" id="input-image"
            class="block w-full border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-blue-500 focus:ring-blue-500 disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Tambah
        </button>
    </div>
</form>