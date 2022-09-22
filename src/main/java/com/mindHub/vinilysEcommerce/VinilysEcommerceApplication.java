package com.mindHub.vinilysEcommerce;

import com.mindHub.vinilysEcommerce.models.*;
import com.mindHub.vinilysEcommerce.repositories.BillRepository;
import com.mindHub.vinilysEcommerce.repositories.ClientRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductBillRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class VinilysEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinilysEcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, ProductRepository productRepository, BillRepository billRepository, ProductBillRepository productBillRepository) {
		return (args) -> {

			Client client1 = new Client("Facu","Araujo", "facu@mindhub.com", passwordEncoder.encode("123"), true);
			clientRepository.save(client1);

			Product product1 = new Product("Fine Line", "Harry Styles","Debutó en el número tres en la lista de álbumes del Reino Unido5 y en el número uno en el Billboard 200" ,"2019", List.of( "https://http2.mlstatic.com/D_NQ_NP_832207-MLA40089208872_122019-O.webp"), Set.of("Pop","Pop Rock"), 15, 2000.0, true, ProductType.VINYLS, "-");
			Product product2 = new Product("Future Nostalgia", "Dua Lipa","El álbum fue promocionado con seis sencillos y un sencillo promocional, «Don't Start Now», se lanzó el 1 de noviembre de 2019 como el sencillo principal del álbum" ,"2019", List.of( "https://i.pinimg.com/originals/80/e4/0e/80e40e92d83ead241dc29fd1f2ebd5af.jpg"), Set.of("Pop","Pop Rock"), 29, 3300.0, true, ProductType.VINYLS, "-");
			Product product3 = new Product("Born to die", "Lana Del Rey","Tras el lanzamiento del disco obtuvo críticas «favorables» por parte de los profesionales más grandes de música contemporáneas" ,"2012", List.of( "https://upload.wikimedia.org/wikipedia/en/2/29/BornToDieAlbumCover.png"), Set.of("Pop"), 30, 10000.0, true, ProductType.VINYLS, "-");
			Product product4 = new Product("Harry Styles", "Harry Styles","Tras el lanzamiento del disco obtuvo críticas «favorables» por parte de los profesionales más grandes de música contemporáneas" ,"2017", List.of( "https://m.media-amazon.com/images/I/71ICZkHhviL._SL1500_.jpg"), Set.of("Pop Rock"), 40, 6000.0, true, ProductType.VINYLS, "-");

			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);

			//http://drive.google.com/uc?export=FIELD

			Product product99 = new Product("A Rush of blood to the head", "Coldplay", "Es el segundo álbum de estudio de la banda británica Coldplay. Lanzado el 26 de agosto de 2002 bajo el sello de la discográfica Parlophone, el álbum fue producido por la banda junto a Ken Nelson 2012", "2020", List.of( "http://drive.google.com/uc?export=view&id=1tjw3hSYS2VZ6vObLn8FHj_GcXbIcqVcE"), Set.of("Rock", "Pop"), 35, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product99);
			Product product5 = new Product("Clics Modernos", "Charly Garcia","Clics Modernos es el segundo álbum de estudio del cantante argentino Charly García, publicado el 5 de noviembre de 1983 por la compañía SG Discos.", "2020", List.of("http://drive.google.com/uc?export=view&id=1dWQZ0kK24vfeKKVLPPzlkb_N6mqzL7go"), Set.of("Rock" ), 30, 8245.0, true, ProductType.VINYLS, "-");
			productRepository.save(product5);
			Product product6 = new Product("The Wall", "Pink Floyd","The Wall —en español: El muro— es el undécimo álbum de estudio del grupo musical británica de rock progresivo Pink Floyd y el segundo doble, publicado en 1979. ", "2012", List.of("http://drive.google.com/uc?export=view&id=1CuMJrc6C4Idybf3QZXGHR9dAEGsqp_Xj"), Set.of("Rock"), 69, 14070.0, true, ProductType.VINYLS, "-");
			productRepository.save(product6);
			Product product7 = new Product("Lets Dance", "David Bowie","Let's Dance es el decimoquinto álbum de David Bowie. Fue lanzado originalmente en abril de 1983, tres años después de su álbum anterior, Scary Monsters.", "2019", List.of("http://drive.google.com/uc?export=view&id=1uQ08kj7w5Nr4mdZOBZpv1a4Gk_fWqCnq"), Set.of("Pop"), 75, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product7);
			Product product8 = new Product("14 episodios sinfónicos", "Gustavo Cerati","14 Episodios Sinfónicos es una actualización emocional de las canciones y un tributo a su legado. Una nueva interpretación bajo la reescritura de los temas. Demuestra la capacidad de Gustavo para reinventarse y crear nuevas versiones.", "2022", List.of("http://drive.google.com/uc?export=view&id=1TWir1-Bing9ioFkJMxS68OSChos44v9o"), Set.of("Rock"), 7, 22947.0, true, ProductType.VINYLS, "-");
			productRepository.save(product8);
			Product product9 = new Product("Salud Universal", "Los Visitantes","Salud universal​ es el primer álbum de la banda de rock argentina Los Visitantes. Fue lanzado en el año 1993. ", "2019", List.of("http://drive.google.com/uc?export=view&id=1chL26of8FbmsIf_UeRhOM1OL7PfQNPCv"), Set.of("Pop"), 22, 5650.0, true, ProductType.VINYLS, "-");
			productRepository.save(product9);
			Product product10 = new Product("Harry’s House", "Harry Style","Harry's House (en español: La casa de Harry) es el tercer álbum de estudio del cantautor británico Harry Styles", "2022", List.of("http://drive.google.com/uc?export=view&id=1-vLMWZxJeMhI3gGW_cl0OgjO62ib51Yq"), Set.of("Pop"), 65, 22964.0, true, ProductType.VINYLS, "-");
			productRepository.save(product10);
			Product product11 = new Product("Acariciando lo áspero", "Divididos","Acariciando lo áspero es el segundo álbum de estudio editado por la banda de rock argentina Divididos, lanzado en el año 1991 por la discográfica EMI.​ ", "2022", List.of("http://drive.google.com/uc?export=view&id=1rrWsLlxCtrVwMzz7VBW1inzH9Y8TSWY4"), Set.of("Rock"), 66, 8245.0, true, ProductType.VINYLS, "-");
			productRepository.save(product11);
			Product product12 = new Product("Lo último", "Hermética","Lo último es el primer álbum en vivo póstumo de la banda argentina de thrash metal Hermética, grabado en el Estadio Obras Sanitarias el 12 de noviembre de 1994 y publicado en 1995 por el sello discográfico DBN. ", "2022", List.of("http://drive.google.com/uc?export=view&id=1HMZiVC-_M9i4Mrp6aDf5K-IwKe92h2nE"), Set.of("Heavy Metal"), 66, 6090.0, true, ProductType.VINYLS, "-");
			productRepository.save(product12);
			Product product14 = new Product("Vasos vacíos", "Los Fabulosos Cadillacs","Vasos vacíos es el primer y más premiado álbum recopilatorio del grupo argentino Los Fabulosos Cadillacs, lanzado en 1993. Contiene diecisiete temas, de los cuales dos eran nuevos: V Centenario y Matador", "2020", List.of("http://drive.google.com/uc?export=view&id=1MZWuDn5uOUUEaj2l7g6F3QN3zeRMMXrW"), Set.of("Rock"), 14, 16893.0, true, ProductType.VINYLS, "-");
			productRepository.save(product14);
			Product product15 = new Product("Kind of blue", "David Miles","Kind of Blue —en español: Una especie de tristeza o algún tipo de tristeza— es un álbum de estudio del músico estadounidense de jazz Miles Davis editado en agosto de 1959. ", "2016", List.of("http://drive.google.com/uc?export=view&id=1aAdZw508Ix-QLNAUzdnlmpoaDdAE1Xps"), Set.of("Blues"), 88, 14115.0, true, ProductType.VINYLS, "-");
			productRepository.save(product15);
			Product product16 = new Product("If I can dream: Elvis Presley", "Elvis Presley","If I Can Dream es un álbum recopilatorio del cantante estadounidense Elvis Presley. ", "2016", List.of("http://drive.google.com/uc?export=view&id=1zr_tM5fR2mkLza_4wUypHPjsWvK00UeG"), Set.of("Rock"), 60, 18539.0, true, ProductType.VINYLS, "-");
			productRepository.save(product16);
			Product product17 = new Product("Magical Mistery Tour", "The Beatles","Disco que en Estados Unidos se publicó como el noveno álbum de estudio de la banda de rock británica The Beatles.", "2012", List.of("http://drive.google.com/uc?export=view&id=1ukyR4gU5EA6Qs9QTv2fh-nSrPbsRQiFu"), Set.of("Rock"), 70, 9688.0, true, ProductType.VINYLS, "-");
			productRepository.save(product17);
			Product product18 = new Product("Tattoo You", "Rolling Stones","Tattoo You —en español: Tatúate— es el decimosexto en el Reino Unido y decimoctavo en los Estados Unidos álbum de estudio de la banda de rock británico The Rolling Stones, publicado en 1981.",  "2021", List.of("http://drive.google.com/uc?export=view&id=1AlYJhPIkl0TVo41qoBUfY6gCVFx-YfpM"), Set.of("Rock"), 66, 9874.0, true, ProductType.VINYLS, "-");
			productRepository.save(product18);
			Product product19 = new Product("Chac tu chac","Los Piojos","Chactuchac es el álbum debut del grupo musical de Argentina Los Piojos. El álbum fue grabado y mezclado por Los Piojos y Adrián Rivarola entre junio y agosto del año 1992 en los Estudios Del Cielito.",  "2020", List.of("http://drive.google.com/uc?export=view&id=1dvlxL8ECH5Q5x19n4_q9xsW-_gIvyutA"), Set.of("Rock"), 87, 6090.0, true, ProductType.VINYLS, "-");
			productRepository.save(product19);
			Product product20 = new Product("The colpix single","Simone Nina", "Album recopilatorio de Nina, hecho en un homenaje", "2019", List.of("http://drive.google.com/uc?export=view&id=1U5Z9pHdNKXpXrK-EpxGecumf5YTykB51"), Set.of("Pop"), 99, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product20);
			Product product21 = new Product("50 años de música", "Jairo","Presenta una serie de canciones que han sido y son importantes en la trayectoria del cantante.", "2021", List.of("http://drive.google.com/uc?export=view&id=1PNZXqJ3qSwz7bjD4NKL6FPSSJ7gWTj09"), Set.of("Latino"), 50, 6090.0, true, ProductType.VINYLS, "-");
			productRepository.save(product21);
			Product product22 = new Product("Giant steps","John Coltrane","Giant Steps es el quinto álbum de estudio de John Coltrane como líder. ", "2016", List.of("http://drive.google.com/uc?export=view&id=1Ze34Fg0BxGxdZcoYNxrtJ4_ysX47XG4b"), Set.of("Pop","Pop Rock"), 25, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product22);
			Product product23 = new Product("The number of the beast", "Iron Maiden","Es considerado uno de los mejores álbumes de metal de todos los tiempos. ", "2015", List.of("http://drive.google.com/uc?export=view&id=1qCX565rptWfPPWC_Xz0FtPhb_HidhR8X"), Set.of("Heavy"), 66, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product23);
			Product product24 = new Product("Bad", "Michael Jackson","Bad es el séptimo álbum de estudio del cantante estadounidense.", "2019", List.of("http://drive.google.com/uc?export=view&id=13aB47P5NjRRHmupK61PXk1zVFuTwjkSo"), Set.of("Pop"), 14, 14115.0, true, ProductType.VINYLS, "-");
			productRepository.save(product24);
			Product product25 = new Product("Jagged Little Pill", "Alanis Morissette","Jagged Little Pill es el tercer álbum de estudio y el primero publicado internacionalmente de la cantante canadiense Alanis Morissette. ", "2013", List.of("http://drive.google.com/uc?export=view&id=1WW60z_rfSf7a4PuxFt8bkw999YXxKhZE"), Set.of("Pop"), 18, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product25);
			Product product26 = new Product("Hunting high and low", "A-Ha","Hunting High and Low es el álbum debut de a-ha y el más vendido del grupo. El álbum fue lanzado por Warner Bros. Records en octubre de 1985 e incluye el sencillo de mayor éxito de a-ha.", "2017", List.of("http://drive.google.com/uc?export=view&id=10BHlI5Qnk5QMe-tSckDI2ChwnMk0A351"), Set.of("Pop"), 23, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product26);
			Product product27 = new Product("Van Halen II", "Van Halen","Van Halen II es el segundo álbum del grupo estadounidense de Hard Rock Van Halen, lanzado en 1979.", "2016", List.of("http://drive.google.com/uc?export=view&id=1FYqQ7uYyJoZc6b9SaFJwve5BrTAsSi9t"), Set.of("Pop"), 24, 8755.0, true, ProductType.VINYLS, "-");
			productRepository.save(product27);
			Product product28 = new Product("Love for sale", "Tony Bennet, Lady Gaga","Love for Sale es el segundo álbum de estudio a dueto entre los cantantes y compositores estadounidenses Tony Bennett y Lady Gaga, después de Cheek to Cheek. Es a su vez el sexagésimo primer álbum de estudio grabado por Bennett y el séptimo por Gaga.", "2021", List.of("http://drive.google.com/uc?export=view&id=1ObMIgkkAATNf0lFt3AKkQFMtPgPV2bM-"), Set.of("Pop"), 35, 6872.0, true, ProductType.VINYLS, "-");
			productRepository.save(product28);
			Product product29 = new Product("In the lonely hour", "Sam Smith","In the Lonely Hour es el álbum de estudio debut del cantautor británico Sam Smith. Su lanzamiento al mercado tuvo lugar el 26 de mayo de 2014 en el Reino Unido a través de las compañías discográficas", "2022", List.of("http://drive.google.com/uc?export=view&id=1o3gkg4SzzWjlF7pkKFBxmVK8qyWHoMI4"), Set.of("Pop"), 2, 8229.0, true, ProductType.VINYLS, "-");
			productRepository.save(product29);
			Product product30 = new Product("Chromatica", "Lady Gaga","Chromatica es el sexto álbum de estudio de la cantante y compositora estadounidense Lady Gaga, lanzado el 29 de mayo de 2020 bajo el sello de Interscope Records.​ ", "2020", List.of("http://drive.google.com/uc?export=view&id=1cuLMBOFHB0VnXznuIs_uW_zcRjHcw1bl"), Set.of("Pop"), 78, 8229.0, true, ProductType.VINYLS, "-");
			productRepository.save(product30);
			Product product31 = new Product("Colores santos", "Gustavo Cerati","Colores santos es un álbum de estudio lanzado en el año 1992 realizado por los músicos argentinos Gustavo Cerati y Daniel Melero. Contó con la colaboración de Flavio Etcheto en trompetas y coros de Carola Bony en «Pudo ser». ", "2015", List.of("http://drive.google.com/uc?export=view&id=1OgjauXvk7ab0dPeJaGA33C436KJbPrNW"), Set.of("Rock"), 44, 11034.0, true, ProductType.VINYLS, "-");
			productRepository.save(product31);
			Product product32 = new Product("Ahora", "Pedro Aznar","Ahora es el noveno álbum de estudio del músico argentino Pedro Aznar, lanzado en el año 2012.​ El disco fue grabado en el Estudio Circo Beat y cuenta con una orquesta de cuerdas grabada en Abbey Road Studios.", "2016", List.of("http://drive.google.com/uc?export=view&id=1UkzmGLMcF0vmpTNgv4t7nEozNiJ6X1Fa"), Set.of("Pop"), 63, 5656.0, true, ProductType.VINYLS, "-");
			productRepository.save(product32);
			Product product33 = new Product("El Aguante", "Charly García","El Aguante es el noveno álbum de estudio en solitario del músico argentino Charly García, editado en el año 1998. Una de las curiosidades del disco es Pedro trabaja en el cine que fue un tema de su etapa en Sui Generis que jamás grabó.", "2017", List.of("http://drive.google.com/uc?export=view&id=1aV4hP4YA_vmmEu4G4vKsir7DLyg8N0Xe"), Set.of("Rock"), 10, 1000.0, true, ProductType.VINYLS, "-");
			productRepository.save(product33);
			Product product34 = new Product("Back to black", "Amy Winehouse","Back to Black es el segundo y último álbum de estudio de la cantante británica Amy Winehouse. ", "2016", List.of("http://drive.google.com/uc?export=view&id=1UOYvePTI1F4bJY-y6QGx_up87s99Z28M"), Set.of("Pop"), 85, 12798.0, true, ProductType.VINYLS, "-");
			productRepository.save(product34);
			Product product35 = new Product("Almendra", "Almendra","Almendra fue una banda de rock argentino formada en 1967 en el barrio porteño de Belgrano por Luis Alberto Spinetta, Edelmiro Molinari, Emilio del Guercio y Rodolfo García. ", "2015", List.of("http://drive.google.com/uc?export=view&id=1PpPYbR32dV3z4dxhsqE1qSI11LNVVEI7"), Set.of("Pop"), 5, 10340, true, ProductType.VINYLS, "-");
			productRepository.save(product35);
			Product product36 = new Product("Mi Buenos Aires Querido", "Daniel Barenboim","Los mejores tangos en un solo disco", "2019", List.of("http://drive.google.com/uc?export=view&id=148i-ZxAXo0o7OiBKwZqmdyJi735uzwFm"), Set.of("Tango"), 7, 5912.0, true, ProductType.VINYLS, "-");
			productRepository.save(product36);
			Product product37 = new Product("Hypnotic eye", "Petty Tom","Hypnotic Eye es el decimotercer y último álbum de estudio del grupo estadounidense Tom Petty and the Heartbreakers, publicado por la compañía discográfica Reprise Records en julio de 2014.", "2016", List.of("http://drive.google.com/uc?export=view&id=1ZW1xAvOIsbM1ArV8areL013y0vOJ6QCQ"), Set.of("Pop"), 14, 14004.0, true, ProductType.VINYLS, "-");
			productRepository.save(product37);
			Product product38 = new Product("Por mirarte", "Andrés Calamaro","Por mirarte es el tercer disco solista de Andrés Calamaro. Publicado en 1988, se puede considerar como el primer álbum de rock de Calamaro.", "2016", List.of("http://drive.google.com/uc?export=view&id=1ZBGLIOZBHXvS2naq4JvtZ-nMfMJRjnOa"), Set.of("Rock"), 18, 11034.0, true, ProductType.VINYLS, "-");
			productRepository.save(product38);
			Product product39 = new Product("Brasil super éxitos", "Varios","El mejor compilado que animará todas tus fiestas", "2021", List.of("http://drive.google.com/uc?export=view&id=1nhWRoh5u7oISJBDOTjx66D-2xlCGn8N0"), Set.of("Carioca"), 29, 5659.0, true, ProductType.VINYLS, "-");
			productRepository.save(product39);
			Product product40 = new Product("True Blue", "Madonna","True Blue es el tercer álbum de estudio de la cantante estadounidense Madonna, publicado el 30 de junio de 1986 por la compañía discográfica Sire Records.​", "2012", List.of("http://drive.google.com/uc?export=view&id=1C7n31c8i9DsxH3eieYKcMIYxXALYnYwa"), Set.of("Pop"), 3, 6205.0, true, ProductType.VINYLS, "-");
			productRepository.save(product40);
			Product product41 = new Product("Crystal silence", "Gary Burton","Crystal Silence es un álbum del pianista Chick Corea y el vibrafonista Gary Burton. ", "2018", List.of("http://drive.google.com/uc?export=view&id=1sAH66DGrJ7uwoRHRD1vO5OVuMvRxeK9b"), Set.of("Pop"), 5, 6511.0, true, ProductType.VINYLS, "-");
			productRepository.save(product41);
			Product product42 = new Product("Llegando los monos", "Sumo","Fue publicado el 22 de mayo de 1986 por Sony Music.", "2019", List.of("http://drive.google.com/uc?export=view&id=1uEosMENdZYBCy4nRICz2fqeny90LqCNB"), Set.of("Rock"), 8, 11034.0, true, ProductType.VINYLS, "-");
			productRepository.save(product42);
			Product product43 = new Product("Why me? Why not", "Liam Gallagher","Why Me? Why Not. es el segundo álbum de estudio del cantante y compositor británico Liam Gallagher, fue lanzado el 20 de septiembre de 2019 por Warner Bros", "2020", List.of("http://drive.google.com/uc?export=view&id=1RwAKDlT2b0ykieAOtgY0EVLanVQhcxUO"), Set.of("Rock"), 3, 8957.0, true, ProductType.VINYLS, "-");
			productRepository.save(product43);
			Product product44 = new Product("La la la doble", "Spinetta & Paez","Se trata de un álbum doble, fue grabado en el año 1995 en el estudio personal de Spinetta La Diosa Salvaje y publicado en 1997.", "2021", List.of("http://drive.google.com/uc?export=view&id=1PJw4WLxBP2mK4sy6NOXnL4KPxOQ9baEB"), Set.of("Rock"), 23, 11270.0, true, ProductType.VINYLS, "-");
			productRepository.save(product44);
			Product product45 = new Product("Mediterraneo", "Joan Manuel Serrat","Mediterráneo es el octavo álbum y el más reconocido del cantautor Joan Manuel Serrat, editado en 1971 por la compañía discográfica Zafiro/Novola", "2019", List.of("http://drive.google.com/uc?export=view&id=1_z8T5k5-dN8hoJF3UiUZLO1OHF_93Dqu"), Set.of("Español"), 7, 11270.0, true, ProductType.VINYLS, "-");
			productRepository.save(product45);
			Product product46 = new Product("Three tenors in concert 1994", "Carreras, Domingo, Pavarotti, Mehta","Los Tres Tenores en concierto 1994 es un álbum en vivo cantado por José Carreras, Plácido Domingo y Luciano Pavarotti dirigido por Zubin Mehta. El álbum fue grabado el 16 de julio de 1994", "2017", List.of("http://drive.google.com/uc?export=view&id=1xOAyS4zaqESqInbEuWIapQTg9JNGBftX"), Set.of("Clasica"), 8, 10774.0, true, ProductType.VINYLS, "-");
			productRepository.save(product46);
			Product product47 = new Product("Esta boca es mía", "Joaquin Sabina","Esta boca es mía es el noveno disco del cantautor español Joaquín Sabina, puesto a la venta en 1994 y del cual se han vendido 200 000 ejemplares.", "2019", List.of("http://drive.google.com/uc?export=view&id=1h3us1iEGCE6WopkWMfK_OAPWnhZPmD8Q"), Set.of("Español"), 6, 11034.0, true, ProductType.VINYLS, "-");
			productRepository.save(product47);
			Product product48 = new Product("Romántico en el Teatro Colon", "Luciano Pereyra","Lo mejor de Luciano en una obra exquisita en el gran Teatro Colón", "2019", List.of("http://drive.google.com/uc?export=view&id=1wn59GQ7kekipFddHW3TXnxoGfhxgOn5a"), Set.of("Folklore"), 25, 3438.0, true, ProductType.VINYLS, "-");
			productRepository.save(product48);
			Product product51 = new Product("The Dark Side of the Moon", "Pink Floyd","El álbum está construido a partir de las ideas que Pink Floyd había explorado en sus conciertos y anteriores grabaciones", "1973", List.of("https://upload.wikimedia.org/wikipedia/commons/c/c7/The_Dark_Side_of_the_Moon_Cover.svg"), Set.of("Rock progresivo"), 25, 4000.0, true, ProductType.VINYLS, "-");
			productRepository.save(product51);


//			Product product50 = new Product("Wish you were here", "Pink Floyd","Wish You Were Here —en español: Ojalá estuvieras aquí— es el noveno álbum de estudio de la banda británica de rock Pink Floyd, lanzado en septiembre de 1975 e inspirado en el material que compusieron durante su gira europea de 1974 y que grabaron en los Abbey Road Studios de Londres. ", "2011", List.of("https://drive.google.com/file/d/1F1FW-NycrXZGUFdd-oEpl_SG56UvdQ1U/view?usp=sharing"), Set.of("Rock"), 42, 14540.0, true, ProductType.VINYLS, "-");
//			productRepository.save(product50);


			Product tocadisco1 = new Product("Tocadisco", "-","Tocadisco retro vinilo con usb, aux, mp3, Cd + Radio", "2022", List.of("http://drive.google.com/uc?export=view&id=14Z9Qq-FupZNazS7hz-gEj4exR_0f29-I"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 20, 224979.99, true, ProductType.RECORDPLAYER, "Victrola");
			productRepository.save(tocadisco1);
			Product tocadisco2 = new Product("Tocadisco", "-","Tocadiscos Vintage en madera con mueble y radio, 220V, para pasar 2 tamaños de disco (33 y 78)", "1970", List.of("http://drive.google.com/uc?export=view&id=1JCrDsrtlZZI9bU9eAYkyUi61m0yZxO3_"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 1, 18000.00, false, ProductType.RECORDPLAYER, "Winco");
			productRepository.save(tocadisco2);
			Product tocadisco3 = new Product("Tocadisco", "-","Tocadiscos Vinilo Winco, incluye 2 altavoces stereo, echo en madera", "2022", List.of("http://drive.google.com/uc?export=view&id=1hcoBOPhz5VdgpuUG1WjTVNex6TpiIt7O"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 8, 26999.00, false, ProductType.RECORDPLAYER, "Winco Fon");
			productRepository.save(tocadisco3);
			Product tocadisco4 = new Product("Tocadisco", "-","Bandeja Maratz totalmente funcional, porta capsula original, sonido stereo, 110V", "1980", List.of("http://drive.google.com/uc?export=view&id=15zYex5tCVrYGR0i5ixNqSSoFZsNpkF3N"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 1, 169500.00, false, ProductType.RECORDPLAYER, "Marantz");
			productRepository.save(tocadisco4);
			Product tocadisco5 = new Product("Tocadisco", "-","Tocadiscos de accionamiento directo con retorno automático. Plato: aleación de aluminio fundido a presión de 320 mm", "1978", List.of("http://drive.google.com/uc?export=view&id=1_WL9-6WHsYqUobZ2UBKsL1CjbseeRCab"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 1, 155000.00, false, ProductType.RECORDPLAYER, "Pioneer PL-540");
			productRepository.save(tocadisco5);
			Product tocadisco6 = new Product("Tocadisco", "-","Tocadisco Vinilo Vintage Disco Bluetooth Sd Rca Aux Gadnic. Conexión Bluetooth 5.0. Reproduce discos de 7, 10 ó 12 pulgadas.3 velocidades de reproducción 33, 45 y 78 rpm", "2022", List.of("http://drive.google.com/uc?export=view&id=1mBnnSPF-HPwpZSTQ5rGQUC092EiNan1A"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 12, 155000.00, true, ProductType.RECORDPLAYER, "Gadnic Soundix6");
			productRepository.save(tocadisco6);
			Product tocadisco7 = new Product("Tocadisco", "-","Tocadisco Bluetooth Gadnic Portatil Vinilo Vintage SD Rca + Puas + Cargador, 220V", "2022", List.of("http://drive.google.com/uc?export=view&id=1mBnnSPF-HPwpZSTQ5rGQUC092EiNan1A"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 22, 31299.00, true, ProductType.RECORDPLAYER, "Gadnic TOCADIS1X");
			productRepository.save(tocadisco7);
			Product tocadisco8 = new Product("Tocadisco", "-","Tocadiscos Vinilo Bluetooth Spica Sp-T90 Vintage Parlante. Batería interna recargable de 2500 mAh. Luz led", "2022", List.of("http://drive.google.com/uc?export=view&id=1BUwcwNdOqXEbg6lwjv60K91cwgTEW3qs"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 10, 29999.00, true, ProductType.RECORDPLAYER, "Spica");
			productRepository.save(tocadisco8);
			Product tocadisco9 = new Product("Tocadisco", "-","El tocadiscos es elaborado en acero, inserciones de alumino y madera de nogal de bosques norteamericanos", "2017", List.of("http://drive.google.com/uc?export=view&id=1AqPPVODNdvV8411iBxrYy4-oJcfbKKe9"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 10, 880000.00, true, ProductType.RECORDPLAYER, "Loft");
			productRepository.save(tocadisco9);
			Product tocadisco10 = new Product("Tocadisco", "-","Consola estéreo de los años 60 con tocadiscos, radio y cassette, modelo RG 87 5-ET, de la casa española VICA. Tocadiscos automático, estereofónico, de cuatro velocidades y tres diámetros de disco.", "1960", List.of("http://drive.google.com/uc?export=view&id=1Njz5VEfLcRh0m07XjjHsAIlC1aw9pWSE"), Set.of("Tocadiscos, reproductor de vinilos, bandeja giradisco"), 2, 60000.00, false, ProductType.RECORDPLAYER, "VICA");
			productRepository.save(tocadisco10);

			
			Bill bill1 = new Bill("11111 1111",200.00 ,Delivery.AMBA , 1000.00, 900.00, 1200.00 ,LocalDateTime.now(), client1);
			Bill bill2 = new Bill("2222 2222", 300.00,Delivery.CABA, 1000.00, 900.00, 1300.00 ,LocalDateTime.now(), client1);
			billRepository.save(bill1);
			billRepository.save(bill2);

			ProductBill pb1 = new ProductBill(2, product1, bill1);
			ProductBill pb2 = new ProductBill(2, product2, bill1);
			ProductBill pb3 = new ProductBill(2, product2, bill2);

			productBillRepository.save(pb1);
			productBillRepository.save(pb2);
			productBillRepository.save(pb3);


			//bill(String number, Double deliveryAmount, Double grossAmount, Double netAmount, LocalDateTime date, Client client)
			//productbill(Integer quantity, Product product, Bill bill)


		};
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
