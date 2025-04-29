<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class LoginController extends Controller
{
    public function loginPage()
    {
        return view('login.login-page');
    }

    public function authenticate(Request $request)
    {

        $credentials = $request->validate([
            'email' => ['required', 'email'],
            'password' => ['required'],
        ]);

        if (Auth::attempt($credentials)) {
            $request->session()->regenerate();

            $user = Auth::user();

            if ($user->peran === 'Admin') {
                return redirect('/dashboard')->with('success', 'Berhasil masuk ke aplikasi Admin');
            } elseif ($user->peran !== 'Admin') {
                return redirect()->back()->with('unmatch', 'Anda bukan admin');
            } else {
                return redirect('/');
            }
        }

        return back()->with('error', 'Email dan Kata Sandi tidak sesuai!');
    }

    public function logout(Request $request)
    {
        Auth::logout();
        $request->session()->invalidate();

        $request->session()->regenerateToken();
        return redirect()->route('login')->with('success', 'Logout Berhasil');
    }
}
