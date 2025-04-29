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
    <!-- Input Ingredient -->
    <div class="flex flex-col gap-4">
        <div class="w-full flex flex-col gap-2 ingredient-group" id="textInputContainerIngredient">
            <div class="flex flex-wrap gap-2">
                <label for="title" class="block text-sm font-medium mb-2 w-full">Bahan
                    Masak</label>
                <div class="flex-2">
                    <label for="input-ingredient-name" class="block text-sm font-medium mb-2">Nama Bahan</label>
                    <input type="hidden" name="id_bahan[]" id="real-input-ingredient" value="">
                    <div class="relative" data-hs-combo-box="">
                        <div class="relative">
                            <input
                                class="py-2.5 sm:py-3 ps-4 pe-9 block w-full border-cinnabar rounded-lg sm:text-sm focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                                type="text" role="combobox" aria-expanded="false" value="" id="display-input-ingredient"
                                data-hs-combo-box-input="" autocomplete="off" placeholder="Pilih bahan masak">
                            @error('id_bahan[]')
                            <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                                {{ $message }}
                            </p>
                            @enderror
                            <div class="hidden hs-combo-box-active:flex absolute inset-y-0 end-8 items-center z-20">
                                <button type="button"
                                    class="inline-flex shrink-0 justify-center items-center size-6 rounded-full text-gray-500 hover:text-blue-600 focus:outline-hidden focus:text-blue-600 dark:text-neutral-500 dark:hover:text-blue-500 dark:focus:text-blue-500"
                                    aria-label="Close" data-hs-combo-box-close="">
                                    <span class="sr-only">Close</span>
                                    <svg class="shrink-0 size-4" xmlns="http://www.w3.org/2000/svg" width="24"
                                        height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                        stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <circle cx="12" cy="12" r="10"></circle>
                                        <path d="m15 9-6 6"></path>
                                        <path d="m9 9 6 6"></path>
                                    </svg>
                                </button>
                            </div>
                            <div class="absolute top-1/2 end-3 -translate-y-1/2" aria-expanded="false" role="button"
                                data-hs-combo-box-toggle="">
                                <svg class="shrink-0 size-3.5 text-charcoal" xmlns="http://www.w3.org/2000/svg"
                                    width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="m7 15 5 5 5-5"></path>
                                    <path d="m7 9 5-5 5 5"></path>
                                </svg>
                            </div>
                        </div>
                        @foreach ($dataBahanMasak as $bahan)
                        <div class="absolute z-50 w-full max-h-72 p-1 bg-white border border-gray-200 rounded-lg overflow-hidden overflow-y-auto [&::-webkit-scrollbar]:w-2 [&::-webkit-scrollbar-thumb]:rounded-full [&::-webkit-scrollbar-track]:bg-gray-100 [&::-webkit-scrollbar-thumb]:bg-gray-300"
                            style="display: none;" role="listbox" data-hs-combo-box-output="{{ $bahan -> id_bahan }}">
                            <div class="cursor-pointer py-2 px-4 w-full text-sm text-gray-800 hover:bg-gray-100 rounded-lg focus:outline-hidden focus:bg-gray-100"
                                role="option" tabindex="0" data-hs-combo-box-output-item="{{ $bahan -> id_bahan }}"
                                data-hs-combo-box-item-stored-data="{{ $bahan -> id_bahan }}">
                                <div class="flex justify-between items-center w-full">
                                    <span data-hs-combo-box-search-text="{{ $bahan -> nama_bahan }}"
                                        data-hs-combo-box-value="{{ $bahan -> id_bahan }}">{{ $bahan -> nama_bahan }}</span>
                                    <span class="hidden hs-combo-box-selected:block">
                                        <svg class="shrink-0 size-3.5 text-blue-600" xmlns="http://www.w3.org/2000/svg"
                                            width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                            stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                            <path d="M20 6 9 17l-5-5"></path>
                                        </svg>
                                    </span>
                                </div>
                            </div>
                        </div>
                        @endforeach
                    </div>
                </div>
                <div class="flex-1">
                    <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                    <input type="text" id="input-amount" name="jumlah_bahan[]"
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
                        @error('satuan[]')
                        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                            {{ $message }}
                        </p>
                        @enderror
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="flex gap-2 w-1/2">
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
            class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            style="display: none;">
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
                <input type="text" id="input-amount" name="jumlah[]"
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
                <input type="text" id="input-number" name="nomor_langkah[]"
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
        <input type="file" name="thumbnail" id="input-thumbnail"
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