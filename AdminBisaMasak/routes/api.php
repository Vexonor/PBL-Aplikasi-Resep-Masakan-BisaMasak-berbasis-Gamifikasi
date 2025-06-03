<?php

use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\BahanMasakApiController;
use App\Http\Controllers\Api\KontenTutorialApiController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

// Auth
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);

Route::get('/bahan-masak', [BahanMasakApiController::class, 'index']);
Route::get('/bahan-masak/{id}', [BahanMasakApiController::class, 'show']);
Route::get('/konten-tutorial', [KontenTutorialApiController::class, 'index']);
Route::get('/stats/konten-resep', [KontenTutorialApiController::class, 'getMonthlyStats']);
