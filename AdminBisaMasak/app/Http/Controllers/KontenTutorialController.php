<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class KontenTutorialController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return view('konten-tutorial.konten-tutorial-page', [
            "title" => "Konten Tutorial"
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('konten-tutorial.tambah-konten-page', [
            "title" => "Tambah Konten Tutorial"
        ]);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        return view('konten-tutorial.edit-konten-page', [
            "title" => "Edit Konten Tutorial"
        ]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
