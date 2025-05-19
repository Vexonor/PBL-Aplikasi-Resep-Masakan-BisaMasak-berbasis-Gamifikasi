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
        Schema::create('bahan_masak', function (Blueprint $table) {
            $table->id('id_bahan');
            $table->string('nama_bahan');
            $table->longText('deskripsi_bahan');
            $table->longText('gambar_bahan');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('bahan_masak');
    }
};
