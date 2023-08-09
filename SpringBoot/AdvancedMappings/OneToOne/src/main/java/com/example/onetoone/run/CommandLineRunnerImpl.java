package com.example.onetoone.run;

import com.example.onetoone.model.entity.Instructor;
import com.example.onetoone.model.entity.InstructorDetail;
import com.example.onetoone.repository.InstructorDetailRepository;
import com.example.onetoone.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    public CommandLineRunnerImpl(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Hello World!");

        //createInstructor();

        //findInstructorById(1L);

        //deleteInstructorById(2L);

        //findInstructorDetailById(1L);

        //deleteInstructorDetailById(2L);
    }

    private void deleteInstructorDetailById(Long id) {
        Optional<InstructorDetail> instructorDetail = this.instructorDetailRepository.findById(id);

        System.out.println("Deleted instructor detail: " + instructorDetail.get());

        instructorDetail.get().getInstructor().setInstructorDetail(null);

        this.instructorDetailRepository.deleteById(id);
    }

    private void findInstructorDetailById(Long id) {
        Optional<InstructorDetail> instructorDetail = this.instructorDetailRepository.findById(id);

        if (instructorDetail.isEmpty()) {
            System.out.println("Couldn't find instructor detail with id: " + id);
            return;
        }

        System.out.println("Instructor detail with id: " + id);
        System.out.println(instructorDetail.get());
        System.out.println("Instructor only: " + instructorDetail.get().getInstructor().toString());
    }

    private void deleteInstructorById(Long id) {
        System.out.println("Deleted Instructor: " + this.instructorRepository.findById(id));
        this.instructorRepository.deleteById(id);
    }

    private void findInstructorById(Long id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);

        if (instructor.isEmpty()) {
            System.out.println("Couldn't find instructor with id: " + id);
            return;
        }

        System.out.println("Instructor with id: " + id);
        System.out.println(instructor.get());
        System.out.println("Instructor Details only:" + instructor.get().getInstructorDetail());
    }

    private void createInstructor() {
        Instructor instructor1 =
                new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail instructorDetail1 =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

        instructor1.setInstructorDetail(instructorDetail1);

        Instructor instructor2 =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail instructorDetail2 =
                new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

        instructor2.setInstructorDetail(instructorDetail2);

        this.instructorRepository.save(instructor1);
        this.instructorRepository.save(instructor2);
    }
}
