@extends('main')

@section('main-content')
<div class="flex justify-between items-center gap-4 w-full">
    <!-- Search Bar -->
    <div class="relative flex-1">
        <form>
            <input type="search" id="search" name="search"
                class="peer py-2.5 sm:py-3 pe-4 ps-8 block w-full bg-transparent border-2 border-cinnabar rounded-lg sm:text-sm focus:ring-0 focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                placeholder="Cari konten..." autocomplete="off">
        </form>
        <div
            class="absolute inset-y-0 start-1 flex items-center pointer-events-none ps-2 peer-disabled:opacity-50 peer-disabled:pointer-events-none">
            <svg xmlns="http://www.w3.org/2000/svg" class="shrink-0 size-4 text-gray-500" fill="currentColor"
                viewBox="0 0 256 256">
                <path
                    d="M229.66,218.34l-50.07-50.06a88.11,88.11,0,1,0-11.31,11.31l50.06,50.07a8,8,0,0,0,11.32-11.32ZM40,112a72,72,0,1,1,72,72A72.08,72.08,0,0,1,40,112Z">
                </path>
            </svg>
        </div>
    </div>
</div>

<div class="w-full h-screen bg-white p-5 my-5">
    @if ($dataLaporan->isEmpty() || !$dataLaporan->contains(function ($item) {
    return optional($item->KontenResepTable)->status_konten === 'Terunggah';
    }))
    <div class="w-full h-full flex flex-col justify-center items-center gap-4 my-4">
        <img src="{{ asset('/asset/empty-query.svg') }}" class="size-60" alt="Empty Asset">
        <h2 class="font-semibold text-xl">Saat ini, belum ada konten resep yang dilaporkan.</h2>
    </div>
    @else
    <div class="flex flex-col">
        <div class="-m-1.5 overflow-x-auto">
            <div class="p-1.5 min-w-full inline-block align-middle">
                <div class="shadow-xs overflow-hidden">
                    <table class="min-w-full divide-y divide-white">
                        <thead class="bg-cinnabar text-white">
                            <tr class="border border-cinnabar divide-x divide-alabaster">
                                <th scope="col" class="px-1 py-3 text-center text-xs font-medium uppercase">
                                    No.</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Judul Konten</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Pengunggah</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Tanggal Unggah</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Aksi</th>
                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($dataLaporan as $key => $laporan)
                            <tr class="border border-cinnabar divide-x divide-cinnabar text-charcoal text-center">
                                <td class="px-1 py-4 whitespace-nowrap text-sm font-medium">
                                    {{ $key + 1 }}.
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm">
                                    <div class="flex justify-center items-center gap-2">
                                        <img class="inline-block size-9.5 rounded-full"
                                            src="{{ asset('storage/' . $laporan -> KontenResepTable -> thumbnail) }}"
                                            alt="Avatar">
                                        {{ $laporan -> KontenResepTable -> judul_konten }}
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm">
                                    <p class="w-40 truncate mx-auto">
                                        {{ $laporan -> deskripsi_laporan }}
                                    </p>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm">
                                    {{ $laporan -> KontenResepTable -> created_at }}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-end text-sm">
                                    <div class="flex justify-evenly items-center gap-4">
                                        <a href="{{ route('laporan-konten.edit', $laporan -> id_resep) }}">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                                viewBox="0 0 256 256">
                                                <path
                                                    d="M128,24A104,104,0,1,0,232,128,104.11,104.11,0,0,0,128,24Zm0,192a88,88,0,1,1,88-88A88.1,88.1,0,0,1,128,216Zm16-40a8,8,0,0,1-8,8,16,16,0,0,1-16-16V128a8,8,0,0,1,0-16,16,16,0,0,1,16,16v40A8,8,0,0,1,144,176ZM112,84a12,12,0,1,1,12,12A12,12,0,0,1,112,84Z">
                                                </path>
                                            </svg>
                                        </a>
                                        <button type="button" class="cursor-pointer"
                                            data-modal-target="popup-modal{{ $laporan -> id_laporan }}"
                                            data-modal-toggle="popup-modal{{ $laporan -> id_laporan }}">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                                viewBox="0 0 256 256">
                                                <path
                                                    d="M128,24A104,104,0,1,0,232,128,104.11,104.11,0,0,0,128,24Zm88,104a87.56,87.56,0,0,1-20.41,56.28L71.72,60.4A88,88,0,0,1,216,128ZM40,128A87.56,87.56,0,0,1,60.41,71.72L184.28,195.6A88,88,0,0,1,40,128Z">
                                                </path>
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    @endif
    <div class="my-5">
        {{ $dataLaporan -> links() }}
    </div>
</div>

@include('laporan-konten.block-modal')
@endsection