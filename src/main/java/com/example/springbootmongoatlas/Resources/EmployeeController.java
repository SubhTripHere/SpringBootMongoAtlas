package com.example.springbootmongoatlas.Resources;

import com.example.springbootmongoatlas.Entities.Employee;
import com.example.springbootmongoatlas.Services.EmployeeServiceI;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/employee-service/")
public class EmployeeController {

    @Autowired
    public EmployeeServiceI employeeService;

    @PostMapping(path = "/employee" )
    @SuppressWarnings("unchecked")
    public ResponseEntity<List<Employee>> saveEmployee(@RequestBody MultipartFile file) throws IOException {

        //File jsonFile = file;
        ObjectMapper mapper = new ObjectMapper();

        // Reading and converting JSON from file to List of Employee objects
        List<Employee> employees = mapper.readValue(file.getInputStream(), new TypeReference<List<Employee>>() {});

        // Printing employees to verify the output
        employees.forEach(System.out::println);

        File nfile=new File("results.json");
        // writing data to file using mapper

            mapper.writeValue(nfile,employees);


        return new ResponseEntity(employees,HttpStatus.OK);


        /*

        *******************************************************************
        ----this is when we dont knpw the pojo/structure of the json returned,
        ----also here we are having array of phonenumbers,
        ----notice how it create JSonNode for this array again to parse
        *******************************************************************

        public static void main(String[] args) {
        String jsonString = "[{\"id\":1,\"name\":\"John Doe\",\"phones\":[\"123-456-7890\",\"987-654-3210\"]},{\"id\":2,\"name\":\"Jane Smith\",\"phones\":[\"111-222-3333\"]}]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse JSON string into JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Iterate over the array elements
            for (JsonNode employeeNode : jsonNode) {
                // Extract values dynamically
                int id = employeeNode.get("id").asInt();
                String name = employeeNode.get("name").asText();
                JsonNode phonesNode = employeeNode.get("phones");
                System.out.println("Employee ID: " + id);
                System.out.println("Employee Name: " + name);
                System.out.println("Employee Phones:");
                // Iterate over the phones array
                for (JsonNode phoneNode : phonesNode) {
                    System.out.println("- " + phoneNode.asText());
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




         */
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

