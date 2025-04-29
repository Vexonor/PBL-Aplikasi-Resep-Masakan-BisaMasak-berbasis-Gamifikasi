<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

class BahanMasakFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nama_bahan' => fake()->word(),
            'deskripsi_bahan' => fake()->paragraph(),
            'gambar_bahan' => fake()->imageUrl(640, 480, 'food', true),
            'terbuka_di_level' => fake()->numberBetween(1, 10),
        ];
    }
}
