<form action="" class="flex flex-col gap-4 p-5" method="post" enctype="multipart/form-data">
    <!-- Input Name -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Nama Admin</label>
        <input type="text" id="input-name"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin">
    </div>
    <!-- Input Date -->
    <div class="w-full">
        <label for="input-name" class="block text-sm font-medium mb-2">Tanggal Lahir</label>
        <input type="date" id="input-name"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan nama admin">
    </div>
    <!-- Input Email -->
    <div class="w-full">
        <label for="input-email" class="block text-sm font-medium mb-2">Email</label>
        <input type="email" id="input-email"
            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
            placeholder="Masukkan email">
    </div>
    <!-- Input Gender -->
    <div class="w-full">
        <label for="input-gender" class="block text-sm font-medium mb-2">Jenis Kelamin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="hs-select-label"
                class="py-3 pr-4 block w-full text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none">
                <option selected="" disabled>Pilih jenis kelamin</option>
                <option>Laki-laki</option>
                <option>Perempuan</option>
            </select>
        </div>
    </div>
    <!-- Input Role -->
    <div class="w-full">
        <label for="input-role" class="block text-sm font-medium mb-2">Peran Admin</label>
        <div class="w-full px-4 border border-cinnabar rounded-lg">
            <select id="hs-select-label"
                class="py-3 pr-4 block w-full text-sm focus:outline-none disabled:opacity-50 disabled:pointer-events-none">
                <option selected="" disabled>Pilih peran admin</option>
                <option>Master Admin</option>
                <option>Admin</option>
            </select>
        </div>
    </div>
    <!-- Submit Button -->
    <div class="w-full flex justify-end items-center">
        <button type="submit"
            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
            Tambah
        </button>
    </div>
</form>