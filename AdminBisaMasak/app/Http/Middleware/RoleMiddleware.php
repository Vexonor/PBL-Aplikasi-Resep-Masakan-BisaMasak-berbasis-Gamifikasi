<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class RoleMiddleware
{
    public function handle(Request $request, Closure $next, string $role)
    {
        if (!Auth::check()) {
            return redirect()->route('login')->with('error', 'Anda harus login terlebih dahulu.');
        }

        $user = Auth::user();
        // Pastikan pengguna memiliki relasi admin jika diperlukan
        if ($role === 'Master Admin' || $role === 'Admin') {
            if (!$user->AdminTable || $user->AdminTable->peran_admin !== $role) {
                return back()->with('error', 'Anda tidak memiliki akses admin ke halaman ini.');
            }
        } elseif ($user->role !== $role) {
            // Periksa role lainnya
            return back()->with('error', 'Anda tidak memiliki akses ke halaman ini.');
        }

        return $next($request);
    }
}
