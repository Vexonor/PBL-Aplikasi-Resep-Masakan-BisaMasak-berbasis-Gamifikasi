<?php

namespace Database\Seeders;

use Illuminate\Support\Facades\DB;
use Illuminate\Database\Seeder;

class BahanMasakSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $bahanMasak = [
            [
                'nama_bahan' => 'Bawang Merah',
                'deskripsi_bahan' => 'Bawang merah digunakan sebagai bumbu dasar dalam banyak masakan Indonesia.',
                'gambar_bahan' => 'https://jambi28.tv/wp-content/uploads/2025/01/2-3.jpg',
            ],
            [
                'nama_bahan' => 'Bawang Putih',
                'deskripsi_bahan' => 'Bawang putih memberikan aroma kuat dan khas pada masakan.',
                'gambar_bahan' => 'https://masjidzayedsolo.or.id/wp-content/uploads/2023/12/bawang-putih.jpg',
            ],
            [
                'nama_bahan' => 'Cabai Merah',
                'deskripsi_bahan' => 'Cabai merah memberi rasa pedas dan warna merah pada masakan.',
                'gambar_bahan' => 'https://image.astronauts.cloud/product-images/2024/11/CabeMerahBesar1_d7b25226-3b3f-4d68-9c35-02a599fdf73b_900x900.png',
            ],
            [
                'nama_bahan' => 'Cabai Rawit',
                'deskripsi_bahan' => 'Cabai rawit lebih pedas dan sering digunakan dalam sambal.',
                'gambar_bahan' => 'https://cdn.rri.co.id/berita/Madiun/o/1734320196172-cabe_rawit/g13wicex21ervsg.jpeg',
            ],
            [
                'nama_bahan' => 'Tomat',
                'deskripsi_bahan' => 'Tomat digunakan untuk memberikan rasa segar dan sedikit asam.',
                'gambar_bahan' => 'https://umsu.ac.id/artikel/wp-content/uploads/2023/09/manfaat-tomat-buah-segar-yang-penuh-nutrisi.jpg',
            ],
            [
                'nama_bahan' => 'Jahe',
                'deskripsi_bahan' => 'Jahe memiliki aroma dan rasa hangat, sering digunakan dalam masakan dan minuman.',
                'gambar_bahan' => 'https://mysiloam-api.siloamhospitals.com/public-asset/website-cms/website-cms-16933694025013188.webp',
            ],
            [
                'nama_bahan' => 'Lengkuas',
                'deskripsi_bahan' => 'Lengkuas memiliki aroma khas dan sering digunakan dalam gulai atau rendang.',
                'gambar_bahan' => 'https://desagrogol.gunungkidulkab.go.id/assets/files/dokumen/LENGKUAS.jpg',
            ],
            [
                'nama_bahan' => 'Kunyit',
                'deskripsi_bahan' => 'Kunyit memberi warna kuning dan aroma khas dalam masakan.',
                'gambar_bahan' => 'https://res.cloudinary.com/dk0z4ums3/image/upload/v1683291053/attached_image/7-manfaat-kunyit-untuk-kulit-yang-jarang-diketahui.jpg',
            ],
            [
                'nama_bahan' => 'Serai',
                'deskripsi_bahan' => 'Serai memberikan aroma segar dan sering dipakai dalam sup dan gulai.',
                'gambar_bahan' => 'https://desagrogol.gunungkidulkab.go.id/assets/files/artikel/sedang_1724401799SEREH.jpg',
            ],
            [
                'nama_bahan' => 'Daun Salam',
                'deskripsi_bahan' => 'Daun salam digunakan untuk menambah aroma dalam masakan berkuah.',
                'gambar_bahan' => 'https://cdn.rri.co.id/berita/Mamuju/o/1723340074253-daun-salamjpg-20230706041146/9kotf02h8x4mx57.jpeg',
            ],
            [
                'nama_bahan' => 'Daun Jeruk',
                'deskripsi_bahan' => 'Daun jeruk digunakan untuk memberikan aroma segar pada masakan.',
                'gambar_bahan' => 'https://asset.kompas.com/crops/tDdrWzQmBZKk-eN5hJ1O71eyVXI=/0x0:1000x667/1200x800/data/photo/2021/08/28/6129bd3937b04.jpg',
            ],
            [
                'nama_bahan' => 'Kemiri',
                'deskripsi_bahan' => 'Kemiri digunakan untuk mengentalkan dan memberi rasa gurih pada masakan.',
                'gambar_bahan' => 'https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/10/11044054/Mengenal-Manfaat-Kemiri-untuk-Kesehatan-Tubuh.jpg',
            ],
            [
                'nama_bahan' => 'Kecap Manis',
                'deskripsi_bahan' => 'Kecap manis digunakan untuk menambah rasa manis dan warna gelap pada masakan.',
                'gambar_bahan' => 'https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full/catalog-image/99/MTA-157416732/abc_abc-kecap-manis-135ml_full01.jpg',
            ],
            [
                'nama_bahan' => 'Garam',
                'deskripsi_bahan' => 'Garam merupakan bahan utama untuk menambah rasa asin.',
                'gambar_bahan' => 'https://png.pngtree.com/png-clipart/20230714/ourlarge/pngtree-fine-sea-salt-png-image_7507558.png',
            ],
            [
                'nama_bahan' => 'Gula Pasir',
                'deskripsi_bahan' => 'Gula pasir menambahkan rasa manis dan bisa menyeimbangkan rasa.',
                'gambar_bahan' => 'https://png.pngtree.com/png-clipart/20220130/original/pngtree-white-sand-sugar-commercially-available-element-material-png-image_7241019.png',
            ],
            [
                'nama_bahan' => 'Minyak Goreng',
                'deskripsi_bahan' => 'Digunakan untuk menggoreng atau menumis bahan makanan.',
                'gambar_bahan' => 'https://c.alfagift.id/product/1/1_A09350001879_20211001113946725_base.jpg',
            ],
            [
                'nama_bahan' => 'Tepung Terigu',
                'deskripsi_bahan' => 'Tepung terigu digunakan sebagai bahan dasar adonan makanan.',
                'gambar_bahan' => 'https://c.alfagift.id/product/1/1_A28090001915_20220829102607550_base.jpg',
            ],
            [
                'nama_bahan' => 'Telur Ayam',
                'deskripsi_bahan' => 'Telur digunakan dalam banyak resep sebagai bahan utama atau tambahan.',
                'gambar_bahan' => 'https://nilaigizi.com/assets/images/produk/produk_1535867340.png',
            ],
            [
                'nama_bahan' => 'Ayam',
                'deskripsi_bahan' => 'Ayam merupakan sumber protein utama dan digunakan dalam berbagai masakan.',
                'gambar_bahan' => 'https://www.sinarpahalautama.com/image-product/img61-1581762923.jpg',
            ],
            [
                'nama_bahan' => 'Tempe',
                'deskripsi_bahan' => 'Tempe adalah sumber protein nabati khas Indonesia.',
                'gambar_bahan' => 'https://wiratech.co.id/wp-content/uploads/2019/02/Tempe.jpg',
            ],
            [
                'nama_bahan' => 'Ketumbar',
                'deskripsi_bahan' => 'Ketumbar digunakan untuk memberikan aroma dan rasa khas pada masakan seperti gulai dan kari.',
                'gambar_bahan' => 'https://example.com/gambar/ketumbar.jpg',
            ],
            [
                'nama_bahan' => 'Jinten',
                'deskripsi_bahan' => 'Jinten memiliki rasa yang kuat dan sering digunakan dalam masakan bersantan seperti opor dan gulai.',
                'gambar_bahan' => 'https://example.com/gambar/jinten.jpg',
            ],
            [
                'nama_bahan' => 'Kencur',
                'deskripsi_bahan' => 'Kencur memberikan aroma khas dan digunakan dalam masakan seperti seblak dan urap.',
                'gambar_bahan' => 'https://example.com/gambar/kencur.jpg',
            ],
            [
                'nama_bahan' => 'Pala',
                'deskripsi_bahan' => 'Pala digunakan untuk memberikan rasa manis dan hangat pada masakan seperti semur.',
                'gambar_bahan' => 'https://example.com/gambar/pala.jpg',
            ],
            [
                'nama_bahan' => 'Cengkeh',
                'deskripsi_bahan' => 'Cengkeh memberikan aroma kuat dan digunakan dalam masakan seperti rendang dan semur.',
                'gambar_bahan' => 'https://example.com/gambar/cengkeh.jpg',
            ],
            [
                'nama_bahan' => 'Kayu Manis',
                'deskripsi_bahan' => 'Kayu manis memberikan rasa manis dan aroma khas pada masakan dan minuman tradisional.',
                'gambar_bahan' => 'https://example.com/gambar/kayu_manis.jpg',
            ],
            [
                'nama_bahan' => 'Kapulaga',
                'deskripsi_bahan' => 'Kapulaga digunakan untuk memberikan aroma dan rasa khas pada masakan seperti gulai dan kari.',
                'gambar_bahan' => 'https://example.com/gambar/kapulaga.jpg',
            ],
            [
                'nama_bahan' => 'Kecombrang',
                'deskripsi_bahan' => 'Kecombrang memberikan aroma harum dan rasa asam segar pada masakan seperti urap dan pepes.',
                'gambar_bahan' => 'https://example.com/gambar/kecombrang.jpg',
            ],
            [
                'nama_bahan' => 'Petai',
                'deskripsi_bahan' => 'Petai memiliki aroma khas dan digunakan dalam masakan seperti sambal goreng dan nasi goreng.',
                'gambar_bahan' => 'https://example.com/gambar/petai.jpg',
            ],
            [
                'nama_bahan' => 'Terasi',
                'deskripsi_bahan' => 'Terasi memberikan rasa gurih dan digunakan dalam sambal dan masakan khas Indonesia.',
                'gambar_bahan' => 'https://example.com/gambar/terasi.jpg',
            ],
            [
                'nama_bahan' => 'Asam Jawa',
                'deskripsi_bahan' => 'Asam jawa memberikan rasa asam segar pada masakan seperti sayur asem dan sambal.',
                'gambar_bahan' => 'https://example.com/gambar/asam_jawa.jpg',
            ],
            [
                'nama_bahan' => 'Asam Kandis',
                'deskripsi_bahan' => 'Asam kandis digunakan untuk memberikan rasa asam pada masakan khas Sumatera seperti rendang.',
                'gambar_bahan' => 'https://example.com/gambar/asam_kandis.jpg',
            ],
            [
                'nama_bahan' => 'Daun Pandan',
                'deskripsi_bahan' => 'Daun pandan memberikan aroma harum pada masakan dan kue tradisional.',
                'gambar_bahan' => 'https://example.com/gambar/daun_pandan.jpg',
            ],
            [
                'nama_bahan' => 'Daun Kemangi',
                'deskripsi_bahan' => 'Daun kemangi digunakan sebagai lalapan atau bumbu pepes karena aromanya yang wangi.',
                'gambar_bahan' => 'https://example.com/gambar/daun_kemangi.jpg',
            ],
            [
                'nama_bahan' => 'Daun Bawang',
                'deskripsi_bahan' => 'Daun bawang digunakan sebagai pelengkap dan penambah aroma pada berbagai masakan.',
                'gambar_bahan' => 'https://example.com/gambar/daun_bawang.jpg',
            ],
            [
                'nama_bahan' => 'Jeruk Nipis',
                'deskripsi_bahan' => 'Jeruk nipis memberikan rasa asam segar dan digunakan untuk menghilangkan bau amis.',
                'gambar_bahan' => 'https://example.com/gambar/jeruk_nipis.jpg',
            ],
            [
                'nama_bahan' => 'Jeruk Purut',
                'deskripsi_bahan' => 'Jeruk purut digunakan untuk memberikan aroma segar pada masakan seperti soto dan sambal.',
                'gambar_bahan' => 'https://example.com/gambar/jeruk_purut.jpg',
            ],
            [
                'nama_bahan' => 'Bawang Bombay',
                'deskripsi_bahan' => 'Bawang bombay memberikan rasa manis dan digunakan dalam masakan seperti semur dan tumisan.',
                'gambar_bahan' => 'https://example.com/gambar/bawang_bombay.jpg',
            ],
            [
                'nama_bahan' => 'Tahu',
                'deskripsi_bahan' => 'Tahu adalah sumber protein nabati yang digunakan dalam berbagai masakan Indonesia.',
                'gambar_bahan' => 'https://example.com/gambar/tahu.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Teri',
                'deskripsi_bahan' => 'Ikan teri digunakan dalam sambal atau sebagai lauk pendamping nasi.',
                'gambar_bahan' => 'https://example.com/gambar/ikan_teri.jpg',
            ],
            [
                'nama_bahan' => 'Udang Kering (Ebi)',
                'deskripsi_bahan' => 'Ebi memberikan rasa gurih dan digunakan dalam sambal atau bumbu dasar.',
                'gambar_bahan' => 'https://example.com/gambar/ebi.jpg',
            ],
            [
                'nama_bahan' => 'Rebon',
                'deskripsi_bahan' => 'Rebon adalah udang kecil kering yang sering digunakan dalam sambal dan rempeyek.',
                'gambar_bahan' => 'https://example.com/gambar/rebon.jpg',
            ],
            [
                'nama_bahan' => 'Kluwek',
                'deskripsi_bahan' => 'Kluwek digunakan untuk memberi warna hitam dan rasa khas pada rawon.',
                'gambar_bahan' => 'https://example.com/gambar/kluwek.jpg',
            ],
            [
                'nama_bahan' => 'Belimbing Wuluh',
                'deskripsi_bahan' => 'Belimbing wuluh memberikan rasa asam dan digunakan dalam sayur asem dan masakan ikan.',
                'gambar_bahan' => 'https://example.com/gambar/belimbing_wuluh.jpg',
            ],
            [
                'nama_bahan' => 'Daun Pepaya',
                'deskripsi_bahan' => 'Daun pepaya digunakan sebagai lalapan atau direbus untuk mengurangi bau amis daging.',
                'gambar_bahan' => 'https://example.com/gambar/daun_pepaya.jpg',
            ],
            [
                'nama_bahan' => 'Kerupuk',
                'deskripsi_bahan' => 'Kerupuk menjadi pelengkap makanan yang memberikan tekstur renyah.',
                'gambar_bahan' => 'https://example.com/gambar/kerupuk.jpg',
            ],
            [
                'nama_bahan' => 'Oncom',
                'deskripsi_bahan' => 'Oncom adalah hasil fermentasi yang menjadi bahan utama dalam masakan khas Sunda.',
                'gambar_bahan' => 'https://example.com/gambar/oncom.jpg',
            ],
            [
                'nama_bahan' => 'Temulawak',
                'deskripsi_bahan' => 'Temulawak sering digunakan dalam jamu dan juga masakan tradisional karena rasanya yang khas.',
                'gambar_bahan' => 'https://example.com/gambar/temulawak.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Tanah',
                'deskripsi_bahan' => 'Kacang tanah sering dijadikan bahan dasar sambal kacang atau sebagai campuran makanan tradisional.',
                'gambar_bahan' => 'https://example.com/gambar/kacang_tanah.jpg',
            ],
            [
                'nama_bahan' => 'Kelapa Parut',
                'deskripsi_bahan' => 'Kelapa parut digunakan dalam urap, kue tradisional, dan campuran bumbu masak.',
                'gambar_bahan' => 'https://example.com/gambar/kelapa_parut.jpg',
            ],
            [
                'nama_bahan' => 'Santan',
                'deskripsi_bahan' => 'Santan adalah hasil perasan kelapa yang memberi cita rasa gurih pada berbagai hidangan.',
                'gambar_bahan' => 'https://example.com/gambar/santan.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkong',
                'deskripsi_bahan' => 'Daun singkong banyak diolah menjadi sayur, terutama dalam masakan Padang.',
                'gambar_bahan' => 'https://example.com/gambar/daun_singkong.jpg',
            ],
            [
                'nama_bahan' => 'Daun Talas',
                'deskripsi_bahan' => 'Daun talas dimanfaatkan dalam masakan seperti botok dan pendap.',
                'gambar_bahan' => 'https://example.com/gambar/daun_talas.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Asin',
                'deskripsi_bahan' => 'Ikan asin memiliki rasa gurih yang khas dan sering dijadikan lauk pendamping nasi.',
                'gambar_bahan' => 'https://example.com/gambar/ikan_asin.jpg',
            ],
            [
                'nama_bahan' => 'Lempah Kuning',
                'deskripsi_bahan' => 'Bumbu khas Bangka Belitung dengan kunyit dan asam yang digunakan untuk memasak ikan.',
                'gambar_bahan' => 'https://example.com/gambar/lempah_kuning.jpg',
            ],
            [
                'nama_bahan' => 'Tauco',
                'deskripsi_bahan' => 'Tauco adalah fermentasi kedelai yang digunakan sebagai bumbu masakan khas seperti tahu tauco.',
                'gambar_bahan' => 'https://example.com/gambar/tauco.jpg',
            ],
            [
                'nama_bahan' => 'Rimbang',
                'deskripsi_bahan' => 'Rimbang atau tekokak digunakan dalam masakan Batak dan Minang, memiliki rasa pahit unik.',
                'gambar_bahan' => 'https://example.com/gambar/rimbang.jpg',
            ],
            [
                'nama_bahan' => 'Daun Kelor',
                'deskripsi_bahan' => 'Daun kelor kaya nutrisi dan sering dimasak sebagai sayur bening atau pelengkap sup.',
                'gambar_bahan' => 'https://example.com/gambar/daun_kelor.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkil',
                'deskripsi_bahan' => 'Daun singkil banyak digunakan dalam masakan tradisional Aceh.',
                'gambar_bahan' => 'https://example.com/gambar/daun_singkil.jpg',
            ],
            [
                'nama_bahan' => 'Buah Keluak',
                'deskripsi_bahan' => 'Buah keluak merupakan bahan utama dalam rawon dan semur khas Indonesia, rasanya pahit-gurih.',
                'gambar_bahan' => 'https://example.com/gambar/buah_keluak.jpg',
            ],
            [
                'nama_bahan' => 'Daun Mengkudu',
                'deskripsi_bahan' => 'Daun mengkudu digunakan dalam masakan khas NTT dan dipercaya menyehatkan tubuh.',
                'gambar_bahan' => 'https://example.com/gambar/daun_mengkudu.jpg',
            ],
            [
                'nama_bahan' => 'Cabe Katokkon',
                'deskripsi_bahan' => 'Cabe khas Toraja yang berukuran besar dan sangat pedas, digunakan dalam masakan tradisional.',
                'gambar_bahan' => 'https://example.com/gambar/cabe_katokkon.jpg',
            ],
            [
                'nama_bahan' => 'Sagu',
                'deskripsi_bahan' => 'Sagu adalah bahan pokok di Papua dan Maluku, biasanya diolah menjadi papeda.',
                'gambar_bahan' => 'https://example.com/gambar/sagu.jpg',
            ],
            [
                'nama_bahan' => 'Papaya Muda',
                'deskripsi_bahan' => 'Papaya muda sering dimasak sebagai sayur lodeh atau oseng-oseng.',
                'gambar_bahan' => 'https://example.com/gambar/papaya_muda.jpg',
            ],
            [
                'nama_bahan' => 'Jantung Pisang',
                'deskripsi_bahan' => 'Jantung pisang dimasak sebagai sayur atau dicampur dalam gulai dan lodeh.',
                'gambar_bahan' => 'https://example.com/gambar/jantung_pisang.jpg',
            ],
            [
                'nama_bahan' => 'Lidah Buaya',
                'deskripsi_bahan' => 'Lidah buaya dapat digunakan dalam minuman tradisional atau sebagai pelengkap hidangan manis.',
                'gambar_bahan' => 'https://example.com/gambar/lidah_buaya.jpg',
            ],
            [
                'nama_bahan' => 'Ubi Ungu',
                'deskripsi_bahan' => 'Ubi ungu diolah menjadi kolak, kue tradisional, atau camilan sehat.',
                'gambar_bahan' => 'https://example.com/gambar/ubi_ungu.jpg',
            ],
            [
                'nama_bahan' => 'Tape Singkong',
                'deskripsi_bahan' => 'Tape singkong adalah hasil fermentasi yang digunakan dalam jajanan pasar seperti peuyeum dan prol tape.',
                'gambar_bahan' => 'https://example.com/gambar/tape_singkong.jpg',
            ],
            [
                'nama_bahan' => 'Gembili',
                'deskripsi_bahan' => 'Gembili adalah umbi-umbian lokal yang digunakan sebagai pengganti nasi di beberapa daerah pedalaman.',
                'gambar_bahan' => 'https://example.com/gambar/gembili.jpg',
            ],
            [
                'nama_bahan' => 'Koro',
                'deskripsi_bahan' => 'Koro adalah kacang lokal yang biasa direbus atau diolah menjadi tempe koro.',
                'gambar_bahan' => 'https://example.com/gambar/koro.jpg',
            ],
            [
                'nama_bahan' => 'Pakis',
                'deskripsi_bahan' => 'Sayur pakis sering dimasak tumis atau menjadi bagian dari sayur kuah santan, khas Sumatera dan Kalimantan.',
                'gambar_bahan' => 'https://example.com/gambar/pakis.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Gabus',
                'deskripsi_bahan' => 'Ikan gabus kaya protein dan sering diolah dalam masakan berkuah seperti pindang.',
                'gambar_bahan' => 'https://example.com/gambar/ikan_gabus.jpg',
            ],
            [
                'nama_bahan' => 'Sirsak Muda',
                'deskripsi_bahan' => 'Sirsak muda kadang dimasak seperti sayur lodeh, memberi rasa asam segar.',
                'gambar_bahan' => 'https://example.com/gambar/sirsak_muda.jpg',
            ],
            [
                'nama_bahan' => 'Buah Pisang Batu',
                'deskripsi_bahan' => 'Pisang batu digunakan dalam rujak khas Madura atau sebagai bahan tambahan kolak.',
                'gambar_bahan' => 'https://example.com/gambar/pisang_batu.jpg',
            ],
            [
                'nama_bahan' => 'Buah Lontar',
                'deskripsi_bahan' => 'Buah lontar dikonsumsi langsung atau diolah menjadi minuman manis khas Nusa Tenggara.',
                'gambar_bahan' => 'https://example.com/gambar/lontar.jpg',
            ],
            [
                'nama_bahan' => 'Sagu Lempeng',
                'deskripsi_bahan' => 'Sagu lempeng adalah olahan sagu yang dibakar, makanan pokok masyarakat Maluku dan Papua.',
                'gambar_bahan' => 'https://example.com/gambar/sagu_lempeng.jpg',
            ],
            [
                'nama_bahan' => 'Udang Papai',
                'deskripsi_bahan' => 'Udang kecil air tawar yang biasa ditemukan di daerah pedalaman Kalimantan.',
                'gambar_bahan' => 'https://example.com/gambar/udang_papai.jpg',
            ],
            [
                'nama_bahan' => 'Rumput Laut',
                'deskripsi_bahan' => 'Rumput laut segar biasa digunakan dalam salad, asinan, atau agar-agar alami.',
                'gambar_bahan' => 'https://example.com/gambar/rumput_laut.jpg',
            ],
            [
                'nama_bahan' => 'Buah Kolang-kaling',
                'deskripsi_bahan' => 'Kolang-kaling berasal dari pohon aren dan sering dijadikan campuran minuman manis atau es campur.',
                'gambar_bahan' => 'https://example.com/gambar/kolang_kaling.jpg',
            ],
            [
                'nama_bahan' => 'Getuk Lindri',
                'deskripsi_bahan' => 'Olahan singkong manis yang diberi warna dan dibentuk memanjang, khas Jawa.',
                'gambar_bahan' => 'https://example.com/gambar/getuk_lindri.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Hijau',
                'deskripsi_bahan' => 'Kacang hijau sering dimasak menjadi bubur atau isian onde-onde dan kue tradisional lainnya.',
                'gambar_bahan' => 'https://example.com/gambar/kacang_hijau.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkong Tumbuk',
                'deskripsi_bahan' => 'Daun singkong yang ditumbuk dan dimasak dengan bumbu khas, sangat populer di Sumatera Utara.',
                'gambar_bahan' => 'https://example.com/gambar/daun_singkong_tumbuk.jpg',
            ],
            [
                'nama_bahan' => 'Sambal Luat',
                'deskripsi_bahan' => 'Sambal khas NTT yang terbuat dari cabai, daun kemangi, dan perasan jeruk lokal, digunakan sebagai pelengkap lauk.',
                'gambar_bahan' => 'https://example.com/gambar/sambal_luat.jpg',
            ],
            [
                'nama_bahan' => 'Daun Gedi',
                'deskripsi_bahan' => 'Daun gedi memiliki tekstur berlendir seperti okra dan digunakan dalam masakan khas Manado seperti bubur tinutuan.',
                'gambar_bahan' => 'https://example.com/gambar/daun_gedi.jpg',
            ],
            [
                'nama_bahan' => 'Sambal Andaliman',
                'deskripsi_bahan' => 'Sambal khas Batak berbahan dasar andaliman, cabai, dan jeruk purut yang memiliki rasa pedas dan menggigit.',
                'gambar_bahan' => 'https://example.com/gambar/sambal_andaliman.jpg',
            ],
            [
                'nama_bahan' => 'Daun Ubi Jalar',
                'deskripsi_bahan' => 'Daun ubi jalar dapat direbus atau dimasak tumis, populer sebagai lalapan di berbagai daerah.',
                'gambar_bahan' => 'https://example.com/gambar/daun_ubi_jalar.jpg',
            ],
            [
                'nama_bahan' => 'Lempuk Durian',
                'deskripsi_bahan' => 'Lempuk adalah olahan durian menjadi dodol, digunakan sebagai bahan kue atau camilan khas Sumatera.',
                'gambar_bahan' => 'https://example.com/gambar/lempuk_durian.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Parende',
                'deskripsi_bahan' => 'Ikan khas dari daerah Bugis yang dimasak dengan kuah kuning dan rempah segar.',
                'gambar_bahan' => 'https://example.com/gambar/ikan_parende.jpg',
            ],
            [
                'nama_bahan' => 'Buah Kenari',
                'deskripsi_bahan' => 'Kenari digunakan dalam kue tradisional Manado seperti klappertaart dan bubur Manado.',
                'gambar_bahan' => 'https://example.com/gambar/buah_kenari.jpg',
            ],
            [
                'nama_bahan' => 'Garo Bunga Pepaya',
                'deskripsi_bahan' => 'Masakan khas Sulawesi Utara yang menggunakan bunga pepaya pahit ditumis dengan ikan asin atau teri.',
                'gambar_bahan' => 'https://example.com/gambar/bunga_pepaya.jpg',
            ],
            [
                'nama_bahan' => 'Daun Melinjo',
                'deskripsi_bahan' => 'Daun melinjo dimasak dalam sayur asem atau ditumis, kaya akan serat dan memiliki rasa khas.',
                'gambar_bahan' => 'https://example.com/gambar/daun_melinjo.jpg',
            ],
            [
                'nama_bahan' => 'Emping Melinjo',
                'deskripsi_bahan' => 'Kerupuk khas yang terbuat dari biji melinjo, digoreng dan disajikan sebagai pelengkap.',
                'gambar_bahan' => 'https://example.com/gambar/emping_melinjo.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Roa',
                'deskripsi_bahan' => 'Ikan asap khas Manado yang sering dijadikan sambal atau abon, memiliki rasa gurih khas laut.',
                'gambar_bahan' => 'https://example.com/gambar/ikan_roa.jpg',
            ],
            [
                'nama_bahan' => 'Lada Bangka',
                'deskripsi_bahan' => 'Lada putih Bangka terkenal pedas dan wangi, digunakan dalam banyak masakan lokal dan ekspor.',
                'gambar_bahan' => 'https://example.com/gambar/lada_bangka.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Koro',
                'deskripsi_bahan' => 'Kacang lokal yang sering digoreng sebagai camilan atau campuran sambal goreng.',
                'gambar_bahan' => 'https://example.com/gambar/kacang_koro.jpg',
            ],
            [
                'nama_bahan' => 'Biji Ketapang',
                'deskripsi_bahan' => 'Biji ketapang kadang dijadikan bahan baku camilan atau bumbu khas dalam beberapa daerah pesisir.',
                'gambar_bahan' => 'https://example.com/gambar/biji_ketapang.jpg',
            ],
            [
                'nama_bahan' => 'Tiwul',
                'deskripsi_bahan' => 'Makanan pokok berbahan gaplek (singkong kering) yang dikukus, khas daerah Gunungkidul.',
                'gambar_bahan' => 'https://example.com/gambar/tiwul.jpg',
            ],
        ];

        $namaGizi = [
            'Energi',
            'Karbohidrat',
            'Protein',
            'Lemak',
            'Serat',
            'Gula',
            'Natrium',
            'Kalsium',
            'Zat Besi',
            'Vitamin A',
            'Vitamin B1',
            'Vitamin B2',
            'Vitamin B3',
            'Vitamin B6',
            'Vitamin B12',
            'Vitamin C',
            'Vitamin D',
            'Vitamin E',
            'Vitamin K',
            'Kolesterol'
        ];

        $satuanGizi = [
            'mg',
            'g',
            'µg',
            'kcal',
            'IU',
            'ml',
            'L',
            '%'
        ];

        foreach ($bahanMasak as $bahan) {
            $idBahan = DB::table('bahan_masak')->insertGetId($bahan);

            $jumlahGizi = rand(3, 5);
            $giziDipilih = collect($namaGizi)->random($jumlahGizi);

            foreach ($giziDipilih as $gizi) {
                DB::table('gizi')->insert([
                    'id_bahan' => $idBahan,
                    'id_resep' => null,
                    'nama_gizi' => $gizi,
                    'jumlah' => round(rand(1, 100) / 10, 2),
                    'satuan' => $satuanGizi[array_rand($satuanGizi)],
                    'created_at' => now(),
                    'updated_at' => now(),
                ]);
            }
        }
    }
}
