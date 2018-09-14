package com.jp.crypto.alerts;

import com.jp.crypto.alerts.data.Historical;
import com.jp.crypto.alerts.data.Info;
import com.jp.crypto.alerts.jsonObjects.Coin;
import com.jp.crypto.alerts.jsonObjects.HistoricalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class AlertsApplication implements CommandLineRunner {

	@Autowired
	private Environment env;

	public AlertsApplication(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) {
		SpringApplication.run(AlertsApplication.class, args);
	}

	@Scheduled(fixedRate = 60000)
	private void verifyData() {

		try {
			//System.out.println("AQUI -------- " + LocalDateTime.now());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run(String... arg0) {

		Info info = new Info(env);

		//Get top coins doing trading
//		List<Coin> coins =  info.getPoloniexCoins();
//
//		Historical historical = new Historical(env);
//
//		Map<String, HistoricalData> hourData = historical.getLastHour(coins);
//
//		//historical.getPump(hourData);
//
//		Map<String, HistoricalData> increment1Hour = historical.getIncrement1Hour(hourData);
//
//		increment1Hour.forEach((coin, historicalData) -> {
//
//			System.out.println(String.format("%s Start: %.9f; Close: %.9f ", coin, historicalData.getData().get(0).getOpen(),
//					historicalData.getData().get(60).getClose()));
//
//		});

		System.out.println("Price ----- " + info.getPriceBTC());

	}

}
