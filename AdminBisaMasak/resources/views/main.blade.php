<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{{ $title }}</title>
    <link rel="icon" type="image/x-icon" href="{{ asset('asset/app-logo.png') }}">
    @vite('resources/css/app.css')
    @vite('resources/js/app.js')
</head>

<body class="font-outfit bg-alabaster flex w-screen overflow-x-hidden">
    <aside>
        @include('components.sidebar')
    </aside>
    <div class="flex flex-1 flex-col w-full">
        <header>
            @include('components.header')
        </header>
        <main class="m-5">
            @yield('main-content')
        </main>
    </div>
</body>

</html>