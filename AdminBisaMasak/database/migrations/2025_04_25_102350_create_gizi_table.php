<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('gizi', function (Blueprint $table) {
            $table->id('id_gizi');
            $table->foreignId('id_bahan')->nullable()->constrained('bahan_masak', 'id_bahan')->onDelete('cascade');
            $table->foreignId('id_resep')->nullable()->constrained('konten_resep', 'id_resep')->onDelete('cascade');
            $table->enum('nama_gizi', [
                'Energi',
                'Karbohidrat',
                'Protein',
                'Lemak',
                'Serat',
                'Gula',
                'Natrium',
                'Kalsium',
                'Zat Besi',
                'Vitamin A',
                'Vitamin B1',
                'Vitamin B2',
                'Vitamin B3',
                'Vitamin B6',
                'Vitamin B12',
                'Vitamin C',
                'Vitamin D',
                'Vitamin E',
                'Vitamin K',
                'Kolesterol'
            ]);
            $table->decimal('jumlah')->default(0);
            $table->enum('satuan', [
                'mg',
                'g',
                'µg',
                'kcal',
                'IU',
                'ml',
                'L',
                '%'
            ]);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('gizi');
    }
};
