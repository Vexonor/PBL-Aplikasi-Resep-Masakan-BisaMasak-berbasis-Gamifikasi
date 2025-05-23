@extends('main')

@section('main-content')
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

    <li class="inline-flex items-center">
        <a class="flex items-center text-sm text-gray-500 hover:text-cinnabar focus:outline-hidden focus:text-cinnabar"
            href="{{ route('laporan-konten.edit', $resepId) }}">
            Detail Laporan
        </a>
        <svg class="shrink-0 mx-2 size-4 text-gray-400" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
            viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
            stroke-linejoin="round">
            <path d="m9 18 6-6-6-6"></path>
        </svg>
    </li>

    <li class="inline-flex items-center">
        <a class="flex items-center text-sm text-gray-500 hover:text-cinnabar focus:outline-hidden focus:text-cinnabar"
            href="/konten-tutorial">
            Konten Tutorial
        </a>
        <svg class="shrink-0 mx-2 size-4 text-gray-400" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
            viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
            stroke-linejoin="round">
            <path d="m9 18 6-6-6-6"></path>
        </svg>
    </li>

    <li class="inline-flex items-center text-sm font-semibold text-gray-800 truncate" aria-current="page">
        Detail Konten Tutorial
    </li>
</ol>

<!-- Form -->
<div class="bg-white w-full my-5">
    @include('laporan-konten.form-detail')
</div>
@endsection