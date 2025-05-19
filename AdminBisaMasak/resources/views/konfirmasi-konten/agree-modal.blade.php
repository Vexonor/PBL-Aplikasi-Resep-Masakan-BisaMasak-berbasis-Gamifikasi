@foreach ( $dataResep as $key => $resep )
<div id="popup-modal-agree{{ $resep -> id_resep }}" tabindex="-1"
    class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%+1rem)] max-h-full bg-charcoal/10">
    <div class="relative p-4 w-full max-w-lg max-h-full">
        <div class="relative bg-alabaster rounded-lg shadow-xl">
            <button type="button"
                class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center"
                data-modal-hide="popup-modal-agree{{ $resep -> id_resep }}">
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                    viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="p-4 md:p-5 text-center text-charcoal">
                <svg xmlns="http://www.w3.org/2000/svg" class="mx-auto mb-4 size-12" fill="currentColor"
                    viewBox="0 0 256 256">
                    <path
                        d="M173.66,98.34a8,8,0,0,1,0,11.32l-56,56a8,8,0,0,1-11.32,0l-24-24a8,8,0,0,1,11.32-11.32L112,148.69l50.34-50.35A8,8,0,0,1,173.66,98.34ZM232,128A104,104,0,1,1,128,24,104.11,104.11,0,0,1,232,128Zm-16,0a88,88,0,1,0-88,88A88.1,88.1,0,0,0,216,128Z">
                    </path>
                </svg>
                <h3 class="mb-5 text-lg font-normal text-gray-500">
                    Apakah kamu yakin ingin mengunggah konten ini?
                </h3>
                <form action="{{ route('konfirmasi-konten.update', $resep -> id_resep) }}" method="post"
                    enctype="multipart/form-data">
                    @csrf
                    @method('PATCH')
                    <button data-modal-hide="popup-modal-agree" type="submit"
                        class="text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm inline-flex items-center px-5 py-2.5 text-center">
                        Ya
                    </button>
                    <button data-modal-hide="popup-modal-agree{{ $resep -> id_resep }}" type="button"
                        class="py-2.5 px-5 ms-3 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border border-gray-200 hover:bg-gray-100 hover:text-cinnabar focus:z-10 focus:ring-4 focus:ring-gray-100">
                        Tidak
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
@endforeach