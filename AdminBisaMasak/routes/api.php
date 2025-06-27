<?php

use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\BahanMasakApiController;
use App\Http\Controllers\Api\KomentarApiController;
use App\Http\Controllers\Api\KontenTutorialApiController;
use App\Http\Controllers\Api\LaporanKontenApiController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

// Auth
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);

// Ingredient
Route::get('/bahan-masak', [BahanMasakApiController::class, 'index']);
Route::get('/bahan-masak/{id}', [BahanMasakApiController::class, 'show']);

// Recipe Content
Route::get('/konten-tutorial', [KontenTutorialApiController::class, 'index']);
Route::get('/search', [KontenTutorialApiController::class, 'search']);
Route::get('/stats/konten-resep', [KontenTutorialApiController::class, 'getMonthlyStats']);
Route::post('/konten-tutorial', [KontenTutorialApiController::class, 'storeRecipe']);
Route::get('/resep/{id}', [KontenTutorialApiController::class, 'show']);
Route::patch('konten-tutorial/{id}/status', [KontenTutorialApiController::class, 'updateStatus']);
Route::post('konten-tutorial/{id}/update', [KontenTutorialApiController::class, 'updateRecipe']);
Route::delete('/konten-resep/{id}', [KontenTutorialApiController::class, 'destroy']);

// Report Content
Route::post('/laporan-konten', [LaporanKontenApiController::class, 'storeLaporan']);

// Comment
Route::get('/komentar', [KomentarApiController::class, 'index']);
Route::get('komentar/resep/{id_resep}', [KomentarApiController::class, 'getByRecipeId']);
Route::post('/komentar', [KomentarApiController::class, 'store']);
Route::delete('/komentar/{id}', [KomentarApiController::class, 'destroy']);
