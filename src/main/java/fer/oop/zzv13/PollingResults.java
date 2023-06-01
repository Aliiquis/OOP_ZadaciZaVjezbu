package fer.oop.zzv13;

import jxl.Sheet;
import jxl.Workbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PollingResults {
    private Map<PollingStation, Map<String, Integer>> mayorResults, assemblyResults;

    public PollingResults(Workbook workbook) {
        this.mayorResults = fillResults(workbook.getSheet(1));
        this.assemblyResults = fillResults(workbook.getSheet(0));
    }

    public Map<PollingStation, Map<String, Integer>> getMayorResults() {
        return mayorResults;
    }

    public Map<PollingStation, Map<String, Integer>> getAssemblyResults() {
        return assemblyResults;
    }

    private static Map<PollingStation, Map<String, Integer>> fillResults(Sheet sheet) {
        Map<PollingStation, Map<String, Integer>> toReturn = new LinkedHashMap<>();

        for (int entryIdx = 1; entryIdx < sheet.getRows(); entryIdx++) {

            int countyId = Integer.parseInt(sheet.getCell(0, entryIdx).getContents());
            String county = sheet.getCell(1, entryIdx).getContents();
            String label = sheet.getCell(2, entryIdx).getContents();
            String place = sheet.getCell(3, entryIdx).getContents();
            int id = Integer.parseInt(sheet.getCell(4, entryIdx).getContents().replaceFirst("^0+(?!$)", ""));
            String title = sheet.getCell(5, entryIdx).getContents();
            String location = sheet.getCell(6, entryIdx).getContents();
            String address = sheet.getCell(7, entryIdx).getContents();

            PollingStation ps = new PollingStation(countyId, county, label, place, id, title, location, address);
            Map<String, Integer> values = new LinkedHashMap<>();

            for (int i = 13; i < sheet.getColumns(); i++) {
                values.put(sheet.getCell(i, 0).getContents(), Integer.parseInt(sheet.getCell(i, entryIdx).getContents()));
            }

            toReturn.put(ps, values);
        }
        return toReturn;
    }
}
