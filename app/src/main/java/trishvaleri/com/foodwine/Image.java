//refer to MainActivity for project details.
//Contributors specific for this page: stackoverflow.com

package trishvaleri.com.foodwine;

/**
 * Image.java - class to create Image objects, used in ArrayList
 * @author Trish Valeri
 */
public class Image {
    //variable
    private String poster;

    //constructor
    public Image(String poster) {
        super();
        this.poster = poster;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
