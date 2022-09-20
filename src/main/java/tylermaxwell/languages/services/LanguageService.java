package tylermaxwell.languages.services;

import org.springframework.stereotype.Service;
import tylermaxwell.languages.models.Language;
import tylermaxwell.languages.repositories.LanguageRepository;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repo;


    public LanguageService(LanguageRepository repo) {
        this.repo = repo;
    }

    public List<Language> allLanguages(){return repo.findAll();}

    public void createLanguage(Language language) { repo.save(language);
    }
}
