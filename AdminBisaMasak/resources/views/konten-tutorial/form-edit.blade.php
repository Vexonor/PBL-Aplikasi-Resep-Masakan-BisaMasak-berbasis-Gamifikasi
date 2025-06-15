<form action="{{ route('konten-tutorial.update', $dataResep->id_resep) }}" class="flex flex-col gap-4 p-5" method="post"
    id="ingredient-form" enctype="multipart/form-data">
    @csrf
    @method('PATCH')
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-title" class="block text-sm font-medium mb-2">Judul Konten</label>
        <input type="text" id="input-title" name="judul_konten" value="{{ $dataResep -> judul_konten }}"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan judul konten" required>
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Konten</label>
        <textarea id="textarea-label" name="deskripsi_konten"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..." required>{{ $dataResep -> deskripsi_konten }}</textarea>
    </div>
    <!-- Input Duration -->
    <div class="w-full">
        <label for="input-level" class="block text-sm font-medium mb-2">Durasi Memasak</label>
        <input type="number" id="input-level" name="durasi"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan durasi memasak" value="{{ $dataResep -> durasi }}" required>
    </div>
    <!-- Input Level Requirement -->
    <div class="w-full">
        <label for="input-level" class="block text-sm font-medium mb-2">Level Untuk Membuka Resep Ini</label>
        <input type="number" id="input-level" name="terbuka_di_level" value="{{ $dataResep -> terbuka_di_level }}"
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
                <option value="{{ $kategori }}" {{ $kategori == $dataResep->kategori ? 'selected' : '' }}>
                    {{ $kategori }}
                </option>
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
            @foreach ($dataResep->BahanResepTable as $resep)
            <div class="w-full flex flex-col gap-2 ingredient-group" id="textInputContainerIngredient">
                <div class="flex flex-wrap gap-2">
                    @php
                    $bahan = $dataBahanMasak->firstWhere('id_bahan', $resep->id_bahan);
                    @endphp
                    <div class="flex-2">
                        <label for="input-nama" class="block text-sm font-medium mb-2">Nama Bahan</label>
                        <input type="text" list="ingredient"
                            class="input-bahan-field py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan level yang dibutuhkan" value="{{ $bahan -> nama_bahan }}" required>
                        <datalist id="ingredient">
                            @foreach ($dataBahanMasak as $bahan)
                            <option data-id="{{ $bahan -> id_bahan }}" value="{{ $bahan -> nama_bahan }}"
                                class="w-full"></option>
                            @endforeach
                        </datalist>
                        <input type="hidden" value="{{ $resep -> id_bahan }}" name="id_bahan[]" id="id-bahan-field">
                    </div>
                    <div class="flex-1">
                        <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                        <input type="text" id="input-amount" name="jumlah_bahan[]"
                            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan jumlah" value="{{ $resep -> jumlah_bahan }}">
                    </div>
                    <div class="flex-1">
                        <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                        <div class="w-full px-4 border border-cinnabar rounded-lg">
                            <select id="hs-select-label" name="satuan_bahan[]"
                                class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                                <option disabled>Pilih Satuan</option>
                                @foreach ([
                                'g', 'kg', 'ml', 'L', 'sdt', 'sdm', 'cup', 'buah', 'butir', 'siung', 'batang', 'lembar',
                                'potong', 'sejumput', 'secukupnya'
                                ] as $satuan)
                                <option value="{{ $satuan }}" {{ $satuan == $resep->satuan_bahan ? 'selected' : '' }}>
                                    {{ $satuan }}
                                </option>
                                @endforeach
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            @endforeach
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
            class="py-3 px-4 flex items-center gap-x-2 text-sm font-medium rounded-lg border border-cinnabar text-cinnabar disabled:opacity-50 disabled:pointer-events-none hidden">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
                <path d="M224,128a8,8,0,0,1-8,8H40a8,8,0,0,1,0-16H216A8,8,0,0,1,224,128Z"></path>
            </svg>
            Hapus Input
        </button>
    </div>
    <!-- Input Nutrition -->
    <div class="flex flex-col gap-2" id="textInputContainerNutrition">
        <label for="title" class="block text-sm font-medium mb-2 w-full">Kandungan Gizi</label>
        @foreach ($dataResep->GiziTable as $bahan)
        <div class="flex flex-wrap gap-2">
            <div class="flex-2">
                <label for="input-nutrition" class="block text-sm font-medium mb-2">Nutrisi</label>
                <div class="w-full px-2 border border-cinnabar rounded-lg mb-2">
                    <select id="hs-select-label" name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                        <option selected disabled>Pilih Nutrisi</option>
                        @foreach ([
                        'Energi', 'Karbohidrat', 'Protein', 'Lemak', 'Serat', 'Gula',
                        'Natrium', 'Kalsium', 'Zat Besi', 'Vitamin A', 'Vitamin B1',
                        'Vitamin B2', 'Vitamin B3', 'Vitamin B6', 'Vitamin B12', 'Vitamin C',
                        'Vitamin D', 'Vitamin E', 'Vitamin K', 'Kolesterol'
                        ] as $gizi)
                        <option value="{{ $gizi }}" {{ $gizi == $bahan -> nama_gizi ? 'selected' : '' }}>{{ $gizi }}
                        </option>
                        @endforeach
                    </select>
                </div>
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                <input type="number" step="any" id="input-amount" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah" value="{{ $bahan -> jumlah }}">
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
                        <option value="{{ $satuan }}" {{ $satuan == $bahan -> satuan ? 'selected' : '' }}>{{ $satuan }}
                        </option>
                        @endforeach
                    </select>
                </div>
            </div>
        </div>
        @endforeach
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
        @foreach ($dataResep->LangkahLangkahTable as $langkah)
        <div class="flex flex-wrap gap-2 step-input">
            <div class="flex-1">
                <label for="input-number" class="block text-sm font-medium">No.</label>
                <input type="number" id="input-number" name="nomor_langkah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan kandungan nutrisi" value="{{ $langkah -> nomor_langkah }}" readonly>
            </div>
            <div class="flex-4">
                <label for="input-description" class="block text-sm font-medium">Deskripsi</label>
                <textarea id="textarea-description" name="deskripsi_langkah[]"
                    class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    rows="1" placeholder="Ketikkan deskripsi disini..."
                    readonly>{{ $langkah -> deskripsi_langkah }}</textarea>
            </div>
            <div class="flex-4">
                <label for="input-image-step" class="block text-sm font-medium">Gambar</label>
                <input type="file" name="gambar_langkah[]" id="input-image-step" value=""
                    class="block w-full ps-4 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
                @error('gambar_langkah[]')
                <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                    {{ $message }}
                </p>
                @enderror
            </div>
            <div class="flex flex-col gap-2 basis-full">
                <label for="" class="block text-sm font-medium">Gambar sebelumnya</label>
                <div class="w-full flex justify-center">
                    <img src="{{ Storage::url($langkah->gambar_langkah) }}" class="w-full h-80 object-cover rounded-lg"
                        alt="{{ $dataResep -> judul_konten }}">
                </div>
            </div>
        </div>
        @endforeach
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
            class="block w-full ps-4 mb-2 border border-gray-200 shadow-sm rounded-lg text-sm focus:z-10 focus:border-cinnabar focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none file:bg-cinnabar file:text-white file:border-0 file:me-4 file:py-3 file:px-4">
        <div class="size-60 flex flex-col gap-2">
            <label for="" class="block text-sm font-medium">Gambar sebelumnya</label>
            <img src="{{ Storage::url($dataResep -> thumbnail) }}" class="size-full object-cover rounded-lg"
                alt="{{ $dataResep -> judul_konten }}">
        </div>
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
    <!-- Video Review -->
    <div class="w-full">
        <label for="input-video" class="block text-sm font-medium mb-2">Video Sebelumnya</label>
        @if ($dataResep -> video_tutorial == null)
        <div
            class="w-full h-60 flex flex-col justify-center items-center text-gray-500 border-2 border-gray-500 rounded-lg">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" viewBox="0 0 256 256">
                <path
                    d="M251.77,73a8,8,0,0,0-8.21.39L208,97.05V72a16,16,0,0,0-16-16H113.06a8,8,0,0,0,0,16H192v87.63a8,8,0,0,0,16,0V159l35.56,23.71A8,8,0,0,0,248,184a8,8,0,0,0,8-8V80A8,8,0,0,0,251.77,73ZM240,161.05l-32-21.33V116.28L240,95ZM53.92,34.62A8,8,0,1,0,42.08,45.38L51.73,56H32A16,16,0,0,0,16,72V184a16,16,0,0,0,16,16H182.64l19.44,21.38a8,8,0,1,0,11.84-10.76ZM32,184V72H66.28L168.1,184Z">
                </path>
            </svg>
            <h2>Video Tidak Tersedia</h2>
        </div>
        @else
        <div
            class="w-full h-80 flex justify-center items-center text-gray-500 border-2 border-gray-500 rounded-lg overflow-hidden">
            <video class="w-full h-full object-cover" src="{{ Storage::url($dataResep->video_tutorial) }}" controls
                loop></video>
        </div>
        @endif
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Simpan Perubahan
        </button>
    </div>
</form>