package com.hongxeob.ch2;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {

	private final BankStatementParser statementParser = new BankStatementCSVParser();

	@Test
	void shouldParseOneCorrectLine() throws Exception {

		//given
		String line = "30-01-2017,-50,Tesco";
		final BankTransaction result = statementParser.parseFrom(line);

		//when
		BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		final double tolerance = 0.0d;

		//then
		assertThat(expected.getDate()).isEqualTo(result.getDate());
	}

}
