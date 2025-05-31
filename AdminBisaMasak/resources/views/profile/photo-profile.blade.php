<form action="{{ route('profile.update', Auth::user()->id_user) }}" class="flex items-center gap-4" method="post"
    enctype="multipart/form-data">
    @csrf
    @method('PATCH')

    <input type="hidden" name="tipe_form" value="foto" />

    <div class="relative size-20 mb-4">
        <img id="previewImage" class="w-full h-full object-cover rounded-full border border-gray-300"
            src="{{ Auth::user()->foto_profil ? asset('storage/' . Auth::user()->foto_profil) : asset('default.png') }}"
            alt="Foto Profil">
    </div>

    <input type="file" name="foto_profil" id="uploadFoto" class="hidden" accept="image/*" onchange="previewFoto(this)">

    <div class="flex items-center gap-3">
        <button type="button" onclick="document.getElementById('uploadFoto').click()"
            class="py-2 px-3 flex items-center gap-4 text-xs font-medium border border-cinnabar text-cinnabar rounded-lg">
            <svg xmlns="http://www.w3.org/2000/svg" class="size-5" fill="currentColor" viewBox="0 0 256 256">
                <path
                    d="M240,136v64a16,16,0,0,1-16,16H32a16,16,0,0,1-16-16V136a16,16,0,0,1,16-16H80a8,8,0,0,1,0,16H32v64H224V136H176a8,8,0,0,1,0-16h48A16,16,0,0,1,240,136ZM85.66,77.66,120,43.31V128a8,8,0,0,0,16,0V43.31l34.34,34.35a8,8,0,0,0,11.32-11.32l-48-48a8,8,0,0,0-11.32,0l-48,48A8,8,0,0,0,85.66,77.66ZM200,168a12,12,0,1,0-12,12A12,12,0,0,0,200,168Z">
                </path>
            </svg>
            Upload Foto
        </button>
        <button type="submit" class="p-3 text-xs font-medium bg-cinnabar text-white rounded-lg hover:bg-cinnabar/75">
            Simpan Foto
        </button>
    </div>
</form>