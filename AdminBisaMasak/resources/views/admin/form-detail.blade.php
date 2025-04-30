<form action="" class="flex flex-col gap-4 p-5" method="post" enctype="multipart/form-data">
    <!-- Input Name -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Admin</label>
        <input type="text" id="input-name" value="{{ $dataAdmin -> UserTable -> nama }}"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin" readonly>
    </div>
    <!-- Input Date -->
    <div class="w-full">
        <label for="input-birth" class="block text-sm font-medium mb-2">Tanggal Lahir</label>
        <input type="date" id="input-birth" value="{{ $dataAdmin -> UserTable -> tanggal_lahir }}"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin" readonly>
    </div>
    <!-- Input Email -->
    <div class="w-full">
        <label for="input-email" class="block text-sm font-medium mb-2">Email</label>
        <input type="email" id="input-email" value="{{ $dataAdmin -> UserTable -> email }}"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar focus-within:ring-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan email" readonly>
    </div>
    <!-- Input Gender -->
    <div class="w-full">
        <label for="input-gender" class="block text-sm font-medium mb-2">Jenis Kelamin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="input-gender" name="jenis_kelamin"
                class="py-3 pr-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
                <option selected disabled>Pilih jenis kelamin</option>
                <option {{ $dataAdmin -> UserTable -> jenis_kelamin === 'Laki-laki' ? 'selected' : '' }}>
                    Laki-laki
                </option>
                <option {{ $dataAdmin -> UserTable -> jenis_kelamin === 'Perempuan' ? 'selected' : '' }}>
                    Perempuan
                </option>
            </select>
        </div>
    </div>
    <!-- Input Role -->
    <div class="w-full">
        <label for="input-role" class="block text-sm font-medium mb-2">Peran Admin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="input-role" name="peran_admin"
                class="py-3 pr-4 block w-full text-sm border-none focus:outline-none focus-within:ring-0 disabled:opacity-50 disabled:pointer-events-none pointer-events-none">
                <option selected disabled>Pilih peran admin</option>
                <option {{ $dataAdmin -> peran_admin === 'Master Admin' ? 'selected' : '' }}>Master Admin</option>
                <option {{ $dataAdmin -> peran_admin === 'Admin' ? 'selected' : '' }}>Admin</option>
            </select>
        </div>
    </div>
</form>