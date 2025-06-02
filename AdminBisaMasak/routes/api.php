<?php

use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\BahanMasakApiController;
use App\Http\Controllers\Api\KontenTutorialApiController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Storage;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/storage/{path}', function ($path) {
    $file = Storage::disk('public')->path($path);
    if (!file_exists($file)) {
        abort(404);
    }
    return response()->file($file);
})->where('path', '.*');

// Auth
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);

Route::get('/bahan-masak', [BahanMasakApiController::class, 'index']);
Route::get('/konten-tutorial', [KontenTutorialApiController::class, 'index']);
Route::get('/stats/konten-resep', [KontenTutorialApiController::class, 'getMonthlyStats']);
