<form action="{{ route('admin.update', $dataAdmin -> id_admin) }}" class="flex flex-col gap-4 p-5" method="post"
    enctype="multipart/form-data">
    @csrf
    @method('PATCH')
    <!-- Input Name -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Admin</label>
        <input type="text" id="input-name" name="nama"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin" value="{{ $dataAdmin -> UserTable -> nama }}">
        @error('nama')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Input Date -->
    <div class="w-full">
        <label for="input-birth" class="block text-sm font-medium mb-2">Tanggal Lahir</label>
        <input type="date" id="input-birth" name="tanggal_lahir"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin" value="{{ $dataAdmin -> UserTable -> tanggal_lahir }}">
        @error('tanggal_lahir')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Input Email -->
    <div class="w-full">
        <label for="input-email" class="block text-sm font-medium mb-2">Email</label>
        <input type="email" id="input-email" name="email"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan email" value="{{ $dataAdmin -> UserTable -> email }}">
        @error('email')
        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
            {{ $message }}
        </p>
        @enderror
    </div>
    <!-- Input Gender -->
    <div class="w-full">
        <label for="input-gender" class="block text-sm font-medium mb-2">Jenis Kelamin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="input-gender" name="jenis_kelamin"
                class="py-3 pr-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                <option selected disabled>Pilih jenis kelamin</option>
                <option {{ $dataAdmin -> UserTable -> jenis_kelamin === 'Laki-laki' ? 'selected' : '' }}
                    value="Laki-laki">
                    Laki-laki
                </option>
                <option {{ $dataAdmin -> UserTable -> jenis_kelamin === 'Perempuan' ? 'selected' : '' }}
                    value="Perempuan">
                    Perempuan
                </option>
            </select>
            @error('jenis_kelamin')
            <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                {{ $message }}
            </p>
            @enderror
        </div>
    </div>
    <!-- Input Role -->
    <div class="w-full">
        <label for="input-role" class="block text-sm font-medium mb-2">Peran Admin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="input-role" name="peran_admin"
                class="py-3 pr-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none">
                <option selected disabled>Pilih peran admin</option>
                <option {{ $dataAdmin -> peran_admin === 'Master Admin' ? 'selected' : '' }} value="Master Admin">Master
                    Admin</option>
                <option {{ $dataAdmin -> peran_admin === 'Admin' ? 'selected' : '' }} value="Admin">Admin</option>
            </select>
            @error('peran_admin')
            <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                {{ $message }}
            </p>
            @enderror
        </div>
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Simpan Perubahan
        </button>
    </div>
</form>