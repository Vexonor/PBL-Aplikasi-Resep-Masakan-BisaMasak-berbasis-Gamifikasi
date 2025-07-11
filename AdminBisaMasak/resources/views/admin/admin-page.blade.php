@extends('main')

@section('main-content')
<div class="flex justify-between items-center gap-4 w-full">
    <!-- Search Bar -->
    <div class="relative flex-1">
        <form>
            <input type="search" id="search" name="search"
                class="peer py-2.5 sm:py-3 pe-0 ps-8 block w-full bg-transparent border-2 border-cinnabar rounded-lg sm:text-sm focus:ring-0 focus:outline-none disabled:opacity-50 disabled:pointer-events-none"
                placeholder="Cari admin..." autocomplete="off">
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

    <!-- Add Button -->
    <a href="{{ route('admin.create') }}"
        class="py-3 px-4 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border-2 border-cinnabar text-cinnabar hover:bg-cinnabar hover:text-white focus:outline-hidden focus:border-cinnabar focus:text-cinnabar disabled:opacity-50 disabled:pointer-events-none cursor-pointer transition-all delay-200">
        <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor" viewBox="0 0 256 256">
            <path
                d="M224,128a8,8,0,0,1-8,8H136v80a8,8,0,0,1-16,0V136H40a8,8,0,0,1,0-16h80V40a8,8,0,0,1,16,0v80h80A8,8,0,0,1,224,128Z">
            </path>
        </svg>
        Tambah Admin
    </a>
</div>

<div class="w-full min-h-screen bg-white p-5 my-5">
    @if ($dataAdmin -> isEmpty())
    <div class="w-full flex flex-col justify-center items-center gap-4 my-4">
        <img src="{{ asset('/asset/empty-query.svg') }}" class="size-60" alt="Empty Asset">
        <h2 class="font-semibold text-xl">Admin tidak terdaftar di sistem.</h2>
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
                                    Nama Admin</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Email</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Peran</th>
                                <th scope="col" class="px-6 py-3 text-center text-xs font-medium uppercase">
                                    Aksi</th>
                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($dataAdmin as $key => $admin)
                            <tr class="border border-cinnabar divide-x divide-cinnabar text-charcoal text-center">
                                <td class="px-1 py-4 whitespace-nowrap text-sm font-medium">
                                    {{ $key + 1 }}.
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm capitalize">
                                    {{ $admin -> UserTable -> nama }}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm">
                                    {{ $admin -> UserTable -> email }}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm">
                                    {{ $admin -> peran_admin }}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-end text-sm">
                                    <div class="flex justify-evenly items-center gap-4">
                                        <a href="{{ route('admin.edit', $admin -> id_admin) }}">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                                viewBox="0 0 256 256">
                                                <path
                                                    d="M227.32,73.37,182.63,28.69a16,16,0,0,0-22.63,0L36.69,152A15.86,15.86,0,0,0,32,163.31V208a16,16,0,0,0,16,16H216a8,8,0,0,0,0-16H115.32l112-112A16,16,0,0,0,227.32,73.37ZM92.69,208H48V163.31l88-88L180.69,120ZM192,108.69,147.32,64l24-24L216,84.69Z">
                                                </path>
                                            </svg>
                                        </a>
                                        <a href="{{ route('admin.show', $admin -> id_admin) }}">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                                viewBox="0 0 256 256">
                                                <path
                                                    d="M128,24A104,104,0,1,0,232,128,104.11,104.11,0,0,0,128,24Zm0,192a88,88,0,1,1,88-88A88.1,88.1,0,0,1,128,216Zm16-40a8,8,0,0,1-8,8,16,16,0,0,1-16-16V128a8,8,0,0,1,0-16,16,16,0,0,1,16,16v40A8,8,0,0,1,144,176ZM112,84a12,12,0,1,1,12,12A12,12,0,0,1,112,84Z">
                                                </path>
                                            </svg>
                                        </a>
                                        <button type="button" data-modal-target="popup-modal{{ $admin -> id_admin }}"
                                            data-modal-toggle="popup-modal{{ $admin -> id_admin }}">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="size-6" fill="currentColor"
                                                viewBox="0 0 256 256">
                                                <path
                                                    d="M216,48H176V40a24,24,0,0,0-24-24H104A24,24,0,0,0,80,40v8H40a8,8,0,0,0,0,16h8V208a16,16,0,0,0,16,16H192a16,16,0,0,0,16-16V64h8a8,8,0,0,0,0-16ZM96,40a8,8,0,0,1,8-8h48a8,8,0,0,1,8,8v8H96Zm96,168H64V64H192ZM112,104v64a8,8,0,0,1-16,0V104a8,8,0,0,1,16,0Zm48,0v64a8,8,0,0,1-16,0V104a8,8,0,0,1,16,0Z">
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
        {{ $dataAdmin -> links() }}
    </div>
</div>

@include('admin.delete-modal')
@endsection