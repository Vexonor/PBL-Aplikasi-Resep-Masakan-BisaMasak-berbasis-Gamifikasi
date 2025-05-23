@extends('main')

@section('main-content')
<div class="flex flex-wrap gap-4 h-svh">
    <div class="flex flex-col flex-2 gap-2">
        <!-- Highlight Card -->
        <div class="flex flex-wrap gap-3 w-full">
            @include('dashboard.highlight-card')
        </div>

        <!-- Content Confirmation -->
        <div class="bg-white w-full h-full rounded-xl p-5">
            <h1
                class="text-xl font-medium flex items-center text-charcoal after:flex-1 after:border-t after:border-charcoal after:ms-6">
                Statistik Upload Resep Bulanan
            </h1>

            @include('dashboard.chart')
        </div>
    </div>

</div>

@endsection