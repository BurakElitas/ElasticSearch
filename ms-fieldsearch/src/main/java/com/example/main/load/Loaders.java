package com.example.main.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.main.dao.ArticleRepository;
import com.example.main.dao.BookRepository;
import com.example.main.document.Article;
import com.example.main.document.Book;


@Component
public class Loaders {

	@Autowired
	private ElasticsearchOperations customElasticsearchTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	@PostConstruct
	@Transactional
	public void loadAll() {

		customElasticsearchTemplate.putMapping(Article.class);
		System.out.println("Loading Data");
		articleRepository.saveAll(getData());
		bookRepository.saveAll(getBooks());
		System.out.println("Loading Completed");

	}

	private List<Article> getData() {
		List<Article> users = new ArrayList<>();
		users.add(new Article("10","Fenerbahçe'de transferde hareketli saatler yaşanıyor","Fenerbahçe’nin bir süredir"
				+ " transfer için görüştüğü Danimarkalı stoper Zanka İstanbul’a geldi.Sabaha karşı 04.30’da İstanbul’a iniş yapan Danimarkalı futbolcuyu Fenerbahçe Sportif Direktörü Damien Comolli ve Yönetim Kurulu Üyesi Selahattin Baki karşıladı." + 
				"Zanka’ya havalimanında bulunan taraftarlar ilgi gösterirken 29 yaşındaki futbolcu daha sonra özel araçla İstanbul Havalimanı’ndan ayrıldı." + 
				 
				"Sırp oyuncunun kendisiyle her konuda anlaşan Sarı-Lacivertliler, Roma ile yaptığı görüşmelerde de sona geldi. Arada ufak detaylar kaldı." + 
				
				"Fenerbahçe yönetiminin bu sıkıntıları da bugün çözmesi ve 33 yaşındaki oyuncuyu açıklayarak en geç Cuma günü İstanbul’a getirmesi bekleniyor." 
				
				,"Burak Elitaş"));
		users.add(new Article("5","İzmir'de korkutan deprem","İzmir'in Seferihisar bir ilçesinde 4,8 büyüklüğünde deprem meydana geldi." + 
				"Afet ve Acil Durum Yönetimi Başkanlığından (AFAD) alınan bilgiye göre, Seferihisar'da saat 11.39'da 4,8 büyüklüğünde deprem kaydedildi.Depremin 18,47 kilometre derinlikte gerçekleştiği belirlendi."
				
				,"Burak Elitaş"));
		
		return users;

	}
	private List<Book> getBooks(){

		Book b1=new Book("1","Suç ve Ceza",12.99,"Rodya Romanoviç Raskolnikov yoksul bir gençtir; "
				+ "Petesburg Üniversitesi'ndeki hukuk öğrenimini yarıda bırakır. Aklı Batı'dan gelen siyasi ve felsefi düşüncelerle karmakarışıktır. Nefret edilen, kötü bir tefeciyi öldürecektir."
				+ " Böylece finansal problemlerini çözerken aynı zamanda dünya kötü, değersiz bir parazitten temizlenecektir. "
				+ "Raskolnikov, daha yüksek bir amaca hizmet eden bir cinayetin kabul edilebilir olduğuna inanır. Bir sürü hesap kitaptan "
				+ "sonra harekete geçer ve kadının evine giderek onu baltayla vahşice öldürür. O anda, Alonya ile birlikte yaşayan ve kimseye bir zararı dokunmayan üvey kız kardeşi beklenmedik biçimde "
				+ "içeri girdiğinden, Raskolnikov onu da öldürmek zorunda kalır. Müşterilerin rehin için bıraktıkları birkaç küçük "
				+ "süs eşyasını alır ve kimseye görünmeden oradan ayrılır","Fyodor Dostoyevski","Macera");
		Book b2=new Book("2","Şeker Portakalı",17.99,"Şeker Portakalı İnomera 5 yaşındaki Zeze isimli bir çocuğun acı hikayesini anlatıyor. Çok fakir bir ailenin çocuklarından biri olan "
				+ "ve 5 yaşında olmasına rağmen hayal gücü ve zekası çok gelişmiş olan Zeze çok yaramaz bir çocuktur ve o yüzden mahalle için şeytan olarak anılmaktadır." + 
				"Çok meraklı olan ve çevresindeki her şeyi keşfetmeye çalışan bu çocuğun diğer ilginç noktası ise okumayı çok erken çözmesidir. Bu yüzden öğretmeni tarafından "
				+ "sevilen ve Zeze’nin şeytan olmadığı bir tek öğretmeni kendisi gibi sarışın olan ablası inanmaktadır.","José Mauro de Vasconcelos","Fantastik");
		Book b3=new Book("3","Orman",12.99,"Yirmi yıl önce, yaz kampındaki dört genç bir gece yarısı ormana girmiş; sonrasında ikisi ölü bulunmuş, diğer ikisinden de bir daha haber alınamamıştır."
				+ " Ancak şimdi, hayatları allak bullak olan bu dört aileyi yeni gerçekler beklemektedir.New Jersey, Essex savcısı Paul Copeland kız kardeşini ve karısını kaybetmenin acısını yüreğine gömmüş, kendini altı yaşındaki kızına adamıştır. Aile hayatının sorumlulukları"
				+ " ve fırtınalı meslek yaşantısı geçmişteki acılarını biraz olsun unutmasına yardımcı olmaktadır. ","Harlan Coben","Korku");
		Book b4=new Book("4","Orman",12.99,"Yirmi yıl önce, yaz kampındaki dört genç bir gece yarısı ormana girmiş; sonrasında ikisi ölü bulunmuş, diğer ikisinden de bir daha haber alınamamıştır."
				+ " Ancak şimdi, hayatları allak bullak olan bu dört aileyi yeni gerçekler beklemektedir.New Jersey, Essex savcısı Paul Copeland kız kardeşini ve karısını kaybetmenin acısını yüreğine gömmüş, kendini altı yaşındaki kızına adamıştır. Aile hayatının sorumlulukları"
				+ " ve fırtınalı meslek yaşantısı geçmişteki acılarını biraz olsun unutmasına yardımcı olmaktadır. ","Harlan Coben","Fantastik");
		
		Book b5=new Book("5","Ahmet",12.99,"Yirmi yıl önce, yaz kampındaki dört genç bir gece yarısı ormana girmiş; sonrasında ikisi ölü bulunmuş, diğer ikisinden de bir daha haber alınamamıştır."
				+ " Ancak şimdi, hayatları allak bullak olan bu dört aileyi yeni gerçekler beklemektedir.New Jersey, Essex savcısı Paul Copeland kız kardeşini ve karısını kaybetmenin acısını yüreğine gömmüş, kendini altı yaşındaki kızına adamıştır. Aile hayatının sorumlulukları"
				+ " ve fırtınalı meslek yaşantısı geçmişteki acılarını biraz olsun unutmasına yardımcı olmaktadır. ","Harlan Coben","Fantastik");
		Book b6=new Book("6","Onör",12.99,"Yirmi yıl önce, yaz kampındaki dört genç bir gece yarısı ormana girmiş; sonrasında ikisi ölü bulunmuş, diğer ikisinden de bir daha haber alınamamıştır."
				+ " Ancak şimdi, hayatları allak bullak olan bu dört aileyi yeni gerçekler beklemektedir.New Jersey, Essex savcısı Paul Copeland kız kardeşini ve karısını kaybetmenin acısını yüreğine gömmüş, kendini altı yaşındaki kızına adamıştır. Aile hayatının sorumlulukları"
				+ " ve fırtınalı meslek yaşantısı geçmişteki acılarını biraz olsun unutmasına yardımcı olmaktadır. ","Harlan Coben","Fantastik");
		Book b7=new Book("7","Zeynebe",12.99,"Yirmi yıl önce, yaz kampındaki dört genç bir gece yarısı ormana girmiş; sonrasında ikisi ölü bulunmuş, diğer ikisinden de bir daha haber alınamamıştır."
				+ " Ancak şimdi, hayatları allak bullak olan bu dört aileyi yeni gerçekler beklemektedir.New Jersey, Essex savcısı Paul Copeland kız kardeşini ve karısını kaybetmenin acısını yüreğine gömmüş, kendini altı yaşındaki kızına adamıştır. Aile hayatının sorumlulukları"
				+ " ve fırtınalı meslek yaşantısı geçmişteki acılarını biraz olsun unutmasına yardımcı olmaktadır. ","Harlan Coben","Fantastik");
		
		List<Book> books=new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		books.add(b6);
		books.add(b7);
		return books;
	}

}
