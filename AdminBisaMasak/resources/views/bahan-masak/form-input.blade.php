<form action="{{ route('bahan-masak.store') }}" class="flex flex-col gap-4 p-5" method="post"
    enctype="multipart/form-data">
    @csrf
    @method('POST')
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Bahan Masak</label>
        <input type="text" id="input-name" name="nama_bahan"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama bahan masak" required>
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Bahan Masak</label>
        <textarea id="textarea-label" name="deskripsi_bahan"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..." required></textarea>
    </div>
    <!-- Input Nutrition -->
    <div class="flex flex-col gap-2" id="textInputContainerNutrition">
        <label for="input-ingredient" class="block text-sm font-medium mb-2 w-full">Kandungan Gizi</label>
        <div class="flex flex-wrap gap-2">
            <div class="flex-2">
                <label for="input-ingredient" class="block text-sm font-medium mb-2">Nutrisi</label>
                <div class="w-full px-2 border border-cinnabar rounded-lg">
                    <select id="hs-select-label" name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="" disabled>Pilih Nutrisi</option>
                        @foreach ([
                        'Energi', 'Karbohidrat', 'Protein', 'Lemak', 'Serat', 'Gula',
                        'Natrium', 'Kalsium', 'Zat Besi', 'Vitamin A', 'Vitamin B1',
                        'Vitamin B2', 'Vitamin B3', 'Vitamin B6', 'Vitamin B12', 'Vitamin C',
                        'Vitamin D', 'Vitamin E', 'Vitamin K', 'Kolesterol'
                        ] as $gizi)
                        <option value="{{ $gizi }}">{{ $gizi }}</option>
                        @endforeach
                    </select>
                </div>
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                <input type="text" id="input-amount" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah">
            </div>
            <div class="flex-1">
                <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                <div class="w-full px-2 border border-cinnabar rounded-lg">
                    <select id="hs-select-label" name="satuan[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected="" disabled>Pilih Satuan</option>
                        @foreach ([
                        'mg', 'g', 'µg', 'kcal', 'IU', 'ml', 'L', '%'
                        ] as $satuan)
                        <option value="{{ $satuan }}">{{ $satuan }}</option>
                        @endforeach
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
        <input type="url" id="input-image" name="gambar_bahan"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan link url gambar bahan masak" required>
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Tambah
        </button>
    </div>
</form>