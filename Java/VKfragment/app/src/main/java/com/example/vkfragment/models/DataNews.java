package com.example.vkfragment.models;

import com.example.vkfragment.R;
import com.example.vkfragment.models.News;

import java.util.ArrayList;
import java.util.List;

public class DataNews {
    public static List<News> news = new ArrayList<>();
    static {
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<String> imageName = new ArrayList<>();
        ArrayList<Integer> imageContent = new ArrayList<>();
        ArrayList<String> timeName = new ArrayList<>();
        ArrayList<String> contentName = new ArrayList<>();

        image.add(R.drawable.logo1);
        imageName.add("Илон Маск");
        imageContent.add(R.drawable.contentlogo1);
        timeName.add("15 минут назад");
        contentName.add("Tesla — американская компания, производитель электромобилей и решений для хранения электрической энергии. Компания была основана в июле 2003 года Мартином Эберхардом и Марком Тарпеннингом, но сама компания считает Илона Маска, Джеффри Брайана Штробеля и Иэна Райта её сооснователями.");

        image.add(R.drawable.naturelogo);
        imageName.add("Nature");
        imageContent.add(R.drawable.naturecontent);
        timeName.add("47 минут назад");
        contentName.add("Nature (в переводе с англ. — «Природа») — один из самых старых и авторитетных общенаучных журналов. Публикует исследования, посвящённые широкому кругу вопросов, в основном естественно-научной тематики");

        image.add(R.drawable.logo1);
        imageName.add("Илон Маск SPACEX");
        imageContent.add(R.drawable.spacex);
        timeName.add("2 часа назад");
        contentName.add("Space Exploration Technologies Corporation — американская компания, производитель космической техники со штаб-квартирой в городе Хоторн, Калифорния, США. Основана в 2002 году прежним акционером PayPal и CEO Tesla Motors Илоном Маском с целью сократить расходы на полёты в космос и для открытия пути к колонизации Марса");

        image.add(R.drawable.naturelogo);
        imageName.add("Nature");
        imageContent.add(R.drawable.mountaincontent);
        timeName.add("30 минут назад");
        contentName.add("Вершина находится в Гималаях в хребте Махалангур-Химал, по которому проходит граница Непала и Тибетского автономного района (Китай).\n" +
                "\n" +
                "Эверест имеет форму трёхгранной пирамиды, южный склон более крутой. На южном склоне и рёбрах снег и фирн не удерживаются, вследствие чего они обнажены. Высота Северо-восточного плеча — 8393 м. Высота от подножия до вершины — около 3550 м. Вершина состоит в основном из осадочных отложений.");

        image.add(R.drawable.naturelogo);
        imageName.add("Nature");
        imageContent.add(R.drawable.northernlights);
        timeName.add("25.02.2020");
        contentName.add("Лучше всего наблюдать сияние в высоких широтах: 67–70°. В Северном полушарии это территория от Аляски до севера Скандинавского полуострова. Иногда сполохи можно увидеть и южнее: при сильной солнечной активности явление наблюдали и в Шотландии, и даже в центральной части России, но это сияние лишь бледное подобие северного.");

        image.add(R.drawable.kinopoisklogo);
        imageName.add("Кино");
        imageContent.add(R.drawable.nozhicontent);
        timeName.add("пол года назад");
        contentName.add("Знаменитый автор детективов Харлан Тромби умирает во время празднования своего 85-летия, в котором участвуют его работники и родственники. На место событий прибывают детективы. Все указывает на убийство, а значит, следователям предстоит вычислить преступника, прячущегося среди гостей.");

        image.add(R.drawable.logo1);
        imageName.add("Илон Маск HYPERLOOP");
        imageContent.add(R.drawable.hyperloop);
        timeName.add("Год назад");
        contentName.add("Hyperloóp — проект вакуумного поезда, предложенный в 2013 году американским венчурным предпринимателем Илоном Маском. До конца не реализован. На сегодняшний день построены испытательные полигоны в Хоторне и Лас-Вегасе. Возводится также полигон в Тулузе.");

        image.add(R.drawable.logo1);
        imageName.add("Илон Маск NEURALINK");
        imageContent.add(R.drawable.ai);
        timeName.add("2 года назад");
        contentName.add("Neuralink — американская нейротехнологическая компания, основанная Илоном Маском, планирующая заниматься разработкой и производством имплантируемых нейрокомпьютерных интерфейсов. Штаб-квартира компании расположена в Сан-Франциско..");

        image.add(R.drawable.naturelogo);
        imageName.add("Nature");
        imageContent.add(R.drawable.bh);
        timeName.add("3 года назад");
        contentName.add("Tesla — американская компания, производитель электромобилей и решений для хранения электрической энергии. Компания была основана в июле 2003 года Мартином Эберхардом и Марком Тарпеннингом, но сама компания считает Илона Маска, Джеффри Брайана Штробеля и Иэна Райта её сооснователями.");

        image.add(R.drawable.logo1);
        imageName.add("Илон Маск Мысли");
        imageContent.add(R.drawable.mars);
        timeName.add("27.03.2015");
        contentName.add("В силу относительно небольшого расстояния до нашей планеты и природных характеристик, Марс, наряду с Луной является самым вероятным кандидатом на основание колонии людей в обозримом будущем. Путешествие к Марсу с Земли требует наименьших энергетических затрат, если не считать Венеры");

        for (int i = 0; i < image.size(); i++) {
            News newsEach = new News(
                    imageName.get(i),
                    timeName.get(i),
                    contentName.get(i),
                    image.get(i),
                    imageContent.get(i),
                    i,
                    i,
                    i,
                    i,
                    0
            );
            news.add(newsEach);
        }
    }
}
