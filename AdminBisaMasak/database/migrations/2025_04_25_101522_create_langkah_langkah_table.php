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
        Schema::create('langkah_langkah', function (Blueprint $table) {
            $table->id('id_langkah');
            $table->foreignId('id_resep')->constrained('konten_resep', 'id_resep')->onDelete('cascade');
            $table->integer('nomor_langkah');
            $table->longText('deskripsi_langkah');
            $table->string('gambar_langkah');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('langkah_langkah');
    }
};
