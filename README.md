#  Java Maps


## Hedeflerimiz:

### Company needs your help
* Şirketimize eleman alımı yapılırken muhasebemizde bazı kullanıcıların aynı id ile kayıt edildiklerini gorduk. Bu durumu düzeltmek için senin yardımın gerekli.
* org.example.entity paketi altında```Employee``` isimli bir sınıf tanımlamalısın. İçerisinde id, firstname ve lastname değerleri olmalı. 
* Tüm ```sınıf değişkenleri``` private olarak tanımlanmalı.
* Employee sınıfının tek bir constructor değeri olmalı ve bu 3 parametreyi de alıp set edebilmeli.
* org.example paketi altında bulunan Main sınıfı içerisinde bir adet  ```LinkedList``` tanımlayın. İçerisine istediğiniz kadar employee ekleyiniz. Tekrar eden employee lerde ekleyiniz.
* Main sınıfı içerisinde ```findDuplicates``` isimli bir method tanımla. Input olarak bir adet List almalı.
* Senden isteğimiz findDuplicates methodu içerisinde tekrar eden employeeleri başka bir listeye eklemen ve bu listeyi return etmen.
* Main sınıfı içerisinde Bir method daha yazmalısın ```findUniques``` Input olarak bir adet List almalı.
* ```findUniques``` LinkedList içerisinde geçen tekrar eden elemanlardan sadece bir tanesini ve tekrar etmeyen eleman varsa bu elemanları bulup bir mape eklemeli.
* Main sınıfı içerisinde ```removeDuplicates``` adında bir method daha yazmalısın. Input olarak bir adet List almalı. ```LinkedList``` list içerisinde bir data birden fazla kez geçiyorsa hepsini silmeli. Sadece tek geçen kayıtları bir listeye eklemeli ve bu listeyi dönmeli.
* Bir adet LinkedList ve HashMap kullanman çözümde zorunludur. Kalan tüm kısımları istediğiniz gibi yapabilirsiniz.

### Find Count of All Words
* org.example paketi altında WordCounter adında bir sınıf tanımlayınız.
* Bu projedeki amacımız aşağıdaki şekilde verilmiş olan text içerisinde her kelimenin kaç kez geçtiğini bulmak.
* Çözümünüzün ```time Complexity``` değeri O(n) komplesitiden daha fazla olmamalı.
* "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
  " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
  " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
  " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
  " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
  " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
  " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
  " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
  " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
  " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
  " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";
* WordCounter sınıfı içerisinde static ```calculateWord``` adında bir method tanımlamalısın. Tüm işlemleri bu method içerisinde yapmalasın.
* Method dönüş tipi olarak ```Map<String,Integer>``` tipinde bir dönüşe sahip olmalı. Map içerisinde key kısmı, textin içerisindeki her bir kelimeye denk gelmeli. Value kısmı bu kelimenin toplamda kaç kez tekrar ettiğini tutmalı.


### ⚠️ Skorun NextGen'e Kaydedilmediyse

Eğer testleri çalıştırdığın halde skorun NextGen'e kaydedilmediyse, önce fork'unun güncel olup olmadığını kontrol et:

1. GitHub reponu aç.
2. Repo **X commit ahead** ve **X commits behind** şeklinde bir uyarı gösteriyorsa, branch'in güncel değildir.
3. **Sync fork → Update branch** adımlarını uygula.
4. Ardından localinde şu komutu çalıştır:

```bash
   git pull
```

5. Testleri tekrar çalıştır. Bu adımdan sonra skorun güncellenmiş olacaktır.

> **Not:** Bu kontrolü yapmadan tekrar tekrar test çalıştırmak sorunu çözmez; sorunun kaynağı genellikle fork'un upstream repository ile senkron olmamasıdır.
