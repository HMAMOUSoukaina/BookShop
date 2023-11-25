package com.example.bookshop;

import android.content.Context;

public class ManualDataInsertion {

    public static void insertDummyData(Context context) {
        BooksBDHelper dbHelper = new BooksBDHelper(context);

        // Catégorie : Arts
        dbHelper.addBook(new BookItem("The Art of War", 0, "https://th.bing.com/th/id/OIP.TibaEfhGH0eR8qR_KcAUjAHaMK?rs=1&pid=ImgDetMain", "Sun Tzu", "Arts",15));
        dbHelper.addBook(new BookItem("The Last Supper", 0, "https://th.bing.com/th/id/OIP.qH8gcGUVTE-YycUvKK9ZVQHaLL?rs=1&pid=ImgDetMain", "Leonardo da Vinci", "Arts",14));
        dbHelper.addBook(new BookItem("The Birth of Venus", 0, "https://th.bing.com/th/id/OIP.J--ODMjFcjMHnlQTrE23XAAAAA?rs=1&pid=ImgDetMain", "Sandro Botticelli", "Arts",20));
        dbHelper.addBook(new BookItem("The Starry Night", 0, "https://www.phanpha.com/sites/default/files/imagecache/product_full/book02/9786167079608.JPG", "Vincent van Gogh", "Arts",9));
        dbHelper.addBook(new BookItem("The Persistence of Memory", 0, "https://th.bing.com/th/id/OIP.BA5GawCVd-DovMi9zMqGPAHaLF?rs=1&pid=ImgDetMain", "Salvador Dalí", "Arts",10));
        dbHelper.addBook(new BookItem("The Scream", 0, "https://th.bing.com/th/id/R.693e7dff3ed6966442669f1b874a3777?rik=U1XYkEjbz2UQgg&pid=ImgRaw&r=0", "Edvard Munch", "Arts",12));
        dbHelper.addBook(new BookItem("The Great Wave of Kanagawa", 0, "https://images-na.ssl-images-amazon.com/images/I/61mYkuyKn9L._SX218_BO1,204,203,200_QL40_ML2_.jpg", "Hokusai", "Arts",14));
        dbHelper.addBook(new BookItem("The Night Café", 0, "https://example.com/night_cafe.jpg", "Vincent van Gogh", "Arts",12));

        // Catégorie : Literature
        dbHelper.addBook(new BookItem("To Kill a Mockingbird", 0, "https://example.com/to_kill_a_mockingbird.jpg", "Harper Lee", "Literature",12));
        dbHelper.addBook(new BookItem("1984", 0, "https://example.com/1984.jpg", "George Orwell", "Literature",10));
        dbHelper.addBook(new BookItem("The Great Gatsby", 0, "https://example.com/great_gatsby.jpg", "F. Scott Fitzgerald", "Literature",22));
        dbHelper.addBook(new BookItem("The Catcher in the Rye", 0, "https://example.com/catcher_in_the_rye.jpg", "J.D. Salinger", "Literature",15));
        dbHelper.addBook(new BookItem("Pride and Prejudice", 0, "https://example.com/pride_and_prejudice.jpg", "Jane Austen", "Literature",11));
        dbHelper.addBook(new BookItem("The Lord of the Rings", 0, "https://example.com/lord_of_the_rings.jpg", "J.R.R. Tolkien", "Literature",14));
        dbHelper.addBook(new BookItem("Crime and Punishment", 0, "https://example.com/crime_and_punishment.jpg", "Fyodor Dostoevsky", "Literature",19));
        dbHelper.addBook(new BookItem("The Hobbit", 0, "https://example.com/hobbit.jpg", "J.R.R. Tolkien", "Literature",17));


        // Catégorie : History
        dbHelper.addBook(new BookItem("The Guns of August", 0, "https://example.com/guns_of_august.jpg", "Friedrich von Bernhardi", "History",10));
        dbHelper.addBook(new BookItem("The Rise and Fall of the Third Reich", 0, "https://example.com/rise_and_fall.jpg", "William L. Shirer", "History",12));
        dbHelper.addBook(new BookItem("The Time of the Revolutions", 0, "https://example.com/time_of_revolutions.jpg", "Daniel de Montplaisir", "History",20));
        dbHelper.addBook(new BookItem("In the Shadow of Empires", 0, "https://example.com/in_the_shadow.jpg", "Germain Payen", "History",23));
        dbHelper.addBook(new BookItem("The Age of Persia", 0, "https://example.com/age_of_persia.jpg", "Yves Bomati", "History",13));
        dbHelper.addBook(new BookItem("Une autre histoire de la Renaissance", 0, "https://example.com/another_renaissance.jpg", "Didier Le Fur", "History",16));
        dbHelper.addBook(new BookItem("The Embracing of the World", 0, "https://example.com/embracing_of_the_world.jpg", "Victor Court", "History",11));
        dbHelper.addBook(new BookItem("The Scepter and the Pen", 0, "https://example.com/scepter_and_pen.jpg", "Bruno de Cessole", "History",20));

        // Catégorie : Philosophy
        dbHelper.addBook(new BookItem("Meditations", 0, "https://example.com/meditations.jpg", "Marcus Aurelius", "Philosophy",14));
        dbHelper.addBook(new BookItem("The Republic", 0, "https://example.com/the_republic.jpg", "Plato", "Philosophy",17));
        dbHelper.addBook(new BookItem("The Significance of the New Logic", 0, "https://example.com/significance_of_new_logic.jpg", "Willard Van Orman Quine", "Philosophy",18));
        dbHelper.addBook(new BookItem("The Vices of Knowledge", 0, "https://example.com/vices_of_knowledge.jpg", "Pascal Engel", "Philosophy",10));
        dbHelper.addBook(new BookItem("The Courage to Think the Future", 0, "https://example.com/courage_to_think.jpg", "Christoph Theobald", "Philosophy",10));
        dbHelper.addBook(new BookItem("Reduced to Nothing", 0, "https://example.com/reduced_to_nothing.jpg", "Rémy Valléjo", "Philosophy",10));
        dbHelper.addBook(new BookItem("On the Traces of Jesus", 0, "https://example.com/traces_of_jesus.jpg", "Jean Zumstein", "Philosophy",10));
        dbHelper.addBook(new BookItem("The Great Gatsby", 0, "https://example.com/great_gatsby.jpg", "F. Scott Fitzgerald", "Philosophy",20));

        // Catégorie : Religion
        dbHelper.addBook(new BookItem("The Bible", 0, "https://example.com/the_bible.jpg", "Various Authors", "Religion",20));
        dbHelper.addBook(new BookItem("The Quran", 0, "https://example.com/the_quran.jpg", "Various Authors", "Religion",9));
        dbHelper.addBook(new BookItem("Croire en Jésus selon Jean", 0, "https://example.com/croire_en_jesus.jpg", "Yves Simoens", "Religion",7));
        dbHelper.addBook(new BookItem("Le courage de penser l’avenir", 0, "https://example.com/courage_to_think.jpg", "Christoph Theobald", "Religion",8));
        dbHelper.addBook(new BookItem("Réduit à rien", 0, "https://example.com/reduced_to_nothing.jpg", "Rémy Valléjo", "Religion",15));
        dbHelper.addBook(new BookItem("Sur les traces de Jésus", 0, "https://example.com/traces_of_jesus.jpg", "Jean Zumstein", "Religion",9));
        dbHelper.addBook(new BookItem("The Great Gatsby", 0, "https://example.com/great_gatsby.jpg", "F. Scott Fitzgerald", "Religion",10));
        dbHelper.addBook(new BookItem("The Hobbit", 0, "https://example.com/hobbit.jpg", "J.R.R. Tolkien", "Religion",9));

        // Catégorie : Science
        dbHelper.addBook(new BookItem("A Brief History of Time", 0, "https://example.com/brief_history.jpg", "Stephen Hawking", "Science",10));
        dbHelper.addBook(new BookItem("The Selfish Gene", 0, "https://example.com/selfish_gene.jpg", "Richard Dawkins", "Science",12));
        dbHelper.addBook(new BookItem("The Embracing of the World", 0, "https://example.com/embracing_of_the_world.jpg", "Victor Court", "Science",9));


    }
}
