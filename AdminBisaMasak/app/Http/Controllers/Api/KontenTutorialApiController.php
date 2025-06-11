<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\KontenResepModel;
use DateTime;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class KontenTutorialApiController extends Controller
{
    public function index()
    {
        $data = KontenResepModel::with('BahanResepTable.BahanMasakTable', 'GiziTable', 'LangkahLangkahTable',)->get();
        return response()->json($data);
    }

    public function getMonthlyStats()
    {
        $rawStats = KontenResepModel::select(
            DB::raw('MONTH(created_at) as month'),
            'status_konten',
            DB::raw('COUNT(*) as total')
        )
            ->whereYear('created_at', date('Y'))
            ->groupBy('month', 'status_konten')
            ->orderBy('month')
            ->get();

        $statuses = KontenResepModel::select('status_konten')->distinct()->pluck('status_konten')->toArray();
        $result = [];

        for ($i = 1; $i <= 12; $i++) {
            $monthName = DateTime::createFromFormat('!m', $i)->format('F');
            $monthData = ['month' => $monthName];

            foreach ($statuses as $status) {
                $match = $rawStats->firstWhere(fn($item) => $item->month == $i && $item->status_konten == $status);
                $monthData[$status] = $match ? $match->total : 0;
            }

            $result[] = $monthData;
        }

        return response()->json($result);
    }

    public function search(Request $request)
    {
        $query = $request->input('q');
        $keywords = explode(' ', strtolower($query));

        $result = KontenResepModel::with(['BahanResepTable.BahanMasakTable'])
            ->judulKonten($keywords)
            ->get();

        return response()->json($result);
    }
}
