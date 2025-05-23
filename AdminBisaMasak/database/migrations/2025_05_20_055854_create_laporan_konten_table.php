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
        Schema::create('laporan_konten', function (Blueprint $table) {
            $table->id('id_laporan');
            $table->foreignId('id_resep')->constrained('konten_resep', 'id_resep')->onDelete('cascade');
            $table->longText('deskripsi_laporan');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('laporan_konten');
    }
};
