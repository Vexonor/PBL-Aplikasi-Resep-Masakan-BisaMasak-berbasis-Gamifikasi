<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Masuk Akun Admin</title>
    <link rel="icon" type="image/x-icon" href="{{ asset('asset/app-logo.png') }}">

    @vite('resources/css/app.css')
    @vite('resources/css/loader.css')
    @vite('resources/js/app.js')
</head>

<body class="bg-alabaster font-outfit">
    <!-- Loader -->
    <div class="loader-wrapper fixed top-0 left-0 bg-alabaster flex justify-center items-center w-full h-full z-[9999]">
        <div class="loader"></div>
    </div>

    <!-- ALert -->
    <div class="flex justify-center w-screen absolute">
        @include('alert.unmatch-role')
    </div>
    <div class="w-full h-screen flex justify-center items-center">
        <div class="w-1/3 h-max py-5 bg-white border-2 border-cinnabar rounded-lg flex flex-col items-center gap-2">
            <img src="{{ asset('asset/app-logo.png') }}" class="size-20 rounded-full" alt="App Logo">
            <h2 class="font-semibold text-xl">Masuk ke Admin</h2>
            <p class="text-center">
                Selamat Datang di Dashboard Admin BisaMasak!
                <br>
                Tolong Masukkan Akun Anda
            </p>
            <form action="{{ route('authenticate') }}" method="post" enctype="multipart/form-data"
                class="w-full px-4 flex flex-col gap-4">
                @csrf
                @method('POST')
                <!-- Input Email -->
                <div class="w-full">
                    <label for="input-email" class="block text-sm font-medium mb-2">Email</label>
                    <input type="email" id="input-email" name="email"
                        class="py-2.5 sm:py-3 px-4 block w-full border border-cinnabar rounded-lg sm:text-sm focus:outline-none focus-within:ring-1 focus-within:ring-cinnabar disabled:opacity-50 disabled:pointer-events-none"
                        placeholder="Masukkan email" required>
                </div>
                <!-- Input Password -->
                <div class="mb-5">
                    <label for="hs-toggle-password-with-checkbox" class="block text-sm mb-2">
                        Kata Sandi
                    </label>
                    <input id="hs-toggle-password-with-checkbox" type="password" name="password"
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
                <!-- Submit Button -->
                <button type="submit"
                    class="py-3 px-6 mt-5 inline-flex items-center justify-center gap-x-2 text-sm font-medium rounded-lg bg-cinnabar text-white disabled:opacity-50 disabled:pointer-events-none cursor-pointer">
                    Masuk
                </button>
            </form>
        </div>
    </div>
</body>

</html>