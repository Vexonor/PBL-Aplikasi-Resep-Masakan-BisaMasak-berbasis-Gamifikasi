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
        Schema::create('simpan_resep', function (Blueprint $table) {
            $table->id("id_simpan");
            $table->foreignId('id_resep')->constrained('konten_resep', 'id_resep')->onDelete('cascade');
            $table->foreignId('id_user')->constrained('users', 'id_user')->onDelete('cascade');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('simpan_resep');
    }
};
