@foreach ( $dataResep as $key => $resep )
<div id="popup-modal-report{{ $resep -> id_resep }}" tabindex="-1"
    class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%+1rem)] max-h-full bg-charcoal/10">
    <div class="relative p-4 w-full max-w-lg max-h-full">
        <div class="relative bg-alabaster rounded-lg shadow-xl">
            <button type="button"
                class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center"
                data-modal-hide="popup-modal-report{{ $resep -> id_resep }}">
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                    viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="p-4 md:p-5 text-center text-charcoal">
                <svg class="mx-auto mb-4 w-12 h-12" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                    viewBox="0 0 20 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
                </svg>
                <h3 class="mb-5 text-lg font-normal text-gray-500">
                    Apakah kamu yakin ingin melaporkan konten ini?
                </h3>
                <form action="{{ route('laporan-konten.store') }}" method="post" enctype="multipart/form-data"
                    class="flex flex-col items-start gap-4">
                    @csrf
                    @method('POST')
                    <input type="hidden" name="id_resep" value="{{ $resep->id_resep }}">
                    <div class="w-full flex flex-col justify-start">
                        <label for="textarea-label" class="block text-sm text-start font-medium mb-2">Deskripsi
                            Konten</label>
                        <textarea id="textarea-label" name="deskripsi_laporan"
                            class="py-2 px-3 sm:py-3 sm:px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                            rows="3" placeholder="Ketikkan deskripsi disini..." required></textarea>
                        @error('deskripsi_laporan')
                        <p class="text-sm 2xl:text-base text-red-600 mt-2" id="hs-validation-name-error-helper">
                            {{ $message }}
                        </p>
                        @enderror
                    </div>
                    <div class="w-full flex justify-center">
                        <button data-modal-hide="popup-modal-report" type="submit"
                            class="text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm inline-flex items-center px-5 py-2.5 text-center">
                            Ya
                        </button>
                        <button data-modal-hide="popup-modal-report{{ $resep -> id_resep }}" type="button"
                            class="py-2.5 px-5 ms-3 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border border-gray-200 hover:bg-gray-100 hover:text-cinnabar focus:z-10 focus:ring-4 focus:ring-gray-100">
                            Tidak
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
@endforeach