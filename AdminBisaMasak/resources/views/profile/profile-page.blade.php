@extends('main')

@section('main-content')
<div class="flex justify-start w-full h-svh pr-5">
    <div class="bg-white flex flex-col gap-4 w-full h-max rounded-md p-5">
        @include('profile.photo-profile')
        @include('profile.form-edit')
    </div>
</div>

@include('profile.password-modal')
@endsection