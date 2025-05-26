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
        Schema::create('bahan_untuk_resep', function (Blueprint $table) {
            $table->id('id_bahan_resep');
            $table->foreignId('id_resep')->constrained('konten_resep', 'id_resep')->onDelete('cascade');
            $table->foreignId('id_bahan')->constrained('bahan_masak', 'id_bahan')->onDelete('cascade');
            $table->string('jumlah_bahan');
            $table->enum('satuan_bahan', [
                'g',
                'kg',
                'ml',
                'L',
                'cm',
                'sdt',
                'sdm',
                'cup',
                'buah',
                'butir',
                'siung',
                'batang',
                'lembar',
                'potong',
                'sejumput',
                'secukupnya'
            ]);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('bahan_untuk_resep');
    }
};
