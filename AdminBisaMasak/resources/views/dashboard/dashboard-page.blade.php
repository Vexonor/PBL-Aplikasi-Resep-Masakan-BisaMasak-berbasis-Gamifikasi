@extends('main')

@section('main-content')
<!-- Title -->
<h1 class="text-charcoal text-2xl font-medium my-5">
    {{ $title }}
</h1>


<div class="flex flex-wrap gap-4">
    <div class="flex flex-wrap max-w-[45rem] gap-2">
        <!-- Highlight Card -->
        <div class="flex flex-auto gap-3 w-full">
            @include('dashboard.highlight-card')
        </div>

        <!-- Content Confirmation -->
        <div class="bg-white w-full h-[30rem] rounded-xl p-5">
            <h1
                class="text-xl font-medium flex items-center text-charcoal after:flex-1 after:border-t after:border-charcoal after:ms-6">
                Konfirmasi Konten
            </h1>

            @include('dashboard.confirmation-table')
        </div>
    </div>
    <!-- Report Section -->
    <div class="bg-white flex-1 h-svh rounded-xl p-5">
        <h1
            class="text-xl font-medium flex items-center text-charcoal after:flex-1 after:border-t after:border-charcoal after:ms-6">
            Laporan Konten
        </h1>

        <div class="flex flex-col my-2 gap-2">
            @include('dashboard.report-section')
            @include('dashboard.report-section')
        </div>
    </div>
</div>

@endsection