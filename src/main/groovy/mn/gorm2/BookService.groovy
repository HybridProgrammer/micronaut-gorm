package mn.gorm2

import grails.gorm.services.Service

import javax.validation.constraints.NotBlank

@Service(Book)
interface BookService {
    int count()

    Book save(@NotBlank String title)
}