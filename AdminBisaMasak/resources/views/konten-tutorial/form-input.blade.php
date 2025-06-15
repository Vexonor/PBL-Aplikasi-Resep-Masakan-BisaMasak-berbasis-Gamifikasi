<form action="{{ route('konten-tutorial.store') }}" class="flex flex-col gap-4 p-5" method="post" id="ingredient-form"
    enctype="multipart/form-data">
    @csrf
    @method('POST')
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-title" class="block text-sm font-medium mb-2">Judul Konten</label>
        <input type="text" id="input-title" name="judul_konten"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan judul konten" required>
        @error('judul_konten')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Konten</label>
        <textarea id="textarea-label" name="deskripsi_konten"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..." required></textarea>
        @error('deskripsi_konten')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Input Duration -->
    <div class="w-full">
        <label for="input-level" class="block text-sm font-medium mb-2">Durasi Memasak</label>
        <input type="number" id="input-level" name="durasi"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan durasi memasak" required>
    </div>
    <!-- Input Level Requirement -->
    <div class="w-full">
        <label for="input-level" class="block text-sm font-medium mb-2">Level Untuk Membuka Resep Ini</label>
        <input type="number" id="input-level" name="terbuka_di_level"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan level yang dibutuhkan" required>
    </div>
    <!-- Input Categories -->
    <div class="w-full">
        <label for="hs-select-label" class="block text-sm font-medium mb-2">Kategori Resep</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="hs-select-label" name="kategori"
                class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                <option selected disabled>Pilih Kategori</option>
                @foreach ([
                'Sarapan', 'Makan Siang', 'Makan Malam', 'Cemilan'
                ] as $kategori)
                <option value="{{ $kategori }}">{{ $kategori }}</option>
                @endforeach
            </select>
            @error('kategori')
            <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                {{ $message }}
            </p>
            @enderror
        </div>
    </div>

    <!-- Input Ingredient -->
    <div class="ingredients-container flex flex-col gap-4">
        <div class="flex flex-col gap-4">
            <label for="title" class="block text-sm font-medium w-full">Bahan
                Masak</label>
            <div class="w-full flex flex-col gap-2 ingredient-group" id="textInputContainerIngredient">
                <div class="flex flex-wrap gap-2">
                    <div class="flex-2">
                        <label for="input-nama" class="block text-sm font-medium mb-2">Nama Bahan</label>
                        <input type="text" list="ingredient"
                            class="input-bahan-field py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan level yang dibutuhkan" required>
                        <datalist id="ingredient">
                            @foreach ($dataBahanMasak as $bahan)
                            <option data-id="{{ $bahan -> id_bahan }}" value="{{ $bahan -> nama_bahan }}"
                                class="w-full"></option>
                            @endforeach
                        </datalist>
                        <input type="hidden" name="id_bahan[]" id="id-bahan-field">
                    </div>
                    <div class="flex-1">
                        <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                        <input type="text" id="input-amount" name="jumlah_bahan[]"
                            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan jumlah">
                    </div>
                    <div class="flex-1">
                        <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                        <div class="w-full px-4 border border-cinnabar rounded-lg">
                            <select id="hs-select-label" name="satuan_bahan[]"
                                class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                                <option selected disabled>Pilih Satuan</option>
                                @foreach ([
                                'g', 'kg', 'ml', 'L', 'sdt', 'sdm', 'cup', 'buah', 'butir', 'siung', 'batang', 'lembar',
                                'potong', 'sejumput', 'secukupnya'
                                ] as $satuan)
                                <option value="{{ $satuan }}">{{ $satuan }}</option>
                                @endforeach
                            </select>
                            @error('satuan_bahan[]')
                            <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                                {{ $message }}
                            </p>
                            @enderror
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="flex gap-2">
        <button type="button" id="btnAddIngredient"
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path
                    d="M224,128a8,8,0,0,1-8,8H136v80a8,8,0,0,1-16,0V136H40a8,8,0,0,1,0-16h80V40a8,8,0,0,1,16,0v80h80A8,8,0,0,1,224,128Z">
                </path>
            </svg>
            Tambah Input
        </button>
        <button type="button" id="btnRemoveIngredient"
            class="py-3 px-4 flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none hidden">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path d="M224,128a8,8,0,0,1-8,8H40a8,8,0,0,1,0-16H216A8,8,0,0,1,224,128Z"></path>
            </svg>
            Hapus Input
        </button>
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
                        <option selected disabled>Pilih Nutrisi</option>
                        @foreach ([
                        'Energi', 'Karbohidrat', 'Protein', 'Lemak', 'Serat', 'Gula',
                        'Natrium', 'Kalsium', 'Zat Besi', 'Vitamin A', 'Vitamin B1',
                        'Vitamin B2', 'Vitamin B3', 'Vitamin B6', 'Vitamin B12', 'Vitamin C',
                        'Vitamin D', 'Vitamin E', 'Vitamin K', 'Kolesterol'
                        ] as $gizi)
                        <option value="{{ $gizi }}">{{ $gizi }}</option>
                        @endforeach
                    </select>
                    @error('nama_gizi[]')
                    <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                        {{ $message }}
                    </p>
                    @enderror
                </div>
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                <input type="number" step="any" id="input-amount" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah">
                @error('jumlah[]')
                <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                    {{ $message }}
                </p>
                @enderror
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
                    @error('satuan_gizi[]')
                    <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                        {{ $message }}
                    </p>
                    @enderror
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
    <!-- Input Step -->
    <div class="flex flex-col gap-2" id="textInputContainerStep">
        <label for="input-description" class="block text-sm font-medium mb-2 w-full">Langkah-langkah</label>
        <div class="flex flex-wrap gap-2 step-input">
            <div class="flex-1">
                <label for="input-number" class="block text-sm font-medium mb-2">No.</label>
                <input type="number" id="input-number" name="nomor_langkah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan kandungan nutrisi" value="1" readonly>
            </div>
            <div class="flex-4">
                <label for="input-description" class="block text-sm font-medium mb-2">Deskripsi</label>
                <textarea id="textarea-description" name="deskripsi_langkah[]"
                    class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    rows="1" placeholder="Ketikkan deskripsi disini..." required></textarea>
                @error('deskripsi_langkah[]')
                <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                    {{ $message }}
                </p>
                @enderror
            </div>
            <div class="flex-4">
                <label for="input-image-step" class="block text-sm font-medium mb-2">Gambar</label>
                <input type="file" name="gambar_langkah[]" id="input-image-step" required
                    class="block w-full ps-4 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
                @error('gambar_langkah[]')
                <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                    {{ $message }}
                </p>
                @enderror
            </div>
        </div>
    </div>
    <div class="flex gap-2 w-1/2">
        <button type="button" id="btnAddStep"
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path
                    d="M224,128a8,8,0,0,1-8,8H136v80a8,8,0,0,1-16,0V136H40a8,8,0,0,1,0-16h80V40a8,8,0,0,1,16,0v80h80A8,8,0,0,1,224,128Z">
                </path>
            </svg>
            Tambah Input
        </button>
        <button type="button" id="btnRemoveStep"
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            style="display: none;">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path d="M224,128a8,8,0,0,1-8,8H40a8,8,0,0,1,0-16H216A8,8,0,0,1,224,128Z"></path>
            </svg>
            Hapus Input
        </button>
    </div>
    <!-- Upload Thumbnail -->
    <div class="w-full">
        <label for="input-thumbnail" class="block text-sm font-medium mb-2">Gambar Thumbnail</label>
        <input type="file" type="image/*" name="thumbnail" id="input-thumbnail"
            class="block w-full ps-4 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4"
            required>
        @error('thumbnail')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Upload Video -->
    <div class="w-full">
        <label for="input-video" class="block text-sm font-medium mb-2">Video Tutorial</label>
        <input type="file" name="video_tutorial" id="input-video"
            class="block w-full ps-4 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4"
            accept="video/*">
        @error('video_tutorial')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Unggah
        </button>
    </div>
</form>