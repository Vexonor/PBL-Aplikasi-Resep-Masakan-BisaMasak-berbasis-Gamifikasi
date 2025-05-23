<?php

use App\Http\Controllers\Api\BahanMasakApiController;
use App\Http\Controllers\Api\KontenTutorialApiController;
use App\Http\Middleware\ApiAuthMiddleware;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/bahan-masak', [BahanMasakApiController::class, 'index']);
Route::get('/konten-tutorial', [KontenTutorialApiController::class, 'index']);
Route::get('/stats/konten-resep', [KontenTutorialApiController::class, 'getMonthlyStats']);
