package ch.juventus.se.problemstofix.bird;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Linda Krüger
 * @since: 21.09.17
 */
public class BirdController {

    // private List<Bird> birds;
    private Set<Bird> birds;

    // solution
//    public BirdController () {
//        birds = new HashSet<>();
//    }

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public int getBirdsCount () {
        return birds.size();
    }

}
