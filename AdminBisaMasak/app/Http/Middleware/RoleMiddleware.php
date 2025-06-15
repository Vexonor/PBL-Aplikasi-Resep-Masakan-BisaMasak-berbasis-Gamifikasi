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
        if ($role === 'Master Admin' || $role === 'Admin') {
            if (!$user->AdminTable) {
                return back()->with('error', 'Anda tidak memiliki akses admin ke halaman ini.');
            }
        } elseif ($user->role !== $role) {
            return back()->with('error', 'Anda tidak memiliki akses ke halaman ini.');
        }

        return $next($request);
    }
}
