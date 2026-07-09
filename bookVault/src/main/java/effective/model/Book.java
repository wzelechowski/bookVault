package effective.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Book implements Comparable<Book> {
    private static final Comparator<Book> FALLBACK_COMPARATOR = Comparator
            .comparing(Book::getISBN);

    private static <U extends Comparable<? super U>> Comparator<Book> createComparator(
            Function<Book, U> primaryExtractor) {
        Objects.requireNonNull(primaryExtractor);
        return Comparator.comparing(primaryExtractor).thenComparing(FALLBACK_COMPARATOR);
    }

    public static final Comparator<Book> BY_TITLE = createComparator(Book::getTitle);
    public static final Comparator<Book> BY_PRICE = createComparator(Book::getPrice);
    public static final Comparator<Book> BY_LANGUAGE = createComparator(Book::getLanguage);
    public static final Comparator<Book> BY_RELEASE_YEAR = createComparator(Book::getReleaseYear);

    private final String title;
    private final List<Author> authors;
    private final String ISBN;
    private final BigDecimal price;
    private final int releaseYear;
    private final String publishing;
    private final int countOfPages;
    private final String language;

    public enum Category { EDUCATIONAL, POP_SCIENCE, THRILLER }
    private final Set<Category> categories;
    private final String description;

    private Book(Builder builder) {
        this.title = builder.title;
        this.authors = builder.authors;
        this.ISBN = builder.ISBN;
        this.price = builder.price;
        this.releaseYear = builder.releaseYear;
        this.publishing = builder.publishing;
        this.countOfPages = builder.countOfPages;
        this.language = builder.language;
        this.description = builder.description;
        this.categories = builder.categories;
    }

    public static class Builder {
        private final String title;
        private final List<Author> authors = new ArrayList<>();
        private final String ISBN;
        private final BigDecimal price;
        private int releaseYear = 0;
        private String publishing = "";
        private int countOfPages = 0;
        private String language = "";
        private String description = "";
        private final EnumSet<Category> categories = EnumSet.noneOf(Category.class);

        public Builder(String title, String ISBN, BigDecimal price) {
            this.title = title;
            this.ISBN = ISBN;
            this.price = price;
        }

        public Builder addCategory(Category category) {
            categories.add(Objects.requireNonNull(category));
            return this;
        }

        public Builder releaseYear(int val) {
            releaseYear = val;
            return this;
        }

        public Builder publishing(String val) {
            publishing = val;
            return this;
        }

        public Builder countOfPages(int val) {
            countOfPages = val;
            return this;
        }

        public Builder language(String val) {
            language = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getPublishing() {
        return publishing;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", publishing='" + publishing + '\'' +
                ", countOfPages=" + countOfPages +
                ", language='" + language + '\'' +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Book b)) {
            return false;
        }

        return Objects.equals(this.ISBN, b.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                title,
                authors,
                ISBN,
                price != null ? price.doubleValue() : null,
                releaseYear,
                countOfPages,
                language,
                categories,
                description
        );
    }

    @Override
    public int compareTo(Book o) {
        return BY_TITLE.compare(this, o);
    }
}
