<?php

use App\Http\Controllers\AdminController;
use App\Http\Controllers\BahanMasakController;
use App\Http\Controllers\DashboardController;
use App\Http\Controllers\KonfirmasiKontenController;
use App\Http\Controllers\KontenTutorialController;
use App\Http\Controllers\LaporanKontenController;
use App\Http\Controllers\LoginController;
use App\Http\Middleware\RoleMiddleware;
use Illuminate\Support\Facades\Route;

// Auth
Route::get('/', [LoginController::class, 'loginPage'])->name('login');
Route::post('authenticate', [LoginController::class, 'authenticate'])->name('authenticate');
Route::post('logout', [LoginController::class, 'logout'])->name('logout');

// Admin
Route::middleware(['auth'])->group(function () {
    // General Page
    Route::resource('/dashboard', DashboardController::class);
    Route::resource('/konten-tutorial', KontenTutorialController::class);
    Route::resource('/bahan-masak', BahanMasakController::class);
    Route::resource('/konfirmasi-konten', KonfirmasiKontenController::class);
    Route::resource('/laporan-konten', LaporanKontenController::class);
    Route::resource('/admin', AdminController::class);
});
