@extends('main')

@section('main-content')
<div class="flex justify-between">
    <!-- Breadcrumb -->
    <ol class="flex items-center whitespace-nowrap">
        <li class="inline-flex items-center">
            <a class="flex items-center text-sm text-gray-500 hover:text-cinnabar focus:outline-hidden focus:text-cinnabar"
                href="/laporan-konten">
                Laporan Konten
            </a>
            <svg class="shrink-0 mx-2 size-4 text-gray-400" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round">
                <path d="m9 18 6-6-6-6"></path>
            </svg>
        </li>

        <li class="inline-flex items-center text-sm font-semibold text-gray-800 truncate" aria-current="page">
            Detail Konten Laporan
        </li>
    </ol>

    <a href="{{ route('laporan-konten.show', $resepId) }}"
        class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border-2 border-cinnabar text-cinnabar hover:bg-cinnabar hover:text-white focus:outline-hidden focus:border-cinnabar focus:text-cinnabar disabled:opacity-50 disabled:pointer-events-none cursor-pointer transition-all delay-200">
        Lihat Detail Konten
        <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
            <path
                d="M181.66,133.66l-80,80a8,8,0,0,1-11.32-11.32L164.69,128,90.34,53.66a8,8,0,0,1,11.32-11.32l80,80A8,8,0,0,1,181.66,133.66Z">
            </path>
        </svg>
    </a>
</div>

<!-- Form -->
<div class="bg-white w-full my-5">
    @include('laporan-konten.form-laporan-detail')
</div>
@endsection