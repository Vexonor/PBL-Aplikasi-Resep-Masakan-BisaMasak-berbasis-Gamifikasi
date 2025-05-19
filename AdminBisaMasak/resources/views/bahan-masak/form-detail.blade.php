<form action="{{ route('bahan-masak.store') }}" class="flex flex-col gap-4 p-5" method="post"
    enctype="multipart/form-data">
    @csrf
    @method('POST')
    <!-- Input Content Title -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Bahan Masak</label>
        <input type="text" id="input-name" name="nama_bahan"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama bahan masak" value="{{ $dataBahanMasak -> nama_bahan }}" readonly>
    </div>
    <!-- Input Description -->
    <div class="w-full">
        <label for="textarea-label" class="block text-sm font-medium mb-2">Deskripsi Bahan Masak</label>
        <textarea id="textarea-label" name="deskripsi_bahan"
            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
            rows="3" placeholder="Ketikkan deskripsi disini..."
            readonly>{{ $dataBahanMasak -> deskripsi_bahan }}</textarea>
    </div>
    <!-- Input Nutrition -->
    <div class="flex flex-col gap-2" id="textInputContainerNutrition">
        <label for="input-ingredient" class="block text-sm font-medium mb-2 w-full">Kandungan Gizi</label>
        <div class="flex flex-wrap gap-2">
            <div class="flex-2">
                <label for="input-ingredient" class="block text-sm font-medium mb-2">Nutrisi</label>
                @foreach ( $dataBahanMasak -> GiziTable as $gizi)
                <div class="w-full px-2 border border-cinnabar rounded-lg mb-2">
                    <select id="hs-select-label" name="nama_gizi[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
                        <option disabled>Pilih Nutrisi</option>
                        <option value="{{ $gizi -> nama_gizi }}">{{ $gizi -> nama_gizi }}</option>
                    </select>
                </div>
                @endforeach
            </div>
            <div class="flex-1">
                <label for="input-amount" class="block text-sm font-medium mb-2">Jumlah</label>
                @foreach ( $dataBahanMasak -> GiziTable as $gizi)
                <input type="text" id="input-amount" name="jumlah[]"
                    class="py-2.5 sm:py-3 px-4 mb-2 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                    placeholder="Masukkan jumlah" value="{{ $gizi -> jumlah }}" readonly>
                @endforeach
            </div>
            <div class="flex-1">
                <label for="hs-select-label" class="block text-sm font-medium mb-2">Satuan</label>
                @foreach ( $dataBahanMasak -> GiziTable as $gizi)
                <div class="w-full px-2 border border-cinnabar rounded-lg mb-2">
                    <select id="hs-select-label" name="satuan[]"
                        class="py-3 px-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
                        <option disabled>Pilih Satuan</option>
                        <option value="{{ $gizi -> satuan }}">{{ $gizi -> satuan }}</option>
                    </select>
                </div>
                @endforeach
            </div>
        </div>
    </div>
    <!-- Upload Image -->
    <div class="w-full">
        <label for="input-image" class="block text-sm font-medium mb-2">Gambar Bahan Masak</label>
        <img src="{{  $dataBahanMasak -> gambar_bahan }}" class="size-72 object-cover object-center rounded-lg"
            alt="{{ $dataBahanMasak -> nama_bahan }}">
    </div>
</form>