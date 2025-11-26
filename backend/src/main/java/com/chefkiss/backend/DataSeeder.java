package com.chefkiss.backend;

import com.chefkiss.backend.model.Restaurant;
import com.chefkiss.backend.model.Review;
import com.chefkiss.backend.repository.RestaurantRepository;
import com.chefkiss.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {
        if (restaurantRepository.count() == 0) {
            Restaurant r = new Restaurant();
            r.setName("La Casona Gourmet");
            r.setDescription("Alta cocina fusión con ingredientes locales.");
            r.setAddress("Av. Siempre Viva 123");
            r.setCity("Santiago");
            r.setRating(4.8);
            r.setImages(Arrays.asList("https://images.unsplash.com/photo-1555396273-367ea4eb4db5"));
            r.setFeatures(Arrays.asList("Wifi", "Estacionamiento", "Bar"));
            restaurantRepository.save(r);
        }

        if (reviewRepository.count() == 0) {
            String[] usuarios = {"Ana", "Carlos", "Beatriz", "David", "Elena", "Felipe", "Gloria", "Hugo", "Ines", "Javier"};
            for (int i = 0; i < 10; i++) {
                Review rev = new Review();
                rev.setUserName(usuarios[i]);
                rev.setRating(4 + (i % 2));
                rev.setComment("Comida increíble, me encantó el plato número " + (i+1));
                rev.setUserAvatar("👤");
                reviewRepository.save(rev);
            }
        }
    }
}