package pl.dpotyralski.spockintroduction.rental;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovieDaoService {

    private final JpaRepository jpaRepository;

    public Movie save(Movie movie) {
        return jpaRepository.save(movie);
    }

}
