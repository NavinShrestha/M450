package ch.tbz.m450.testing.tools;

import ch.tbz.m450.testing.tools.repository.StudentRepository;
import ch.tbz.m450.testing.tools.repository.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoadTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    private List<Student> students;

    @BeforeEach
    void setUp() {
        Mockito.reset(studentRepository);

        Student student1 = new Student(1L, "Marwin Kohl", "marwin@kohler.ch");
        Student student2 = new Student(2L, "Abinayan Sureskumar", "abi@gmail.com");

        students = Arrays.asList(student1, student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);
    }

    @RepeatedTest(100)
    void getStudentsLoadTest() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Marwin Kohl"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Abinayan Sureskumar"));
    }
}
