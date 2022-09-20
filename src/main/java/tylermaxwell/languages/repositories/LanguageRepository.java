package tylermaxwell.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.languages.models.Language;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
}
