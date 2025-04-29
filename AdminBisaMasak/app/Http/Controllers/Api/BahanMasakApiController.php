<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\BahanMasakModel;
use Illuminate\Http\Request;

class BahanMasakApiController extends Controller
{
    public function index()
    {
        $data = BahanMasakModel::all();
        return response()->json($data);
    }
}
