<form action="" class="flex flex-col gap-4 p-5" method="post" enctype="multipart/form-data">
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-title" class="block text-sm font-medium mb-2">Judul Konten</label>
        <input type="text" id="input-title" value="{{ $dataResep -> judul_konten }}"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan judul konten" readonly>
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Konten</label>
        <textarea id="textarea-label" name="deskripsi_konten"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..." readonly>{{ $dataResep -> deskripsi_konten }}</textarea>
    </div>
    <!-- Input Ingredient -->
    <div class="flex flex-col gap-4">
        <label for="title" class="block text-sm font-medium w-full">Bahan
            Masak</label>
        <div class="w-full flex flex-col gap-2 ingredient-group" id="textInputContainerIngredient">
            <div class="flex flex-wrap gap-2">
                <div class="flex-2">
                    <label for="input-ingredient-name" class="block text-sm font-medium mb-2">Nama Bahan</label>
                    @foreach ($dataResep->BahanResepTable as $key => $resep)
                    @php
                    $bahan = $dataBahanMasak->firstWhere('id_bahan', $resep->id_bahan);
                    @endphp
                    <div class="relative mb-2" data-hs-combo-box="">
                        <div class="relative">
                            <input
                                class="py-2.5 sm:py-3 ps-4 pe-9 block w-full border-cinnabar rounded-lg sm:text-sm focus:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                                type="text" role="combobox" aria-expanded="false"
                                value="{{ $bahan ? $bahan -> nama_bahan : 'Kosong' }}" id="display-input-ingredient"
                                data-hs-combo-box-input="" autocomplete="off" placeholder="Pilih bahan masak" readonly>
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
                        <div class="absolute z-50 w-full max-h-72 p-1 bg-white border border-gray-200 rounded-lg overflow-hidden overflow-y-auto [&::-webkit-scrollbar]:w-2 [&::-webkit-scrollbar-thumb]:rounded-full [&::-webkit-scrollbar-track]:bg-gray-100 [&::-webkit-scrollbar-thumb]:bg-gray-300 pointer-events-none"
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
                    @endforeach
                </div>
                <div class="flex-1">
                    <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                    @foreach ($dataResep->BahanResepTable as $bahan)
                    <input type="text" id="input-amount"
                        class="py-2.5 sm:py-3 px-4 mb-2 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                        placeholder="Masukkan jumlah" value="{{ $bahan -> jumlah_bahan }}" readonly>
                    @endforeach
                </div>
                <div class="flex-1">
                    <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                    @foreach ($dataResep->BahanResepTable as $bahan)
                    <div class="w-full px-4 border border-cinnabar rounded-lg mb-2">
                        <select id="hs-select-label" name="satuan_bahan[]"
                            class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                            <option disabled>Pilih Satuan</option>
                            @foreach ([
                            'g', 'kg', 'ml', 'L', 'sdt', 'sdm', 'cup', 'buah', 'butir', 'siung', 'batang', 'lembar',
                            'potong', 'sejumput', 'secukupnya'
                            ] as $satuan)
                            <option value="{{ $satuan }}" {{ $satuan == $bahan->satuan_bahan ? 'selected' : '' }}>
                                {{ $satuan }}
                            </option>
                            @endforeach
                        </select>
                    </div>
                    @endforeach
                </div>
            </div>
        </div>
    </div>
    <!-- Input Nutrition -->
    <div class="flex flex-col gap-2" id="textInputContainerNutrition">
        <label for="input-ingredient" class="block text-sm font-medium mb-2 w-full">Kandungan Gizi</label>
        <div class="flex flex-wrap gap-2">
            <div class="flex-2">
                <label for="input-ingredient" class="block text-sm font-medium mb-2">Nutrisi</label>
                @foreach ($dataResep->GiziTable as $bahan)
                <div class="w-full px-2 border border-cinnabar rounded-lg mb-2">
                    <select id="hs-select-label" name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
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
                @endforeach
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                @foreach ($dataResep->GiziTable as $bahan)
                <input type="number" step="any" id="input-amount" name="jumlah[]"
                    class="py-2.5 sm:py-3 mb-2 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah" value="{{ $bahan -> jumlah }}" readonly>
                @endforeach
            </div>
            <div class="flex-1">
                <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                @foreach ($dataResep->GiziTable as $bahan)
                <div class="w-full px-2 border border-cinnabar rounded-lg mb-2">
                    <select id="hs-select-label" name="satuan[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
                        <option selected="" disabled>Pilih Satuan</option>
                        @foreach ([
                        'mg', 'g', 'µg', 'kcal', 'IU', 'ml', 'L', '%'
                        ] as $satuan)
                        <option value="{{ $satuan }}" {{ $satuan == $bahan -> satuan ? 'selected' : '' }}>{{ $satuan }}
                        </option>
                        @endforeach
                    </select>
                </div>
                @endforeach
            </div>
        </div>
    </div>
    <!-- Input Step -->
    <div class="flex flex-col gap-2" id="textInputContainerStep">
        <label for="input-description" class="block text-sm font-medium mb-2 w-full">Langkah-langkah</label>
        @foreach ($dataResep->LangkahLangkahTable as $langkah)
        <div class="flex flex-wrap gap-2 step-input">
            <div class="flex-1 mb-2">
                <label for="input-number" class="block text-sm font-medium">No.</label>
                <input type="number" id="input-number" name="nomor_langkah[]"
                    class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan kandungan nutrisi" value="{{ $langkah -> nomor_langkah }}" readonly>
            </div>
            <div class="flex-4 mb-2">
                <label for="input-description" class="block text-sm font-medium">Deskripsi</label>
                <textarea id="textarea-description" name="deskripsi_langkah[]"
                    class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                    rows="1" placeholder="Ketikkan deskripsi disini..."
                    readonly>{{ $langkah -> deskripsi_langkah }}</textarea>
            </div>
        </div>
        <div>
            <div class="w-full flex justify-center">
                <img src="{{ Storage::url($langkah->gambar_langkah) }}" class="w-full h-80 object-cover rounded-lg"
                    alt="{{ $dataResep -> judul_konten }}">
            </div>
        </div>
        @endforeach
    </div>
    <!-- Upload Thumbnail -->
    <div class="w-full">
        <label for="input-thumbnail" class="block text-sm font-medium mb-2">Gambar Thumbnail</label>
        <div class="size-60">
            <img src="{{ Storage::url($dataResep -> thumbnail) }}" class="size-full object-cover rounded-lg"
                alt="{{ $dataResep -> judul_konten }}">
        </div>
    </div>
    <!-- Upload Video -->
    <div class="w-full">
        <label for="input-video" class="block text-sm font-medium mb-2">Video Tutorial</label>
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
</form>