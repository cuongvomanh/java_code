import org.javatuples.Triplet;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStream {

    static class Company {

        private String id;
        private String name;
        private Integer dt;

        public Company(String id, String name, Integer dt) {
            this.id = id;
            this.name = name;
            this.dt = dt;
        }


        public Integer getDt() {
            return dt;
        }

        public void setDt(Integer dt) {
            this.dt = dt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args){
        Map<String, List<Company>> raw = new HashMap<String, List<Company>>();
        raw.put("2019", Arrays.asList(
                new Company("viettel", "ct viettel", 1),
                new Company("vnpt", "ct vnpt", 2)
        ));
        raw.put("2020", Arrays.asList(
                new Company("viettel", "ct viettel", 10),
                new Company("vnpt", "ct vnpt", 4),
                new Company("fpt", "ct fpt", 12)
        ));
        List<Triplet<String, String, Company>> data = raw.entrySet().stream().map((Map.Entry<String, List<Company>> e) ->
                    e.getValue().stream().map(company -> new Triplet<>(e.getKey(), company.getId(), company)).collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Map<String, List<Triplet<String, String, Company>>> index = data.stream()
                .collect(Collectors.groupingBy((Triplet<String, String, Company> row) -> row.getValue0() + row.getValue1()));
//        System.out.println(data);

    }
}
