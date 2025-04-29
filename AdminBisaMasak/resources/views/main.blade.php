<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{{ $title }}</title>
    <link rel="icon" type="image/x-icon" href="{{ asset('asset/app-logo.png') }}">

    @vite('resources/css/app.css')
    @vite('resources/css/loader.css')
    @vite('resources/js/app.js')
</head>

<body class="font-outfit bg-gray-100 flex w-screen overflow-x-hidden">
    <!-- Loader -->
    <div class="loader-wrapper fixed top-0 left-0 bg-alabaster flex justify-center items-center w-full h-full z-[9999]">
        <div class="loader"></div>
    </div>

    <!-- Alert -->
    <div class="flex justify-center w-full absolute">
        @include('alert.success')
    </div>
    <aside>
        @include('components.sidebar')
    </aside>
    <div class="flex flex-1 flex-col w-full">
        <header>
            @include('components.header')
        </header>
        <main class="m-5">
            <!-- Title -->
            <h1 class="text-charcoal text-2xl font-medium my-5">
                {{ $title }}
            </h1>

            @yield('main-content')
        </main>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/flowbite@3.1.2/dist/flowbite.min.js"></script>
    @include('script.script-form')
</body>

</html>