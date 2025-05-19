<!-- Sidebar -->
<div id="hs-sidebar-basic-usage"
    class="hs-overlay [--auto-close:lg] lg:block lg:translate-x-0 lg:end-auto lg:bottom-0 w-64 hs-overlay-open:translate-x-0 -translate-x-full transition-all duration-300 transform h-full hidden top-0 start-0 bottom-0 z-60 bg-white border-e border-gray-200"
    role="dialog" tabindex="-1" aria-label="Sidebar">
    <div class="relative flex flex-col h-full max-h-full ">
        <!-- Header -->
        <header class="p-4 flex justify-between items-center gap-x-2">
            <a class="flex justify-center items-center gap-2 font-semibold text-xl text-black focus:outline-hidden focus:opacity-80"
                href="#" aria-label="Brand">
                <img src="{{ asset('asset/app-logo.png') }}" alt="BisaMasak Logo"
                    class="size-16 rounded-xl object-cover object-center">
                BisaMasak
            </a>

            <div class="lg:hidden -me-2">
                <!-- Close Button -->
                <button type="button"
                    class="flex justify-center items-center gap-x-3 size-6 bg-white border border-gray-200 text-sm text-gray-600 hover:bg-gray-100 rounded-full disabled:opacity-50 disabled:pointer-events-none focus:outline-hidden focus:bg-gray-100 dark:bg-neutral-800 dark:border-neutral-700 dark:text-neutral-400 dark:hover:bg-neutral-700 dark:focus:bg-neutral-700 dark:hover:text-neutral-200 dark:focus:text-neutral-200"
                    data-hs-overlay="#hs-sidebar-basic-usage">
                    <svg class="shrink-0 size-4" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                        viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                        stroke-linejoin="round">
                        <path d="M18 6 6 18" />
                        <path d="m6 6 12 12" />
                    </svg>
                    <span class="sr-only">Close</span>
                </button>
                <!-- End Close Button -->
            </div>
        </header>
        <!-- End Header -->

        <!-- Body -->
        <nav
            class="h-full overflow-y-auto [&::-webkit-scrollbar]:w-2 [&::-webkit-scrollbar-thumb]:rounded-full [&::-webkit-scrollbar-track]:bg-gray-100 [&::-webkit-scrollbar-thumb]:bg-gray-300 dark:[&::-webkit-scrollbar-track]:bg-neutral-700 dark:[&::-webkit-scrollbar-thumb]:bg-neutral-500">
            <div class=" pb-0 px-2  w-full flex flex-col flex-wrap">
                <ul class="space-y-1">
                    <!-- Dashboard -->
                    <li>
                        <a class="flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Dashboard' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/dashboard">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M222.14,105.85l-80-80a20,20,0,0,0-28.28,0l-80,80A19.86,19.86,0,0,0,28,120v96a12,12,0,0,0,12,12h64a12,12,0,0,0,12-12V164h24v52a12,12,0,0,0,12,12h64a12,12,0,0,0,12-12V120A19.86,19.86,0,0,0,222.14,105.85ZM204,204H164V152a12,12,0,0,0-12-12H104a12,12,0,0,0-12,12v52H52V121.65l76-76,76,76Z">
                                </path>
                            </svg>
                            Dashboard
                        </a>
                    </li>
                    <!-- Tutorial Content -->
                    <li>
                        <a class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Konten Tutorial' || $title == 'Tambah Konten Tutorial' || $title == 'Detail Konten Tutorial' || $title == 'Edit Konten Tutorial' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/konten-tutorial">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M244,112a60.07,60.07,0,0,0-60-60c-1,0-1.95,0-2.92.08a60,60,0,0,0-106.16,0C74,52,73,52,72,52A60,60,0,0,0,44,165v43a20,20,0,0,0,20,20H192a20,20,0,0,0,20-20V165A60,60,0,0,0,244,112Zm-56,92H68V171.85c1.32.09,2.65.15,4,.15H184c1.35,0,2.68-.06,4-.15Zm-4-56h-8.63l4.27-17.09a12,12,0,0,0-23.28-5.82L150.63,148H140V128a12,12,0,0,0-24,0v20H105.37l-5.73-22.91a12,12,0,1,0-23.28,5.82L80.63,148H72a36,36,0,0,1-3.87-71.79C68.05,77.47,68,78.73,68,80a12,12,0,0,0,24,0,36,36,0,0,1,72,0,12,12,0,0,0,24,0c0-1.27-.05-2.53-.13-3.79A36,36,0,0,1,184,148Z">
                                </path>
                            </svg>
                            Konten Tutorial
                        </a>
                    </li>
                    <!-- Ingredients -->
                    <li>
                        <a class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Bahan Masak' || $title == 'Tambah Bahan Masak' || $title == 'Detail Bahan Masak' || $title == 'Edit Bahan Masak' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/bahan-masak">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M232,60H213l19.51-19.51a12,12,0,1,0-17-17L196,43V24a12,12,0,0,0-24,0V50A68,68,0,0,0,96,63.87l0,0h0l0,0C55.45,103.68,25.18,197,21.78,207.77A20,20,0,0,0,40,236a20.12,20.12,0,0,0,8.24-1.78c7.64-2.42,56.79-18.34,98.91-41.82l.54-.3c17.1-9.57,33-20.39,44.44-32A68,68,0,0,0,206,84h26a12,12,0,0,0,0-24Zm-56.89,83.12-.09.09c-8.11,8.28-19.11,16.2-31.33,23.52l-23.21-23.21a12,12,0,1,0-17,17l18.22,18.22c-30.29,15.17-62.13,26.42-75.26,30.82,6.77-20.22,29.79-84.8,58.34-119.74l30.7,30.7a12,12,0,1,0,17-17L122.54,73.58a44,44,0,0,1,52.57,69.54Z">
                                </path>
                            </svg>
                            Bahan Masak
                        </a>
                    </li>
                    <!-- Content Confirmation -->
                    <li>
                        <a class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Konfirmasi Konten' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/konfirmasi-konten">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M228,48V208a20,20,0,0,1-20,20H140a12,12,0,0,1,0-24h64V52H52v88a12,12,0,0,1-24,0V48A20,20,0,0,1,48,28H208A20,20,0,0,1,228,48ZM128.49,151.51a12,12,0,0,0-17,0L64,199,48.49,183.51a12,12,0,1,0-17,17l24,24a12,12,0,0,0,17,0l56-56A12,12,0,0,0,128.49,151.51Z">
                                </path>
                            </svg>
                            Konfirmasi Konten
                        </a>
                    </li>
                    <!-- Report Content -->
                    <li>
                        <a class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Laporan Konten' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/laporan-konten">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M172,164a12,12,0,0,1-12,12H96a12,12,0,0,1,0-24h64A12,12,0,0,1,172,164Zm-12-52H96a12,12,0,0,0,0,24h64a12,12,0,0,0,0-24Zm60-64V216a20,20,0,0,1-20,20H56a20,20,0,0,1-20-20V48A20,20,0,0,1,56,28H90.53a51.88,51.88,0,0,1,74.94,0H200A20,20,0,0,1,220,48ZM100.29,60h55.42a28,28,0,0,0-55.42,0ZM196,52H178.59A52.13,52.13,0,0,1,180,64v8a12,12,0,0,1-12,12H88A12,12,0,0,1,76,72V64a52.13,52.13,0,0,1,1.41-12H60V212H196Z">
                                </path>
                            </svg>
                            Laporan Konten
                        </a>
                    </li>
                    <!-- Manage Admin -->
                    <li>
                        <a class="w-full flex items-center gap-x-3.5 py-2 px-2.5 text-sm {{ $title == 'Admin' || $title == 'Tambah Admin' ? 'bg-cinnabar text-white' : 'text-charcoal hover:bg-cinnabar/50' }} rounded-lg focus:outline-hidden"
                            href="/admin">
                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                viewBox="0 0 256 256">
                                <path
                                    d="M125.18,156.94a64,64,0,1,0-82.36,0,100.23,100.23,0,0,0-39.49,32,12,12,0,0,0,19.35,14.2,76,76,0,0,1,122.64,0,12,12,0,0,0,19.36-14.2A100.33,100.33,0,0,0,125.18,156.94ZM44,108a40,40,0,1,1,40,40A40,40,0,0,1,44,108Zm206.1,97.67a12,12,0,0,1-16.78-2.57A76.31,76.31,0,0,0,172,172a12,12,0,0,1,0-24,40,40,0,1,0-10.3-78.67,12,12,0,1,1-6.16-23.19,64,64,0,0,1,57.64,110.8,100.23,100.23,0,0,1,39.49,32A12,12,0,0,1,250.1,205.67Z">
                                </path>
                            </svg>
                            Admin
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- End Body -->
    </div>
</div>
<!-- End Sidebar -->