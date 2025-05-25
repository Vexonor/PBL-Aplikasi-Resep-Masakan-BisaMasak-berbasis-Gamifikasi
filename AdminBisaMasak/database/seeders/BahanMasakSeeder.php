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
                'gambar_bahan' => 'https://cdn.rri.co.id/berita/Banda_Aceh/o/1715838450214-KEtumbar/a7llg5mzp4schr0.jpeg',
            ],
            [
                'nama_bahan' => 'Jinten',
                'deskripsi_bahan' => 'Jinten memiliki rasa yang kuat dan sering digunakan dalam masakan bersantan seperti opor dan gulai.',
                'gambar_bahan' => 'https://png.pngtree.com/png-vector/20240721/ourmid/pngtree-cumin-selective-focus-png-image_13177673.png',
            ],
            [
                'nama_bahan' => 'Kencur',
                'deskripsi_bahan' => 'Kencur memberikan aroma khas dan digunakan dalam masakan seperti seblak dan urap.',
                'gambar_bahan' => 'https://radarjabar.disway.id/upload/9d6c9218477dcaa7e04910c7f055ccab.png',
            ],
            [
                'nama_bahan' => 'Pala',
                'deskripsi_bahan' => 'Pala digunakan untuk memberikan rasa manis dan hangat pada masakan seperti semur.',
                'gambar_bahan' => 'https://tanimakmurindonesia.com/wp-content/uploads/2023/08/image-1.png',
            ],
            [
                'nama_bahan' => 'Cengkeh',
                'deskripsi_bahan' => 'Cengkeh memberikan aroma kuat dan digunakan dalam masakan seperti rendang dan semur.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/f7/27/66/f72766d76302fd80849bb8c67621fc78.jpg',
            ],
            [
                'nama_bahan' => 'Kayu Manis',
                'deskripsi_bahan' => 'Kayu manis memberikan rasa manis dan aroma khas pada masakan dan minuman tradisional.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/86/6b/4f/866b4f378d15bcbeb1fa2d08548d2bc2.jpg',
            ],
            [
                'nama_bahan' => 'Kapulaga',
                'deskripsi_bahan' => 'Kapulaga digunakan untuk memberikan aroma dan rasa khas pada masakan seperti gulai dan kari.',
                'gambar_bahan' => 'https://umsu.ac.id/health/wp-content/uploads/2024/11/Rempah-Kapulaga-Kandungan-dan-Manfaatnya.jpg',
            ],
            [
                'nama_bahan' => 'Kecombrang',
                'deskripsi_bahan' => 'Kecombrang memberikan aroma harum dan rasa asam segar pada masakan seperti urap dan pepes.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/c0/12/79/c0127922643e9bf82dda62dd872f9299.jpg',
            ],
            [
                'nama_bahan' => 'Petai',
                'deskripsi_bahan' => 'Petai memiliki aroma khas dan digunakan dalam masakan seperti sambal goreng dan nasi goreng.',
                'gambar_bahan' => 'https://t4.ftcdn.net/jpg/00/86/03/79/360_F_86037932_WDfbRs1Lm67yD7TjzwZi380iJoWsObXl.jpg',
            ],
            [
                'nama_bahan' => 'Terasi',
                'deskripsi_bahan' => 'Terasi memberikan rasa gurih dan digunakan dalam sambal dan masakan khas Indonesia.',
                'gambar_bahan' => 'https://jabarekspres.com/wp-content/uploads/2022/02/shrimp-paste-dried.jpg',
            ],
            [
                'nama_bahan' => 'Asam Jawa',
                'deskripsi_bahan' => 'Asam jawa memberikan rasa asam segar pada masakan seperti sayur asem dan sambal.',
                'gambar_bahan' => 'https://png.pngtree.com/png-vector/20250101/ourmid/pngtree-tamarind-fruit-on-transparent-background-png-image_15008620.png',
            ],
            [
                'nama_bahan' => 'Asam Kandis',
                'deskripsi_bahan' => 'Asam kandis digunakan untuk memberikan rasa asam pada masakan khas Sumatera seperti rendang.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/96/a5/f6/96a5f669319e07734aeaf27b228b2017.jpg',
            ],
            [
                'nama_bahan' => 'Daun Pandan',
                'deskripsi_bahan' => 'Daun pandan memberikan aroma harum pada masakan dan kue tradisional.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/36/e7/2a/36e72a0c9b7aaa1083a0c8bea98ad85a.jpg',
            ],
            [
                'nama_bahan' => 'Daun Kemangi',
                'deskripsi_bahan' => 'Daun kemangi digunakan sebagai lalapan atau bumbu pepes karena aromanya yang wangi.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/f7/60/8b/f7608baa8977166cfea203dd93f16e01.jpg',
            ],
            [
                'nama_bahan' => 'Daun Bawang',
                'deskripsi_bahan' => 'Daun bawang digunakan sebagai pelengkap dan penambah aroma pada berbagai masakan.',
                'gambar_bahan' => 'https://daganghalal.blob.core.windows.net/42729/Product/daun-bawang-1704360838034.jpg',
            ],
            [
                'nama_bahan' => 'Jeruk Nipis',
                'deskripsi_bahan' => 'Jeruk nipis memberikan rasa asam segar dan digunakan untuk menghilangkan bau amis.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/46/3d/e3/463de3e6ff8f26ecbf757252db9b3cfc.jpg',
            ],
            [
                'nama_bahan' => 'Jeruk Purut',
                'deskripsi_bahan' => 'Jeruk purut digunakan untuk memberikan aroma segar pada masakan seperti soto dan sambal.',
                'gambar_bahan' => 'https://res.cloudinary.com/dk0z4ums3/image/upload/v1643545186/attached_image/ternyata-ada-manfaat-jeruk-purut-untuk-kesehatan.jpg',
            ],
            [
                'nama_bahan' => 'Bawang Bombay',
                'deskripsi_bahan' => 'Bawang bombay memberikan rasa manis dan digunakan dalam masakan seperti semur dan tumisan.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/0f/a6/e0/0fa6e086da30cc8f6842ae6e7cb00ed0.jpg',
            ],
            [
                'nama_bahan' => 'Tahu',
                'deskripsi_bahan' => 'Tahu adalah sumber protein nabati yang digunakan dalam berbagai masakan Indonesia.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/0f/2e/fd/0f2efd091aed8146a859da4438ef9b52.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Teri',
                'deskripsi_bahan' => 'Ikan teri digunakan dalam sambal atau sebagai lauk pendamping nasi.',
                'gambar_bahan' => 'https://doktersehat.com/wp-content/uploads/2020/12/ikan-teri-doktersehat.jpg',
            ],
            [
                'nama_bahan' => 'Udang Kering (Ebi)',
                'deskripsi_bahan' => 'Ebi memberikan rasa gurih dan digunakan dalam sambal atau bumbu dasar.',
                'gambar_bahan' => 'https://cdn.grid.id/crop/0x0:0x0/700x0/photo/2023/02/10/rsz_mencambur_ebi_dalam_masakan-20230210010207.jpg',
            ],
            [
                'nama_bahan' => 'Rebon',
                'deskripsi_bahan' => 'Rebon adalah udang kecil kering yang sering digunakan dalam sambal dan rempeyek.',
                'gambar_bahan' => 'https://www.bibiksayur.com/wp-content/uploads/2024/06/Udang-Rebon.png',
            ],
            [
                'nama_bahan' => 'Kluwek',
                'deskripsi_bahan' => 'Kluwek digunakan untuk memberi warna hitam dan rasa khas pada rawon.',
                'gambar_bahan' => 'https://asset.kompas.com/crops/J8FK0F9YiHEJWZI6zmhEFNJZvJA=/0x0:698x465/1200x800/data/photo/2021/04/22/6080f30e698bc.jpg',
            ],
            [
                'nama_bahan' => 'Belimbing Wuluh',
                'deskripsi_bahan' => 'Belimbing wuluh memberikan rasa asam dan digunakan dalam sayur asem dan masakan ikan.',
                'gambar_bahan' => 'https://agroindonesia.co.id/wp-content/uploads/2017/05/belimbing-wuluh-tokopedia.jpg',
            ],
            [
                'nama_bahan' => 'Daun Pepaya',
                'deskripsi_bahan' => 'Daun pepaya digunakan sebagai lalapan atau direbus untuk mengurangi bau amis daging.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/10/82/c2/1082c2d11164fc610dc05bb6bf33ee71.jpg',
            ],
            [
                'nama_bahan' => 'Kerupuk',
                'deskripsi_bahan' => 'Kerupuk menjadi pelengkap makanan yang memberikan tekstur renyah.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/1a/14/bf/1a14bfea78bb6b5df616609574f10ec3.jpg',
            ],
            [
                'nama_bahan' => 'Oncom',
                'deskripsi_bahan' => 'Oncom adalah hasil fermentasi yang menjadi bahan utama dalam masakan khas Sunda.',
                'gambar_bahan' => 'https://example.com/gambar/oncom.jpg',
            ],
            [
                'nama_bahan' => 'Temulawak',
                'deskripsi_bahan' => 'Temulawak sering digunakan dalam jamu dan juga masakan tradisional karena rasanya yang khas.',
                'gambar_bahan' => 'https://images.tokopedia.net/img/cache/700/VqbcmM/2021/4/24/2c00f4d9-a8e1-495c-8e1e-ad4e59cdeede.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Tanah',
                'deskripsi_bahan' => 'Kacang tanah sering dijadikan bahan dasar sambal kacang atau sebagai campuran makanan tradisional.',
                'gambar_bahan' => 'hhttps://i.pinimg.com/736x/a2/fa/80/a2fa80aab48bc118355bdac51d203981.jpg',
            ],
            [
                'nama_bahan' => 'Kelapa Parut',
                'deskripsi_bahan' => 'Kelapa parut digunakan dalam urap, kue tradisional, dan campuran bumbu masak.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/e8/d9/cb/e8d9cbf7b1571c43333a2fd02a2effbd.jpg',
            ],
            [
                'nama_bahan' => 'Santan',
                'deskripsi_bahan' => 'Santan adalah hasil perasan kelapa yang memberi cita rasa gurih pada berbagai hidangan.',
                'gambar_bahan' => 'https://st2.depositphotos.com/28791292/46614/i/450/depositphotos_466145760-stock-photo-coconut-milk-splash-coconut-halves.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkong',
                'deskripsi_bahan' => 'Daun singkong banyak diolah menjadi sayur, terutama dalam masakan Padang.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/9c/21/d9/9c21d9be8f2f767365a2346283140707.jpg',
            ],
            [
                'nama_bahan' => 'Daun Talas',
                'deskripsi_bahan' => 'Daun talas dimanfaatkan dalam masakan seperti botok dan pendap.',
                'gambar_bahan' => 'https://png.pngtree.com/png-clipart/20210702/ourmid/pngtree-taro-leaves-on-transparent-background-png-image_3489076.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Asin',
                'deskripsi_bahan' => 'Ikan asin memiliki rasa gurih yang khas dan sering dijadikan lauk pendamping nasi.',
                'gambar_bahan' => 'https://yubissayur.com/wp-content/uploads/2020/09/ikan-asin-peda.jpg',
            ],
            [
                'nama_bahan' => 'Lempah Kuning',
                'deskripsi_bahan' => 'Bumbu khas Bangka Belitung dengan kunyit dan asam yang digunakan untuk memasak ikan.',
                'gambar_bahan' => 'https://asset.kompas.com/crops/aHA2CUB9X9najacJI85SZfpJMZ8=/3x0:700x465/1200x800/data/photo/2024/09/03/66d65738020c7.jpg',
            ],
            [
                'nama_bahan' => 'Tauco',
                'deskripsi_bahan' => 'Tauco adalah fermentasi kedelai yang digunakan sebagai bumbu masakan khas seperti tahu tauco.',
                'gambar_bahan' => 'https://foto.kontan.co.id/l8AYLhxsuGForcQ25HmHg4iY4Vo=/smart/2024/05/01/43763179p.jpg',
            ],
            [
                'nama_bahan' => 'Rimbang',
                'deskripsi_bahan' => 'Rimbang atau tekokak digunakan dalam masakan Batak dan Minang, memiliki rasa pahit unik.',
                'gambar_bahan' => 'https://cdn.rri.co.id/berita/Ranai/o/1742370184839-rimbang/meorkpjxzugphq5.jpeg',
            ],
            [
                'nama_bahan' => 'Daun Kelor',
                'deskripsi_bahan' => 'Daun kelor kaya nutrisi dan sering dimasak sebagai sayur bening atau pelengkap sup.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/ee/c0/7d/eec07df24eecea0f10edace1e9634787.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkil',
                'deskripsi_bahan' => 'Daun singkil banyak digunakan dalam masakan tradisional Aceh.',
                'gambar_bahan' => 'https://www.shutterstock.com/image-photo/premna-foetida-reine-indonesian-called-600nw-2607113981.jpg',
            ],
            [
                'nama_bahan' => 'Buah Keluak',
                'deskripsi_bahan' => 'Buah keluak merupakan bahan utama dalam rawon dan semur khas Indonesia, rasanya pahit-gurih.',
                'gambar_bahan' => 'https://asset.kompas.com/crops/J8FK0F9YiHEJWZI6zmhEFNJZvJA=/0x0:698x465/1200x800/data/photo/2021/04/22/6080f30e698bc.jpg',
            ],
            [
                'nama_bahan' => 'Daun Mengkudu',
                'deskripsi_bahan' => 'Daun mengkudu digunakan dalam masakan khas NTT dan dipercaya menyehatkan tubuh.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/b7/f9/a2/b7f9a2b1231be25769b5047e60984b35.jpg',
            ],
            [
                'nama_bahan' => 'Cabe Katokkon',
                'deskripsi_bahan' => 'Cabe khas Toraja yang berukuran besar dan sangat pedas, digunakan dalam masakan tradisional.',
                'gambar_bahan' => 'https://asset.kompas.com/crops/KpI2pTSCkDMEDBb716kjwgrjfDc=/85x0:418x333/340x340/data/photo/2022/11/26/63817925949b1.jpg',
            ],
            [
                'nama_bahan' => 'Sagu',
                'deskripsi_bahan' => 'Sagu adalah bahan pokok di Papua dan Maluku, biasanya diolah menjadi papeda.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/56/1e/20/561e202414edf1f02040599f78f14343.jpg',
            ],
            [
                'nama_bahan' => 'Papaya Muda',
                'deskripsi_bahan' => 'Papaya muda sering dimasak sebagai sayur lodeh atau oseng-oseng.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/57/a4/15/57a4159a30e9a9aea2d942ea76bb75e0.jpg',
            ],
            [
                'nama_bahan' => 'Jantung Pisang',
                'deskripsi_bahan' => 'Jantung pisang dimasak sebagai sayur atau dicampur dalam gulai dan lodeh.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/16/cb/9e/16cb9ebce47c88ff745d5b5a3b3157ca.jpg',
            ],
            [
                'nama_bahan' => 'Lidah Buaya',
                'deskripsi_bahan' => 'Lidah buaya dapat digunakan dalam minuman tradisional atau sebagai pelengkap hidangan manis.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/95/07/a5/9507a572867b567c811987b2f8b7ee7b.jpg',
            ],
            [
                'nama_bahan' => 'Ubi Ungu',
                'deskripsi_bahan' => 'Ubi ungu diolah menjadi kolak, kue tradisional, atau camilan sehat.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/49/b9/15/49b915886e4246f6a0703a33cf593091.jpg',
            ],
            [
                'nama_bahan' => 'Tape Singkong',
                'deskripsi_bahan' => 'Tape singkong adalah hasil fermentasi yang digunakan dalam jajanan pasar seperti peuyeum dan prol tape.',
                'gambar_bahan' => 'https://d27xm72ryhvga.cloudfront.net/product/13_02_2024_11_25_53_22_07_2022_10_31_41_tape.jpg',
            ],
            [
                'nama_bahan' => 'Gembili',
                'deskripsi_bahan' => 'Gembili adalah umbi-umbian lokal yang digunakan sebagai pengganti nasi di beberapa daerah pedalaman.',
                'gambar_bahan' => 'https://asset-2.tstatic.net/health/foto/bank/images/manfaat-gembili-untuk-diabetes2.jpg',
            ],
            [
                'nama_bahan' => 'Koro',
                'deskripsi_bahan' => 'Koro adalah kacang lokal yang biasa direbus atau diolah menjadi tempe koro.',
                'gambar_bahan' => 'https://umsu.ac.id/health/wp-content/uploads/2024/11/Manfaat-Kacang-Koro-Pedang-Bagi-Kesehatan-Tubuh.jpg',
            ],
            [
                'nama_bahan' => 'Pakis',
                'deskripsi_bahan' => 'Sayur pakis sering dimasak tumis atau menjadi bagian dari sayur kuah santan, khas Sumatera dan Kalimantan.',
                'gambar_bahan' => 'https://vincesmarket.ca/wp-content/uploads/2018/05/7166364_s.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Gabus',
                'deskripsi_bahan' => 'Ikan gabus kaya protein dan sering diolah dalam masakan berkuah seperti pindang.',
                'gambar_bahan' => 'https://media.suara.com/pictures/970x544/2017/11/21/97366-ikan-gabus.jpg',
            ],
            [
                'nama_bahan' => 'Sirsak Muda',
                'deskripsi_bahan' => 'Sirsak muda kadang dimasak seperti sayur lodeh, memberi rasa asam segar.',
                'gambar_bahan' => 'https://bnp.jambiprov.go.id/wp-content/uploads/2023/07/Manfaat-buah-sirsak-untuk-kesehatan.png',
            ],
            [
                'nama_bahan' => 'Buah Pisang Batu',
                'deskripsi_bahan' => 'Pisang batu digunakan dalam rujak khas Madura atau sebagai bahan tambahan kolak.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/a0/c1/60/a0c1607a4ea035248d8b2ccbbf8ffde2.jpg',
            ],
            [
                'nama_bahan' => 'Buah Lontar',
                'deskripsi_bahan' => 'Buah lontar dikonsumsi langsung atau diolah menjadi minuman manis khas Nusa Tenggara.',
                'gambar_bahan' => 'https://img.lazcdn.com/g/p/f263c7aadf5c13c2f0c6a0469d243723.jpg_720x720q80.jpg',
            ],
            [
                'nama_bahan' => 'Sagu Lempeng',
                'deskripsi_bahan' => 'Sagu lempeng adalah olahan sagu yang dibakar, makanan pokok masyarakat Maluku dan Papua.',
                'gambar_bahan' => 'https://backpackstory.me/wp-content/uploads/2014/07/p1120775.jpg',
            ],
            [
                'nama_bahan' => 'Udang Papai',
                'deskripsi_bahan' => 'Udang kecil air tawar yang biasa ditemukan di daerah pedalaman Kalimantan.',
                'gambar_bahan' => 'https://www.bibiksayur.com/wp-content/uploads/2024/06/Udang-Rebon.png',
            ],
            [
                'nama_bahan' => 'Rumput Laut',
                'deskripsi_bahan' => 'Rumput laut segar biasa digunakan dalam salad, asinan, atau agar-agar alami.',
                'gambar_bahan' => 'https://cdn.rri.co.id/berita/Fak_Fak/o/1722753627952-rumput_laut/wsg3e6lhbqsnldn.jpeg',
            ],
            [
                'nama_bahan' => 'Buah Kolang-kaling',
                'deskripsi_bahan' => 'Kolang-kaling berasal dari pohon aren dan sering dijadikan campuran minuman manis atau es campur.',
                'gambar_bahan' => 'https://goodlife.id/wp-content/uploads/2021/05/d4a1e34f9e4d375b1af5f375e136e04c66b8808b-800x569.jpg',
            ],
            [
                'nama_bahan' => 'Getuk Lindri',
                'deskripsi_bahan' => 'Olahan singkong manis yang diberi warna dan dibentuk memanjang, khas Jawa.',
                'gambar_bahan' => 'https://mir-s3-cdn-cf.behance.net/projects/404/14fa8f162710165.Y3JvcCwxMDc5LDg0MywwLDExNw.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Hijau',
                'deskripsi_bahan' => 'Kacang hijau sering dimasak menjadi bubur atau isian onde-onde dan kue tradisional lainnya.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/8b/3c/13/8b3c1334b91d32c161cd9d3a0fee2934.jpg',
            ],
            [
                'nama_bahan' => 'Daun Singkong Tumbuk',
                'deskripsi_bahan' => 'Daun singkong yang ditumbuk dan dimasak dengan bumbu khas, sangat populer di Sumatera Utara.',
                'gambar_bahan' => 'https://www.shutterstock.com/image-photo/daun-ubi-tumbuk-singkong-indonesian-260nw-1730917744.jpg',
            ],
            [
                'nama_bahan' => 'Sambal Luat',
                'deskripsi_bahan' => 'Sambal khas NTT yang terbuat dari cabai, daun kemangi, dan perasan jeruk lokal, digunakan sebagai pelengkap lauk.',
                'gambar_bahan' => 'https://img-global.cpcdn.com/recipes/325d064e9334f988/680x482cq70/sambal-luat-ntt-foto-resep-utama.jpg',
            ],
            [
                'nama_bahan' => 'Daun Gedi',
                'deskripsi_bahan' => 'Daun gedi memiliki tekstur berlendir seperti okra dan digunakan dalam masakan khas Manado seperti bubur tinutuan.',
                'gambar_bahan' => 'https://static.promediateknologi.id/crop/0x0:0x0/0x0/webp/photo/p2/28/2025/01/08/Second-Account-76-921733655.png',
            ],
            [
                'nama_bahan' => 'Sambal Andaliman',
                'deskripsi_bahan' => 'Sambal khas Batak berbahan dasar andaliman, cabai, dan jeruk purut yang memiliki rasa pedas dan menggigit.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/5c/8a/d7/5c8ad78e7a78691d7f911e37ab35cea3.jpg',
            ],
            [
                'nama_bahan' => 'Daun Ubi Jalar',
                'deskripsi_bahan' => 'Daun ubi jalar dapat direbus atau dimasak tumis, populer sebagai lalapan di berbagai daerah.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/6e/83/98/6e8398d2c2328649ee9e5bd566a77ae2.jpg',
            ],
            [
                'nama_bahan' => 'Lempuk Durian',
                'deskripsi_bahan' => 'Lempuk adalah olahan durian menjadi dodol, digunakan sebagai bahan kue atau camilan khas Sumatera.',
                'gambar_bahan' => 'https://radarmukomuko.disway.id/upload/042d717e0288ed7ececefa5c58a7a6e3.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Parende',
                'deskripsi_bahan' => 'Ikan khas dari daerah Bugis yang dimasak dengan kuah kuning dan rempah segar.',
                'gambar_bahan' => 'https://www.masakapahariini.com/wp-content/uploads/2020/03/palumara-1.jpg',
            ],
            [
                'nama_bahan' => 'Buah Kenari',
                'deskripsi_bahan' => 'Kenari digunakan dalam kue tradisional Manado seperti klappertaart dan bubur Manado.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/da/22/e0/da22e0727d72b174ca47a30ad36e54aa.jpg',
            ],
            [
                'nama_bahan' => 'Garo Bunga Pepaya',
                'deskripsi_bahan' => 'Masakan khas Sulawesi Utara yang menggunakan bunga pepaya pahit ditumis dengan ikan asin atau teri.',
                'gambar_bahan' => 'https://res.cloudinary.com/dk0z4ums3/image/upload/v1601630161/attached_image/manfaat-bunga-pepaya-tidak-kalah-dengan-buahnya.jpg',
            ],
            [
                'nama_bahan' => 'Daun Melinjo',
                'deskripsi_bahan' => 'Daun melinjo dimasak dalam sayur asem atau ditumis, kaya akan serat dan memiliki rasa khas.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/8e/26/30/8e2630d5f5f298a0c243e1eb321b6e4a.jpg',
            ],
            [
                'nama_bahan' => 'Emping Melinjo',
                'deskripsi_bahan' => 'Kerupuk khas yang terbuat dari biji melinjo, digoreng dan disajikan sebagai pelengkap.',
                'gambar_bahan' => 'https://mlijoy.com/data/images/product/IMG7244.jpg',
            ],
            [
                'nama_bahan' => 'Ikan Roa',
                'deskripsi_bahan' => 'Ikan asap khas Manado yang sering dijadikan sambal atau abon, memiliki rasa gurih khas laut.',
                'gambar_bahan' => 'https://filebroker-cdn.lazada.co.id/kf/S1789bbee67d841f79aec815078412d7dP.jpg',
            ],
            [
                'nama_bahan' => 'Lada Bangka',
                'deskripsi_bahan' => 'Lada putih Bangka terkenal pedas dan wangi, digunakan dalam banyak masakan lokal dan ekspor.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/69/ba/25/69ba25d414f99506ee51b6a355825eb6.jpg',
            ],
            [
                'nama_bahan' => 'Kacang Koro',
                'deskripsi_bahan' => 'Kacang lokal yang sering digoreng sebagai camilan atau campuran sambal goreng.',
                'gambar_bahan' => 'https://umsu.ac.id/health/wp-content/uploads/2024/11/Manfaat-Kacang-Koro-Pedang-Bagi-Kesehatan-Tubuh.jpg',
            ],
            [
                'nama_bahan' => 'Biji Ketapang',
                'deskripsi_bahan' => 'Biji ketapang kadang dijadikan bahan baku camilan atau bumbu khas dalam beberapa daerah pesisir.',
                'gambar_bahan' => 'https://i.pinimg.com/736x/fa/d1/7c/fad17c84b657910a6f0a2b13bd067d5f.jpg',
            ],
            [
                'nama_bahan' => 'Tiwul',
                'deskripsi_bahan' => 'Makanan pokok berbahan gaplek (singkong kering) yang dikukus, khas daerah Gunungkidul.',
                'gambar_bahan' => 'https://img.harianjogja.com/posts/2024/10/09/1189730/tiwul-freepik.jpg',
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
