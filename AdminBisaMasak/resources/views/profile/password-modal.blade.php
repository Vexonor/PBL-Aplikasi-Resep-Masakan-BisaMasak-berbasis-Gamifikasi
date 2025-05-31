<div id="popup-modal" tabindex="-1"
    class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%+1rem)] max-h-full bg-charcoal/10">
    <div class="relative p-4 w-full max-w-4xl max-h-full">
        <div class="relative bg-alabaster rounded-lg shadow-xl">
            <button type="button"
                class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center"
                data-modal-hide="popup-modal">
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                    viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="p-4 md:p-5 text-charcoal">
                <h3 class="mb-5 text-lg font-semibold text-charcoal">
                    Ubah Kata Sandi
                </h3>
                <p class="mb-5">
                    Silakan buat kata sandi baru untuk akun Anda. Pastikan kata sandi yang Anda buat kuat dan tidak
                    mudah ditebak untuk menjaga keamanan akun Anda.
                </p>
                <form action="{{ route('profile.update', Auth::user()->id_user) }}" method="post"
                    enctype="multipart/form-data">
                    @csrf
                    @method('PATCH')
                    <input type="hidden" name="tipe_form" value="password" />
                    <!-- Input New Password -->
                    <div class="mb-5">
                        <label for="hs-toggle-password-with-checkbox" class="block text-sm mb-2">
                            Kata Sandi Baru
                        </label>
                        <input id="hs-toggle-password-with-checkbox" type="password"
                            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-1 focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan kata sandi" required>
                        <!-- Checkbox -->
                        <div class="flex mt-4">
                            <input data-hs-toggle-password='{
                            "target": "#hs-toggle-password-with-checkbox"
                        }' id="hs-toggle-password-checkbox" type="checkbox"
                                class="shrink-0 mt-0.5 border border-cinnabar rounded-sm text-cinnabar focus:ring-cinnabar">
                            <label for="hs-toggle-password-checkbox" class="text-sm text-gray-500 ms-3">
                                Lihat kata sandi
                            </label>
                        </div>
                        <!-- End Checkbox -->
                    </div>
                    <!-- Confirm Password -->
                    <div class="mb-5">
                        <label for="hs-toggle-password-with-checkbox-confirm" class="block text-sm mb-2">
                            Konfirmasi Kata Sandi
                        </label>
                        <input id="hs-toggle-password-with-checkbox-confirm" type="password" name="password"
                            class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-1 focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            placeholder="Masukkan kata sandi" required>
                        <!-- Checkbox -->
                        <div class="flex mt-4">
                            <input data-hs-toggle-password='{
                            "target": "#hs-toggle-password-with-checkbox-confirm"
                        }' id="hs-toggle-password-checkbox-confirm" type="checkbox"
                                class="shrink-0 mt-0.5 border border-cinnabar rounded-sm text-cinnabar focus:ring-cinnabar">
                            <label for="hs-toggle-password-checkbox" class="text-sm text-gray-500 ms-3">
                                Lihat kata sandi
                            </label>
                        </div>
                        <!-- End Checkbox -->
                    </div>
                    <div class="w-full flex justify-end items-center">
                        <button data-modal-hide="popup-modal" type="submit"
                            class="py-3 px-6 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
                            Simpan Perubahan
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>