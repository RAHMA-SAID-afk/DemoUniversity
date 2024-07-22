package universityWeb;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityService {

    private final UniversityRepositry repo;

    public UniversityService(UniversityRepositry repo) {
        this.repo = repo;
    }

    public void insertUniversity(University university){
        repo.save(university);
    }

    public void updateUniversity(University university){
        repo.save(university);
    }
    public void deleteUniversity(Long id){
        repo.deleteById(id);
    }
    public University getUniversityById(long id) {
        return repo.findById(id).orElse(null);
    }
    public List<University> getAllUniversity(){
        return repo.findAll();

    }

    public List<University> getAllUniversity(Long keyword){
        if(keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }


}
