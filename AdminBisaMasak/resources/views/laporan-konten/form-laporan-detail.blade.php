<form action="" class="flex flex-col gap-4 p-5" method="post" enctype="multipart/form-data">
    <div class="space-y-4">
        @forelse ($laporanKonten as $index => $laporan)
        <div class="bg-white p-4 rounded-lg shadow">
            <label for="laporan-{{ $index }}" class="block text-sm font-medium text-gray-700 mb-2">
                Laporan #{{ $index + 1 }}
            </label>
            <textarea id="laporan-{{ $index }}" name="deskripsi_laporan[]"
                class="py-2 px-3 block w-full border border-gray-300 rounded-lg text-sm focus:outline-none focus:ring-2 focus:ring-cinnabar focus:border-transparent"
                rows="3" readonly>{{ $laporan->deskripsi_laporan }}</textarea>
            <p class="text-xs text-gray-500 mt-1">Dilaporkan pada: {{ $laporan->created_at->format('d M Y H:i') }}</p>
        </div>
        @empty
        <div class="bg-white p-4 rounded-lg shadow text-center">
            <p class="text-gray-500">Belum ada laporan untuk resep ini</p>
        </div>
        @endforelse
    </div>
</form>