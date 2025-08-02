package payment_system.utils;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class CsvUtil {

    public static List<String[]> lerCsv(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            CSVParser parser = new CSVParserBuilder().withSeparator(detectarDelimitador(reader)).build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
            return csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Erro ao ler CSV: " + e.getMessage());
        }
    }

    private static char detectarDelimitador(BufferedReader reader) throws IOException {
        reader.mark(1000);
        String primeiraLinha = reader.readLine();
        reader.reset();

        if (primeiraLinha == null || primeiraLinha.isBlank()) {
            throw new RuntimeException("CSV vazio ou mal formatado");
        }

        if (primeiraLinha.contains(";")) return ';';
        if (primeiraLinha.contains(",")) return ',';

        return ',';
    }
}