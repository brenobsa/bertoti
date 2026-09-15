package com.thehecklers.sburrestdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class SburRestDemoApplication {

	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://localhost:3306/treino_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true")
				.username("root")
				.password("") // Ajuste se a senha do seu MySQL for diferente de 'root'
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner inicializarBanco(TreinoRepository treinoRepository) {
		return args -> {
			if (treinoRepository.count() == 0) {
				Treino a = new Treino("A", "Peito e Tríceps");
				Treino b = new Treino("B", "Costas e Bíceps");
				Treino c = new Treino("C", "Pernas e Ombros");

				a.adicionarExercicio(new Exercicio("Supino Reto", 4, 12));
				b.adicionarExercicio(new Exercicio("Remada Curvada", 4, 12));
				c.adicionarExercicio(new Exercicio("Leg Press 45", 4, 12));

				treinoRepository.saveAll(List.of(a, b, c));
			}
		};
	}
}