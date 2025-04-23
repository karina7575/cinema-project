package com.javaacademy.cinema;

import com.javaacademy.cinema.entity.Movie;
import com.javaacademy.cinema.entity.Session;
import com.javaacademy.cinema.repository.MovieRepository;
import com.javaacademy.cinema.repository.SessionRepository;
import com.javaacademy.cinema.repository.TicketRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(CinemaApplication.class, args);
		MovieRepository movieRepository = context.getBean(MovieRepository.class);
		SessionRepository sessionRepository = context.getBean(SessionRepository.class);

//		Movie movie = Movie.builder()
//						.movieName("Адвокат дьявола")
//						.movieDescription("Вообще хз о чем он")
//						.build();
//
//		Session session = Session.builder()
//						.movieDate(LocalDateTime.now())
//						.price(BigDecimal.valueOf(600))
//						.movie (movie)
//						.build();
//		System.out.println(sessionRepository.save(session));
//		System.out.println("___________________________________________");
//		System.out.println(sessionRepository.selectAll());
//		System.out.println("___________________________________________");
//		System.out.println(movieRepository.findById(1));
//		System.out.println("___________________________________________");
//		System.out.println(sessionRepository.findById(1));
//		System.out.println("___________________________________________");
//		Movie movie = Movie.builder()
//						.movieName("Если я останусь")
//						.movieDescription("Драма о погибшей семье")
//						.build();
//		System.out.println(movieRepository.save(movie));
		TicketRepository ticketRepository = context.getBean(TicketRepository.class);
		System.out.println(ticketRepository.findFreeTickets(1));
		ticketRepository.changeIsBuyed(1);
	}

}
