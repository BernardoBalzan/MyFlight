package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;

import java.time.LocalDateTime;
import java.time.Duration;

public class App {

	public static void main(String[] args) {
		//System.out.println("\nMyFlight project...");

		Aeronave av1 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave av2 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave av3 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave av4 = new Aeronave("764", "Boeing 767-400", 304);
		Aeronave av5 = new Aeronave("738", "Boeing 737-800", 189);
		Aeronave av6 = new Aeronave("332", "Airbus A330-200", 380);
		Aeronave av7 = new Aeronave("320", "Airbus A320", 220);
		GerenciadorAeronaves gerAeronaves = GerenciadorAeronaves.getInstance();
		gerAeronaves.adicionar(av1);
		gerAeronaves.adicionar(av2);
		gerAeronaves.adicionar(av3);
		gerAeronaves.adicionar(av4);
		gerAeronaves.adicionar(av5);
		gerAeronaves.adicionar(av6);
		gerAeronaves.adicionar(av7);
		gerAeronaves.ordenaDescricao();
		//System.out.println(gerAeronaves.listarTodas());
		//System.out.println(gerAeronaves.buscarPorCodigo("764"));

		CiaAerea c1 = new CiaAerea("JJ", "LATAM Linhas Aereas");
		CiaAerea c2 = new CiaAerea("G3", "Gol Linhas Aereas SA");
		CiaAerea c3 = new CiaAerea("TP", "TAP Portugal");
		CiaAerea c4 = new CiaAerea("AD", "Azul Linhas Aereas");
		CiaAerea c5 = new CiaAerea("AR", "Aerolineas Argentinas");
		GerenciadorCias gerCias = GerenciadorCias.getInstance();
		gerCias.adicionar(c1);
		gerCias.adicionar(c2);
		gerCias.adicionar(c3);
		gerCias.adicionar(c4);
		gerCias.adicionar(c5);
		//System.out.println(gerCias.listarTodas());
		//System.out.println(gerCias.buscarPorNome("LATAM Linhas Aereas"));
		//System.out.println(gerCias.buscarPorCodigo("AD"));

		Aeroporto a1 = new Aeroporto("POA", "Salgado Filho Intl Apt", new Geo(-29.9939, -51.1711));
		Aeroporto a2 = new Aeroporto("GRU", "Sao Paulo Guarulhos Intl Apt", new Geo(-23.4356, -46.4731)); 
		Aeroporto a3 = new Aeroporto("LIS", "Lisbon", new Geo(38.7742, -9.1342));
		Aeroporto a4 = new Aeroporto("MIA", "Miami International Apt", new Geo(25.7933, -80.2906));
		Aeroporto a5 = new Aeroporto("GIG", "RIOgaleao - Aeroporto Internacional Tom Jobim", new Geo(-22.8089, -43.2436));
		Aeroporto a6 = new Aeroporto("AEP", "Aeroparque Internacional Jorge Newbery", new Geo(-34.5580, -58.4170));
		GerenciadorAeroportos gerAeroportos = GerenciadorAeroportos.getInstance();
		gerAeroportos.adicionar(a1);
		gerAeroportos.adicionar(a2);
		gerAeroportos.adicionar(a3);
		gerAeroportos.adicionar(a4);
		gerAeroportos.adicionar(a5);
		gerAeroportos.adicionar(a6);
		gerAeroportos.ordenaNome();
		//System.out.println(gerAeroportos.listarTodos());
		//System.out.println(gerAeroportos.buscaPorCodigo("LIS"));

		Rota r1 = new Rota(c2, a2, a1, av5);
		Rota r2 = new Rota(c2, a1, a2, av5);
		Rota r3 = new Rota(c3, a4, a3, av6);
		Rota r4 = new Rota(c1, a2, a5, av7);
		Rota r5 = new Rota(c2, a1, a5, av5);
		Rota r6 = new Rota(c5, a1, a6, av6);
		GerenciadorRotas gerRotas = GerenciadorRotas.getInstance();
		gerRotas.adicionar(r1);
		gerRotas.adicionar(r2);
		gerRotas.adicionar(r3);
		gerRotas.adicionar(r4);
		gerRotas.adicionar(r5);
		gerRotas.adicionar(r6);
		gerRotas.ordenaCias();
		//System.out.println(gerRotas.listarTodas());
		//System.out.println(gerRotas.buscarPorOrigem(a2));


		//Voo v1 = new Voo(r2, LocalDateTime.of(2016, 8, 10, 8, 0), Duration.ofMinutes(90));
		//Voo v2 = new Voo(r5, LocalDateTime.of(2016, 8, 10, 15, 0) , Duration.ofMinutes(120));
		//Voo v3 = new Voo(r6, LocalDateTime.of(2016, 8, 15, 12, 0) , Duration.ofMinutes(120));
		//GerenciadorVoos gerVoos = GerenciadorVoos.getInstance();
		//gerVoos.adicionar(v1);
		//gerVoos.adicionar(v2);
		//gerVoos.adicionar(v3);
		//v1.setStatus(Status.ATRASADO);
		//v3.setStatus(Status.CANCELADO);

		//System.out.printf("Distancia: %.4f", Geo.distancia(a1.getLocal(), a2.getLocal()));
		//av1.contar();
		//r1.contar();
		//a1.contar();









	}
}