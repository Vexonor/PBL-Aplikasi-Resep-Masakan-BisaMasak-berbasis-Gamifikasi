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
        Schema::create('konten_resep', function (Blueprint $table) {
            $table->id('id_resep');
            $table->foreignId('id_user')->constrained('users', 'id_user')->onDelete('cascade');
            $table->string('judul_konten');
            $table->longText('deskripsi_konten');
            $table->string('thumbnail');
            $table->string('video_tutorial')->nullable();
            $table->enum('status_konten', [
                'Draf',
                'Terunggah',
                'Terblokir'
            ])->default('Draf');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('konten_resep');
    }
};
